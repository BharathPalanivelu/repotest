package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseSetAddrTax extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetAddrTax(String str, Integer num) {
        this.requestid = str;
        this.errcode = num;
    }

    private ResponseSetAddrTax(Builder builder) {
        this(builder.requestid, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetAddrTax)) {
            return false;
        }
        ResponseSetAddrTax responseSetAddrTax = (ResponseSetAddrTax) obj;
        if (!equals((Object) this.requestid, (Object) responseSetAddrTax.requestid) || !equals((Object) this.errcode, (Object) responseSetAddrTax.errcode)) {
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

    public static final class Builder extends Message.Builder<ResponseSetAddrTax> {
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetAddrTax responseSetAddrTax) {
            super(responseSetAddrTax);
            if (responseSetAddrTax != null) {
                this.requestid = responseSetAddrTax.requestid;
                this.errcode = responseSetAddrTax.errcode;
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

        public ResponseSetAddrTax build() {
            return new ResponseSetAddrTax(this);
        }
    }
}
