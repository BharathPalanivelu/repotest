package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Header extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LIMIT = 200;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public Header(String str, String str2, Integer num, Integer num2) {
        this.requestid = str;
        this.country = str2;
        this.limit = num;
        this.offset = num2;
    }

    private Header(Builder builder) {
        this(builder.requestid, builder.country, builder.limit, builder.offset);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (!equals((Object) this.requestid, (Object) header.requestid) || !equals((Object) this.country, (Object) header.country) || !equals((Object) this.limit, (Object) header.limit) || !equals((Object) this.offset, (Object) header.offset)) {
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
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.limit;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Header> {
        public String country;
        public Integer limit;
        public Integer offset;
        public String requestid;

        public Builder() {
        }

        public Builder(Header header) {
            super(header);
            if (header != null) {
                this.requestid = header.requestid;
                this.country = header.country;
                this.limit = header.limit;
                this.offset = header.offset;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Header build() {
            return new Header(this);
        }
    }
}
