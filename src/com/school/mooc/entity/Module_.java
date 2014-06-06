/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Spidyx
 */
@StaticMetamodel(Module.class)
public class Module_ {

    public static volatile SingularAttribute<Module, Long> id;
    public static volatile SingularAttribute<Module, String> title;
    public static volatile SingularAttribute<Module, Integer> minute;
    public static volatile SingularAttribute<Module, String> description;
}
