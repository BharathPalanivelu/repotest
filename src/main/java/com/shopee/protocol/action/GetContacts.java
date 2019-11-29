package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class GetContacts extends Message {
    public static final Integer DEFAULT_ACCTYPE = 0;
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEEDS_ACCOUNT = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer acctype;
    @ProtoField(tag = 8)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean needs_account;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;

    public GetContacts(String str, Integer num, Integer num2, Integer num3, f fVar, String str2, Boolean bool, BackendParam backendParam) {
        this.requestid = str;
        this.acctype = num;
        this.offset = num2;
        this.limit = num3;
        this.deviceid = fVar;
        this.token = str2;
        this.needs_account = bool;
        this.bparam = backendParam;
    }

    private GetContacts(Builder builder) {
        this(builder.requestid, builder.acctype, builder.offset, builder.limit, builder.deviceid, builder.token, builder.needs_account, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetContacts)) {
            return false;
        }
        GetContacts getContacts = (GetContacts) obj;
        if (!equals((Object) this.requestid, (Object) getContacts.requestid) || !equals((Object) this.acctype, (Object) getContacts.acctype) || !equals((Object) this.offset, (Object) getContacts.offset) || !equals((Object) this.limit, (Object) getContacts.limit) || !equals((Object) this.deviceid, (Object) getContacts.deviceid) || !equals((Object) this.token, (Object) getContacts.token) || !equals((Object) this.needs_account, (Object) getContacts.needs_account) || !equals((Object) this.bparam, (Object) getContacts.bparam)) {
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
        Integer num = this.acctype;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode5 = (hashCode4 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.needs_account;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetContacts> {
        public Integer acctype;
        public BackendParam bparam;
        public f deviceid;
        public Integer limit;
        public Boolean needs_account;
        public Integer offset;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetContacts getContacts) {
            super(getContacts);
            if (getContacts != null) {
                this.requestid = getContacts.requestid;
                this.acctype = getContacts.acctype;
                this.offset = getContacts.offset;
                this.limit = getContacts.limit;
                this.deviceid = getContacts.deviceid;
                this.token = getContacts.token;
                this.needs_account = getContacts.needs_account;
                this.bparam = getContacts.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder acctype(Integer num) {
            this.acctype = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder needs_account(Boolean bool) {
            this.needs_account = bool;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public GetContacts build() {
            return new GetContacts(this);
        }
    }
}
