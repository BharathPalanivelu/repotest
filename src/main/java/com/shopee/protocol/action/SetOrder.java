package com.shopee.protocol.action;

import com.shopee.protocol.shop.Order;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetOrder extends Message {
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(tag = 3)
    public final Order order;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetOrder(String str, BackendParam backendParam, Order order2, Boolean bool) {
        this.requestid = str;
        this.bparam = backendParam;
        this.order = order2;
        this.is_group_buy = bool;
    }

    private SetOrder(Builder builder) {
        this(builder.requestid, builder.bparam, builder.order, builder.is_group_buy);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetOrder)) {
            return false;
        }
        SetOrder setOrder = (SetOrder) obj;
        if (!equals((Object) this.requestid, (Object) setOrder.requestid) || !equals((Object) this.bparam, (Object) setOrder.bparam) || !equals((Object) this.order, (Object) setOrder.order) || !equals((Object) this.is_group_buy, (Object) setOrder.is_group_buy)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Order order2 = this.order;
        int hashCode3 = (hashCode2 + (order2 != null ? order2.hashCode() : 0)) * 37;
        Boolean bool = this.is_group_buy;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetOrder> {
        public BackendParam bparam;
        public Boolean is_group_buy;
        public Order order;
        public String requestid;

        public Builder() {
        }

        public Builder(SetOrder setOrder) {
            super(setOrder);
            if (setOrder != null) {
                this.requestid = setOrder.requestid;
                this.bparam = setOrder.bparam;
                this.order = setOrder.order;
                this.is_group_buy = setOrder.is_group_buy;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public SetOrder build() {
            return new SetOrder(this);
        }
    }
}
