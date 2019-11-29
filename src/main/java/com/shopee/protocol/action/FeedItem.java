package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class FeedItem extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final String DEFAULT_COMMENT = "";
    public static final Long DEFAULT_FEEDID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final f DEFAULT_MENTIONED = f.f32736b;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_RATING = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String comment;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long feedid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f mentioned;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer rating;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public FeedItem(Integer num, Long l, Long l2, Long l3, String str, Integer num2, Long l4, f fVar) {
        this.shopid = num;
        this.itemid = l;
        this.cmtid = l2;
        this.price = l3;
        this.comment = str;
        this.rating = num2;
        this.feedid = l4;
        this.mentioned = fVar;
    }

    private FeedItem(Builder builder) {
        this(builder.shopid, builder.itemid, builder.cmtid, builder.price, builder.comment, builder.rating, builder.feedid, builder.mentioned);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedItem)) {
            return false;
        }
        FeedItem feedItem = (FeedItem) obj;
        if (!equals((Object) this.shopid, (Object) feedItem.shopid) || !equals((Object) this.itemid, (Object) feedItem.itemid) || !equals((Object) this.cmtid, (Object) feedItem.cmtid) || !equals((Object) this.price, (Object) feedItem.price) || !equals((Object) this.comment, (Object) feedItem.comment) || !equals((Object) this.rating, (Object) feedItem.rating) || !equals((Object) this.feedid, (Object) feedItem.feedid) || !equals((Object) this.mentioned, (Object) feedItem.mentioned)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.cmtid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.price;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str = this.comment;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.rating;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l4 = this.feedid;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        f fVar = this.mentioned;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FeedItem> {
        public Long cmtid;
        public String comment;
        public Long feedid;
        public Long itemid;
        public f mentioned;
        public Long price;
        public Integer rating;
        public Integer shopid;

        public Builder() {
        }

        public Builder(FeedItem feedItem) {
            super(feedItem);
            if (feedItem != null) {
                this.shopid = feedItem.shopid;
                this.itemid = feedItem.itemid;
                this.cmtid = feedItem.cmtid;
                this.price = feedItem.price;
                this.comment = feedItem.comment;
                this.rating = feedItem.rating;
                this.feedid = feedItem.feedid;
                this.mentioned = feedItem.mentioned;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder comment(String str) {
            this.comment = str;
            return this;
        }

        public Builder rating(Integer num) {
            this.rating = num;
            return this;
        }

        public Builder feedid(Long l) {
            this.feedid = l;
            return this;
        }

        public Builder mentioned(f fVar) {
            this.mentioned = fVar;
            return this;
        }

        public FeedItem build() {
            return new FeedItem(this);
        }
    }
}
