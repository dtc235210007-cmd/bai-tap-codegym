package com.codegym.strategy;

import com.codegym.model.Note;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NoteFileStrategy implements NoteStrategy {
    private final String filePath;

    public NoteFileStrategy(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized List<Note> readAllFromFile() {
        List<Note> notes = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return notes;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\\|", 4);
                if (parts.length >= 4) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String content = parts[2].replace("\\n", "\n");
                    int typeId = Integer.parseInt(parts[3]);
                    Note n = new Note(id, title, content, typeId);
                    n.setTypeName(resolveTypeName(typeId));
                    notes.add(n);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notes;
    }

    private synchronized void writeAllToFile(List<Note> notes) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, false), StandardCharsets.UTF_8))) {
            for (Note n : notes) {
                String sanitizedContent = n.getContent() == null ? "" : n.getContent().replace("\r\n", "\\n").replace("\n", "\\n");
                String line = String.format("%d|%s|%s|%d", n.getId(), n.getTitle(), sanitizedContent, n.getTypeId());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String resolveTypeName(int typeId) {
        switch (typeId) {
            case 1: return "Cá nhân";
            case 2: return "Công việc";
            case 3: return "Học tập";
            default: return "Khác";
        }
    }

    @Override
    public synchronized void save(Note note) {
        List<Note> notes = readAllFromFile();
        if (note.getId() > 0) {
            for (int i = 0; i < notes.size(); i++) {
                if (notes.get(i).getId() == note.getId()) {
                    notes.set(i, note);
                    writeAllToFile(notes);
                    return;
                }
            }
        } else {
            int maxId = notes.stream().mapToInt(Note::getId).max().orElse(0);
            note.setId(maxId + 1);
            notes.add(0, note); // Cho ghi chú mới lên đầu
            writeAllToFile(notes);
        }
    }

    @Override
    public synchronized void delete(int id) {
        List<Note> notes = readAllFromFile();
        notes.removeIf(n -> n.getId() == id);
        writeAllToFile(notes);
    }

    @Override
    public List<Note> findAll() {
        return readAllFromFile();
    }

    @Override
    public List<Note> search(String keyword) {
        List<Note> notes = readAllFromFile();
        String query = keyword.toLowerCase();
        List<Note> filtered = new ArrayList<>();
        for (Note n : notes) {
            if ((n.getTitle() != null && n.getTitle().toLowerCase().contains(query)) ||
                (n.getContent() != null && n.getContent().toLowerCase().contains(query))) {
                filtered.add(n);
            }
        }
        return filtered;
    }
}