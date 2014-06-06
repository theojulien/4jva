/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.moc.printer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 *
 * @author theo
 */
public class Printer {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     * @throws javax.jms.JMSException
     */
    public static void main(String[] args) throws NamingException, JMSException {

        System.out.println("Hello JMS Receiver");

        Context ctx;
        ctx = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/MoocConnectionFactory");

        Destination destination = (Destination) ctx.lookup("jms/MoocQueue");
        Connection connection = null;

        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {

                @Override
                public void onMessage(Message message) {
                    TextMessage receivedMessage = (TextMessage) message;
                    try {
                        System.out.println(receivedMessage.getText());
                    } catch (JMSException ex) {
                        Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            connection.start();

            System.out.println("After start");

        } catch (JMSException e) {
        }

    }

}
