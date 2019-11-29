package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchSetActivityRequest extends Message {
    public static final List<CuratedActivity> DEFAULT_ACTIVITY = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedActivity.class, tag = 2)
    public final List<CuratedActivity> activity;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public BatchSetActivityRequest(RequestHeader requestHeader, List<CuratedActivity> list) {
        this.header = requestHeader;
        this.activity = immutableCopyOf(list);
    }

    private BatchSetActivityRequest(Builder builder) {
        this(builder.header, builder.activity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchSetActivityRequest)) {
            return false;
        }
        BatchSetActivityRequest batchSetActivityRequest = (BatchSetActivityRequest) obj;
        if (!equals((Object) this.header, (Object) batchSetActivityRequest.header) || !equals((List<?>) this.activity, (List<?>) batchSetActivityRequest.activity)) {
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
        List<CuratedActivity> list = this.activity;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BatchSetActivityRequest> {
        public List<CuratedActivity> activity;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(BatchSetActivityRequest batchSetActivityRequest) {
            super(batchSetActivityRequest);
            if (batchSetActivityRequest != null) {
                this.header = batchSetActivityRequest.header;
                this.activity = BatchSetActivityRequest.copyOf(batchSetActivityRequest.activity);
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder activity(List<CuratedActivity> list) {
            this.activity = checkForNulls(list);
            return this;
        }

        public BatchSetActivityRequest build() {
            return new BatchSetActivityRequest(this);
        }
    }
}
