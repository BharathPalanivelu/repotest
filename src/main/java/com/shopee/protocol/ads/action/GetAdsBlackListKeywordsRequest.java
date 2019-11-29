package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetAdsBlackListKeywordsRequest extends Message {
    public static final List<Long> DEFAULT_IDS = Collections.emptyList();
    public static final List<String> DEFAULT_KEYWORDS = Collections.emptyList();
    public static final List<Integer> DEFAULT_STATUSES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Header header;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> ids;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> keywords;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> statuses;

    public GetAdsBlackListKeywordsRequest(Header header2, List<Long> list, List<String> list2, List<Integer> list3) {
        this.header = header2;
        this.ids = immutableCopyOf(list);
        this.keywords = immutableCopyOf(list2);
        this.statuses = immutableCopyOf(list3);
    }

    private GetAdsBlackListKeywordsRequest(Builder builder) {
        this(builder.header, builder.ids, builder.keywords, builder.statuses);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetAdsBlackListKeywordsRequest)) {
            return false;
        }
        GetAdsBlackListKeywordsRequest getAdsBlackListKeywordsRequest = (GetAdsBlackListKeywordsRequest) obj;
        if (!equals((Object) this.header, (Object) getAdsBlackListKeywordsRequest.header) || !equals((List<?>) this.ids, (List<?>) getAdsBlackListKeywordsRequest.ids) || !equals((List<?>) this.keywords, (List<?>) getAdsBlackListKeywordsRequest.keywords) || !equals((List<?>) this.statuses, (List<?>) getAdsBlackListKeywordsRequest.statuses)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Header header2 = this.header;
        int hashCode = (header2 != null ? header2.hashCode() : 0) * 37;
        List<Long> list = this.ids;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<String> list2 = this.keywords;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Integer> list3 = this.statuses;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetAdsBlackListKeywordsRequest> {
        public Header header;
        public List<Long> ids;
        public List<String> keywords;
        public List<Integer> statuses;

        public Builder() {
        }

        public Builder(GetAdsBlackListKeywordsRequest getAdsBlackListKeywordsRequest) {
            super(getAdsBlackListKeywordsRequest);
            if (getAdsBlackListKeywordsRequest != null) {
                this.header = getAdsBlackListKeywordsRequest.header;
                this.ids = GetAdsBlackListKeywordsRequest.copyOf(getAdsBlackListKeywordsRequest.ids);
                this.keywords = GetAdsBlackListKeywordsRequest.copyOf(getAdsBlackListKeywordsRequest.keywords);
                this.statuses = GetAdsBlackListKeywordsRequest.copyOf(getAdsBlackListKeywordsRequest.statuses);
            }
        }

        public Builder header(Header header2) {
            this.header = header2;
            return this;
        }

        public Builder ids(List<Long> list) {
            this.ids = checkForNulls(list);
            return this;
        }

        public Builder keywords(List<String> list) {
            this.keywords = checkForNulls(list);
            return this;
        }

        public Builder statuses(List<Integer> list) {
            this.statuses = checkForNulls(list);
            return this;
        }

        public GetAdsBlackListKeywordsRequest build() {
            return new GetAdsBlackListKeywordsRequest(this);
        }
    }
}
