/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.dao.jpa;

import com.school.mooc.dao.StatementDao;
import com.school.mooc.entity.Course_;
import com.school.mooc.entity.Question;
import com.school.mooc.entity.Question_;
import com.school.mooc.entity.Statement;
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
public class JpaStatementDao implements StatementDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Statement getStatementDaoById(long id) {
        return em.find(Statement.class, id);
    }

}
