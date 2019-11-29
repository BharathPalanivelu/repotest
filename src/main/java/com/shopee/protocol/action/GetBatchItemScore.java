package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetBatchItemScore extends Message {
    public static final List<SearchItemScore> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = SearchItemScore.class, tag = 2)
    public final List<SearchItemScore> items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetBatchItemScore(String str, List<SearchItemScore> list) {
        this.requestid = str;
        this.items = immutableCopyOf(list);
    }

    private GetBatchItemScore(Builder builder) {
        this(builder.requestid, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetBatchItemScore)) {
            return false;
        }
        GetBatchItemScore getBatchItemScore = (GetBatchItemScore) obj;
        if (!equals((Object) this.requestid, (Object) getBatchItemScore.requestid) || !equals((List<?>) this.items, (List<?>) getBatchItemScore.items)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<SearchItemScore> list = this.items;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetBatchItemScore> {
        public List<SearchItemScore> items;
        public String requestid;

        public Builder() {
        }

        public Builder(GetBatchItemScore getBatchItemScore) {
            super(getBatchItemScore);
            if (getBatchItemScore != null) {
                this.requestid = getBatchItemScore.requestid;
                this.items = GetBatchItemScore.copyOf(getBatchItemScore.items);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder items(List<SearchItemScore> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public GetBatchItemScore build() {
            return new GetBatchItemScore(this);
        }
    }
}
