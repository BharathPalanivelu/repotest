package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemPair extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 7)
    public final TargetItemId target;

    public ItemPair(Long l, Integer num, Integer num2, String str, TargetItemId targetItemId) {
        this.itemid = l;
        this.shopid = num;
        this.status = num2;
        this.country = str;
        this.target = targetItemId;
    }

    private ItemPair(Builder builder) {
        this(builder.itemid, builder.shopid, builder.status, builder.country, builder.target);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemPair)) {
            return false;
        }
        ItemPair itemPair = (ItemPair) obj;
        if (!equals((Object) this.itemid, (Object) itemPair.itemid) || !equals((Object) this.shopid, (Object) itemPair.shopid) || !equals((Object) this.status, (Object) itemPair.status) || !equals((Object) this.country, (Object) itemPair.country) || !equals((Object) this.target, (Object) itemPair.target)) {
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
        Integer num2 = this.status;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        TargetItemId targetItemId = this.target;
        if (targetItemId != null) {
            i2 = targetItemId.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemPair> {
        public String country;
        public Long itemid;
        public Integer shopid;
        public Integer status;
        public TargetItemId target;

        public Builder() {
        }

        public Builder(ItemPair itemPair) {
            super(itemPair);
            if (itemPair != null) {
                this.itemid = itemPair.itemid;
                this.shopid = itemPair.shopid;
                this.status = itemPair.status;
                this.country = itemPair.country;
                this.target = itemPair.target;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder target(TargetItemId targetItemId) {
            this.target = targetItemId;
            return this;
        }

        public ItemPair build() {
            return new ItemPair(this);
        }
    }
}
