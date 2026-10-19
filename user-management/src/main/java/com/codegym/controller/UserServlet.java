private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));

    // Gọi phương thức dùng Stored Procedure
    User existingUser = userDAO.getUserById(id); 

    RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
    request.setAttribute("user", existingUser);
    dispatcher.forward(request, response);
}