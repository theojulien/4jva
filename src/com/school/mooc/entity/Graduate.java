package com.school.mooc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User: Spidyx
 */
@Entity
public class Graduate implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
