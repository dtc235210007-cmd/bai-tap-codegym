package com.codegym.strategy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // Thay đổi thông tin user/password phù hợp với MySQL của bạn
    private static final String URL = "jdbc:mysql://localhost:3306/inotes_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}