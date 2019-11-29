package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseBlockUserList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<BlockedUser> DEFAULT_USER = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = BlockedUser.class, tag = 3)
    public final List<BlockedUser> user;

    public ResponseBlockUserList(String str, Integer num, List<BlockedUser> list) {
        this.requestid = str;
        this.errcode = num;
        this.user = immutableCopyOf(list);
    }

    private ResponseBlockUserList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.user);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseBlockUserList)) {
            return false;
        }
        ResponseBlockUserList responseBlockUserList = (ResponseBlockUserList) obj;
        if (!equals((Object) this.requestid, (Object) responseBlockUserList.requestid) || !equals((Object) this.errcode, (Object) responseBlockUserList.errcode) || !equals((List<?>) this.user, (List<?>) responseBlockUserList.user)) {
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
        List<BlockedUser> list = this.user;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseBlockUserList> {
        public Integer errcode;
        public String requestid;
        public List<BlockedUser> user;

        public Builder() {
        }

        public Builder(ResponseBlockUserList responseBlockUserList) {
            super(responseBlockUserList);
            if (responseBlockUserList != null) {
                this.requestid = responseBlockUserList.requestid;
                this.errcode = responseBlockUserList.errcode;
                this.user = ResponseBlockUserList.copyOf(responseBlockUserList.user);
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

        public Builder user(List<BlockedUser> list) {
            this.user = checkForNulls(list);
            return this;
        }

        public ResponseBlockUserList build() {
            checkRequiredFields();
            return new ResponseBlockUserList(this);
        }
    }
}
