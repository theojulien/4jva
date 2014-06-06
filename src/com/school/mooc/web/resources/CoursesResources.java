/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.resources;

import com.school.mooc.entity.Course;
import com.school.mooc.entity.User;
import com.school.mooc.services.CourseService;
import com.school.mooc.services.UserService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author theo
 */
@WebService(serviceName = "CoursesResources")
public class CoursesResources {

    @EJB
    CourseService courseService;

    @EJB
    UserService userService;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "GetCourse")
    public Course getCourse(@WebParam(name = "id") Long id) {
        return courseService.getCourse(id);
    }

    @WebMethod(operationName = "GetCourses")
    public List<Course> GetCourses() {
        return courseService.getCourses();
    }

    @WebMethod(operationName = "registerToCourse")
    public void registerToCourse(@WebParam(name = "token") String token, @WebParam(name = "id") Long id) {
        User user = userService.isValidUser(token);
        if (user != null) {
            courseService.register(user, id);
        }
    }
}
