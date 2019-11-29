package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopBoostInfo extends Message {
    public static final List<ShopBoostSlot> DEFAULT_SLOTS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopBoostSlot.class, tag = 1)
    public final List<ShopBoostSlot> slots;

    public ShopBoostInfo(List<ShopBoostSlot> list) {
        this.slots = immutableCopyOf(list);
    }

    private ShopBoostInfo(Builder builder) {
        this(builder.slots);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopBoostInfo)) {
            return false;
        }
        return equals((List<?>) this.slots, (List<?>) ((ShopBoostInfo) obj).slots);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ShopBoostSlot> list = this.slots;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ShopBoostInfo> {
        public List<ShopBoostSlot> slots;

        public Builder() {
        }

        public Builder(ShopBoostInfo shopBoostInfo) {
            super(shopBoostInfo);
            if (shopBoostInfo != null) {
                this.slots = ShopBoostInfo.copyOf(shopBoostInfo.slots);
            }
        }

        public Builder slots(List<ShopBoostSlot> list) {
            this.slots = checkForNulls(list);
            return this;
        }

        public ShopBoostInfo build() {
            return new ShopBoostInfo(this);
        }
    }
}
