package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchSetModuleResponse extends Message {
    public static final ErrCode DEFAULT_CODE = ErrCode.Success;
    public static final List<CuratedModule> DEFAULT_MODULES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ErrCode code;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedModule.class, tag = 2)
    public final List<CuratedModule> modules;

    public BatchSetModuleResponse(ErrCode errCode, List<CuratedModule> list) {
        this.code = errCode;
        this.modules = immutableCopyOf(list);
    }

    private BatchSetModuleResponse(Builder builder) {
        this(builder.code, builder.modules);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchSetModuleResponse)) {
            return false;
        }
        BatchSetModuleResponse batchSetModuleResponse = (BatchSetModuleResponse) obj;
        if (!equals((Object) this.code, (Object) batchSetModuleResponse.code) || !equals((List<?>) this.modules, (List<?>) batchSetModuleResponse.modules)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ErrCode errCode = this.code;
        int hashCode = (errCode != null ? errCode.hashCode() : 0) * 37;
        List<CuratedModule> list = this.modules;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BatchSetModuleResponse> {
        public ErrCode code;
        public List<CuratedModule> modules;

        public Builder() {
        }

        public Builder(BatchSetModuleResponse batchSetModuleResponse) {
            super(batchSetModuleResponse);
            if (batchSetModuleResponse != null) {
                this.code = batchSetModuleResponse.code;
                this.modules = BatchSetModuleResponse.copyOf(batchSetModuleResponse.modules);
            }
        }

        public Builder code(ErrCode errCode) {
            this.code = errCode;
            return this;
        }

        public Builder modules(List<CuratedModule> list) {
            this.modules = checkForNulls(list);
            return this;
        }

        public BatchSetModuleResponse build() {
            return new BatchSetModuleResponse(this);
        }
    }
}
