package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchSetModuleRequest extends Message {
    public static final List<CuratedModule> DEFAULT_MODULES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedModule.class, tag = 2)
    public final List<CuratedModule> modules;

    public BatchSetModuleRequest(RequestHeader requestHeader, List<CuratedModule> list) {
        this.header = requestHeader;
        this.modules = immutableCopyOf(list);
    }

    private BatchSetModuleRequest(Builder builder) {
        this(builder.header, builder.modules);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchSetModuleRequest)) {
            return false;
        }
        BatchSetModuleRequest batchSetModuleRequest = (BatchSetModuleRequest) obj;
        if (!equals((Object) this.header, (Object) batchSetModuleRequest.header) || !equals((List<?>) this.modules, (List<?>) batchSetModuleRequest.modules)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        List<CuratedModule> list = this.modules;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BatchSetModuleRequest> {
        public RequestHeader header;
        public List<CuratedModule> modules;

        public Builder() {
        }

        public Builder(BatchSetModuleRequest batchSetModuleRequest) {
            super(batchSetModuleRequest);
            if (batchSetModuleRequest != null) {
                this.header = batchSetModuleRequest.header;
                this.modules = BatchSetModuleRequest.copyOf(batchSetModuleRequest.modules);
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder modules(List<CuratedModule> list) {
            this.modules = checkForNulls(list);
            return this;
        }

        public BatchSetModuleRequest build() {
            return new BatchSetModuleRequest(this);
        }
    }
}
