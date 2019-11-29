package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SellerDiscount extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public SellerDiscount(Long l, Integer num, Integer num2, String str, Integer num3, String str2, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, f fVar) {
        this.promotionid = l;
        this.userid = num;
        this.shopid = num2;
        this.country = str;
        this.status = num3;
        this.title = str2;
        this.start_time = num4;
        this.end_time = num5;
        this.ctime = num6;
        this.mtime = num7;
        this.source = num8;
        this.extinfo = fVar;
    }

    private SellerDiscount(Builder builder) {
        this(builder.promotionid, builder.userid, builder.shopid, builder.country, builder.status, builder.title, builder.start_time, builder.end_time, builder.ctime, builder.mtime, builder.source, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerDiscount)) {
            return false;
        }
        SellerDiscount sellerDiscount = (SellerDiscount) obj;
        if (!equals((Object) this.promotionid, (Object) sellerDiscount.promotionid) || !equals((Object) this.userid, (Object) sellerDiscount.userid) || !equals((Object) this.shopid, (Object) sellerDiscount.shopid) || !equals((Object) this.country, (Object) sellerDiscount.country) || !equals((Object) this.status, (Object) sellerDiscount.status) || !equals((Object) this.title, (Object) sellerDiscount.title) || !equals((Object) this.start_time, (Object) sellerDiscount.start_time) || !equals((Object) this.end_time, (Object) sellerDiscount.end_time) || !equals((Object) this.ctime, (Object) sellerDiscount.ctime) || !equals((Object) this.mtime, (Object) sellerDiscount.mtime) || !equals((Object) this.source, (Object) sellerDiscount.source) || !equals((Object) this.extinfo, (Object) sellerDiscount.extinfo)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.title;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.start_time;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.end_time;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode9 = (hashCode8 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode10 = (hashCode9 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.source;
        int hashCode11 = (hashCode10 + (num8 != null ? num8.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerDiscount> {
        public String country;
        public Integer ctime;
        public Integer end_time;
        public f extinfo;
        public Integer mtime;
        public Long promotionid;
        public Integer shopid;
        public Integer source;
        public Integer start_time;
        public Integer status;
        public String title;
        public Integer userid;

        public Builder() {
        }

        public Builder(SellerDiscount sellerDiscount) {
            super(sellerDiscount);
            if (sellerDiscount != null) {
                this.promotionid = sellerDiscount.promotionid;
                this.userid = sellerDiscount.userid;
                this.shopid = sellerDiscount.shopid;
                this.country = sellerDiscount.country;
                this.status = sellerDiscount.status;
                this.title = sellerDiscount.title;
                this.start_time = sellerDiscount.start_time;
                this.end_time = sellerDiscount.end_time;
                this.ctime = sellerDiscount.ctime;
                this.mtime = sellerDiscount.mtime;
                this.source = sellerDiscount.source;
                this.extinfo = sellerDiscount.extinfo;
            }
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
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

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public SellerDiscount build() {
            return new SellerDiscount(this);
        }
    }
}
