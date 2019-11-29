package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TargetAdsReqInfo extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public TargetAdsReqInfo(Long l, Integer num, Integer num2) {
        this.itemid = l;
        this.shopid = num;
        this.placement = num2;
    }

    private TargetAdsReqInfo(Builder builder) {
        this(builder.itemid, builder.shopid, builder.placement);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TargetAdsReqInfo)) {
            return false;
        }
        TargetAdsReqInfo targetAdsReqInfo = (TargetAdsReqInfo) obj;
        if (!equals((Object) this.itemid, (Object) targetAdsReqInfo.itemid) || !equals((Object) this.shopid, (Object) targetAdsReqInfo.shopid) || !equals((Object) this.placement, (Object) targetAdsReqInfo.placement)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.placement;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TargetAdsReqInfo> {
        public Long itemid;
        public Integer placement;
        public Integer shopid;

        public Builder() {
        }

        public Builder(TargetAdsReqInfo targetAdsReqInfo) {
            super(targetAdsReqInfo);
            if (targetAdsReqInfo != null) {
                this.itemid = targetAdsReqInfo.itemid;
                this.shopid = targetAdsReqInfo.shopid;
                this.placement = targetAdsReqInfo.placement;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public TargetAdsReqInfo build() {
            return new TargetAdsReqInfo(this);
        }
    }
}
