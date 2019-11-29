package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AdsBlackListKeywordsResponse extends Message {
    public static final List<AdsBlackListKeywordDBModel> DEFAULT_BLACKLISTKEYWORDS = Collections.emptyList();
    public static final List<ResponseCommon> DEFAULT_RESPONSES = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdsBlackListKeywordDBModel.class, tag = 2)
    public final List<AdsBlackListKeywordDBModel> blackListKeywords;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResponseCommon.class, tag = 4)
    public final List<ResponseCommon> responses;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total;

    public AdsBlackListKeywordsResponse(ResponseHeader responseHeader, List<AdsBlackListKeywordDBModel> list, Integer num, List<ResponseCommon> list2) {
        this.header = responseHeader;
        this.blackListKeywords = immutableCopyOf(list);
        this.total = num;
        this.responses = immutableCopyOf(list2);
    }

    private AdsBlackListKeywordsResponse(Builder builder) {
        this(builder.header, builder.blackListKeywords, builder.total, builder.responses);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsBlackListKeywordsResponse)) {
            return false;
        }
        AdsBlackListKeywordsResponse adsBlackListKeywordsResponse = (AdsBlackListKeywordsResponse) obj;
        if (!equals((Object) this.header, (Object) adsBlackListKeywordsResponse.header) || !equals((List<?>) this.blackListKeywords, (List<?>) adsBlackListKeywordsResponse.blackListKeywords) || !equals((Object) this.total, (Object) adsBlackListKeywordsResponse.total) || !equals((List<?>) this.responses, (List<?>) adsBlackListKeywordsResponse.responses)) {
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
        List<AdsBlackListKeywordDBModel> list = this.blackListKeywords;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.total;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i4 = (hashCode2 + i2) * 37;
        List<ResponseCommon> list2 = this.responses;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<AdsBlackListKeywordsResponse> {
        public List<AdsBlackListKeywordDBModel> blackListKeywords;
        public ResponseHeader header;
        public List<ResponseCommon> responses;
        public Integer total;

        public Builder() {
        }

        public Builder(AdsBlackListKeywordsResponse adsBlackListKeywordsResponse) {
            super(adsBlackListKeywordsResponse);
            if (adsBlackListKeywordsResponse != null) {
                this.header = adsBlackListKeywordsResponse.header;
                this.blackListKeywords = AdsBlackListKeywordsResponse.copyOf(adsBlackListKeywordsResponse.blackListKeywords);
                this.total = adsBlackListKeywordsResponse.total;
                this.responses = AdsBlackListKeywordsResponse.copyOf(adsBlackListKeywordsResponse.responses);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder blackListKeywords(List<AdsBlackListKeywordDBModel> list) {
            this.blackListKeywords = checkForNulls(list);
            return this;
        }

        public Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public Builder responses(List<ResponseCommon> list) {
            this.responses = checkForNulls(list);
            return this;
        }

        public AdsBlackListKeywordsResponse build() {
            return new AdsBlackListKeywordsResponse(this);
        }
    }
}
