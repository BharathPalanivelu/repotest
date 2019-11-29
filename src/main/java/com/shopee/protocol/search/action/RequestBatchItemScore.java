package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RequestBatchItemScore extends Message {
    public static final List<ItemidWithScore> DEFAULT_ITEMS = Collections.emptyList();
    public static final Boolean DEFAULT_VIEW_COUNT_ONLY = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemidWithScore.class, tag = 2)
    public final List<ItemidWithScore> items;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean view_count_only;

    public RequestBatchItemScore(RequestHeader requestHeader, List<ItemidWithScore> list, Boolean bool) {
        this.header = requestHeader;
        this.items = immutableCopyOf(list);
        this.view_count_only = bool;
    }

    private RequestBatchItemScore(Builder builder) {
        this(builder.header, builder.items, builder.view_count_only);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestBatchItemScore)) {
            return false;
        }
        RequestBatchItemScore requestBatchItemScore = (RequestBatchItemScore) obj;
        if (!equals((Object) this.header, (Object) requestBatchItemScore.header) || !equals((List<?>) this.items, (List<?>) requestBatchItemScore.items) || !equals((Object) this.view_count_only, (Object) requestBatchItemScore.view_count_only)) {
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
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        List<ItemidWithScore> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.view_count_only;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestBatchItemScore> {
        public RequestHeader header;
        public List<ItemidWithScore> items;
        public Boolean view_count_only;

        public Builder() {
        }

        public Builder(RequestBatchItemScore requestBatchItemScore) {
            super(requestBatchItemScore);
            if (requestBatchItemScore != null) {
                this.header = requestBatchItemScore.header;
                this.items = RequestBatchItemScore.copyOf(requestBatchItemScore.items);
                this.view_count_only = requestBatchItemScore.view_count_only;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder items(List<ItemidWithScore> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder view_count_only(Boolean bool) {
            this.view_count_only = bool;
            return this;
        }

        public RequestBatchItemScore build() {
            return new RequestBatchItemScore(this);
        }
    }
}
