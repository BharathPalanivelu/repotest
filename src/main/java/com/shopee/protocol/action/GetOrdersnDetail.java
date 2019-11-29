package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetOrdersnDetail extends Message {
    public static final String DEFAULT_ORDERSN = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String ordersn;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetOrdersnDetail(String str, String str2) {
        this.requestid = str;
        this.ordersn = str2;
    }

    private GetOrdersnDetail(Builder builder) {
        this(builder.requestid, builder.ordersn);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetOrdersnDetail)) {
            return false;
        }
        GetOrdersnDetail getOrdersnDetail = (GetOrdersnDetail) obj;
        if (!equals((Object) this.requestid, (Object) getOrdersnDetail.requestid) || !equals((Object) this.ordersn, (Object) getOrdersnDetail.ordersn)) {
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
        String str2 = this.ordersn;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetOrdersnDetail> {
        public String ordersn;
        public String requestid;

        public Builder() {
        }

        public Builder(GetOrdersnDetail getOrdersnDetail) {
            super(getOrdersnDetail);
            if (getOrdersnDetail != null) {
                this.requestid = getOrdersnDetail.requestid;
                this.ordersn = getOrdersnDetail.ordersn;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder ordersn(String str) {
            this.ordersn = str;
            return this;
        }

        public GetOrdersnDetail build() {
            checkRequiredFields();
            return new GetOrdersnDetail(this);
        }
    }
}
