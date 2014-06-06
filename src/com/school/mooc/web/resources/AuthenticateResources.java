/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.web.resources;

import com.school.mooc.entity.User;
import com.school.mooc.entity.WebToken;
import com.school.mooc.services.UserService;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author theo
 */
@WebService(serviceName = "AuthenticateResources")
public class AuthenticateResources {

    @EJB
    UserService userService;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "Authenticate")
    public String authenticate(@WebParam(name = "Username") String username, @WebParam(name = "Password") String password) {
        User user = userService.getUserByUsername(username, password);
        if (user == null) {
            return "Username ou mot de passe invalide(s)";
        }
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MINUTE, 15);
        WebToken webToken = new WebToken(UUID.randomUUID().toString(), c);
        user.setToken(webToken);
        user = userService.updateUser(user);

        return "Authentifié => token : " + webToken.getToken();
    }
}
