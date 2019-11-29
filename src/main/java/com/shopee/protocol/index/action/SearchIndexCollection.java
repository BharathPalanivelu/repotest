package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Collection;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexCollection extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Collection collection;

    public SearchIndexCollection(Collection collection2) {
        this.collection = collection2;
    }

    private SearchIndexCollection(Builder builder) {
        this(builder.collection);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexCollection)) {
            return false;
        }
        return equals((Object) this.collection, (Object) ((SearchIndexCollection) obj).collection);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Collection collection2 = this.collection;
            i = collection2 != null ? collection2.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchIndexCollection> {
        public Collection collection;

        public Builder() {
        }

        public Builder(SearchIndexCollection searchIndexCollection) {
            super(searchIndexCollection);
            if (searchIndexCollection != null) {
                this.collection = searchIndexCollection.collection;
            }
        }

        public Builder collection(Collection collection2) {
            this.collection = collection2;
            return this;
        }

        public SearchIndexCollection build() {
            return new SearchIndexCollection(this);
        }
    }
}
