package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BundleDealItem extends Message {
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;

    public BundleDealItem(Long l, Integer num, Long l2, Long l3, Integer num2, Integer num3, Integer num4) {
        this.id = l;
        this.shopid = num;
        this.itemid = l2;
        this.bundle_deal_id = l3;
        this.start_time = num2;
        this.end_time = num3;
        this.status = num4;
    }

    private BundleDealItem(Builder builder) {
        this(builder.id, builder.shopid, builder.itemid, builder.bundle_deal_id, builder.start_time, builder.end_time, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundleDealItem)) {
            return false;
        }
        BundleDealItem bundleDealItem = (BundleDealItem) obj;
        if (!equals((Object) this.id, (Object) bundleDealItem.id) || !equals((Object) this.shopid, (Object) bundleDealItem.shopid) || !equals((Object) this.itemid, (Object) bundleDealItem.itemid) || !equals((Object) this.bundle_deal_id, (Object) bundleDealItem.bundle_deal_id) || !equals((Object) this.start_time, (Object) bundleDealItem.start_time) || !equals((Object) this.end_time, (Object) bundleDealItem.end_time) || !equals((Object) this.status, (Object) bundleDealItem.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.bundle_deal_id;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.start_time;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BundleDealItem> {
        public Long bundle_deal_id;
        public Integer end_time;
        public Long id;
        public Long itemid;
        public Integer shopid;
        public Integer start_time;
        public Integer status;

        public Builder() {
        }

        public Builder(BundleDealItem bundleDealItem) {
            super(bundleDealItem);
            if (bundleDealItem != null) {
                this.id = bundleDealItem.id;
                this.shopid = bundleDealItem.shopid;
                this.itemid = bundleDealItem.itemid;
                this.bundle_deal_id = bundleDealItem.bundle_deal_id;
                this.start_time = bundleDealItem.start_time;
                this.end_time = bundleDealItem.end_time;
                this.status = bundleDealItem.status;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public BundleDealItem build() {
            return new BundleDealItem(this);
        }
    }
}
