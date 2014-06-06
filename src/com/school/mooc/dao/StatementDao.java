/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.dao;

import com.school.mooc.entity.Question;
import com.school.mooc.entity.Statement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antoine
 */
@Local
public interface StatementDao {

    public Statement getStatementDaoById(long id);
}
