package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OfferCount extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public OfferCount(Integer num, Integer num2) {
        this.userid = num;
        this.count = num2;
    }

    private OfferCount(Builder builder) {
        this(builder.userid, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OfferCount)) {
            return false;
        }
        OfferCount offerCount = (OfferCount) obj;
        if (!equals((Object) this.userid, (Object) offerCount.userid) || !equals((Object) this.count, (Object) offerCount.count)) {
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
        Integer num2 = this.count;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OfferCount> {
        public Integer count;
        public Integer userid;

        public Builder() {
        }

        public Builder(OfferCount offerCount) {
            super(offerCount);
            if (offerCount != null) {
                this.userid = offerCount.userid;
                this.count = offerCount.count;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public OfferCount build() {
            return new OfferCount(this);
        }
    }
}
