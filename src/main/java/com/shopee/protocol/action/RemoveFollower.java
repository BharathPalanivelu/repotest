package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RemoveFollower extends Message {
    public static final Integer DEFAULT_FOLLOWERID = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer followerid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public RemoveFollower(String str, String str2, Integer num) {
        this.requestid = str;
        this.token = str2;
        this.followerid = num;
    }

    private RemoveFollower(Builder builder) {
        this(builder.requestid, builder.token, builder.followerid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoveFollower)) {
            return false;
        }
        RemoveFollower removeFollower = (RemoveFollower) obj;
        if (!equals((Object) this.requestid, (Object) removeFollower.requestid) || !equals((Object) this.token, (Object) removeFollower.token) || !equals((Object) this.followerid, (Object) removeFollower.followerid)) {
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
        Integer num = this.followerid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RemoveFollower> {
        public Integer followerid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(RemoveFollower removeFollower) {
            super(removeFollower);
            if (removeFollower != null) {
                this.requestid = removeFollower.requestid;
                this.token = removeFollower.token;
                this.followerid = removeFollower.followerid;
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

        public Builder followerid(Integer num) {
            this.followerid = num;
            return this;
        }

        public RemoveFollower build() {
            return new RemoveFollower(this);
        }
    }
}
