package com.ljj.lettercircle.model;

public class DynamicVideoBean {
    private String cover_url;
    private String video_url;

    public String getCover_url() {
        return cover_url == null ? "" : cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getVideo_url() {
        return video_url == null ? "" : video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}
