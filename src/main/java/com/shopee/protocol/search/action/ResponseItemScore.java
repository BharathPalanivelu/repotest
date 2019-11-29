package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseItemScore extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOLD_SCORE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer sold_score;

    public ResponseItemScore(ResponseHeader responseHeader, Long l, Integer num, Integer num2) {
        this.header = responseHeader;
        this.itemid = l;
        this.shopid = num;
        this.sold_score = num2;
    }

    private ResponseItemScore(Builder builder) {
        this(builder.header, builder.itemid, builder.shopid, builder.sold_score);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseItemScore)) {
            return false;
        }
        ResponseItemScore responseItemScore = (ResponseItemScore) obj;
        if (!equals((Object) this.header, (Object) responseItemScore.header) || !equals((Object) this.itemid, (Object) responseItemScore.itemid) || !equals((Object) this.shopid, (Object) responseItemScore.shopid) || !equals((Object) this.sold_score, (Object) responseItemScore.sold_score)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.sold_score;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseItemScore> {
        public ResponseHeader header;
        public Long itemid;
        public Integer shopid;
        public Integer sold_score;

        public Builder() {
        }

        public Builder(ResponseItemScore responseItemScore) {
            super(responseItemScore);
            if (responseItemScore != null) {
                this.header = responseItemScore.header;
                this.itemid = responseItemScore.itemid;
                this.shopid = responseItemScore.shopid;
                this.sold_score = responseItemScore.sold_score;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder sold_score(Integer num) {
            this.sold_score = num;
            return this;
        }

        public ResponseItemScore build() {
            return new ResponseItemScore(this);
        }
    }
}
