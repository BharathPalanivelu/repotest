package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchItemCache extends Message {
    public static final List<ResultItem> DEFAULT_ITEM = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultItem.class, tag = 1)
    public final List<ResultItem> item;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer total_count;

    public SearchItemCache(List<ResultItem> list, Integer num) {
        this.item = immutableCopyOf(list);
        this.total_count = num;
    }

    private SearchItemCache(Builder builder) {
        this(builder.item, builder.total_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchItemCache)) {
            return false;
        }
        SearchItemCache searchItemCache = (SearchItemCache) obj;
        if (!equals((List<?>) this.item, (List<?>) searchItemCache.item) || !equals((Object) this.total_count, (Object) searchItemCache.total_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<ResultItem> list = this.item;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.total_count;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SearchItemCache> {
        public List<ResultItem> item;
        public Integer total_count;

        public Builder() {
        }

        public Builder(SearchItemCache searchItemCache) {
            super(searchItemCache);
            if (searchItemCache != null) {
                this.item = SearchItemCache.copyOf(searchItemCache.item);
                this.total_count = searchItemCache.total_count;
            }
        }

        public Builder item(List<ResultItem> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public SearchItemCache build() {
            return new SearchItemCache(this);
        }
    }
}
