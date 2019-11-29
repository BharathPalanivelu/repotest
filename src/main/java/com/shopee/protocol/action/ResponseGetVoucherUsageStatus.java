package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseGetVoucherUsageStatus extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public ResponseGetVoucherUsageStatus(String str, Integer num, String str2, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.status = num2;
    }

    private ResponseGetVoucherUsageStatus(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetVoucherUsageStatus)) {
            return false;
        }
        ResponseGetVoucherUsageStatus responseGetVoucherUsageStatus = (ResponseGetVoucherUsageStatus) obj;
        if (!equals((Object) this.requestid, (Object) responseGetVoucherUsageStatus.requestid) || !equals((Object) this.errcode, (Object) responseGetVoucherUsageStatus.errcode) || !equals((Object) this.debug_msg, (Object) responseGetVoucherUsageStatus.debug_msg) || !equals((Object) this.status, (Object) responseGetVoucherUsageStatus.status)) {
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
        String str2 = this.debug_msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetVoucherUsageStatus> {
        public String debug_msg;
        public Integer errcode;
        public String requestid;
        public Integer status;

        public Builder() {
        }

        public Builder(ResponseGetVoucherUsageStatus responseGetVoucherUsageStatus) {
            super(responseGetVoucherUsageStatus);
            if (responseGetVoucherUsageStatus != null) {
                this.requestid = responseGetVoucherUsageStatus.requestid;
                this.errcode = responseGetVoucherUsageStatus.errcode;
                this.debug_msg = responseGetVoucherUsageStatus.debug_msg;
                this.status = responseGetVoucherUsageStatus.status;
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

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public ResponseGetVoucherUsageStatus build() {
            return new ResponseGetVoucherUsageStatus(this);
        }
    }
}
