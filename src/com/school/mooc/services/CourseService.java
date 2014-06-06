/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.services;

import com.school.mooc.dao.CourseDao;
import com.school.mooc.entity.Course;
import com.school.mooc.entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author theo
 */
@Stateless
public class CourseService {

    @EJB
    private CourseDao courseDao;

    public Course getCourse(Long id) {
        return courseDao.getCourseById(id);
    }

    public List<Course> getCourses() {
        return courseDao.getCourses();
    }

    public void register(User user, long id) {
        courseDao.register(user, id);
    }
}
