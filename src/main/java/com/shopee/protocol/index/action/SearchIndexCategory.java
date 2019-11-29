package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Category;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexCategory extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Category category;

    public SearchIndexCategory(Category category2) {
        this.category = category2;
    }

    private SearchIndexCategory(Builder builder) {
        this(builder.category);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexCategory)) {
            return false;
        }
        return equals((Object) this.category, (Object) ((SearchIndexCategory) obj).category);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Category category2 = this.category;
            i = category2 != null ? category2.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchIndexCategory> {
        public Category category;

        public Builder() {
        }

        public Builder(SearchIndexCategory searchIndexCategory) {
            super(searchIndexCategory);
            if (searchIndexCategory != null) {
                this.category = searchIndexCategory.category;
            }
        }

        public Builder category(Category category2) {
            this.category = category2;
            return this;
        }

        public SearchIndexCategory build() {
            return new SearchIndexCategory(this);
        }
    }
}
