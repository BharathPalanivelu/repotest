package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetUserCmt extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetUserCmt(String str, String str2, Boolean bool, Long l, Long l2) {
        this.requestid = str;
        this.token = str2;
        this.is_seller = bool;
        this.cmtid = l;
        this.orderid = l2;
    }

    private GetUserCmt(Builder builder) {
        this(builder.requestid, builder.token, builder.is_seller, builder.cmtid, builder.orderid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUserCmt)) {
            return false;
        }
        GetUserCmt getUserCmt = (GetUserCmt) obj;
        if (!equals((Object) this.requestid, (Object) getUserCmt.requestid) || !equals((Object) this.token, (Object) getUserCmt.token) || !equals((Object) this.is_seller, (Object) getUserCmt.is_seller) || !equals((Object) this.cmtid, (Object) getUserCmt.cmtid) || !equals((Object) this.orderid, (Object) getUserCmt.orderid)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.is_seller;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.cmtid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetUserCmt> {
        public Long cmtid;
        public Boolean is_seller;
        public Long orderid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetUserCmt getUserCmt) {
            super(getUserCmt);
            if (getUserCmt != null) {
                this.requestid = getUserCmt.requestid;
                this.token = getUserCmt.token;
                this.is_seller = getUserCmt.is_seller;
                this.cmtid = getUserCmt.cmtid;
                this.orderid = getUserCmt.orderid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder is_seller(Boolean bool) {
            this.is_seller = bool;
            return this;
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public GetUserCmt build() {
            return new GetUserCmt(this);
        }
    }
}
