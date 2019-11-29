package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCheckoutList extends Message {
    public static final Long DEFAULT_CURSOR = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long cursor;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCheckoutList(String str, Long l, Integer num) {
        this.requestid = str;
        this.cursor = l;
        this.limit = num;
    }

    private GetCheckoutList(Builder builder) {
        this(builder.requestid, builder.cursor, builder.limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCheckoutList)) {
            return false;
        }
        GetCheckoutList getCheckoutList = (GetCheckoutList) obj;
        if (!equals((Object) this.requestid, (Object) getCheckoutList.requestid) || !equals((Object) this.cursor, (Object) getCheckoutList.cursor) || !equals((Object) this.limit, (Object) getCheckoutList.limit)) {
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
        Long l = this.cursor;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.limit;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCheckoutList> {
        public Long cursor;
        public Integer limit;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCheckoutList getCheckoutList) {
            super(getCheckoutList);
            if (getCheckoutList != null) {
                this.requestid = getCheckoutList.requestid;
                this.cursor = getCheckoutList.cursor;
                this.limit = getCheckoutList.limit;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder cursor(Long l) {
            this.cursor = l;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public GetCheckoutList build() {
            return new GetCheckoutList(this);
        }
    }
}
