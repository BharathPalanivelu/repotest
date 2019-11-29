package com.garena.android.gpnprotocol.gpush;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetGPidResponse extends Message {
    public static final String DEFAULT_CONNSERVERADDR = "";
    public static final Long DEFAULT_GPID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String ConnServerAddr;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long GPid;

    public GetGPidResponse(Long l, String str) {
        this.GPid = l;
        this.ConnServerAddr = str;
    }

    private GetGPidResponse(Builder builder) {
        this(builder.GPid, builder.ConnServerAddr);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetGPidResponse)) {
            return false;
        }
        GetGPidResponse getGPidResponse = (GetGPidResponse) obj;
        if (!equals((Object) this.GPid, (Object) getGPidResponse.GPid) || !equals((Object) this.ConnServerAddr, (Object) getGPidResponse.ConnServerAddr)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.GPid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.ConnServerAddr;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetGPidResponse> {
        public String ConnServerAddr;
        public Long GPid;

        public Builder() {
        }

        public Builder(GetGPidResponse getGPidResponse) {
            super(getGPidResponse);
            if (getGPidResponse != null) {
                this.GPid = getGPidResponse.GPid;
                this.ConnServerAddr = getGPidResponse.ConnServerAddr;
            }
        }

        public Builder GPid(Long l) {
            this.GPid = l;
            return this;
        }

        public Builder ConnServerAddr(String str) {
            this.ConnServerAddr = str;
            return this;
        }

        public GetGPidResponse build() {
            checkRequiredFields();
            return new GetGPidResponse(this);
        }
    }
}
