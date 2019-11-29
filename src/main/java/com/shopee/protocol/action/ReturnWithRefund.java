package com.shopee.protocol.action;

import com.shopee.protocol.shop.Refund;
import com.shopee.protocol.shop.Return;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReturnWithRefund extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Return _return;
    @ProtoField(tag = 2)
    public final Refund refund;

    public ReturnWithRefund(Return returnR, Refund refund2) {
        this._return = returnR;
        this.refund = refund2;
    }

    private ReturnWithRefund(Builder builder) {
        this(builder._return, builder.refund);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReturnWithRefund)) {
            return false;
        }
        ReturnWithRefund returnWithRefund = (ReturnWithRefund) obj;
        if (!equals((Object) this._return, (Object) returnWithRefund._return) || !equals((Object) this.refund, (Object) returnWithRefund.refund)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Return returnR = this._return;
        int i2 = 0;
        int hashCode = (returnR != null ? returnR.hashCode() : 0) * 37;
        Refund refund2 = this.refund;
        if (refund2 != null) {
            i2 = refund2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReturnWithRefund> {
        public Return _return;
        public Refund refund;

        public Builder() {
        }

        public Builder(ReturnWithRefund returnWithRefund) {
            super(returnWithRefund);
            if (returnWithRefund != null) {
                this._return = returnWithRefund._return;
                this.refund = returnWithRefund.refund;
            }
        }

        public Builder _return(Return returnR) {
            this._return = returnR;
            return this;
        }

        public Builder refund(Refund refund2) {
            this.refund = refund2;
            return this;
        }

        public ReturnWithRefund build() {
            return new ReturnWithRefund(this);
        }
    }
}
