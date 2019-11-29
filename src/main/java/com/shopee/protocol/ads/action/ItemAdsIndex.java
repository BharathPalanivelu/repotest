package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemAdsIndex extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_PLACEMENT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer placement;

    public ItemAdsIndex(Long l, Long l2, Long l3, Long l4, Integer num) {
        this.id = l;
        this.itemid = l2;
        this.adsid = l3;
        this.campaignid = l4;
        this.placement = num;
    }

    private ItemAdsIndex(Builder builder) {
        this(builder.id, builder.itemid, builder.adsid, builder.campaignid, builder.placement);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemAdsIndex)) {
            return false;
        }
        ItemAdsIndex itemAdsIndex = (ItemAdsIndex) obj;
        if (!equals((Object) this.id, (Object) itemAdsIndex.id) || !equals((Object) this.itemid, (Object) itemAdsIndex.itemid) || !equals((Object) this.adsid, (Object) itemAdsIndex.adsid) || !equals((Object) this.campaignid, (Object) itemAdsIndex.campaignid) || !equals((Object) this.placement, (Object) itemAdsIndex.placement)) {
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
        Long l2 = this.itemid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.adsid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.campaignid;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num = this.placement;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemAdsIndex> {
        public Long adsid;
        public Long campaignid;
        public Long id;
        public Long itemid;
        public Integer placement;

        public Builder() {
        }

        public Builder(ItemAdsIndex itemAdsIndex) {
            super(itemAdsIndex);
            if (itemAdsIndex != null) {
                this.id = itemAdsIndex.id;
                this.itemid = itemAdsIndex.itemid;
                this.adsid = itemAdsIndex.adsid;
                this.campaignid = itemAdsIndex.campaignid;
                this.placement = itemAdsIndex.placement;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public ItemAdsIndex build() {
            return new ItemAdsIndex(this);
        }
    }
}
