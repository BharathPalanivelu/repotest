package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SellerPromotionRefresh extends Message {
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_REFRESH_TIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer refresh_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public SellerPromotionRefresh(Long l, Integer num, Long l2, Long l3, Integer num2) {
        this.id = l;
        this.shopid = num;
        this.itemid = l2;
        this.modelid = l3;
        this.refresh_time = num2;
    }

    private SellerPromotionRefresh(Builder builder) {
        this(builder.id, builder.shopid, builder.itemid, builder.modelid, builder.refresh_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerPromotionRefresh)) {
            return false;
        }
        SellerPromotionRefresh sellerPromotionRefresh = (SellerPromotionRefresh) obj;
        if (!equals((Object) this.id, (Object) sellerPromotionRefresh.id) || !equals((Object) this.shopid, (Object) sellerPromotionRefresh.shopid) || !equals((Object) this.itemid, (Object) sellerPromotionRefresh.itemid) || !equals((Object) this.modelid, (Object) sellerPromotionRefresh.modelid) || !equals((Object) this.refresh_time, (Object) sellerPromotionRefresh.refresh_time)) {
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
        Long l3 = this.modelid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.refresh_time;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerPromotionRefresh> {
        public Long id;
        public Long itemid;
        public Long modelid;
        public Integer refresh_time;
        public Integer shopid;

        public Builder() {
        }

        public Builder(SellerPromotionRefresh sellerPromotionRefresh) {
            super(sellerPromotionRefresh);
            if (sellerPromotionRefresh != null) {
                this.id = sellerPromotionRefresh.id;
                this.shopid = sellerPromotionRefresh.shopid;
                this.itemid = sellerPromotionRefresh.itemid;
                this.modelid = sellerPromotionRefresh.modelid;
                this.refresh_time = sellerPromotionRefresh.refresh_time;
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

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder refresh_time(Integer num) {
            this.refresh_time = num;
            return this;
        }

        public SellerPromotionRefresh build() {
            return new SellerPromotionRefresh(this);
        }
    }
}
