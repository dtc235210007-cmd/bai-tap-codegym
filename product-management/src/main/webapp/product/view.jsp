<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f8fafc; }
        .detail-container { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); max-width: 500px; margin: auto; }
        h2 { color: #1b2a7a; text-align: center; border-bottom: 2px solid #1b2a7a; padding-bottom: 10px; }
        table { width: 100%; margin-top: 15px; border-collapse: collapse; }
        td { padding: 10px; font-size: 16px; border-bottom: 1px solid #eee; }
        .label { font-weight: bold; color: #555; width: 35%; }
        .link-back { display: block; text-align: center; margin-top: 25px; color: #1b2a7a; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <div class="detail-container">
        <h2>Chi Tiết Sản Phẩm</h2>
        <table>
            <tr><td class="label">Mã ID:</td><td>${requestScope.product.id}</td></tr>
            <tr><td class="label">Tên sản phẩm:</td><td>${requestScope.product.name}</td></tr>
            <tr><td class="label">Giá bán:</td><td>$${requestScope.product.price}</td></tr>
            <tr><td class="label">Mô tả:</td><td>${requestScope.product.description}</td></tr>
            <tr><td class="label">Nhà sản xuất:</td><td>${requestScope.product.producer}</td></tr>
        </table>
        <a href="${pageContext.request.contextPath}/products" class="link-back">Quay lại danh sách</a>
    </div>
</body>
</html>