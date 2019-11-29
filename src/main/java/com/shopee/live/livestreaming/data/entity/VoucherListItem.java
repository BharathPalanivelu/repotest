package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;

public class VoucherListItem implements Serializable {
    public static final int VIEW_TYPE_LINE = 3;
    public static final int VIEW_TYPE_TITLE = 1;
    public static final int VIEW_TYPE_VOUCHER = 2;
    private String title;
    private int type;
    private VoucherEntity voucherEntity;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public VoucherEntity getVoucherEntity() {
        return this.voucherEntity;
    }

    public void setVoucherEntity(VoucherEntity voucherEntity2) {
        this.voucherEntity = voucherEntity2;
    }

    public String getTitle() {
        String str = this.title;
        return str == null ? "" : str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean isVoucher() {
        return this.type == 2;
    }

    public boolean isTitle() {
        return this.type == 1;
    }

    public boolean isLine() {
        return this.type == 3;
    }
}
