package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchFacetCache extends Message {
    public static final List<CategoryFacet> DEFAULT_CATEGORY_FACET = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CategoryFacet.class, tag = 1)
    public final List<CategoryFacet> category_facet;

    public SearchFacetCache(List<CategoryFacet> list) {
        this.category_facet = immutableCopyOf(list);
    }

    private SearchFacetCache(Builder builder) {
        this(builder.category_facet);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchFacetCache)) {
            return false;
        }
        return equals((List<?>) this.category_facet, (List<?>) ((SearchFacetCache) obj).category_facet);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<CategoryFacet> list = this.category_facet;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchFacetCache> {
        public List<CategoryFacet> category_facet;

        public Builder() {
        }

        public Builder(SearchFacetCache searchFacetCache) {
            super(searchFacetCache);
            if (searchFacetCache != null) {
                this.category_facet = SearchFacetCache.copyOf(searchFacetCache.category_facet);
            }
        }

        public Builder category_facet(List<CategoryFacet> list) {
            this.category_facet = checkForNulls(list);
            return this;
        }

        public SearchFacetCache build() {
            return new SearchFacetCache(this);
        }
    }
}
