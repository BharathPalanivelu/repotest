package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ShopCollection;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class SearchIndexJob extends Message {
    public static final List<Long> DEFAULT_AFFECTED_SHOP_COLLECTIONID = Collections.emptyList();
    public static final List<Integer> DEFAULT_CATID = Collections.emptyList();
    public static final List<Integer> DEFAULT_COLLECTIONID = Collections.emptyList();
    public static final Integer DEFAULT_FLAG = 0;
    public static final Boolean DEFAULT_FORCE = false;
    public static final List<HashtagScore> DEFAULT_HASHTAG = Collections.emptyList();
    public static final Integer DEFAULT_INQ_TIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_VISIBLE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT64)
    public final List<Long> affected_shop_collectionid;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> catid;
    @ProtoField(tag = 9)
    public final ShopCollection collection;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> collectionid;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean force;
    @ProtoField(label = Message.Label.REPEATED, messageType = HashtagScore.class, tag = 5)
    public final List<HashtagScore> hashtag;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer inq_time;
    @ProtoField(tag = 7)
    public final Item item;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 15, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer visible;

    public SearchIndexJob(Integer num, Integer num2, Long l, List<Integer> list, List<HashtagScore> list2, List<Integer> list3, Item item2, Integer num3, ShopCollection shopCollection, List<Long> list4, String str, Boolean bool, Integer num4, Integer num5, f fVar) {
        this.type = num;
        this.shopid = num2;
        this.itemid = l;
        this.catid = immutableCopyOf(list);
        this.hashtag = immutableCopyOf(list2);
        this.collectionid = immutableCopyOf(list3);
        this.item = item2;
        this.visible = num3;
        this.collection = shopCollection;
        this.affected_shop_collectionid = immutableCopyOf(list4);
        this.source = str;
        this.force = bool;
        this.inq_time = num4;
        this.flag = num5;
        this.raw_ctx = fVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SearchIndexJob(com.shopee.protocol.index.action.SearchIndexJob.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Integer r2 = r0.type
            java.lang.Integer r3 = r0.shopid
            java.lang.Long r4 = r0.itemid
            java.util.List<java.lang.Integer> r5 = r0.catid
            java.util.List<com.shopee.protocol.index.action.HashtagScore> r6 = r0.hashtag
            java.util.List<java.lang.Integer> r7 = r0.collectionid
            com.shopee.protocol.shop.Item r8 = r0.item
            java.lang.Integer r9 = r0.visible
            com.shopee.protocol.shop.ShopCollection r10 = r0.collection
            java.util.List<java.lang.Long> r11 = r0.affected_shop_collectionid
            java.lang.String r12 = r0.source
            java.lang.Boolean r13 = r0.force
            java.lang.Integer r14 = r0.inq_time
            java.lang.Integer r15 = r0.flag
            e.f r1 = r0.raw_ctx
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.index.action.SearchIndexJob.<init>(com.shopee.protocol.index.action.SearchIndexJob$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexJob)) {
            return false;
        }
        SearchIndexJob searchIndexJob = (SearchIndexJob) obj;
        if (!equals((Object) this.type, (Object) searchIndexJob.type) || !equals((Object) this.shopid, (Object) searchIndexJob.shopid) || !equals((Object) this.itemid, (Object) searchIndexJob.itemid) || !equals((List<?>) this.catid, (List<?>) searchIndexJob.catid) || !equals((List<?>) this.hashtag, (List<?>) searchIndexJob.hashtag) || !equals((List<?>) this.collectionid, (List<?>) searchIndexJob.collectionid) || !equals((Object) this.item, (Object) searchIndexJob.item) || !equals((Object) this.visible, (Object) searchIndexJob.visible) || !equals((Object) this.collection, (Object) searchIndexJob.collection) || !equals((List<?>) this.affected_shop_collectionid, (List<?>) searchIndexJob.affected_shop_collectionid) || !equals((Object) this.source, (Object) searchIndexJob.source) || !equals((Object) this.force, (Object) searchIndexJob.force) || !equals((Object) this.inq_time, (Object) searchIndexJob.inq_time) || !equals((Object) this.flag, (Object) searchIndexJob.flag) || !equals((Object) this.raw_ctx, (Object) searchIndexJob.raw_ctx)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        List<Integer> list = this.catid;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        List<HashtagScore> list2 = this.hashtag;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Integer> list3 = this.collectionid;
        int hashCode6 = (hashCode5 + (list3 != null ? list3.hashCode() : 1)) * 37;
        Item item2 = this.item;
        int hashCode7 = (hashCode6 + (item2 != null ? item2.hashCode() : 0)) * 37;
        Integer num3 = this.visible;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        ShopCollection shopCollection = this.collection;
        int hashCode9 = (hashCode8 + (shopCollection != null ? shopCollection.hashCode() : 0)) * 37;
        List<Long> list4 = this.affected_shop_collectionid;
        if (list4 != null) {
            i3 = list4.hashCode();
        }
        int i4 = (hashCode9 + i3) * 37;
        String str = this.source;
        int hashCode10 = (i4 + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.force;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num4 = this.inq_time;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.flag;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i5 = hashCode13 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SearchIndexJob> {
        public List<Long> affected_shop_collectionid;
        public List<Integer> catid;
        public ShopCollection collection;
        public List<Integer> collectionid;
        public Integer flag;
        public Boolean force;
        public List<HashtagScore> hashtag;
        public Integer inq_time;
        public Item item;
        public Long itemid;
        public f raw_ctx;
        public Integer shopid;
        public String source;
        public Integer type;
        public Integer visible;

        public Builder() {
        }

        public Builder(SearchIndexJob searchIndexJob) {
            super(searchIndexJob);
            if (searchIndexJob != null) {
                this.type = searchIndexJob.type;
                this.shopid = searchIndexJob.shopid;
                this.itemid = searchIndexJob.itemid;
                this.catid = SearchIndexJob.copyOf(searchIndexJob.catid);
                this.hashtag = SearchIndexJob.copyOf(searchIndexJob.hashtag);
                this.collectionid = SearchIndexJob.copyOf(searchIndexJob.collectionid);
                this.item = searchIndexJob.item;
                this.visible = searchIndexJob.visible;
                this.collection = searchIndexJob.collection;
                this.affected_shop_collectionid = SearchIndexJob.copyOf(searchIndexJob.affected_shop_collectionid);
                this.source = searchIndexJob.source;
                this.force = searchIndexJob.force;
                this.inq_time = searchIndexJob.inq_time;
                this.flag = searchIndexJob.flag;
                this.raw_ctx = searchIndexJob.raw_ctx;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
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

        public Builder catid(List<Integer> list) {
            this.catid = checkForNulls(list);
            return this;
        }

        public Builder hashtag(List<HashtagScore> list) {
            this.hashtag = checkForNulls(list);
            return this;
        }

        public Builder collectionid(List<Integer> list) {
            this.collectionid = checkForNulls(list);
            return this;
        }

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public Builder visible(Integer num) {
            this.visible = num;
            return this;
        }

        public Builder collection(ShopCollection shopCollection) {
            this.collection = shopCollection;
            return this;
        }

        public Builder affected_shop_collectionid(List<Long> list) {
            this.affected_shop_collectionid = checkForNulls(list);
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder force(Boolean bool) {
            this.force = bool;
            return this;
        }

        public Builder inq_time(Integer num) {
            this.inq_time = num;
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

        public SearchIndexJob build() {
            return new SearchIndexJob(this);
        }
    }
}
