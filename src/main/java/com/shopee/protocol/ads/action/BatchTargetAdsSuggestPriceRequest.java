package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchTargetAdsSuggestPriceRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_NEED_DEBUG = 0;
    public static final List<TargetAdsReqInfo> DEFAULT_REQ_INFO = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer need_debug;
    @ProtoField(label = Message.Label.REPEATED, messageType = TargetAdsReqInfo.class, tag = 2)
    public final List<TargetAdsReqInfo> req_info;

    public BatchTargetAdsSuggestPriceRequest(RequestHeader requestHeader, List<TargetAdsReqInfo> list, String str, Integer num) {
        this.header = requestHeader;
        this.req_info = immutableCopyOf(list);
        this.country = str;
        this.need_debug = num;
    }

    private BatchTargetAdsSuggestPriceRequest(Builder builder) {
        this(builder.header, builder.req_info, builder.country, builder.need_debug);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchTargetAdsSuggestPriceRequest)) {
            return false;
        }
        BatchTargetAdsSuggestPriceRequest batchTargetAdsSuggestPriceRequest = (BatchTargetAdsSuggestPriceRequest) obj;
        if (!equals((Object) this.header, (Object) batchTargetAdsSuggestPriceRequest.header) || !equals((List<?>) this.req_info, (List<?>) batchTargetAdsSuggestPriceRequest.req_info) || !equals((Object) this.country, (Object) batchTargetAdsSuggestPriceRequest.country) || !equals((Object) this.need_debug, (Object) batchTargetAdsSuggestPriceRequest.need_debug)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        List<TargetAdsReqInfo> list = this.req_info;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.need_debug;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BatchTargetAdsSuggestPriceRequest> {
        public String country;
        public RequestHeader header;
        public Integer need_debug;
        public List<TargetAdsReqInfo> req_info;

        public Builder() {
        }

        public Builder(BatchTargetAdsSuggestPriceRequest batchTargetAdsSuggestPriceRequest) {
            super(batchTargetAdsSuggestPriceRequest);
            if (batchTargetAdsSuggestPriceRequest != null) {
                this.header = batchTargetAdsSuggestPriceRequest.header;
                this.req_info = BatchTargetAdsSuggestPriceRequest.copyOf(batchTargetAdsSuggestPriceRequest.req_info);
                this.country = batchTargetAdsSuggestPriceRequest.country;
                this.need_debug = batchTargetAdsSuggestPriceRequest.need_debug;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder req_info(List<TargetAdsReqInfo> list) {
            this.req_info = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder need_debug(Integer num) {
            this.need_debug = num;
            return this;
        }

        public BatchTargetAdsSuggestPriceRequest build() {
            return new BatchTargetAdsSuggestPriceRequest(this);
        }
    }
}
