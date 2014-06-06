/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.dao.jpa;

import com.school.mooc.dao.CourseDao;
import com.school.mooc.entity.Course;
import com.school.mooc.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Spidyx
 */
@Stateless
public class JpaCourseDao implements CourseDao{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Course getCourseById(long id) {
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> getCourses() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        query.from(Course.class);
        return em.createQuery(query).getResultList();
    }    

    @Override
    public void register(User user, long id) {
        Course course = em.find(Course.class, id);
        user.getFollowedCourses().add(course);
        em.merge(user);
    }
}
