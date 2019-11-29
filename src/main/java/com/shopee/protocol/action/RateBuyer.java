package com.shopee.protocol.action;

import com.shopee.protocol.shop.UserCmt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RateBuyer extends Message {
    public static final Boolean DEFAULT_IS_RATING_REPLY = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final UserCmt comment;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_rating_reply;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public RateBuyer(String str, Integer num, Long l, UserCmt userCmt, String str2, Boolean bool) {
        this.requestid = str;
        this.shopid = num;
        this.orderid = l;
        this.comment = userCmt;
        this.token = str2;
        this.is_rating_reply = bool;
    }

    private RateBuyer(Builder builder) {
        this(builder.requestid, builder.shopid, builder.orderid, builder.comment, builder.token, builder.is_rating_reply);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RateBuyer)) {
            return false;
        }
        RateBuyer rateBuyer = (RateBuyer) obj;
        if (!equals((Object) this.requestid, (Object) rateBuyer.requestid) || !equals((Object) this.shopid, (Object) rateBuyer.shopid) || !equals((Object) this.orderid, (Object) rateBuyer.orderid) || !equals((Object) this.comment, (Object) rateBuyer.comment) || !equals((Object) this.token, (Object) rateBuyer.token) || !equals((Object) this.is_rating_reply, (Object) rateBuyer.is_rating_reply)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        UserCmt userCmt = this.comment;
        int hashCode4 = (hashCode3 + (userCmt != null ? userCmt.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.is_rating_reply;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RateBuyer> {
        public UserCmt comment;
        public Boolean is_rating_reply;
        public Long orderid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(RateBuyer rateBuyer) {
            super(rateBuyer);
            if (rateBuyer != null) {
                this.requestid = rateBuyer.requestid;
                this.shopid = rateBuyer.shopid;
                this.orderid = rateBuyer.orderid;
                this.comment = rateBuyer.comment;
                this.token = rateBuyer.token;
                this.is_rating_reply = rateBuyer.is_rating_reply;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder comment(UserCmt userCmt) {
            this.comment = userCmt;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder is_rating_reply(Boolean bool) {
            this.is_rating_reply = bool;
            return this;
        }

        public RateBuyer build() {
            return new RateBuyer(this);
        }
    }
}
