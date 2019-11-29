package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FollowShop extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public FollowShop(String str, String str2, Integer num) {
        this.requestid = str;
        this.token = str2;
        this.shopid = num;
    }

    private FollowShop(Builder builder) {
        this(builder.requestid, builder.token, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FollowShop)) {
            return false;
        }
        FollowShop followShop = (FollowShop) obj;
        if (!equals((Object) this.requestid, (Object) followShop.requestid) || !equals((Object) this.token, (Object) followShop.token) || !equals((Object) this.shopid, (Object) followShop.shopid)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FollowShop> {
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(FollowShop followShop) {
            super(followShop);
            if (followShop != null) {
                this.requestid = followShop.requestid;
                this.token = followShop.token;
                this.shopid = followShop.shopid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public FollowShop build() {
            checkRequiredFields();
            return new FollowShop(this);
        }
    }
}
