package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchGetItemDetailResponse extends Message {
    public static final List<TargetItemInfo> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = TargetItemInfo.class, tag = 2)
    public final List<TargetItemInfo> items;

    public BatchGetItemDetailResponse(ResponseHeader responseHeader, List<TargetItemInfo> list) {
        this.header = responseHeader;
        this.items = immutableCopyOf(list);
    }

    private BatchGetItemDetailResponse(Builder builder) {
        this(builder.header, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchGetItemDetailResponse)) {
            return false;
        }
        BatchGetItemDetailResponse batchGetItemDetailResponse = (BatchGetItemDetailResponse) obj;
        if (!equals((Object) this.header, (Object) batchGetItemDetailResponse.header) || !equals((List<?>) this.items, (List<?>) batchGetItemDetailResponse.items)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<TargetItemInfo> list = this.items;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BatchGetItemDetailResponse> {
        public ResponseHeader header;
        public List<TargetItemInfo> items;

        public Builder() {
        }

        public Builder(BatchGetItemDetailResponse batchGetItemDetailResponse) {
            super(batchGetItemDetailResponse);
            if (batchGetItemDetailResponse != null) {
                this.header = batchGetItemDetailResponse.header;
                this.items = BatchGetItemDetailResponse.copyOf(batchGetItemDetailResponse.items);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder items(List<TargetItemInfo> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public BatchGetItemDetailResponse build() {
            return new BatchGetItemDetailResponse(this);
        }
    }
}
