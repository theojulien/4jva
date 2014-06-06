/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.dao.jpa;

import com.school.mooc.dao.QuestionDao;
import com.school.mooc.entity.Course_;
import com.school.mooc.entity.Question;
import com.school.mooc.entity.Question_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Antoine
 */
@Stateless
public class JpaQuestionDao implements QuestionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Question getQuestionDaoById(long id) {
        return em.find(Question.class, id);
    }
  
    @Override
    public List<Question> getQuestion() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Question> query = builder.createQuery(Question.class);
        query.from(Question.class);
        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Question> getQuestionsByCourseId(long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Question> cq = cb.createQuery(Question.class);
        Root<Question> question = cq.from(Question.class);
        cq.where(cb.equal(question.get(Question_.course).get(Course_.id), id));
        TypedQuery<Question> q = em.createQuery(cq);
        return q.getResultList();
    }
}
