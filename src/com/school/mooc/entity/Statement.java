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
public class Statement implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private boolean isGoodAnswer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isGoodAnswer() {
        return isGoodAnswer;
    }

    public void setGoodAnswer(boolean isGoodAnswer) {
        this.isGoodAnswer = isGoodAnswer;
    }
}
