/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.entity;

import java.util.List;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author theo
 */
@StaticMetamodel(Question.class)
public class Question_ {
    public static volatile SingularAttribute<Question,Long> id;

    public static volatile SingularAttribute<Question,String> subject;

    public static volatile ListAttribute<Question, Statement> statements;
    
    public static volatile SingularAttribute<Question, Course> course;
}
