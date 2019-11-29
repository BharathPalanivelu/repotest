package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCreateMultiOrder extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Long> DEFAULT_ORDERIDS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT64)
    public final List<Long> orderids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCreateMultiOrder(String str, Integer num, Long l, List<Long> list) {
        this.requestid = str;
        this.errcode = num;
        this.checkoutid = l;
        this.orderids = immutableCopyOf(list);
    }

    private ResponseCreateMultiOrder(Builder builder) {
        this(builder.requestid, builder.errcode, builder.checkoutid, builder.orderids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCreateMultiOrder)) {
            return false;
        }
        ResponseCreateMultiOrder responseCreateMultiOrder = (ResponseCreateMultiOrder) obj;
        if (!equals((Object) this.requestid, (Object) responseCreateMultiOrder.requestid) || !equals((Object) this.errcode, (Object) responseCreateMultiOrder.errcode) || !equals((Object) this.checkoutid, (Object) responseCreateMultiOrder.checkoutid) || !equals((List<?>) this.orderids, (List<?>) responseCreateMultiOrder.orderids)) {
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
        Long l = this.checkoutid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<Long> list = this.orderids;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseCreateMultiOrder> {
        public Long checkoutid;
        public Integer errcode;
        public List<Long> orderids;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCreateMultiOrder responseCreateMultiOrder) {
            super(responseCreateMultiOrder);
            if (responseCreateMultiOrder != null) {
                this.requestid = responseCreateMultiOrder.requestid;
                this.errcode = responseCreateMultiOrder.errcode;
                this.checkoutid = responseCreateMultiOrder.checkoutid;
                this.orderids = ResponseCreateMultiOrder.copyOf(responseCreateMultiOrder.orderids);
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

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder orderids(List<Long> list) {
            this.orderids = checkForNulls(list);
            return this;
        }

        public ResponseCreateMultiOrder build() {
            checkRequiredFields();
            return new ResponseCreateMultiOrder(this);
        }
    }
}
