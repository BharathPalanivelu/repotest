package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Item;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class UpdateItemShopCollection extends Message {
    public static final List<Long> DEFAULT_ADDED_SHOPCOLLID = Collections.emptyList();
    public static final Integer DEFAULT_FLAG = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final List<Long> DEFAULT_REMOVED_SHOPCOLLID = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> added_shopcollid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 5)
    public final Item item;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT64)
    public final List<Long> removed_shopcollid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public UpdateItemShopCollection(Long l, Integer num, List<Long> list, List<Long> list2, Item item2, Integer num2, f fVar) {
        this.itemid = l;
        this.shopid = num;
        this.added_shopcollid = immutableCopyOf(list);
        this.removed_shopcollid = immutableCopyOf(list2);
        this.item = item2;
        this.flag = num2;
        this.raw_ctx = fVar;
    }

    private UpdateItemShopCollection(Builder builder) {
        this(builder.itemid, builder.shopid, builder.added_shopcollid, builder.removed_shopcollid, builder.item, builder.flag, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateItemShopCollection)) {
            return false;
        }
        UpdateItemShopCollection updateItemShopCollection = (UpdateItemShopCollection) obj;
        if (!equals((Object) this.itemid, (Object) updateItemShopCollection.itemid) || !equals((Object) this.shopid, (Object) updateItemShopCollection.shopid) || !equals((List<?>) this.added_shopcollid, (List<?>) updateItemShopCollection.added_shopcollid) || !equals((List<?>) this.removed_shopcollid, (List<?>) updateItemShopCollection.removed_shopcollid) || !equals((Object) this.item, (Object) updateItemShopCollection.item) || !equals((Object) this.flag, (Object) updateItemShopCollection.flag) || !equals((Object) this.raw_ctx, (Object) updateItemShopCollection.raw_ctx)) {
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
        List<Long> list = this.added_shopcollid;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.removed_shopcollid;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        Item item2 = this.item;
        int hashCode4 = (i4 + (item2 != null ? item2.hashCode() : 0)) * 37;
        Integer num2 = this.flag;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i5 = hashCode5 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<UpdateItemShopCollection> {
        public List<Long> added_shopcollid;
        public Integer flag;
        public Item item;
        public Long itemid;
        public f raw_ctx;
        public List<Long> removed_shopcollid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(UpdateItemShopCollection updateItemShopCollection) {
            super(updateItemShopCollection);
            if (updateItemShopCollection != null) {
                this.itemid = updateItemShopCollection.itemid;
                this.shopid = updateItemShopCollection.shopid;
                this.added_shopcollid = UpdateItemShopCollection.copyOf(updateItemShopCollection.added_shopcollid);
                this.removed_shopcollid = UpdateItemShopCollection.copyOf(updateItemShopCollection.removed_shopcollid);
                this.item = updateItemShopCollection.item;
                this.flag = updateItemShopCollection.flag;
                this.raw_ctx = updateItemShopCollection.raw_ctx;
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

        public Builder added_shopcollid(List<Long> list) {
            this.added_shopcollid = checkForNulls(list);
            return this;
        }

        public Builder removed_shopcollid(List<Long> list) {
            this.removed_shopcollid = checkForNulls(list);
            return this;
        }

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public Builder flag(Integer num) {
            this.flag = num;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public UpdateItemShopCollection build() {
            return new UpdateItemShopCollection(this);
        }
    }
}
