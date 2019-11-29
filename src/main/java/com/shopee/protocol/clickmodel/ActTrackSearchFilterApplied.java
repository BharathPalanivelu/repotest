package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActTrackSearchFilterApplied extends Message {
    public static final String DEFAULT_CATEGORYIDS = "";
    public static final String DEFAULT_CONDITIONS = "";
    public static final String DEFAULT_PRICE_MAX = "";
    public static final String DEFAULT_PRICE_MIN = "";
    public static final Boolean DEFAULT_SHIPPING_FEE_INCLUDED = false;
    public static final Boolean DEFAULT_SHOPEE_VERIFIED = false;
    public static final Boolean DEFAULT_WITH_DISCOUNT = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String categoryids;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String conditions;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String price_max;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String price_min;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean shipping_fee_included;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean shopee_verified;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean with_discount;

    public ActTrackSearchFilterApplied(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, String str3, String str4) {
        this.categoryids = str;
        this.conditions = str2;
        this.with_discount = bool;
        this.shopee_verified = bool2;
        this.shipping_fee_included = bool3;
        this.price_min = str3;
        this.price_max = str4;
    }

    private ActTrackSearchFilterApplied(Builder builder) {
        this(builder.categoryids, builder.conditions, builder.with_discount, builder.shopee_verified, builder.shipping_fee_included, builder.price_min, builder.price_max);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTrackSearchFilterApplied)) {
            return false;
        }
        ActTrackSearchFilterApplied actTrackSearchFilterApplied = (ActTrackSearchFilterApplied) obj;
        if (!equals((Object) this.categoryids, (Object) actTrackSearchFilterApplied.categoryids) || !equals((Object) this.conditions, (Object) actTrackSearchFilterApplied.conditions) || !equals((Object) this.with_discount, (Object) actTrackSearchFilterApplied.with_discount) || !equals((Object) this.shopee_verified, (Object) actTrackSearchFilterApplied.shopee_verified) || !equals((Object) this.shipping_fee_included, (Object) actTrackSearchFilterApplied.shipping_fee_included) || !equals((Object) this.price_min, (Object) actTrackSearchFilterApplied.price_min) || !equals((Object) this.price_max, (Object) actTrackSearchFilterApplied.price_max)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.categoryids;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.conditions;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.with_discount;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.shopee_verified;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.shipping_fee_included;
        int hashCode5 = (hashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        String str3 = this.price_min;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.price_max;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActTrackSearchFilterApplied> {
        public String categoryids;
        public String conditions;
        public String price_max;
        public String price_min;
        public Boolean shipping_fee_included;
        public Boolean shopee_verified;
        public Boolean with_discount;

        public Builder() {
        }

        public Builder(ActTrackSearchFilterApplied actTrackSearchFilterApplied) {
            super(actTrackSearchFilterApplied);
            if (actTrackSearchFilterApplied != null) {
                this.categoryids = actTrackSearchFilterApplied.categoryids;
                this.conditions = actTrackSearchFilterApplied.conditions;
                this.with_discount = actTrackSearchFilterApplied.with_discount;
                this.shopee_verified = actTrackSearchFilterApplied.shopee_verified;
                this.shipping_fee_included = actTrackSearchFilterApplied.shipping_fee_included;
                this.price_min = actTrackSearchFilterApplied.price_min;
                this.price_max = actTrackSearchFilterApplied.price_max;
            }
        }

        public Builder categoryids(String str) {
            this.categoryids = str;
            return this;
        }

        public Builder conditions(String str) {
            this.conditions = str;
            return this;
        }

        public Builder with_discount(Boolean bool) {
            this.with_discount = bool;
            return this;
        }

        public Builder shopee_verified(Boolean bool) {
            this.shopee_verified = bool;
            return this;
        }

        public Builder shipping_fee_included(Boolean bool) {
            this.shipping_fee_included = bool;
            return this;
        }

        public Builder price_min(String str) {
            this.price_min = str;
            return this;
        }

        public Builder price_max(String str) {
            this.price_max = str;
            return this;
        }

        public ActTrackSearchFilterApplied build() {
            return new ActTrackSearchFilterApplied(this);
        }
    }
}
