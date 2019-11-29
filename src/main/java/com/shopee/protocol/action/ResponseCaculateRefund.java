package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCaculateRefund extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Long DEFAULT_MAX_REFUNDABLE_AMOUNT = 0L;
    public static final List<ItemRefundInfo> DEFAULT_REFUNDS = Collections.emptyList();
    public static final Boolean DEFAULT_REFUND_AMOUNT_ADJUSTABLE = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_RETURN_SOLUTIONS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long max_refundable_amount;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean refund_amount_adjustable;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemRefundInfo.class, tag = 3)
    public final List<ItemRefundInfo> refunds;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> return_solutions;

    public ResponseCaculateRefund(String str, Integer num, List<ItemRefundInfo> list, Long l, List<Integer> list2, Boolean bool) {
        this.requestid = str;
        this.errcode = num;
        this.refunds = immutableCopyOf(list);
        this.max_refundable_amount = l;
        this.return_solutions = immutableCopyOf(list2);
        this.refund_amount_adjustable = bool;
    }

    private ResponseCaculateRefund(Builder builder) {
        this(builder.requestid, builder.errcode, builder.refunds, builder.max_refundable_amount, builder.return_solutions, builder.refund_amount_adjustable);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCaculateRefund)) {
            return false;
        }
        ResponseCaculateRefund responseCaculateRefund = (ResponseCaculateRefund) obj;
        if (!equals((Object) this.requestid, (Object) responseCaculateRefund.requestid) || !equals((Object) this.errcode, (Object) responseCaculateRefund.errcode) || !equals((List<?>) this.refunds, (List<?>) responseCaculateRefund.refunds) || !equals((Object) this.max_refundable_amount, (Object) responseCaculateRefund.max_refundable_amount) || !equals((List<?>) this.return_solutions, (List<?>) responseCaculateRefund.return_solutions) || !equals((Object) this.refund_amount_adjustable, (Object) responseCaculateRefund.refund_amount_adjustable)) {
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
        List<ItemRefundInfo> list = this.refunds;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.max_refundable_amount;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        List<Integer> list2 = this.return_solutions;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode4 + i3) * 37;
        Boolean bool = this.refund_amount_adjustable;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseCaculateRefund> {
        public Integer errcode;
        public Long max_refundable_amount;
        public Boolean refund_amount_adjustable;
        public List<ItemRefundInfo> refunds;
        public String requestid;
        public List<Integer> return_solutions;

        public Builder() {
        }

        public Builder(ResponseCaculateRefund responseCaculateRefund) {
            super(responseCaculateRefund);
            if (responseCaculateRefund != null) {
                this.requestid = responseCaculateRefund.requestid;
                this.errcode = responseCaculateRefund.errcode;
                this.refunds = ResponseCaculateRefund.copyOf(responseCaculateRefund.refunds);
                this.max_refundable_amount = responseCaculateRefund.max_refundable_amount;
                this.return_solutions = ResponseCaculateRefund.copyOf(responseCaculateRefund.return_solutions);
                this.refund_amount_adjustable = responseCaculateRefund.refund_amount_adjustable;
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

        public Builder refunds(List<ItemRefundInfo> list) {
            this.refunds = checkForNulls(list);
            return this;
        }

        public Builder max_refundable_amount(Long l) {
            this.max_refundable_amount = l;
            return this;
        }

        public Builder return_solutions(List<Integer> list) {
            this.return_solutions = checkForNulls(list);
            return this;
        }

        public Builder refund_amount_adjustable(Boolean bool) {
            this.refund_amount_adjustable = bool;
            return this;
        }

        public ResponseCaculateRefund build() {
            return new ResponseCaculateRefund(this);
        }
    }
}
