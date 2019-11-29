package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetOrdersnHint extends Message {
    public static final String DEFAULT_ORDERSN_PREFIX = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String ordersn_prefix;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetOrdersnHint(String str, String str2) {
        this.requestid = str;
        this.ordersn_prefix = str2;
    }

    private GetOrdersnHint(Builder builder) {
        this(builder.requestid, builder.ordersn_prefix);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetOrdersnHint)) {
            return false;
        }
        GetOrdersnHint getOrdersnHint = (GetOrdersnHint) obj;
        if (!equals((Object) this.requestid, (Object) getOrdersnHint.requestid) || !equals((Object) this.ordersn_prefix, (Object) getOrdersnHint.ordersn_prefix)) {
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
        String str2 = this.ordersn_prefix;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetOrdersnHint> {
        public String ordersn_prefix;
        public String requestid;

        public Builder() {
        }

        public Builder(GetOrdersnHint getOrdersnHint) {
            super(getOrdersnHint);
            if (getOrdersnHint != null) {
                this.requestid = getOrdersnHint.requestid;
                this.ordersn_prefix = getOrdersnHint.ordersn_prefix;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder ordersn_prefix(String str) {
            this.ordersn_prefix = str;
            return this;
        }

        public GetOrdersnHint build() {
            return new GetOrdersnHint(this);
        }
    }
}
