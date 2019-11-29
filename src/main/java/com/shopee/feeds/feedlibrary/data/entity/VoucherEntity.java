package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class VoucherEntity implements Serializable {
    public static final int COIN_REWARD = 1;
    public static final int COMMON_REWARD = 0;
    private String coin_cap;
    private int coin_percentage_real;
    private String description;
    private String discount_cap;
    private int discount_percent;
    private String discount_value;
    private String end_time;
    private String min_spend;
    private String promotion_id;
    private int reward_type;
    private int shop_id;
    private String signature;
    private String voucher_code;

    public String getSignature() {
        String str = this.signature;
        return str == null ? "" : str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String getPromotion_id() {
        String str = this.promotion_id;
        return str == null ? "" : str;
    }

    public void setPromotion_id(String str) {
        this.promotion_id = str;
    }

    public String getVoucher_code() {
        String str = this.voucher_code;
        return str == null ? "" : str;
    }

    public void setVoucher_code(String str) {
        this.voucher_code = str;
    }

    public String getDescription() {
        String str = this.description;
        return str == null ? "" : str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getEnd_time() {
        String str = this.end_time;
        return str == null ? "" : str;
    }

    public void setEnd_time(String str) {
        this.end_time = str;
    }

    public String getDiscount_value() {
        String str = this.discount_value;
        return str == null ? "" : str;
    }

    public void setDiscount_value(String str) {
        this.discount_value = str;
    }

    public int getDiscount_percent() {
        return this.discount_percent;
    }

    public void setDiscount_percent(int i) {
        this.discount_percent = i;
    }

    public int getCoin_percentage_real() {
        return this.coin_percentage_real;
    }

    public void setCoin_percentage_real(int i) {
        this.coin_percentage_real = i;
    }

    public int getReward_type() {
        return this.reward_type;
    }

    public void setReward_type(int i) {
        this.reward_type = i;
    }

    public String getMin_spend() {
        String str = this.min_spend;
        return str == null ? "" : str;
    }

    public void setMin_spend(String str) {
        this.min_spend = str;
    }

    public String getDiscount_cap() {
        String str = this.discount_cap;
        return str == null ? "" : str;
    }

    public void setDiscount_cap(String str) {
        this.discount_cap = str;
    }

    public String getCoin_cap() {
        String str = this.coin_cap;
        return str == null ? "" : str;
    }

    public void setCoin_cap(String str) {
        this.coin_cap = str;
    }

    public int getShop_id() {
        return this.shop_id;
    }

    public void setShop_id(int i) {
        this.shop_id = i;
    }
}
