/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.services;

import com.school.mooc.dao.UserDao;
import com.school.mooc.entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author theo
 */
@Stateless
public class UserService {

    @EJB
    private UserDao userDao;

    public User getUserByUsername(String login, String password) {
        return userDao.getUserByUsername(login, password);
    }

    public String getHashPassword(String password) {
        return userDao.getHashPassword(password);
    }

    public User addUser(User user) {
        return userDao.addUser(user);
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public User isValidUser(String token) {
        return userDao.isValidUser(token);
    }

    public User getUser(String token, Long id) {
        return userDao.getUserById(token,id);
    }
}
