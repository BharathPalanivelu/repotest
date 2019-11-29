package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BanAccount extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public BanAccount(String str, Integer num) {
        this.requestid = str;
        this.userid = num;
    }

    private BanAccount(Builder builder) {
        this(builder.requestid, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BanAccount)) {
            return false;
        }
        BanAccount banAccount = (BanAccount) obj;
        if (!equals((Object) this.requestid, (Object) banAccount.requestid) || !equals((Object) this.userid, (Object) banAccount.userid)) {
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
        Integer num = this.userid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BanAccount> {
        public String requestid;
        public Integer userid;

        public Builder() {
        }

        public Builder(BanAccount banAccount) {
            super(banAccount);
            if (banAccount != null) {
                this.requestid = banAccount.requestid;
                this.userid = banAccount.userid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public BanAccount build() {
            return new BanAccount(this);
        }
    }
}
