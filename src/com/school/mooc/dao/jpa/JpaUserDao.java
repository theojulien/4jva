/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.dao.jpa;

import com.school.mooc.dao.UserDao;
import com.school.mooc.entity.User;
import com.school.mooc.entity.User_;
import com.school.mooc.entity.WebToken;
import com.school.mooc.entity.WebToken_;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author theo
 */
@Stateless
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUserByUsername(String login, String password) {

        User user = getUserByUsername(login);

        if (null!= user && user.getPassword().equals(getHashPassword(password))) {
            return user;
        }
        return null;

    }

    @Override
    public String getHashPassword(String password) {
        try {

            byte[] bytesOfMessage = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashpass = md.digest(bytesOfMessage);

            return new String(hashpass);

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(JpaUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        user.setPassword(getHashPassword(user.getPassword()));
        em.persist(user);
        return user;
    }

    @Override
    public User getUserByUsername(String login) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        cq.where(cb.like(user.get(User_.username), login));
        TypedQuery<User> q = em.createQuery(cq);
        List<User> users = q.getResultList();

        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User updateUser(User user) {
        em.merge(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        User user = em.find(User.class, id);
        return user;
    }
    
     public User getUserById(String token,Long id) {
        User user = em.find(User.class, id);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        if(user.getToken().getDateExpiration().after(c)&&user.getToken().getToken().equals(token)){
            return user;
        }
        return null;
    }

    @Override
    public User isValidUser(String token) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        Join<User,WebToken> userToken = user.join(User_.webToken );
        cq.where(cb.like(userToken.get(WebToken_.token), token));
        TypedQuery<User> q = em.createQuery(cq);
        List<User> users = q.getResultList();

        if (users.isEmpty()) {
            return null;
        }
        
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        if(users.get(0).getToken().getDateExpiration().after(c)){
            return users.get(0);
        }
        return null; 
    }

}
