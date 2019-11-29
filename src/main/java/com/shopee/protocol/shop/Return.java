package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Return extends Message {
    public static final Integer DEFAULT_ARCHIVE = 0;
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_LOGISTICS_STATUS = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_REASON = 0;
    public static final Long DEFAULT_REFUND_AMOUNT = 0L;
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final f DEFAULT_RETURN_INFO = f.f32736b;
    public static final String DEFAULT_RETURN_SN = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer archive;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer logistics_status;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer reason;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long refund_amount;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f return_info;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String return_sn;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public Return(Long l, Long l2, Integer num, Integer num2, Long l3, String str, Integer num3, Integer num4, Integer num5, Integer num6, f fVar, String str2, String str3, Integer num7, Integer num8, Integer num9) {
        this.return_id = l;
        this.orderid = l2;
        this.shopid = num;
        this.userid = num2;
        this.refund_amount = l3;
        this.currency = str;
        this.reason = num3;
        this.status = num4;
        this.ctime = num5;
        this.mtime = num6;
        this.return_info = fVar;
        this.country = str2;
        this.return_sn = str3;
        this.archive = num7;
        this.cb_option = num8;
        this.logistics_status = num9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Return(com.shopee.protocol.shop.Return.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.Long r2 = r0.return_id
            java.lang.Long r3 = r0.orderid
            java.lang.Integer r4 = r0.shopid
            java.lang.Integer r5 = r0.userid
            java.lang.Long r6 = r0.refund_amount
            java.lang.String r7 = r0.currency
            java.lang.Integer r8 = r0.reason
            java.lang.Integer r9 = r0.status
            java.lang.Integer r10 = r0.ctime
            java.lang.Integer r11 = r0.mtime
            e.f r12 = r0.return_info
            java.lang.String r13 = r0.country
            java.lang.String r14 = r0.return_sn
            java.lang.Integer r15 = r0.archive
            r18 = r1
            java.lang.Integer r1 = r0.cb_option
            r16 = r1
            java.lang.Integer r1 = r0.logistics_status
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Return.<init>(com.shopee.protocol.shop.Return$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Return)) {
            return false;
        }
        Return returnR = (Return) obj;
        if (!equals((Object) this.return_id, (Object) returnR.return_id) || !equals((Object) this.orderid, (Object) returnR.orderid) || !equals((Object) this.shopid, (Object) returnR.shopid) || !equals((Object) this.userid, (Object) returnR.userid) || !equals((Object) this.refund_amount, (Object) returnR.refund_amount) || !equals((Object) this.currency, (Object) returnR.currency) || !equals((Object) this.reason, (Object) returnR.reason) || !equals((Object) this.status, (Object) returnR.status) || !equals((Object) this.ctime, (Object) returnR.ctime) || !equals((Object) this.mtime, (Object) returnR.mtime) || !equals((Object) this.return_info, (Object) returnR.return_info) || !equals((Object) this.country, (Object) returnR.country) || !equals((Object) this.return_sn, (Object) returnR.return_sn) || !equals((Object) this.archive, (Object) returnR.archive) || !equals((Object) this.cb_option, (Object) returnR.cb_option) || !equals((Object) this.logistics_status, (Object) returnR.logistics_status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.return_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.orderid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l3 = this.refund_amount;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.reason;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.mtime;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar = this.return_info;
        int hashCode11 = (hashCode10 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.return_sn;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num7 = this.archive;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.cb_option;
        int hashCode15 = (hashCode14 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.logistics_status;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Return> {
        public Integer archive;
        public Integer cb_option;
        public String country;
        public Integer ctime;
        public String currency;
        public Integer logistics_status;
        public Integer mtime;
        public Long orderid;
        public Integer reason;
        public Long refund_amount;
        public Long return_id;
        public f return_info;
        public String return_sn;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(Return returnR) {
            super(returnR);
            if (returnR != null) {
                this.return_id = returnR.return_id;
                this.orderid = returnR.orderid;
                this.shopid = returnR.shopid;
                this.userid = returnR.userid;
                this.refund_amount = returnR.refund_amount;
                this.currency = returnR.currency;
                this.reason = returnR.reason;
                this.status = returnR.status;
                this.ctime = returnR.ctime;
                this.mtime = returnR.mtime;
                this.return_info = returnR.return_info;
                this.country = returnR.country;
                this.return_sn = returnR.return_sn;
                this.archive = returnR.archive;
                this.cb_option = returnR.cb_option;
                this.logistics_status = returnR.logistics_status;
            }
        }

        public Builder return_id(Long l) {
            this.return_id = l;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder refund_amount(Long l) {
            this.refund_amount = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder reason(Integer num) {
            this.reason = num;
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

        public Builder return_info(f fVar) {
            this.return_info = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder return_sn(String str) {
            this.return_sn = str;
            return this;
        }

        public Builder archive(Integer num) {
            this.archive = num;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Builder logistics_status(Integer num) {
            this.logistics_status = num;
            return this;
        }

        public Return build() {
            return new Return(this);
        }
    }
}
