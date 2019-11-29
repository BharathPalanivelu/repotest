package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CuratedLayoutInfo extends Message {
    public static final List<CuratedModule> DEFAULT_MODULES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final CuratedActivity activity;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedModule.class, tag = 1)
    public final List<CuratedModule> modules;

    public CuratedLayoutInfo(List<CuratedModule> list, CuratedActivity curatedActivity) {
        this.modules = immutableCopyOf(list);
        this.activity = curatedActivity;
    }

    private CuratedLayoutInfo(Builder builder) {
        this(builder.modules, builder.activity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CuratedLayoutInfo)) {
            return false;
        }
        CuratedLayoutInfo curatedLayoutInfo = (CuratedLayoutInfo) obj;
        if (!equals((List<?>) this.modules, (List<?>) curatedLayoutInfo.modules) || !equals((Object) this.activity, (Object) curatedLayoutInfo.activity)) {
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
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        CuratedActivity curatedActivity = this.activity;
        int hashCode2 = hashCode + (curatedActivity != null ? curatedActivity.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CuratedLayoutInfo> {
        public CuratedActivity activity;
        public List<CuratedModule> modules;

        public Builder() {
        }

        public Builder(CuratedLayoutInfo curatedLayoutInfo) {
            super(curatedLayoutInfo);
            if (curatedLayoutInfo != null) {
                this.modules = CuratedLayoutInfo.copyOf(curatedLayoutInfo.modules);
                this.activity = curatedLayoutInfo.activity;
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

        public CuratedLayoutInfo build() {
            return new CuratedLayoutInfo(this);
        }
    }
}
