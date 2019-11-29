package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetOrderDetail extends Message {
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6)
    public final BackendParam bparam;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public GetOrderDetail(String str, Long l, Integer num, String str2, Boolean bool, BackendParam backendParam, Boolean bool2) {
        this.requestid = str;
        this.orderid = l;
        this.shopid = num;
        this.token = str2;
        this.is_seller = bool;
        this.bparam = backendParam;
        this.is_group_buy = bool2;
    }

    private GetOrderDetail(Builder builder) {
        this(builder.requestid, builder.orderid, builder.shopid, builder.token, builder.is_seller, builder.bparam, builder.is_group_buy);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetOrderDetail)) {
            return false;
        }
        GetOrderDetail getOrderDetail = (GetOrderDetail) obj;
        if (!equals((Object) this.requestid, (Object) getOrderDetail.requestid) || !equals((Object) this.orderid, (Object) getOrderDetail.orderid) || !equals((Object) this.shopid, (Object) getOrderDetail.shopid) || !equals((Object) this.token, (Object) getOrderDetail.token) || !equals((Object) this.is_seller, (Object) getOrderDetail.is_seller) || !equals((Object) this.bparam, (Object) getOrderDetail.bparam) || !equals((Object) this.is_group_buy, (Object) getOrderDetail.is_group_buy)) {
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
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.is_seller;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode6 = (hashCode5 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_group_buy;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetOrderDetail> {
        public BackendParam bparam;
        public Boolean is_group_buy;
        public Boolean is_seller;
        public Long orderid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(GetOrderDetail getOrderDetail) {
            super(getOrderDetail);
            if (getOrderDetail != null) {
                this.requestid = getOrderDetail.requestid;
                this.orderid = getOrderDetail.orderid;
                this.shopid = getOrderDetail.shopid;
                this.token = getOrderDetail.token;
                this.is_seller = getOrderDetail.is_seller;
                this.bparam = getOrderDetail.bparam;
                this.is_group_buy = getOrderDetail.is_group_buy;
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

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder is_seller(Boolean bool) {
            this.is_seller = bool;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public GetOrderDetail build() {
            checkRequiredFields();
            return new GetOrderDetail(this);
        }
    }
}
