package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FraudInfo extends Message {
    public static final Integer DEFAULT_FRAUD_LEVEL = 0;
    public static final String DEFAULT_FRAUD_MESSAGE = "";
    public static final Integer DEFAULT_FRAUD_REASON = 0;
    public static final Integer DEFAULT_FRAUD_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer fraud_level;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String fraud_message;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer fraud_reason;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer fraud_type;

    public FraudInfo(Integer num, Integer num2, Integer num3, String str) {
        this.fraud_type = num;
        this.fraud_level = num2;
        this.fraud_reason = num3;
        this.fraud_message = str;
    }

    private FraudInfo(Builder builder) {
        this(builder.fraud_type, builder.fraud_level, builder.fraud_reason, builder.fraud_message);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FraudInfo)) {
            return false;
        }
        FraudInfo fraudInfo = (FraudInfo) obj;
        if (!equals((Object) this.fraud_type, (Object) fraudInfo.fraud_type) || !equals((Object) this.fraud_level, (Object) fraudInfo.fraud_level) || !equals((Object) this.fraud_reason, (Object) fraudInfo.fraud_reason) || !equals((Object) this.fraud_message, (Object) fraudInfo.fraud_message)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.fraud_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.fraud_level;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.fraud_reason;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.fraud_message;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FraudInfo> {
        public Integer fraud_level;
        public String fraud_message;
        public Integer fraud_reason;
        public Integer fraud_type;

        public Builder() {
        }

        public Builder(FraudInfo fraudInfo) {
            super(fraudInfo);
            if (fraudInfo != null) {
                this.fraud_type = fraudInfo.fraud_type;
                this.fraud_level = fraudInfo.fraud_level;
                this.fraud_reason = fraudInfo.fraud_reason;
                this.fraud_message = fraudInfo.fraud_message;
            }
        }

        public Builder fraud_type(Integer num) {
            this.fraud_type = num;
            return this;
        }

        public Builder fraud_level(Integer num) {
            this.fraud_level = num;
            return this;
        }

        public Builder fraud_reason(Integer num) {
            this.fraud_reason = num;
            return this;
        }

        public Builder fraud_message(String str) {
            this.fraud_message = str;
            return this;
        }

        public FraudInfo build() {
            return new FraudInfo(this);
        }
    }
}
