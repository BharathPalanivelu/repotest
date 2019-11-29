package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchGetItemDetailRequest extends Message {
    public static final List<TargetItemId> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = TargetItemId.class, tag = 2)
    public final List<TargetItemId> items;

    public BatchGetItemDetailRequest(RequestHeader requestHeader, List<TargetItemId> list) {
        this.header = requestHeader;
        this.items = immutableCopyOf(list);
    }

    private BatchGetItemDetailRequest(Builder builder) {
        this(builder.header, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchGetItemDetailRequest)) {
            return false;
        }
        BatchGetItemDetailRequest batchGetItemDetailRequest = (BatchGetItemDetailRequest) obj;
        if (!equals((Object) this.header, (Object) batchGetItemDetailRequest.header) || !equals((List<?>) this.items, (List<?>) batchGetItemDetailRequest.items)) {
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
        List<TargetItemId> list = this.items;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BatchGetItemDetailRequest> {
        public RequestHeader header;
        public List<TargetItemId> items;

        public Builder() {
        }

        public Builder(BatchGetItemDetailRequest batchGetItemDetailRequest) {
            super(batchGetItemDetailRequest);
            if (batchGetItemDetailRequest != null) {
                this.header = batchGetItemDetailRequest.header;
                this.items = BatchGetItemDetailRequest.copyOf(batchGetItemDetailRequest.items);
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder items(List<TargetItemId> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public BatchGetItemDetailRequest build() {
            return new BatchGetItemDetailRequest(this);
        }
    }
}
