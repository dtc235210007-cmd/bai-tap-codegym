private void insertUser(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String country = request.getParameter("country");

    // Đọc danh sách checkbox permissions
    String[] permissionsStr = request.getParameterValues("permissions");
    int[] permissions = null;
    if (permissionsStr != null) {
        permissions = new int[permissionsStr.length];
        for (int i = 0; i < permissionsStr.length; i++) {
            permissions[i] = Integer.parseInt(permissionsStr[i]);
        }
    }

    User newUser = new User(name, email, country);

    // Thực thi Transaction
    userDAO.addUserTransaction(newUser, permissions);

    response.sendRedirect("users");
}