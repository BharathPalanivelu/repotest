package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ValidateGroupBuyOrder extends Message {
    public static final Long DEFAULT_GROUP_BUY_CAMPAIGNID = 0L;
    public static final Long DEFAULT_GROUP_BUY_GROUPID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_QUANTITY = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long group_buy_campaignid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long group_buy_groupid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer quantity;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public ValidateGroupBuyOrder(String str, String str2, BackendParam backendParam, Long l, Long l2, Integer num, Long l3, Long l4, Integer num2) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.group_buy_groupid = l;
        this.group_buy_campaignid = l2;
        this.shopid = num;
        this.itemid = l3;
        this.modelid = l4;
        this.quantity = num2;
    }

    private ValidateGroupBuyOrder(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.group_buy_groupid, builder.group_buy_campaignid, builder.shopid, builder.itemid, builder.modelid, builder.quantity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValidateGroupBuyOrder)) {
            return false;
        }
        ValidateGroupBuyOrder validateGroupBuyOrder = (ValidateGroupBuyOrder) obj;
        if (!equals((Object) this.requestid, (Object) validateGroupBuyOrder.requestid) || !equals((Object) this.token, (Object) validateGroupBuyOrder.token) || !equals((Object) this.bparam, (Object) validateGroupBuyOrder.bparam) || !equals((Object) this.group_buy_groupid, (Object) validateGroupBuyOrder.group_buy_groupid) || !equals((Object) this.group_buy_campaignid, (Object) validateGroupBuyOrder.group_buy_campaignid) || !equals((Object) this.shopid, (Object) validateGroupBuyOrder.shopid) || !equals((Object) this.itemid, (Object) validateGroupBuyOrder.itemid) || !equals((Object) this.modelid, (Object) validateGroupBuyOrder.modelid) || !equals((Object) this.quantity, (Object) validateGroupBuyOrder.quantity)) {
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
        Long l = this.group_buy_groupid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.group_buy_campaignid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.itemid;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.modelid;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.quantity;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ValidateGroupBuyOrder> {
        public BackendParam bparam;
        public Long group_buy_campaignid;
        public Long group_buy_groupid;
        public Long itemid;
        public Long modelid;
        public Integer quantity;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(ValidateGroupBuyOrder validateGroupBuyOrder) {
            super(validateGroupBuyOrder);
            if (validateGroupBuyOrder != null) {
                this.requestid = validateGroupBuyOrder.requestid;
                this.token = validateGroupBuyOrder.token;
                this.bparam = validateGroupBuyOrder.bparam;
                this.group_buy_groupid = validateGroupBuyOrder.group_buy_groupid;
                this.group_buy_campaignid = validateGroupBuyOrder.group_buy_campaignid;
                this.shopid = validateGroupBuyOrder.shopid;
                this.itemid = validateGroupBuyOrder.itemid;
                this.modelid = validateGroupBuyOrder.modelid;
                this.quantity = validateGroupBuyOrder.quantity;
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

        public Builder group_buy_groupid(Long l) {
            this.group_buy_groupid = l;
            return this;
        }

        public Builder group_buy_campaignid(Long l) {
            this.group_buy_campaignid = l;
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

        public Builder quantity(Integer num) {
            this.quantity = num;
            return this;
        }

        public ValidateGroupBuyOrder build() {
            return new ValidateGroupBuyOrder(this);
        }
    }
}
