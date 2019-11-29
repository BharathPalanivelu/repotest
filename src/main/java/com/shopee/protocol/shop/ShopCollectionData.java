package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopCollectionData extends Message {
    public static final List<Long> DEFAULT_ITEMID = Collections.emptyList();
    public static final Integer DEFAULT_NOUSE = 0;
    public static final List<SubShopCollection> DEFAULT_SUB_COLLECTIONS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer nouse;
    @ProtoField(label = Message.Label.REPEATED, messageType = SubShopCollection.class, tag = 3)
    public final List<SubShopCollection> sub_collections;

    public ShopCollectionData(List<Long> list, Integer num, List<SubShopCollection> list2) {
        this.itemid = immutableCopyOf(list);
        this.nouse = num;
        this.sub_collections = immutableCopyOf(list2);
    }

    private ShopCollectionData(Builder builder) {
        this(builder.itemid, builder.nouse, builder.sub_collections);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCollectionData)) {
            return false;
        }
        ShopCollectionData shopCollectionData = (ShopCollectionData) obj;
        if (!equals((List<?>) this.itemid, (List<?>) shopCollectionData.itemid) || !equals((Object) this.nouse, (Object) shopCollectionData.nouse) || !equals((List<?>) this.sub_collections, (List<?>) shopCollectionData.sub_collections)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.itemid;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.nouse;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<SubShopCollection> list2 = this.sub_collections;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCollectionData> {
        public List<Long> itemid;
        public Integer nouse;
        public List<SubShopCollection> sub_collections;

        public Builder() {
        }

        public Builder(ShopCollectionData shopCollectionData) {
            super(shopCollectionData);
            if (shopCollectionData != null) {
                this.itemid = ShopCollectionData.copyOf(shopCollectionData.itemid);
                this.nouse = shopCollectionData.nouse;
                this.sub_collections = ShopCollectionData.copyOf(shopCollectionData.sub_collections);
            }
        }

        public Builder itemid(List<Long> list) {
            this.itemid = checkForNulls(list);
            return this;
        }

        public Builder nouse(Integer num) {
            this.nouse = num;
            return this;
        }

        public Builder sub_collections(List<SubShopCollection> list) {
            this.sub_collections = checkForNulls(list);
            return this;
        }

        public ShopCollectionData build() {
            return new ShopCollectionData(this);
        }
    }
}
