package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class ShopMetricExtinfo extends Message {
    public static final Integer DEFAULT_AUTO_CANCELLATION = 0;
    public static final Integer DEFAULT_BUYER_CANCELLATION = 0;
    public static final Integer DEFAULT_CANCELLATION_RATE = 0;
    public static final Integer DEFAULT_CANNOT_SUPPORT_COD = 0;
    public static final Integer DEFAULT_COD_VERIFIED = 0;
    public static final Integer DEFAULT_DENOMINATOR = 0;
    public static final Integer DEFAULT_EXTRA_FLAG = 0;
    public static final Integer DEFAULT_FLAG = 0;
    public static final Integer DEFAULT_NUMERATOR = 0;
    public static final List<Long> DEFAULT_ORDERID = Collections.emptyList();
    public static final Integer DEFAULT_OUT_OF_STOCK = 0;
    public static final Integer DEFAULT_PAID_ORDER = 0;
    public static final Integer DEFAULT_PERIOD = 0;
    public static final Integer DEFAULT_RETURN = 0;
    public static final Integer DEFAULT_RETURN_REFUND_RATE = 0;
    public static final f DEFAULT_TEXT = f.f32736b;
    public static final Integer DEFAULT_UNDELIVERABLE_AREA = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer _return;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer auto_cancellation;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer buyer_cancellation;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer cancellation_rate;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer cannot_support_cod;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer cod_verified;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer denominator;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer extra_flag;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer numerator;
    @ProtoField(label = Message.Label.REPEATED, tag = 15, type = Message.Datatype.INT64)
    public final List<Long> orderid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer out_of_stock;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer paid_order;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer period;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer return_refund_rate;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f text;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer undeliverable_area;

    public ShopMetricExtinfo(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, f fVar, List<Long> list, Integer num14, Integer num15) {
        this.out_of_stock = num;
        this.auto_cancellation = num2;
        this._return = num3;
        this.paid_order = num4;
        this.cod_verified = num5;
        this.cannot_support_cod = num6;
        this.undeliverable_area = num7;
        this.denominator = num8;
        this.flag = num9;
        this.cancellation_rate = num10;
        this.return_refund_rate = num11;
        this.period = num12;
        this.numerator = num13;
        this.text = fVar;
        this.orderid = immutableCopyOf(list);
        this.extra_flag = num14;
        this.buyer_cancellation = num15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ShopMetricExtinfo(com.shopee.protocol.shop.ShopMetricExtinfo.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.Integer r2 = r0.out_of_stock
            java.lang.Integer r3 = r0.auto_cancellation
            java.lang.Integer r4 = r0._return
            java.lang.Integer r5 = r0.paid_order
            java.lang.Integer r6 = r0.cod_verified
            java.lang.Integer r7 = r0.cannot_support_cod
            java.lang.Integer r8 = r0.undeliverable_area
            java.lang.Integer r9 = r0.denominator
            java.lang.Integer r10 = r0.flag
            java.lang.Integer r11 = r0.cancellation_rate
            java.lang.Integer r12 = r0.return_refund_rate
            java.lang.Integer r13 = r0.period
            java.lang.Integer r14 = r0.numerator
            e.f r15 = r0.text
            r19 = r1
            java.util.List<java.lang.Long> r1 = r0.orderid
            r16 = r1
            java.lang.Integer r1 = r0.extra_flag
            r17 = r1
            java.lang.Integer r1 = r0.buyer_cancellation
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ShopMetricExtinfo.<init>(com.shopee.protocol.shop.ShopMetricExtinfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopMetricExtinfo)) {
            return false;
        }
        ShopMetricExtinfo shopMetricExtinfo = (ShopMetricExtinfo) obj;
        if (!equals((Object) this.out_of_stock, (Object) shopMetricExtinfo.out_of_stock) || !equals((Object) this.auto_cancellation, (Object) shopMetricExtinfo.auto_cancellation) || !equals((Object) this._return, (Object) shopMetricExtinfo._return) || !equals((Object) this.paid_order, (Object) shopMetricExtinfo.paid_order) || !equals((Object) this.cod_verified, (Object) shopMetricExtinfo.cod_verified) || !equals((Object) this.cannot_support_cod, (Object) shopMetricExtinfo.cannot_support_cod) || !equals((Object) this.undeliverable_area, (Object) shopMetricExtinfo.undeliverable_area) || !equals((Object) this.denominator, (Object) shopMetricExtinfo.denominator) || !equals((Object) this.flag, (Object) shopMetricExtinfo.flag) || !equals((Object) this.cancellation_rate, (Object) shopMetricExtinfo.cancellation_rate) || !equals((Object) this.return_refund_rate, (Object) shopMetricExtinfo.return_refund_rate) || !equals((Object) this.period, (Object) shopMetricExtinfo.period) || !equals((Object) this.numerator, (Object) shopMetricExtinfo.numerator) || !equals((Object) this.text, (Object) shopMetricExtinfo.text) || !equals((List<?>) this.orderid, (List<?>) shopMetricExtinfo.orderid) || !equals((Object) this.extra_flag, (Object) shopMetricExtinfo.extra_flag) || !equals((Object) this.buyer_cancellation, (Object) shopMetricExtinfo.buyer_cancellation)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.out_of_stock;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.auto_cancellation;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this._return;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.paid_order;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.cod_verified;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.cannot_support_cod;
        int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.undeliverable_area;
        int hashCode7 = (hashCode6 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.denominator;
        int hashCode8 = (hashCode7 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.flag;
        int hashCode9 = (hashCode8 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.cancellation_rate;
        int hashCode10 = (hashCode9 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.return_refund_rate;
        int hashCode11 = (hashCode10 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.period;
        int hashCode12 = (hashCode11 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.numerator;
        int hashCode13 = (hashCode12 + (num13 != null ? num13.hashCode() : 0)) * 37;
        f fVar = this.text;
        int hashCode14 = (hashCode13 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        List<Long> list = this.orderid;
        int hashCode15 = (hashCode14 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num14 = this.extra_flag;
        int hashCode16 = (hashCode15 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.buyer_cancellation;
        if (num15 != null) {
            i2 = num15.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopMetricExtinfo> {
        public Integer _return;
        public Integer auto_cancellation;
        public Integer buyer_cancellation;
        public Integer cancellation_rate;
        public Integer cannot_support_cod;
        public Integer cod_verified;
        public Integer denominator;
        public Integer extra_flag;
        public Integer flag;
        public Integer numerator;
        public List<Long> orderid;
        public Integer out_of_stock;
        public Integer paid_order;
        public Integer period;
        public Integer return_refund_rate;
        public f text;
        public Integer undeliverable_area;

        public Builder() {
        }

        public Builder(ShopMetricExtinfo shopMetricExtinfo) {
            super(shopMetricExtinfo);
            if (shopMetricExtinfo != null) {
                this.out_of_stock = shopMetricExtinfo.out_of_stock;
                this.auto_cancellation = shopMetricExtinfo.auto_cancellation;
                this._return = shopMetricExtinfo._return;
                this.paid_order = shopMetricExtinfo.paid_order;
                this.cod_verified = shopMetricExtinfo.cod_verified;
                this.cannot_support_cod = shopMetricExtinfo.cannot_support_cod;
                this.undeliverable_area = shopMetricExtinfo.undeliverable_area;
                this.denominator = shopMetricExtinfo.denominator;
                this.flag = shopMetricExtinfo.flag;
                this.cancellation_rate = shopMetricExtinfo.cancellation_rate;
                this.return_refund_rate = shopMetricExtinfo.return_refund_rate;
                this.period = shopMetricExtinfo.period;
                this.numerator = shopMetricExtinfo.numerator;
                this.text = shopMetricExtinfo.text;
                this.orderid = ShopMetricExtinfo.copyOf(shopMetricExtinfo.orderid);
                this.extra_flag = shopMetricExtinfo.extra_flag;
                this.buyer_cancellation = shopMetricExtinfo.buyer_cancellation;
            }
        }

        public Builder out_of_stock(Integer num) {
            this.out_of_stock = num;
            return this;
        }

        public Builder auto_cancellation(Integer num) {
            this.auto_cancellation = num;
            return this;
        }

        public Builder _return(Integer num) {
            this._return = num;
            return this;
        }

        public Builder paid_order(Integer num) {
            this.paid_order = num;
            return this;
        }

        public Builder cod_verified(Integer num) {
            this.cod_verified = num;
            return this;
        }

        public Builder cannot_support_cod(Integer num) {
            this.cannot_support_cod = num;
            return this;
        }

        public Builder undeliverable_area(Integer num) {
            this.undeliverable_area = num;
            return this;
        }

        public Builder denominator(Integer num) {
            this.denominator = num;
            return this;
        }

        public Builder flag(Integer num) {
            this.flag = num;
            return this;
        }

        public Builder cancellation_rate(Integer num) {
            this.cancellation_rate = num;
            return this;
        }

        public Builder return_refund_rate(Integer num) {
            this.return_refund_rate = num;
            return this;
        }

        public Builder period(Integer num) {
            this.period = num;
            return this;
        }

        public Builder numerator(Integer num) {
            this.numerator = num;
            return this;
        }

        public Builder text(f fVar) {
            this.text = fVar;
            return this;
        }

        public Builder orderid(List<Long> list) {
            this.orderid = checkForNulls(list);
            return this;
        }

        public Builder extra_flag(Integer num) {
            this.extra_flag = num;
            return this;
        }

        public Builder buyer_cancellation(Integer num) {
            this.buyer_cancellation = num;
            return this;
        }

        public ShopMetricExtinfo build() {
            return new ShopMetricExtinfo(this);
        }
    }
}
