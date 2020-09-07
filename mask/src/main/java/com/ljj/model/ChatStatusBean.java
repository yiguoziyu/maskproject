package com.ljj.model;

/**
 * Created by 一锅子鱼 on 2018/12/21.
 */
public class ChatStatusBean {

    /**
     * can_send_image_msg : 1
     * already_record_number : 0
     * tips_message : 您和她还不熟，聊一会再试试此功能吧～
     */

    private int can_send_image_msg;
    private int already_record_number;
    private String tips_message;

    public int getCan_send_image_msg() {
        return can_send_image_msg;
    }

    public void setCan_send_image_msg(int can_send_image_msg) {
        this.can_send_image_msg = can_send_image_msg;
    }

    public int getAlready_record_number() {
        return already_record_number;
    }

    public void setAlready_record_number(int already_record_number) {
        this.already_record_number = already_record_number;
    }

    public String getTips_message() {
        return tips_message == null ? "" : tips_message;
    }

    public void setTips_message(String tips_message) {
        this.tips_message = tips_message;
    }
}
