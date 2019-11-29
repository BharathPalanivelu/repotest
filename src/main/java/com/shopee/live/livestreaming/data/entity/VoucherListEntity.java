package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class VoucherListEntity implements Serializable {
    private ArrayList<VoucherEntity> shop_vouchers;
    private ArrayList<VoucherEntity> shopee_vouchers;
    private int show_voucher_duration;

    public int getShow_voucher_duration() {
        return this.show_voucher_duration;
    }

    public void setShow_voucher_duration(int i) {
        this.show_voucher_duration = i;
    }

    public ArrayList<VoucherEntity> getShop_vouchers() {
        ArrayList<VoucherEntity> arrayList = this.shop_vouchers;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setShop_vouchers(ArrayList<VoucherEntity> arrayList) {
        this.shop_vouchers = arrayList;
    }

    public ArrayList<VoucherEntity> getShopee_vouchers() {
        ArrayList<VoucherEntity> arrayList = this.shopee_vouchers;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setShopee_vouchers(ArrayList<VoucherEntity> arrayList) {
        this.shopee_vouchers = arrayList;
    }
}
