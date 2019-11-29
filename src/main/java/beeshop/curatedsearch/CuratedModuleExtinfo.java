package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CuratedModuleExtinfo extends Message {
    public static final Integer DEFAULT_MODULE_TYPE = 0;
    public static final List<Integer> DEFAULT_PLATFORM = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer module_type;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> platform;

    public CuratedModuleExtinfo(List<Integer> list, Integer num) {
        this.platform = immutableCopyOf(list);
        this.module_type = num;
    }

    private CuratedModuleExtinfo(Builder builder) {
        this(builder.platform, builder.module_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CuratedModuleExtinfo)) {
            return false;
        }
        CuratedModuleExtinfo curatedModuleExtinfo = (CuratedModuleExtinfo) obj;
        if (!equals((List<?>) this.platform, (List<?>) curatedModuleExtinfo.platform) || !equals((Object) this.module_type, (Object) curatedModuleExtinfo.module_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Integer> list = this.platform;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.module_type;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CuratedModuleExtinfo> {
        public Integer module_type;
        public List<Integer> platform;

        public Builder() {
        }

        public Builder(CuratedModuleExtinfo curatedModuleExtinfo) {
            super(curatedModuleExtinfo);
            if (curatedModuleExtinfo != null) {
                this.platform = CuratedModuleExtinfo.copyOf(curatedModuleExtinfo.platform);
                this.module_type = curatedModuleExtinfo.module_type;
            }
        }

        public Builder platform(List<Integer> list) {
            this.platform = checkForNulls(list);
            return this;
        }

        public Builder module_type(Integer num) {
            this.module_type = num;
            return this;
        }

        public CuratedModuleExtinfo build() {
            return new CuratedModuleExtinfo(this);
        }
    }
}
