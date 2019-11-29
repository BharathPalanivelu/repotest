package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CancelOrder extends Message {
    public static final Integer DEFAULT_CANCEL_REASON = 0;
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Boolean DEFAULT_SILENT_CANCEL = false;
    public static final List<ItemModelId> DEFAULT_STOCKOUTITEMMODELS = Collections.emptyList();
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer cancel_reason;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean silent_cancel;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModelId.class, tag = 9)
    public final List<ItemModelId> stockoutItemModels;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;

    public CancelOrder(String str, Long l, Integer num, BackendParam backendParam, Integer num2, String str2, Boolean bool, Boolean bool2, List<ItemModelId> list) {
        this.requestid = str;
        this.orderid = l;
        this.shopid = num;
        this.bparam = backendParam;
        this.cancel_reason = num2;
        this.token = str2;
        this.silent_cancel = bool;
        this.is_group_buy = bool2;
        this.stockoutItemModels = immutableCopyOf(list);
    }

    private CancelOrder(Builder builder) {
        this(builder.requestid, builder.orderid, builder.shopid, builder.bparam, builder.cancel_reason, builder.token, builder.silent_cancel, builder.is_group_buy, builder.stockoutItemModels);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelOrder)) {
            return false;
        }
        CancelOrder cancelOrder = (CancelOrder) obj;
        if (!equals((Object) this.requestid, (Object) cancelOrder.requestid) || !equals((Object) this.orderid, (Object) cancelOrder.orderid) || !equals((Object) this.shopid, (Object) cancelOrder.shopid) || !equals((Object) this.bparam, (Object) cancelOrder.bparam) || !equals((Object) this.cancel_reason, (Object) cancelOrder.cancel_reason) || !equals((Object) this.token, (Object) cancelOrder.token) || !equals((Object) this.silent_cancel, (Object) cancelOrder.silent_cancel) || !equals((Object) this.is_group_buy, (Object) cancelOrder.is_group_buy) || !equals((List<?>) this.stockoutItemModels, (List<?>) cancelOrder.stockoutItemModels)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num2 = this.cancel_reason;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.silent_cancel;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_group_buy;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = (hashCode7 + i2) * 37;
        List<ItemModelId> list = this.stockoutItemModels;
        int hashCode8 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode8;
        return hashCode8;
    }

    public static final class Builder extends Message.Builder<CancelOrder> {
        public BackendParam bparam;
        public Integer cancel_reason;
        public Boolean is_group_buy;
        public Long orderid;
        public String requestid;
        public Integer shopid;
        public Boolean silent_cancel;
        public List<ItemModelId> stockoutItemModels;
        public String token;

        public Builder() {
        }

        public Builder(CancelOrder cancelOrder) {
            super(cancelOrder);
            if (cancelOrder != null) {
                this.requestid = cancelOrder.requestid;
                this.orderid = cancelOrder.orderid;
                this.shopid = cancelOrder.shopid;
                this.bparam = cancelOrder.bparam;
                this.cancel_reason = cancelOrder.cancel_reason;
                this.token = cancelOrder.token;
                this.silent_cancel = cancelOrder.silent_cancel;
                this.is_group_buy = cancelOrder.is_group_buy;
                this.stockoutItemModels = CancelOrder.copyOf(cancelOrder.stockoutItemModels);
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder cancel_reason(Integer num) {
            this.cancel_reason = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder silent_cancel(Boolean bool) {
            this.silent_cancel = bool;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public Builder stockoutItemModels(List<ItemModelId> list) {
            this.stockoutItemModels = checkForNulls(list);
            return this;
        }

        public CancelOrder build() {
            checkRequiredFields();
            return new CancelOrder(this);
        }
    }
}
