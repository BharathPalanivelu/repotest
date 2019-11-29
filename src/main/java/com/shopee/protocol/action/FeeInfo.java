package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FeeInfo extends Message {
    public static final Long DEFAULT_FEE = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long fee;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public FeeInfo(Integer num, Long l) {
        this.type = num;
        this.fee = l;
    }

    private FeeInfo(Builder builder) {
        this(builder.type, builder.fee);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeeInfo)) {
            return false;
        }
        FeeInfo feeInfo = (FeeInfo) obj;
        if (!equals((Object) this.type, (Object) feeInfo.type) || !equals((Object) this.fee, (Object) feeInfo.fee)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.fee;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FeeInfo> {
        public Long fee;
        public Integer type;

        public Builder() {
        }

        public Builder(FeeInfo feeInfo) {
            super(feeInfo);
            if (feeInfo != null) {
                this.type = feeInfo.type;
                this.fee = feeInfo.fee;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder fee(Long l) {
            this.fee = l;
            return this;
        }

        public FeeInfo build() {
            return new FeeInfo(this);
        }
    }
}
