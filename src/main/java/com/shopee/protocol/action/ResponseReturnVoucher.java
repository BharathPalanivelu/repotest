package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseReturnVoucher extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseReturnVoucher(String str, Integer num, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
    }

    private ResponseReturnVoucher(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseReturnVoucher)) {
            return false;
        }
        ResponseReturnVoucher responseReturnVoucher = (ResponseReturnVoucher) obj;
        if (!equals((Object) this.requestid, (Object) responseReturnVoucher.requestid) || !equals((Object) this.errcode, (Object) responseReturnVoucher.errcode) || !equals((Object) this.debug_msg, (Object) responseReturnVoucher.debug_msg)) {
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
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseReturnVoucher> {
        public String debug_msg;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseReturnVoucher responseReturnVoucher) {
            super(responseReturnVoucher);
            if (responseReturnVoucher != null) {
                this.requestid = responseReturnVoucher.requestid;
                this.errcode = responseReturnVoucher.errcode;
                this.debug_msg = responseReturnVoucher.debug_msg;
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

        public ResponseReturnVoucher build() {
            return new ResponseReturnVoucher(this);
        }
    }
}
