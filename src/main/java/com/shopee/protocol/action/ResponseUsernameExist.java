package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseUsernameExist extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<String> DEFAULT_USERNAME = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> username;

    public ResponseUsernameExist(String str, Integer num, List<String> list) {
        this.requestid = str;
        this.errcode = num;
        this.username = immutableCopyOf(list);
    }

    private ResponseUsernameExist(Builder builder) {
        this(builder.requestid, builder.errcode, builder.username);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUsernameExist)) {
            return false;
        }
        ResponseUsernameExist responseUsernameExist = (ResponseUsernameExist) obj;
        if (!equals((Object) this.requestid, (Object) responseUsernameExist.requestid) || !equals((Object) this.errcode, (Object) responseUsernameExist.errcode) || !equals((List<?>) this.username, (List<?>) responseUsernameExist.username)) {
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
        List<String> list = this.username;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseUsernameExist> {
        public Integer errcode;
        public String requestid;
        public List<String> username;

        public Builder() {
        }

        public Builder(ResponseUsernameExist responseUsernameExist) {
            super(responseUsernameExist);
            if (responseUsernameExist != null) {
                this.requestid = responseUsernameExist.requestid;
                this.errcode = responseUsernameExist.errcode;
                this.username = ResponseUsernameExist.copyOf(responseUsernameExist.username);
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

        public Builder username(List<String> list) {
            this.username = checkForNulls(list);
            return this;
        }

        public ResponseUsernameExist build() {
            return new ResponseUsernameExist(this);
        }
    }
}
