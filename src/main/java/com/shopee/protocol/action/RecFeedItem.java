package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RecFeedItem extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SCORE = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer score;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer source;

    public RecFeedItem(Integer num, Long l, Integer num2, Integer num3) {
        this.shopid = num;
        this.itemid = l;
        this.score = num2;
        this.source = num3;
    }

    private RecFeedItem(Builder builder) {
        this(builder.shopid, builder.itemid, builder.score, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecFeedItem)) {
            return false;
        }
        RecFeedItem recFeedItem = (RecFeedItem) obj;
        if (!equals((Object) this.shopid, (Object) recFeedItem.shopid) || !equals((Object) this.itemid, (Object) recFeedItem.itemid) || !equals((Object) this.score, (Object) recFeedItem.score) || !equals((Object) this.source, (Object) recFeedItem.source)) {
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
        Integer num2 = this.score;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.source;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RecFeedItem> {
        public Long itemid;
        public Integer score;
        public Integer shopid;
        public Integer source;

        public Builder() {
        }

        public Builder(RecFeedItem recFeedItem) {
            super(recFeedItem);
            if (recFeedItem != null) {
                this.shopid = recFeedItem.shopid;
                this.itemid = recFeedItem.itemid;
                this.score = recFeedItem.score;
                this.source = recFeedItem.source;
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

        public Builder score(Integer num) {
            this.score = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public RecFeedItem build() {
            return new RecFeedItem(this);
        }
    }
}
