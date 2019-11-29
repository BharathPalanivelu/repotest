package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetAdsBlackListKeywordsRequest extends Message {
    public static final List<AdsBlackListKeywordDBModel> DEFAULT_BLACKLISTKEYWORDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdsBlackListKeywordDBModel.class, tag = 1)
    public final List<AdsBlackListKeywordDBModel> blackListKeywords;
    @ProtoField(tag = 2)
    public final Header header;

    public SetAdsBlackListKeywordsRequest(List<AdsBlackListKeywordDBModel> list, Header header2) {
        this.blackListKeywords = immutableCopyOf(list);
        this.header = header2;
    }

    private SetAdsBlackListKeywordsRequest(Builder builder) {
        this(builder.blackListKeywords, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAdsBlackListKeywordsRequest)) {
            return false;
        }
        SetAdsBlackListKeywordsRequest setAdsBlackListKeywordsRequest = (SetAdsBlackListKeywordsRequest) obj;
        if (!equals((List<?>) this.blackListKeywords, (List<?>) setAdsBlackListKeywordsRequest.blackListKeywords) || !equals((Object) this.header, (Object) setAdsBlackListKeywordsRequest.header)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<AdsBlackListKeywordDBModel> list = this.blackListKeywords;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Header header2 = this.header;
        int hashCode2 = hashCode + (header2 != null ? header2.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetAdsBlackListKeywordsRequest> {
        public List<AdsBlackListKeywordDBModel> blackListKeywords;
        public Header header;

        public Builder() {
        }

        public Builder(SetAdsBlackListKeywordsRequest setAdsBlackListKeywordsRequest) {
            super(setAdsBlackListKeywordsRequest);
            if (setAdsBlackListKeywordsRequest != null) {
                this.blackListKeywords = SetAdsBlackListKeywordsRequest.copyOf(setAdsBlackListKeywordsRequest.blackListKeywords);
                this.header = setAdsBlackListKeywordsRequest.header;
            }
        }

        public Builder blackListKeywords(List<AdsBlackListKeywordDBModel> list) {
            this.blackListKeywords = checkForNulls(list);
            return this;
        }

        public Builder header(Header header2) {
            this.header = header2;
            return this;
        }

        public SetAdsBlackListKeywordsRequest build() {
            return new SetAdsBlackListKeywordsRequest(this);
        }
    }
}
