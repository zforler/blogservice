package com.blog.entity;

public class Comment {
    private Integer id;

    private String createtime;

    private Integer articleid;

    private String author;

    private Integer commentid;

    private Boolean status;

    private String content;

    public Comment(Integer id, String createtime, Integer articleid, String author, Integer commentid, Boolean status) {
        this.id = id;
        this.createtime = createtime;
        this.articleid = articleid;
        this.author = author;
        this.commentid = commentid;
        this.status = status;
    }

    public Comment(Integer id, String createtime, Integer articleid, String author, Integer commentid, Boolean status, String content) {
        this.id = id;
        this.createtime = createtime;
        this.articleid = articleid;
        this.author = author;
        this.commentid = commentid;
        this.status = status;
        this.content = content;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}