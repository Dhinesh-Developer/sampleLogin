package com.login.model;

import java.sql.*;
import java.util.ArrayList;

public class loginModel {

    static String url = "jdbc:mysql://localhost:3306/login";
    static String user = "root";
    static String pwd = "root@dk";

    private static PreparedStatement pstmt;
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet resultset;

    private static final String INSERT = "INSERT INTO user (userName, password, email) VALUES (?, ?, ?)";
    private static final String SELECT = "SELECT * FROM user";

    private String userName;
    private String password;
    private String email;

    public loginModel(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public loginModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int register() {
        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
            pstmt = connection.prepareStatement(INSERT);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            result = pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return result;
    }

    public ArrayList<loginModel> getUserFromRegister() {
        ArrayList<loginModel> userList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
            stmt = connection.createStatement();
            resultset = stmt.executeQuery(SELECT);
            while (resultset.next()) {
                userList.add(new loginModel(resultset.getString("userName"), resultset.getString("password"), resultset.getString("email")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return userList;
    }

    private void closeResources() {
        try {
            if (resultset != null) resultset.close();
            if (pstmt != null) pstmt.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
