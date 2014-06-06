/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.servlet;

import com.school.mooc.entity.Course;
import com.school.mooc.entity.Graduate;
import com.school.mooc.entity.User;
import com.school.mooc.services.GraduateService;
import java.io.IOException;
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
@WebServlet(name = "WinServlet", urlPatterns = {"/auth/winQuizz"})
public class WinServlet extends HttpServlet {

    @EJB
    GraduateService graduateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long resultat = Long.parseLong(req.getParameter("resultat"));
        req.setAttribute("resultat", resultat);
        if (resultat >= 50) {
            User user = (User) req.getSession().getAttribute("user");
            Course course = (Course) req.getSession().getAttribute("course");
            Graduate graduate = graduateService.addGraduate(user, course);
            req.getSession().setAttribute("graduate", graduate);
            req.getRequestDispatcher("/jsp/winQuizz.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/jsp/lostQuizz.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Graduate graduate = (Graduate) req.getSession().getAttribute("graduate");
        resp.sendRedirect(req.getContextPath()+"/auth/graduate/print");
    }
    
}
