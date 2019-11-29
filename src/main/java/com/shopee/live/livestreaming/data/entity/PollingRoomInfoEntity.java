package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;

public class PollingRoomInfoEntity implements Serializable {
    private long duration;
    private boolean is_end;
    private int products_cnt;
    public int session_id;
    public int session_like_cnt;
    public int session_member_cnt;
    public String session_show_product;
    public String session_show_voucher;
    public int show_voucher_duration;
    public long show_voucher_timestamp;
    private int total_member_cnt;

    public String getSession_show_voucher() {
        String str = this.session_show_voucher;
        return str == null ? "" : str;
    }

    public void setSession_show_voucher(String str) {
        this.session_show_voucher = str;
    }

    public long getShow_voucher_timestamp() {
        return this.show_voucher_timestamp;
    }

    public void setShow_voucher_timestamp(long j) {
        this.show_voucher_timestamp = j;
    }

    public int getShow_voucher_duration() {
        return this.show_voucher_duration;
    }

    public void setShow_voucher_duration(int i) {
        this.show_voucher_duration = i;
    }

    public boolean is_end() {
        return this.is_end;
    }

    public void setIs_end(boolean z) {
        this.is_end = z;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public int getProducts_cnt() {
        return this.products_cnt;
    }

    public void setProducts_cnt(int i) {
        this.products_cnt = i;
    }

    public int getTotal_member_cnt() {
        return this.total_member_cnt;
    }

    public void setTotal_member_cnt(int i) {
        this.total_member_cnt = i;
    }

    public int getSession_member_cnt() {
        return this.session_member_cnt;
    }

    public void setSession_member_cnt(int i) {
        this.session_member_cnt = i;
    }

    public int getSession_like_cnt() {
        return this.session_like_cnt;
    }

    public void setSession_like_cnt(int i) {
        this.session_like_cnt = i;
    }

    public String getSession_show_product() {
        String str = this.session_show_product;
        return str == null ? "" : str;
    }

    public void setSession_show_product(String str) {
        this.session_show_product = str;
    }

    public int getSession_id() {
        return this.session_id;
    }

    public void setSession_id(int i) {
        this.session_id = i;
    }
}
