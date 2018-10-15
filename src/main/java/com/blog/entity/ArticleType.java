package com.blog.entity;

public class ArticleType {
    private Integer id;

    private String append;

    public ArticleType(Integer id, String append) {
        this.id = id;
        this.append = append;
    }

    public ArticleType() {
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