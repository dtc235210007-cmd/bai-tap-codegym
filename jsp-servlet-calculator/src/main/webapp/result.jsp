<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả tính toán</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .result-box { border: 1px solid #ccc; padding: 20px; width: 300px; border-radius: 5px; box-shadow: 2px 2px 12px #aaa; }
        .success { color: green; font-size: 20px; font-weight: bold;}
        .error { color: red; font-size: 18px; font-weight: bold; }
        a { display: inline-block; margin-top: 15px; text-decoration: none; color: blue; }
    </style>
</head>
<body>
    <div class="result-box">
        <h2>Kết Quả</h2>
        
        <%-- Hiển thị kết quả nếu thành công --%>
        <% if (request.getAttribute("resultMessage") != null) { %>
            <p class="success"><%= request.getAttribute("resultMessage") %></p>
        <% } %>

        <%-- Hiển thị lỗi nếu chia cho 0 --%>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
        
        <a href="index.jsp">⬅ Quay lại máy tính</a>
    </div>
</body>
</html>