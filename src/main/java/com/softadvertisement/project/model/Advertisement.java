package com.softadvertisement.project.model;

import java.time.LocalDate;

public class Advertisement {

    private long id;
    private String title;
    private LocalDate createdAt;
    private String description;
    private User user;

    public Advertisement(){}

    public Advertisement(String title,String description){
        this.title = title;
        this.description = description;
    }
    public Advertisement(long id, String title,String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Advertisement(long id, String title,LocalDate createdAt, String description){
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
