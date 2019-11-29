package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RefundExtInfo extends Message {
    public static final Long DEFAULT_AMOUNT_BEFORE_DISCOUNT = 0L;
    public static final Integer DEFAULT_BATCHID = 0;
    public static final Integer DEFAULT_BIN_TYPE = 0;
    public static final String DEFAULT_CHECKOUT_SN = "";
    public static final Integer DEFAULT_CREATED_TIME = 0;
    public static final Integer DEFAULT_DAYS_BANK = 0;
    public static final Integer DEFAULT_DAYS_SHOPEE = 0;
    public static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 0;
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final Integer DEFAULT_PAID_TIME = 0;
    public static final Long DEFAULT_PARCELID = 0L;
    public static final Integer DEFAULT_PENDING_TIME = 0;
    public static final Integer DEFAULT_REFUND_DAYS_MAX = 0;
    public static final Integer DEFAULT_REFUND_DAYS_MIN = 0;
    public static final Boolean DEFAULT_REFUND_TO_SELLER = false;
    public static final Long DEFAULT_SPM_TRANSACTION_ID = 0L;
    public static final Integer DEFAULT_VERIFIED_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long amount_before_discount;
    @ProtoField(tag = 1)
    public final BankAccountInfo bank_account;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer batchid;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer bin_type;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String checkout_sn;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer created_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer days_bank;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer days_shopee;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer discount_percentage;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer paid_time;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long parcelid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer pending_time;
    @ProtoField(tag = 12)
    public final PromotionInfo promotion_info;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer refund_days_max;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer refund_days_min;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean refund_to_seller;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long spm_transaction_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer verified_time;

    public RefundExtInfo(BankAccountInfo bankAccountInfo, Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Long l, Integer num8, PromotionInfo promotionInfo, Integer num9, Integer num10, Integer num11, Boolean bool, Boolean bool2, Long l2, Long l3) {
        this.bank_account = bankAccountInfo;
        this.batchid = num;
        this.checkout_sn = str;
        this.created_time = num2;
        this.verified_time = num3;
        this.pending_time = num4;
        this.paid_time = num5;
        this.days_shopee = num6;
        this.days_bank = num7;
        this.amount_before_discount = l;
        this.discount_percentage = num8;
        this.promotion_info = promotionInfo;
        this.refund_days_min = num9;
        this.refund_days_max = num10;
        this.bin_type = num11;
        this.refund_to_seller = bool;
        this.is_group_buy = bool2;
        this.spm_transaction_id = l2;
        this.parcelid = l3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private RefundExtInfo(com.shopee.protocol.shop.RefundExtInfo.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            com.shopee.protocol.shop.BankAccountInfo r2 = r0.bank_account
            java.lang.Integer r3 = r0.batchid
            java.lang.String r4 = r0.checkout_sn
            java.lang.Integer r5 = r0.created_time
            java.lang.Integer r6 = r0.verified_time
            java.lang.Integer r7 = r0.pending_time
            java.lang.Integer r8 = r0.paid_time
            java.lang.Integer r9 = r0.days_shopee
            java.lang.Integer r10 = r0.days_bank
            java.lang.Long r11 = r0.amount_before_discount
            java.lang.Integer r12 = r0.discount_percentage
            com.shopee.protocol.shop.PromotionInfo r13 = r0.promotion_info
            java.lang.Integer r14 = r0.refund_days_min
            java.lang.Integer r15 = r0.refund_days_max
            r21 = r1
            java.lang.Integer r1 = r0.bin_type
            r16 = r1
            java.lang.Boolean r1 = r0.refund_to_seller
            r17 = r1
            java.lang.Boolean r1 = r0.is_group_buy
            r18 = r1
            java.lang.Long r1 = r0.spm_transaction_id
            r19 = r1
            java.lang.Long r1 = r0.parcelid
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.RefundExtInfo.<init>(com.shopee.protocol.shop.RefundExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RefundExtInfo)) {
            return false;
        }
        RefundExtInfo refundExtInfo = (RefundExtInfo) obj;
        if (!equals((Object) this.bank_account, (Object) refundExtInfo.bank_account) || !equals((Object) this.batchid, (Object) refundExtInfo.batchid) || !equals((Object) this.checkout_sn, (Object) refundExtInfo.checkout_sn) || !equals((Object) this.created_time, (Object) refundExtInfo.created_time) || !equals((Object) this.verified_time, (Object) refundExtInfo.verified_time) || !equals((Object) this.pending_time, (Object) refundExtInfo.pending_time) || !equals((Object) this.paid_time, (Object) refundExtInfo.paid_time) || !equals((Object) this.days_shopee, (Object) refundExtInfo.days_shopee) || !equals((Object) this.days_bank, (Object) refundExtInfo.days_bank) || !equals((Object) this.amount_before_discount, (Object) refundExtInfo.amount_before_discount) || !equals((Object) this.discount_percentage, (Object) refundExtInfo.discount_percentage) || !equals((Object) this.promotion_info, (Object) refundExtInfo.promotion_info) || !equals((Object) this.refund_days_min, (Object) refundExtInfo.refund_days_min) || !equals((Object) this.refund_days_max, (Object) refundExtInfo.refund_days_max) || !equals((Object) this.bin_type, (Object) refundExtInfo.bin_type) || !equals((Object) this.refund_to_seller, (Object) refundExtInfo.refund_to_seller) || !equals((Object) this.is_group_buy, (Object) refundExtInfo.is_group_buy) || !equals((Object) this.spm_transaction_id, (Object) refundExtInfo.spm_transaction_id) || !equals((Object) this.parcelid, (Object) refundExtInfo.parcelid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        BankAccountInfo bankAccountInfo = this.bank_account;
        int i2 = 0;
        int hashCode = (bankAccountInfo != null ? bankAccountInfo.hashCode() : 0) * 37;
        Integer num = this.batchid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.checkout_sn;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.created_time;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.verified_time;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.pending_time;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.paid_time;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.days_shopee;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.days_bank;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l = this.amount_before_discount;
        int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num8 = this.discount_percentage;
        int hashCode11 = (hashCode10 + (num8 != null ? num8.hashCode() : 0)) * 37;
        PromotionInfo promotionInfo = this.promotion_info;
        int hashCode12 = (hashCode11 + (promotionInfo != null ? promotionInfo.hashCode() : 0)) * 37;
        Integer num9 = this.refund_days_min;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.refund_days_max;
        int hashCode14 = (hashCode13 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.bin_type;
        int hashCode15 = (hashCode14 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Boolean bool = this.refund_to_seller;
        int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_group_buy;
        int hashCode17 = (hashCode16 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Long l2 = this.spm_transaction_id;
        int hashCode18 = (hashCode17 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.parcelid;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RefundExtInfo> {
        public Long amount_before_discount;
        public BankAccountInfo bank_account;
        public Integer batchid;
        public Integer bin_type;
        public String checkout_sn;
        public Integer created_time;
        public Integer days_bank;
        public Integer days_shopee;
        public Integer discount_percentage;
        public Boolean is_group_buy;
        public Integer paid_time;
        public Long parcelid;
        public Integer pending_time;
        public PromotionInfo promotion_info;
        public Integer refund_days_max;
        public Integer refund_days_min;
        public Boolean refund_to_seller;
        public Long spm_transaction_id;
        public Integer verified_time;

        public Builder() {
        }

        public Builder(RefundExtInfo refundExtInfo) {
            super(refundExtInfo);
            if (refundExtInfo != null) {
                this.bank_account = refundExtInfo.bank_account;
                this.batchid = refundExtInfo.batchid;
                this.checkout_sn = refundExtInfo.checkout_sn;
                this.created_time = refundExtInfo.created_time;
                this.verified_time = refundExtInfo.verified_time;
                this.pending_time = refundExtInfo.pending_time;
                this.paid_time = refundExtInfo.paid_time;
                this.days_shopee = refundExtInfo.days_shopee;
                this.days_bank = refundExtInfo.days_bank;
                this.amount_before_discount = refundExtInfo.amount_before_discount;
                this.discount_percentage = refundExtInfo.discount_percentage;
                this.promotion_info = refundExtInfo.promotion_info;
                this.refund_days_min = refundExtInfo.refund_days_min;
                this.refund_days_max = refundExtInfo.refund_days_max;
                this.bin_type = refundExtInfo.bin_type;
                this.refund_to_seller = refundExtInfo.refund_to_seller;
                this.is_group_buy = refundExtInfo.is_group_buy;
                this.spm_transaction_id = refundExtInfo.spm_transaction_id;
                this.parcelid = refundExtInfo.parcelid;
            }
        }

        public Builder bank_account(BankAccountInfo bankAccountInfo) {
            this.bank_account = bankAccountInfo;
            return this;
        }

        public Builder batchid(Integer num) {
            this.batchid = num;
            return this;
        }

        public Builder checkout_sn(String str) {
            this.checkout_sn = str;
            return this;
        }

        public Builder created_time(Integer num) {
            this.created_time = num;
            return this;
        }

        public Builder verified_time(Integer num) {
            this.verified_time = num;
            return this;
        }

        public Builder pending_time(Integer num) {
            this.pending_time = num;
            return this;
        }

        public Builder paid_time(Integer num) {
            this.paid_time = num;
            return this;
        }

        public Builder days_shopee(Integer num) {
            this.days_shopee = num;
            return this;
        }

        public Builder days_bank(Integer num) {
            this.days_bank = num;
            return this;
        }

        public Builder amount_before_discount(Long l) {
            this.amount_before_discount = l;
            return this;
        }

        public Builder discount_percentage(Integer num) {
            this.discount_percentage = num;
            return this;
        }

        public Builder promotion_info(PromotionInfo promotionInfo) {
            this.promotion_info = promotionInfo;
            return this;
        }

        public Builder refund_days_min(Integer num) {
            this.refund_days_min = num;
            return this;
        }

        public Builder refund_days_max(Integer num) {
            this.refund_days_max = num;
            return this;
        }

        public Builder bin_type(Integer num) {
            this.bin_type = num;
            return this;
        }

        public Builder refund_to_seller(Boolean bool) {
            this.refund_to_seller = bool;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public Builder spm_transaction_id(Long l) {
            this.spm_transaction_id = l;
            return this;
        }

        public Builder parcelid(Long l) {
            this.parcelid = l;
            return this;
        }

        public RefundExtInfo build() {
            return new RefundExtInfo(this);
        }
    }
}
