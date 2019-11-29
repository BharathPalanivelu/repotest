package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetShopSnapshot extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long snapshotid;

    public GetShopSnapshot(String str, Long l, BackendParam backendParam) {
        this.requestid = str;
        this.snapshotid = l;
        this.bparam = backendParam;
    }

    private GetShopSnapshot(Builder builder) {
        this(builder.requestid, builder.snapshotid, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetShopSnapshot)) {
            return false;
        }
        GetShopSnapshot getShopSnapshot = (GetShopSnapshot) obj;
        if (!equals((Object) this.requestid, (Object) getShopSnapshot.requestid) || !equals((Object) this.snapshotid, (Object) getShopSnapshot.snapshotid) || !equals((Object) this.bparam, (Object) getShopSnapshot.bparam)) {
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
        Long l = this.snapshotid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetShopSnapshot> {
        public BackendParam bparam;
        public String requestid;
        public Long snapshotid;

        public Builder() {
        }

        public Builder(GetShopSnapshot getShopSnapshot) {
            super(getShopSnapshot);
            if (getShopSnapshot != null) {
                this.requestid = getShopSnapshot.requestid;
                this.snapshotid = getShopSnapshot.snapshotid;
                this.bparam = getShopSnapshot.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public GetShopSnapshot build() {
            return new GetShopSnapshot(this);
        }
    }
}
