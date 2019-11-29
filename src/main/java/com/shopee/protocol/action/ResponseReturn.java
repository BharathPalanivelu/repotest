package com.shopee.protocol.action;

import com.shopee.protocol.shop.Return;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseReturn extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final Return _return;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseReturn(String str, Integer num, Return returnR) {
        this.requestid = str;
        this.errcode = num;
        this._return = returnR;
    }

    private ResponseReturn(Builder builder) {
        this(builder.requestid, builder.errcode, builder._return);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseReturn)) {
            return false;
        }
        ResponseReturn responseReturn = (ResponseReturn) obj;
        if (!equals((Object) this.requestid, (Object) responseReturn.requestid) || !equals((Object) this.errcode, (Object) responseReturn.errcode) || !equals((Object) this._return, (Object) responseReturn._return)) {
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
        Return returnR = this._return;
        if (returnR != null) {
            i2 = returnR.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseReturn> {
        public Return _return;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseReturn responseReturn) {
            super(responseReturn);
            if (responseReturn != null) {
                this.requestid = responseReturn.requestid;
                this.errcode = responseReturn.errcode;
                this._return = responseReturn._return;
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

        public Builder _return(Return returnR) {
            this._return = returnR;
            return this;
        }

        public ResponseReturn build() {
            checkRequiredFields();
            return new ResponseReturn(this);
        }
    }
}
