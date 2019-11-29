package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestItemScore extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public RequestItemScore(RequestHeader requestHeader, Long l, Integer num) {
        this.header = requestHeader;
        this.itemid = l;
        this.shopid = num;
    }

    private RequestItemScore(Builder builder) {
        this(builder.header, builder.itemid, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestItemScore)) {
            return false;
        }
        RequestItemScore requestItemScore = (RequestItemScore) obj;
        if (!equals((Object) this.header, (Object) requestItemScore.header) || !equals((Object) this.itemid, (Object) requestItemScore.itemid) || !equals((Object) this.shopid, (Object) requestItemScore.shopid)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestItemScore> {
        public RequestHeader header;
        public Long itemid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(RequestItemScore requestItemScore) {
            super(requestItemScore);
            if (requestItemScore != null) {
                this.header = requestItemScore.header;
                this.itemid = requestItemScore.itemid;
                this.shopid = requestItemScore.shopid;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
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

        public RequestItemScore build() {
            return new RequestItemScore(this);
        }
    }
}
