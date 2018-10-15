package com.blog.entity;

public class Label {
    private Integer id;

    private String append;

    public Label(Integer id, String append) {
        this.id = id;
        this.append = append;
    }

    public Label() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppend() {
        return append;
    }

    public void setAppend(String append) {
        this.append = append == null ? null : append.trim();
    }
}