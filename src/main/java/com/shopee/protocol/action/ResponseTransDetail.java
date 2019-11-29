package com.shopee.protocol.action;

import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.OrderAudit;
import com.shopee.protocol.shop.OrderItem;
import com.shopee.protocol.shop.TransHistory;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseTransDetail extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<FeeInfo> DEFAULT_FEE = Collections.emptyList();
    public static final List<OrderItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final List<OrderAudit> DEFAULT_PAYMENT_TRACK = Collections.emptyList();
    public static final Long DEFAULT_REBATE_FEE = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_USING_WALLET = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeeInfo.class, tag = 10)
    public final List<FeeInfo> fee;
    @ProtoField(tag = 5)
    public final OrderInfo info;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItem.class, tag = 4)
    public final List<OrderItem> items;
    @ProtoField(tag = 3)
    public final Order order;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderAudit.class, tag = 7)
    public final List<OrderAudit> payment_track;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long rebate_fee;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6)
    public final TransHistory trans;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean using_wallet;

    public ResponseTransDetail(String str, Integer num, Order order2, List<OrderItem> list, OrderInfo orderInfo, TransHistory transHistory, List<OrderAudit> list2, Long l, List<FeeInfo> list3, Boolean bool) {
        this.requestid = str;
        this.errcode = num;
        this.order = order2;
        this.items = immutableCopyOf(list);
        this.info = orderInfo;
        this.trans = transHistory;
        this.payment_track = immutableCopyOf(list2);
        this.rebate_fee = l;
        this.fee = immutableCopyOf(list3);
        this.using_wallet = bool;
    }

    private ResponseTransDetail(Builder builder) {
        this(builder.requestid, builder.errcode, builder.order, builder.items, builder.info, builder.trans, builder.payment_track, builder.rebate_fee, builder.fee, builder.using_wallet);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseTransDetail)) {
            return false;
        }
        ResponseTransDetail responseTransDetail = (ResponseTransDetail) obj;
        if (!equals((Object) this.requestid, (Object) responseTransDetail.requestid) || !equals((Object) this.errcode, (Object) responseTransDetail.errcode) || !equals((Object) this.order, (Object) responseTransDetail.order) || !equals((List<?>) this.items, (List<?>) responseTransDetail.items) || !equals((Object) this.info, (Object) responseTransDetail.info) || !equals((Object) this.trans, (Object) responseTransDetail.trans) || !equals((List<?>) this.payment_track, (List<?>) responseTransDetail.payment_track) || !equals((Object) this.rebate_fee, (Object) responseTransDetail.rebate_fee) || !equals((List<?>) this.fee, (List<?>) responseTransDetail.fee) || !equals((Object) this.using_wallet, (Object) responseTransDetail.using_wallet)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Order order2 = this.order;
        int hashCode3 = (hashCode2 + (order2 != null ? order2.hashCode() : 0)) * 37;
        List<OrderItem> list = this.items;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        OrderInfo orderInfo = this.info;
        int hashCode5 = (hashCode4 + (orderInfo != null ? orderInfo.hashCode() : 0)) * 37;
        TransHistory transHistory = this.trans;
        int hashCode6 = (hashCode5 + (transHistory != null ? transHistory.hashCode() : 0)) * 37;
        List<OrderAudit> list2 = this.payment_track;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Long l = this.rebate_fee;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        List<FeeInfo> list3 = this.fee;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i4 = (hashCode8 + i3) * 37;
        Boolean bool = this.using_wallet;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseTransDetail> {
        public Integer errcode;
        public List<FeeInfo> fee;
        public OrderInfo info;
        public List<OrderItem> items;
        public Order order;
        public List<OrderAudit> payment_track;
        public Long rebate_fee;
        public String requestid;
        public TransHistory trans;
        public Boolean using_wallet;

        public Builder() {
        }

        public Builder(ResponseTransDetail responseTransDetail) {
            super(responseTransDetail);
            if (responseTransDetail != null) {
                this.requestid = responseTransDetail.requestid;
                this.errcode = responseTransDetail.errcode;
                this.order = responseTransDetail.order;
                this.items = ResponseTransDetail.copyOf(responseTransDetail.items);
                this.info = responseTransDetail.info;
                this.trans = responseTransDetail.trans;
                this.payment_track = ResponseTransDetail.copyOf(responseTransDetail.payment_track);
                this.rebate_fee = responseTransDetail.rebate_fee;
                this.fee = ResponseTransDetail.copyOf(responseTransDetail.fee);
                this.using_wallet = responseTransDetail.using_wallet;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder items(List<OrderItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder info(OrderInfo orderInfo) {
            this.info = orderInfo;
            return this;
        }

        public Builder trans(TransHistory transHistory) {
            this.trans = transHistory;
            return this;
        }

        public Builder payment_track(List<OrderAudit> list) {
            this.payment_track = checkForNulls(list);
            return this;
        }

        public Builder rebate_fee(Long l) {
            this.rebate_fee = l;
            return this;
        }

        public Builder fee(List<FeeInfo> list) {
            this.fee = checkForNulls(list);
            return this;
        }

        public Builder using_wallet(Boolean bool) {
            this.using_wallet = bool;
            return this;
        }

        public ResponseTransDetail build() {
            checkRequiredFields();
            return new ResponseTransDetail(this);
        }
    }
}
