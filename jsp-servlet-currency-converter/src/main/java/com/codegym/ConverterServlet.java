package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ConverterServlet", urlPatterns = {"/convert"})
public class ConverterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            try {
                // Nhận tham số từ form
                float rate = Float.parseFloat(request.getParameter("rate"));
                float usd = Float.parseFloat(request.getParameter("usd"));
                
                // Tính toán
                float vnd = rate * usd;
                
                // Định dạng hiển thị số cho đẹp mắt
                DecimalFormat formatter = new DecimalFormat("#,###.##");
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head><title>Kết quả chuyển đổi</title></head>");
                out.println("<body style='font-family: Arial, sans-serif; text-align: center; margin-top: 100px; background-color: #f8fafc;'>");
                out.println("<div style='background: white; max-width: 400px; margin: auto; padding: 30px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1);'>");
                out.println("<h2 style='color: #1b2a7a;'>KẾT QUẢ CHUYỂN ĐỔI</h2>");
                out.println("<p style='font-size: 16px; color: #555;'>Tỉ giá: <strong>" + formatter.format(rate) + " VND/USD</strong></p>");
                out.println("<p style='font-size: 16px; color: #555;'>Số tiền USD: <strong>$" + formatter.format(usd) + "</strong></p>");
                out.println("<h3 style='color: #27ae60; font-size: 22px; margin: 20px 0;'>Thành tiền: " + formatter.format(vnd) + " VNĐ</h3>");
                out.println("<a href='index.jsp' style='display: inline-block; text-decoration: none; padding: 10px 20px; background-color: #1b2a7a; color: white; border-radius: 4px; font-weight: bold;'>Quay lại</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                
            } catch (NumberFormatException e) {
                out.println("<!DOCTYPE html>");
                out.println("<html><body style='font-family: Arial, sans-serif; text-align: center; margin-top: 100px;'>");
                out.println("<h2 style='color: #dc3545;'>Lỗi: Vui lòng nhập số hợp lệ!</h2>");
                out.println("<a href='index.jsp'>Quay lại</a>");
                out.println("</body></html>");
            }
        }
    }
}