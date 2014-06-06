/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.servlet;

import com.school.mooc.entity.User;
import com.school.mooc.entity.WebToken;
import com.school.mooc.services.UserService;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author theo
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String firstname = req.getParameter("firstname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (password.equals(confirmPassword)) {
            User newUser = new User(username, name, firstname, password, email);
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MINUTE, 15);
            WebToken webToken = new WebToken(UUID.randomUUID().toString(), c);
            newUser.setToken(webToken);
            newUser = userService.addUser(newUser);
            req.getSession().setAttribute("user", newUser);
            resp.sendRedirect(req.getContextPath() + "/Courses");

        }
    }
    
}
