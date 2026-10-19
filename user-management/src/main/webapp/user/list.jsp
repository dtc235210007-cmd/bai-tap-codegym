<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý User</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f8fafc; }
        h2 { color: #1b2a7a; text-align: center; }
        .toolbar { width: 80%; margin: 0 auto 15px auto; display: flex; justify-content: space-between; align-items: center; }
        .search-form { display: flex; gap: 8px; }
        input[type="text"] { padding: 8px 12px; border: 1px solid #ccc; border-radius: 4px; }
        table { width: 80%; margin: 0 auto; border-collapse: collapse; background: white; box-shadow: 0 4px 6px rgba(0,0,0,0.05); }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #1b2a7a; color: white; }
        tr:hover { background-color: #f1f5f9; }
        .btn { padding: 8px 12px; text-decoration: none; border-radius: 4px; color: white; font-weight: bold; font-size: 14px; border: none; cursor: pointer; }
        .btn-add { background-color: #27ae60; }
        .btn-sort { background-color: #8e44ad; }
        .btn-search { background-color: #1b2a7a; }
        .btn-reset { background-color: #95a5a6; }
        .btn-edit { background-color: #2980b9; margin-right: 5px; }
        .btn-delete { background-color: #c0392b; }
        .no-result { text-align: center; color: #c0392b; font-weight: bold; padding: 20px; }
    </style>
</head>
<body>
    <h2>Danh Sách Người Dùng (Users)</h2>

    <div class="toolbar">
        <div>
            <a href="${pageContext.request.contextPath}/users?action=create" class="btn btn-add">+ Thêm mới User</a>
            <a href="${pageContext.request.contextPath}/users?action=sort" class="btn btn-sort">Sắp xếp theo tên</a>
        </div>

        <!-- Form tìm kiếm theo Country -->
        <form action="${pageContext.request.contextPath}/users?action=search" method="post" class="search-form">
            <input type="text" name="country" placeholder="Nhập quốc gia cần tìm..." value="${requestScope.searchCountry}" />
            <button type="submit" class="btn btn-search">Tìm kiếm</button>
            <a href="${pageContext.request.contextPath}/users" class="btn btn-reset">Xem tất cả</a>
        </form>
    </div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên User</th>
                <th>Email</th>
                <th>Quốc gia</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty requestScope.listUser}">
                    <c:forEach var="user" items="${requestScope.listUser}">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.name}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.country}" /></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/users?action=edit&id=${user.id}" class="btn btn-edit">Sửa</a>
                                <a href="${pageContext.request.contextPath}/users?action=delete&id=${user.id}" class="btn btn-delete">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="5" class="no-result">Không tìm thấy người dùng nào!</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</body>
</html>