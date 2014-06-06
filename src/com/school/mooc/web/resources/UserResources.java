/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.resources;

import com.school.mooc.entity.User;
import com.school.mooc.services.UserService;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author theo
 */
@WebService(serviceName = "UserResources")
public class UserResources {

    @EJB
    UserService userService;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "token") String token, @WebParam(name = "id") Long id) {
        return userService.isValidUser(token);
        /*
        User user = userService.isValidUser(token);
        if (user != null) {par c
            return userService.getUser(token, id);
        } else {
            System.out.println("Impossible de récupérer le user.");
            return null;
        }
                */
    }
}
