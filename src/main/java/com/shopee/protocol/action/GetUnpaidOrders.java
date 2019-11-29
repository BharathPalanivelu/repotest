package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetUnpaidOrders extends Message {
    public static final Long DEFAULT_CURSOR = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long cursor;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    public GetUnpaidOrders(String str, Long l, Integer num, Integer num2, String str2) {
        this.requestid = str;
        this.cursor = l;
        this.limit = num;
        this.type = num2;
        this.token = str2;
    }

    private GetUnpaidOrders(Builder builder) {
        this(builder.requestid, builder.cursor, builder.limit, builder.type, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUnpaidOrders)) {
            return false;
        }
        GetUnpaidOrders getUnpaidOrders = (GetUnpaidOrders) obj;
        if (!equals((Object) this.requestid, (Object) getUnpaidOrders.requestid) || !equals((Object) this.cursor, (Object) getUnpaidOrders.cursor) || !equals((Object) this.limit, (Object) getUnpaidOrders.limit) || !equals((Object) this.type, (Object) getUnpaidOrders.type) || !equals((Object) this.token, (Object) getUnpaidOrders.token)) {
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
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetUnpaidOrders> {
        public Long cursor;
        public Integer limit;
        public String requestid;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(GetUnpaidOrders getUnpaidOrders) {
            super(getUnpaidOrders);
            if (getUnpaidOrders != null) {
                this.requestid = getUnpaidOrders.requestid;
                this.cursor = getUnpaidOrders.cursor;
                this.limit = getUnpaidOrders.limit;
                this.type = getUnpaidOrders.type;
                this.token = getUnpaidOrders.token;
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

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetUnpaidOrders build() {
            return new GetUnpaidOrders(this);
        }
    }
}
