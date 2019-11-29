package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchItemScore extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_VIEW_COUNT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long view_count;

    public SearchItemScore(Long l, Integer num, Long l2) {
        this.itemid = l;
        this.shopid = num;
        this.view_count = l2;
    }

    private SearchItemScore(Builder builder) {
        this(builder.itemid, builder.shopid, builder.view_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchItemScore)) {
            return false;
        }
        SearchItemScore searchItemScore = (SearchItemScore) obj;
        if (!equals((Object) this.itemid, (Object) searchItemScore.itemid) || !equals((Object) this.shopid, (Object) searchItemScore.shopid) || !equals((Object) this.view_count, (Object) searchItemScore.view_count)) {
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
        Long l2 = this.view_count;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchItemScore> {
        public Long itemid;
        public Integer shopid;
        public Long view_count;

        public Builder() {
        }

        public Builder(SearchItemScore searchItemScore) {
            super(searchItemScore);
            if (searchItemScore != null) {
                this.itemid = searchItemScore.itemid;
                this.shopid = searchItemScore.shopid;
                this.view_count = searchItemScore.view_count;
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

        public Builder view_count(Long l) {
            this.view_count = l;
            return this;
        }

        public SearchItemScore build() {
            return new SearchItemScore(this);
        }
    }
}
