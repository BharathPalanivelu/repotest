package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetItemCmt extends Message {
    public static final Integer DEFAULT_APP_VERSION_CODE = 0;
    public static final Long DEFAULT_CMTID = 0L;
    public static final Boolean DEFAULT_GET_BUYER_RATING = false;
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer app_version_code;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean get_buyer_rating;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetItemCmt(String str, String str2, Boolean bool, Long l, Long l2, Boolean bool2, Integer num, Integer num2) {
        this.requestid = str;
        this.token = str2;
        this.is_seller = bool;
        this.cmtid = l;
        this.orderid = l2;
        this.get_buyer_rating = bool2;
        this.app_version_code = num;
        this.shopid = num2;
    }

    private GetItemCmt(Builder builder) {
        this(builder.requestid, builder.token, builder.is_seller, builder.cmtid, builder.orderid, builder.get_buyer_rating, builder.app_version_code, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetItemCmt)) {
            return false;
        }
        GetItemCmt getItemCmt = (GetItemCmt) obj;
        if (!equals((Object) this.requestid, (Object) getItemCmt.requestid) || !equals((Object) this.token, (Object) getItemCmt.token) || !equals((Object) this.is_seller, (Object) getItemCmt.is_seller) || !equals((Object) this.cmtid, (Object) getItemCmt.cmtid) || !equals((Object) this.orderid, (Object) getItemCmt.orderid) || !equals((Object) this.get_buyer_rating, (Object) getItemCmt.get_buyer_rating) || !equals((Object) this.app_version_code, (Object) getItemCmt.app_version_code) || !equals((Object) this.shopid, (Object) getItemCmt.shopid)) {
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
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool2 = this.get_buyer_rating;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num = this.app_version_code;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetItemCmt> {
        public Integer app_version_code;
        public Long cmtid;
        public Boolean get_buyer_rating;
        public Boolean is_seller;
        public Long orderid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(GetItemCmt getItemCmt) {
            super(getItemCmt);
            if (getItemCmt != null) {
                this.requestid = getItemCmt.requestid;
                this.token = getItemCmt.token;
                this.is_seller = getItemCmt.is_seller;
                this.cmtid = getItemCmt.cmtid;
                this.orderid = getItemCmt.orderid;
                this.get_buyer_rating = getItemCmt.get_buyer_rating;
                this.app_version_code = getItemCmt.app_version_code;
                this.shopid = getItemCmt.shopid;
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

        public Builder get_buyer_rating(Boolean bool) {
            this.get_buyer_rating = bool;
            return this;
        }

        public Builder app_version_code(Integer num) {
            this.app_version_code = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public GetItemCmt build() {
            return new GetItemCmt(this);
        }
    }
}
