package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetShopid extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String username;

    public GetShopid(String str, String str2, Integer num) {
        this.requestid = str;
        this.username = str2;
        this.userid = num;
    }

    private GetShopid(Builder builder) {
        this(builder.requestid, builder.username, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetShopid)) {
            return false;
        }
        GetShopid getShopid = (GetShopid) obj;
        if (!equals((Object) this.requestid, (Object) getShopid.requestid) || !equals((Object) this.username, (Object) getShopid.username) || !equals((Object) this.userid, (Object) getShopid.userid)) {
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
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.userid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetShopid> {
        public String requestid;
        public Integer userid;
        public String username;

        public Builder() {
        }

        public Builder(GetShopid getShopid) {
            super(getShopid);
            if (getShopid != null) {
                this.requestid = getShopid.requestid;
                this.username = getShopid.username;
                this.userid = getShopid.userid;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public GetShopid build() {
            return new GetShopid(this);
        }
    }
}
