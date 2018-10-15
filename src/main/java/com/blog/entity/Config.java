package com.blog.entity;

public class Config {
    private Integer id;

    private Boolean reviewswitch;

    public Config(Integer id, Boolean reviewswitch) {
        this.id = id;
        this.reviewswitch = reviewswitch;
    }

    public Config() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getReviewswitch() {
        return reviewswitch;
    }

    public void setReviewswitch(Boolean reviewswitch) {
        this.reviewswitch = reviewswitch;
    }
}