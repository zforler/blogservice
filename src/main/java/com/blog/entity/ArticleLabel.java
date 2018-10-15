package com.blog.entity;

public class ArticleLabel {
    private Integer id;

    private Integer articleid;

    private Integer labelid;

    public ArticleLabel(Integer id, Integer articleid, Integer labelid) {
        this.id = id;
        this.articleid = articleid;
        this.labelid = labelid;
    }

    public ArticleLabel() {
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

    public Integer getLabelid() {
        return labelid;
    }

    public void setLabelid(Integer labelid) {
        this.labelid = labelid;
    }
}