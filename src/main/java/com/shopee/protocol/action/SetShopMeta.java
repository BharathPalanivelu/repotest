package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SetShopMeta extends Message {
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final Long DEFAULT_GPID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long gpid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetShopMeta(String str, f fVar, Long l) {
        this.requestid = str;
        this.deviceid = fVar;
        this.gpid = l;
    }

    private SetShopMeta(Builder builder) {
        this(builder.requestid, builder.deviceid, builder.gpid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetShopMeta)) {
            return false;
        }
        SetShopMeta setShopMeta = (SetShopMeta) obj;
        if (!equals((Object) this.requestid, (Object) setShopMeta.requestid) || !equals((Object) this.deviceid, (Object) setShopMeta.deviceid) || !equals((Object) this.gpid, (Object) setShopMeta.gpid)) {
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
        f fVar = this.deviceid;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l = this.gpid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetShopMeta> {
        public f deviceid;
        public Long gpid;
        public String requestid;

        public Builder() {
        }

        public Builder(SetShopMeta setShopMeta) {
            super(setShopMeta);
            if (setShopMeta != null) {
                this.requestid = setShopMeta.requestid;
                this.deviceid = setShopMeta.deviceid;
                this.gpid = setShopMeta.gpid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder gpid(Long l) {
            this.gpid = l;
            return this;
        }

        public SetShopMeta build() {
            return new SetShopMeta(this);
        }
    }
}
