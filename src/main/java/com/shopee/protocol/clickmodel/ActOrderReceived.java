package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActOrderReceived extends Message {
    public static final Integer DEFAULT_BUYER_ID = 0;
    public static final Integer DEFAULT_ITEMID = 0;
    public static final Long DEFAULT_SHOPID = 0L;
    public static final Boolean DEFAULT_WITH_DISCOUNT = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer buyer_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer itemid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long shopid;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean with_discount;

    public ActOrderReceived(Long l, Integer num, Integer num2, Boolean bool) {
        this.shopid = l;
        this.itemid = num;
        this.buyer_id = num2;
        this.with_discount = bool;
    }

    private ActOrderReceived(Builder builder) {
        this(builder.shopid, builder.itemid, builder.buyer_id, builder.with_discount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActOrderReceived)) {
            return false;
        }
        ActOrderReceived actOrderReceived = (ActOrderReceived) obj;
        if (!equals((Object) this.shopid, (Object) actOrderReceived.shopid) || !equals((Object) this.itemid, (Object) actOrderReceived.itemid) || !equals((Object) this.buyer_id, (Object) actOrderReceived.buyer_id) || !equals((Object) this.with_discount, (Object) actOrderReceived.with_discount)) {
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
        Integer num = this.itemid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.buyer_id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.with_discount;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActOrderReceived> {
        public Integer buyer_id;
        public Integer itemid;
        public Long shopid;
        public Boolean with_discount;

        public Builder() {
        }

        public Builder(ActOrderReceived actOrderReceived) {
            super(actOrderReceived);
            if (actOrderReceived != null) {
                this.shopid = actOrderReceived.shopid;
                this.itemid = actOrderReceived.itemid;
                this.buyer_id = actOrderReceived.buyer_id;
                this.with_discount = actOrderReceived.with_discount;
            }
        }

        public Builder shopid(Long l) {
            this.shopid = l;
            return this;
        }

        public Builder itemid(Integer num) {
            this.itemid = num;
            return this;
        }

        public Builder buyer_id(Integer num) {
            this.buyer_id = num;
            return this;
        }

        public Builder with_discount(Boolean bool) {
            this.with_discount = bool;
            return this;
        }

        public ActOrderReceived build() {
            return new ActOrderReceived(this);
        }
    }
}
