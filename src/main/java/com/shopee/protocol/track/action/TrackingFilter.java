package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackingFilter extends Message {
    public static final List<TrackingCategory> DEFAULT_CATEGORY = Collections.emptyList();
    public static final Integer DEFAULT_CONDITION = 0;
    public static final Boolean DEFAULT_FREE_SHIPPING = false;
    public static final Integer DEFAULT_PRICE_FILTER_TYPE = 0;
    public static final Integer DEFAULT_PRICE_MAX = 0;
    public static final Integer DEFAULT_PRICE_MIN = 0;
    public static final List<TrackingShippedFrom> DEFAULT_SHIPPED_FROM = Collections.emptyList();
    public static final Boolean DEFAULT_SHOPEE_PREFERRED = false;
    public static final Integer DEFAULT_SHOPEE_PREFERRED_FILTER_TYPE = 0;
    public static final Boolean DEFAULT_WHOLESALE = false;
    public static final Boolean DEFAULT_WITH_DISCOUNT = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingCategory.class, tag = 3)
    public final List<TrackingCategory> category;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer condition;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean free_shipping;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer price_filter_type;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer price_max;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer price_min;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingShippedFrom.class, tag = 4)
    public final List<TrackingShippedFrom> shipped_from;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean shopee_preferred;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopee_preferred_filter_type;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean wholesale;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean with_discount;

    public TrackingFilter(Integer num, Integer num2, List<TrackingCategory> list, List<TrackingShippedFrom> list2, Integer num3, Integer num4, Integer num5, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.shopee_preferred_filter_type = num;
        this.price_filter_type = num2;
        this.category = immutableCopyOf(list);
        this.shipped_from = immutableCopyOf(list2);
        this.condition = num3;
        this.price_max = num4;
        this.price_min = num5;
        this.wholesale = bool;
        this.shopee_preferred = bool2;
        this.with_discount = bool3;
        this.free_shipping = bool4;
    }

    private TrackingFilter(Builder builder) {
        this(builder.shopee_preferred_filter_type, builder.price_filter_type, builder.category, builder.shipped_from, builder.condition, builder.price_max, builder.price_min, builder.wholesale, builder.shopee_preferred, builder.with_discount, builder.free_shipping);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingFilter)) {
            return false;
        }
        TrackingFilter trackingFilter = (TrackingFilter) obj;
        if (!equals((Object) this.shopee_preferred_filter_type, (Object) trackingFilter.shopee_preferred_filter_type) || !equals((Object) this.price_filter_type, (Object) trackingFilter.price_filter_type) || !equals((List<?>) this.category, (List<?>) trackingFilter.category) || !equals((List<?>) this.shipped_from, (List<?>) trackingFilter.shipped_from) || !equals((Object) this.condition, (Object) trackingFilter.condition) || !equals((Object) this.price_max, (Object) trackingFilter.price_max) || !equals((Object) this.price_min, (Object) trackingFilter.price_min) || !equals((Object) this.wholesale, (Object) trackingFilter.wholesale) || !equals((Object) this.shopee_preferred, (Object) trackingFilter.shopee_preferred) || !equals((Object) this.with_discount, (Object) trackingFilter.with_discount) || !equals((Object) this.free_shipping, (Object) trackingFilter.free_shipping)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopee_preferred_filter_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.price_filter_type;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<TrackingCategory> list = this.category;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<TrackingShippedFrom> list2 = this.shipped_from;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        Integer num3 = this.condition;
        int hashCode4 = (i4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.price_max;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.price_min;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool = this.wholesale;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.shopee_preferred;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.with_discount;
        int hashCode9 = (hashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.free_shipping;
        if (bool4 != null) {
            i2 = bool4.hashCode();
        }
        int i5 = hashCode9 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<TrackingFilter> {
        public List<TrackingCategory> category;
        public Integer condition;
        public Boolean free_shipping;
        public Integer price_filter_type;
        public Integer price_max;
        public Integer price_min;
        public List<TrackingShippedFrom> shipped_from;
        public Boolean shopee_preferred;
        public Integer shopee_preferred_filter_type;
        public Boolean wholesale;
        public Boolean with_discount;

        public Builder() {
        }

        public Builder(TrackingFilter trackingFilter) {
            super(trackingFilter);
            if (trackingFilter != null) {
                this.shopee_preferred_filter_type = trackingFilter.shopee_preferred_filter_type;
                this.price_filter_type = trackingFilter.price_filter_type;
                this.category = TrackingFilter.copyOf(trackingFilter.category);
                this.shipped_from = TrackingFilter.copyOf(trackingFilter.shipped_from);
                this.condition = trackingFilter.condition;
                this.price_max = trackingFilter.price_max;
                this.price_min = trackingFilter.price_min;
                this.wholesale = trackingFilter.wholesale;
                this.shopee_preferred = trackingFilter.shopee_preferred;
                this.with_discount = trackingFilter.with_discount;
                this.free_shipping = trackingFilter.free_shipping;
            }
        }

        public Builder shopee_preferred_filter_type(Integer num) {
            this.shopee_preferred_filter_type = num;
            return this;
        }

        public Builder price_filter_type(Integer num) {
            this.price_filter_type = num;
            return this;
        }

        public Builder category(List<TrackingCategory> list) {
            this.category = checkForNulls(list);
            return this;
        }

        public Builder shipped_from(List<TrackingShippedFrom> list) {
            this.shipped_from = checkForNulls(list);
            return this;
        }

        public Builder condition(Integer num) {
            this.condition = num;
            return this;
        }

        public Builder price_max(Integer num) {
            this.price_max = num;
            return this;
        }

        public Builder price_min(Integer num) {
            this.price_min = num;
            return this;
        }

        public Builder wholesale(Boolean bool) {
            this.wholesale = bool;
            return this;
        }

        public Builder shopee_preferred(Boolean bool) {
            this.shopee_preferred = bool;
            return this;
        }

        public Builder with_discount(Boolean bool) {
            this.with_discount = bool;
            return this;
        }

        public Builder free_shipping(Boolean bool) {
            this.free_shipping = bool;
            return this;
        }

        public TrackingFilter build() {
            return new TrackingFilter(this);
        }
    }
}
