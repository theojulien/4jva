/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.services;

import com.school.mooc.dao.StatementDao;
import com.school.mooc.entity.Question;
import com.school.mooc.entity.Statement;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Antoine
 */
@Stateless
public class StatementService {

    @EJB
    private StatementDao dao;

    public Statement getQuestionDaoById(Long id) {
        return dao.getStatementDaoById(id);
    }

}
