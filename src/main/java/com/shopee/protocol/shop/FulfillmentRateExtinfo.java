package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FulfillmentRateExtinfo extends Message {
    public static final Integer DEFAULT_AUTO_CANCELLATION = 0;
    public static final Integer DEFAULT_CANCELLATION_RATE = 0;
    public static final Integer DEFAULT_CANNOT_SUPPORT_COD = 0;
    public static final Integer DEFAULT_COD_VERIFIED = 0;
    public static final Integer DEFAULT_DENOMINATOR = 0;
    public static final Integer DEFAULT_FLAG = 0;
    public static final Integer DEFAULT_OUT_OF_STOCK = 0;
    public static final Integer DEFAULT_PAID_ORDER = 0;
    public static final Integer DEFAULT_PERIOD = 0;
    public static final Integer DEFAULT_RETURN = 0;
    public static final Integer DEFAULT_RETURN_REFUND_RATE = 0;
    public static final Integer DEFAULT_UNDELIVERABLE_AREA = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer _return;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer auto_cancellation;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer cancellation_rate;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer cannot_support_cod;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer cod_verified;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer denominator;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer out_of_stock;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer paid_order;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer period;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer return_refund_rate;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer undeliverable_area;

    public FulfillmentRateExtinfo(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12) {
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
    }

    private FulfillmentRateExtinfo(Builder builder) {
        this(builder.out_of_stock, builder.auto_cancellation, builder._return, builder.paid_order, builder.cod_verified, builder.cannot_support_cod, builder.undeliverable_area, builder.denominator, builder.flag, builder.cancellation_rate, builder.return_refund_rate, builder.period);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FulfillmentRateExtinfo)) {
            return false;
        }
        FulfillmentRateExtinfo fulfillmentRateExtinfo = (FulfillmentRateExtinfo) obj;
        if (!equals((Object) this.out_of_stock, (Object) fulfillmentRateExtinfo.out_of_stock) || !equals((Object) this.auto_cancellation, (Object) fulfillmentRateExtinfo.auto_cancellation) || !equals((Object) this._return, (Object) fulfillmentRateExtinfo._return) || !equals((Object) this.paid_order, (Object) fulfillmentRateExtinfo.paid_order) || !equals((Object) this.cod_verified, (Object) fulfillmentRateExtinfo.cod_verified) || !equals((Object) this.cannot_support_cod, (Object) fulfillmentRateExtinfo.cannot_support_cod) || !equals((Object) this.undeliverable_area, (Object) fulfillmentRateExtinfo.undeliverable_area) || !equals((Object) this.denominator, (Object) fulfillmentRateExtinfo.denominator) || !equals((Object) this.flag, (Object) fulfillmentRateExtinfo.flag) || !equals((Object) this.cancellation_rate, (Object) fulfillmentRateExtinfo.cancellation_rate) || !equals((Object) this.return_refund_rate, (Object) fulfillmentRateExtinfo.return_refund_rate) || !equals((Object) this.period, (Object) fulfillmentRateExtinfo.period)) {
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
        if (num12 != null) {
            i2 = num12.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FulfillmentRateExtinfo> {
        public Integer _return;
        public Integer auto_cancellation;
        public Integer cancellation_rate;
        public Integer cannot_support_cod;
        public Integer cod_verified;
        public Integer denominator;
        public Integer flag;
        public Integer out_of_stock;
        public Integer paid_order;
        public Integer period;
        public Integer return_refund_rate;
        public Integer undeliverable_area;

        public Builder() {
        }

        public Builder(FulfillmentRateExtinfo fulfillmentRateExtinfo) {
            super(fulfillmentRateExtinfo);
            if (fulfillmentRateExtinfo != null) {
                this.out_of_stock = fulfillmentRateExtinfo.out_of_stock;
                this.auto_cancellation = fulfillmentRateExtinfo.auto_cancellation;
                this._return = fulfillmentRateExtinfo._return;
                this.paid_order = fulfillmentRateExtinfo.paid_order;
                this.cod_verified = fulfillmentRateExtinfo.cod_verified;
                this.cannot_support_cod = fulfillmentRateExtinfo.cannot_support_cod;
                this.undeliverable_area = fulfillmentRateExtinfo.undeliverable_area;
                this.denominator = fulfillmentRateExtinfo.denominator;
                this.flag = fulfillmentRateExtinfo.flag;
                this.cancellation_rate = fulfillmentRateExtinfo.cancellation_rate;
                this.return_refund_rate = fulfillmentRateExtinfo.return_refund_rate;
                this.period = fulfillmentRateExtinfo.period;
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

        public FulfillmentRateExtinfo build() {
            return new FulfillmentRateExtinfo(this);
        }
    }
}
