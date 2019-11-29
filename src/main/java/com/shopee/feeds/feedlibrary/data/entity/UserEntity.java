package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private String email;
    private boolean email_verified;
    private FeedAccount feed_account_info;
    private boolean is_seller;
    private boolean need_convert_phone;
    private String portrait;
    private String spc_ec;
    private int status;
    private String username;

    public class FeedAccount implements Serializable {
        private boolean can_post_feed;
        private boolean is_kol;

        public FeedAccount() {
        }
    }

    public String getUsername() {
        String str = this.username;
        return str == null ? "" : str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public boolean is_seller() {
        return this.is_seller;
    }

    public void setIs_seller(boolean z) {
        this.is_seller = z;
    }

    public String getSpc_ec() {
        String str = this.spc_ec;
        return str == null ? "" : str;
    }

    public void setSpc_ec(String str) {
        this.spc_ec = str;
    }

    public boolean isEmail_verified() {
        return this.email_verified;
    }

    public void setEmail_verified(boolean z) {
        this.email_verified = z;
    }

    public FeedAccount getFeed_account_info() {
        return this.feed_account_info;
    }

    public void setFeed_account_info(FeedAccount feedAccount) {
        this.feed_account_info = feedAccount;
    }

    public String getPortrait() {
        String str = this.portrait;
        return str == null ? "" : str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public boolean isNeed_convert_phone() {
        return this.need_convert_phone;
    }

    public void setNeed_convert_phone(boolean z) {
        this.need_convert_phone = z;
    }

    public String getEmail() {
        String str = this.email;
        return str == null ? "" : str;
    }

    public void setEmail(String str) {
        this.email = str;
    }
}
