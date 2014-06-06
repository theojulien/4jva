/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.entity;

import java.io.Serializable;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author theo
 */
@StaticMetamodel(User.class)
public class User_ implements Serializable {

    public static volatile SingularAttribute<User, Long> id;

    public static volatile SingularAttribute<User, String> username;

    public static volatile SingularAttribute<User, String> name;

    public static volatile SingularAttribute<User, String> firstname;

    public static volatile SingularAttribute<User, String> password;

    public static volatile SingularAttribute<User, String> email;
    
    public static volatile ListAttribute<User,Graduate> graduates;
    
    public static volatile ListAttribute<User,Course> followedCourses;
    
    public static volatile SingularAttribute<User,WebToken> webToken;

}
