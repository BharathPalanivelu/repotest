package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.ItemRating;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexItemAttribute extends Message {
    public static final String DEFAULT_ATTR_BRAND = "";
    public static final Integer DEFAULT_ATTR_BRAND_ID = 0;
    public static final Double DEFAULT_BOOST_VALUE = Double.valueOf(0.0d);
    public static final Integer DEFAULT_BRAND_STATUS = 0;
    public static final List<Integer> DEFAULT_CATEGORYID = Collections.emptyList();
    public static final Integer DEFAULT_CAT_POP_SCORE = 0;
    public static final List<Integer> DEFAULT_COLLECTIONID = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<Integer> DEFAULT_LIKE_COUNT = Collections.emptyList();
    public static final Integer DEFAULT_NEW_ARRIVAL = 0;
    public static final List<Long> DEFAULT_SHOPCOLLECTIONID = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    public static final List<Integer> DEFAULT_SOLD_COUNT = Collections.emptyList();
    public static final Long DEFAULT_SPU_ID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STOCKOUT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String attr_brand;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer attr_brand_id;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double boost_value;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer brand_status;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer cat_pop_score;
    @ProtoField(label = Message.Label.REPEATED, tag = 12, type = Message.Datatype.INT32)
    public final List<Integer> categoryid;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT32)
    public final List<Integer> collectionid;
    @ProtoField(tag = 17)
    public final ItemRating item_rating;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> like_count;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer new_arrival;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT64)
    public final List<Long> shopcollectionid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> sold_count;
    @ProtoField(tag = 16, type = Message.Datatype.INT64)
    public final Long spu_id;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer stockout;

    public SearchIndexItemAttribute(Long l, Integer num, List<Integer> list, List<Integer> list2, Integer num2, Integer num3, List<Integer> list3, Integer num4, Integer num5, List<Long> list4, Double d2, List<Integer> list5, String str, Integer num6, Integer num7, Long l2, ItemRating itemRating) {
        this.itemid = l;
        this.shopid = num;
        this.like_count = immutableCopyOf(list);
        this.sold_count = immutableCopyOf(list2);
        this.new_arrival = num2;
        this.cat_pop_score = num3;
        this.collectionid = immutableCopyOf(list3);
        this.stockout = num4;
        this.status = num5;
        this.shopcollectionid = immutableCopyOf(list4);
        this.boost_value = d2;
        this.categoryid = immutableCopyOf(list5);
        this.attr_brand = str;
        this.brand_status = num6;
        this.attr_brand_id = num7;
        this.spu_id = l2;
        this.item_rating = itemRating;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SearchIndexItemAttribute(com.shopee.protocol.index.action.SearchIndexItemAttribute.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.Long r2 = r0.itemid
            java.lang.Integer r3 = r0.shopid
            java.util.List<java.lang.Integer> r4 = r0.like_count
            java.util.List<java.lang.Integer> r5 = r0.sold_count
            java.lang.Integer r6 = r0.new_arrival
            java.lang.Integer r7 = r0.cat_pop_score
            java.util.List<java.lang.Integer> r8 = r0.collectionid
            java.lang.Integer r9 = r0.stockout
            java.lang.Integer r10 = r0.status
            java.util.List<java.lang.Long> r11 = r0.shopcollectionid
            java.lang.Double r12 = r0.boost_value
            java.util.List<java.lang.Integer> r13 = r0.categoryid
            java.lang.String r14 = r0.attr_brand
            java.lang.Integer r15 = r0.brand_status
            r19 = r1
            java.lang.Integer r1 = r0.attr_brand_id
            r16 = r1
            java.lang.Long r1 = r0.spu_id
            r17 = r1
            com.shopee.protocol.shop.ItemRating r1 = r0.item_rating
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.index.action.SearchIndexItemAttribute.<init>(com.shopee.protocol.index.action.SearchIndexItemAttribute$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemAttribute)) {
            return false;
        }
        SearchIndexItemAttribute searchIndexItemAttribute = (SearchIndexItemAttribute) obj;
        if (!equals((Object) this.itemid, (Object) searchIndexItemAttribute.itemid) || !equals((Object) this.shopid, (Object) searchIndexItemAttribute.shopid) || !equals((List<?>) this.like_count, (List<?>) searchIndexItemAttribute.like_count) || !equals((List<?>) this.sold_count, (List<?>) searchIndexItemAttribute.sold_count) || !equals((Object) this.new_arrival, (Object) searchIndexItemAttribute.new_arrival) || !equals((Object) this.cat_pop_score, (Object) searchIndexItemAttribute.cat_pop_score) || !equals((List<?>) this.collectionid, (List<?>) searchIndexItemAttribute.collectionid) || !equals((Object) this.stockout, (Object) searchIndexItemAttribute.stockout) || !equals((Object) this.status, (Object) searchIndexItemAttribute.status) || !equals((List<?>) this.shopcollectionid, (List<?>) searchIndexItemAttribute.shopcollectionid) || !equals((Object) this.boost_value, (Object) searchIndexItemAttribute.boost_value) || !equals((List<?>) this.categoryid, (List<?>) searchIndexItemAttribute.categoryid) || !equals((Object) this.attr_brand, (Object) searchIndexItemAttribute.attr_brand) || !equals((Object) this.brand_status, (Object) searchIndexItemAttribute.brand_status) || !equals((Object) this.attr_brand_id, (Object) searchIndexItemAttribute.attr_brand_id) || !equals((Object) this.spu_id, (Object) searchIndexItemAttribute.spu_id) || !equals((Object) this.item_rating, (Object) searchIndexItemAttribute.item_rating)) {
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
        List<Integer> list = this.like_count;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.sold_count;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Integer num2 = this.new_arrival;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.cat_pop_score;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<Integer> list3 = this.collectionid;
        int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 1)) * 37;
        Integer num4 = this.stockout;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        List<Long> list4 = this.shopcollectionid;
        int hashCode10 = (hashCode9 + (list4 != null ? list4.hashCode() : 1)) * 37;
        Double d2 = this.boost_value;
        int hashCode11 = (hashCode10 + (d2 != null ? d2.hashCode() : 0)) * 37;
        List<Integer> list5 = this.categoryid;
        if (list5 != null) {
            i3 = list5.hashCode();
        }
        int i4 = (hashCode11 + i3) * 37;
        String str = this.attr_brand;
        int hashCode12 = (i4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num6 = this.brand_status;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.attr_brand_id;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l2 = this.spu_id;
        int hashCode15 = (hashCode14 + (l2 != null ? l2.hashCode() : 0)) * 37;
        ItemRating itemRating = this.item_rating;
        if (itemRating != null) {
            i2 = itemRating.hashCode();
        }
        int i5 = hashCode15 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemAttribute> {
        public String attr_brand;
        public Integer attr_brand_id;
        public Double boost_value;
        public Integer brand_status;
        public Integer cat_pop_score;
        public List<Integer> categoryid;
        public List<Integer> collectionid;
        public ItemRating item_rating;
        public Long itemid;
        public List<Integer> like_count;
        public Integer new_arrival;
        public List<Long> shopcollectionid;
        public Integer shopid;
        public List<Integer> sold_count;
        public Long spu_id;
        public Integer status;
        public Integer stockout;

        public Builder() {
        }

        public Builder(SearchIndexItemAttribute searchIndexItemAttribute) {
            super(searchIndexItemAttribute);
            if (searchIndexItemAttribute != null) {
                this.itemid = searchIndexItemAttribute.itemid;
                this.shopid = searchIndexItemAttribute.shopid;
                this.like_count = SearchIndexItemAttribute.copyOf(searchIndexItemAttribute.like_count);
                this.sold_count = SearchIndexItemAttribute.copyOf(searchIndexItemAttribute.sold_count);
                this.new_arrival = searchIndexItemAttribute.new_arrival;
                this.cat_pop_score = searchIndexItemAttribute.cat_pop_score;
                this.collectionid = SearchIndexItemAttribute.copyOf(searchIndexItemAttribute.collectionid);
                this.stockout = searchIndexItemAttribute.stockout;
                this.status = searchIndexItemAttribute.status;
                this.shopcollectionid = SearchIndexItemAttribute.copyOf(searchIndexItemAttribute.shopcollectionid);
                this.boost_value = searchIndexItemAttribute.boost_value;
                this.categoryid = SearchIndexItemAttribute.copyOf(searchIndexItemAttribute.categoryid);
                this.attr_brand = searchIndexItemAttribute.attr_brand;
                this.brand_status = searchIndexItemAttribute.brand_status;
                this.attr_brand_id = searchIndexItemAttribute.attr_brand_id;
                this.spu_id = searchIndexItemAttribute.spu_id;
                this.item_rating = searchIndexItemAttribute.item_rating;
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

        public Builder like_count(List<Integer> list) {
            this.like_count = checkForNulls(list);
            return this;
        }

        public Builder sold_count(List<Integer> list) {
            this.sold_count = checkForNulls(list);
            return this;
        }

        public Builder new_arrival(Integer num) {
            this.new_arrival = num;
            return this;
        }

        public Builder cat_pop_score(Integer num) {
            this.cat_pop_score = num;
            return this;
        }

        public Builder collectionid(List<Integer> list) {
            this.collectionid = checkForNulls(list);
            return this;
        }

        public Builder stockout(Integer num) {
            this.stockout = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder shopcollectionid(List<Long> list) {
            this.shopcollectionid = checkForNulls(list);
            return this;
        }

        public Builder boost_value(Double d2) {
            this.boost_value = d2;
            return this;
        }

        public Builder categoryid(List<Integer> list) {
            this.categoryid = checkForNulls(list);
            return this;
        }

        public Builder attr_brand(String str) {
            this.attr_brand = str;
            return this;
        }

        public Builder brand_status(Integer num) {
            this.brand_status = num;
            return this;
        }

        public Builder attr_brand_id(Integer num) {
            this.attr_brand_id = num;
            return this;
        }

        public Builder spu_id(Long l) {
            this.spu_id = l;
            return this;
        }

        public Builder item_rating(ItemRating itemRating) {
            this.item_rating = itemRating;
            return this;
        }

        public SearchIndexItemAttribute build() {
            return new SearchIndexItemAttribute(this);
        }
    }
}
