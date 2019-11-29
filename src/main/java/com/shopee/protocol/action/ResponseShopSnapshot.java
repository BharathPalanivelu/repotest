package com.shopee.protocol.action;

import com.shopee.protocol.shop.ShopSnapshot;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseShopSnapshot extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3)
    public final ShopSnapshot snapshot;

    public ResponseShopSnapshot(String str, Integer num, ShopSnapshot shopSnapshot) {
        this.requestid = str;
        this.errcode = num;
        this.snapshot = shopSnapshot;
    }

    private ResponseShopSnapshot(Builder builder) {
        this(builder.requestid, builder.errcode, builder.snapshot);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseShopSnapshot)) {
            return false;
        }
        ResponseShopSnapshot responseShopSnapshot = (ResponseShopSnapshot) obj;
        if (!equals((Object) this.requestid, (Object) responseShopSnapshot.requestid) || !equals((Object) this.errcode, (Object) responseShopSnapshot.errcode) || !equals((Object) this.snapshot, (Object) responseShopSnapshot.snapshot)) {
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
        ShopSnapshot shopSnapshot = this.snapshot;
        if (shopSnapshot != null) {
            i2 = shopSnapshot.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseShopSnapshot> {
        public Integer errcode;
        public String requestid;
        public ShopSnapshot snapshot;

        public Builder() {
        }

        public Builder(ResponseShopSnapshot responseShopSnapshot) {
            super(responseShopSnapshot);
            if (responseShopSnapshot != null) {
                this.requestid = responseShopSnapshot.requestid;
                this.errcode = responseShopSnapshot.errcode;
                this.snapshot = responseShopSnapshot.snapshot;
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

        public Builder snapshot(ShopSnapshot shopSnapshot) {
            this.snapshot = shopSnapshot;
            return this;
        }

        public ResponseShopSnapshot build() {
            checkRequiredFields();
            return new ResponseShopSnapshot(this);
        }
    }
}
