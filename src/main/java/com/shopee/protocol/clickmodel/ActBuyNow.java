package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActBuyNow extends Message {
    public static final Integer DEFAULT_BUYER_ID = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_SHOPID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer buyer_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long shopid;

    public ActBuyNow(Long l, Long l2, Integer num) {
        this.shopid = l;
        this.itemid = l2;
        this.buyer_id = num;
    }

    private ActBuyNow(Builder builder) {
        this(builder.shopid, builder.itemid, builder.buyer_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActBuyNow)) {
            return false;
        }
        ActBuyNow actBuyNow = (ActBuyNow) obj;
        if (!equals((Object) this.shopid, (Object) actBuyNow.shopid) || !equals((Object) this.itemid, (Object) actBuyNow.itemid) || !equals((Object) this.buyer_id, (Object) actBuyNow.buyer_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.shopid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.itemid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.buyer_id;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActBuyNow> {
        public Integer buyer_id;
        public Long itemid;
        public Long shopid;

        public Builder() {
        }

        public Builder(ActBuyNow actBuyNow) {
            super(actBuyNow);
            if (actBuyNow != null) {
                this.shopid = actBuyNow.shopid;
                this.itemid = actBuyNow.itemid;
                this.buyer_id = actBuyNow.buyer_id;
            }
        }

        public Builder shopid(Long l) {
            this.shopid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder buyer_id(Integer num) {
            this.buyer_id = num;
            return this;
        }

        public ActBuyNow build() {
            return new ActBuyNow(this);
        }
    }
}
