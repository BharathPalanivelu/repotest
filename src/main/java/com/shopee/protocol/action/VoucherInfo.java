package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class VoucherInfo extends Message {
    public static final Long DEFAULT_COIN_CAP = 0L;
    public static final Long DEFAULT_COIN_EARNED = 0L;
    public static final Integer DEFAULT_COIN_PERCENTAGE = 0;
    public static final Integer DEFAULT_COIN_PERCENTAGE_REAL = 0;
    public static final Long DEFAULT_CURRENT_SPEND = 0L;
    public static final Long DEFAULT_DISCOUNT_CAP = 0L;
    public static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 0;
    public static final Long DEFAULT_DISCOUNT_VALUE = 0L;
    public static final Long DEFAULT_MIN_SPEND = 0L;
    public static final Integer DEFAULT_PLATFORM_TYPE = 0;
    public static final Boolean DEFAULT_PRODUCT_LIMIT = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_REWARD_TYPE = 0;
    public static final Integer DEFAULT_SHOP_ID = 0;
    public static final Boolean DEFAULT_SINGLE_SHOP = false;
    public static final List<Long> DEFAULT_SPM_CHANNELS = Collections.emptyList();
    public static final Long DEFAULT_USED_PRICE = 0L;
    public static final Integer DEFAULT_USE_TYPE = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long coin_cap;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long coin_earned;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer coin_percentage;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer coin_percentage_real;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long current_spend;
    @ProtoField(tag = 16, type = Message.Datatype.INT64)
    public final Long discount_cap;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer discount_percentage;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long discount_value;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long min_spend;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer platform_type;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean product_limit;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer reward_type;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer shop_id;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean single_shop;
    @ProtoField(label = Message.Label.REPEATED, tag = 15, type = Message.Datatype.INT64)
    public final List<Long> spm_channels;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer use_type;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long used_price;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String voucher_code;

    public VoucherInfo(Long l, String str, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Long l3, Long l4, Integer num5, Boolean bool, Integer num6, Boolean bool2, Integer num7, List<Long> list, Long l5, Long l6, Long l7, Long l8) {
        this.promotionid = l;
        this.voucher_code = str;
        this.use_type = num;
        this.reward_type = num2;
        this.discount_value = l2;
        this.discount_percentage = num3;
        this.coin_percentage = num4;
        this.min_spend = l3;
        this.current_spend = l4;
        this.platform_type = num5;
        this.single_shop = bool;
        this.shop_id = num6;
        this.product_limit = bool2;
        this.coin_percentage_real = num7;
        this.spm_channels = immutableCopyOf(list);
        this.discount_cap = l5;
        this.coin_cap = l6;
        this.used_price = l7;
        this.coin_earned = l8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private VoucherInfo(com.shopee.protocol.action.VoucherInfo.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            java.lang.Long r2 = r0.promotionid
            java.lang.String r3 = r0.voucher_code
            java.lang.Integer r4 = r0.use_type
            java.lang.Integer r5 = r0.reward_type
            java.lang.Long r6 = r0.discount_value
            java.lang.Integer r7 = r0.discount_percentage
            java.lang.Integer r8 = r0.coin_percentage
            java.lang.Long r9 = r0.min_spend
            java.lang.Long r10 = r0.current_spend
            java.lang.Integer r11 = r0.platform_type
            java.lang.Boolean r12 = r0.single_shop
            java.lang.Integer r13 = r0.shop_id
            java.lang.Boolean r14 = r0.product_limit
            java.lang.Integer r15 = r0.coin_percentage_real
            r21 = r1
            java.util.List<java.lang.Long> r1 = r0.spm_channels
            r16 = r1
            java.lang.Long r1 = r0.discount_cap
            r17 = r1
            java.lang.Long r1 = r0.coin_cap
            r18 = r1
            java.lang.Long r1 = r0.used_price
            r19 = r1
            java.lang.Long r1 = r0.coin_earned
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.VoucherInfo.<init>(com.shopee.protocol.action.VoucherInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherInfo)) {
            return false;
        }
        VoucherInfo voucherInfo = (VoucherInfo) obj;
        if (!equals((Object) this.promotionid, (Object) voucherInfo.promotionid) || !equals((Object) this.voucher_code, (Object) voucherInfo.voucher_code) || !equals((Object) this.use_type, (Object) voucherInfo.use_type) || !equals((Object) this.reward_type, (Object) voucherInfo.reward_type) || !equals((Object) this.discount_value, (Object) voucherInfo.discount_value) || !equals((Object) this.discount_percentage, (Object) voucherInfo.discount_percentage) || !equals((Object) this.coin_percentage, (Object) voucherInfo.coin_percentage) || !equals((Object) this.min_spend, (Object) voucherInfo.min_spend) || !equals((Object) this.current_spend, (Object) voucherInfo.current_spend) || !equals((Object) this.platform_type, (Object) voucherInfo.platform_type) || !equals((Object) this.single_shop, (Object) voucherInfo.single_shop) || !equals((Object) this.shop_id, (Object) voucherInfo.shop_id) || !equals((Object) this.product_limit, (Object) voucherInfo.product_limit) || !equals((Object) this.coin_percentage_real, (Object) voucherInfo.coin_percentage_real) || !equals((List<?>) this.spm_channels, (List<?>) voucherInfo.spm_channels) || !equals((Object) this.discount_cap, (Object) voucherInfo.discount_cap) || !equals((Object) this.coin_cap, (Object) voucherInfo.coin_cap) || !equals((Object) this.used_price, (Object) voucherInfo.used_price) || !equals((Object) this.coin_earned, (Object) voucherInfo.coin_earned)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.promotionid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.voucher_code;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.use_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.reward_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.discount_value;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.discount_percentage;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.coin_percentage;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l3 = this.min_spend;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.current_spend;
        int hashCode9 = (hashCode8 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num5 = this.platform_type;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool = this.single_shop;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num6 = this.shop_id;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool2 = this.product_limit;
        int hashCode13 = (hashCode12 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num7 = this.coin_percentage_real;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 37;
        List<Long> list = this.spm_channels;
        int hashCode15 = (hashCode14 + (list != null ? list.hashCode() : 1)) * 37;
        Long l5 = this.discount_cap;
        int hashCode16 = (hashCode15 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.coin_cap;
        int hashCode17 = (hashCode16 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.used_price;
        int hashCode18 = (hashCode17 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.coin_earned;
        if (l8 != null) {
            i2 = l8.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VoucherInfo> {
        public Long coin_cap;
        public Long coin_earned;
        public Integer coin_percentage;
        public Integer coin_percentage_real;
        public Long current_spend;
        public Long discount_cap;
        public Integer discount_percentage;
        public Long discount_value;
        public Long min_spend;
        public Integer platform_type;
        public Boolean product_limit;
        public Long promotionid;
        public Integer reward_type;
        public Integer shop_id;
        public Boolean single_shop;
        public List<Long> spm_channels;
        public Integer use_type;
        public Long used_price;
        public String voucher_code;

        public Builder() {
        }

        public Builder(VoucherInfo voucherInfo) {
            super(voucherInfo);
            if (voucherInfo != null) {
                this.promotionid = voucherInfo.promotionid;
                this.voucher_code = voucherInfo.voucher_code;
                this.use_type = voucherInfo.use_type;
                this.reward_type = voucherInfo.reward_type;
                this.discount_value = voucherInfo.discount_value;
                this.discount_percentage = voucherInfo.discount_percentage;
                this.coin_percentage = voucherInfo.coin_percentage;
                this.min_spend = voucherInfo.min_spend;
                this.current_spend = voucherInfo.current_spend;
                this.platform_type = voucherInfo.platform_type;
                this.single_shop = voucherInfo.single_shop;
                this.shop_id = voucherInfo.shop_id;
                this.product_limit = voucherInfo.product_limit;
                this.coin_percentage_real = voucherInfo.coin_percentage_real;
                this.spm_channels = VoucherInfo.copyOf(voucherInfo.spm_channels);
                this.discount_cap = voucherInfo.discount_cap;
                this.coin_cap = voucherInfo.coin_cap;
                this.used_price = voucherInfo.used_price;
                this.coin_earned = voucherInfo.coin_earned;
            }
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder use_type(Integer num) {
            this.use_type = num;
            return this;
        }

        public Builder reward_type(Integer num) {
            this.reward_type = num;
            return this;
        }

        public Builder discount_value(Long l) {
            this.discount_value = l;
            return this;
        }

        public Builder discount_percentage(Integer num) {
            this.discount_percentage = num;
            return this;
        }

        public Builder coin_percentage(Integer num) {
            this.coin_percentage = num;
            return this;
        }

        public Builder min_spend(Long l) {
            this.min_spend = l;
            return this;
        }

        public Builder current_spend(Long l) {
            this.current_spend = l;
            return this;
        }

        public Builder platform_type(Integer num) {
            this.platform_type = num;
            return this;
        }

        public Builder single_shop(Boolean bool) {
            this.single_shop = bool;
            return this;
        }

        public Builder shop_id(Integer num) {
            this.shop_id = num;
            return this;
        }

        public Builder product_limit(Boolean bool) {
            this.product_limit = bool;
            return this;
        }

        public Builder coin_percentage_real(Integer num) {
            this.coin_percentage_real = num;
            return this;
        }

        public Builder spm_channels(List<Long> list) {
            this.spm_channels = checkForNulls(list);
            return this;
        }

        public Builder discount_cap(Long l) {
            this.discount_cap = l;
            return this;
        }

        public Builder coin_cap(Long l) {
            this.coin_cap = l;
            return this;
        }

        public Builder used_price(Long l) {
            this.used_price = l;
            return this;
        }

        public Builder coin_earned(Long l) {
            this.coin_earned = l;
            return this;
        }

        public VoucherInfo build() {
            return new VoucherInfo(this);
        }
    }
}
