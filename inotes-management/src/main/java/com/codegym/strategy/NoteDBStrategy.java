package com.codegym.strategy;

import com.codegym.model.Note;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDBStrategy implements NoteStrategy {

    @Override
    public void save(Note note) {
        if (note.getId() > 0) {
            String sql = "UPDATE notes SET title = ?, content = ?, type_id = ? WHERE id = ?";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, note.getTitle());
                ps.setString(2, note.getContent());
                ps.setInt(3, note.getTypeId());
                ps.setInt(4, note.getId());
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String sql = "INSERT INTO notes (title, content, type_id) VALUES (?, ?, ?)";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, note.getTitle());
                ps.setString(2, note.getContent());
                ps.setInt(3, note.getTypeId());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    note.setId(rs.getInt(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM notes WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Note> findAll() {
        List<Note> list = new ArrayList<>();
        String sql = "SELECT n.id, n.title, n.content, n.type_id, t.name AS type_name " +
                     "FROM notes n LEFT JOIN note_type t ON n.type_id = t.id ORDER BY n.id DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Note n = new Note(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getInt("type_id"));
                n.setTypeName(rs.getString("type_name"));
                list.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Note> search(String keyword) {
        List<Note> list = new ArrayList<>();
        String sql = "SELECT n.id, n.title, n.content, n.type_id, t.name AS type_name " +
                     "FROM notes n LEFT JOIN note_type t ON n.type_id = t.id " +
                     "WHERE n.title LIKE ? OR n.content LIKE ? ORDER BY n.id DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String queryPattern = "%" + keyword + "%";
            ps.setString(1, queryPattern);
            ps.setString(2, queryPattern);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Note n = new Note(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getInt("type_id"));
                    n.setTypeName(rs.getString("type_name"));
                    list.add(n);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}