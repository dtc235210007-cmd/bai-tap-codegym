package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DiscountServlet", urlPatterns = {"/display-discount"})
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String description = request.getParameter("description");
        String priceRaw = request.getParameter("price");
        String percentRaw = request.getParameter("discount_percent");

        try (PrintWriter out = response.getWriter()) {
            try {
                double listPrice = Double.parseDouble(priceRaw);
                double discountPercent = Double.parseDouble(percentRaw);

                // Tính toán theo công thức đề bài: Discount Amount = List Price * Discount Percent * 0.01
                double discountAmount = listPrice * discountPercent * 0.01;
                double discountPrice = listPrice - discountAmount;

                DecimalFormat formatter = new DecimalFormat("#,##0.00");

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<title>Discount Result</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f1f5f9; display: flex; justify-content: center; margin-top: 80px; }");
                out.println(".result-card { background: #ffffff; width: 420px; padding: 30px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.08); }");
                out.println("h2 { color: #1e293b; text-align: center; margin-top: 0; margin-bottom: 20px; }");
                out.println(".item { display: flex; justify-content: space-between; padding: 10px 0; border-bottom: 1px solid #e2e8f0; font-size: 15px; }");
                out.println(".label { color: #64748b; font-weight: 500; }");
                out.println(".value { color: #0f172a; font-weight: 600; }");
                out.println(".highlight { color: #16a34a; font-size: 18px; }");
                out.println(".btn { display: block; text-align: center; margin-top: 25px; text-decoration: none; background: #2563eb; color: #fff; padding: 10px; border-radius: 6px; font-weight: 600; }");
                out.println(".btn:hover { background: #1d4ed8; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='result-card'>");
                out.println("<h2>Chi Tiết Chiết Khấu</h2>");
                
                out.println("<div class='item'><span class='label'>Product Description:</span><span class='value'>" + description + "</span></div>");
                out.println("<div class='item'><span class='label'>List Price:</span><span class='value'>$" + formatter.format(listPrice) + "</span></div>");
                out.println("<div class='item'><span class='label'>Discount Percent:</span><span class='value'>" + discountPercent + "%</span></div>");
                out.println("<div class='item'><span class='label'>Discount Amount:</span><span class='value' style='color: #dc2626;'>-$" + formatter.format(discountAmount) + "</span></div>");
                out.println("<div class='item' style='border-bottom: none;'><span class='label'>Discount Price:</span><span class='value highlight'>$" + formatter.format(discountPrice) + "</span></div>");
                
                out.println("<a href='index.jsp' class='btn'>Tính sản phẩm khác</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");

            } catch (NumberFormatException e) {
                out.println("<!DOCTYPE html>");
                out.println("<html><body>");
                out.println("<div style='text-align: center; margin-top: 80px; font-family: Arial, sans-serif;'>");
                out.println("<h2 style='color: #dc2626;'>Lỗi: Vui lòng nhập số hợp lệ cho giá và phần trăm!</h2>");
                out.println("<a href='index.jsp'>Quay lại</a>");
                out.println("</div>");
                out.println("</body></html>");
            }
        }
    }
}