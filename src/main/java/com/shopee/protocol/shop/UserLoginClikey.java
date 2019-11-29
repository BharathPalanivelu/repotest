package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class UserLoginClikey extends Message {
    public static final List<Long> DEFAULT_CLIKEY = Collections.emptyList();
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.UINT64)
    public final List<Long> clikey;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public UserLoginClikey(Integer num, List<Long> list) {
        this.userid = num;
        this.clikey = immutableCopyOf(list);
    }

    private UserLoginClikey(Builder builder) {
        this(builder.userid, builder.clikey);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLoginClikey)) {
            return false;
        }
        UserLoginClikey userLoginClikey = (UserLoginClikey) obj;
        if (!equals((Object) this.userid, (Object) userLoginClikey.userid) || !equals((List<?>) this.clikey, (List<?>) userLoginClikey.clikey)) {
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
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<Long> list = this.clikey;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<UserLoginClikey> {
        public List<Long> clikey;
        public Integer userid;

        public Builder() {
        }

        public Builder(UserLoginClikey userLoginClikey) {
            super(userLoginClikey);
            if (userLoginClikey != null) {
                this.userid = userLoginClikey.userid;
                this.clikey = UserLoginClikey.copyOf(userLoginClikey.clikey);
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder clikey(List<Long> list) {
            this.clikey = checkForNulls(list);
            return this;
        }

        public UserLoginClikey build() {
            return new UserLoginClikey(this);
        }
    }
}
