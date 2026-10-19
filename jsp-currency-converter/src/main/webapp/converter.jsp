<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Kết quả chuyển đổi</title>
        <style>
            body { font-family: Arial, sans-serif; display: flex; justify-content: center; margin-top: 80px; background-color: #f8fafc; }
            .box { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); width: 360px; text-align: center; }
            .success { background: #e8f5e9; padding: 15px; border-radius: 6px; margin: 15px 0; color: #27ae60; font-size: 20px; font-weight: bold; }
            .error { background: #ffebee; padding: 15px; border-radius: 6px; margin: 15px 0; color: #c0392b; }
            a { display: inline-block; padding: 8px 16px; background: #1b2a7a; color: white; text-decoration: none; border-radius: 4px; }
        </style>
    </head>
    <body>
        <div class="box">
            <h2>KẾT QUẢ</h2>
            <%
                try {
                    float rate = Float.parseFloat(request.getParameter("rate"));
                    float usd = Float.parseFloat(request.getParameter("usd"));
                    float vnd = rate * usd;
            %>
                <p>Tỉ giá: <b><%= rate %></b> VND/USD</p>
                <p>Số USD: <b>$<%= usd %></b></p>
                <div class="success">Thành tiền: <%= vnd %> VNĐ</div>
            <%
                } catch (Exception e) {
            %>
                <div class="error">Dữ liệu đầu vào không hợp lệ!</div>
            <%
                }
            %>
            <a href="index.jsp">Quay lại</a>
        </div>
    </body>
</html>