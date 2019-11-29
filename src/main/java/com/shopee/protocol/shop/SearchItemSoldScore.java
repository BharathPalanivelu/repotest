package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchItemSoldScore extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_SCORE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Double DEFAULT_SOLDSCORE_LONGTERM;
    public static final Double DEFAULT_SOLDSCORE_SHORTTERM;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long score;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double soldscore_longterm;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double soldscore_shortterm;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_SOLDSCORE_SHORTTERM = valueOf;
        DEFAULT_SOLDSCORE_LONGTERM = valueOf;
    }

    public SearchItemSoldScore(Long l, Long l2, Double d2, Double d3, Integer num) {
        this.score = l;
        this.itemid = l2;
        this.soldscore_shortterm = d2;
        this.soldscore_longterm = d3;
        this.shopid = num;
    }

    private SearchItemSoldScore(Builder builder) {
        this(builder.score, builder.itemid, builder.soldscore_shortterm, builder.soldscore_longterm, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchItemSoldScore)) {
            return false;
        }
        SearchItemSoldScore searchItemSoldScore = (SearchItemSoldScore) obj;
        if (!equals((Object) this.score, (Object) searchItemSoldScore.score) || !equals((Object) this.itemid, (Object) searchItemSoldScore.itemid) || !equals((Object) this.soldscore_shortterm, (Object) searchItemSoldScore.soldscore_shortterm) || !equals((Object) this.soldscore_longterm, (Object) searchItemSoldScore.soldscore_longterm) || !equals((Object) this.shopid, (Object) searchItemSoldScore.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.score;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.itemid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Double d2 = this.soldscore_shortterm;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.soldscore_longterm;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchItemSoldScore> {
        public Long itemid;
        public Long score;
        public Integer shopid;
        public Double soldscore_longterm;
        public Double soldscore_shortterm;

        public Builder() {
        }

        public Builder(SearchItemSoldScore searchItemSoldScore) {
            super(searchItemSoldScore);
            if (searchItemSoldScore != null) {
                this.score = searchItemSoldScore.score;
                this.itemid = searchItemSoldScore.itemid;
                this.soldscore_shortterm = searchItemSoldScore.soldscore_shortterm;
                this.soldscore_longterm = searchItemSoldScore.soldscore_longterm;
                this.shopid = searchItemSoldScore.shopid;
            }
        }

        public Builder score(Long l) {
            this.score = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder soldscore_shortterm(Double d2) {
            this.soldscore_shortterm = d2;
            return this;
        }

        public Builder soldscore_longterm(Double d2) {
            this.soldscore_longterm = d2;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public SearchItemSoldScore build() {
            return new SearchItemSoldScore(this);
        }
    }
}
