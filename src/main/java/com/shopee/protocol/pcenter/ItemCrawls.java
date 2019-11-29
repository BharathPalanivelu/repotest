package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemCrawls extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TARGET_SHOPID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String target_shopid;

    public ItemCrawls(Long l, Integer num, String str) {
        this.itemid = l;
        this.shopid = num;
        this.target_shopid = str;
    }

    private ItemCrawls(Builder builder) {
        this(builder.itemid, builder.shopid, builder.target_shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemCrawls)) {
            return false;
        }
        ItemCrawls itemCrawls = (ItemCrawls) obj;
        if (!equals((Object) this.itemid, (Object) itemCrawls.itemid) || !equals((Object) this.shopid, (Object) itemCrawls.shopid) || !equals((Object) this.target_shopid, (Object) itemCrawls.target_shopid)) {
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
        String str = this.target_shopid;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemCrawls> {
        public Long itemid;
        public Integer shopid;
        public String target_shopid;

        public Builder() {
        }

        public Builder(ItemCrawls itemCrawls) {
            super(itemCrawls);
            if (itemCrawls != null) {
                this.itemid = itemCrawls.itemid;
                this.shopid = itemCrawls.shopid;
                this.target_shopid = itemCrawls.target_shopid;
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

        public Builder target_shopid(String str) {
            this.target_shopid = str;
            return this;
        }

        public ItemCrawls build() {
            return new ItemCrawls(this);
        }
    }
}
