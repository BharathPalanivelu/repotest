package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PListGetWeight extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public PListGetWeight(String str, Integer num, String str2, RequestHeader requestHeader) {
        this.requestid = str;
        this.catid = num;
        this.country = str2;
        this.header = requestHeader;
    }

    private PListGetWeight(Builder builder) {
        this(builder.requestid, builder.catid, builder.country, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListGetWeight)) {
            return false;
        }
        PListGetWeight pListGetWeight = (PListGetWeight) obj;
        if (!equals((Object) this.requestid, (Object) pListGetWeight.requestid) || !equals((Object) this.catid, (Object) pListGetWeight.catid) || !equals((Object) this.country, (Object) pListGetWeight.country) || !equals((Object) this.header, (Object) pListGetWeight.header)) {
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
        Integer num = this.catid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListGetWeight> {
        public Integer catid;
        public String country;
        public RequestHeader header;
        public String requestid;

        public Builder() {
        }

        public Builder(PListGetWeight pListGetWeight) {
            super(pListGetWeight);
            if (pListGetWeight != null) {
                this.requestid = pListGetWeight.requestid;
                this.catid = pListGetWeight.catid;
                this.country = pListGetWeight.country;
                this.header = pListGetWeight.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
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

        public PListGetWeight build() {
            return new PListGetWeight(this);
        }
    }
}
