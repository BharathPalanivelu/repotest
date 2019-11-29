package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UpdateRefund extends Message {
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_REFUND_ID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long refund_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public UpdateRefund(String str, String str2, Long l, f fVar, Long l2, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.return_id = l;
        this.extinfo = fVar;
        this.refund_id = l2;
        this.bparam = backendParam;
    }

    private UpdateRefund(Builder builder) {
        this(builder.requestid, builder.token, builder.return_id, builder.extinfo, builder.refund_id, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateRefund)) {
            return false;
        }
        UpdateRefund updateRefund = (UpdateRefund) obj;
        if (!equals((Object) this.requestid, (Object) updateRefund.requestid) || !equals((Object) this.token, (Object) updateRefund.token) || !equals((Object) this.return_id, (Object) updateRefund.return_id) || !equals((Object) this.extinfo, (Object) updateRefund.extinfo) || !equals((Object) this.refund_id, (Object) updateRefund.refund_id) || !equals((Object) this.bparam, (Object) updateRefund.bparam)) {
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
        Long l = this.return_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l2 = this.refund_id;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UpdateRefund> {
        public BackendParam bparam;
        public f extinfo;
        public Long refund_id;
        public String requestid;
        public Long return_id;
        public String token;

        public Builder() {
        }

        public Builder(UpdateRefund updateRefund) {
            super(updateRefund);
            if (updateRefund != null) {
                this.requestid = updateRefund.requestid;
                this.token = updateRefund.token;
                this.return_id = updateRefund.return_id;
                this.extinfo = updateRefund.extinfo;
                this.refund_id = updateRefund.refund_id;
                this.bparam = updateRefund.bparam;
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

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder refund_id(Long l) {
            this.refund_id = l;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public UpdateRefund build() {
            return new UpdateRefund(this);
        }
    }
}
