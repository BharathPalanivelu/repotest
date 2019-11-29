package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchTargetAdsSuggestPriceResponse extends Message {
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final List<TargetAdsRespInfo> DEFAULT_RESP_INFO = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = TargetAdsRespInfo.class, tag = 3)
    public final List<TargetAdsRespInfo> resp_info;

    public BatchTargetAdsSuggestPriceResponse(ResponseHeader responseHeader, String str, List<TargetAdsRespInfo> list) {
        this.header = responseHeader;
        this.err_message = str;
        this.resp_info = immutableCopyOf(list);
    }

    private BatchTargetAdsSuggestPriceResponse(Builder builder) {
        this(builder.header, builder.err_message, builder.resp_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchTargetAdsSuggestPriceResponse)) {
            return false;
        }
        BatchTargetAdsSuggestPriceResponse batchTargetAdsSuggestPriceResponse = (BatchTargetAdsSuggestPriceResponse) obj;
        if (!equals((Object) this.header, (Object) batchTargetAdsSuggestPriceResponse.header) || !equals((Object) this.err_message, (Object) batchTargetAdsSuggestPriceResponse.err_message) || !equals((List<?>) this.resp_info, (List<?>) batchTargetAdsSuggestPriceResponse.resp_info)) {
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
        String str = this.err_message;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<TargetAdsRespInfo> list = this.resp_info;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BatchTargetAdsSuggestPriceResponse> {
        public String err_message;
        public ResponseHeader header;
        public List<TargetAdsRespInfo> resp_info;

        public Builder() {
        }

        public Builder(BatchTargetAdsSuggestPriceResponse batchTargetAdsSuggestPriceResponse) {
            super(batchTargetAdsSuggestPriceResponse);
            if (batchTargetAdsSuggestPriceResponse != null) {
                this.header = batchTargetAdsSuggestPriceResponse.header;
                this.err_message = batchTargetAdsSuggestPriceResponse.err_message;
                this.resp_info = BatchTargetAdsSuggestPriceResponse.copyOf(batchTargetAdsSuggestPriceResponse.resp_info);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public Builder resp_info(List<TargetAdsRespInfo> list) {
            this.resp_info = checkForNulls(list);
            return this;
        }

        public BatchTargetAdsSuggestPriceResponse build() {
            return new BatchTargetAdsSuggestPriceResponse(this);
        }
    }
}
