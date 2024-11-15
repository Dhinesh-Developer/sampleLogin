package com.login.servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.model.loginModel;

@WebServlet("/Register")
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        loginModel model = new loginModel();
        model.setUserName("name");
        model.setPassword("password");
        model.setEmail("email");

        int result = model.register();
        if (result == 0) {
            resp.sendRedirect("/LoginMODEL/failure.jsp");
        } else {
            resp.sendRedirect("/LoginMODEL/success.jsp");
        }

        ArrayList<loginModel> users = model.getUserFromRegister();
        for (loginModel user : users) {
            System.out.println("User: " + user.getUserName() + ", Email: " + user.getEmail());
        }
    }
}
