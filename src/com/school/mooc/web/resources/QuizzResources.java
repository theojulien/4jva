/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.resources;

import com.school.mooc.entity.Course;
import com.school.mooc.entity.Graduate;
import com.school.mooc.entity.User;
import com.school.mooc.services.CourseService;
import com.school.mooc.services.GraduateService;
import com.school.mooc.services.UserService;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author theo
 */
@WebService(serviceName = "QuizzResources")
public class QuizzResources {

    @EJB
    GraduateService graduateService;

    @EJB
    UserService userService;

    @EJB
    CourseService courseService;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "QuizzPassed")
    public Graduate addGraduate(@WebParam(name = "token") String token, @WebParam(name = "idCourse") Long idCourse) {
        User user = userService.isValidUser(token);
        if (user != null) {
            Course course = courseService.getCourse(idCourse);
            return graduateService.addGraduate(user, course);
        }
        return null;
    }
}
