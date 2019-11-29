package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemInfo extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final String DEFAULT_EXTRAINFO = "";
    public static final String DEFAULT_FROM = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_ITEM_INDEX = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String extrainfo;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer item_index;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ItemInfo(Long l, Integer num, String str, String str2, String str3, Integer num2) {
        this.itemid = l;
        this.shopid = num;
        this.extrainfo = str;
        this.from = str2;
        this.algorithm = str3;
        this.item_index = num2;
    }

    private ItemInfo(Builder builder) {
        this(builder.itemid, builder.shopid, builder.extrainfo, builder.from, builder.algorithm, builder.item_index);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemInfo)) {
            return false;
        }
        ItemInfo itemInfo = (ItemInfo) obj;
        if (!equals((Object) this.itemid, (Object) itemInfo.itemid) || !equals((Object) this.shopid, (Object) itemInfo.shopid) || !equals((Object) this.extrainfo, (Object) itemInfo.extrainfo) || !equals((Object) this.from, (Object) itemInfo.from) || !equals((Object) this.algorithm, (Object) itemInfo.algorithm) || !equals((Object) this.item_index, (Object) itemInfo.item_index)) {
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
        String str = this.extrainfo;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.from;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.algorithm;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.item_index;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemInfo> {
        public String algorithm;
        public String extrainfo;
        public String from;
        public Integer item_index;
        public Long itemid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ItemInfo itemInfo) {
            super(itemInfo);
            if (itemInfo != null) {
                this.itemid = itemInfo.itemid;
                this.shopid = itemInfo.shopid;
                this.extrainfo = itemInfo.extrainfo;
                this.from = itemInfo.from;
                this.algorithm = itemInfo.algorithm;
                this.item_index = itemInfo.item_index;
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

        public Builder extrainfo(String str) {
            this.extrainfo = str;
            return this;
        }

        public Builder from(String str) {
            this.from = str;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Builder item_index(Integer num) {
            this.item_index = num;
            return this;
        }

        public ItemInfo build() {
            return new ItemInfo(this);
        }
    }
}
