package com.school.mooc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Column;

/**
 * User: Spidyx
 */
@Entity
public class Module implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private int minute;
    @Column(nullable = false)
    private String description;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
