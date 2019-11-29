package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetDefaultAddress extends Message {
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public SetDefaultAddress(String str, String str2, Integer num) {
        this.requestid = str;
        this.token = str2;
        this.id = num;
    }

    private SetDefaultAddress(Builder builder) {
        this(builder.requestid, builder.token, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetDefaultAddress)) {
            return false;
        }
        SetDefaultAddress setDefaultAddress = (SetDefaultAddress) obj;
        if (!equals((Object) this.requestid, (Object) setDefaultAddress.requestid) || !equals((Object) this.token, (Object) setDefaultAddress.token) || !equals((Object) this.id, (Object) setDefaultAddress.id)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.id;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetDefaultAddress> {
        public Integer id;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetDefaultAddress setDefaultAddress) {
            super(setDefaultAddress);
            if (setDefaultAddress != null) {
                this.requestid = setDefaultAddress.requestid;
                this.token = setDefaultAddress.token;
                this.id = setDefaultAddress.id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public SetDefaultAddress build() {
            checkRequiredFields();
            return new SetDefaultAddress(this);
        }
    }
}
