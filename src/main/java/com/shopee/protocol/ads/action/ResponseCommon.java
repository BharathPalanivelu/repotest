package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCommon extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final Boolean DEFAULT_RESULT = false;
    public static final Long DEFAULT_SHOPID = 0L;
    public static final Long DEFAULT_TOPUPID = 0L;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean result;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long topupid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long userid;

    public ResponseCommon(ResponseHeader responseHeader, Boolean bool, String str, Long l, Long l2, Long l3, Integer num) {
        this.header = responseHeader;
        this.result = bool;
        this.err_message = str;
        this.shopid = l;
        this.userid = l2;
        this.topupid = l3;
        this.errcode = num;
    }

    private ResponseCommon(Builder builder) {
        this(builder.header, builder.result, builder.err_message, builder.shopid, builder.userid, builder.topupid, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCommon)) {
            return false;
        }
        ResponseCommon responseCommon = (ResponseCommon) obj;
        if (!equals((Object) this.header, (Object) responseCommon.header) || !equals((Object) this.result, (Object) responseCommon.result) || !equals((Object) this.err_message, (Object) responseCommon.err_message) || !equals((Object) this.shopid, (Object) responseCommon.shopid) || !equals((Object) this.userid, (Object) responseCommon.userid) || !equals((Object) this.topupid, (Object) responseCommon.topupid) || !equals((Object) this.errcode, (Object) responseCommon.errcode)) {
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
        Boolean bool = this.result;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.err_message;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.shopid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.userid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.topupid;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCommon> {
        public String err_message;
        public Integer errcode;
        public ResponseHeader header;
        public Boolean result;
        public Long shopid;
        public Long topupid;
        public Long userid;

        public Builder() {
        }

        public Builder(ResponseCommon responseCommon) {
            super(responseCommon);
            if (responseCommon != null) {
                this.header = responseCommon.header;
                this.result = responseCommon.result;
                this.err_message = responseCommon.err_message;
                this.shopid = responseCommon.shopid;
                this.userid = responseCommon.userid;
                this.topupid = responseCommon.topupid;
                this.errcode = responseCommon.errcode;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder result(Boolean bool) {
            this.result = bool;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public Builder shopid(Long l) {
            this.shopid = l;
            return this;
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder topupid(Long l) {
            this.topupid = l;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseCommon build() {
            return new ResponseCommon(this);
        }
    }
}
