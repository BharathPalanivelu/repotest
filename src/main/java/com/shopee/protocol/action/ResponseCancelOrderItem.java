package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCancelOrderItem extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCancelOrderItem(String str, Integer num) {
        this.requestid = str;
        this.errcode = num;
    }

    private ResponseCancelOrderItem(Builder builder) {
        this(builder.requestid, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCancelOrderItem)) {
            return false;
        }
        ResponseCancelOrderItem responseCancelOrderItem = (ResponseCancelOrderItem) obj;
        if (!equals((Object) this.requestid, (Object) responseCancelOrderItem.requestid) || !equals((Object) this.errcode, (Object) responseCancelOrderItem.errcode)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCancelOrderItem> {
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCancelOrderItem responseCancelOrderItem) {
            super(responseCancelOrderItem);
            if (responseCancelOrderItem != null) {
                this.requestid = responseCancelOrderItem.requestid;
                this.errcode = responseCancelOrderItem.errcode;
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

        public ResponseCancelOrderItem build() {
            checkRequiredFields();
            return new ResponseCancelOrderItem(this);
        }
    }
}
