package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RecFeeds extends Message {
    public static final Integer DEFAULT_FROM = 0;
    public static final List<RecFeedItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer from;
    @ProtoField(label = Message.Label.REPEATED, messageType = RecFeedItem.class, tag = 3)
    public final List<RecFeedItem> items;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public RecFeeds(Integer num, Integer num2, List<RecFeedItem> list) {
        this.shopid = num;
        this.from = num2;
        this.items = immutableCopyOf(list);
    }

    private RecFeeds(Builder builder) {
        this(builder.shopid, builder.from, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecFeeds)) {
            return false;
        }
        RecFeeds recFeeds = (RecFeeds) obj;
        if (!equals((Object) this.shopid, (Object) recFeeds.shopid) || !equals((Object) this.from, (Object) recFeeds.from) || !equals((List<?>) this.items, (List<?>) recFeeds.items)) {
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
        Integer num2 = this.from;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<RecFeedItem> list = this.items;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<RecFeeds> {
        public Integer from;
        public List<RecFeedItem> items;
        public Integer shopid;

        public Builder() {
        }

        public Builder(RecFeeds recFeeds) {
            super(recFeeds);
            if (recFeeds != null) {
                this.shopid = recFeeds.shopid;
                this.from = recFeeds.from;
                this.items = RecFeeds.copyOf(recFeeds.items);
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder from(Integer num) {
            this.from = num;
            return this;
        }

        public Builder items(List<RecFeedItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public RecFeeds build() {
            return new RecFeeds(this);
        }
    }
}
