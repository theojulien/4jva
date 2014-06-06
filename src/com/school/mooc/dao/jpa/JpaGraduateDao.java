/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.dao.jpa;

import com.school.mooc.dao.GraduateDao;
import com.school.mooc.entity.Course;
import com.school.mooc.entity.Graduate;
import com.school.mooc.entity.Graduate_;
import com.school.mooc.entity.User;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author theo
 */
@Stateless
public class JpaGraduateDao implements GraduateDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Graduate addGraduate(User user, Course course) {
        Graduate graduate = new Graduate();
        graduate.setUser(user);
        graduate.setCourse(course);
        graduate.setDate(new Date());
        em.persist(graduate);
        return graduate;
    }

    @Override
    public Graduate getGraduate(Long id) {
        return em.find(Graduate.class,Long.parseLong(id.toString()));
    }

    @Override
    public List<Graduate> getGraduatesFromUser(User user) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Graduate> cq = cb.createQuery(Graduate.class);
        Root<Graduate> graduates = cq.from(Graduate.class);
        cq.where(cb.equal(graduates.get(Graduate_.user), user));
        return em.createQuery(cq).getResultList();
    }

}
