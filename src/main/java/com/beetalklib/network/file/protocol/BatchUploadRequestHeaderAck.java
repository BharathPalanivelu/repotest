package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BatchUploadRequestHeaderAck extends Message {
    public static final Boolean DEFAULT_EXISTS = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.BOOL)
    public final Boolean Exists;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String RequestId;

    public BatchUploadRequestHeaderAck(String str, Boolean bool) {
        this.RequestId = str;
        this.Exists = bool;
    }

    private BatchUploadRequestHeaderAck(Builder builder) {
        this(builder.RequestId, builder.Exists);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchUploadRequestHeaderAck)) {
            return false;
        }
        BatchUploadRequestHeaderAck batchUploadRequestHeaderAck = (BatchUploadRequestHeaderAck) obj;
        if (!equals((Object) this.RequestId, (Object) batchUploadRequestHeaderAck.RequestId) || !equals((Object) this.Exists, (Object) batchUploadRequestHeaderAck.Exists)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.RequestId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Boolean bool = this.Exists;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BatchUploadRequestHeaderAck> {
        public Boolean Exists;
        public String RequestId;

        public Builder() {
        }

        public Builder(BatchUploadRequestHeaderAck batchUploadRequestHeaderAck) {
            super(batchUploadRequestHeaderAck);
            if (batchUploadRequestHeaderAck != null) {
                this.RequestId = batchUploadRequestHeaderAck.RequestId;
                this.Exists = batchUploadRequestHeaderAck.Exists;
            }
        }

        public Builder RequestId(String str) {
            this.RequestId = str;
            return this;
        }

        public Builder Exists(Boolean bool) {
            this.Exists = bool;
            return this;
        }

        public BatchUploadRequestHeaderAck build() {
            checkRequiredFields();
            return new BatchUploadRequestHeaderAck(this);
        }
    }
}
