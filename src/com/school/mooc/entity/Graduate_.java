/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.entity;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author theo
 */
@StaticMetamodel(Graduate.class)
public class Graduate_ {

    public static volatile SingularAttribute<Graduate, Long> id;

    public static volatile SingularAttribute<Graduate, Date> date;

    public static volatile SingularAttribute<Graduate, User> user;

    public static volatile SingularAttribute<Graduate, Course> course;


}
