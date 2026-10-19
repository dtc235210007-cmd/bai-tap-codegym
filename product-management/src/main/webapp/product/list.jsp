<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f8fafc; }
        .header-bar { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        h1 { color: #1b2a7a; margin: 0; }
        .search-box { display: flex; gap: 8px; }
        input[type="text"] { padding: 8px 12px; border: 1px solid #ccc; border-radius: 4px; }
        table { border-collapse: collapse; width: 100%; background: white; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 6px rgba(0,0,0,0.05); }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #1b2a7a; color: white; }
        tr:hover { background-color: #f1f5f9; }
        .btn { display: inline-block; padding: 8px 16px; text-decoration: none; border-radius: 4px; font-weight: bold; font-size: 14px; border: none; cursor: pointer; }
        .btn-create { background-color: #27ae60; color: white; }
        .btn-search { background-color: #1b2a7a; color: white; }
        .btn-edit { color: #2980b9; text-decoration: none; margin-right: 10px; }
        .btn-delete { color: #c0392b; text-decoration: none; }
        .btn-view { color: #1b2a7a; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <div class="header-bar">
        <h1>Danh Sách Sản Phẩm</h1>
        <a href="${pageContext.request.contextPath}/products?action=create" class="btn btn-create">+ Thêm sản phẩm mới</a>
    </div>

    <!-- Form tìm kiếm sản phẩm theo tên -->
    <form action="${pageContext.request.contextPath}/products?action=search" method="POST" class="search-box" style="margin-bottom: 20px;">
        <input type="text" name="search" placeholder="Nhập tên sản phẩm..." value="${requestScope.searchQuery}" />
        <button type="submit" class="btn btn-search">Tìm kiếm</button>
        <a href="${pageContext.request.contextPath}/products" class="btn" style="background: #e2e8f0; color: #333;">Tất cả</a>
    </form>
    
    <table>
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên sản phẩm</th>
                <th>Giá ($)</th>
                <th>Mô tả</th>
                <th>Nhà sản xuất</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.products}" var="p" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/products?action=view&id=${p.id}" class="btn-view">${p.name}</a>
                    </td>
                    <td>${p.price}</td>
                    <td>${p.description}</td>
                    <td>${p.producer}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/products?action=edit&id=${p.id}" class="btn-edit">Sửa</a>
                        <a href="${pageContext.request.contextPath}/products?action=delete&id=${p.id}" class="btn-delete">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>