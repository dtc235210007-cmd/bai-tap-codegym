@Override
public void addUserTransaction(User user, int[] permissionIds) throws SQLException {
    Connection connection = null;
    PreparedStatement pstmtUser = null;
    PreparedStatement pstmtPermission = null;
    ResultSet rs = null;

    try {
        connection = getConnection();
        
        // 1. Tắt chế độ tự động lưu để mở Transaction
        connection.setAutoCommit(false);

        // 2. Thêm User mới và cấu hình lấy ID tự sinh
        String insertUserSql = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
        pstmtUser = connection.prepareStatement(insertUserSql, Statement.RETURN_GENERATED_KEYS);
        pstmtUser.setString(1, user.getName());
        pstmtUser.setString(2, user.getEmail());
        pstmtUser.setString(3, user.getCountry());
        pstmtUser.executeUpdate();

        // 3. Lấy ID vừa tạo
        rs = pstmtUser.getGeneratedKeys();
        int userId = 0;
        if (rs.next()) {
            userId = rs.getInt(1);
        }

        // 4. Thêm danh sách quyền vào bảng user_permission
        if (permissionIds != null && permissionIds.length > 0) {
            String insertPermSql = "INSERT INTO user_permission (user_id, permission_id) VALUES (?, ?)";
            pstmtPermission = connection.prepareStatement(insertPermSql);

            for (int permId : permissionIds) {
                pstmtPermission.setInt(1, userId);
                pstmtPermission.setInt(2, permId);
                pstmtPermission.executeUpdate();
            }
        }

        // 5. Cả 2 bước thành công -> Lưu vĩnh viễn
        connection.commit();

    } catch (SQLException e) {
        // 6. Có lỗi -> Hủy bỏ toàn bộ thao tác dở dang
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        e.printStackTrace();
    } finally {
        // 7. Giải phóng tài nguyên và trả lại trạng thái kết nối
        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (pstmtUser != null) try { pstmtUser.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (pstmtPermission != null) try { pstmtPermission.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}