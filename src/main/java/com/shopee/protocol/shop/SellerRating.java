package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SellerRating extends Message {
    public static final List<Integer> DEFAULT_RATING_BYME_COUNT = Collections.emptyList();
    public static final List<Integer> DEFAULT_RATING_COUNT = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> rating_byme_count;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> rating_count;

    public SellerRating(List<Integer> list, List<Integer> list2) {
        this.rating_count = immutableCopyOf(list);
        this.rating_byme_count = immutableCopyOf(list2);
    }

    private SellerRating(Builder builder) {
        this(builder.rating_count, builder.rating_byme_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerRating)) {
            return false;
        }
        SellerRating sellerRating = (SellerRating) obj;
        if (!equals((List<?>) this.rating_count, (List<?>) sellerRating.rating_count) || !equals((List<?>) this.rating_byme_count, (List<?>) sellerRating.rating_byme_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Integer> list = this.rating_count;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Integer> list2 = this.rating_byme_count;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerRating> {
        public List<Integer> rating_byme_count;
        public List<Integer> rating_count;

        public Builder() {
        }

        public Builder(SellerRating sellerRating) {
            super(sellerRating);
            if (sellerRating != null) {
                this.rating_count = SellerRating.copyOf(sellerRating.rating_count);
                this.rating_byme_count = SellerRating.copyOf(sellerRating.rating_byme_count);
            }
        }

        public Builder rating_count(List<Integer> list) {
            this.rating_count = checkForNulls(list);
            return this;
        }

        public Builder rating_byme_count(List<Integer> list) {
            this.rating_byme_count = checkForNulls(list);
            return this;
        }

        public SellerRating build() {
            return new SellerRating(this);
        }
    }
}
