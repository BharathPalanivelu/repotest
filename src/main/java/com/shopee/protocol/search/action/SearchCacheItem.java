package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchCacheItem extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final List<AlgoEntry> DEFAULT_ALGORITHMS = Collections.emptyList();
    public static final List<CategoryFacet> DEFAULT_CATEGORY_FACET = Collections.emptyList();
    public static final Long DEFAULT_DEFAULTPRICECOUNT = 0L;
    public static final List<ResultItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_JSON_DATA = "";
    public static final String DEFAULT_KEYWORD = "";
    public static final List<Double> DEFAULT_SCORES = Collections.emptyList();
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    public static final List<Integer> DEFAULT_USERIDS = Collections.emptyList();
    public static final List<ResultUser> DEFAULT_USERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(label = Message.Label.REPEATED, messageType = AlgoEntry.class, tag = 10)
    public final List<AlgoEntry> algorithms;
    @ProtoField(label = Message.Label.REPEATED, messageType = CategoryFacet.class, tag = 9)
    public final List<CategoryFacet> category_facet;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long defaultPriceCount;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultItem.class, tag = 1)
    public final List<ResultItem> items;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String json_data;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.DOUBLE)
    public final List<Double> scores;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total_count;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT32)
    public final List<Integer> userids;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultUser.class, tag = 11)
    public final List<ResultUser> users;

    public SearchCacheItem(List<ResultItem> list, List<Double> list2, Integer num, String str, String str2, Long l, List<Integer> list3, String str3, List<CategoryFacet> list4, List<AlgoEntry> list5, List<ResultUser> list6, String str4) {
        this.items = immutableCopyOf(list);
        this.scores = immutableCopyOf(list2);
        this.total_count = num;
        this.algorithm = str;
        this.source = str2;
        this.defaultPriceCount = l;
        this.userids = immutableCopyOf(list3);
        this.keyword = str3;
        this.category_facet = immutableCopyOf(list4);
        this.algorithms = immutableCopyOf(list5);
        this.users = immutableCopyOf(list6);
        this.json_data = str4;
    }

    private SearchCacheItem(Builder builder) {
        this(builder.items, builder.scores, builder.total_count, builder.algorithm, builder.source, builder.defaultPriceCount, builder.userids, builder.keyword, builder.category_facet, builder.algorithms, builder.users, builder.json_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCacheItem)) {
            return false;
        }
        SearchCacheItem searchCacheItem = (SearchCacheItem) obj;
        if (!equals((List<?>) this.items, (List<?>) searchCacheItem.items) || !equals((List<?>) this.scores, (List<?>) searchCacheItem.scores) || !equals((Object) this.total_count, (Object) searchCacheItem.total_count) || !equals((Object) this.algorithm, (Object) searchCacheItem.algorithm) || !equals((Object) this.source, (Object) searchCacheItem.source) || !equals((Object) this.defaultPriceCount, (Object) searchCacheItem.defaultPriceCount) || !equals((List<?>) this.userids, (List<?>) searchCacheItem.userids) || !equals((Object) this.keyword, (Object) searchCacheItem.keyword) || !equals((List<?>) this.category_facet, (List<?>) searchCacheItem.category_facet) || !equals((List<?>) this.algorithms, (List<?>) searchCacheItem.algorithms) || !equals((List<?>) this.users, (List<?>) searchCacheItem.users) || !equals((Object) this.json_data, (Object) searchCacheItem.json_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<ResultItem> list = this.items;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Double> list2 = this.scores;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        Integer num = this.total_count;
        int i3 = 0;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.algorithm;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.source;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.defaultPriceCount;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        List<Integer> list3 = this.userids;
        int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 1)) * 37;
        String str3 = this.keyword;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<CategoryFacet> list4 = this.category_facet;
        int hashCode9 = (hashCode8 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<AlgoEntry> list5 = this.algorithms;
        int hashCode10 = (hashCode9 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<ResultUser> list6 = this.users;
        if (list6 != null) {
            i2 = list6.hashCode();
        }
        int i4 = (hashCode10 + i2) * 37;
        String str4 = this.json_data;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SearchCacheItem> {
        public String algorithm;
        public List<AlgoEntry> algorithms;
        public List<CategoryFacet> category_facet;
        public Long defaultPriceCount;
        public List<ResultItem> items;
        public String json_data;
        public String keyword;
        public List<Double> scores;
        public String source;
        public Integer total_count;
        public List<Integer> userids;
        public List<ResultUser> users;

        public Builder() {
        }

        public Builder(SearchCacheItem searchCacheItem) {
            super(searchCacheItem);
            if (searchCacheItem != null) {
                this.items = SearchCacheItem.copyOf(searchCacheItem.items);
                this.scores = SearchCacheItem.copyOf(searchCacheItem.scores);
                this.total_count = searchCacheItem.total_count;
                this.algorithm = searchCacheItem.algorithm;
                this.source = searchCacheItem.source;
                this.defaultPriceCount = searchCacheItem.defaultPriceCount;
                this.userids = SearchCacheItem.copyOf(searchCacheItem.userids);
                this.keyword = searchCacheItem.keyword;
                this.category_facet = SearchCacheItem.copyOf(searchCacheItem.category_facet);
                this.algorithms = SearchCacheItem.copyOf(searchCacheItem.algorithms);
                this.users = SearchCacheItem.copyOf(searchCacheItem.users);
                this.json_data = searchCacheItem.json_data;
            }
        }

        public Builder items(List<ResultItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder scores(List<Double> list) {
            this.scores = checkForNulls(list);
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder defaultPriceCount(Long l) {
            this.defaultPriceCount = l;
            return this;
        }

        public Builder userids(List<Integer> list) {
            this.userids = checkForNulls(list);
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder category_facet(List<CategoryFacet> list) {
            this.category_facet = checkForNulls(list);
            return this;
        }

        public Builder algorithms(List<AlgoEntry> list) {
            this.algorithms = checkForNulls(list);
            return this;
        }

        public Builder users(List<ResultUser> list) {
            this.users = checkForNulls(list);
            return this;
        }

        public Builder json_data(String str) {
            this.json_data = str;
            return this;
        }

        public SearchCacheItem build() {
            return new SearchCacheItem(this);
        }
    }
}
