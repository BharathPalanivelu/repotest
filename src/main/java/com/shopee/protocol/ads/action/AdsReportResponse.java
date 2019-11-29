package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdsReportResponse extends Message {
    public static final String DEFAULT_BODY = "";
    public static final String DEFAULT_ERR_MESSAGE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String body;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 1)
    public final ResponseHeader header;

    public AdsReportResponse(ResponseHeader responseHeader, String str, String str2) {
        this.header = responseHeader;
        this.body = str;
        this.err_message = str2;
    }

    private AdsReportResponse(Builder builder) {
        this(builder.header, builder.body, builder.err_message);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsReportResponse)) {
            return false;
        }
        AdsReportResponse adsReportResponse = (AdsReportResponse) obj;
        if (!equals((Object) this.header, (Object) adsReportResponse.header) || !equals((Object) this.body, (Object) adsReportResponse.body) || !equals((Object) this.err_message, (Object) adsReportResponse.err_message)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        String str = this.body;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.err_message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsReportResponse> {
        public String body;
        public String err_message;
        public ResponseHeader header;

        public Builder() {
        }

        public Builder(AdsReportResponse adsReportResponse) {
            super(adsReportResponse);
            if (adsReportResponse != null) {
                this.header = adsReportResponse.header;
                this.body = adsReportResponse.body;
                this.err_message = adsReportResponse.err_message;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder body(String str) {
            this.body = str;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public AdsReportResponse build() {
            return new AdsReportResponse(this);
        }
    }
}
