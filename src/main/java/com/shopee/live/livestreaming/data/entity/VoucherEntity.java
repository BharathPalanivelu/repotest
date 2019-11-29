package com.shopee.live.livestreaming.data.entity;

import android.text.TextUtils;
import java.io.Serializable;

public class VoucherEntity implements Serializable {
    public static final int COIN_REWARD = 1;
    public static final int COMMON_REWARD = 0;
    public static final int FREE_SHIP = 2;
    public static final int USER_TYPE_PRIVATE = 0;
    public static final int USER_TYPE_PUBLIC = 1;
    private String coin_cap = "";
    private int coin_percentage_real = 0;
    private String description = "";
    private String discount_cap = "";
    private int discount_percentage = 0;
    private String discount_value = "";
    private long end_time = 0;
    private String extra_voucher = "";
    private String min_spend = "";
    private long promotion_id = 0;
    private int reward_type = 0;
    private int shop_id = 0;
    private String signature = "";
    private int use_type = 0;
    private String voucher_code = "";

    public static int getCoinReward() {
        return 1;
    }

    public static int getCommonReward() {
        return 0;
    }

    public String getSignature() {
        String str = this.signature;
        return str == null ? "" : str;
    }

    public void setSignature(String str) {
        this.signature = str;
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

    public String getDescription() {
        String str = this.description;
        return str == null ? "" : str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public long getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(long j) {
        this.end_time = j;
    }

    public int getDiscount_percentage() {
        return this.discount_percentage;
    }

    public void setDiscount_percentage(int i) {
        this.discount_percentage = i;
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

    public int getShop_id() {
        return this.shop_id;
    }

    public void setShop_id(int i) {
        this.shop_id = i;
    }

    public String getDiscount_value() {
        String str = this.discount_value;
        return str == null ? "" : str;
    }

    public void setDiscount_value(String str) {
        this.discount_value = str;
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

    public int getUse_type() {
        return this.use_type;
    }

    public void setUse_type(int i) {
        this.use_type = i;
    }

    public String getExtra_voucher() {
        return this.extra_voucher;
    }

    public void setExtra_voucher(String str) {
        this.extra_voucher = str;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherEntity)) {
            return false;
        }
        VoucherEntity voucherEntity = (VoucherEntity) obj;
        if (TextUtils.isEmpty(voucherEntity.getVoucher_code()) || TextUtils.isEmpty(this.voucher_code) || voucherEntity.getPromotion_id() != this.promotion_id || !voucherEntity.getVoucher_code().equals(this.voucher_code)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.promotion_id;
        return ((527 + ((int) (j ^ (j >>> 32)))) * 31) + this.voucher_code.hashCode();
    }
}
