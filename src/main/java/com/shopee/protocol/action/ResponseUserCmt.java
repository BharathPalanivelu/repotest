package com.shopee.protocol.action;

import com.shopee.protocol.shop.UserCmt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseUserCmt extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final UserCmt comment;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseUserCmt(String str, Integer num, UserCmt userCmt) {
        this.requestid = str;
        this.errcode = num;
        this.comment = userCmt;
    }

    private ResponseUserCmt(Builder builder) {
        this(builder.requestid, builder.errcode, builder.comment);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUserCmt)) {
            return false;
        }
        ResponseUserCmt responseUserCmt = (ResponseUserCmt) obj;
        if (!equals((Object) this.requestid, (Object) responseUserCmt.requestid) || !equals((Object) this.errcode, (Object) responseUserCmt.errcode) || !equals((Object) this.comment, (Object) responseUserCmt.comment)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        UserCmt userCmt = this.comment;
        if (userCmt != null) {
            i2 = userCmt.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseUserCmt> {
        public UserCmt comment;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseUserCmt responseUserCmt) {
            super(responseUserCmt);
            if (responseUserCmt != null) {
                this.requestid = responseUserCmt.requestid;
                this.errcode = responseUserCmt.errcode;
                this.comment = responseUserCmt.comment;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder comment(UserCmt userCmt) {
            this.comment = userCmt;
            return this;
        }

        public ResponseUserCmt build() {
            checkRequiredFields();
            return new ResponseUserCmt(this);
        }
    }
}
