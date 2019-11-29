package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CheckUserBlocked extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_REVERSE = false;
    public static final String DEFAULT_TOKEN = "";
    public static final List<Integer> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean reverse;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> userid;

    public CheckUserBlocked(String str, List<Integer> list, Boolean bool, String str2) {
        this.requestid = str;
        this.userid = immutableCopyOf(list);
        this.reverse = bool;
        this.token = str2;
    }

    private CheckUserBlocked(Builder builder) {
        this(builder.requestid, builder.userid, builder.reverse, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckUserBlocked)) {
            return false;
        }
        CheckUserBlocked checkUserBlocked = (CheckUserBlocked) obj;
        if (!equals((Object) this.requestid, (Object) checkUserBlocked.requestid) || !equals((List<?>) this.userid, (List<?>) checkUserBlocked.userid) || !equals((Object) this.reverse, (Object) checkUserBlocked.reverse) || !equals((Object) this.token, (Object) checkUserBlocked.token)) {
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
        List<Integer> list = this.userid;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.reverse;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckUserBlocked> {
        public String requestid;
        public Boolean reverse;
        public String token;
        public List<Integer> userid;

        public Builder() {
        }

        public Builder(CheckUserBlocked checkUserBlocked) {
            super(checkUserBlocked);
            if (checkUserBlocked != null) {
                this.requestid = checkUserBlocked.requestid;
                this.userid = CheckUserBlocked.copyOf(checkUserBlocked.userid);
                this.reverse = checkUserBlocked.reverse;
                this.token = checkUserBlocked.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(List<Integer> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public Builder reverse(Boolean bool) {
            this.reverse = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public CheckUserBlocked build() {
            return new CheckUserBlocked(this);
        }
    }
}
