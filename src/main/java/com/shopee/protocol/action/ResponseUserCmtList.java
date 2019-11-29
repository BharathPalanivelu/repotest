package com.shopee.protocol.action;

import com.shopee.protocol.shop.UserCmt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseUserCmtList extends Message {
    public static final List<UserCmt> DEFAULT_COMMENT = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = UserCmt.class, tag = 3)
    public final List<UserCmt> comment;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseUserCmtList(String str, Integer num, List<UserCmt> list) {
        this.requestid = str;
        this.errcode = num;
        this.comment = immutableCopyOf(list);
    }

    private ResponseUserCmtList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.comment);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUserCmtList)) {
            return false;
        }
        ResponseUserCmtList responseUserCmtList = (ResponseUserCmtList) obj;
        if (!equals((Object) this.requestid, (Object) responseUserCmtList.requestid) || !equals((Object) this.errcode, (Object) responseUserCmtList.errcode) || !equals((List<?>) this.comment, (List<?>) responseUserCmtList.comment)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<UserCmt> list = this.comment;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseUserCmtList> {
        public List<UserCmt> comment;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseUserCmtList responseUserCmtList) {
            super(responseUserCmtList);
            if (responseUserCmtList != null) {
                this.requestid = responseUserCmtList.requestid;
                this.errcode = responseUserCmtList.errcode;
                this.comment = ResponseUserCmtList.copyOf(responseUserCmtList.comment);
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

        public Builder comment(List<UserCmt> list) {
            this.comment = checkForNulls(list);
            return this;
        }

        public ResponseUserCmtList build() {
            checkRequiredFields();
            return new ResponseUserCmtList(this);
        }
    }
}
