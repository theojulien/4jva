package com.school.mooc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * User: Spidyx
 */
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "course_id", nullable = false)
    private List<Module> modules;
    
    public int getTotalDuration(){
        int duration = 0;
        for(Module module : this.modules){
            duration += module.getMinute();
        }
        return duration;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
