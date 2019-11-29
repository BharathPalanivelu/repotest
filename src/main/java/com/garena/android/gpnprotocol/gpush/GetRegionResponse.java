package com.garena.android.gpnprotocol.gpush;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetRegionResponse extends Message {
    public static final String DEFAULT_REGION = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String Region;

    public GetRegionResponse(String str) {
        this.Region = str;
    }

    private GetRegionResponse(Builder builder) {
        this(builder.Region);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetRegionResponse)) {
            return false;
        }
        return equals((Object) this.Region, (Object) ((GetRegionResponse) obj).Region);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.Region;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<GetRegionResponse> {
        public String Region;

        public Builder() {
        }

        public Builder(GetRegionResponse getRegionResponse) {
            super(getRegionResponse);
            if (getRegionResponse != null) {
                this.Region = getRegionResponse.Region;
            }
        }

        public Builder Region(String str) {
            this.Region = str;
            return this;
        }

        public GetRegionResponse build() {
            checkRequiredFields();
            return new GetRegionResponse(this);
        }
    }
}
