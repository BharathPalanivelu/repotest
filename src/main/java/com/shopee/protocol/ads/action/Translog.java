package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Translog extends Message {
    public static final Long DEFAULT_ACC_AFTER_BALANCE = 0L;
    public static final Long DEFAULT_ACC_BEFORE_BALANCE = 0L;
    public static final Long DEFAULT_ADSID = 0L;
    public static final Long DEFAULT_CLIENT_IP = 0L;
    public static final Long DEFAULT_DAI_AFTER_BALANCE = 0L;
    public static final Long DEFAULT_DAI_BEFORE_BALANCE = 0L;
    public static final Long DEFAULT_DEDUCT_UNIQUE_ID = 0L;
    public static final String DEFAULT_DEVICEID = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_OPERATION = 0;
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long acc_after_balance;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long acc_before_balance;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long client_ip;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long dai_after_balance;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long dai_before_balance;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long deduct_unique_id;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String deviceid;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer operation;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer userid;

    public Translog(Long l, Long l2, Long l3, Integer num, Integer num2, Long l4, Long l5, Integer num3, Long l6, f fVar, Integer num4, Long l7, Long l8, Long l9, Long l10, String str, String str2, Integer num5, Long l11) {
        this.id = l;
        this.adsid = l2;
        this.itemid = l3;
        this.shopid = num;
        this.operation = num2;
        this.timestamp = l4;
        this.client_ip = l5;
        this.userid = num3;
        this.price = l6;
        this.extinfo = fVar;
        this.status = num4;
        this.acc_before_balance = l7;
        this.acc_after_balance = l8;
        this.dai_before_balance = l9;
        this.dai_after_balance = l10;
        this.deviceid = str;
        this.keyword = str2;
        this.placement = num5;
        this.deduct_unique_id = l11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Translog(com.shopee.protocol.ads.action.Translog.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            java.lang.Long r2 = r0.id
            java.lang.Long r3 = r0.adsid
            java.lang.Long r4 = r0.itemid
            java.lang.Integer r5 = r0.shopid
            java.lang.Integer r6 = r0.operation
            java.lang.Long r7 = r0.timestamp
            java.lang.Long r8 = r0.client_ip
            java.lang.Integer r9 = r0.userid
            java.lang.Long r10 = r0.price
            e.f r11 = r0.extinfo
            java.lang.Integer r12 = r0.status
            java.lang.Long r13 = r0.acc_before_balance
            java.lang.Long r14 = r0.acc_after_balance
            java.lang.Long r15 = r0.dai_before_balance
            r21 = r1
            java.lang.Long r1 = r0.dai_after_balance
            r16 = r1
            java.lang.String r1 = r0.deviceid
            r17 = r1
            java.lang.String r1 = r0.keyword
            r18 = r1
            java.lang.Integer r1 = r0.placement
            r19 = r1
            java.lang.Long r1 = r0.deduct_unique_id
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.ads.action.Translog.<init>(com.shopee.protocol.ads.action.Translog$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Translog)) {
            return false;
        }
        Translog translog = (Translog) obj;
        if (!equals((Object) this.id, (Object) translog.id) || !equals((Object) this.adsid, (Object) translog.adsid) || !equals((Object) this.itemid, (Object) translog.itemid) || !equals((Object) this.shopid, (Object) translog.shopid) || !equals((Object) this.operation, (Object) translog.operation) || !equals((Object) this.timestamp, (Object) translog.timestamp) || !equals((Object) this.client_ip, (Object) translog.client_ip) || !equals((Object) this.userid, (Object) translog.userid) || !equals((Object) this.price, (Object) translog.price) || !equals((Object) this.extinfo, (Object) translog.extinfo) || !equals((Object) this.status, (Object) translog.status) || !equals((Object) this.acc_before_balance, (Object) translog.acc_before_balance) || !equals((Object) this.acc_after_balance, (Object) translog.acc_after_balance) || !equals((Object) this.dai_before_balance, (Object) translog.dai_before_balance) || !equals((Object) this.dai_after_balance, (Object) translog.dai_after_balance) || !equals((Object) this.deviceid, (Object) translog.deviceid) || !equals((Object) this.keyword, (Object) translog.keyword) || !equals((Object) this.placement, (Object) translog.placement) || !equals((Object) this.deduct_unique_id, (Object) translog.deduct_unique_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.adsid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.itemid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.operation;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l4 = this.timestamp;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.client_ip;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l6 = this.price;
        int hashCode9 = (hashCode8 + (l6 != null ? l6.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode10 = (hashCode9 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l7 = this.acc_before_balance;
        int hashCode12 = (hashCode11 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.acc_after_balance;
        int hashCode13 = (hashCode12 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.dai_before_balance;
        int hashCode14 = (hashCode13 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.dai_after_balance;
        int hashCode15 = (hashCode14 + (l10 != null ? l10.hashCode() : 0)) * 37;
        String str = this.deviceid;
        int hashCode16 = (hashCode15 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.keyword;
        int hashCode17 = (hashCode16 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num5 = this.placement;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l11 = this.deduct_unique_id;
        if (l11 != null) {
            i2 = l11.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Translog> {
        public Long acc_after_balance;
        public Long acc_before_balance;
        public Long adsid;
        public Long client_ip;
        public Long dai_after_balance;
        public Long dai_before_balance;
        public Long deduct_unique_id;
        public String deviceid;
        public f extinfo;
        public Long id;
        public Long itemid;
        public String keyword;
        public Integer operation;
        public Integer placement;
        public Long price;
        public Integer shopid;
        public Integer status;
        public Long timestamp;
        public Integer userid;

        public Builder() {
        }

        public Builder(Translog translog) {
            super(translog);
            if (translog != null) {
                this.id = translog.id;
                this.adsid = translog.adsid;
                this.itemid = translog.itemid;
                this.shopid = translog.shopid;
                this.operation = translog.operation;
                this.timestamp = translog.timestamp;
                this.client_ip = translog.client_ip;
                this.userid = translog.userid;
                this.price = translog.price;
                this.extinfo = translog.extinfo;
                this.status = translog.status;
                this.acc_before_balance = translog.acc_before_balance;
                this.acc_after_balance = translog.acc_after_balance;
                this.dai_before_balance = translog.dai_before_balance;
                this.dai_after_balance = translog.dai_after_balance;
                this.deviceid = translog.deviceid;
                this.keyword = translog.keyword;
                this.placement = translog.placement;
                this.deduct_unique_id = translog.deduct_unique_id;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder operation(Integer num) {
            this.operation = num;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder client_ip(Long l) {
            this.client_ip = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder acc_before_balance(Long l) {
            this.acc_before_balance = l;
            return this;
        }

        public Builder acc_after_balance(Long l) {
            this.acc_after_balance = l;
            return this;
        }

        public Builder dai_before_balance(Long l) {
            this.dai_before_balance = l;
            return this;
        }

        public Builder dai_after_balance(Long l) {
            this.dai_after_balance = l;
            return this;
        }

        public Builder deviceid(String str) {
            this.deviceid = str;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public Builder deduct_unique_id(Long l) {
            this.deduct_unique_id = l;
            return this;
        }

        public Translog build() {
            return new Translog(this);
        }
    }
}
