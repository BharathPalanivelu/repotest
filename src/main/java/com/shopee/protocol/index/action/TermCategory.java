package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TermCategory extends Message {
    public static final List<Integer> DEFAULT_CATEGORIES = Collections.emptyList();
    public static final String DEFAULT_SEARCH_TERM = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> categories;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String search_term;

    public TermCategory(String str, List<Integer> list) {
        this.search_term = str;
        this.categories = immutableCopyOf(list);
    }

    private TermCategory(Builder builder) {
        this(builder.search_term, builder.categories);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TermCategory)) {
            return false;
        }
        TermCategory termCategory = (TermCategory) obj;
        if (!equals((Object) this.search_term, (Object) termCategory.search_term) || !equals((List<?>) this.categories, (List<?>) termCategory.categories)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.search_term;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<Integer> list = this.categories;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<TermCategory> {
        public List<Integer> categories;
        public String search_term;

        public Builder() {
        }

        public Builder(TermCategory termCategory) {
            super(termCategory);
            if (termCategory != null) {
                this.search_term = termCategory.search_term;
                this.categories = TermCategory.copyOf(termCategory.categories);
            }
        }

        public Builder search_term(String str) {
            this.search_term = str;
            return this;
        }

        public Builder categories(List<Integer> list) {
            this.categories = checkForNulls(list);
            return this;
        }

        public TermCategory build() {
            return new TermCategory(this);
        }
    }
}
