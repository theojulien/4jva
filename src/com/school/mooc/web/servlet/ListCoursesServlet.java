/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.web.servlet;

import com.school.mooc.dao.CourseDao;
import com.school.mooc.services.CourseService;
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
@WebServlet(urlPatterns = "/Courses", name = "courses")
public class ListCoursesServlet extends HttpServlet{
    @EJB
    CourseService courseService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("courses", courseService.getCourses());
        req.getRequestDispatcher("/jsp/listCourses.jsp").forward(req, resp);
    }
    
}
