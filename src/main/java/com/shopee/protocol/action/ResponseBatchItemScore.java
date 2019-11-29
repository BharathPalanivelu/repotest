package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseBatchItemScore extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<SearchItemScore> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = SearchItemScore.class, tag = 3)
    public final List<SearchItemScore> items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseBatchItemScore(String str, Integer num, List<SearchItemScore> list) {
        this.requestid = str;
        this.errcode = num;
        this.items = immutableCopyOf(list);
    }

    private ResponseBatchItemScore(Builder builder) {
        this(builder.requestid, builder.errcode, builder.items);
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
        if (!equals((Object) this.requestid, (Object) responseBatchItemScore.requestid) || !equals((Object) this.errcode, (Object) responseBatchItemScore.errcode) || !equals((List<?>) this.items, (List<?>) responseBatchItemScore.items)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<SearchItemScore> list = this.items;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseBatchItemScore> {
        public Integer errcode;
        public List<SearchItemScore> items;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseBatchItemScore responseBatchItemScore) {
            super(responseBatchItemScore);
            if (responseBatchItemScore != null) {
                this.requestid = responseBatchItemScore.requestid;
                this.errcode = responseBatchItemScore.errcode;
                this.items = ResponseBatchItemScore.copyOf(responseBatchItemScore.items);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder items(List<SearchItemScore> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public ResponseBatchItemScore build() {
            return new ResponseBatchItemScore(this);
        }
    }
}
