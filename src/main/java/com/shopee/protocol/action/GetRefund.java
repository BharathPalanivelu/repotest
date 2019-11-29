package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetRefund extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Long DEFAULT_REFUND_ID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long refund_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public GetRefund(String str, Long l, Long l2, String str2, Long l3, BackendParam backendParam) {
        this.requestid = str;
        this.refund_id = l;
        this.return_id = l2;
        this.token = str2;
        this.checkoutid = l3;
        this.bparam = backendParam;
    }

    private GetRefund(Builder builder) {
        this(builder.requestid, builder.refund_id, builder.return_id, builder.token, builder.checkoutid, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetRefund)) {
            return false;
        }
        GetRefund getRefund = (GetRefund) obj;
        if (!equals((Object) this.requestid, (Object) getRefund.requestid) || !equals((Object) this.refund_id, (Object) getRefund.refund_id) || !equals((Object) this.return_id, (Object) getRefund.return_id) || !equals((Object) this.token, (Object) getRefund.token) || !equals((Object) this.checkoutid, (Object) getRefund.checkoutid) || !equals((Object) this.bparam, (Object) getRefund.bparam)) {
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
        Long l = this.refund_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.return_id;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l3 = this.checkoutid;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetRefund> {
        public BackendParam bparam;
        public Long checkoutid;
        public Long refund_id;
        public String requestid;
        public Long return_id;
        public String token;

        public Builder() {
        }

        public Builder(GetRefund getRefund) {
            super(getRefund);
            if (getRefund != null) {
                this.requestid = getRefund.requestid;
                this.refund_id = getRefund.refund_id;
                this.return_id = getRefund.return_id;
                this.token = getRefund.token;
                this.checkoutid = getRefund.checkoutid;
                this.bparam = getRefund.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder refund_id(Long l) {
            this.refund_id = l;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public GetRefund build() {
            return new GetRefund(this);
        }
    }
}
