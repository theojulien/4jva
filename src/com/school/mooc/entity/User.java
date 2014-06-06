/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author theo
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Course> followedCourses;

    @Embedded
    @LazyCollection(LazyCollectionOption.FALSE)
    private WebToken webToken;

    public WebToken getToken() {
        return webToken;
    }

    public void setToken(WebToken token) {
        this.webToken = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Course> getFollowedCourses() {
        return followedCourses;
    }

    public void setFollowedCourses(List<Course> followedCourses) {
        this.followedCourses = followedCourses;
    }

    public User() {
    }

    public User(String username, String name, String firstname, String password, String email) {
        this.username = username;
        this.name = name;
        this.firstname = firstname;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", name=" + name + ", firstname=" + firstname + ", password=" + password + ", email=" + email + '}';
    }

}
