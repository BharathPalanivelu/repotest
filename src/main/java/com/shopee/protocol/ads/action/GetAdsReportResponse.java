package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetAdsReportResponse extends Message {
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final List<KeyMap> DEFAULT_RESULT = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = KeyMap.class, tag = 2)
    public final List<KeyMap> result;

    public GetAdsReportResponse(ResponseHeader responseHeader, List<KeyMap> list, String str) {
        this.header = responseHeader;
        this.result = immutableCopyOf(list);
        this.err_message = str;
    }

    private GetAdsReportResponse(Builder builder) {
        this(builder.header, builder.result, builder.err_message);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetAdsReportResponse)) {
            return false;
        }
        GetAdsReportResponse getAdsReportResponse = (GetAdsReportResponse) obj;
        if (!equals((Object) this.header, (Object) getAdsReportResponse.header) || !equals((List<?>) this.result, (List<?>) getAdsReportResponse.result) || !equals((Object) this.err_message, (Object) getAdsReportResponse.err_message)) {
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
        List<KeyMap> list = this.result;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.err_message;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetAdsReportResponse> {
        public String err_message;
        public ResponseHeader header;
        public List<KeyMap> result;

        public Builder() {
        }

        public Builder(GetAdsReportResponse getAdsReportResponse) {
            super(getAdsReportResponse);
            if (getAdsReportResponse != null) {
                this.header = getAdsReportResponse.header;
                this.result = GetAdsReportResponse.copyOf(getAdsReportResponse.result);
                this.err_message = getAdsReportResponse.err_message;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder result(List<KeyMap> list) {
            this.result = checkForNulls(list);
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public GetAdsReportResponse build() {
            return new GetAdsReportResponse(this);
        }
    }
}
