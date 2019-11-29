package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Kick extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public Kick(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.userid = num;
        this.timestamp = num2;
    }

    private Kick(Builder builder) {
        this(builder.requestid, builder.userid, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Kick)) {
            return false;
        }
        Kick kick = (Kick) obj;
        if (!equals((Object) this.requestid, (Object) kick.requestid) || !equals((Object) this.userid, (Object) kick.userid) || !equals((Object) this.timestamp, (Object) kick.timestamp)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.timestamp;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Kick> {
        public String requestid;
        public Integer timestamp;
        public Integer userid;

        public Builder() {
        }

        public Builder(Kick kick) {
            super(kick);
            if (kick != null) {
                this.requestid = kick.requestid;
                this.userid = kick.userid;
                this.timestamp = kick.timestamp;
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

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Kick build() {
            checkRequiredFields();
            return new Kick(this);
        }
    }
}
