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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.getUserByUsername(username, password);
        if (user != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.MINUTE, 15);
            WebToken webToken = new WebToken(UUID.randomUUID().toString(),c);
            user.setToken(webToken);
            user = userService.updateUser(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath()+"/Courses");
        } else {
            req.setAttribute("error", true);
            doGet(req, resp);
        }
    }
}
