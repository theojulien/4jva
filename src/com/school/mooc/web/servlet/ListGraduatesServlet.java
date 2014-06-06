/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.web.servlet;

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
 * @author Spidyx
 */
@WebServlet(urlPatterns = "/auth/Graduates")
public class ListGraduatesServlet extends HttpServlet{
    
    @EJB
    GraduateService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object sessionUser = req.getSession().getAttribute("user");
        if(null != sessionUser){
            User user = (User)sessionUser;
            req.setAttribute("graduates", service.getGraduatesFromUser(user));
            req.getRequestDispatcher("/jsp/listGraduates.jsp").forward(req, resp);
        }
        else
            resp.sendError(401, "You must be logged.");
    }
    
}
