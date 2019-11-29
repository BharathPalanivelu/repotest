package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdvertiseTarget extends Message {
    public static final Long DEFAULT_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long price;

    public AdvertiseTarget(Long l) {
        this.price = l;
    }

    private AdvertiseTarget(Builder builder) {
        this(builder.price);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdvertiseTarget)) {
            return false;
        }
        return equals((Object) this.price, (Object) ((AdvertiseTarget) obj).price);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Long l = this.price;
            i = l != null ? l.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<AdvertiseTarget> {
        public Long price;

        public Builder() {
        }

        public Builder(AdvertiseTarget advertiseTarget) {
            super(advertiseTarget);
            if (advertiseTarget != null) {
                this.price = advertiseTarget.price;
            }
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public AdvertiseTarget build() {
            return new AdvertiseTarget(this);
        }
    }
}
