package com.ljj.lettercircle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShareBean implements Serializable {
    private String share_url;
    private String share_title;
    private String share_content;
    private String share_tip;
    private List<ShareExtra> extra;

    public String getShare_url() {
        return share_url == null ? "" : share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getShare_title() {
        return share_title == null ? "" : share_title;
    }

    public void setShare_title(String share_title) {
        this.share_title = share_title;
    }

    public String getShare_content() {
        return share_content == null ? "" : share_content;
    }

    public void setShare_content(String share_content) {
        this.share_content = share_content;
    }

    public String getShare_tip() {
        return share_tip == null ? "" : share_tip;
    }

    public void setShare_tip(String share_tip) {
        this.share_tip = share_tip;
    }

    public List<ShareExtra> getExtra() {
        if (extra == null) {
            return new ArrayList<>();
        }
        return extra;
    }

    public void setExtra(List<ShareExtra> extra) {
        this.extra = extra;
    }




}
