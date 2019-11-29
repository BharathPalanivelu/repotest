package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TransHisExtInfo extends Message {
    public static final Long DEFAULT_ADMIN_FEE = 0L;
    public static final Long DEFAULT_BUYER_TXN_FEE = 0L;
    public static final Long DEFAULT_CARD_TXN_FEE = 0L;
    public static final Long DEFAULT_COMM_FEE = 0L;
    public static final Integer DEFAULT_MAXTIME = 0;
    public static final Integer DEFAULT_MINTIME = 0;
    public static final Long DEFAULT_PAYMENT_CHANNEL_ID = 0L;
    public static final Long DEFAULT_SELLER_ABSORBED_COIN_CASHBACK_VOUCHER = 0L;
    public static final Long DEFAULT_SELLER_ABSORBED_DISCOUNT = 0L;
    public static final Long DEFAULT_SERVICE_FEE = 0L;
    public static final Long DEFAULT_TAX_AMOUNT = 0L;
    public static final Long DEFAULT_TOTAL_COMPENSATE_FEE = 0L;
    public static final Boolean DEFAULT_USING_WALLET = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long admin_fee;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long buyer_txn_fee;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long card_txn_fee;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long comm_fee;
    @ProtoField(tag = 11)
    public final JkoAccountSeller jko_seller_info;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer maxtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer mintime;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long payment_channel_id;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long seller_absorbed_coin_cashback_voucher;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long seller_absorbed_discount;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long service_fee;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long tax_amount;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long total_compensate_fee;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean using_wallet;

    public TransHisExtInfo(Integer num, Integer num2, Boolean bool, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, JkoAccountSeller jkoAccountSeller, Long l8, Long l9, Long l10) {
        this.mintime = num;
        this.maxtime = num2;
        this.using_wallet = bool;
        this.comm_fee = l;
        this.seller_absorbed_discount = l2;
        this.card_txn_fee = l3;
        this.tax_amount = l4;
        this.buyer_txn_fee = l5;
        this.admin_fee = l6;
        this.payment_channel_id = l7;
        this.jko_seller_info = jkoAccountSeller;
        this.seller_absorbed_coin_cashback_voucher = l8;
        this.total_compensate_fee = l9;
        this.service_fee = l10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TransHisExtInfo(com.shopee.protocol.shop.TransHisExtInfo.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Integer r2 = r0.mintime
            java.lang.Integer r3 = r0.maxtime
            java.lang.Boolean r4 = r0.using_wallet
            java.lang.Long r5 = r0.comm_fee
            java.lang.Long r6 = r0.seller_absorbed_discount
            java.lang.Long r7 = r0.card_txn_fee
            java.lang.Long r8 = r0.tax_amount
            java.lang.Long r9 = r0.buyer_txn_fee
            java.lang.Long r10 = r0.admin_fee
            java.lang.Long r11 = r0.payment_channel_id
            com.shopee.protocol.shop.JkoAccountSeller r12 = r0.jko_seller_info
            java.lang.Long r13 = r0.seller_absorbed_coin_cashback_voucher
            java.lang.Long r14 = r0.total_compensate_fee
            java.lang.Long r15 = r0.service_fee
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.TransHisExtInfo.<init>(com.shopee.protocol.shop.TransHisExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransHisExtInfo)) {
            return false;
        }
        TransHisExtInfo transHisExtInfo = (TransHisExtInfo) obj;
        if (!equals((Object) this.mintime, (Object) transHisExtInfo.mintime) || !equals((Object) this.maxtime, (Object) transHisExtInfo.maxtime) || !equals((Object) this.using_wallet, (Object) transHisExtInfo.using_wallet) || !equals((Object) this.comm_fee, (Object) transHisExtInfo.comm_fee) || !equals((Object) this.seller_absorbed_discount, (Object) transHisExtInfo.seller_absorbed_discount) || !equals((Object) this.card_txn_fee, (Object) transHisExtInfo.card_txn_fee) || !equals((Object) this.tax_amount, (Object) transHisExtInfo.tax_amount) || !equals((Object) this.buyer_txn_fee, (Object) transHisExtInfo.buyer_txn_fee) || !equals((Object) this.admin_fee, (Object) transHisExtInfo.admin_fee) || !equals((Object) this.payment_channel_id, (Object) transHisExtInfo.payment_channel_id) || !equals((Object) this.jko_seller_info, (Object) transHisExtInfo.jko_seller_info) || !equals((Object) this.seller_absorbed_coin_cashback_voucher, (Object) transHisExtInfo.seller_absorbed_coin_cashback_voucher) || !equals((Object) this.total_compensate_fee, (Object) transHisExtInfo.total_compensate_fee) || !equals((Object) this.service_fee, (Object) transHisExtInfo.service_fee)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.mintime;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.maxtime;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.using_wallet;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.comm_fee;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.seller_absorbed_discount;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.card_txn_fee;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.tax_amount;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.buyer_txn_fee;
        int hashCode8 = (hashCode7 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.admin_fee;
        int hashCode9 = (hashCode8 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.payment_channel_id;
        int hashCode10 = (hashCode9 + (l7 != null ? l7.hashCode() : 0)) * 37;
        JkoAccountSeller jkoAccountSeller = this.jko_seller_info;
        int hashCode11 = (hashCode10 + (jkoAccountSeller != null ? jkoAccountSeller.hashCode() : 0)) * 37;
        Long l8 = this.seller_absorbed_coin_cashback_voucher;
        int hashCode12 = (hashCode11 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.total_compensate_fee;
        int hashCode13 = (hashCode12 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.service_fee;
        if (l10 != null) {
            i2 = l10.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TransHisExtInfo> {
        public Long admin_fee;
        public Long buyer_txn_fee;
        public Long card_txn_fee;
        public Long comm_fee;
        public JkoAccountSeller jko_seller_info;
        public Integer maxtime;
        public Integer mintime;
        public Long payment_channel_id;
        public Long seller_absorbed_coin_cashback_voucher;
        public Long seller_absorbed_discount;
        public Long service_fee;
        public Long tax_amount;
        public Long total_compensate_fee;
        public Boolean using_wallet;

        public Builder() {
        }

        public Builder(TransHisExtInfo transHisExtInfo) {
            super(transHisExtInfo);
            if (transHisExtInfo != null) {
                this.mintime = transHisExtInfo.mintime;
                this.maxtime = transHisExtInfo.maxtime;
                this.using_wallet = transHisExtInfo.using_wallet;
                this.comm_fee = transHisExtInfo.comm_fee;
                this.seller_absorbed_discount = transHisExtInfo.seller_absorbed_discount;
                this.card_txn_fee = transHisExtInfo.card_txn_fee;
                this.tax_amount = transHisExtInfo.tax_amount;
                this.buyer_txn_fee = transHisExtInfo.buyer_txn_fee;
                this.admin_fee = transHisExtInfo.admin_fee;
                this.payment_channel_id = transHisExtInfo.payment_channel_id;
                this.jko_seller_info = transHisExtInfo.jko_seller_info;
                this.seller_absorbed_coin_cashback_voucher = transHisExtInfo.seller_absorbed_coin_cashback_voucher;
                this.total_compensate_fee = transHisExtInfo.total_compensate_fee;
                this.service_fee = transHisExtInfo.service_fee;
            }
        }

        public Builder mintime(Integer num) {
            this.mintime = num;
            return this;
        }

        public Builder maxtime(Integer num) {
            this.maxtime = num;
            return this;
        }

        public Builder using_wallet(Boolean bool) {
            this.using_wallet = bool;
            return this;
        }

        public Builder comm_fee(Long l) {
            this.comm_fee = l;
            return this;
        }

        public Builder seller_absorbed_discount(Long l) {
            this.seller_absorbed_discount = l;
            return this;
        }

        public Builder card_txn_fee(Long l) {
            this.card_txn_fee = l;
            return this;
        }

        public Builder tax_amount(Long l) {
            this.tax_amount = l;
            return this;
        }

        public Builder buyer_txn_fee(Long l) {
            this.buyer_txn_fee = l;
            return this;
        }

        public Builder admin_fee(Long l) {
            this.admin_fee = l;
            return this;
        }

        public Builder payment_channel_id(Long l) {
            this.payment_channel_id = l;
            return this;
        }

        public Builder jko_seller_info(JkoAccountSeller jkoAccountSeller) {
            this.jko_seller_info = jkoAccountSeller;
            return this;
        }

        public Builder seller_absorbed_coin_cashback_voucher(Long l) {
            this.seller_absorbed_coin_cashback_voucher = l;
            return this;
        }

        public Builder total_compensate_fee(Long l) {
            this.total_compensate_fee = l;
            return this;
        }

        public Builder service_fee(Long l) {
            this.service_fee = l;
            return this;
        }

        public TransHisExtInfo build() {
            return new TransHisExtInfo(this);
        }
    }
}
