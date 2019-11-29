package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SellerPromotionUsage extends Message {
    public static final Integer DEFAULT_AMOUNT = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer amount;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer userid;

    public SellerPromotionUsage(Long l, Long l2, Integer num, Long l3, Long l4, Integer num2, Integer num3) {
        this.id = l;
        this.promotionid = l2;
        this.shopid = num;
        this.itemid = l3;
        this.modelid = l4;
        this.userid = num2;
        this.amount = num3;
    }

    private SellerPromotionUsage(Builder builder) {
        this(builder.id, builder.promotionid, builder.shopid, builder.itemid, builder.modelid, builder.userid, builder.amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerPromotionUsage)) {
            return false;
        }
        SellerPromotionUsage sellerPromotionUsage = (SellerPromotionUsage) obj;
        if (!equals((Object) this.id, (Object) sellerPromotionUsage.id) || !equals((Object) this.promotionid, (Object) sellerPromotionUsage.promotionid) || !equals((Object) this.shopid, (Object) sellerPromotionUsage.shopid) || !equals((Object) this.itemid, (Object) sellerPromotionUsage.itemid) || !equals((Object) this.modelid, (Object) sellerPromotionUsage.modelid) || !equals((Object) this.userid, (Object) sellerPromotionUsage.userid) || !equals((Object) this.amount, (Object) sellerPromotionUsage.amount)) {
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
        Long l2 = this.promotionid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.itemid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.modelid;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.amount;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerPromotionUsage> {
        public Integer amount;
        public Long id;
        public Long itemid;
        public Long modelid;
        public Long promotionid;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(SellerPromotionUsage sellerPromotionUsage) {
            super(sellerPromotionUsage);
            if (sellerPromotionUsage != null) {
                this.id = sellerPromotionUsage.id;
                this.promotionid = sellerPromotionUsage.promotionid;
                this.shopid = sellerPromotionUsage.shopid;
                this.itemid = sellerPromotionUsage.itemid;
                this.modelid = sellerPromotionUsage.modelid;
                this.userid = sellerPromotionUsage.userid;
                this.amount = sellerPromotionUsage.amount;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder amount(Integer num) {
            this.amount = num;
            return this;
        }

        public SellerPromotionUsage build() {
            return new SellerPromotionUsage(this);
        }
    }
}
