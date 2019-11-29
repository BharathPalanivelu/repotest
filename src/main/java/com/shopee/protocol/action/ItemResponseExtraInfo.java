package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemResponseExtraInfo extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2)
    public final ItemPriceInfo price_info;

    public ItemResponseExtraInfo(Long l, ItemPriceInfo itemPriceInfo) {
        this.itemid = l;
        this.price_info = itemPriceInfo;
    }

    private ItemResponseExtraInfo(Builder builder) {
        this(builder.itemid, builder.price_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemResponseExtraInfo)) {
            return false;
        }
        ItemResponseExtraInfo itemResponseExtraInfo = (ItemResponseExtraInfo) obj;
        if (!equals((Object) this.itemid, (Object) itemResponseExtraInfo.itemid) || !equals((Object) this.price_info, (Object) itemResponseExtraInfo.price_info)) {
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
        ItemPriceInfo itemPriceInfo = this.price_info;
        if (itemPriceInfo != null) {
            i2 = itemPriceInfo.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemResponseExtraInfo> {
        public Long itemid;
        public ItemPriceInfo price_info;

        public Builder() {
        }

        public Builder(ItemResponseExtraInfo itemResponseExtraInfo) {
            super(itemResponseExtraInfo);
            if (itemResponseExtraInfo != null) {
                this.itemid = itemResponseExtraInfo.itemid;
                this.price_info = itemResponseExtraInfo.price_info;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder price_info(ItemPriceInfo itemPriceInfo) {
            this.price_info = itemPriceInfo;
            return this;
        }

        public ItemResponseExtraInfo build() {
            return new ItemResponseExtraInfo(this);
        }
    }
}
