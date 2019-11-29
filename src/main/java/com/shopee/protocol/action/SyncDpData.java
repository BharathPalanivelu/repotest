package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SyncDpData extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    public SyncDpData(String str, BackendParam backendParam, Integer num, Long l) {
        this.requestid = str;
        this.bparam = backendParam;
        this.type = num;
        this.orderid = l;
    }

    private SyncDpData(Builder builder) {
        this(builder.requestid, builder.bparam, builder.type, builder.orderid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SyncDpData)) {
            return false;
        }
        SyncDpData syncDpData = (SyncDpData) obj;
        if (!equals((Object) this.requestid, (Object) syncDpData.requestid) || !equals((Object) this.bparam, (Object) syncDpData.bparam) || !equals((Object) this.type, (Object) syncDpData.type) || !equals((Object) this.orderid, (Object) syncDpData.orderid)) {
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
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.orderid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SyncDpData> {
        public BackendParam bparam;
        public Long orderid;
        public String requestid;
        public Integer type;

        public Builder() {
        }

        public Builder(SyncDpData syncDpData) {
            super(syncDpData);
            if (syncDpData != null) {
                this.requestid = syncDpData.requestid;
                this.bparam = syncDpData.bparam;
                this.type = syncDpData.type;
                this.orderid = syncDpData.orderid;
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

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public SyncDpData build() {
            return new SyncDpData(this);
        }
    }
}
