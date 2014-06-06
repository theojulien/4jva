/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.services;

import com.school.mooc.entity.Graduate;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author theo
 */
@Stateless
@LocalBean
public class JMService {

    public void printGraduate(Graduate graduate) throws NamingException, JMSException {

        InitialContext ctx = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/MoocConnectionFactory");

        Destination destination = (Destination) ctx.lookup("jms/MoocQueue");

        Connection cnx = connectionFactory.createConnection();
        Session session = cnx.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageProducer producer = session.createProducer(destination);

        String txt = "Graduate : "
                + "\n Name : " + graduate.getUser().getName()
                + "\n Firstname : "+graduate.getUser().getFirstname()                
                + "\n Course : "+graduate.getCourse().getTitle()
                + "\n Date : "+graduate.getDate();
               

        TextMessage message = session.createTextMessage();
        message.setText(txt);

        producer.send(message);
        System.out.println("Sending JMS.... \n"+txt);

        cnx.close();

    }
}
