package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestSearchCover extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 5)
    public final MatchType match;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;

    public RequestSearchCover(RequestHeader requestHeader, Integer num, Integer num2, String str, MatchType matchType, Integer num3) {
        this.header = requestHeader;
        this.offset = num;
        this.limit = num2;
        this.country = str;
        this.match = matchType;
        this.shopid = num3;
    }

    private RequestSearchCover(Builder builder) {
        this(builder.header, builder.offset, builder.limit, builder.country, builder.match, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestSearchCover)) {
            return false;
        }
        RequestSearchCover requestSearchCover = (RequestSearchCover) obj;
        if (!equals((Object) this.header, (Object) requestSearchCover.header) || !equals((Object) this.offset, (Object) requestSearchCover.offset) || !equals((Object) this.limit, (Object) requestSearchCover.limit) || !equals((Object) this.country, (Object) requestSearchCover.country) || !equals((Object) this.match, (Object) requestSearchCover.match) || !equals((Object) this.shopid, (Object) requestSearchCover.shopid)) {
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
        Integer num = this.offset;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        MatchType matchType = this.match;
        int hashCode5 = (hashCode4 + (matchType != null ? matchType.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestSearchCover> {
        public String country;
        public RequestHeader header;
        public Integer limit;
        public MatchType match;
        public Integer offset;
        public Integer shopid;

        public Builder() {
        }

        public Builder(RequestSearchCover requestSearchCover) {
            super(requestSearchCover);
            if (requestSearchCover != null) {
                this.header = requestSearchCover.header;
                this.offset = requestSearchCover.offset;
                this.limit = requestSearchCover.limit;
                this.country = requestSearchCover.country;
                this.match = requestSearchCover.match;
                this.shopid = requestSearchCover.shopid;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder match(MatchType matchType) {
            this.match = matchType;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public RequestSearchCover build() {
            return new RequestSearchCover(this);
        }
    }
}
