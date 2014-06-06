/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.dao;

import com.school.mooc.entity.Question;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antoine
 */
@Local
public interface QuestionDao {
    public Question getQuestionDaoById(long id);
    public List<Question> getQuestion();
    public List<Question> getQuestionsByCourseId(long id);
}

