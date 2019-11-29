package com.shopee.protocol.action;

import com.shopee.protocol.shop.Return;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetReturn extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final Return _return;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetReturn(String str, BackendParam backendParam, Return returnR) {
        this.requestid = str;
        this.bparam = backendParam;
        this._return = returnR;
    }

    private SetReturn(Builder builder) {
        this(builder.requestid, builder.bparam, builder._return);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetReturn)) {
            return false;
        }
        SetReturn setReturn = (SetReturn) obj;
        if (!equals((Object) this.requestid, (Object) setReturn.requestid) || !equals((Object) this.bparam, (Object) setReturn.bparam) || !equals((Object) this._return, (Object) setReturn._return)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Return returnR = this._return;
        if (returnR != null) {
            i2 = returnR.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetReturn> {
        public Return _return;
        public BackendParam bparam;
        public String requestid;

        public Builder() {
        }

        public Builder(SetReturn setReturn) {
            super(setReturn);
            if (setReturn != null) {
                this.requestid = setReturn.requestid;
                this.bparam = setReturn.bparam;
                this._return = setReturn._return;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder _return(Return returnR) {
            this._return = returnR;
            return this;
        }

        public SetReturn build() {
            return new SetReturn(this);
        }
    }
}
