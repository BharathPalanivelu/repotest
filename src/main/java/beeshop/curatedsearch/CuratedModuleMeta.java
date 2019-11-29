package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CuratedModuleMeta extends Message {
    public static final String DEFAULT_DATA = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String data;

    public CuratedModuleMeta(String str) {
        this.data = str;
    }

    private CuratedModuleMeta(Builder builder) {
        this(builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CuratedModuleMeta)) {
            return false;
        }
        return equals((Object) this.data, (Object) ((CuratedModuleMeta) obj).data);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.data;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CuratedModuleMeta> {
        public String data;

        public Builder() {
        }

        public Builder(CuratedModuleMeta curatedModuleMeta) {
            super(curatedModuleMeta);
            if (curatedModuleMeta != null) {
                this.data = curatedModuleMeta.data;
            }
        }

        public Builder data(String str) {
            this.data = str;
            return this;
        }

        public CuratedModuleMeta build() {
            return new CuratedModuleMeta(this);
        }
    }
}
