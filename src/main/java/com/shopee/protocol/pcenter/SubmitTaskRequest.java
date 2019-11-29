package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SubmitTaskRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final List<ItemCrawls> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_SIGNATURE = "";
    public static final Integer DEFAULT_SOURCE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemCrawls.class, tag = 2)
    public final List<ItemCrawls> items;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer source;

    public SubmitTaskRequest(RequestHeader requestHeader, List<ItemCrawls> list, String str, String str2, Integer num) {
        this.header = requestHeader;
        this.items = immutableCopyOf(list);
        this.country = str;
        this.signature = str2;
        this.source = num;
    }

    private SubmitTaskRequest(Builder builder) {
        this(builder.header, builder.items, builder.country, builder.signature, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitTaskRequest)) {
            return false;
        }
        SubmitTaskRequest submitTaskRequest = (SubmitTaskRequest) obj;
        if (!equals((Object) this.header, (Object) submitTaskRequest.header) || !equals((List<?>) this.items, (List<?>) submitTaskRequest.items) || !equals((Object) this.country, (Object) submitTaskRequest.country) || !equals((Object) this.signature, (Object) submitTaskRequest.signature) || !equals((Object) this.source, (Object) submitTaskRequest.source)) {
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
        List<ItemCrawls> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.signature;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.source;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SubmitTaskRequest> {
        public String country;
        public RequestHeader header;
        public List<ItemCrawls> items;
        public String signature;
        public Integer source;

        public Builder() {
        }

        public Builder(SubmitTaskRequest submitTaskRequest) {
            super(submitTaskRequest);
            if (submitTaskRequest != null) {
                this.header = submitTaskRequest.header;
                this.items = SubmitTaskRequest.copyOf(submitTaskRequest.items);
                this.country = submitTaskRequest.country;
                this.signature = submitTaskRequest.signature;
                this.source = submitTaskRequest.source;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder items(List<ItemCrawls> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public SubmitTaskRequest build() {
            return new SubmitTaskRequest(this);
        }
    }
}
