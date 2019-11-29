package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseBatchItemScore extends Message {
    public static final List<ItemidWithScore> DEFAULT_SCORES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemidWithScore.class, tag = 2)
    public final List<ItemidWithScore> scores;

    public ResponseBatchItemScore(ResponseHeader responseHeader, List<ItemidWithScore> list) {
        this.header = responseHeader;
        this.scores = immutableCopyOf(list);
    }

    private ResponseBatchItemScore(Builder builder) {
        this(builder.header, builder.scores);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseBatchItemScore)) {
            return false;
        }
        ResponseBatchItemScore responseBatchItemScore = (ResponseBatchItemScore) obj;
        if (!equals((Object) this.header, (Object) responseBatchItemScore.header) || !equals((List<?>) this.scores, (List<?>) responseBatchItemScore.scores)) {
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
        List<ItemidWithScore> list = this.scores;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseBatchItemScore> {
        public ResponseHeader header;
        public List<ItemidWithScore> scores;

        public Builder() {
        }

        public Builder(ResponseBatchItemScore responseBatchItemScore) {
            super(responseBatchItemScore);
            if (responseBatchItemScore != null) {
                this.header = responseBatchItemScore.header;
                this.scores = ResponseBatchItemScore.copyOf(responseBatchItemScore.scores);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder scores(List<ItemidWithScore> list) {
            this.scores = checkForNulls(list);
            return this;
        }

        public ResponseBatchItemScore build() {
            return new ResponseBatchItemScore(this);
        }
    }
}
