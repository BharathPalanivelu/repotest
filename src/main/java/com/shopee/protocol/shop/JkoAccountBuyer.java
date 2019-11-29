package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class JkoAccountBuyer extends Message {
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_KYC_STATUS = 0;
    public static final String DEFAULT_PHONE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer kyc_status;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String phone;

    public JkoAccountBuyer(String str, String str2, Integer num, String str3) {
        this.id = str;
        this.key = str2;
        this.kyc_status = num;
        this.phone = str3;
    }

    private JkoAccountBuyer(Builder builder) {
        this(builder.id, builder.key, builder.kyc_status, builder.phone);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JkoAccountBuyer)) {
            return false;
        }
        JkoAccountBuyer jkoAccountBuyer = (JkoAccountBuyer) obj;
        if (!equals((Object) this.id, (Object) jkoAccountBuyer.id) || !equals((Object) this.key, (Object) jkoAccountBuyer.key) || !equals((Object) this.kyc_status, (Object) jkoAccountBuyer.kyc_status) || !equals((Object) this.phone, (Object) jkoAccountBuyer.phone)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.kyc_status;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.phone;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<JkoAccountBuyer> {
        public String id;
        public String key;
        public Integer kyc_status;
        public String phone;

        public Builder() {
        }

        public Builder(JkoAccountBuyer jkoAccountBuyer) {
            super(jkoAccountBuyer);
            if (jkoAccountBuyer != null) {
                this.id = jkoAccountBuyer.id;
                this.key = jkoAccountBuyer.key;
                this.kyc_status = jkoAccountBuyer.kyc_status;
                this.phone = jkoAccountBuyer.phone;
            }
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder kyc_status(Integer num) {
            this.kyc_status = num;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public JkoAccountBuyer build() {
            return new JkoAccountBuyer(this);
        }
    }
}
