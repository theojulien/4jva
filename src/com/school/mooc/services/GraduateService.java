/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.services;

import com.school.mooc.dao.GraduateDao;
import com.school.mooc.entity.Course;
import com.school.mooc.entity.Graduate;
import com.school.mooc.entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author theo
 */
@Stateless
public class GraduateService {
    
    @EJB
    private GraduateDao graduateDao;
    
    public Graduate addGraduate(User user,Course course){
        return graduateDao.addGraduate(user, course);
    }
    
    public Graduate getGraduate(Long id){
        return graduateDao.getGraduate(id);
    }
    
    public List<Graduate> getGraduatesFromUser(User user){
        return graduateDao.getGraduatesFromUser(user);
    }
}
