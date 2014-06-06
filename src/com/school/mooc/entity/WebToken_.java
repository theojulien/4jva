/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.entity;

import java.util.Calendar;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author theo
 */

@StaticMetamodel(WebToken.class)
public class WebToken_ {

    public static volatile SingularAttribute<WebToken, String> token;

    public static volatile SingularAttribute<WebToken, Calendar> dateExpiration;
}
