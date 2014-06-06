/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.dao;

import com.school.mooc.entity.Course;
import com.school.mooc.entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Spidyx
 */
@Local
public interface CourseDao {
    public Course getCourseById(long id);
    public List<Course> getCourses();
    public void register(User user, long id);
}
