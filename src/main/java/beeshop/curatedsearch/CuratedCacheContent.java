package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CuratedCacheContent extends Message {
    public static final List<CuratedLayoutInfo> DEFAULT_LAYOUTS = Collections.emptyList();
    public static final List<CuratedModule> DEFAULT_MODULES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final CuratedActivity activity;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedLayoutInfo.class, tag = 3)
    public final List<CuratedLayoutInfo> layouts;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedModule.class, tag = 1)
    public final List<CuratedModule> modules;

    public CuratedCacheContent(List<CuratedModule> list, CuratedActivity curatedActivity, List<CuratedLayoutInfo> list2) {
        this.modules = immutableCopyOf(list);
        this.activity = curatedActivity;
        this.layouts = immutableCopyOf(list2);
    }

    private CuratedCacheContent(Builder builder) {
        this(builder.modules, builder.activity, builder.layouts);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CuratedCacheContent)) {
            return false;
        }
        CuratedCacheContent curatedCacheContent = (CuratedCacheContent) obj;
        if (!equals((List<?>) this.modules, (List<?>) curatedCacheContent.modules) || !equals((Object) this.activity, (Object) curatedCacheContent.activity) || !equals((List<?>) this.layouts, (List<?>) curatedCacheContent.layouts)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<CuratedModule> list = this.modules;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        CuratedActivity curatedActivity = this.activity;
        int hashCode2 = (hashCode + (curatedActivity != null ? curatedActivity.hashCode() : 0)) * 37;
        List<CuratedLayoutInfo> list2 = this.layouts;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CuratedCacheContent> {
        public CuratedActivity activity;
        public List<CuratedLayoutInfo> layouts;
        public List<CuratedModule> modules;

        public Builder() {
        }

        public Builder(CuratedCacheContent curatedCacheContent) {
            super(curatedCacheContent);
            if (curatedCacheContent != null) {
                this.modules = CuratedCacheContent.copyOf(curatedCacheContent.modules);
                this.activity = curatedCacheContent.activity;
                this.layouts = CuratedCacheContent.copyOf(curatedCacheContent.layouts);
            }
        }

        public Builder modules(List<CuratedModule> list) {
            this.modules = checkForNulls(list);
            return this;
        }

        public Builder activity(CuratedActivity curatedActivity) {
            this.activity = curatedActivity;
            return this;
        }

        public Builder layouts(List<CuratedLayoutInfo> list) {
            this.layouts = checkForNulls(list);
            return this;
        }

        public CuratedCacheContent build() {
            return new CuratedCacheContent(this);
        }
    }
}
