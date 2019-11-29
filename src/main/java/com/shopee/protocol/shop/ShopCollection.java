package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ShopCollection extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final Integer DEFAULT_COLLECTION_TYPE = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_DATA = f.f32736b;
    public static final String DEFAULT_HASHTAG = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SHOP_COLLECTION_ID = 0L;
    public static final Integer DEFAULT_SORT_WEIGHT = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer collection_type;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f data;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String hashtag;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long shop_collection_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer sort_weight;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;

    public ShopCollection(Long l, Integer num, String str, Integer num2, Integer num3, String str2, Integer num4, Integer num5, Integer num6, Integer num7, f fVar) {
        this.shop_collection_id = l;
        this.shopid = num;
        this.name = str;
        this.collection_type = num2;
        this.catid = num3;
        this.hashtag = str2;
        this.sort_weight = num4;
        this.status = num5;
        this.ctime = num6;
        this.mtime = num7;
        this.data = fVar;
    }

    private ShopCollection(Builder builder) {
        this(builder.shop_collection_id, builder.shopid, builder.name, builder.collection_type, builder.catid, builder.hashtag, builder.sort_weight, builder.status, builder.ctime, builder.mtime, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCollection)) {
            return false;
        }
        ShopCollection shopCollection = (ShopCollection) obj;
        if (!equals((Object) this.shop_collection_id, (Object) shopCollection.shop_collection_id) || !equals((Object) this.shopid, (Object) shopCollection.shopid) || !equals((Object) this.name, (Object) shopCollection.name) || !equals((Object) this.collection_type, (Object) shopCollection.collection_type) || !equals((Object) this.catid, (Object) shopCollection.catid) || !equals((Object) this.hashtag, (Object) shopCollection.hashtag) || !equals((Object) this.sort_weight, (Object) shopCollection.sort_weight) || !equals((Object) this.status, (Object) shopCollection.status) || !equals((Object) this.ctime, (Object) shopCollection.ctime) || !equals((Object) this.mtime, (Object) shopCollection.mtime) || !equals((Object) this.data, (Object) shopCollection.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.shop_collection_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.collection_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.catid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.hashtag;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.sort_weight;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode9 = (hashCode8 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode10 = (hashCode9 + (num7 != null ? num7.hashCode() : 0)) * 37;
        f fVar = this.data;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCollection> {
        public Integer catid;
        public Integer collection_type;
        public Integer ctime;
        public f data;
        public String hashtag;
        public Integer mtime;
        public String name;
        public Long shop_collection_id;
        public Integer shopid;
        public Integer sort_weight;
        public Integer status;

        public Builder() {
        }

        public Builder(ShopCollection shopCollection) {
            super(shopCollection);
            if (shopCollection != null) {
                this.shop_collection_id = shopCollection.shop_collection_id;
                this.shopid = shopCollection.shopid;
                this.name = shopCollection.name;
                this.collection_type = shopCollection.collection_type;
                this.catid = shopCollection.catid;
                this.hashtag = shopCollection.hashtag;
                this.sort_weight = shopCollection.sort_weight;
                this.status = shopCollection.status;
                this.ctime = shopCollection.ctime;
                this.mtime = shopCollection.mtime;
                this.data = shopCollection.data;
            }
        }

        public Builder shop_collection_id(Long l) {
            this.shop_collection_id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder collection_type(Integer num) {
            this.collection_type = num;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder hashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public Builder sort_weight(Integer num) {
            this.sort_weight = num;
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

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder data(f fVar) {
            this.data = fVar;
            return this;
        }

        public ShopCollection build() {
            return new ShopCollection(this);
        }
    }
}
