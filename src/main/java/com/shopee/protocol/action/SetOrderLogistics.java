package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerAddress;
import com.shopee.protocol.shop.OrderLogisticsInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SetOrderLogistics extends Message {
    public static final Long DEFAULT_CARRIER_SHIPPING_FEE = 0L;
    public static final Long DEFAULT_CONTRACTUAL_CARRIER_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_DELIVERY_TIME = 0;
    public static final Boolean DEFAULT_DISABLE_PN = false;
    public static final Long DEFAULT_ESCROW_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_LOGISTICS_STATUS = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_PICKUP_TIME = 0;
    public static final Long DEFAULT_REBATE_SHIPPING_FEE = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_SET_ORDER_ESCROW_CREATE = false;
    public static final String DEFAULT_SHIPPING_CARRIER = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TRACENO = "";
    public static final f DEFAULT_TRANS_DETAIL_SHIPPING_FEE = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long carrier_shipping_fee;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long contractual_carrier_shipping_fee;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer delivery_time;
    @ProtoField(tag = 19, type = Message.Datatype.BOOL)
    public final Boolean disable_pn;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long escrow_shipping_fee;
    @ProtoField(tag = 10)
    public final OrderLogisticsInfo logistics_info;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer logistics_status;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer pickup_time;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long rebate_shipping_fee;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 7)
    public final BuyerAddress seller_address;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean set_order_escrow_create;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String shipping_carrier;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String traceno;
    @ProtoField(tag = 16, type = Message.Datatype.BYTES)
    public final f trans_detail_shipping_fee;

    public SetOrderLogistics(String str, String str2, BackendParam backendParam, Long l, Integer num, Integer num2, BuyerAddress buyerAddress, Integer num3, String str3, OrderLogisticsInfo orderLogisticsInfo, Integer num4, Long l2, String str4, Long l3, Long l4, f fVar, Boolean bool, Long l5, Boolean bool2) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.orderid = l;
        this.shopid = num;
        this.pickup_time = num2;
        this.seller_address = buyerAddress;
        this.logistics_status = num3;
        this.traceno = str3;
        this.logistics_info = orderLogisticsInfo;
        this.delivery_time = num4;
        this.carrier_shipping_fee = l2;
        this.shipping_carrier = str4;
        this.rebate_shipping_fee = l3;
        this.escrow_shipping_fee = l4;
        this.trans_detail_shipping_fee = fVar;
        this.set_order_escrow_create = bool;
        this.contractual_carrier_shipping_fee = l5;
        this.disable_pn = bool2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SetOrderLogistics(com.shopee.protocol.action.SetOrderLogistics.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.token
            com.shopee.protocol.action.BackendParam r4 = r0.bparam
            java.lang.Long r5 = r0.orderid
            java.lang.Integer r6 = r0.shopid
            java.lang.Integer r7 = r0.pickup_time
            com.shopee.protocol.shop.BuyerAddress r8 = r0.seller_address
            java.lang.Integer r9 = r0.logistics_status
            java.lang.String r10 = r0.traceno
            com.shopee.protocol.shop.OrderLogisticsInfo r11 = r0.logistics_info
            java.lang.Integer r12 = r0.delivery_time
            java.lang.Long r13 = r0.carrier_shipping_fee
            java.lang.String r14 = r0.shipping_carrier
            java.lang.Long r15 = r0.rebate_shipping_fee
            r21 = r1
            java.lang.Long r1 = r0.escrow_shipping_fee
            r16 = r1
            e.f r1 = r0.trans_detail_shipping_fee
            r17 = r1
            java.lang.Boolean r1 = r0.set_order_escrow_create
            r18 = r1
            java.lang.Long r1 = r0.contractual_carrier_shipping_fee
            r19 = r1
            java.lang.Boolean r1 = r0.disable_pn
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SetOrderLogistics.<init>(com.shopee.protocol.action.SetOrderLogistics$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetOrderLogistics)) {
            return false;
        }
        SetOrderLogistics setOrderLogistics = (SetOrderLogistics) obj;
        if (!equals((Object) this.requestid, (Object) setOrderLogistics.requestid) || !equals((Object) this.token, (Object) setOrderLogistics.token) || !equals((Object) this.bparam, (Object) setOrderLogistics.bparam) || !equals((Object) this.orderid, (Object) setOrderLogistics.orderid) || !equals((Object) this.shopid, (Object) setOrderLogistics.shopid) || !equals((Object) this.pickup_time, (Object) setOrderLogistics.pickup_time) || !equals((Object) this.seller_address, (Object) setOrderLogistics.seller_address) || !equals((Object) this.logistics_status, (Object) setOrderLogistics.logistics_status) || !equals((Object) this.traceno, (Object) setOrderLogistics.traceno) || !equals((Object) this.logistics_info, (Object) setOrderLogistics.logistics_info) || !equals((Object) this.delivery_time, (Object) setOrderLogistics.delivery_time) || !equals((Object) this.carrier_shipping_fee, (Object) setOrderLogistics.carrier_shipping_fee) || !equals((Object) this.shipping_carrier, (Object) setOrderLogistics.shipping_carrier) || !equals((Object) this.rebate_shipping_fee, (Object) setOrderLogistics.rebate_shipping_fee) || !equals((Object) this.escrow_shipping_fee, (Object) setOrderLogistics.escrow_shipping_fee) || !equals((Object) this.trans_detail_shipping_fee, (Object) setOrderLogistics.trans_detail_shipping_fee) || !equals((Object) this.set_order_escrow_create, (Object) setOrderLogistics.set_order_escrow_create) || !equals((Object) this.contractual_carrier_shipping_fee, (Object) setOrderLogistics.contractual_carrier_shipping_fee) || !equals((Object) this.disable_pn, (Object) setOrderLogistics.disable_pn)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.pickup_time;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress = this.seller_address;
        int hashCode7 = (hashCode6 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        Integer num3 = this.logistics_status;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.traceno;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        OrderLogisticsInfo orderLogisticsInfo = this.logistics_info;
        int hashCode10 = (hashCode9 + (orderLogisticsInfo != null ? orderLogisticsInfo.hashCode() : 0)) * 37;
        Integer num4 = this.delivery_time;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.carrier_shipping_fee;
        int hashCode12 = (hashCode11 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str4 = this.shipping_carrier;
        int hashCode13 = (hashCode12 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l3 = this.rebate_shipping_fee;
        int hashCode14 = (hashCode13 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.escrow_shipping_fee;
        int hashCode15 = (hashCode14 + (l4 != null ? l4.hashCode() : 0)) * 37;
        f fVar = this.trans_detail_shipping_fee;
        int hashCode16 = (hashCode15 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Boolean bool = this.set_order_escrow_create;
        int hashCode17 = (hashCode16 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l5 = this.contractual_carrier_shipping_fee;
        int hashCode18 = (hashCode17 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_pn;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetOrderLogistics> {
        public BackendParam bparam;
        public Long carrier_shipping_fee;
        public Long contractual_carrier_shipping_fee;
        public Integer delivery_time;
        public Boolean disable_pn;
        public Long escrow_shipping_fee;
        public OrderLogisticsInfo logistics_info;
        public Integer logistics_status;
        public Long orderid;
        public Integer pickup_time;
        public Long rebate_shipping_fee;
        public String requestid;
        public BuyerAddress seller_address;
        public Boolean set_order_escrow_create;
        public String shipping_carrier;
        public Integer shopid;
        public String token;
        public String traceno;
        public f trans_detail_shipping_fee;

        public Builder() {
        }

        public Builder(SetOrderLogistics setOrderLogistics) {
            super(setOrderLogistics);
            if (setOrderLogistics != null) {
                this.requestid = setOrderLogistics.requestid;
                this.token = setOrderLogistics.token;
                this.bparam = setOrderLogistics.bparam;
                this.orderid = setOrderLogistics.orderid;
                this.shopid = setOrderLogistics.shopid;
                this.pickup_time = setOrderLogistics.pickup_time;
                this.seller_address = setOrderLogistics.seller_address;
                this.logistics_status = setOrderLogistics.logistics_status;
                this.traceno = setOrderLogistics.traceno;
                this.logistics_info = setOrderLogistics.logistics_info;
                this.delivery_time = setOrderLogistics.delivery_time;
                this.carrier_shipping_fee = setOrderLogistics.carrier_shipping_fee;
                this.shipping_carrier = setOrderLogistics.shipping_carrier;
                this.rebate_shipping_fee = setOrderLogistics.rebate_shipping_fee;
                this.escrow_shipping_fee = setOrderLogistics.escrow_shipping_fee;
                this.trans_detail_shipping_fee = setOrderLogistics.trans_detail_shipping_fee;
                this.set_order_escrow_create = setOrderLogistics.set_order_escrow_create;
                this.contractual_carrier_shipping_fee = setOrderLogistics.contractual_carrier_shipping_fee;
                this.disable_pn = setOrderLogistics.disable_pn;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder pickup_time(Integer num) {
            this.pickup_time = num;
            return this;
        }

        public Builder seller_address(BuyerAddress buyerAddress) {
            this.seller_address = buyerAddress;
            return this;
        }

        public Builder logistics_status(Integer num) {
            this.logistics_status = num;
            return this;
        }

        public Builder traceno(String str) {
            this.traceno = str;
            return this;
        }

        public Builder logistics_info(OrderLogisticsInfo orderLogisticsInfo) {
            this.logistics_info = orderLogisticsInfo;
            return this;
        }

        public Builder delivery_time(Integer num) {
            this.delivery_time = num;
            return this;
        }

        public Builder carrier_shipping_fee(Long l) {
            this.carrier_shipping_fee = l;
            return this;
        }

        public Builder shipping_carrier(String str) {
            this.shipping_carrier = str;
            return this;
        }

        public Builder rebate_shipping_fee(Long l) {
            this.rebate_shipping_fee = l;
            return this;
        }

        public Builder escrow_shipping_fee(Long l) {
            this.escrow_shipping_fee = l;
            return this;
        }

        public Builder trans_detail_shipping_fee(f fVar) {
            this.trans_detail_shipping_fee = fVar;
            return this;
        }

        public Builder set_order_escrow_create(Boolean bool) {
            this.set_order_escrow_create = bool;
            return this;
        }

        public Builder contractual_carrier_shipping_fee(Long l) {
            this.contractual_carrier_shipping_fee = l;
            return this;
        }

        public Builder disable_pn(Boolean bool) {
            this.disable_pn = bool;
            return this;
        }

        public SetOrderLogistics build() {
            return new SetOrderLogistics(this);
        }
    }
}
