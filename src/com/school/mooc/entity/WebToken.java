/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.mooc.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

/**
 *
 * @author theo
 */
@Embeddable
public class WebToken implements Serializable {

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dateExpiration;

    public WebToken() {
    }

    public WebToken(String token, Calendar dateExpiration) {
        this.token = token;
        this.dateExpiration = dateExpiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Calendar getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Calendar dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    
}
