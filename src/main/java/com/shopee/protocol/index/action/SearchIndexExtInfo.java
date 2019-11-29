package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexExtInfo extends Message {
    public static final IndexSource DEFAULT_SOURCE = IndexSource.UNKNOW;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final IndexSource source;

    public SearchIndexExtInfo(IndexSource indexSource) {
        this.source = indexSource;
    }

    private SearchIndexExtInfo(Builder builder) {
        this(builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexExtInfo)) {
            return false;
        }
        return equals((Object) this.source, (Object) ((SearchIndexExtInfo) obj).source);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            IndexSource indexSource = this.source;
            i = indexSource != null ? indexSource.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<SearchIndexExtInfo> {
        public IndexSource source;

        public Builder() {
        }

        public Builder(SearchIndexExtInfo searchIndexExtInfo) {
            super(searchIndexExtInfo);
            if (searchIndexExtInfo != null) {
                this.source = searchIndexExtInfo.source;
            }
        }

        public Builder source(IndexSource indexSource) {
            this.source = indexSource;
            return this;
        }

        public SearchIndexExtInfo build() {
            return new SearchIndexExtInfo(this);
        }
    }
}
