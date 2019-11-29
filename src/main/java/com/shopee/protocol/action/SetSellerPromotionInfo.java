package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetSellerPromotionInfo extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Boolean DEFAULT_IS_DEL = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean is_del;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer userid;

    public SetSellerPromotionInfo(String str, Long l, Boolean bool, Integer num, Integer num2, Integer num3, Integer num4, String str2, Integer num5, String str3, String str4) {
        this.requestid = str;
        this.promotionid = l;
        this.is_del = bool;
        this.start_time = num;
        this.end_time = num2;
        this.userid = num3;
        this.shopid = num4;
        this.country = str2;
        this.status = num5;
        this.title = str3;
        this.token = str4;
    }

    private SetSellerPromotionInfo(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.is_del, builder.start_time, builder.end_time, builder.userid, builder.shopid, builder.country, builder.status, builder.title, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetSellerPromotionInfo)) {
            return false;
        }
        SetSellerPromotionInfo setSellerPromotionInfo = (SetSellerPromotionInfo) obj;
        if (!equals((Object) this.requestid, (Object) setSellerPromotionInfo.requestid) || !equals((Object) this.promotionid, (Object) setSellerPromotionInfo.promotionid) || !equals((Object) this.is_del, (Object) setSellerPromotionInfo.is_del) || !equals((Object) this.start_time, (Object) setSellerPromotionInfo.start_time) || !equals((Object) this.end_time, (Object) setSellerPromotionInfo.end_time) || !equals((Object) this.userid, (Object) setSellerPromotionInfo.userid) || !equals((Object) this.shopid, (Object) setSellerPromotionInfo.shopid) || !equals((Object) this.country, (Object) setSellerPromotionInfo.country) || !equals((Object) this.status, (Object) setSellerPromotionInfo.status) || !equals((Object) this.title, (Object) setSellerPromotionInfo.title) || !equals((Object) this.token, (Object) setSellerPromotionInfo.token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.is_del;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.start_time;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_time;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.shopid;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str3 = this.title;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.token;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetSellerPromotionInfo> {
        public String country;
        public Integer end_time;
        public Boolean is_del;
        public Long promotionid;
        public String requestid;
        public Integer shopid;
        public Integer start_time;
        public Integer status;
        public String title;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(SetSellerPromotionInfo setSellerPromotionInfo) {
            super(setSellerPromotionInfo);
            if (setSellerPromotionInfo != null) {
                this.requestid = setSellerPromotionInfo.requestid;
                this.promotionid = setSellerPromotionInfo.promotionid;
                this.is_del = setSellerPromotionInfo.is_del;
                this.start_time = setSellerPromotionInfo.start_time;
                this.end_time = setSellerPromotionInfo.end_time;
                this.userid = setSellerPromotionInfo.userid;
                this.shopid = setSellerPromotionInfo.shopid;
                this.country = setSellerPromotionInfo.country;
                this.status = setSellerPromotionInfo.status;
                this.title = setSellerPromotionInfo.title;
                this.token = setSellerPromotionInfo.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder is_del(Boolean bool) {
            this.is_del = bool;
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public SetSellerPromotionInfo build() {
            return new SetSellerPromotionInfo(this);
        }
    }
}
