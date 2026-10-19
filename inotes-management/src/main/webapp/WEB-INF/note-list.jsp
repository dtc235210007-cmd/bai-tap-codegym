<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>iNotes Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="text-primary fw-bold">iNotes Dashboard</h2>
        <div>
            <span class="me-2 badge bg-secondary fs-6">Tầng lưu trữ: <strong>${currentMode.toUpperCase()}</strong></span>
            <a href="notes?switchStorage=db" class="btn btn-outline-primary btn-sm ${currentMode == 'db' ? 'active' : ''}">MySQL DB</a>
            <a href="notes?switchStorage=file" class="btn btn-outline-success btn-sm ${currentMode == 'file' ? 'active' : ''}">File TXT</a>
        </div>
    </div>

    <div class="row g-2 mb-3">
        <div class="col-md-9">
            <form action="notes" method="get" class="d-flex">
                <input type="text" name="keyword" value="${keyword}" class="form-control me-2" placeholder="Tìm kiếm theo tiêu đề hoặc nội dung...">
                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            </form>
        </div>
        <div class="col-md-3 text-end">
            <a href="notes?action=new" class="btn btn-success w-100">+ Thêm Mới</a>
        </div>
    </div>

    <div class="card shadow-sm border-0">
        <div class="table-responsive">
            <table class="table table-hover table-striped align-middle mb-0">
                <thead class="table-dark">
                    <tr>
                        <th style="width: 5%">#</th>
                        <th style="width: 45%">Tiêu đề & Nội dung</th>
                        <th style="width: 25%">Phân loại</th>
                        <th style="width: 25%" class="text-center">Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty notes}">
                            <tr>
                                <td colspan="4" class="text-center text-muted py-4">Chưa có ghi chú nào trong chế độ lưu trữ này.</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="note" items="${notes}">
                                <tr>
                                    <td>${note.id}</td>
                                    <td>
                                        <div class="fw-bold">${note.title}</div>
                                        <div class="text-secondary small text-truncate" style="max-width: 450px;">${note.content}</div>
                                    </td>
                                    <td><span class="badge bg-info text-dark">${note.typeName}</span></td>
                                    <td class="text-center">
                                        <a href="notes?action=delete&id=${note.id}" 
                                           class="btn btn-outline-danger btn-sm"
                                           onclick="return confirm('Bạn có chắc chắn muốn xóa ghi chú này không?')">Xóa</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>