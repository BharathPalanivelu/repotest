package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemDimensions extends Message {
    public static final Long DEFAULT_HEIGHT = 0L;
    public static final Long DEFAULT_LENGTH = 0L;
    public static final Integer DEFAULT_UNIT = 0;
    public static final Long DEFAULT_WIDTH = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long height;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long length;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer unit;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long width;

    public ItemDimensions(Long l, Long l2, Long l3, Integer num) {
        this.width = l;
        this.length = l2;
        this.height = l3;
        this.unit = num;
    }

    private ItemDimensions(Builder builder) {
        this(builder.width, builder.length, builder.height, builder.unit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemDimensions)) {
            return false;
        }
        ItemDimensions itemDimensions = (ItemDimensions) obj;
        if (!equals((Object) this.width, (Object) itemDimensions.width) || !equals((Object) this.length, (Object) itemDimensions.length) || !equals((Object) this.height, (Object) itemDimensions.height) || !equals((Object) this.unit, (Object) itemDimensions.unit)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.width;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.length;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.height;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.unit;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemDimensions> {
        public Long height;
        public Long length;
        public Integer unit;
        public Long width;

        public Builder() {
        }

        public Builder(ItemDimensions itemDimensions) {
            super(itemDimensions);
            if (itemDimensions != null) {
                this.width = itemDimensions.width;
                this.length = itemDimensions.length;
                this.height = itemDimensions.height;
                this.unit = itemDimensions.unit;
            }
        }

        public Builder width(Long l) {
            this.width = l;
            return this;
        }

        public Builder length(Long l) {
            this.length = l;
            return this;
        }

        public Builder height(Long l) {
            this.height = l;
            return this;
        }

        public Builder unit(Integer num) {
            this.unit = num;
            return this;
        }

        public ItemDimensions build() {
            checkRequiredFields();
            return new ItemDimensions(this);
        }
    }
}
