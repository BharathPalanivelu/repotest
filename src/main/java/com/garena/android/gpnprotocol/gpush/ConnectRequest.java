package com.garena.android.gpnprotocol.gpush;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnectRequest extends Message {
    public static final Long DEFAULT_GPID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long GPid;

    public ConnectRequest(Long l) {
        this.GPid = l;
    }

    private ConnectRequest(Builder builder) {
        this(builder.GPid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectRequest)) {
            return false;
        }
        return equals((Object) this.GPid, (Object) ((ConnectRequest) obj).GPid);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Long l = this.GPid;
            i = l != null ? l.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnectRequest> {
        public Long GPid;

        public Builder() {
        }

        public Builder(ConnectRequest connectRequest) {
            super(connectRequest);
            if (connectRequest != null) {
                this.GPid = connectRequest.GPid;
            }
        }

        public Builder GPid(Long l) {
            this.GPid = l;
            return this;
        }

        public ConnectRequest build() {
            checkRequiredFields();
            return new ConnectRequest(this);
        }
    }
}
