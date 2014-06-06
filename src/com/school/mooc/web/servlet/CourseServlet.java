/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.servlet;

import com.school.mooc.entity.Course;
import com.school.mooc.entity.Graduate;
import com.school.mooc.entity.User;
import com.school.mooc.services.CourseService;
import com.school.mooc.services.GraduateService;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Spidyx
 */
@WebServlet(urlPatterns = "/Course", name = "course")
public class CourseServlet extends HttpServlet {

    @EJB
    CourseService courseService;
    
    @EJB
    GraduateService graduateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course course = courseService.getCourse(Long.valueOf(req.getParameter("id")));
        req.setAttribute("course", course);

        Object sessionUser = req.getSession().getAttribute("user");
        if (null != sessionUser) {
            User user = (User) sessionUser;
            req.setAttribute("user", user);

            Boolean contains = false;
            Iterator<Course> followedCourses = user.getFollowedCourses().iterator();
            while (followedCourses.hasNext() && !contains) {
                if (followedCourses.next().getId() == course.getId()) {
                    contains = true;
                }
            }
            req.setAttribute("followed", contains);

            contains = false;
            Iterator<Graduate> graduates = graduateService.getGraduatesFromUser(user).iterator();
            while (graduates.hasNext() && !contains) {
                if (graduates.next().getCourse().getId() == course.getId()) {
                    contains = true;
                }
            }
            req.setAttribute("graduated", contains);
        }

        req.getRequestDispatcher("/jsp/course.jsp").forward(req, resp);
    }
}
