package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UserLastSeen extends Message {
    public static final Integer DEFAULT_LAST_LOGIN = 0;
    public static final Integer DEFAULT_LAST_LOGOUT = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer last_login;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer last_logout;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public UserLastSeen(Integer num, Integer num2, Integer num3) {
        this.userid = num;
        this.last_login = num2;
        this.last_logout = num3;
    }

    private UserLastSeen(Builder builder) {
        this(builder.userid, builder.last_login, builder.last_logout);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLastSeen)) {
            return false;
        }
        UserLastSeen userLastSeen = (UserLastSeen) obj;
        if (!equals((Object) this.userid, (Object) userLastSeen.userid) || !equals((Object) this.last_login, (Object) userLastSeen.last_login) || !equals((Object) this.last_logout, (Object) userLastSeen.last_logout)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.last_login;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.last_logout;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserLastSeen> {
        public Integer last_login;
        public Integer last_logout;
        public Integer userid;

        public Builder() {
        }

        public Builder(UserLastSeen userLastSeen) {
            super(userLastSeen);
            if (userLastSeen != null) {
                this.userid = userLastSeen.userid;
                this.last_login = userLastSeen.last_login;
                this.last_logout = userLastSeen.last_logout;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder last_login(Integer num) {
            this.last_login = num;
            return this;
        }

        public Builder last_logout(Integer num) {
            this.last_logout = num;
            return this;
        }

        public UserLastSeen build() {
            return new UserLastSeen(this);
        }
    }
}
