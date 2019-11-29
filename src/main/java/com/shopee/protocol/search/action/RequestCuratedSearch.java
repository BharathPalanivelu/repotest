package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestCuratedSearch extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_KEYWORD = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;

    public RequestCuratedSearch(RequestHeader requestHeader, String str, String str2) {
        this.header = requestHeader;
        this.keyword = str;
        this.country = str2;
    }

    private RequestCuratedSearch(Builder builder) {
        this(builder.header, builder.keyword, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestCuratedSearch)) {
            return false;
        }
        RequestCuratedSearch requestCuratedSearch = (RequestCuratedSearch) obj;
        if (!equals((Object) this.header, (Object) requestCuratedSearch.header) || !equals((Object) this.keyword, (Object) requestCuratedSearch.keyword) || !equals((Object) this.country, (Object) requestCuratedSearch.country)) {
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
        String str = this.keyword;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestCuratedSearch> {
        public String country;
        public RequestHeader header;
        public String keyword;

        public Builder() {
        }

        public Builder(RequestCuratedSearch requestCuratedSearch) {
            super(requestCuratedSearch);
            if (requestCuratedSearch != null) {
                this.header = requestCuratedSearch.header;
                this.keyword = requestCuratedSearch.keyword;
                this.country = requestCuratedSearch.country;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public RequestCuratedSearch build() {
            return new RequestCuratedSearch(this);
        }
    }
}
