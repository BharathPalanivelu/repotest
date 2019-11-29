package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CaculateRefund extends Message {
    public static final Boolean DEFAULT_NEED_RETURN_SOLUTION = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<ReturnItem> DEFAULT_RETURN_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_RETURN_REASON = 0;
    public static final Integer DEFAULT_RETURN_SOLUTION = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9)
    public final BackendParam bparam;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean need_return_solution;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ReturnItem.class, tag = 7)
    public final List<ReturnItem> return_items;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer return_reason;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer return_solution;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public CaculateRefund(String str, Long l, Integer num, String str2, Integer num2, Integer num3, List<ReturnItem> list, Boolean bool, BackendParam backendParam) {
        this.requestid = str;
        this.orderid = l;
        this.shopid = num;
        this.token = str2;
        this.return_solution = num2;
        this.return_reason = num3;
        this.return_items = immutableCopyOf(list);
        this.need_return_solution = bool;
        this.bparam = backendParam;
    }

    private CaculateRefund(Builder builder) {
        this(builder.requestid, builder.orderid, builder.shopid, builder.token, builder.return_solution, builder.return_reason, builder.return_items, builder.need_return_solution, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaculateRefund)) {
            return false;
        }
        CaculateRefund caculateRefund = (CaculateRefund) obj;
        if (!equals((Object) this.requestid, (Object) caculateRefund.requestid) || !equals((Object) this.orderid, (Object) caculateRefund.orderid) || !equals((Object) this.shopid, (Object) caculateRefund.shopid) || !equals((Object) this.token, (Object) caculateRefund.token) || !equals((Object) this.return_solution, (Object) caculateRefund.return_solution) || !equals((Object) this.return_reason, (Object) caculateRefund.return_reason) || !equals((List<?>) this.return_items, (List<?>) caculateRefund.return_items) || !equals((Object) this.need_return_solution, (Object) caculateRefund.need_return_solution) || !equals((Object) this.bparam, (Object) caculateRefund.bparam)) {
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
        Integer num2 = this.return_solution;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.return_reason;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<ReturnItem> list = this.return_items;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.need_return_solution;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CaculateRefund> {
        public BackendParam bparam;
        public Boolean need_return_solution;
        public Long orderid;
        public String requestid;
        public List<ReturnItem> return_items;
        public Integer return_reason;
        public Integer return_solution;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(CaculateRefund caculateRefund) {
            super(caculateRefund);
            if (caculateRefund != null) {
                this.requestid = caculateRefund.requestid;
                this.orderid = caculateRefund.orderid;
                this.shopid = caculateRefund.shopid;
                this.token = caculateRefund.token;
                this.return_solution = caculateRefund.return_solution;
                this.return_reason = caculateRefund.return_reason;
                this.return_items = CaculateRefund.copyOf(caculateRefund.return_items);
                this.need_return_solution = caculateRefund.need_return_solution;
                this.bparam = caculateRefund.bparam;
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

        public Builder return_solution(Integer num) {
            this.return_solution = num;
            return this;
        }

        public Builder return_reason(Integer num) {
            this.return_reason = num;
            return this;
        }

        public Builder return_items(List<ReturnItem> list) {
            this.return_items = checkForNulls(list);
            return this;
        }

        public Builder need_return_solution(Boolean bool) {
            this.need_return_solution = bool;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public CaculateRefund build() {
            return new CaculateRefund(this);
        }
    }
}
