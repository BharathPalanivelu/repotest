package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopItemId extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ShopItemId(Integer num, Long l, Integer num2, Long l2) {
        this.shopid = num;
        this.itemid = l;
        this.mtime = num2;
        this.modelid = l2;
    }

    private ShopItemId(Builder builder) {
        this(builder.shopid, builder.itemid, builder.mtime, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopItemId)) {
            return false;
        }
        ShopItemId shopItemId = (ShopItemId) obj;
        if (!equals((Object) this.shopid, (Object) shopItemId.shopid) || !equals((Object) this.itemid, (Object) shopItemId.itemid) || !equals((Object) this.mtime, (Object) shopItemId.mtime) || !equals((Object) this.modelid, (Object) shopItemId.modelid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.mtime;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopItemId> {
        public Long itemid;
        public Long modelid;
        public Integer mtime;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ShopItemId shopItemId) {
            super(shopItemId);
            if (shopItemId != null) {
                this.shopid = shopItemId.shopid;
                this.itemid = shopItemId.itemid;
                this.mtime = shopItemId.mtime;
                this.modelid = shopItemId.modelid;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public ShopItemId build() {
            checkRequiredFields();
            return new ShopItemId(this);
        }
    }
}
