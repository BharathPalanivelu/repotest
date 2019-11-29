package com.shopee.protocol.index.action;

import beeshop.curatedsearch.CuratedActivity;
import beeshop.curatedsearch.CuratedModule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexCuratedModule extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final CuratedActivity activity;
    @ProtoField(tag = 2)
    public final CuratedModule module;

    public SearchIndexCuratedModule(CuratedActivity curatedActivity, CuratedModule curatedModule) {
        this.activity = curatedActivity;
        this.module = curatedModule;
    }

    private SearchIndexCuratedModule(Builder builder) {
        this(builder.activity, builder.module);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexCuratedModule)) {
            return false;
        }
        SearchIndexCuratedModule searchIndexCuratedModule = (SearchIndexCuratedModule) obj;
        if (!equals((Object) this.activity, (Object) searchIndexCuratedModule.activity) || !equals((Object) this.module, (Object) searchIndexCuratedModule.module)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        CuratedActivity curatedActivity = this.activity;
        int i2 = 0;
        int hashCode = (curatedActivity != null ? curatedActivity.hashCode() : 0) * 37;
        CuratedModule curatedModule = this.module;
        if (curatedModule != null) {
            i2 = curatedModule.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexCuratedModule> {
        public CuratedActivity activity;
        public CuratedModule module;

        public Builder() {
        }

        public Builder(SearchIndexCuratedModule searchIndexCuratedModule) {
            super(searchIndexCuratedModule);
            if (searchIndexCuratedModule != null) {
                this.activity = searchIndexCuratedModule.activity;
                this.module = searchIndexCuratedModule.module;
            }
        }

        public Builder activity(CuratedActivity curatedActivity) {
            this.activity = curatedActivity;
            return this;
        }

        public Builder module(CuratedModule curatedModule) {
            this.module = curatedModule;
            return this;
        }

        public SearchIndexCuratedModule build() {
            return new SearchIndexCuratedModule(this);
        }
    }
}
