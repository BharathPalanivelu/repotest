package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Signature extends Message {
    public static final String DEFAULT_PID = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Long DEFAULT_USERID = 0L;
    public static final String DEFAULT_UUID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String pid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long userid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String uuid;

    public Signature(String str, String str2, Long l, Long l2) {
        this.pid = str;
        this.uuid = str2;
        this.userid = l;
        this.timestamp = l2;
    }

    private Signature(Builder builder) {
        this(builder.pid, builder.uuid, builder.userid, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Signature)) {
            return false;
        }
        Signature signature = (Signature) obj;
        if (!equals((Object) this.pid, (Object) signature.pid) || !equals((Object) this.uuid, (Object) signature.uuid) || !equals((Object) this.userid, (Object) signature.userid) || !equals((Object) this.timestamp, (Object) signature.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.pid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.uuid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.userid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.timestamp;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Signature> {
        public String pid;
        public Long timestamp;
        public Long userid;
        public String uuid;

        public Builder() {
        }

        public Builder(Signature signature) {
            super(signature);
            if (signature != null) {
                this.pid = signature.pid;
                this.uuid = signature.uuid;
                this.userid = signature.userid;
                this.timestamp = signature.timestamp;
            }
        }

        public Builder pid(String str) {
            this.pid = str;
            return this;
        }

        public Builder uuid(String str) {
            this.uuid = str;
            return this;
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Signature build() {
            return new Signature(this);
        }
    }
}
