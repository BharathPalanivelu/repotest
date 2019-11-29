package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopBoostSlot extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_TOUCH_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer touch_time;

    public ShopBoostSlot(Long l, Integer num) {
        this.itemid = l;
        this.touch_time = num;
    }

    private ShopBoostSlot(Builder builder) {
        this(builder.itemid, builder.touch_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopBoostSlot)) {
            return false;
        }
        ShopBoostSlot shopBoostSlot = (ShopBoostSlot) obj;
        if (!equals((Object) this.itemid, (Object) shopBoostSlot.itemid) || !equals((Object) this.touch_time, (Object) shopBoostSlot.touch_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.touch_time;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopBoostSlot> {
        public Long itemid;
        public Integer touch_time;

        public Builder() {
        }

        public Builder(ShopBoostSlot shopBoostSlot) {
            super(shopBoostSlot);
            if (shopBoostSlot != null) {
                this.itemid = shopBoostSlot.itemid;
                this.touch_time = shopBoostSlot.touch_time;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder touch_time(Integer num) {
            this.touch_time = num;
            return this;
        }

        public ShopBoostSlot build() {
            return new ShopBoostSlot(this);
        }
    }
}
