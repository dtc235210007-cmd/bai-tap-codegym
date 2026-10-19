<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Mới Ghi Chú - iNotes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5" style="max-width: 600px;">
    <div class="card shadow-sm border-0">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Thêm Mới Ghi Chú</h4>
        </div>
        <div class="card-body p-4">
            <form action="notes" method="post">
                <div class="mb-3">
                    <label class="form-label fw-bold">Tiêu đề:</label>
                    <input type="text" name="title" class="form-control" placeholder="Nhập tiêu đề ghi chú..." required>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Phân loại:</label>
                    <select name="typeId" class="form-select">
                        <option value="1">Cá nhân</option>
                        <option value="2">Công việc</option>
                        <option value="3">Học tập</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Nội dung:</label>
                    <textarea name="content" class="form-control" rows="5" placeholder="Nhập nội dung chi tiết..."></textarea>
                </div>

                <div class="d-flex justify-content-end gap-2">
                    <a href="notes" class="btn btn-secondary">Hủy bỏ</a>
                    <button type="submit" class="btn btn-success">Lưu Ghi Chú</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>