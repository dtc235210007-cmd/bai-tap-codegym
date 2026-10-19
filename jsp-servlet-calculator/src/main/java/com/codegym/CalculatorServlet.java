package com.codegym;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        try {
            // Lấy tham số từ form
            float firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
            float secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
            char operator = request.getParameter("operator").charAt(0);
            
            // Gọi logic tính toán
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            
            // Đưa kết quả vào request để hiển thị trên JSP
            String output = firstOperand + " " + operator + " " + secondOperand + " = " + result;
            request.setAttribute("resultMessage", output);
            
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Vui lòng nhập số hợp lệ.");
        } catch (RuntimeException e) {
            request.setAttribute("errorMessage", "Lỗi: " + e.getMessage());
        }
        
        // Điều hướng sang trang hiển thị kết quả
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}