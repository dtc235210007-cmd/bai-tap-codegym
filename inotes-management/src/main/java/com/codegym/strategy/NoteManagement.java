package com.codegym.strategy;

import com.codegym.model.Note;
import java.util.List;

public class NoteManagement {
    private NoteStrategy strategy;

    public NoteManagement(NoteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NoteStrategy strategy) {
        this.strategy = strategy;
    }

    public NoteStrategy getStrategy() {
        return this.strategy;
    }

    public void addNote(String title, String content, int typeId) {
        Note note = new Note(0, title, content, typeId);
        strategy.save(note);
    }

    public void updateNote(int id, String title, String content, int typeId) {
        Note note = new Note(id, title, content, typeId);
        strategy.save(note);
    }

    public void deleteNote(int id) {
        strategy.delete(id);
    }

    public List<Note> getAllNotes() {
        return strategy.findAll();
    }

    public List<Note> searchNotes(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return strategy.findAll();
        }
        return strategy.search(keyword.trim());
    }
}