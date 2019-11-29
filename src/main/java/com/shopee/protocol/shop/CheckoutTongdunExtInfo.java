package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CheckoutTongdunExtInfo extends Message {
    public static final List<Integer> DEFAULT_DECODE_REASON = Collections.emptyList();
    public static final Boolean DEFAULT_SUCCESS = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> decode_reason;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean success;

    public CheckoutTongdunExtInfo(Boolean bool, List<Integer> list) {
        this.success = bool;
        this.decode_reason = immutableCopyOf(list);
    }

    private CheckoutTongdunExtInfo(Builder builder) {
        this(builder.success, builder.decode_reason);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutTongdunExtInfo)) {
            return false;
        }
        CheckoutTongdunExtInfo checkoutTongdunExtInfo = (CheckoutTongdunExtInfo) obj;
        if (!equals((Object) this.success, (Object) checkoutTongdunExtInfo.success) || !equals((List<?>) this.decode_reason, (List<?>) checkoutTongdunExtInfo.decode_reason)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.success;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        List<Integer> list = this.decode_reason;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CheckoutTongdunExtInfo> {
        public List<Integer> decode_reason;
        public Boolean success;

        public Builder() {
        }

        public Builder(CheckoutTongdunExtInfo checkoutTongdunExtInfo) {
            super(checkoutTongdunExtInfo);
            if (checkoutTongdunExtInfo != null) {
                this.success = checkoutTongdunExtInfo.success;
                this.decode_reason = CheckoutTongdunExtInfo.copyOf(checkoutTongdunExtInfo.decode_reason);
            }
        }

        public Builder success(Boolean bool) {
            this.success = bool;
            return this;
        }

        public Builder decode_reason(List<Integer> list) {
            this.decode_reason = checkForNulls(list);
            return this;
        }

        public CheckoutTongdunExtInfo build() {
            return new CheckoutTongdunExtInfo(this);
        }
    }
}
