package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPriceActivity extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_CURRENT_PRICE = 0L;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Integer DEFAULT_EXPIRY_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final f DEFAULT_HASHED_FINGERPRINT = f.f32736b;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_LOWEST_PRICE = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Boolean DEFAULT_NOTIFICATION_SENT = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_ORIGINAL_PRICE = 0L;
    public static final Integer DEFAULT_SENDER_USERID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Boolean DEFAULT_STOCK_RETURNED = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long current_price;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer expiry_time;
    @ProtoField(tag = 17, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 20, type = Message.Datatype.BYTES)
    public final f hashed_fingerprint;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long lowest_price;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 15, type = Message.Datatype.BOOL)
    public final Boolean notification_sent;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long original_price;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer sender_userid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean stock_returned;

    public SlashPriceActivity(Long l, Integer num, Long l2, Long l3, Integer num2, Long l4, Long l5, Long l6, Long l7, Integer num3, String str, Integer num4, Integer num5, Integer num6, Boolean bool, Boolean bool2, f fVar, Integer num7, Integer num8, f fVar2) {
        this.activity_id = l;
        this.shopid = num;
        this.itemid = l2;
        this.modelid = l3;
        this.sender_userid = num2;
        this.orderid = l4;
        this.original_price = l5;
        this.current_price = l6;
        this.lowest_price = l7;
        this.status = num3;
        this.country = str;
        this.start_time = num4;
        this.end_time = num5;
        this.expiry_time = num6;
        this.notification_sent = bool;
        this.stock_returned = bool2;
        this.extinfo = fVar;
        this.ctime = num7;
        this.mtime = num8;
        this.hashed_fingerprint = fVar2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SlashPriceActivity(com.shopee.protocol.shop.SlashPriceActivity.Builder r24) {
        /*
            r23 = this;
            r0 = r24
            r1 = r23
            java.lang.Long r2 = r0.activity_id
            java.lang.Integer r3 = r0.shopid
            java.lang.Long r4 = r0.itemid
            java.lang.Long r5 = r0.modelid
            java.lang.Integer r6 = r0.sender_userid
            java.lang.Long r7 = r0.orderid
            java.lang.Long r8 = r0.original_price
            java.lang.Long r9 = r0.current_price
            java.lang.Long r10 = r0.lowest_price
            java.lang.Integer r11 = r0.status
            java.lang.String r12 = r0.country
            java.lang.Integer r13 = r0.start_time
            java.lang.Integer r14 = r0.end_time
            java.lang.Integer r15 = r0.expiry_time
            r22 = r1
            java.lang.Boolean r1 = r0.notification_sent
            r16 = r1
            java.lang.Boolean r1 = r0.stock_returned
            r17 = r1
            e.f r1 = r0.extinfo
            r18 = r1
            java.lang.Integer r1 = r0.ctime
            r19 = r1
            java.lang.Integer r1 = r0.mtime
            r20 = r1
            e.f r1 = r0.hashed_fingerprint
            r21 = r1
            r1 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r23.setBuilder(r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.SlashPriceActivity.<init>(com.shopee.protocol.shop.SlashPriceActivity$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceActivity)) {
            return false;
        }
        SlashPriceActivity slashPriceActivity = (SlashPriceActivity) obj;
        if (!equals((Object) this.activity_id, (Object) slashPriceActivity.activity_id) || !equals((Object) this.shopid, (Object) slashPriceActivity.shopid) || !equals((Object) this.itemid, (Object) slashPriceActivity.itemid) || !equals((Object) this.modelid, (Object) slashPriceActivity.modelid) || !equals((Object) this.sender_userid, (Object) slashPriceActivity.sender_userid) || !equals((Object) this.orderid, (Object) slashPriceActivity.orderid) || !equals((Object) this.original_price, (Object) slashPriceActivity.original_price) || !equals((Object) this.current_price, (Object) slashPriceActivity.current_price) || !equals((Object) this.lowest_price, (Object) slashPriceActivity.lowest_price) || !equals((Object) this.status, (Object) slashPriceActivity.status) || !equals((Object) this.country, (Object) slashPriceActivity.country) || !equals((Object) this.start_time, (Object) slashPriceActivity.start_time) || !equals((Object) this.end_time, (Object) slashPriceActivity.end_time) || !equals((Object) this.expiry_time, (Object) slashPriceActivity.expiry_time) || !equals((Object) this.notification_sent, (Object) slashPriceActivity.notification_sent) || !equals((Object) this.stock_returned, (Object) slashPriceActivity.stock_returned) || !equals((Object) this.extinfo, (Object) slashPriceActivity.extinfo) || !equals((Object) this.ctime, (Object) slashPriceActivity.ctime) || !equals((Object) this.mtime, (Object) slashPriceActivity.mtime) || !equals((Object) this.hashed_fingerprint, (Object) slashPriceActivity.hashed_fingerprint)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.activity_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.modelid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.sender_userid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l4 = this.orderid;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.original_price;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.current_price;
        int hashCode8 = (hashCode7 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.lowest_price;
        int hashCode9 = (hashCode8 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode11 = (hashCode10 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.start_time;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.end_time;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.expiry_time;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool = this.notification_sent;
        int hashCode15 = (hashCode14 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.stock_returned;
        int hashCode16 = (hashCode15 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode17 = (hashCode16 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num7 = this.ctime;
        int hashCode18 = (hashCode17 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.mtime;
        int hashCode19 = (hashCode18 + (num8 != null ? num8.hashCode() : 0)) * 37;
        f fVar2 = this.hashed_fingerprint;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode19 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceActivity> {
        public Long activity_id;
        public String country;
        public Integer ctime;
        public Long current_price;
        public Integer end_time;
        public Integer expiry_time;
        public f extinfo;
        public f hashed_fingerprint;
        public Long itemid;
        public Long lowest_price;
        public Long modelid;
        public Integer mtime;
        public Boolean notification_sent;
        public Long orderid;
        public Long original_price;
        public Integer sender_userid;
        public Integer shopid;
        public Integer start_time;
        public Integer status;
        public Boolean stock_returned;

        public Builder() {
        }

        public Builder(SlashPriceActivity slashPriceActivity) {
            super(slashPriceActivity);
            if (slashPriceActivity != null) {
                this.activity_id = slashPriceActivity.activity_id;
                this.shopid = slashPriceActivity.shopid;
                this.itemid = slashPriceActivity.itemid;
                this.modelid = slashPriceActivity.modelid;
                this.sender_userid = slashPriceActivity.sender_userid;
                this.orderid = slashPriceActivity.orderid;
                this.original_price = slashPriceActivity.original_price;
                this.current_price = slashPriceActivity.current_price;
                this.lowest_price = slashPriceActivity.lowest_price;
                this.status = slashPriceActivity.status;
                this.country = slashPriceActivity.country;
                this.start_time = slashPriceActivity.start_time;
                this.end_time = slashPriceActivity.end_time;
                this.expiry_time = slashPriceActivity.expiry_time;
                this.notification_sent = slashPriceActivity.notification_sent;
                this.stock_returned = slashPriceActivity.stock_returned;
                this.extinfo = slashPriceActivity.extinfo;
                this.ctime = slashPriceActivity.ctime;
                this.mtime = slashPriceActivity.mtime;
                this.hashed_fingerprint = slashPriceActivity.hashed_fingerprint;
            }
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder sender_userid(Integer num) {
            this.sender_userid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder original_price(Long l) {
            this.original_price = l;
            return this;
        }

        public Builder current_price(Long l) {
            this.current_price = l;
            return this;
        }

        public Builder lowest_price(Long l) {
            this.lowest_price = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
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

        public Builder expiry_time(Integer num) {
            this.expiry_time = num;
            return this;
        }

        public Builder notification_sent(Boolean bool) {
            this.notification_sent = bool;
            return this;
        }

        public Builder stock_returned(Boolean bool) {
            this.stock_returned = bool;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
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

        public Builder hashed_fingerprint(f fVar) {
            this.hashed_fingerprint = fVar;
            return this;
        }

        public SlashPriceActivity build() {
            return new SlashPriceActivity(this);
        }
    }
}
