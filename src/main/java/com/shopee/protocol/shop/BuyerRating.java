package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BuyerRating extends Message {
    public static final Integer DEFAULT_RATING_AUTO = 0;
    public static final Integer DEFAULT_RATING_BAD = 0;
    public static final Integer DEFAULT_RATING_BAD_BYME = 0;
    public static final List<Integer> DEFAULT_RATING_BYME_COUNT = Collections.emptyList();
    public static final List<Integer> DEFAULT_RATING_COUNT = Collections.emptyList();
    public static final Integer DEFAULT_RATING_GOOD = 0;
    public static final Integer DEFAULT_RATING_GOOD_BYME = 0;
    public static final Integer DEFAULT_RATING_NORMAL = 0;
    public static final Integer DEFAULT_RATING_NORMAL_BYME = 0;
    public static final Double DEFAULT_RATING_STAR = Double.valueOf(0.0d);
    public static final Integer DEFAULT_STAR = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer rating_auto;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer rating_bad;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer rating_bad_byme;
    @ProtoField(label = Message.Label.REPEATED, tag = 11, type = Message.Datatype.INT32)
    public final List<Integer> rating_byme_count;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT32)
    public final List<Integer> rating_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rating_good;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer rating_good_byme;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer rating_normal;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer rating_normal_byme;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double rating_star;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer star;

    public BuyerRating(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Double d2, List<Integer> list, List<Integer> list2) {
        this.rating_good = num;
        this.rating_normal = num2;
        this.rating_bad = num3;
        this.star = num4;
        this.rating_good_byme = num5;
        this.rating_normal_byme = num6;
        this.rating_bad_byme = num7;
        this.rating_auto = num8;
        this.rating_star = d2;
        this.rating_count = immutableCopyOf(list);
        this.rating_byme_count = immutableCopyOf(list2);
    }

    private BuyerRating(Builder builder) {
        this(builder.rating_good, builder.rating_normal, builder.rating_bad, builder.star, builder.rating_good_byme, builder.rating_normal_byme, builder.rating_bad_byme, builder.rating_auto, builder.rating_star, builder.rating_count, builder.rating_byme_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyerRating)) {
            return false;
        }
        BuyerRating buyerRating = (BuyerRating) obj;
        if (!equals((Object) this.rating_good, (Object) buyerRating.rating_good) || !equals((Object) this.rating_normal, (Object) buyerRating.rating_normal) || !equals((Object) this.rating_bad, (Object) buyerRating.rating_bad) || !equals((Object) this.star, (Object) buyerRating.star) || !equals((Object) this.rating_good_byme, (Object) buyerRating.rating_good_byme) || !equals((Object) this.rating_normal_byme, (Object) buyerRating.rating_normal_byme) || !equals((Object) this.rating_bad_byme, (Object) buyerRating.rating_bad_byme) || !equals((Object) this.rating_auto, (Object) buyerRating.rating_auto) || !equals((Object) this.rating_star, (Object) buyerRating.rating_star) || !equals((List<?>) this.rating_count, (List<?>) buyerRating.rating_count) || !equals((List<?>) this.rating_byme_count, (List<?>) buyerRating.rating_byme_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.rating_good;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.rating_normal;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.rating_bad;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.star;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.rating_good_byme;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.rating_normal_byme;
        int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.rating_bad_byme;
        int hashCode7 = (hashCode6 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.rating_auto;
        int hashCode8 = (hashCode7 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Double d2 = this.rating_star;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = (hashCode8 + i2) * 37;
        List<Integer> list = this.rating_count;
        int i4 = 1;
        int hashCode9 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.rating_byme_count;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode9 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<BuyerRating> {
        public Integer rating_auto;
        public Integer rating_bad;
        public Integer rating_bad_byme;
        public List<Integer> rating_byme_count;
        public List<Integer> rating_count;
        public Integer rating_good;
        public Integer rating_good_byme;
        public Integer rating_normal;
        public Integer rating_normal_byme;
        public Double rating_star;
        public Integer star;

        public Builder() {
        }

        public Builder(BuyerRating buyerRating) {
            super(buyerRating);
            if (buyerRating != null) {
                this.rating_good = buyerRating.rating_good;
                this.rating_normal = buyerRating.rating_normal;
                this.rating_bad = buyerRating.rating_bad;
                this.star = buyerRating.star;
                this.rating_good_byme = buyerRating.rating_good_byme;
                this.rating_normal_byme = buyerRating.rating_normal_byme;
                this.rating_bad_byme = buyerRating.rating_bad_byme;
                this.rating_auto = buyerRating.rating_auto;
                this.rating_star = buyerRating.rating_star;
                this.rating_count = BuyerRating.copyOf(buyerRating.rating_count);
                this.rating_byme_count = BuyerRating.copyOf(buyerRating.rating_byme_count);
            }
        }

        public Builder rating_good(Integer num) {
            this.rating_good = num;
            return this;
        }

        public Builder rating_normal(Integer num) {
            this.rating_normal = num;
            return this;
        }

        public Builder rating_bad(Integer num) {
            this.rating_bad = num;
            return this;
        }

        public Builder star(Integer num) {
            this.star = num;
            return this;
        }

        public Builder rating_good_byme(Integer num) {
            this.rating_good_byme = num;
            return this;
        }

        public Builder rating_normal_byme(Integer num) {
            this.rating_normal_byme = num;
            return this;
        }

        public Builder rating_bad_byme(Integer num) {
            this.rating_bad_byme = num;
            return this;
        }

        public Builder rating_auto(Integer num) {
            this.rating_auto = num;
            return this;
        }

        public Builder rating_star(Double d2) {
            this.rating_star = d2;
            return this;
        }

        public Builder rating_count(List<Integer> list) {
            this.rating_count = checkForNulls(list);
            return this;
        }

        public Builder rating_byme_count(List<Integer> list) {
            this.rating_byme_count = checkForNulls(list);
            return this;
        }

        public BuyerRating build() {
            return new BuyerRating(this);
        }
    }
}
