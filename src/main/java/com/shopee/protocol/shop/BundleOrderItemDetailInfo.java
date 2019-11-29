package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BundleOrderItemDetailInfo extends Message {
    public static final Integer DEFAULT_AMOUNT = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_PRICE = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer amount;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long item_price;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long snapshotid;

    public BundleOrderItemDetailInfo(Long l, Long l2, Integer num, Long l3, Long l4) {
        this.itemid = l;
        this.modelid = l2;
        this.amount = num;
        this.item_price = l3;
        this.snapshotid = l4;
    }

    private BundleOrderItemDetailInfo(Builder builder) {
        this(builder.itemid, builder.modelid, builder.amount, builder.item_price, builder.snapshotid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundleOrderItemDetailInfo)) {
            return false;
        }
        BundleOrderItemDetailInfo bundleOrderItemDetailInfo = (BundleOrderItemDetailInfo) obj;
        if (!equals((Object) this.itemid, (Object) bundleOrderItemDetailInfo.itemid) || !equals((Object) this.modelid, (Object) bundleOrderItemDetailInfo.modelid) || !equals((Object) this.amount, (Object) bundleOrderItemDetailInfo.amount) || !equals((Object) this.item_price, (Object) bundleOrderItemDetailInfo.item_price) || !equals((Object) this.snapshotid, (Object) bundleOrderItemDetailInfo.snapshotid)) {
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
        Long l2 = this.modelid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.amount;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.item_price;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.snapshotid;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BundleOrderItemDetailInfo> {
        public Integer amount;
        public Long item_price;
        public Long itemid;
        public Long modelid;
        public Long snapshotid;

        public Builder() {
        }

        public Builder(BundleOrderItemDetailInfo bundleOrderItemDetailInfo) {
            super(bundleOrderItemDetailInfo);
            if (bundleOrderItemDetailInfo != null) {
                this.itemid = bundleOrderItemDetailInfo.itemid;
                this.modelid = bundleOrderItemDetailInfo.modelid;
                this.amount = bundleOrderItemDetailInfo.amount;
                this.item_price = bundleOrderItemDetailInfo.item_price;
                this.snapshotid = bundleOrderItemDetailInfo.snapshotid;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder amount(Integer num) {
            this.amount = num;
            return this;
        }

        public Builder item_price(Long l) {
            this.item_price = l;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public BundleOrderItemDetailInfo build() {
            return new BundleOrderItemDetailInfo(this);
        }
    }
}
