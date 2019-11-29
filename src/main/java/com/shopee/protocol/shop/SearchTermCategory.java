package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchTermCategory extends Message {
    public static final List<Integer> DEFAULT_CATEGORY = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> category;

    public SearchTermCategory(List<Integer> list) {
        this.category = immutableCopyOf(list);
    }

    private SearchTermCategory(Builder builder) {
        this(builder.category);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTermCategory)) {
            return false;
        }
        return equals((List<?>) this.category, (List<?>) ((SearchTermCategory) obj).category);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Integer> list = this.category;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchTermCategory> {
        public List<Integer> category;

        public Builder() {
        }

        public Builder(SearchTermCategory searchTermCategory) {
            super(searchTermCategory);
            if (searchTermCategory != null) {
                this.category = SearchTermCategory.copyOf(searchTermCategory.category);
            }
        }

        public Builder category(List<Integer> list) {
            this.category = checkForNulls(list);
            return this;
        }

        public SearchTermCategory build() {
            return new SearchTermCategory(this);
        }
    }
}
