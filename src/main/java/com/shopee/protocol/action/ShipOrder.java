package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ShipOrder extends Message {
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REMARK = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SHIPPING_CARRIER = "";
    public static final String DEFAULT_SHIPPING_TRACENO = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String remark;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String shipping_carrier;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String shipping_traceno;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;

    public ShipOrder(String str, Long l, String str2, String str3, String str4, String str5, f fVar) {
        this.requestid = str;
        this.orderid = l;
        this.shipping_carrier = str2;
        this.shipping_traceno = str3;
        this.remark = str4;
        this.token = str5;
        this.extinfo = fVar;
    }

    private ShipOrder(Builder builder) {
        this(builder.requestid, builder.orderid, builder.shipping_carrier, builder.shipping_traceno, builder.remark, builder.token, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShipOrder)) {
            return false;
        }
        ShipOrder shipOrder = (ShipOrder) obj;
        if (!equals((Object) this.requestid, (Object) shipOrder.requestid) || !equals((Object) this.orderid, (Object) shipOrder.orderid) || !equals((Object) this.shipping_carrier, (Object) shipOrder.shipping_carrier) || !equals((Object) this.shipping_traceno, (Object) shipOrder.shipping_traceno) || !equals((Object) this.remark, (Object) shipOrder.remark) || !equals((Object) this.token, (Object) shipOrder.token) || !equals((Object) this.extinfo, (Object) shipOrder.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.shipping_carrier;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.shipping_traceno;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.remark;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.token;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShipOrder> {
        public f extinfo;
        public Long orderid;
        public String remark;
        public String requestid;
        public String shipping_carrier;
        public String shipping_traceno;
        public String token;

        public Builder() {
        }

        public Builder(ShipOrder shipOrder) {
            super(shipOrder);
            if (shipOrder != null) {
                this.requestid = shipOrder.requestid;
                this.orderid = shipOrder.orderid;
                this.shipping_carrier = shipOrder.shipping_carrier;
                this.shipping_traceno = shipOrder.shipping_traceno;
                this.remark = shipOrder.remark;
                this.token = shipOrder.token;
                this.extinfo = shipOrder.extinfo;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder shipping_carrier(String str) {
            this.shipping_carrier = str;
            return this;
        }

        public Builder shipping_traceno(String str) {
            this.shipping_traceno = str;
            return this;
        }

        public Builder remark(String str) {
            this.remark = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public ShipOrder build() {
            checkRequiredFields();
            return new ShipOrder(this);
        }
    }
}
