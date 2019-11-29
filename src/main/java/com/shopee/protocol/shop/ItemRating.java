package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemRating extends Message {
    public static final List<Integer> DEFAULT_RATING_COUNT = Collections.emptyList();
    public static final Double DEFAULT_RATING_STAR = Double.valueOf(0.0d);
    public static final Integer DEFAULT_RCOUNT_WITH_CONTEXT = 0;
    public static final Integer DEFAULT_RCOUNT_WITH_IMAGE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> rating_count;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double rating_star;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer rcount_with_context;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer rcount_with_image;

    public ItemRating(Double d2, List<Integer> list, Integer num, Integer num2) {
        this.rating_star = d2;
        this.rating_count = immutableCopyOf(list);
        this.rcount_with_context = num;
        this.rcount_with_image = num2;
    }

    private ItemRating(Builder builder) {
        this(builder.rating_star, builder.rating_count, builder.rcount_with_context, builder.rcount_with_image);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemRating)) {
            return false;
        }
        ItemRating itemRating = (ItemRating) obj;
        if (!equals((Object) this.rating_star, (Object) itemRating.rating_star) || !equals((List<?>) this.rating_count, (List<?>) itemRating.rating_count) || !equals((Object) this.rcount_with_context, (Object) itemRating.rcount_with_context) || !equals((Object) this.rcount_with_image, (Object) itemRating.rcount_with_image)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d2 = this.rating_star;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 37;
        List<Integer> list = this.rating_count;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.rcount_with_context;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.rcount_with_image;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemRating> {
        public List<Integer> rating_count;
        public Double rating_star;
        public Integer rcount_with_context;
        public Integer rcount_with_image;

        public Builder() {
        }

        public Builder(ItemRating itemRating) {
            super(itemRating);
            if (itemRating != null) {
                this.rating_star = itemRating.rating_star;
                this.rating_count = ItemRating.copyOf(itemRating.rating_count);
                this.rcount_with_context = itemRating.rcount_with_context;
                this.rcount_with_image = itemRating.rcount_with_image;
            }
        }

        public Builder rating_star(Double d2) {
            this.rating_star = d2;
            return this;
        }

        public Builder rating_count(List<Integer> list) {
            this.rating_count = checkForNulls(list);
            return this;
        }

        public Builder rcount_with_context(Integer num) {
            this.rcount_with_context = num;
            return this;
        }

        public Builder rcount_with_image(Integer num) {
            this.rcount_with_image = num;
            return this;
        }

        public ItemRating build() {
            return new ItemRating(this);
        }
    }
}
