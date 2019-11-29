package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class ShowVoucerParams implements Serializable {
    private int session_id;
    private String voucher;

    public int getSession_id() {
        return this.session_id;
    }

    public void setSession_id(int i) {
        this.session_id = i;
    }

    public String getVoucher() {
        String str = this.voucher;
        return str == null ? "" : str;
    }

    public void setVoucher(String str) {
        this.voucher = str;
    }
}
