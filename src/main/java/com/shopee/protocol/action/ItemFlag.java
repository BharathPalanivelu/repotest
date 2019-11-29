package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemFlag extends Message {
    public static final Integer DEFAULT_BITS = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_VALUES = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer bits;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer values;

    public ItemFlag(Long l, Integer num, Integer num2, Integer num3) {
        this.itemid = l;
        this.shopid = num;
        this.bits = num2;
        this.values = num3;
    }

    private ItemFlag(Builder builder) {
        this(builder.itemid, builder.shopid, builder.bits, builder.values);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemFlag)) {
            return false;
        }
        ItemFlag itemFlag = (ItemFlag) obj;
        if (!equals((Object) this.itemid, (Object) itemFlag.itemid) || !equals((Object) this.shopid, (Object) itemFlag.shopid) || !equals((Object) this.bits, (Object) itemFlag.bits) || !equals((Object) this.values, (Object) itemFlag.values)) {
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
        Integer num2 = this.bits;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.values;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemFlag> {
        public Integer bits;
        public Long itemid;
        public Integer shopid;
        public Integer values;

        public Builder() {
        }

        public Builder(ItemFlag itemFlag) {
            super(itemFlag);
            if (itemFlag != null) {
                this.itemid = itemFlag.itemid;
                this.shopid = itemFlag.shopid;
                this.bits = itemFlag.bits;
                this.values = itemFlag.values;
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

        public Builder bits(Integer num) {
            this.bits = num;
            return this;
        }

        public Builder values(Integer num) {
            this.values = num;
            return this;
        }

        public ItemFlag build() {
            return new ItemFlag(this);
        }
    }
}
