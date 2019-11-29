package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class KeywordRecommendRequest extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public KeywordRecommendRequest(RequestHeader requestHeader, Long l, Integer num, String str, Integer num2, String str2, Integer num3) {
        this.header = requestHeader;
        this.itemid = l;
        this.shopid = num;
        this.country = str;
        this.count = num2;
        this.keyword = str2;
        this.placement = num3;
    }

    private KeywordRecommendRequest(Builder builder) {
        this(builder.header, builder.itemid, builder.shopid, builder.country, builder.count, builder.keyword, builder.placement);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeywordRecommendRequest)) {
            return false;
        }
        KeywordRecommendRequest keywordRecommendRequest = (KeywordRecommendRequest) obj;
        if (!equals((Object) this.header, (Object) keywordRecommendRequest.header) || !equals((Object) this.itemid, (Object) keywordRecommendRequest.itemid) || !equals((Object) this.shopid, (Object) keywordRecommendRequest.shopid) || !equals((Object) this.country, (Object) keywordRecommendRequest.country) || !equals((Object) this.count, (Object) keywordRecommendRequest.count) || !equals((Object) this.keyword, (Object) keywordRecommendRequest.keyword) || !equals((Object) this.placement, (Object) keywordRecommendRequest.placement)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.count;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.keyword;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.placement;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<KeywordRecommendRequest> {
        public Integer count;
        public String country;
        public RequestHeader header;
        public Long itemid;
        public String keyword;
        public Integer placement;
        public Integer shopid;

        public Builder() {
        }

        public Builder(KeywordRecommendRequest keywordRecommendRequest) {
            super(keywordRecommendRequest);
            if (keywordRecommendRequest != null) {
                this.header = keywordRecommendRequest.header;
                this.itemid = keywordRecommendRequest.itemid;
                this.shopid = keywordRecommendRequest.shopid;
                this.country = keywordRecommendRequest.country;
                this.count = keywordRecommendRequest.count;
                this.keyword = keywordRecommendRequest.keyword;
                this.placement = keywordRecommendRequest.placement;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public KeywordRecommendRequest build() {
            return new KeywordRecommendRequest(this);
        }
    }
}
