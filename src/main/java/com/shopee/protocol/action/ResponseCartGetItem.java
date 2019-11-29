package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCartGetItem extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3)
    public final CartItemInfo iteminfo;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCartGetItem(String str, Integer num, CartItemInfo cartItemInfo) {
        this.requestid = str;
        this.errcode = num;
        this.iteminfo = cartItemInfo;
    }

    private ResponseCartGetItem(Builder builder) {
        this(builder.requestid, builder.errcode, builder.iteminfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCartGetItem)) {
            return false;
        }
        ResponseCartGetItem responseCartGetItem = (ResponseCartGetItem) obj;
        if (!equals((Object) this.requestid, (Object) responseCartGetItem.requestid) || !equals((Object) this.errcode, (Object) responseCartGetItem.errcode) || !equals((Object) this.iteminfo, (Object) responseCartGetItem.iteminfo)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        CartItemInfo cartItemInfo = this.iteminfo;
        if (cartItemInfo != null) {
            i2 = cartItemInfo.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCartGetItem> {
        public Integer errcode;
        public CartItemInfo iteminfo;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCartGetItem responseCartGetItem) {
            super(responseCartGetItem);
            if (responseCartGetItem != null) {
                this.requestid = responseCartGetItem.requestid;
                this.errcode = responseCartGetItem.errcode;
                this.iteminfo = responseCartGetItem.iteminfo;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder iteminfo(CartItemInfo cartItemInfo) {
            this.iteminfo = cartItemInfo;
            return this;
        }

        public ResponseCartGetItem build() {
            checkRequiredFields();
            return new ResponseCartGetItem(this);
        }
    }
}
