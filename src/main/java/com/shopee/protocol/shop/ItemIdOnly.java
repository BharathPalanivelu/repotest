package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemIdOnly extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ItemIdOnly(Long l, Integer num, Integer num2) {
        this.itemid = l;
        this.shopid = num;
        this.mtime = num2;
    }

    private ItemIdOnly(Builder builder) {
        this(builder.itemid, builder.shopid, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemIdOnly)) {
            return false;
        }
        ItemIdOnly itemIdOnly = (ItemIdOnly) obj;
        if (!equals((Object) this.itemid, (Object) itemIdOnly.itemid) || !equals((Object) this.shopid, (Object) itemIdOnly.shopid) || !equals((Object) this.mtime, (Object) itemIdOnly.mtime)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.mtime;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemIdOnly> {
        public Long itemid;
        public Integer mtime;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ItemIdOnly itemIdOnly) {
            super(itemIdOnly);
            if (itemIdOnly != null) {
                this.itemid = itemIdOnly.itemid;
                this.shopid = itemIdOnly.shopid;
                this.mtime = itemIdOnly.mtime;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public ItemIdOnly build() {
            checkRequiredFields();
            return new ItemIdOnly(this);
        }
    }
}
