package com.blog.entity;

public class Article {
    private Integer id;

    private String title;

    private String createtime;

    private String updatetime;

    private Byte type;

    private Integer viewcount;

    private String author;

    private String upvotecount;

    private Boolean status;

    private Boolean reviewswitch;

    private String keyword;

    private String content;


    public Article(Integer id, String title, String createtime, String updatetime, Byte type, Integer viewcount, String author, String upvotecount, Boolean status, Boolean reviewswitch, String keyword) {
        this.id = id;
        this.title = title;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.type = type;
        this.viewcount = viewcount;
        this.author = author;
        this.upvotecount = upvotecount;
        this.status = status;
        this.reviewswitch = reviewswitch;
        this.keyword = keyword;
    }

    public Article(Integer id, String title, String createtime, String updatetime, Byte type, Integer viewcount, String author, String upvotecount, Boolean status, Boolean reviewswitch, String keyword, String content) {
        this.id = id;
        this.title = title;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.type = type;
        this.viewcount = viewcount;
        this.author = author;
        this.upvotecount = upvotecount;
        this.status = status;
        this.reviewswitch = reviewswitch;
        this.keyword = keyword;
        this.content = content;
    }

    public Article() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getUpvotecount() {
        return upvotecount;
    }

    public void setUpvotecount(String upvotecount) {
        this.upvotecount = upvotecount == null ? null : upvotecount.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getReviewswitch() {
        return reviewswitch;
    }

    public void setReviewswitch(Boolean reviewswitch) {
        this.reviewswitch = reviewswitch;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}