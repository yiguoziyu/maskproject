package com.ljj.lettercircle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShareExtra implements Serializable {
    private String poster;
    private List<ShareQrcodeItem> qrcode;
    private List<ShareTextItem> text;

    public ShareExtra() {
    }

    public List<ShareQrcodeItem> getQrcode() {
        if (qrcode == null) {
            return new ArrayList<>();
        }
        return qrcode;
    }

    public void setQrcode(List<ShareQrcodeItem> qrcode) {
        this.qrcode = qrcode;
    }

    public List<ShareTextItem> getText() {
        if (text == null) {
            return new ArrayList<>();
        }
        return text;
    }

    public void setText(List<ShareTextItem> text) {
        this.text = text;
    }

    public String getPoster() {
        return poster == null ? "" : poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    public class ShareQrcodeItem implements Serializable {
        private String value;
        private int x;
        private int y;
        private int w;
        private int h;

        public String getValue() {
            return value == null ? "" : value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
    }

    public class ShareTextItem implements Serializable{
        private String value;
        private int x;
        private int y;
        private int font_size;
        private String color;

        public String getValue() {
            return value == null ? "" : value;
        }

        public void setValue(String value) {
            this.value = value;
        }


        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getFont_size() {
            return font_size;
        }

        public void setFont_size(int font_size) {
            this.font_size = font_size;
        }

        public String getColor() {
            return color == null ? "" : color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
