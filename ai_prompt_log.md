# Nhật Ký Tra Cứu AI (Prompt Log)

### Câu hỏi 1: Xử lý Mosaic Gallery 2D bất đối xứng
- **Prompt:** "Khi dựng thư viện ảnh 1 bên to chiếm 2 hàng và 1 bên gồm 2 ảnh nhỏ xếp chồng, giữa CSS Grid span và position absolute thì Grid giải quyết vấn đề document flow và chiều cao container như thế nào?"
- **Kết quả áp dụng:** Hiểu rõ cơ chế `span 2` của Grid giữ nguyên luồng tài liệu chuẩn, loại bỏ hoàn toàn thuộc tính `position: absolute` và lỗi đè lấn text.

### Câu hỏi 2: Kết hợp Flexbox và Bootstrap Utilities cho Author Bar
- **Prompt:** "Làm sao để dàn một hàng tác giả gồm [Avatar + Info] bên trái và [Share Buttons] bên phải thẳng hàng tuyệt đối theo trục dọc mà không dùng float hay margin căn chỉnh thủ công?"
- **Kết quả áp dụng:** Sử dụng `display: flex; justify-content: space-between; align-items: center;` kết hợp nhóm avatar + details vào một flex-item con riêng biệt.

### Câu hỏi 3: Phân chia Breakpoints Bootstrap cho danh sách 4 thẻ
- **Prompt:** "Trong Bootstrap 5, cần kết hợp các class nào để danh sách 4 card hiển thị: 4 cột trên Desktop (>=992px), 2 cột trên Tablet (>=768px) và 1 cột trên Mobile (<768px)?"
- **Kết quả áp dụng:** Áp dụng bộ class `col-12 col-md-6 col-lg-3` bên trong `<div class="row g-4">`.