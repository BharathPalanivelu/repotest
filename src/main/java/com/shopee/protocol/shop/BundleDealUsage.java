package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BundleDealUsage extends Message {
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final Integer DEFAULT_COUNT = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public BundleDealUsage(Long l, Long l2, Long l3, Integer num, Integer num2, Integer num3, Integer num4) {
        this.id = l;
        this.bundle_deal_id = l2;
        this.orderid = l3;
        this.userid = num;
        this.ctime = num2;
        this.status = num3;
        this.count = num4;
    }

    private BundleDealUsage(Builder builder) {
        this(builder.id, builder.bundle_deal_id, builder.orderid, builder.userid, builder.ctime, builder.status, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundleDealUsage)) {
            return false;
        }
        BundleDealUsage bundleDealUsage = (BundleDealUsage) obj;
        if (!equals((Object) this.id, (Object) bundleDealUsage.id) || !equals((Object) this.bundle_deal_id, (Object) bundleDealUsage.bundle_deal_id) || !equals((Object) this.orderid, (Object) bundleDealUsage.orderid) || !equals((Object) this.userid, (Object) bundleDealUsage.userid) || !equals((Object) this.ctime, (Object) bundleDealUsage.ctime) || !equals((Object) this.status, (Object) bundleDealUsage.status) || !equals((Object) this.count, (Object) bundleDealUsage.count)) {
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
        Long l2 = this.bundle_deal_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.orderid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.count;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BundleDealUsage> {
        public Long bundle_deal_id;
        public Integer count;
        public Integer ctime;
        public Long id;
        public Long orderid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(BundleDealUsage bundleDealUsage) {
            super(bundleDealUsage);
            if (bundleDealUsage != null) {
                this.id = bundleDealUsage.id;
                this.bundle_deal_id = bundleDealUsage.bundle_deal_id;
                this.orderid = bundleDealUsage.orderid;
                this.userid = bundleDealUsage.userid;
                this.ctime = bundleDealUsage.ctime;
                this.status = bundleDealUsage.status;
                this.count = bundleDealUsage.count;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public BundleDealUsage build() {
            return new BundleDealUsage(this);
        }
    }
}
