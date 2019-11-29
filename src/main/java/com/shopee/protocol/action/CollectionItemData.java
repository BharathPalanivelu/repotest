package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CollectionItemData extends Message {
    public static final Integer DEFAULT_CAMPAIGN_STOCK = 0;
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer campaign_stock;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String display_name;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public CollectionItemData(Integer num, Integer num2, Long l, String str, Integer num3, f fVar) {
        this.collection_id = num;
        this.shopid = num2;
        this.itemid = l;
        this.display_name = str;
        this.campaign_stock = num3;
        this.extinfo = fVar;
    }

    private CollectionItemData(Builder builder) {
        this(builder.collection_id, builder.shopid, builder.itemid, builder.display_name, builder.campaign_stock, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionItemData)) {
            return false;
        }
        CollectionItemData collectionItemData = (CollectionItemData) obj;
        if (!equals((Object) this.collection_id, (Object) collectionItemData.collection_id) || !equals((Object) this.shopid, (Object) collectionItemData.shopid) || !equals((Object) this.itemid, (Object) collectionItemData.itemid) || !equals((Object) this.display_name, (Object) collectionItemData.display_name) || !equals((Object) this.campaign_stock, (Object) collectionItemData.campaign_stock) || !equals((Object) this.extinfo, (Object) collectionItemData.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.collection_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.display_name;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.campaign_stock;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CollectionItemData> {
        public Integer campaign_stock;
        public Integer collection_id;
        public String display_name;
        public f extinfo;
        public Long itemid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(CollectionItemData collectionItemData) {
            super(collectionItemData);
            if (collectionItemData != null) {
                this.collection_id = collectionItemData.collection_id;
                this.shopid = collectionItemData.shopid;
                this.itemid = collectionItemData.itemid;
                this.display_name = collectionItemData.display_name;
                this.campaign_stock = collectionItemData.campaign_stock;
                this.extinfo = collectionItemData.extinfo;
            }
        }

        public Builder collection_id(Integer num) {
            this.collection_id = num;
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

        public Builder display_name(String str) {
            this.display_name = str;
            return this;
        }

        public Builder campaign_stock(Integer num) {
            this.campaign_stock = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public CollectionItemData build() {
            return new CollectionItemData(this);
        }
    }
}
