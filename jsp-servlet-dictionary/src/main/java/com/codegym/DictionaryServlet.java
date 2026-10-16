package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DictionaryServlet", urlPatterns = {"/translate"})
public class DictionaryServlet extends HttpServlet {

    private final Map<String, String> dictionary = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // Nạp sẵn danh mục từ vựng
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển sách");
        dictionary.put("computer", "Máy tính");
        dictionary.put("student", "Sinh viên");
        dictionary.put("teacher", "Giáo viên");
        dictionary.put("school", "Trường học");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String searchWord = request.getParameter("word");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Kết quả tra cứu</title></head>");
            out.println("<body style='font-family: Arial, sans-serif; text-align: center; margin-top: 100px; background-color: #f8fafc;'>");
            out.println("<div style='background: white; max-width: 400px; margin: auto; padding: 30px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1);'>");
            
            if (searchWord != null && !searchWord.trim().isEmpty()) {
                String normalizedWord = searchWord.trim().toLowerCase();
                String result = dictionary.get(normalizedWord);
                
                if (result != null) {
                    out.println("<h2 style='color: #1b2a7a; margin-top: 0;'>Từ khóa: " + searchWord + "</h2>");
                    out.println("<h3 style='color: #27ae60; font-size: 22px; margin: 20px 0;'>Nghĩa tiếng Việt: " + result + "</h3>");
                } else {
                    out.println("<h2 style='color: #dc3545; margin-top: 0;'>Không tìm thấy</h2>");
                    out.println("<p style='font-size: 16px; color: #555;'>Không tìm thấy từ: <strong>" + searchWord + "</strong> trong hệ thống.</p>");
                }
            } else {
                out.println("<h2 style='color: #fd7e14;'>Vui lòng nhập từ khóa hợp lệ!</h2>");
            }
            
            out.println("<a href='index.jsp' style='display: inline-block; margin-top: 15px; text-decoration: none; padding: 10px 20px; background-color: #1b2a7a; color: white; border-radius: 4px; font-weight: bold;'>Quay lại</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}