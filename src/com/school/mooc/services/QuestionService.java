/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.services;

import com.school.mooc.dao.QuestionDao;
import com.school.mooc.entity.Question;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Antoine
 */
@Stateless
public class QuestionService {

    @EJB
    private QuestionDao dao;

    public Question getQuestionDaoById(Long id) {
        return dao.getQuestionDaoById(id);
    }

    public List<Question> getQuestion() {
        return dao.getQuestion();
    }
    
    public List<Question> getQuestionsByCourseId(long id){
        return dao.getQuestionsByCourseId(id);
    }
}
