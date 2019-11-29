package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Checkout extends Message {
    public static final Long DEFAULT_ACTUAL_PRICE = 0L;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final f DEFAULT_CHECKOUT_INFO = f.f32736b;
    public static final String DEFAULT_CHECKOUT_SN = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_LOGISTICS_STATUS = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_PAID_AMOUNT = 0L;
    public static final Integer DEFAULT_PAYMENT_STATUS = 0;
    public static final Integer DEFAULT_PAYMENT_TYPE = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TOTAL_PRICE = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long actual_price;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f checkout_info;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String checkout_sn;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer logistics_status;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long paid_amount;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer payment_status;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer payment_type;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long total_price;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public Checkout(Long l, Integer num, Integer num2, Long l2, Long l3, String str, Integer num3, Integer num4, f fVar, String str2, Integer num5, String str3, Long l4, Integer num6, Integer num7) {
        this.checkoutid = l;
        this.userid = num;
        this.status = num2;
        this.total_price = l2;
        this.paid_amount = l3;
        this.currency = str;
        this.ctime = num3;
        this.mtime = num4;
        this.checkout_info = fVar;
        this.country = str2;
        this.payment_status = num5;
        this.checkout_sn = str3;
        this.actual_price = l4;
        this.payment_type = num6;
        this.logistics_status = num7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Checkout(com.shopee.protocol.shop.Checkout.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Long r2 = r0.checkoutid
            java.lang.Integer r3 = r0.userid
            java.lang.Integer r4 = r0.status
            java.lang.Long r5 = r0.total_price
            java.lang.Long r6 = r0.paid_amount
            java.lang.String r7 = r0.currency
            java.lang.Integer r8 = r0.ctime
            java.lang.Integer r9 = r0.mtime
            e.f r10 = r0.checkout_info
            java.lang.String r11 = r0.country
            java.lang.Integer r12 = r0.payment_status
            java.lang.String r13 = r0.checkout_sn
            java.lang.Long r14 = r0.actual_price
            java.lang.Integer r15 = r0.payment_type
            java.lang.Integer r1 = r0.logistics_status
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Checkout.<init>(com.shopee.protocol.shop.Checkout$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Checkout)) {
            return false;
        }
        Checkout checkout = (Checkout) obj;
        if (!equals((Object) this.checkoutid, (Object) checkout.checkoutid) || !equals((Object) this.userid, (Object) checkout.userid) || !equals((Object) this.status, (Object) checkout.status) || !equals((Object) this.total_price, (Object) checkout.total_price) || !equals((Object) this.paid_amount, (Object) checkout.paid_amount) || !equals((Object) this.currency, (Object) checkout.currency) || !equals((Object) this.ctime, (Object) checkout.ctime) || !equals((Object) this.mtime, (Object) checkout.mtime) || !equals((Object) this.checkout_info, (Object) checkout.checkout_info) || !equals((Object) this.country, (Object) checkout.country) || !equals((Object) this.payment_status, (Object) checkout.payment_status) || !equals((Object) this.checkout_sn, (Object) checkout.checkout_sn) || !equals((Object) this.actual_price, (Object) checkout.actual_price) || !equals((Object) this.payment_type, (Object) checkout.payment_type) || !equals((Object) this.logistics_status, (Object) checkout.logistics_status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.checkoutid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.total_price;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.paid_amount;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        f fVar = this.checkout_info;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num5 = this.payment_status;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str3 = this.checkout_sn;
        int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l4 = this.actual_price;
        int hashCode13 = (hashCode12 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num6 = this.payment_type;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.logistics_status;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Checkout> {
        public Long actual_price;
        public f checkout_info;
        public String checkout_sn;
        public Long checkoutid;
        public String country;
        public Integer ctime;
        public String currency;
        public Integer logistics_status;
        public Integer mtime;
        public Long paid_amount;
        public Integer payment_status;
        public Integer payment_type;
        public Integer status;
        public Long total_price;
        public Integer userid;

        public Builder() {
        }

        public Builder(Checkout checkout) {
            super(checkout);
            if (checkout != null) {
                this.checkoutid = checkout.checkoutid;
                this.userid = checkout.userid;
                this.status = checkout.status;
                this.total_price = checkout.total_price;
                this.paid_amount = checkout.paid_amount;
                this.currency = checkout.currency;
                this.ctime = checkout.ctime;
                this.mtime = checkout.mtime;
                this.checkout_info = checkout.checkout_info;
                this.country = checkout.country;
                this.payment_status = checkout.payment_status;
                this.checkout_sn = checkout.checkout_sn;
                this.actual_price = checkout.actual_price;
                this.payment_type = checkout.payment_type;
                this.logistics_status = checkout.logistics_status;
            }
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
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

        public Builder total_price(Long l) {
            this.total_price = l;
            return this;
        }

        public Builder paid_amount(Long l) {
            this.paid_amount = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
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

        public Builder checkout_info(f fVar) {
            this.checkout_info = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder payment_status(Integer num) {
            this.payment_status = num;
            return this;
        }

        public Builder checkout_sn(String str) {
            this.checkout_sn = str;
            return this;
        }

        public Builder actual_price(Long l) {
            this.actual_price = l;
            return this;
        }

        public Builder payment_type(Integer num) {
            this.payment_type = num;
            return this;
        }

        public Builder logistics_status(Integer num) {
            this.logistics_status = num;
            return this;
        }

        public Checkout build() {
            return new Checkout(this);
        }
    }
}
