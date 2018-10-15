package com.blog.entity;

public class Viewer {
    private Integer id;

    private String ip;

    private Boolean status;

    private String time;

    public Viewer(Integer id, String ip, Boolean status, String time) {
        this.id = id;
        this.ip = ip;
        this.status = status;
        this.time = time;
    }

    public Viewer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}