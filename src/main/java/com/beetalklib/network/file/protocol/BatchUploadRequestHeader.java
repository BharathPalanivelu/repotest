package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BatchUploadRequestHeader extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TOTALBLOCK = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String RequestId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String Token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer TotalBlock;

    public BatchUploadRequestHeader(String str, String str2, Integer num) {
        this.Token = str;
        this.RequestId = str2;
        this.TotalBlock = num;
    }

    private BatchUploadRequestHeader(Builder builder) {
        this(builder.Token, builder.RequestId, builder.TotalBlock);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchUploadRequestHeader)) {
            return false;
        }
        BatchUploadRequestHeader batchUploadRequestHeader = (BatchUploadRequestHeader) obj;
        if (!equals((Object) this.Token, (Object) batchUploadRequestHeader.Token) || !equals((Object) this.RequestId, (Object) batchUploadRequestHeader.RequestId) || !equals((Object) this.TotalBlock, (Object) batchUploadRequestHeader.TotalBlock)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.Token;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.RequestId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.TotalBlock;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BatchUploadRequestHeader> {
        public String RequestId;
        public String Token;
        public Integer TotalBlock;

        public Builder() {
        }

        public Builder(BatchUploadRequestHeader batchUploadRequestHeader) {
            super(batchUploadRequestHeader);
            if (batchUploadRequestHeader != null) {
                this.Token = batchUploadRequestHeader.Token;
                this.RequestId = batchUploadRequestHeader.RequestId;
                this.TotalBlock = batchUploadRequestHeader.TotalBlock;
            }
        }

        public Builder Token(String str) {
            this.Token = str;
            return this;
        }

        public Builder RequestId(String str) {
            this.RequestId = str;
            return this;
        }

        public Builder TotalBlock(Integer num) {
            this.TotalBlock = num;
            return this;
        }

        public BatchUploadRequestHeader build() {
            checkRequiredFields();
            return new BatchUploadRequestHeader(this);
        }
    }
}
