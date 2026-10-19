package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.strategy.NoteDBStrategy;
import com.codegym.strategy.NoteFileStrategy;
import com.codegym.strategy.NoteManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoteServlet", urlPatterns = {"/notes", ""})
public class NoteServlet extends HttpServlet {
    private NoteManagement noteManagement;
    private NoteDBStrategy dbStrategy;
    private NoteFileStrategy fileStrategy;

    @Override
    public void init() {
        dbStrategy = new NoteDBStrategy();
        String storagePath = getServletContext().getRealPath("/WEB-INF/notes_storage.txt");
        fileStrategy = new NoteFileStrategy(storagePath);
        noteManagement = new NoteManagement(dbStrategy);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String currentMode = (String) session.getAttribute("storageMode");
        if (currentMode == null) {
            currentMode = "db";
            session.setAttribute("storageMode", currentMode);
        }

        String switchMode = req.getParameter("switchStorage");
        if (switchMode != null) {
            currentMode = switchMode;
            session.setAttribute("storageMode", currentMode);
        }

        if ("file".equalsIgnoreCase(currentMode)) {
            noteManagement.setStrategy(fileStrategy);
        } else {
            noteManagement.setStrategy(dbStrategy);
        }

        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                req.getRequestDispatcher("/note-form.jsp").forward(req, resp);
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                noteManagement.deleteNote(id);
                resp.sendRedirect("notes");
                break;
            case "list":
            default:
                String keyword = req.getParameter("keyword");
                List<Note> notes = noteManagement.searchNotes(keyword);
                req.setAttribute("notes", notes);
                req.setAttribute("keyword", keyword);
                req.setAttribute("currentMode", currentMode);
                req.getRequestDispatcher("/note-list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int typeId = Integer.parseInt(req.getParameter("typeId"));

        noteManagement.addNote(title, content, typeId);
        resp.sendRedirect("notes");
    }
}