/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.servlet;

import com.school.mooc.entity.Graduate;
import com.school.mooc.services.GraduateService;
import com.school.mooc.services.JMService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author theo
 */
@WebServlet(name = "PrintGraduateServlet", urlPatterns = {"/auth/graduate/print"})
public class PrintGraduateServlet extends HttpServlet {

    @EJB
    private GraduateService graduateService;

    @EJB
    private JMService jMService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Graduate graduate = (Graduate) req.getSession().getAttribute("graduate");
        try {
            jMService.printGraduate(graduate);
        } catch (NamingException | JMSException ex) {
            Logger.getLogger(PrintGraduateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.getRequestDispatcher("/jsp/sendGraduate.jsp").forward(req, resp);
    }
}
