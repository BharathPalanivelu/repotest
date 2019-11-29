package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VoucherPromotion extends Message {
    public static final Integer DEFAULT_CLAIM_START_TIME = 0;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Long DEFAULT_MIN_SPEND = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REGION = "";
    public static final Integer DEFAULT_REMAINING_CLAIM_COUNT = 0;
    public static final Integer DEFAULT_REMAINING_USE_COUNT = 0;
    public static final Integer DEFAULT_REWARD_TYPE = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SIGNATURE = "";
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STOP_DISPATCH_TIME = 0;
    public static final Integer DEFAULT_USE_TYPE = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer claim_start_time;
    @ProtoField(tag = 8)
    public final CoinCashbackVoucher coin_cashback_voucher;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 7)
    public final DiscountVoucher discount_voucher;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long min_spend;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String region;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer remaining_claim_count;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer remaining_use_count;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer reward_type;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer stop_dispatch_time;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer use_type;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String voucher_code;

    public VoucherPromotion(Long l, String str, Integer num, Integer num2, Integer num3, Integer num4, DiscountVoucher discountVoucher, CoinCashbackVoucher coinCashbackVoucher, Long l2, String str2, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String str3, Integer num10, String str4) {
        this.promotionid = l;
        this.voucher_code = str;
        this.status = num;
        this.start_time = num2;
        this.end_time = num3;
        this.reward_type = num4;
        this.discount_voucher = discountVoucher;
        this.coin_cashback_voucher = coinCashbackVoucher;
        this.min_spend = l2;
        this.description = str2;
        this.remaining_claim_count = num5;
        this.remaining_use_count = num6;
        this.shopid = num7;
        this.claim_start_time = num8;
        this.stop_dispatch_time = num9;
        this.signature = str3;
        this.use_type = num10;
        this.region = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private VoucherPromotion(com.shopee.protocol.action.VoucherPromotion.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.Long r2 = r0.promotionid
            java.lang.String r3 = r0.voucher_code
            java.lang.Integer r4 = r0.status
            java.lang.Integer r5 = r0.start_time
            java.lang.Integer r6 = r0.end_time
            java.lang.Integer r7 = r0.reward_type
            com.shopee.protocol.action.DiscountVoucher r8 = r0.discount_voucher
            com.shopee.protocol.action.CoinCashbackVoucher r9 = r0.coin_cashback_voucher
            java.lang.Long r10 = r0.min_spend
            java.lang.String r11 = r0.description
            java.lang.Integer r12 = r0.remaining_claim_count
            java.lang.Integer r13 = r0.remaining_use_count
            java.lang.Integer r14 = r0.shopid
            java.lang.Integer r15 = r0.claim_start_time
            r20 = r1
            java.lang.Integer r1 = r0.stop_dispatch_time
            r16 = r1
            java.lang.String r1 = r0.signature
            r17 = r1
            java.lang.Integer r1 = r0.use_type
            r18 = r1
            java.lang.String r1 = r0.region
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.VoucherPromotion.<init>(com.shopee.protocol.action.VoucherPromotion$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherPromotion)) {
            return false;
        }
        VoucherPromotion voucherPromotion = (VoucherPromotion) obj;
        if (!equals((Object) this.promotionid, (Object) voucherPromotion.promotionid) || !equals((Object) this.voucher_code, (Object) voucherPromotion.voucher_code) || !equals((Object) this.status, (Object) voucherPromotion.status) || !equals((Object) this.start_time, (Object) voucherPromotion.start_time) || !equals((Object) this.end_time, (Object) voucherPromotion.end_time) || !equals((Object) this.reward_type, (Object) voucherPromotion.reward_type) || !equals((Object) this.discount_voucher, (Object) voucherPromotion.discount_voucher) || !equals((Object) this.coin_cashback_voucher, (Object) voucherPromotion.coin_cashback_voucher) || !equals((Object) this.min_spend, (Object) voucherPromotion.min_spend) || !equals((Object) this.description, (Object) voucherPromotion.description) || !equals((Object) this.remaining_claim_count, (Object) voucherPromotion.remaining_claim_count) || !equals((Object) this.remaining_use_count, (Object) voucherPromotion.remaining_use_count) || !equals((Object) this.shopid, (Object) voucherPromotion.shopid) || !equals((Object) this.claim_start_time, (Object) voucherPromotion.claim_start_time) || !equals((Object) this.stop_dispatch_time, (Object) voucherPromotion.stop_dispatch_time) || !equals((Object) this.signature, (Object) voucherPromotion.signature) || !equals((Object) this.use_type, (Object) voucherPromotion.use_type) || !equals((Object) this.region, (Object) voucherPromotion.region)) {
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
        Integer num = this.status;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.start_time;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.reward_type;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        DiscountVoucher discountVoucher = this.discount_voucher;
        int hashCode7 = (hashCode6 + (discountVoucher != null ? discountVoucher.hashCode() : 0)) * 37;
        CoinCashbackVoucher coinCashbackVoucher = this.coin_cashback_voucher;
        int hashCode8 = (hashCode7 + (coinCashbackVoucher != null ? coinCashbackVoucher.hashCode() : 0)) * 37;
        Long l2 = this.min_spend;
        int hashCode9 = (hashCode8 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num5 = this.remaining_claim_count;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.remaining_use_count;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.shopid;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.claim_start_time;
        int hashCode14 = (hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.stop_dispatch_time;
        int hashCode15 = (hashCode14 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str3 = this.signature;
        int hashCode16 = (hashCode15 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num10 = this.use_type;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        String str4 = this.region;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VoucherPromotion> {
        public Integer claim_start_time;
        public CoinCashbackVoucher coin_cashback_voucher;
        public String description;
        public DiscountVoucher discount_voucher;
        public Integer end_time;
        public Long min_spend;
        public Long promotionid;
        public String region;
        public Integer remaining_claim_count;
        public Integer remaining_use_count;
        public Integer reward_type;
        public Integer shopid;
        public String signature;
        public Integer start_time;
        public Integer status;
        public Integer stop_dispatch_time;
        public Integer use_type;
        public String voucher_code;

        public Builder() {
        }

        public Builder(VoucherPromotion voucherPromotion) {
            super(voucherPromotion);
            if (voucherPromotion != null) {
                this.promotionid = voucherPromotion.promotionid;
                this.voucher_code = voucherPromotion.voucher_code;
                this.status = voucherPromotion.status;
                this.start_time = voucherPromotion.start_time;
                this.end_time = voucherPromotion.end_time;
                this.reward_type = voucherPromotion.reward_type;
                this.discount_voucher = voucherPromotion.discount_voucher;
                this.coin_cashback_voucher = voucherPromotion.coin_cashback_voucher;
                this.min_spend = voucherPromotion.min_spend;
                this.description = voucherPromotion.description;
                this.remaining_claim_count = voucherPromotion.remaining_claim_count;
                this.remaining_use_count = voucherPromotion.remaining_use_count;
                this.shopid = voucherPromotion.shopid;
                this.claim_start_time = voucherPromotion.claim_start_time;
                this.stop_dispatch_time = voucherPromotion.stop_dispatch_time;
                this.signature = voucherPromotion.signature;
                this.use_type = voucherPromotion.use_type;
                this.region = voucherPromotion.region;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder reward_type(Integer num) {
            this.reward_type = num;
            return this;
        }

        public Builder discount_voucher(DiscountVoucher discountVoucher) {
            this.discount_voucher = discountVoucher;
            return this;
        }

        public Builder coin_cashback_voucher(CoinCashbackVoucher coinCashbackVoucher) {
            this.coin_cashback_voucher = coinCashbackVoucher;
            return this;
        }

        public Builder min_spend(Long l) {
            this.min_spend = l;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder remaining_claim_count(Integer num) {
            this.remaining_claim_count = num;
            return this;
        }

        public Builder remaining_use_count(Integer num) {
            this.remaining_use_count = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder claim_start_time(Integer num) {
            this.claim_start_time = num;
            return this;
        }

        public Builder stop_dispatch_time(Integer num) {
            this.stop_dispatch_time = num;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public Builder use_type(Integer num) {
            this.use_type = num;
            return this;
        }

        public Builder region(String str) {
            this.region = str;
            return this;
        }

        public VoucherPromotion build() {
            return new VoucherPromotion(this);
        }
    }
}
