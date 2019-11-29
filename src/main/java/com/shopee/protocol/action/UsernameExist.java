package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UsernameExist extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String username;

    public UsernameExist(String str, String str2) {
        this.requestid = str;
        this.username = str2;
    }

    private UsernameExist(Builder builder) {
        this(builder.requestid, builder.username);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UsernameExist)) {
            return false;
        }
        UsernameExist usernameExist = (UsernameExist) obj;
        if (!equals((Object) this.requestid, (Object) usernameExist.requestid) || !equals((Object) this.username, (Object) usernameExist.username)) {
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
        String str2 = this.username;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UsernameExist> {
        public String requestid;
        public String username;

        public Builder() {
        }

        public Builder(UsernameExist usernameExist) {
            super(usernameExist);
            if (usernameExist != null) {
                this.requestid = usernameExist.requestid;
                this.username = usernameExist.username;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public UsernameExist build() {
            return new UsernameExist(this);
        }
    }
}
