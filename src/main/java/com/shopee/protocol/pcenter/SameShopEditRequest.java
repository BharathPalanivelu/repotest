package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SameShopEditRequest extends Message {
    public static final Integer DEFAULT_MAIN_CAT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TARGET_SHOPID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer main_cat;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String target_shopid;

    public SameShopEditRequest(RequestHeader requestHeader, Integer num, Integer num2, String str, Integer num3, Integer num4) {
        this.header = requestHeader;
        this.shopid = num;
        this.source = num2;
        this.target_shopid = str;
        this.main_cat = num3;
        this.status = num4;
    }

    private SameShopEditRequest(Builder builder) {
        this(builder.header, builder.shopid, builder.source, builder.target_shopid, builder.main_cat, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SameShopEditRequest)) {
            return false;
        }
        SameShopEditRequest sameShopEditRequest = (SameShopEditRequest) obj;
        if (!equals((Object) this.header, (Object) sameShopEditRequest.header) || !equals((Object) this.shopid, (Object) sameShopEditRequest.shopid) || !equals((Object) this.source, (Object) sameShopEditRequest.source) || !equals((Object) this.target_shopid, (Object) sameShopEditRequest.target_shopid) || !equals((Object) this.main_cat, (Object) sameShopEditRequest.main_cat) || !equals((Object) this.status, (Object) sameShopEditRequest.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.source;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.target_shopid;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.main_cat;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SameShopEditRequest> {
        public RequestHeader header;
        public Integer main_cat;
        public Integer shopid;
        public Integer source;
        public Integer status;
        public String target_shopid;

        public Builder() {
        }

        public Builder(SameShopEditRequest sameShopEditRequest) {
            super(sameShopEditRequest);
            if (sameShopEditRequest != null) {
                this.header = sameShopEditRequest.header;
                this.shopid = sameShopEditRequest.shopid;
                this.source = sameShopEditRequest.source;
                this.target_shopid = sameShopEditRequest.target_shopid;
                this.main_cat = sameShopEditRequest.main_cat;
                this.status = sameShopEditRequest.status;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder target_shopid(String str) {
            this.target_shopid = str;
            return this;
        }

        public Builder main_cat(Integer num) {
            this.main_cat = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public SameShopEditRequest build() {
            return new SameShopEditRequest(this);
        }
    }
}
