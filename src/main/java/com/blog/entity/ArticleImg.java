package com.blog.entity;

public class ArticleImg {
    private Integer id;

    private Integer articleid;

    private String createtime;

    private String url;

    public ArticleImg(Integer id, Integer articleid, String createtime, String url) {
        this.id = id;
        this.articleid = articleid;
        this.createtime = createtime;
        this.url = url;
    }

    public ArticleImg() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}