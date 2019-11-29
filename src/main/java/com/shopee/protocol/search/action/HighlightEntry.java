package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class HighlightEntry extends Message {
    public static final String DEFAULT_FIELDNAME = "";
    public static final List<String> DEFAULT_HIGHLIGHTS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String FieldName;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> Highlights;

    public HighlightEntry(String str, List<String> list) {
        this.FieldName = str;
        this.Highlights = immutableCopyOf(list);
    }

    private HighlightEntry(Builder builder) {
        this(builder.FieldName, builder.Highlights);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HighlightEntry)) {
            return false;
        }
        HighlightEntry highlightEntry = (HighlightEntry) obj;
        if (!equals((Object) this.FieldName, (Object) highlightEntry.FieldName) || !equals((List<?>) this.Highlights, (List<?>) highlightEntry.Highlights)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.FieldName;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<String> list = this.Highlights;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<HighlightEntry> {
        public String FieldName;
        public List<String> Highlights;

        public Builder() {
        }

        public Builder(HighlightEntry highlightEntry) {
            super(highlightEntry);
            if (highlightEntry != null) {
                this.FieldName = highlightEntry.FieldName;
                this.Highlights = HighlightEntry.copyOf(highlightEntry.Highlights);
            }
        }

        public Builder FieldName(String str) {
            this.FieldName = str;
            return this;
        }

        public Builder Highlights(List<String> list) {
            this.Highlights = checkForNulls(list);
            return this;
        }

        public HighlightEntry build() {
            return new HighlightEntry(this);
        }
    }
}
