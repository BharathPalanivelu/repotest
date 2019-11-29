package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SellerPromotionItem extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Integer DEFAULT_FLASH_SALE_TYPE = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Long DEFAULT_PROMOTION_PRICE = 0L;
    public static final Integer DEFAULT_PROMO_SOURCE = 0;
    public static final Long DEFAULT_REBATE_PRICE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STOCK = 0;
    public static final Integer DEFAULT_TOTAL_ITEM_LIMIT = 0;
    public static final Integer DEFAULT_TOTAL_MODEL_LIMIT = 0;
    public static final Integer DEFAULT_USER_ITEM_LIMIT = 0;
    public static final Integer DEFAULT_USER_MODEL_LIMIT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer flash_sale_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer promo_source;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long promotion_price;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long rebate_price;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer stock;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer total_item_limit;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer total_model_limit;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer user_item_limit;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer user_model_limit;

    public SellerPromotionItem(Long l, Long l2, Integer num, Long l3, Long l4, Long l5, Long l6, Long l7, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13) {
        this.id = l;
        this.promotionid = l2;
        this.shopid = num;
        this.itemid = l3;
        this.modelid = l4;
        this.price_before_discount = l5;
        this.promotion_price = l6;
        this.rebate_price = l7;
        this.status = num2;
        this.user_item_limit = num3;
        this.user_model_limit = num4;
        this.total_item_limit = num5;
        this.total_model_limit = num6;
        this.start_time = num7;
        this.end_time = num8;
        this.mtime = num9;
        this.promo_source = num10;
        this.stock = num11;
        this.flash_sale_type = num12;
        this.ctime = num13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SellerPromotionItem(com.shopee.protocol.shop.SellerPromotionItem.Builder r24) {
        /*
            r23 = this;
            r0 = r24
            r1 = r23
            java.lang.Long r2 = r0.id
            java.lang.Long r3 = r0.promotionid
            java.lang.Integer r4 = r0.shopid
            java.lang.Long r5 = r0.itemid
            java.lang.Long r6 = r0.modelid
            java.lang.Long r7 = r0.price_before_discount
            java.lang.Long r8 = r0.promotion_price
            java.lang.Long r9 = r0.rebate_price
            java.lang.Integer r10 = r0.status
            java.lang.Integer r11 = r0.user_item_limit
            java.lang.Integer r12 = r0.user_model_limit
            java.lang.Integer r13 = r0.total_item_limit
            java.lang.Integer r14 = r0.total_model_limit
            java.lang.Integer r15 = r0.start_time
            r22 = r1
            java.lang.Integer r1 = r0.end_time
            r16 = r1
            java.lang.Integer r1 = r0.mtime
            r17 = r1
            java.lang.Integer r1 = r0.promo_source
            r18 = r1
            java.lang.Integer r1 = r0.stock
            r19 = r1
            java.lang.Integer r1 = r0.flash_sale_type
            r20 = r1
            java.lang.Integer r1 = r0.ctime
            r21 = r1
            r1 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r23.setBuilder(r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.SellerPromotionItem.<init>(com.shopee.protocol.shop.SellerPromotionItem$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerPromotionItem)) {
            return false;
        }
        SellerPromotionItem sellerPromotionItem = (SellerPromotionItem) obj;
        if (!equals((Object) this.id, (Object) sellerPromotionItem.id) || !equals((Object) this.promotionid, (Object) sellerPromotionItem.promotionid) || !equals((Object) this.shopid, (Object) sellerPromotionItem.shopid) || !equals((Object) this.itemid, (Object) sellerPromotionItem.itemid) || !equals((Object) this.modelid, (Object) sellerPromotionItem.modelid) || !equals((Object) this.price_before_discount, (Object) sellerPromotionItem.price_before_discount) || !equals((Object) this.promotion_price, (Object) sellerPromotionItem.promotion_price) || !equals((Object) this.rebate_price, (Object) sellerPromotionItem.rebate_price) || !equals((Object) this.status, (Object) sellerPromotionItem.status) || !equals((Object) this.user_item_limit, (Object) sellerPromotionItem.user_item_limit) || !equals((Object) this.user_model_limit, (Object) sellerPromotionItem.user_model_limit) || !equals((Object) this.total_item_limit, (Object) sellerPromotionItem.total_item_limit) || !equals((Object) this.total_model_limit, (Object) sellerPromotionItem.total_model_limit) || !equals((Object) this.start_time, (Object) sellerPromotionItem.start_time) || !equals((Object) this.end_time, (Object) sellerPromotionItem.end_time) || !equals((Object) this.mtime, (Object) sellerPromotionItem.mtime) || !equals((Object) this.promo_source, (Object) sellerPromotionItem.promo_source) || !equals((Object) this.stock, (Object) sellerPromotionItem.stock) || !equals((Object) this.flash_sale_type, (Object) sellerPromotionItem.flash_sale_type) || !equals((Object) this.ctime, (Object) sellerPromotionItem.ctime)) {
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
        Long l5 = this.price_before_discount;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.promotion_price;
        int hashCode7 = (hashCode6 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.rebate_price;
        int hashCode8 = (hashCode7 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.user_item_limit;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.user_model_limit;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.total_item_limit;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.total_model_limit;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.start_time;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.end_time;
        int hashCode15 = (hashCode14 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.mtime;
        int hashCode16 = (hashCode15 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.promo_source;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.stock;
        int hashCode18 = (hashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.flash_sale_type;
        int hashCode19 = (hashCode18 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.ctime;
        if (num13 != null) {
            i2 = num13.hashCode();
        }
        int i3 = hashCode19 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerPromotionItem> {
        public Integer ctime;
        public Integer end_time;
        public Integer flash_sale_type;
        public Long id;
        public Long itemid;
        public Long modelid;
        public Integer mtime;
        public Long price_before_discount;
        public Integer promo_source;
        public Long promotion_price;
        public Long promotionid;
        public Long rebate_price;
        public Integer shopid;
        public Integer start_time;
        public Integer status;
        public Integer stock;
        public Integer total_item_limit;
        public Integer total_model_limit;
        public Integer user_item_limit;
        public Integer user_model_limit;

        public Builder() {
        }

        public Builder(SellerPromotionItem sellerPromotionItem) {
            super(sellerPromotionItem);
            if (sellerPromotionItem != null) {
                this.id = sellerPromotionItem.id;
                this.promotionid = sellerPromotionItem.promotionid;
                this.shopid = sellerPromotionItem.shopid;
                this.itemid = sellerPromotionItem.itemid;
                this.modelid = sellerPromotionItem.modelid;
                this.price_before_discount = sellerPromotionItem.price_before_discount;
                this.promotion_price = sellerPromotionItem.promotion_price;
                this.rebate_price = sellerPromotionItem.rebate_price;
                this.status = sellerPromotionItem.status;
                this.user_item_limit = sellerPromotionItem.user_item_limit;
                this.user_model_limit = sellerPromotionItem.user_model_limit;
                this.total_item_limit = sellerPromotionItem.total_item_limit;
                this.total_model_limit = sellerPromotionItem.total_model_limit;
                this.start_time = sellerPromotionItem.start_time;
                this.end_time = sellerPromotionItem.end_time;
                this.mtime = sellerPromotionItem.mtime;
                this.promo_source = sellerPromotionItem.promo_source;
                this.stock = sellerPromotionItem.stock;
                this.flash_sale_type = sellerPromotionItem.flash_sale_type;
                this.ctime = sellerPromotionItem.ctime;
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

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public Builder promotion_price(Long l) {
            this.promotion_price = l;
            return this;
        }

        public Builder rebate_price(Long l) {
            this.rebate_price = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder user_item_limit(Integer num) {
            this.user_item_limit = num;
            return this;
        }

        public Builder user_model_limit(Integer num) {
            this.user_model_limit = num;
            return this;
        }

        public Builder total_item_limit(Integer num) {
            this.total_item_limit = num;
            return this;
        }

        public Builder total_model_limit(Integer num) {
            this.total_model_limit = num;
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

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder promo_source(Integer num) {
            this.promo_source = num;
            return this;
        }

        public Builder stock(Integer num) {
            this.stock = num;
            return this;
        }

        public Builder flash_sale_type(Integer num) {
            this.flash_sale_type = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public SellerPromotionItem build() {
            return new SellerPromotionItem(this);
        }
    }
}
