package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseUseridList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> userid;

    public ResponseUseridList(String str, Integer num, List<Integer> list) {
        this.requestid = str;
        this.errcode = num;
        this.userid = immutableCopyOf(list);
    }

    private ResponseUseridList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUseridList)) {
            return false;
        }
        ResponseUseridList responseUseridList = (ResponseUseridList) obj;
        if (!equals((Object) this.requestid, (Object) responseUseridList.requestid) || !equals((Object) this.errcode, (Object) responseUseridList.errcode) || !equals((List<?>) this.userid, (List<?>) responseUseridList.userid)) {
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
        List<Integer> list = this.userid;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseUseridList> {
        public Integer errcode;
        public String requestid;
        public List<Integer> userid;

        public Builder() {
        }

        public Builder(ResponseUseridList responseUseridList) {
            super(responseUseridList);
            if (responseUseridList != null) {
                this.requestid = responseUseridList.requestid;
                this.errcode = responseUseridList.errcode;
                this.userid = ResponseUseridList.copyOf(responseUseridList.userid);
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

        public Builder userid(List<Integer> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public ResponseUseridList build() {
            checkRequiredFields();
            return new ResponseUseridList(this);
        }
    }
}
