/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.dao;

import com.school.mooc.entity.User;
import javax.ejb.Local;

/**
 *
 * @author theo
 */
@Local
public interface UserDao {

    public User getUserByUsername(String login, String password);

    public String getHashPassword(String password);

    public User addUser(User user);

    public User getUserByUsername(String username);

    public User updateUser(User user);

    public User getUserById(Long id);

    public User isValidUser(String token);

    public User getUserById(String token, Long id);

}
