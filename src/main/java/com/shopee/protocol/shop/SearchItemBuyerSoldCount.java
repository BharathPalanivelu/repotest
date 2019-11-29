package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchItemBuyerSoldCount extends Message {
    public static final Long DEFAULT_SOLDCOUNT_LONGTERM = 0L;
    public static final Long DEFAULT_SOLDCOUNT_SHORTTERM = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long soldcount_longterm;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long soldcount_shortterm;

    public SearchItemBuyerSoldCount(Long l, Long l2) {
        this.soldcount_shortterm = l;
        this.soldcount_longterm = l2;
    }

    private SearchItemBuyerSoldCount(Builder builder) {
        this(builder.soldcount_shortterm, builder.soldcount_longterm);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchItemBuyerSoldCount)) {
            return false;
        }
        SearchItemBuyerSoldCount searchItemBuyerSoldCount = (SearchItemBuyerSoldCount) obj;
        if (!equals((Object) this.soldcount_shortterm, (Object) searchItemBuyerSoldCount.soldcount_shortterm) || !equals((Object) this.soldcount_longterm, (Object) searchItemBuyerSoldCount.soldcount_longterm)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.soldcount_shortterm;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.soldcount_longterm;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchItemBuyerSoldCount> {
        public Long soldcount_longterm;
        public Long soldcount_shortterm;

        public Builder() {
        }

        public Builder(SearchItemBuyerSoldCount searchItemBuyerSoldCount) {
            super(searchItemBuyerSoldCount);
            if (searchItemBuyerSoldCount != null) {
                this.soldcount_shortterm = searchItemBuyerSoldCount.soldcount_shortterm;
                this.soldcount_longterm = searchItemBuyerSoldCount.soldcount_longterm;
            }
        }

        public Builder soldcount_shortterm(Long l) {
            this.soldcount_shortterm = l;
            return this;
        }

        public Builder soldcount_longterm(Long l) {
            this.soldcount_longterm = l;
            return this;
        }

        public SearchItemBuyerSoldCount build() {
            return new SearchItemBuyerSoldCount(this);
        }
    }
}
