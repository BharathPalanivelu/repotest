package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BundleDealStats extends Message {
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final Integer DEFAULT_QUANTITY_IN_BUNDLE = 0;
    public static final Integer DEFAULT_QUANTITY_TOTAL = 0;
    public static final Long DEFAULT_SAVED_AMOUNT = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer quantity_in_bundle;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer quantity_total;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long saved_amount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public BundleDealStats(Long l, Integer num, Integer num2, Integer num3, Long l2) {
        this.bundle_deal_id = l;
        this.shopid = num;
        this.quantity_in_bundle = num2;
        this.quantity_total = num3;
        this.saved_amount = l2;
    }

    private BundleDealStats(Builder builder) {
        this(builder.bundle_deal_id, builder.shopid, builder.quantity_in_bundle, builder.quantity_total, builder.saved_amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundleDealStats)) {
            return false;
        }
        BundleDealStats bundleDealStats = (BundleDealStats) obj;
        if (!equals((Object) this.bundle_deal_id, (Object) bundleDealStats.bundle_deal_id) || !equals((Object) this.shopid, (Object) bundleDealStats.shopid) || !equals((Object) this.quantity_in_bundle, (Object) bundleDealStats.quantity_in_bundle) || !equals((Object) this.quantity_total, (Object) bundleDealStats.quantity_total) || !equals((Object) this.saved_amount, (Object) bundleDealStats.saved_amount)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.bundle_deal_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.quantity_in_bundle;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.quantity_total;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.saved_amount;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BundleDealStats> {
        public Long bundle_deal_id;
        public Integer quantity_in_bundle;
        public Integer quantity_total;
        public Long saved_amount;
        public Integer shopid;

        public Builder() {
        }

        public Builder(BundleDealStats bundleDealStats) {
            super(bundleDealStats);
            if (bundleDealStats != null) {
                this.bundle_deal_id = bundleDealStats.bundle_deal_id;
                this.shopid = bundleDealStats.shopid;
                this.quantity_in_bundle = bundleDealStats.quantity_in_bundle;
                this.quantity_total = bundleDealStats.quantity_total;
                this.saved_amount = bundleDealStats.saved_amount;
            }
        }

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder quantity_in_bundle(Integer num) {
            this.quantity_in_bundle = num;
            return this;
        }

        public Builder quantity_total(Integer num) {
            this.quantity_total = num;
            return this;
        }

        public Builder saved_amount(Long l) {
            this.saved_amount = l;
            return this;
        }

        public BundleDealStats build() {
            return new BundleDealStats(this);
        }
    }
}
