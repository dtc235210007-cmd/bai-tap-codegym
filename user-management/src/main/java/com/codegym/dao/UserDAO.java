// Thêm 2 hàm này vào bên trong class UserDAO

@Override
public User getUserById(int id) {
    User user = null;
    String query = "{CALL get_user_by_id(?)}";

    try (Connection connection = getConnection();
         CallableStatement callableStatement = connection.prepareCall(query)) {
        
        callableStatement.setInt(1, id);
        ResultSet rs = callableStatement.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            user = new User(id, name, email, country);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}

@Override
public void insertUserStore(User user) throws SQLException {
    String query = "{CALL insert_user(?, ?, ?)}";

    try (Connection connection = getConnection();
         CallableStatement callableStatement = connection.prepareCall(query)) {
        
        callableStatement.setString(1, user.getName());
        callableStatement.setString(2, user.getEmail());
        callableStatement.setString(3, user.getCountry());
        callableStatement.executeUpdate();
    }
}