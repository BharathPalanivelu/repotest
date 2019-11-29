package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SubShopCollection extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 3)
    public final ShopCollectionData data;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;

    public SubShopCollection(String str, Integer num, ShopCollectionData shopCollectionData) {
        this.name = str;
        this.catid = num;
        this.data = shopCollectionData;
    }

    private SubShopCollection(Builder builder) {
        this(builder.name, builder.catid, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubShopCollection)) {
            return false;
        }
        SubShopCollection subShopCollection = (SubShopCollection) obj;
        if (!equals((Object) this.name, (Object) subShopCollection.name) || !equals((Object) this.catid, (Object) subShopCollection.catid) || !equals((Object) this.data, (Object) subShopCollection.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.catid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        ShopCollectionData shopCollectionData = this.data;
        if (shopCollectionData != null) {
            i2 = shopCollectionData.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SubShopCollection> {
        public Integer catid;
        public ShopCollectionData data;
        public String name;

        public Builder() {
        }

        public Builder(SubShopCollection subShopCollection) {
            super(subShopCollection);
            if (subShopCollection != null) {
                this.name = subShopCollection.name;
                this.catid = subShopCollection.catid;
                this.data = subShopCollection.data;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder data(ShopCollectionData shopCollectionData) {
            this.data = shopCollectionData;
            return this;
        }

        public SubShopCollection build() {
            return new SubShopCollection(this);
        }
    }
}
