package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Refund extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Integer DEFAULT_BANKACCOUNT_ID = 0;
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    public static final String DEFAULT_REASON = "";
    public static final Long DEFAULT_REFUND_ID = 0L;
    public static final String DEFAULT_REFUND_SN = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer bankaccount_id;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 16, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer payment_method;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long refund_id;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String refund_sn;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public Refund(Long l, Integer num, Integer num2, Long l2, String str, String str2, Integer num3, Integer num4, Long l3, Integer num5, Long l4, String str3, String str4, Long l5, Integer num6, f fVar, Integer num7, Integer num8) {
        this.refund_id = l;
        this.userid = num;
        this.status = num2;
        this.amount = l2;
        this.currency = str;
        this.reason = str2;
        this.ctime = num3;
        this.mtime = num4;
        this.orderid = l3;
        this.shopid = num5;
        this.return_id = l4;
        this.country = str3;
        this.refund_sn = str4;
        this.checkoutid = l5;
        this.payment_method = num6;
        this.extinfo = fVar;
        this.bankaccount_id = num7;
        this.cb_option = num8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Refund(com.shopee.protocol.shop.Refund.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.Long r2 = r0.refund_id
            java.lang.Integer r3 = r0.userid
            java.lang.Integer r4 = r0.status
            java.lang.Long r5 = r0.amount
            java.lang.String r6 = r0.currency
            java.lang.String r7 = r0.reason
            java.lang.Integer r8 = r0.ctime
            java.lang.Integer r9 = r0.mtime
            java.lang.Long r10 = r0.orderid
            java.lang.Integer r11 = r0.shopid
            java.lang.Long r12 = r0.return_id
            java.lang.String r13 = r0.country
            java.lang.String r14 = r0.refund_sn
            java.lang.Long r15 = r0.checkoutid
            r20 = r1
            java.lang.Integer r1 = r0.payment_method
            r16 = r1
            e.f r1 = r0.extinfo
            r17 = r1
            java.lang.Integer r1 = r0.bankaccount_id
            r18 = r1
            java.lang.Integer r1 = r0.cb_option
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Refund.<init>(com.shopee.protocol.shop.Refund$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Refund)) {
            return false;
        }
        Refund refund = (Refund) obj;
        if (!equals((Object) this.refund_id, (Object) refund.refund_id) || !equals((Object) this.userid, (Object) refund.userid) || !equals((Object) this.status, (Object) refund.status) || !equals((Object) this.amount, (Object) refund.amount) || !equals((Object) this.currency, (Object) refund.currency) || !equals((Object) this.reason, (Object) refund.reason) || !equals((Object) this.ctime, (Object) refund.ctime) || !equals((Object) this.mtime, (Object) refund.mtime) || !equals((Object) this.orderid, (Object) refund.orderid) || !equals((Object) this.shopid, (Object) refund.shopid) || !equals((Object) this.return_id, (Object) refund.return_id) || !equals((Object) this.country, (Object) refund.country) || !equals((Object) this.refund_sn, (Object) refund.refund_sn) || !equals((Object) this.checkoutid, (Object) refund.checkoutid) || !equals((Object) this.payment_method, (Object) refund.payment_method) || !equals((Object) this.extinfo, (Object) refund.extinfo) || !equals((Object) this.bankaccount_id, (Object) refund.bankaccount_id) || !equals((Object) this.cb_option, (Object) refund.cb_option)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.refund_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.amount;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.reason;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l3 = this.orderid;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num5 = this.shopid;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l4 = this.return_id;
        int hashCode11 = (hashCode10 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.refund_sn;
        int hashCode13 = (hashCode12 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l5 = this.checkoutid;
        int hashCode14 = (hashCode13 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num6 = this.payment_method;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode16 = (hashCode15 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num7 = this.bankaccount_id;
        int hashCode17 = (hashCode16 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.cb_option;
        if (num8 != null) {
            i2 = num8.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Refund> {
        public Long amount;
        public Integer bankaccount_id;
        public Integer cb_option;
        public Long checkoutid;
        public String country;
        public Integer ctime;
        public String currency;
        public f extinfo;
        public Integer mtime;
        public Long orderid;
        public Integer payment_method;
        public String reason;
        public Long refund_id;
        public String refund_sn;
        public Long return_id;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(Refund refund) {
            super(refund);
            if (refund != null) {
                this.refund_id = refund.refund_id;
                this.userid = refund.userid;
                this.status = refund.status;
                this.amount = refund.amount;
                this.currency = refund.currency;
                this.reason = refund.reason;
                this.ctime = refund.ctime;
                this.mtime = refund.mtime;
                this.orderid = refund.orderid;
                this.shopid = refund.shopid;
                this.return_id = refund.return_id;
                this.country = refund.country;
                this.refund_sn = refund.refund_sn;
                this.checkoutid = refund.checkoutid;
                this.payment_method = refund.payment_method;
                this.extinfo = refund.extinfo;
                this.bankaccount_id = refund.bankaccount_id;
                this.cb_option = refund.cb_option;
            }
        }

        public Builder refund_id(Long l) {
            this.refund_id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public Builder reason(String str) {
            this.reason = str;
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

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder refund_sn(String str) {
            this.refund_sn = str;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder payment_method(Integer num) {
            this.payment_method = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder bankaccount_id(Integer num) {
            this.bankaccount_id = num;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Refund build() {
            return new Refund(this);
        }
    }
}
