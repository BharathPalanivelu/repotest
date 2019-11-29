package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RequestRankItem extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final List<ResultItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_KEYWORD = "";
    public static final List<Integer> DEFAULT_MATCHLEVELS = Collections.emptyList();
    public static final List<Double> DEFAULT_SCORES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 8)
    public final SearchCondition condition;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultItem.class, tag = 3)
    public final List<ResultItem> items;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> matchLevels;
    @ProtoField(tag = 9)
    public final RankParam rankparam;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.DOUBLE)
    public final List<Double> scores;

    public RequestRankItem(RequestHeader requestHeader, String str, List<ResultItem> list, List<Integer> list2, List<Double> list3, String str2, String str3, SearchCondition searchCondition, RankParam rankParam) {
        this.header = requestHeader;
        this.keyword = str;
        this.items = immutableCopyOf(list);
        this.matchLevels = immutableCopyOf(list2);
        this.scores = immutableCopyOf(list3);
        this.algorithm = str2;
        this.country = str3;
        this.condition = searchCondition;
        this.rankparam = rankParam;
    }

    private RequestRankItem(Builder builder) {
        this(builder.header, builder.keyword, builder.items, builder.matchLevels, builder.scores, builder.algorithm, builder.country, builder.condition, builder.rankparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestRankItem)) {
            return false;
        }
        RequestRankItem requestRankItem = (RequestRankItem) obj;
        if (!equals((Object) this.header, (Object) requestRankItem.header) || !equals((Object) this.keyword, (Object) requestRankItem.keyword) || !equals((List<?>) this.items, (List<?>) requestRankItem.items) || !equals((List<?>) this.matchLevels, (List<?>) requestRankItem.matchLevels) || !equals((List<?>) this.scores, (List<?>) requestRankItem.scores) || !equals((Object) this.algorithm, (Object) requestRankItem.algorithm) || !equals((Object) this.country, (Object) requestRankItem.country) || !equals((Object) this.condition, (Object) requestRankItem.condition) || !equals((Object) this.rankparam, (Object) requestRankItem.rankparam)) {
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
        List<ResultItem> list = this.items;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.matchLevels;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Double> list3 = this.scores;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i4 = (hashCode4 + i3) * 37;
        String str2 = this.algorithm;
        int hashCode5 = (i4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        SearchCondition searchCondition = this.condition;
        int hashCode7 = (hashCode6 + (searchCondition != null ? searchCondition.hashCode() : 0)) * 37;
        RankParam rankParam = this.rankparam;
        if (rankParam != null) {
            i2 = rankParam.hashCode();
        }
        int i5 = hashCode7 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RequestRankItem> {
        public String algorithm;
        public SearchCondition condition;
        public String country;
        public RequestHeader header;
        public List<ResultItem> items;
        public String keyword;
        public List<Integer> matchLevels;
        public RankParam rankparam;
        public List<Double> scores;

        public Builder() {
        }

        public Builder(RequestRankItem requestRankItem) {
            super(requestRankItem);
            if (requestRankItem != null) {
                this.header = requestRankItem.header;
                this.keyword = requestRankItem.keyword;
                this.items = RequestRankItem.copyOf(requestRankItem.items);
                this.matchLevels = RequestRankItem.copyOf(requestRankItem.matchLevels);
                this.scores = RequestRankItem.copyOf(requestRankItem.scores);
                this.algorithm = requestRankItem.algorithm;
                this.country = requestRankItem.country;
                this.condition = requestRankItem.condition;
                this.rankparam = requestRankItem.rankparam;
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

        public Builder items(List<ResultItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder matchLevels(List<Integer> list) {
            this.matchLevels = checkForNulls(list);
            return this;
        }

        public Builder scores(List<Double> list) {
            this.scores = checkForNulls(list);
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder condition(SearchCondition searchCondition) {
            this.condition = searchCondition;
            return this;
        }

        public Builder rankparam(RankParam rankParam) {
            this.rankparam = rankParam;
            return this;
        }

        public RequestRankItem build() {
            return new RequestRankItem(this);
        }
    }
}
