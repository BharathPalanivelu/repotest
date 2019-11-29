package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class KeywordRecommendResponse extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<RecommendKeyword> DEFAULT_KEYWORDS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = RecommendKeyword.class, tag = 4)
    public final List<RecommendKeyword> keywords;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public KeywordRecommendResponse(ResponseHeader responseHeader, Long l, Integer num, List<RecommendKeyword> list) {
        this.header = responseHeader;
        this.itemid = l;
        this.shopid = num;
        this.keywords = immutableCopyOf(list);
    }

    private KeywordRecommendResponse(Builder builder) {
        this(builder.header, builder.itemid, builder.shopid, builder.keywords);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeywordRecommendResponse)) {
            return false;
        }
        KeywordRecommendResponse keywordRecommendResponse = (KeywordRecommendResponse) obj;
        if (!equals((Object) this.header, (Object) keywordRecommendResponse.header) || !equals((Object) this.itemid, (Object) keywordRecommendResponse.itemid) || !equals((Object) this.shopid, (Object) keywordRecommendResponse.shopid) || !equals((List<?>) this.keywords, (List<?>) keywordRecommendResponse.keywords)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<RecommendKeyword> list = this.keywords;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<KeywordRecommendResponse> {
        public ResponseHeader header;
        public Long itemid;
        public List<RecommendKeyword> keywords;
        public Integer shopid;

        public Builder() {
        }

        public Builder(KeywordRecommendResponse keywordRecommendResponse) {
            super(keywordRecommendResponse);
            if (keywordRecommendResponse != null) {
                this.header = keywordRecommendResponse.header;
                this.itemid = keywordRecommendResponse.itemid;
                this.shopid = keywordRecommendResponse.shopid;
                this.keywords = KeywordRecommendResponse.copyOf(keywordRecommendResponse.keywords);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
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

        public Builder keywords(List<RecommendKeyword> list) {
            this.keywords = checkForNulls(list);
            return this;
        }

        public KeywordRecommendResponse build() {
            return new KeywordRecommendResponse(this);
        }
    }
}
