package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PListGetBoost extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7)
    public final RequestHeader header;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public PListGetBoost(String str, Integer num, Integer num2, String str2, RequestHeader requestHeader) {
        this.requestid = str;
        this.offset = num;
        this.limit = num2;
        this.country = str2;
        this.header = requestHeader;
    }

    private PListGetBoost(Builder builder) {
        this(builder.requestid, builder.offset, builder.limit, builder.country, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListGetBoost)) {
            return false;
        }
        PListGetBoost pListGetBoost = (PListGetBoost) obj;
        if (!equals((Object) this.requestid, (Object) pListGetBoost.requestid) || !equals((Object) this.offset, (Object) pListGetBoost.offset) || !equals((Object) this.limit, (Object) pListGetBoost.limit) || !equals((Object) this.country, (Object) pListGetBoost.country) || !equals((Object) this.header, (Object) pListGetBoost.header)) {
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
        Integer num = this.offset;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListGetBoost> {
        public String country;
        public RequestHeader header;
        public Integer limit;
        public Integer offset;
        public String requestid;

        public Builder() {
        }

        public Builder(PListGetBoost pListGetBoost) {
            super(pListGetBoost);
            if (pListGetBoost != null) {
                this.requestid = pListGetBoost.requestid;
                this.offset = pListGetBoost.offset;
                this.limit = pListGetBoost.limit;
                this.country = pListGetBoost.country;
                this.header = pListGetBoost.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public PListGetBoost build() {
            return new PListGetBoost(this);
        }
    }
}
