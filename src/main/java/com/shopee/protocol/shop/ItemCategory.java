package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemCategory extends Message {
    public static final Integer DEFAULT_CATEGORYID = 0;
    public static final Integer DEFAULT_IS_INVISIBLE = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SCORE = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer categoryid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer is_invisible;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer score;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ItemCategory(Integer num, Long l, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.categoryid = num;
        this.itemid = l;
        this.shopid = num2;
        this.mtime = num3;
        this.score = num4;
        this.is_invisible = num5;
    }

    private ItemCategory(Builder builder) {
        this(builder.categoryid, builder.itemid, builder.shopid, builder.mtime, builder.score, builder.is_invisible);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemCategory)) {
            return false;
        }
        ItemCategory itemCategory = (ItemCategory) obj;
        if (!equals((Object) this.categoryid, (Object) itemCategory.categoryid) || !equals((Object) this.itemid, (Object) itemCategory.itemid) || !equals((Object) this.shopid, (Object) itemCategory.shopid) || !equals((Object) this.mtime, (Object) itemCategory.mtime) || !equals((Object) this.score, (Object) itemCategory.score) || !equals((Object) this.is_invisible, (Object) itemCategory.is_invisible)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.categoryid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.score;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.is_invisible;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemCategory> {
        public Integer categoryid;
        public Integer is_invisible;
        public Long itemid;
        public Integer mtime;
        public Integer score;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ItemCategory itemCategory) {
            super(itemCategory);
            if (itemCategory != null) {
                this.categoryid = itemCategory.categoryid;
                this.itemid = itemCategory.itemid;
                this.shopid = itemCategory.shopid;
                this.mtime = itemCategory.mtime;
                this.score = itemCategory.score;
                this.is_invisible = itemCategory.is_invisible;
            }
        }

        public Builder categoryid(Integer num) {
            this.categoryid = num;
            return this;
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

        public Builder score(Integer num) {
            this.score = num;
            return this;
        }

        public Builder is_invisible(Integer num) {
            this.is_invisible = num;
            return this;
        }

        public ItemCategory build() {
            return new ItemCategory(this);
        }
    }
}
