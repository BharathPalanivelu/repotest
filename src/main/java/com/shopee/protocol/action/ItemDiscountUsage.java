package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemDiscountUsage extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_PURCHASED_AMOUNT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USAGE_LIMIT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer purchased_amount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer usage_limit;

    public ItemDiscountUsage(Long l, Integer num, Integer num2, Integer num3) {
        this.itemid = l;
        this.shopid = num;
        this.purchased_amount = num2;
        this.usage_limit = num3;
    }

    private ItemDiscountUsage(Builder builder) {
        this(builder.itemid, builder.shopid, builder.purchased_amount, builder.usage_limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemDiscountUsage)) {
            return false;
        }
        ItemDiscountUsage itemDiscountUsage = (ItemDiscountUsage) obj;
        if (!equals((Object) this.itemid, (Object) itemDiscountUsage.itemid) || !equals((Object) this.shopid, (Object) itemDiscountUsage.shopid) || !equals((Object) this.purchased_amount, (Object) itemDiscountUsage.purchased_amount) || !equals((Object) this.usage_limit, (Object) itemDiscountUsage.usage_limit)) {
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
        Integer num2 = this.purchased_amount;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.usage_limit;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemDiscountUsage> {
        public Long itemid;
        public Integer purchased_amount;
        public Integer shopid;
        public Integer usage_limit;

        public Builder() {
        }

        public Builder(ItemDiscountUsage itemDiscountUsage) {
            super(itemDiscountUsage);
            if (itemDiscountUsage != null) {
                this.itemid = itemDiscountUsage.itemid;
                this.shopid = itemDiscountUsage.shopid;
                this.purchased_amount = itemDiscountUsage.purchased_amount;
                this.usage_limit = itemDiscountUsage.usage_limit;
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

        public Builder purchased_amount(Integer num) {
            this.purchased_amount = num;
            return this;
        }

        public Builder usage_limit(Integer num) {
            this.usage_limit = num;
            return this;
        }

        public ItemDiscountUsage build() {
            return new ItemDiscountUsage(this);
        }
    }
}
