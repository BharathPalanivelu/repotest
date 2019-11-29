package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetTransfee extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetTransfee(String str, Long l) {
        this.requestid = str;
        this.amount = l;
    }

    private GetTransfee(Builder builder) {
        this(builder.requestid, builder.amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTransfee)) {
            return false;
        }
        GetTransfee getTransfee = (GetTransfee) obj;
        if (!equals((Object) this.requestid, (Object) getTransfee.requestid) || !equals((Object) this.amount, (Object) getTransfee.amount)) {
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
        Long l = this.amount;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetTransfee> {
        public Long amount;
        public String requestid;

        public Builder() {
        }

        public Builder(GetTransfee getTransfee) {
            super(getTransfee);
            if (getTransfee != null) {
                this.requestid = getTransfee.requestid;
                this.amount = getTransfee.amount;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public GetTransfee build() {
            checkRequiredFields();
            return new GetTransfee(this);
        }
    }
}
