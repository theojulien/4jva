/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.resources;

import com.school.mooc.entity.Graduate;
import com.school.mooc.entity.User;
import com.school.mooc.services.GraduateService;
import com.school.mooc.services.JMService;
import com.school.mooc.services.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.NamingException;

/**
 *
 * @author theo
 */
@WebService(serviceName = "GraduateResources")
public class GraduateResources {

    @EJB
    GraduateService graduateService;

    @EJB
    JMService jMService;
    
    @EJB
    UserService userService;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "getGraduate")
    public Graduate getGraduate(@WebParam(name = "token") String token, @WebParam(name = "id") Long id) {
        User user = userService.isValidUser(token);
        if (user != null) {
            Graduate graduate = graduateService.getGraduate(id);
            try {
                jMService.printGraduate(graduate);
            } catch (NamingException | JMSException ex) {
                Logger.getLogger(GraduateResources.class.getName()).log(Level.SEVERE, null, ex);
            }
            return graduate;
        }
        return null;
    }
}
