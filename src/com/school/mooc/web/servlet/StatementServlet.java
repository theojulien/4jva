/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.web.servlet;

import com.school.mooc.entity.Question;
import com.school.mooc.entity.Statement;
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
@WebServlet(name = "StatementServlet")
public class StatementServlet extends HttpServlet {

    @EJB
    private StatementService statementService;
    private Question question;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("statement", question.getStatements());
        req.getRequestDispatcher("/jsp/quizz.jsp").forward(req, resp);
    }
}
