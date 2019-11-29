package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetSnapshot extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long snapshotid;

    public GetSnapshot(String str, Integer num, Long l) {
        this.requestid = str;
        this.shopid = num;
        this.snapshotid = l;
    }

    private GetSnapshot(Builder builder) {
        this(builder.requestid, builder.shopid, builder.snapshotid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSnapshot)) {
            return false;
        }
        GetSnapshot getSnapshot = (GetSnapshot) obj;
        if (!equals((Object) this.requestid, (Object) getSnapshot.requestid) || !equals((Object) this.shopid, (Object) getSnapshot.shopid) || !equals((Object) this.snapshotid, (Object) getSnapshot.snapshotid)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.snapshotid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetSnapshot> {
        public String requestid;
        public Integer shopid;
        public Long snapshotid;

        public Builder() {
        }

        public Builder(GetSnapshot getSnapshot) {
            super(getSnapshot);
            if (getSnapshot != null) {
                this.requestid = getSnapshot.requestid;
                this.shopid = getSnapshot.shopid;
                this.snapshotid = getSnapshot.snapshotid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public GetSnapshot build() {
            checkRequiredFields();
            return new GetSnapshot(this);
        }
    }
}
