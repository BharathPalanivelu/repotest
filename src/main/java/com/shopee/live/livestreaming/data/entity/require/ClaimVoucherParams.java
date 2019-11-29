package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class ClaimVoucherParams implements Serializable {
    private long promotion_id;
    private int session_id;
    private String signature;
    private String voucher_code;

    public int getSession_id() {
        return this.session_id;
    }

    public void setSession_id(int i) {
        this.session_id = i;
    }

    public long getPromotion_id() {
        return this.promotion_id;
    }

    public void setPromotion_id(long j) {
        this.promotion_id = j;
    }

    public String getVoucher_code() {
        String str = this.voucher_code;
        return str == null ? "" : str;
    }

    public void setVoucher_code(String str) {
        this.voucher_code = str;
    }

    public String getSignature() {
        String str = this.signature;
        return str == null ? "" : str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }
}
