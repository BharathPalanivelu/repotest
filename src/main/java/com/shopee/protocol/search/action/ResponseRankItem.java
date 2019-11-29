package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseRankItem extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final List<ResultItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final List<Double> DEFAULT_SCORES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultItem.class, tag = 2)
    public final List<ResultItem> items;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.DOUBLE)
    public final List<Double> scores;

    public ResponseRankItem(ResponseHeader responseHeader, List<ResultItem> list, List<Double> list2, String str) {
        this.header = responseHeader;
        this.items = immutableCopyOf(list);
        this.scores = immutableCopyOf(list2);
        this.algorithm = str;
    }

    private ResponseRankItem(Builder builder) {
        this(builder.header, builder.items, builder.scores, builder.algorithm);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseRankItem)) {
            return false;
        }
        ResponseRankItem responseRankItem = (ResponseRankItem) obj;
        if (!equals((Object) this.header, (Object) responseRankItem.header) || !equals((List<?>) this.items, (List<?>) responseRankItem.items) || !equals((List<?>) this.scores, (List<?>) responseRankItem.scores) || !equals((Object) this.algorithm, (Object) responseRankItem.algorithm)) {
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
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<ResultItem> list = this.items;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Double> list2 = this.scores;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode2 + i3) * 37;
        String str = this.algorithm;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseRankItem> {
        public String algorithm;
        public ResponseHeader header;
        public List<ResultItem> items;
        public List<Double> scores;

        public Builder() {
        }

        public Builder(ResponseRankItem responseRankItem) {
            super(responseRankItem);
            if (responseRankItem != null) {
                this.header = responseRankItem.header;
                this.items = ResponseRankItem.copyOf(responseRankItem.items);
                this.scores = ResponseRankItem.copyOf(responseRankItem.scores);
                this.algorithm = responseRankItem.algorithm;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder items(List<ResultItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder scores(List<Double> list) {
            this.scores = checkForNulls(list);
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public ResponseRankItem build() {
            return new ResponseRankItem(this);
        }
    }
}
