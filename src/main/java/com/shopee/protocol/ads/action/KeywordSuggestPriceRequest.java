package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class KeywordSuggestPriceRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<String> DEFAULT_KEYWORD = Collections.emptyList();
    public static final Integer DEFAULT_NEED_DEBUG = 0;
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> keyword;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer need_debug;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public KeywordSuggestPriceRequest(RequestHeader requestHeader, Long l, Integer num, String str, List<String> list, Integer num2, Integer num3) {
        this.header = requestHeader;
        this.itemid = l;
        this.shopid = num;
        this.country = str;
        this.keyword = immutableCopyOf(list);
        this.need_debug = num2;
        this.placement = num3;
    }

    private KeywordSuggestPriceRequest(Builder builder) {
        this(builder.header, builder.itemid, builder.shopid, builder.country, builder.keyword, builder.need_debug, builder.placement);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeywordSuggestPriceRequest)) {
            return false;
        }
        KeywordSuggestPriceRequest keywordSuggestPriceRequest = (KeywordSuggestPriceRequest) obj;
        if (!equals((Object) this.header, (Object) keywordSuggestPriceRequest.header) || !equals((Object) this.itemid, (Object) keywordSuggestPriceRequest.itemid) || !equals((Object) this.shopid, (Object) keywordSuggestPriceRequest.shopid) || !equals((Object) this.country, (Object) keywordSuggestPriceRequest.country) || !equals((List<?>) this.keyword, (List<?>) keywordSuggestPriceRequest.keyword) || !equals((Object) this.need_debug, (Object) keywordSuggestPriceRequest.need_debug) || !equals((Object) this.placement, (Object) keywordSuggestPriceRequest.placement)) {
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
        List<String> list = this.keyword;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.need_debug;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.placement;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<KeywordSuggestPriceRequest> {
        public String country;
        public RequestHeader header;
        public Long itemid;
        public List<String> keyword;
        public Integer need_debug;
        public Integer placement;
        public Integer shopid;

        public Builder() {
        }

        public Builder(KeywordSuggestPriceRequest keywordSuggestPriceRequest) {
            super(keywordSuggestPriceRequest);
            if (keywordSuggestPriceRequest != null) {
                this.header = keywordSuggestPriceRequest.header;
                this.itemid = keywordSuggestPriceRequest.itemid;
                this.shopid = keywordSuggestPriceRequest.shopid;
                this.country = keywordSuggestPriceRequest.country;
                this.keyword = KeywordSuggestPriceRequest.copyOf(keywordSuggestPriceRequest.keyword);
                this.need_debug = keywordSuggestPriceRequest.need_debug;
                this.placement = keywordSuggestPriceRequest.placement;
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

        public Builder keyword(List<String> list) {
            this.keyword = checkForNulls(list);
            return this;
        }

        public Builder need_debug(Integer num) {
            this.need_debug = num;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public KeywordSuggestPriceRequest build() {
            return new KeywordSuggestPriceRequest(this);
        }
    }
}
