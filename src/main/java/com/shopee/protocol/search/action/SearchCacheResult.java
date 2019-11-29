package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchCacheResult extends Message {
    public static final List<NamedVariant> DEFAULT_EXTRADATA = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = NamedVariant.class, tag = 2)
    public final List<NamedVariant> ExtraData;
    @ProtoField(tag = 1)
    public final SearchResult SearchResult;

    public SearchCacheResult(SearchResult searchResult, List<NamedVariant> list) {
        this.SearchResult = searchResult;
        this.ExtraData = immutableCopyOf(list);
    }

    private SearchCacheResult(Builder builder) {
        this(builder.SearchResult, builder.ExtraData);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCacheResult)) {
            return false;
        }
        SearchCacheResult searchCacheResult = (SearchCacheResult) obj;
        if (!equals((Object) this.SearchResult, (Object) searchCacheResult.SearchResult) || !equals((List<?>) this.ExtraData, (List<?>) searchCacheResult.ExtraData)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        SearchResult searchResult = this.SearchResult;
        int hashCode = (searchResult != null ? searchResult.hashCode() : 0) * 37;
        List<NamedVariant> list = this.ExtraData;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SearchCacheResult> {
        public List<NamedVariant> ExtraData;
        public SearchResult SearchResult;

        public Builder() {
        }

        public Builder(SearchCacheResult searchCacheResult) {
            super(searchCacheResult);
            if (searchCacheResult != null) {
                this.SearchResult = searchCacheResult.SearchResult;
                this.ExtraData = SearchCacheResult.copyOf(searchCacheResult.ExtraData);
            }
        }

        public Builder SearchResult(SearchResult searchResult) {
            this.SearchResult = searchResult;
            return this;
        }

        public Builder ExtraData(List<NamedVariant> list) {
            this.ExtraData = checkForNulls(list);
            return this;
        }

        public SearchCacheResult build() {
            return new SearchCacheResult(this);
        }
    }
}
