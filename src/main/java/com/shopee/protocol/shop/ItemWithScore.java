package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemWithScore extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Double DEFAULT_FSCORE = Double.valueOf(0.0d);
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_SCORE = 0L;
    public static final List<Long> DEFAULT_SCORES = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double fscore;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long score;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT64)
    public final List<Long> scores;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long timestamp;

    public ItemWithScore(Long l, Integer num, Long l2, Double d2, Long l3, Long l4, List<Long> list) {
        this.itemid = l;
        this.shopid = num;
        this.score = l2;
        this.fscore = d2;
        this.adsid = l3;
        this.timestamp = l4;
        this.scores = immutableCopyOf(list);
    }

    private ItemWithScore(Builder builder) {
        this(builder.itemid, builder.shopid, builder.score, builder.fscore, builder.adsid, builder.timestamp, builder.scores);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemWithScore)) {
            return false;
        }
        ItemWithScore itemWithScore = (ItemWithScore) obj;
        if (!equals((Object) this.itemid, (Object) itemWithScore.itemid) || !equals((Object) this.shopid, (Object) itemWithScore.shopid) || !equals((Object) this.score, (Object) itemWithScore.score) || !equals((Object) this.fscore, (Object) itemWithScore.fscore) || !equals((Object) this.adsid, (Object) itemWithScore.adsid) || !equals((Object) this.timestamp, (Object) itemWithScore.timestamp) || !equals((List<?>) this.scores, (List<?>) itemWithScore.scores)) {
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
        Long l2 = this.score;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Double d2 = this.fscore;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Long l3 = this.adsid;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.timestamp;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = (hashCode5 + i2) * 37;
        List<Long> list = this.scores;
        int hashCode6 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    public static final class Builder extends Message.Builder<ItemWithScore> {
        public Long adsid;
        public Double fscore;
        public Long itemid;
        public Long score;
        public List<Long> scores;
        public Integer shopid;
        public Long timestamp;

        public Builder() {
        }

        public Builder(ItemWithScore itemWithScore) {
            super(itemWithScore);
            if (itemWithScore != null) {
                this.itemid = itemWithScore.itemid;
                this.shopid = itemWithScore.shopid;
                this.score = itemWithScore.score;
                this.fscore = itemWithScore.fscore;
                this.adsid = itemWithScore.adsid;
                this.timestamp = itemWithScore.timestamp;
                this.scores = ItemWithScore.copyOf(itemWithScore.scores);
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

        public Builder score(Long l) {
            this.score = l;
            return this;
        }

        public Builder fscore(Double d2) {
            this.fscore = d2;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder scores(List<Long> list) {
            this.scores = checkForNulls(list);
            return this;
        }

        public ItemWithScore build() {
            return new ItemWithScore(this);
        }
    }
}
