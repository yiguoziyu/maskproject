package com.ljj.lettercircle.model;

public class SmsVerAuthBean {
    private String ticket;
    private String randStr;

    public SmsVerAuthBean(String ticket, String randStr) {
        this.ticket = ticket;
        this.randStr = randStr;
    }

    public String getTicket() {
        return ticket == null ? "" : ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getRandStr() {
        return randStr == null ? "" : randStr;
    }

    public void setRandStr(String randStr) {
        this.randStr = randStr;
    }
}
