package com.ljj.lettercircle.model;

import com.ljj.lannotation.Persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Persistence
public class InviteBean implements Serializable {
    private List<String> banner_list;
    private String invite_num;
    private String invite_amount;
    private String invite_rule;
    private List<InviteRankingBean> invite_ranking_list;
    private List<InviteBroasrBean> last_hundred_income;

    public List<String> getBanner_list() {
        if (banner_list == null) {
            return new ArrayList<>();
        }
        return banner_list;
    }

    public void setBanner_list(List<String> banner_list) {
        this.banner_list = banner_list;
    }

    public String getInvite_num() {
        return invite_num == null ? "" : invite_num;
    }

    public void setInvite_num(String invite_num) {
        this.invite_num = invite_num;
    }

    public String getInvite_amount() {
        return invite_amount == null ? "" : invite_amount;
    }

    public void setInvite_amount(String invite_amount) {
        this.invite_amount = invite_amount;
    }

    public String getInvite_rule() {
        return invite_rule == null ? "" : invite_rule;
    }

    public void setInvite_rule(String invite_rule) {
        this.invite_rule = invite_rule;
    }

    public List<InviteRankingBean> getInvite_ranking_list() {
        if (invite_ranking_list == null) {
            return new ArrayList<>();
        }
        return invite_ranking_list;
    }

    public void setInvite_ranking_list(List<InviteRankingBean> invite_ranking_list) {
        this.invite_ranking_list = invite_ranking_list;
    }

    public List<InviteBroasrBean> getLast_hundred_income() {
        if (last_hundred_income == null) {
            return new ArrayList<>();
        }
        return last_hundred_income;
    }

    public void setLast_hundred_income(List<InviteBroasrBean> last_hundred_income) {
        this.last_hundred_income = last_hundred_income;
    }

    public class InviteRankingBean implements Serializable{
        private String amount;
        private String user_id;
        private String nick_name;
        private String avatar;

        public String getAmount() {
            return amount == null ? "" : amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getUser_id() {
            return user_id == null ? "" : user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getNick_name() {
            return nick_name == null ? "" : nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getAvatar() {
            return avatar == null ? "" : avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
    public class InviteBroasrBean implements Serializable{
        private String user_id;
        private String nick_name;
        private String amount;

        public String getUser_id() {
            return user_id == null ? "" : user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getNick_name() {
            return nick_name == null ? "" : nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getAmount() {
            return amount == null ? "" : amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}
