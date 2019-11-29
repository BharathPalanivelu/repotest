package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCheckoutId extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCheckoutId(String str) {
        this.requestid = str;
    }

    private GetCheckoutId(Builder builder) {
        this(builder.requestid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCheckoutId)) {
            return false;
        }
        return equals((Object) this.requestid, (Object) ((GetCheckoutId) obj).requestid);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.requestid;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<GetCheckoutId> {
        public String requestid;

        public Builder() {
        }

        public Builder(GetCheckoutId getCheckoutId) {
            super(getCheckoutId);
            if (getCheckoutId != null) {
                this.requestid = getCheckoutId.requestid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public GetCheckoutId build() {
            return new GetCheckoutId(this);
        }
    }
}
