package com.garena.android.gpnprotocol.gpush;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetGPidRequest extends Message {
    public static final Long DEFAULT_OLDID = 0L;
    public static final Long DEFAULT_SIGN = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long OldId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long Sign;

    public GetGPidRequest(Long l, Long l2) {
        this.Sign = l;
        this.OldId = l2;
    }

    private GetGPidRequest(Builder builder) {
        this(builder.Sign, builder.OldId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetGPidRequest)) {
            return false;
        }
        GetGPidRequest getGPidRequest = (GetGPidRequest) obj;
        if (!equals((Object) this.Sign, (Object) getGPidRequest.Sign) || !equals((Object) this.OldId, (Object) getGPidRequest.OldId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.Sign;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.OldId;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetGPidRequest> {
        public Long OldId;
        public Long Sign;

        public Builder() {
        }

        public Builder(GetGPidRequest getGPidRequest) {
            super(getGPidRequest);
            if (getGPidRequest != null) {
                this.Sign = getGPidRequest.Sign;
                this.OldId = getGPidRequest.OldId;
            }
        }

        public Builder Sign(Long l) {
            this.Sign = l;
            return this;
        }

        public Builder OldId(Long l) {
            this.OldId = l;
            return this;
        }

        public GetGPidRequest build() {
            checkRequiredFields();
            return new GetGPidRequest(this);
        }
    }
}
