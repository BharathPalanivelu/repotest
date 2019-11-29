package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FieldSumMap extends Message {
    public static final Long DEFAULT_BROAD_GMV = 0L;
    public static final Long DEFAULT_BROAD_ITEM_COUNT = 0L;
    public static final Long DEFAULT_BROAD_ORDER = 0L;
    public static final Long DEFAULT_BROAD_SHOP_ITEM_CLICK = 0L;
    public static final Long DEFAULT_BROAD_SHOP_ITEM_IMP = 0L;
    public static final Long DEFAULT_CLICK = 0L;
    public static final Long DEFAULT_COST = 0L;
    public static final Long DEFAULT_IMPRESSION = 0L;
    public static final Long DEFAULT_LOCATION_IN_ADS = 0L;
    public static final Long DEFAULT_ORDER = 0L;
    public static final Long DEFAULT_ORDER_AMOUNT = 0L;
    public static final Long DEFAULT_ORDER_GMV = 0L;
    public static final Long DEFAULT_SHOP_ITEM_CLICK = 0L;
    public static final Long DEFAULT_SHOP_ITEM_IMPRESSION = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long broad_gmv;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long broad_item_count;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long broad_order;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long broad_shop_item_click;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long broad_shop_item_imp;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long click;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long cost;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long impression;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long location_in_ads;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long order;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long order_amount;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long order_gmv;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long shop_item_click;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long shop_item_impression;

    public FieldSumMap(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Long l9, Long l10, Long l11, Long l12, Long l13, Long l14) {
        this.impression = l;
        this.click = l2;
        this.order = l3;
        this.order_amount = l4;
        this.order_gmv = l5;
        this.cost = l6;
        this.shop_item_impression = l7;
        this.shop_item_click = l8;
        this.broad_shop_item_imp = l9;
        this.broad_shop_item_click = l10;
        this.broad_order = l11;
        this.broad_item_count = l12;
        this.broad_gmv = l13;
        this.location_in_ads = l14;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FieldSumMap(com.shopee.protocol.ads.action.FieldSumMap.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Long r2 = r0.impression
            java.lang.Long r3 = r0.click
            java.lang.Long r4 = r0.order
            java.lang.Long r5 = r0.order_amount
            java.lang.Long r6 = r0.order_gmv
            java.lang.Long r7 = r0.cost
            java.lang.Long r8 = r0.shop_item_impression
            java.lang.Long r9 = r0.shop_item_click
            java.lang.Long r10 = r0.broad_shop_item_imp
            java.lang.Long r11 = r0.broad_shop_item_click
            java.lang.Long r12 = r0.broad_order
            java.lang.Long r13 = r0.broad_item_count
            java.lang.Long r14 = r0.broad_gmv
            java.lang.Long r15 = r0.location_in_ads
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.ads.action.FieldSumMap.<init>(com.shopee.protocol.ads.action.FieldSumMap$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldSumMap)) {
            return false;
        }
        FieldSumMap fieldSumMap = (FieldSumMap) obj;
        if (!equals((Object) this.impression, (Object) fieldSumMap.impression) || !equals((Object) this.click, (Object) fieldSumMap.click) || !equals((Object) this.order, (Object) fieldSumMap.order) || !equals((Object) this.order_amount, (Object) fieldSumMap.order_amount) || !equals((Object) this.order_gmv, (Object) fieldSumMap.order_gmv) || !equals((Object) this.cost, (Object) fieldSumMap.cost) || !equals((Object) this.shop_item_impression, (Object) fieldSumMap.shop_item_impression) || !equals((Object) this.shop_item_click, (Object) fieldSumMap.shop_item_click) || !equals((Object) this.broad_shop_item_imp, (Object) fieldSumMap.broad_shop_item_imp) || !equals((Object) this.broad_shop_item_click, (Object) fieldSumMap.broad_shop_item_click) || !equals((Object) this.broad_order, (Object) fieldSumMap.broad_order) || !equals((Object) this.broad_item_count, (Object) fieldSumMap.broad_item_count) || !equals((Object) this.broad_gmv, (Object) fieldSumMap.broad_gmv) || !equals((Object) this.location_in_ads, (Object) fieldSumMap.location_in_ads)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.impression;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.click;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.order;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.order_amount;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.order_gmv;
        int hashCode5 = (hashCode4 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.cost;
        int hashCode6 = (hashCode5 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.shop_item_impression;
        int hashCode7 = (hashCode6 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.shop_item_click;
        int hashCode8 = (hashCode7 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.broad_shop_item_imp;
        int hashCode9 = (hashCode8 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.broad_shop_item_click;
        int hashCode10 = (hashCode9 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Long l11 = this.broad_order;
        int hashCode11 = (hashCode10 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Long l12 = this.broad_item_count;
        int hashCode12 = (hashCode11 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Long l13 = this.broad_gmv;
        int hashCode13 = (hashCode12 + (l13 != null ? l13.hashCode() : 0)) * 37;
        Long l14 = this.location_in_ads;
        if (l14 != null) {
            i2 = l14.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FieldSumMap> {
        public Long broad_gmv;
        public Long broad_item_count;
        public Long broad_order;
        public Long broad_shop_item_click;
        public Long broad_shop_item_imp;
        public Long click;
        public Long cost;
        public Long impression;
        public Long location_in_ads;
        public Long order;
        public Long order_amount;
        public Long order_gmv;
        public Long shop_item_click;
        public Long shop_item_impression;

        public Builder() {
        }

        public Builder(FieldSumMap fieldSumMap) {
            super(fieldSumMap);
            if (fieldSumMap != null) {
                this.impression = fieldSumMap.impression;
                this.click = fieldSumMap.click;
                this.order = fieldSumMap.order;
                this.order_amount = fieldSumMap.order_amount;
                this.order_gmv = fieldSumMap.order_gmv;
                this.cost = fieldSumMap.cost;
                this.shop_item_impression = fieldSumMap.shop_item_impression;
                this.shop_item_click = fieldSumMap.shop_item_click;
                this.broad_shop_item_imp = fieldSumMap.broad_shop_item_imp;
                this.broad_shop_item_click = fieldSumMap.broad_shop_item_click;
                this.broad_order = fieldSumMap.broad_order;
                this.broad_item_count = fieldSumMap.broad_item_count;
                this.broad_gmv = fieldSumMap.broad_gmv;
                this.location_in_ads = fieldSumMap.location_in_ads;
            }
        }

        public Builder impression(Long l) {
            this.impression = l;
            return this;
        }

        public Builder click(Long l) {
            this.click = l;
            return this;
        }

        public Builder order(Long l) {
            this.order = l;
            return this;
        }

        public Builder order_amount(Long l) {
            this.order_amount = l;
            return this;
        }

        public Builder order_gmv(Long l) {
            this.order_gmv = l;
            return this;
        }

        public Builder cost(Long l) {
            this.cost = l;
            return this;
        }

        public Builder shop_item_impression(Long l) {
            this.shop_item_impression = l;
            return this;
        }

        public Builder shop_item_click(Long l) {
            this.shop_item_click = l;
            return this;
        }

        public Builder broad_shop_item_imp(Long l) {
            this.broad_shop_item_imp = l;
            return this;
        }

        public Builder broad_shop_item_click(Long l) {
            this.broad_shop_item_click = l;
            return this;
        }

        public Builder broad_order(Long l) {
            this.broad_order = l;
            return this;
        }

        public Builder broad_item_count(Long l) {
            this.broad_item_count = l;
            return this;
        }

        public Builder broad_gmv(Long l) {
            this.broad_gmv = l;
            return this;
        }

        public Builder location_in_ads(Long l) {
            this.location_in_ads = l;
            return this;
        }

        public FieldSumMap build() {
            return new FieldSumMap(this);
        }
    }
}
