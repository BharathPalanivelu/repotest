package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdvertiseKeyword extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_MATCH_TYPE = 0;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer match_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;

    public AdvertiseKeyword(String str, Long l, Integer num, Integer num2, String str2) {
        this.keyword = str;
        this.price = l;
        this.status = num;
        this.match_type = num2;
        this.algorithm = str2;
    }

    private AdvertiseKeyword(Builder builder) {
        this(builder.keyword, builder.price, builder.status, builder.match_type, builder.algorithm);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdvertiseKeyword)) {
            return false;
        }
        AdvertiseKeyword advertiseKeyword = (AdvertiseKeyword) obj;
        if (!equals((Object) this.keyword, (Object) advertiseKeyword.keyword) || !equals((Object) this.price, (Object) advertiseKeyword.price) || !equals((Object) this.status, (Object) advertiseKeyword.status) || !equals((Object) this.match_type, (Object) advertiseKeyword.match_type) || !equals((Object) this.algorithm, (Object) advertiseKeyword.algorithm)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.keyword;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.price;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.match_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.algorithm;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdvertiseKeyword> {
        public String algorithm;
        public String keyword;
        public Integer match_type;
        public Long price;
        public Integer status;

        public Builder() {
        }

        public Builder(AdvertiseKeyword advertiseKeyword) {
            super(advertiseKeyword);
            if (advertiseKeyword != null) {
                this.keyword = advertiseKeyword.keyword;
                this.price = advertiseKeyword.price;
                this.status = advertiseKeyword.status;
                this.match_type = advertiseKeyword.match_type;
                this.algorithm = advertiseKeyword.algorithm;
            }
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder match_type(Integer num) {
            this.match_type = num;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public AdvertiseKeyword build() {
            return new AdvertiseKeyword(this);
        }
    }
}
