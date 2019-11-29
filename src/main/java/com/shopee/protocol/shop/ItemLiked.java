package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemLiked extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public ItemLiked(Integer num, Integer num2, Long l, Integer num3, Integer num4) {
        this.userid = num;
        this.shopid = num2;
        this.itemid = l;
        this.status = num3;
        this.ctime = num4;
    }

    private ItemLiked(Builder builder) {
        this(builder.userid, builder.shopid, builder.itemid, builder.status, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemLiked)) {
            return false;
        }
        ItemLiked itemLiked = (ItemLiked) obj;
        if (!equals((Object) this.userid, (Object) itemLiked.userid) || !equals((Object) this.shopid, (Object) itemLiked.shopid) || !equals((Object) this.itemid, (Object) itemLiked.itemid) || !equals((Object) this.status, (Object) itemLiked.status) || !equals((Object) this.ctime, (Object) itemLiked.ctime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemLiked> {
        public Integer ctime;
        public Long itemid;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ItemLiked itemLiked) {
            super(itemLiked);
            if (itemLiked != null) {
                this.userid = itemLiked.userid;
                this.shopid = itemLiked.shopid;
                this.itemid = itemLiked.itemid;
                this.status = itemLiked.status;
                this.ctime = itemLiked.ctime;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public ItemLiked build() {
            checkRequiredFields();
            return new ItemLiked(this);
        }
    }
}
