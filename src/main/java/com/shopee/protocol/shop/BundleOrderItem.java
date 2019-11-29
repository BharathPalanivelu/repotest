package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BundleOrderItem extends Message {
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final List<BundleOrderItemDetailInfo> DEFAULT_ITEM_LIST = Collections.emptyList();
    public static final Long DEFAULT_PRICE_BEFORE_BUNDLE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(label = Message.Label.REPEATED, messageType = BundleOrderItemDetailInfo.class, tag = 3)
    public final List<BundleOrderItemDetailInfo> item_list;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long price_before_bundle;

    public BundleOrderItem(Long l, Long l2, List<BundleOrderItemDetailInfo> list) {
        this.bundle_deal_id = l;
        this.price_before_bundle = l2;
        this.item_list = immutableCopyOf(list);
    }

    private BundleOrderItem(Builder builder) {
        this(builder.bundle_deal_id, builder.price_before_bundle, builder.item_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundleOrderItem)) {
            return false;
        }
        BundleOrderItem bundleOrderItem = (BundleOrderItem) obj;
        if (!equals((Object) this.bundle_deal_id, (Object) bundleOrderItem.bundle_deal_id) || !equals((Object) this.price_before_bundle, (Object) bundleOrderItem.price_before_bundle) || !equals((List<?>) this.item_list, (List<?>) bundleOrderItem.item_list)) {
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
        Long l2 = this.price_before_bundle;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<BundleOrderItemDetailInfo> list = this.item_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BundleOrderItem> {
        public Long bundle_deal_id;
        public List<BundleOrderItemDetailInfo> item_list;
        public Long price_before_bundle;

        public Builder() {
        }

        public Builder(BundleOrderItem bundleOrderItem) {
            super(bundleOrderItem);
            if (bundleOrderItem != null) {
                this.bundle_deal_id = bundleOrderItem.bundle_deal_id;
                this.price_before_bundle = bundleOrderItem.price_before_bundle;
                this.item_list = BundleOrderItem.copyOf(bundleOrderItem.item_list);
            }
        }

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder price_before_bundle(Long l) {
            this.price_before_bundle = l;
            return this;
        }

        public Builder item_list(List<BundleOrderItemDetailInfo> list) {
            this.item_list = checkForNulls(list);
            return this;
        }

        public BundleOrderItem build() {
            return new BundleOrderItem(this);
        }
    }
}
