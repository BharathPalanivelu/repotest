package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseUserLastSeen extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<UserLastSeen> DEFAULT_USER = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = UserLastSeen.class, tag = 3)
    public final List<UserLastSeen> user;

    public ResponseUserLastSeen(String str, Integer num, List<UserLastSeen> list) {
        this.requestid = str;
        this.errcode = num;
        this.user = immutableCopyOf(list);
    }

    private ResponseUserLastSeen(Builder builder) {
        this(builder.requestid, builder.errcode, builder.user);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUserLastSeen)) {
            return false;
        }
        ResponseUserLastSeen responseUserLastSeen = (ResponseUserLastSeen) obj;
        if (!equals((Object) this.requestid, (Object) responseUserLastSeen.requestid) || !equals((Object) this.errcode, (Object) responseUserLastSeen.errcode) || !equals((List<?>) this.user, (List<?>) responseUserLastSeen.user)) {
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
        List<UserLastSeen> list = this.user;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseUserLastSeen> {
        public Integer errcode;
        public String requestid;
        public List<UserLastSeen> user;

        public Builder() {
        }

        public Builder(ResponseUserLastSeen responseUserLastSeen) {
            super(responseUserLastSeen);
            if (responseUserLastSeen != null) {
                this.requestid = responseUserLastSeen.requestid;
                this.errcode = responseUserLastSeen.errcode;
                this.user = ResponseUserLastSeen.copyOf(responseUserLastSeen.user);
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

        public Builder user(List<UserLastSeen> list) {
            this.user = checkForNulls(list);
            return this;
        }

        public ResponseUserLastSeen build() {
            checkRequiredFields();
            return new ResponseUserLastSeen(this);
        }
    }
}
