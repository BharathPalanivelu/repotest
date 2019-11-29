package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseValidateGroupBuyOrder extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_INVALID_MESSAGE_CODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer invalid_message_code;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseValidateGroupBuyOrder(String str, Integer num, Integer num2, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.invalid_message_code = num2;
        this.debug_msg = str2;
    }

    private ResponseValidateGroupBuyOrder(Builder builder) {
        this(builder.requestid, builder.errcode, builder.invalid_message_code, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseValidateGroupBuyOrder)) {
            return false;
        }
        ResponseValidateGroupBuyOrder responseValidateGroupBuyOrder = (ResponseValidateGroupBuyOrder) obj;
        if (!equals((Object) this.requestid, (Object) responseValidateGroupBuyOrder.requestid) || !equals((Object) this.errcode, (Object) responseValidateGroupBuyOrder.errcode) || !equals((Object) this.invalid_message_code, (Object) responseValidateGroupBuyOrder.invalid_message_code) || !equals((Object) this.debug_msg, (Object) responseValidateGroupBuyOrder.debug_msg)) {
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
        Integer num2 = this.invalid_message_code;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseValidateGroupBuyOrder> {
        public String debug_msg;
        public Integer errcode;
        public Integer invalid_message_code;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseValidateGroupBuyOrder responseValidateGroupBuyOrder) {
            super(responseValidateGroupBuyOrder);
            if (responseValidateGroupBuyOrder != null) {
                this.requestid = responseValidateGroupBuyOrder.requestid;
                this.errcode = responseValidateGroupBuyOrder.errcode;
                this.invalid_message_code = responseValidateGroupBuyOrder.invalid_message_code;
                this.debug_msg = responseValidateGroupBuyOrder.debug_msg;
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

        public Builder invalid_message_code(Integer num) {
            this.invalid_message_code = num;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponseValidateGroupBuyOrder build() {
            return new ResponseValidateGroupBuyOrder(this);
        }
    }
}
