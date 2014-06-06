/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.dao;

import com.school.mooc.entity.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author theo
 */
@Local
public interface GraduateDao {
    
    public Graduate addGraduate(User user, Course course);
    
    public Graduate getGraduate(Long id);
    
    public List<Graduate> getGraduatesFromUser(User user);
}
