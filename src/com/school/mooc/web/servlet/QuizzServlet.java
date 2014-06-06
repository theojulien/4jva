/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.servlet;

import com.school.mooc.entity.Question;
import com.school.mooc.entity.Statement;
import com.school.mooc.services.CourseService;
import com.school.mooc.services.QuestionService;
import com.school.mooc.services.StatementService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antoine
 */
@WebServlet(name = "QuizzServlet", urlPatterns = {"/auth/quizz"})
public class QuizzServlet extends HttpServlet {
    
    @EJB
    private QuestionService questionService;
    
    @EJB
    private CourseService courseService;
    
    private Long courseId;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int resultat = 0;
        List<Question> questions = questionService.getQuestionsByCourseId(courseId);
        for (Question q : questions) {
            boolean isAlreadyFalse = false;
            for (Statement s : q.getStatements()) {
                boolean etatCheckbox = req.getParameter(s.getId() + "") != null;
                boolean goodAnswer = s.isGoodAnswer();
                
                if (goodAnswer != etatCheckbox || isAlreadyFalse) {
                    isAlreadyFalse = true;
                }
            }
            if (!isAlreadyFalse) {
                resultat = resultat + 1;
            }
        }
        
        resp.sendRedirect(req.getContextPath() + "/auth/winQuizz?resultat=" + resultat * 100 / questions.size());
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courseId = Long.parseLong(req.getParameter("courseId"));
        req.getSession().setAttribute("course", courseService.getCourse(courseId));
        List<Question> questions = questionService.getQuestionsByCourseId(courseId);
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("/jsp/quizz.jsp").forward(req, resp);
    }
}
