package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class TransHistoryV2 extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final String DEFAULT_CUSTOM_NAME = "";
    public static final Long DEFAULT_ESTIMATED_ESCROW_AMOUNT = 0L;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final String DEFAULT_IMAGE = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Long DEFAULT_REBATE_PRICE = 0L;
    public static final Integer DEFAULT_RELEASE_TIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TRANSID = 0;
    public static final Integer DEFAULT_TRANS_PAYMENT_TYPE = 0;
    public static final Integer DEFAULT_TRANS_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_WITHDRAW_BANKACC = "";
    public static final String DEFAULT_WITHDRAW_NAME = "";
    public static final Long DEFAULT_WITHDRAW_TRANSFEE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String custom_name;
    @ProtoField(tag = 20, type = Message.Datatype.INT64)
    public final Long estimated_escrow_amount;
    @ProtoField(tag = 19, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String image;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long rebate_price;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer release_time;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer trans_payment_type;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer trans_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer transid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String withdraw_bankacc;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String withdraw_name;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long withdraw_transfee;

    public TransHistoryV2(Integer num, Integer num2, Integer num3, Long l, String str, String str2, String str3, String str4, Long l2, String str5, Long l3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Long l4, Long l5, f fVar, Long l6, Integer num9) {
        this.transid = num;
        this.userid = num2;
        this.shopid = num3;
        this.orderid = l;
        this.image = str;
        this.custom_name = str2;
        this.withdraw_name = str3;
        this.withdraw_bankacc = str4;
        this.amount = l2;
        this.currency = str5;
        this.withdraw_transfee = l3;
        this.trans_type = num4;
        this.status = num5;
        this.ctime = num6;
        this.mtime = num7;
        this.release_time = num8;
        this.price_before_discount = l4;
        this.rebate_price = l5;
        this.extinfo = fVar;
        this.estimated_escrow_amount = l6;
        this.trans_payment_type = num9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TransHistoryV2(com.shopee.protocol.shop.TransHistoryV2.Builder r25) {
        /*
            r24 = this;
            r0 = r25
            r1 = r24
            java.lang.Integer r2 = r0.transid
            java.lang.Integer r3 = r0.userid
            java.lang.Integer r4 = r0.shopid
            java.lang.Long r5 = r0.orderid
            java.lang.String r6 = r0.image
            java.lang.String r7 = r0.custom_name
            java.lang.String r8 = r0.withdraw_name
            java.lang.String r9 = r0.withdraw_bankacc
            java.lang.Long r10 = r0.amount
            java.lang.String r11 = r0.currency
            java.lang.Long r12 = r0.withdraw_transfee
            java.lang.Integer r13 = r0.trans_type
            java.lang.Integer r14 = r0.status
            java.lang.Integer r15 = r0.ctime
            r23 = r1
            java.lang.Integer r1 = r0.mtime
            r16 = r1
            java.lang.Integer r1 = r0.release_time
            r17 = r1
            java.lang.Long r1 = r0.price_before_discount
            r18 = r1
            java.lang.Long r1 = r0.rebate_price
            r19 = r1
            e.f r1 = r0.extinfo
            r20 = r1
            java.lang.Long r1 = r0.estimated_escrow_amount
            r21 = r1
            java.lang.Integer r1 = r0.trans_payment_type
            r22 = r1
            r1 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r24.setBuilder(r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.TransHistoryV2.<init>(com.shopee.protocol.shop.TransHistoryV2$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransHistoryV2)) {
            return false;
        }
        TransHistoryV2 transHistoryV2 = (TransHistoryV2) obj;
        if (!equals((Object) this.transid, (Object) transHistoryV2.transid) || !equals((Object) this.userid, (Object) transHistoryV2.userid) || !equals((Object) this.shopid, (Object) transHistoryV2.shopid) || !equals((Object) this.orderid, (Object) transHistoryV2.orderid) || !equals((Object) this.image, (Object) transHistoryV2.image) || !equals((Object) this.custom_name, (Object) transHistoryV2.custom_name) || !equals((Object) this.withdraw_name, (Object) transHistoryV2.withdraw_name) || !equals((Object) this.withdraw_bankacc, (Object) transHistoryV2.withdraw_bankacc) || !equals((Object) this.amount, (Object) transHistoryV2.amount) || !equals((Object) this.currency, (Object) transHistoryV2.currency) || !equals((Object) this.withdraw_transfee, (Object) transHistoryV2.withdraw_transfee) || !equals((Object) this.trans_type, (Object) transHistoryV2.trans_type) || !equals((Object) this.status, (Object) transHistoryV2.status) || !equals((Object) this.ctime, (Object) transHistoryV2.ctime) || !equals((Object) this.mtime, (Object) transHistoryV2.mtime) || !equals((Object) this.release_time, (Object) transHistoryV2.release_time) || !equals((Object) this.price_before_discount, (Object) transHistoryV2.price_before_discount) || !equals((Object) this.rebate_price, (Object) transHistoryV2.rebate_price) || !equals((Object) this.extinfo, (Object) transHistoryV2.extinfo) || !equals((Object) this.estimated_escrow_amount, (Object) transHistoryV2.estimated_escrow_amount) || !equals((Object) this.trans_payment_type, (Object) transHistoryV2.trans_payment_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.transid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.image;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.custom_name;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.withdraw_name;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.withdraw_bankacc;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l2 = this.amount;
        int hashCode9 = (hashCode8 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str5 = this.currency;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l3 = this.withdraw_transfee;
        int hashCode11 = (hashCode10 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num4 = this.trans_type;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode15 = (hashCode14 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.release_time;
        int hashCode16 = (hashCode15 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Long l4 = this.price_before_discount;
        int hashCode17 = (hashCode16 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.rebate_price;
        int hashCode18 = (hashCode17 + (l5 != null ? l5.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode19 = (hashCode18 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l6 = this.estimated_escrow_amount;
        int hashCode20 = (hashCode19 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num9 = this.trans_payment_type;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i3 = hashCode20 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TransHistoryV2> {
        public Long amount;
        public Integer ctime;
        public String currency;
        public String custom_name;
        public Long estimated_escrow_amount;
        public f extinfo;
        public String image;
        public Integer mtime;
        public Long orderid;
        public Long price_before_discount;
        public Long rebate_price;
        public Integer release_time;
        public Integer shopid;
        public Integer status;
        public Integer trans_payment_type;
        public Integer trans_type;
        public Integer transid;
        public Integer userid;
        public String withdraw_bankacc;
        public String withdraw_name;
        public Long withdraw_transfee;

        public Builder() {
        }

        public Builder(TransHistoryV2 transHistoryV2) {
            super(transHistoryV2);
            if (transHistoryV2 != null) {
                this.transid = transHistoryV2.transid;
                this.userid = transHistoryV2.userid;
                this.shopid = transHistoryV2.shopid;
                this.orderid = transHistoryV2.orderid;
                this.image = transHistoryV2.image;
                this.custom_name = transHistoryV2.custom_name;
                this.withdraw_name = transHistoryV2.withdraw_name;
                this.withdraw_bankacc = transHistoryV2.withdraw_bankacc;
                this.amount = transHistoryV2.amount;
                this.currency = transHistoryV2.currency;
                this.withdraw_transfee = transHistoryV2.withdraw_transfee;
                this.trans_type = transHistoryV2.trans_type;
                this.status = transHistoryV2.status;
                this.ctime = transHistoryV2.ctime;
                this.mtime = transHistoryV2.mtime;
                this.release_time = transHistoryV2.release_time;
                this.price_before_discount = transHistoryV2.price_before_discount;
                this.rebate_price = transHistoryV2.rebate_price;
                this.extinfo = transHistoryV2.extinfo;
                this.estimated_escrow_amount = transHistoryV2.estimated_escrow_amount;
                this.trans_payment_type = transHistoryV2.trans_payment_type;
            }
        }

        public Builder transid(Integer num) {
            this.transid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder image(String str) {
            this.image = str;
            return this;
        }

        public Builder custom_name(String str) {
            this.custom_name = str;
            return this;
        }

        public Builder withdraw_name(String str) {
            this.withdraw_name = str;
            return this;
        }

        public Builder withdraw_bankacc(String str) {
            this.withdraw_bankacc = str;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder withdraw_transfee(Long l) {
            this.withdraw_transfee = l;
            return this;
        }

        public Builder trans_type(Integer num) {
            this.trans_type = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder release_time(Integer num) {
            this.release_time = num;
            return this;
        }

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public Builder rebate_price(Long l) {
            this.rebate_price = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder estimated_escrow_amount(Long l) {
            this.estimated_escrow_amount = l;
            return this;
        }

        public Builder trans_payment_type(Integer num) {
            this.trans_payment_type = num;
            return this;
        }

        public TransHistoryV2 build() {
            return new TransHistoryV2(this);
        }
    }
}
