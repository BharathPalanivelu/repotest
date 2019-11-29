package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetModelsForAttr extends Message {
    public static final Integer DEFAULT_ATTRID = 0;
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer attrid;
    @ProtoField(tag = 2)
    public final RequestHeader header;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetModelsForAttr(String str, RequestHeader requestHeader, Integer num, String str2) {
        this.requestid = str;
        this.header = requestHeader;
        this.attrid = num;
        this.operator = str2;
    }

    private GetModelsForAttr(Builder builder) {
        this(builder.requestid, builder.header, builder.attrid, builder.operator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetModelsForAttr)) {
            return false;
        }
        GetModelsForAttr getModelsForAttr = (GetModelsForAttr) obj;
        if (!equals((Object) this.requestid, (Object) getModelsForAttr.requestid) || !equals((Object) this.header, (Object) getModelsForAttr.header) || !equals((Object) this.attrid, (Object) getModelsForAttr.attrid) || !equals((Object) this.operator, (Object) getModelsForAttr.operator)) {
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
        RequestHeader requestHeader = this.header;
        int hashCode2 = (hashCode + (requestHeader != null ? requestHeader.hashCode() : 0)) * 37;
        Integer num = this.attrid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.operator;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetModelsForAttr> {
        public Integer attrid;
        public RequestHeader header;
        public String operator;
        public String requestid;

        public Builder() {
        }

        public Builder(GetModelsForAttr getModelsForAttr) {
            super(getModelsForAttr);
            if (getModelsForAttr != null) {
                this.requestid = getModelsForAttr.requestid;
                this.header = getModelsForAttr.header;
                this.attrid = getModelsForAttr.attrid;
                this.operator = getModelsForAttr.operator;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder attrid(Integer num) {
            this.attrid = num;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public GetModelsForAttr build() {
            return new GetModelsForAttr(this);
        }
    }
}
