# Phân Tích Refactor: Tác Hại Của Position Absolute & Sức Mạnh CSS Grid

Việc lạm dụng `position: absolute` cho bố cục Mosaic Gallery đã phá vỡ hoàn toàn Normal Document Flow. Thẻ cha bị rút sạch chiều cao thực tế (collapse to 0), buộc lập trình viên phải "hardcode" chiều cao tĩnh (`height: 400px`). Khi màn hình co về kích thước Mobile, ảnh không thể co giãn mà đè bẹp lên nhau và phủ lấp nội dung văn bản bên dưới.

**CSS Grid là giải pháp cứu cánh tối ưu:**
1. **Kiểm soát không gian 2D độc lập:** Grid quản lý đồng thời cả hàng và cột (`grid-template-columns: 2fr 1fr`), tạo lưới mosaic bất đối xứng với `grid-row: span 2` mà không cần tính toán thủ công từng pixel toạ độ `top/left`.
2. **Bảo toàn chiều cao DOM tự nhiên:** Grid container tự động phình to theo kích thước con, bảo vệ tính toàn vẹn của các đoạn văn bản liền kề.
3. **Responsive linh hoạt:** Chỉ cần một dòng media query chuyển sang `grid-template-columns: 1fr`, toàn bộ layout tự động xếp chồng hoàn hảo trên Mobile.