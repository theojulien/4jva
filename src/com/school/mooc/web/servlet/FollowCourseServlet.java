/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.servlet;

import com.school.mooc.entity.User;
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
@WebServlet(name = "FollowCourse", urlPatterns = "/auth/follow")
public class FollowCourseServlet extends HttpServlet {

    @EJB
    private CourseService courseService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long courseId = Long.parseLong(req.getParameter("courseId"));
        User user = (User) req.getSession().getAttribute("user");

        courseService.register(user, courseId);
        resp.sendRedirect(req.getContextPath() + "/Course" + courseId);
    }

}
