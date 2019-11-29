package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LoginRecord extends Message {
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public LoginRecord(Integer num, Integer num2) {
        this.userid = num;
        this.timestamp = num2;
    }

    private LoginRecord(Builder builder) {
        this(builder.userid, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginRecord)) {
            return false;
        }
        LoginRecord loginRecord = (LoginRecord) obj;
        if (!equals((Object) this.userid, (Object) loginRecord.userid) || !equals((Object) this.timestamp, (Object) loginRecord.timestamp)) {
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
        Integer num2 = this.timestamp;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LoginRecord> {
        public Integer timestamp;
        public Integer userid;

        public Builder() {
        }

        public Builder(LoginRecord loginRecord) {
            super(loginRecord);
            if (loginRecord != null) {
                this.userid = loginRecord.userid;
                this.timestamp = loginRecord.timestamp;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public LoginRecord build() {
            return new LoginRecord(this);
        }
    }
}
