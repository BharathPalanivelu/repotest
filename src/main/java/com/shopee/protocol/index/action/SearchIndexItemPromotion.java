package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Item;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexItemPromotion extends Message {
    public static final List<Long> DEFAULT_DISABLE_PROMOTIONID = Collections.emptyList();
    public static final List<Long> DEFAULT_ENABLE_PROMOTIONID = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT64)
    public final List<Long> disable_promotionid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> enable_promotionid;
    @ProtoField(tag = 2)
    public final Item item;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;

    public SearchIndexItemPromotion(Long l, Item item2, List<Long> list, List<Long> list2) {
        this.itemid = l;
        this.item = item2;
        this.enable_promotionid = immutableCopyOf(list);
        this.disable_promotionid = immutableCopyOf(list2);
    }

    private SearchIndexItemPromotion(Builder builder) {
        this(builder.itemid, builder.item, builder.enable_promotionid, builder.disable_promotionid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemPromotion)) {
            return false;
        }
        SearchIndexItemPromotion searchIndexItemPromotion = (SearchIndexItemPromotion) obj;
        if (!equals((Object) this.itemid, (Object) searchIndexItemPromotion.itemid) || !equals((Object) this.item, (Object) searchIndexItemPromotion.item) || !equals((List<?>) this.enable_promotionid, (List<?>) searchIndexItemPromotion.enable_promotionid) || !equals((List<?>) this.disable_promotionid, (List<?>) searchIndexItemPromotion.disable_promotionid)) {
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
        Item item2 = this.item;
        if (item2 != null) {
            i2 = item2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Long> list = this.enable_promotionid;
        int i4 = 1;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.disable_promotionid;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode2 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemPromotion> {
        public List<Long> disable_promotionid;
        public List<Long> enable_promotionid;
        public Item item;
        public Long itemid;

        public Builder() {
        }

        public Builder(SearchIndexItemPromotion searchIndexItemPromotion) {
            super(searchIndexItemPromotion);
            if (searchIndexItemPromotion != null) {
                this.itemid = searchIndexItemPromotion.itemid;
                this.item = searchIndexItemPromotion.item;
                this.enable_promotionid = SearchIndexItemPromotion.copyOf(searchIndexItemPromotion.enable_promotionid);
                this.disable_promotionid = SearchIndexItemPromotion.copyOf(searchIndexItemPromotion.disable_promotionid);
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public Builder enable_promotionid(List<Long> list) {
            this.enable_promotionid = checkForNulls(list);
            return this;
        }

        public Builder disable_promotionid(List<Long> list) {
            this.disable_promotionid = checkForNulls(list);
            return this;
        }

        public SearchIndexItemPromotion build() {
            return new SearchIndexItemPromotion(this);
        }
    }
}
