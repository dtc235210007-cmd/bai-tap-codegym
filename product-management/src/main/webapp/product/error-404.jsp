<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Không tìm thấy sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 80px; background-color: #f8fafc; }
        h1 { color: #c0392b; font-size: 40px; }
        a { text-decoration: none; color: #1b2a7a; font-weight: bold; }
    </style>
</head>
<body>
    <h1>404 - Sản phẩm không tồn tại!</h1>
    <p>Sản phẩm bạn đang tìm kiếm không tồn tại hoặc đã bị xóa.</p>
    <a href="${pageContext.request.contextPath}/products">⬅ Quay lại danh sách sản phẩm</a>
</body>
</html>