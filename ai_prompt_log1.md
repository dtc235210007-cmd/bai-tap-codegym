# Nhật Ký Tương Tác AI (Prompt Log)

### Phiên 1: Thẩm định kiến trúc Bento Box
- **Prompt:** "Khi tôi cần một bố cục mà một phần tử con (Child) phải chiếm chính xác 2 hàng và 2 cột (span 2 rows, 2 columns) đan xen với các phần tử nhỏ khác, tôi nên chọn CSS Grid hay Flexbox? Tại sao Flexbox lại chật vật với yêu cầu này?"
- **Phản hồi từ AI & Ứng dụng:** Flexbox chỉ tính toán theo 1 trục chính tại một thời điểm, muốn giả lập bảng 2 chiều phải lồng nhiều lớp flex cột/hàng (`div soup`) và fix cứng chiều cao. Quyết định: Dùng `display: grid; grid-template-columns: repeat(3, 1fr)` và `grid-column: span 2; grid-row: span 2`.

### Phiên 2: Khai thác thuộc tính `gap` thay thế cho margin hack
- **Prompt:** "Thuộc tính `gap` hoạt động thế nào trong Flexbox và Grid hiện đại? Lợi ích của nó so với việc dùng margin âm trên container và padding/margin trên từng item con là gì?"
- **Phản hồi từ AI & Ứng dụng:** `gap` phân tách trực tiếp khoảng cách giữa các phần tử con mà không tạo khoảng thừa ở mép ngoài cùng. Đã áp dụng `gap: 1rem` cho cả `.app-navbar` và `.bento-dashboard`, dẹp bỏ triệt để các class `margin: 5px` của mã cũ.

### Phiên 3: Tối ưu hàng dọc cho Pricing Card bằng Bootstrap
- **Prompt:** "Trong Bootstrap 5, khi làm 3 Card giá bằng `row` và `col-md-4`, làm thế nào để các nút bấm Call-to-Action luôn nằm thẳng hàng ở đáy dù độ dài đoạn văn bản mô tả giữa các gói là khác nhau?"
- **Phản hồi từ AI & Ứng dụng:** Sử dụng `d-flex flex-column` trên `.card-body` và gắn class `mt-auto` lên button. Nút sẽ tự động được đẩy sát đáy card nhờ cơ chế margin auto của Flexbox.