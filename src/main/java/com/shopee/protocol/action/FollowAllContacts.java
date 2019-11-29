package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class FollowAllContacts extends Message {
    public static final Integer DEFAULT_ACCTYPE = 0;
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer acctype;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public FollowAllContacts(String str, f fVar, Integer num) {
        this.requestid = str;
        this.deviceid = fVar;
        this.acctype = num;
    }

    private FollowAllContacts(Builder builder) {
        this(builder.requestid, builder.deviceid, builder.acctype);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FollowAllContacts)) {
            return false;
        }
        FollowAllContacts followAllContacts = (FollowAllContacts) obj;
        if (!equals((Object) this.requestid, (Object) followAllContacts.requestid) || !equals((Object) this.deviceid, (Object) followAllContacts.deviceid) || !equals((Object) this.acctype, (Object) followAllContacts.acctype)) {
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
        f fVar = this.deviceid;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.acctype;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FollowAllContacts> {
        public Integer acctype;
        public f deviceid;
        public String requestid;

        public Builder() {
        }

        public Builder(FollowAllContacts followAllContacts) {
            super(followAllContacts);
            if (followAllContacts != null) {
                this.requestid = followAllContacts.requestid;
                this.deviceid = followAllContacts.deviceid;
                this.acctype = followAllContacts.acctype;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder acctype(Integer num) {
            this.acctype = num;
            return this;
        }

        public FollowAllContacts build() {
            return new FollowAllContacts(this);
        }
    }
}
