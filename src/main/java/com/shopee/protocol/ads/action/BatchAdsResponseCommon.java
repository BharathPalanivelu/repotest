package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchAdsResponseCommon extends Message {
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final List<AdsResponseCommon> DEFAULT_RESPONSES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdsResponseCommon.class, tag = 3)
    public final List<AdsResponseCommon> responses;

    public BatchAdsResponseCommon(ResponseHeader responseHeader, String str, List<AdsResponseCommon> list) {
        this.header = responseHeader;
        this.err_message = str;
        this.responses = immutableCopyOf(list);
    }

    private BatchAdsResponseCommon(Builder builder) {
        this(builder.header, builder.err_message, builder.responses);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchAdsResponseCommon)) {
            return false;
        }
        BatchAdsResponseCommon batchAdsResponseCommon = (BatchAdsResponseCommon) obj;
        if (!equals((Object) this.header, (Object) batchAdsResponseCommon.header) || !equals((Object) this.err_message, (Object) batchAdsResponseCommon.err_message) || !equals((List<?>) this.responses, (List<?>) batchAdsResponseCommon.responses)) {
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
        List<AdsResponseCommon> list = this.responses;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BatchAdsResponseCommon> {
        public String err_message;
        public ResponseHeader header;
        public List<AdsResponseCommon> responses;

        public Builder() {
        }

        public Builder(BatchAdsResponseCommon batchAdsResponseCommon) {
            super(batchAdsResponseCommon);
            if (batchAdsResponseCommon != null) {
                this.header = batchAdsResponseCommon.header;
                this.err_message = batchAdsResponseCommon.err_message;
                this.responses = BatchAdsResponseCommon.copyOf(batchAdsResponseCommon.responses);
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

        public Builder responses(List<AdsResponseCommon> list) {
            this.responses = checkForNulls(list);
            return this;
        }

        public BatchAdsResponseCommon build() {
            return new BatchAdsResponseCommon(this);
        }
    }
}
