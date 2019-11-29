package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseRecUsers extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<RecUser> DEFAULT_USERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = RecUser.class, tag = 3)
    public final List<RecUser> users;

    public ResponseRecUsers(String str, Integer num, List<RecUser> list) {
        this.requestid = str;
        this.errcode = num;
        this.users = immutableCopyOf(list);
    }

    private ResponseRecUsers(Builder builder) {
        this(builder.requestid, builder.errcode, builder.users);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseRecUsers)) {
            return false;
        }
        ResponseRecUsers responseRecUsers = (ResponseRecUsers) obj;
        if (!equals((Object) this.requestid, (Object) responseRecUsers.requestid) || !equals((Object) this.errcode, (Object) responseRecUsers.errcode) || !equals((List<?>) this.users, (List<?>) responseRecUsers.users)) {
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
        List<RecUser> list = this.users;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseRecUsers> {
        public Integer errcode;
        public String requestid;
        public List<RecUser> users;

        public Builder() {
        }

        public Builder(ResponseRecUsers responseRecUsers) {
            super(responseRecUsers);
            if (responseRecUsers != null) {
                this.requestid = responseRecUsers.requestid;
                this.errcode = responseRecUsers.errcode;
                this.users = ResponseRecUsers.copyOf(responseRecUsers.users);
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

        public Builder users(List<RecUser> list) {
            this.users = checkForNulls(list);
            return this;
        }

        public ResponseRecUsers build() {
            checkRequiredFields();
            return new ResponseRecUsers(this);
        }
    }
}
