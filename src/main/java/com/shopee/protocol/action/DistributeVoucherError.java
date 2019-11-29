package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DistributeVoucherError extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public DistributeVoucherError(Integer num, Integer num2) {
        this.userid = num;
        this.errcode = num2;
    }

    private DistributeVoucherError(Builder builder) {
        this(builder.userid, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DistributeVoucherError)) {
            return false;
        }
        DistributeVoucherError distributeVoucherError = (DistributeVoucherError) obj;
        if (!equals((Object) this.userid, (Object) distributeVoucherError.userid) || !equals((Object) this.errcode, (Object) distributeVoucherError.errcode)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.errcode;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DistributeVoucherError> {
        public Integer errcode;
        public Integer userid;

        public Builder() {
        }

        public Builder(DistributeVoucherError distributeVoucherError) {
            super(distributeVoucherError);
            if (distributeVoucherError != null) {
                this.userid = distributeVoucherError.userid;
                this.errcode = distributeVoucherError.errcode;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public DistributeVoucherError build() {
            return new DistributeVoucherError(this);
        }
    }
}
