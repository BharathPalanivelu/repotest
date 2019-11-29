package com.shopee.protocol.index.action;

import beeshop.curatedsearch.CuratedActivity;
import beeshop.curatedsearch.CuratedModule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexCuratedActivity extends Message {
    public static final List<CuratedModule> DEFAULT_MODULES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final CuratedActivity activity;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedModule.class, tag = 2)
    public final List<CuratedModule> modules;

    public SearchIndexCuratedActivity(CuratedActivity curatedActivity, List<CuratedModule> list) {
        this.activity = curatedActivity;
        this.modules = immutableCopyOf(list);
    }

    private SearchIndexCuratedActivity(Builder builder) {
        this(builder.activity, builder.modules);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexCuratedActivity)) {
            return false;
        }
        SearchIndexCuratedActivity searchIndexCuratedActivity = (SearchIndexCuratedActivity) obj;
        if (!equals((Object) this.activity, (Object) searchIndexCuratedActivity.activity) || !equals((List<?>) this.modules, (List<?>) searchIndexCuratedActivity.modules)) {
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
        int hashCode = (curatedActivity != null ? curatedActivity.hashCode() : 0) * 37;
        List<CuratedModule> list = this.modules;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SearchIndexCuratedActivity> {
        public CuratedActivity activity;
        public List<CuratedModule> modules;

        public Builder() {
        }

        public Builder(SearchIndexCuratedActivity searchIndexCuratedActivity) {
            super(searchIndexCuratedActivity);
            if (searchIndexCuratedActivity != null) {
                this.activity = searchIndexCuratedActivity.activity;
                this.modules = SearchIndexCuratedActivity.copyOf(searchIndexCuratedActivity.modules);
            }
        }

        public Builder activity(CuratedActivity curatedActivity) {
            this.activity = curatedActivity;
            return this;
        }

        public Builder modules(List<CuratedModule> list) {
            this.modules = checkForNulls(list);
            return this;
        }

        public SearchIndexCuratedActivity build() {
            return new SearchIndexCuratedActivity(this);
        }
    }
}
