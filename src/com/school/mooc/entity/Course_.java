/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.mooc.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Spidyx
 */
@StaticMetamodel(Course.class)
public class Course_ {
    public static volatile SingularAttribute<Course, Long> id;
    public static volatile SingularAttribute<Course, String> title;
    public static volatile SingularAttribute<Course, String> description;
    public static volatile ListAttribute<User,Module> modules;
}
