package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ReqCheckoutCount extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final Boolean DEFAULT_ONLY_FREE_SHIPPING = false;
    public static final Boolean DEFAULT_ONLY_WEB = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean only_free_shipping;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean only_web;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ReqCheckoutCount(String str, Integer num, String str2, f fVar, f fVar2, Boolean bool, Boolean bool2) {
        this.requestid = str;
        this.userid = num;
        this.country = str2;
        this.deviceid = fVar;
        this.device_fingerprint = fVar2;
        this.only_free_shipping = bool;
        this.only_web = bool2;
    }

    private ReqCheckoutCount(Builder builder) {
        this(builder.requestid, builder.userid, builder.country, builder.deviceid, builder.device_fingerprint, builder.only_free_shipping, builder.only_web);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReqCheckoutCount)) {
            return false;
        }
        ReqCheckoutCount reqCheckoutCount = (ReqCheckoutCount) obj;
        if (!equals((Object) this.requestid, (Object) reqCheckoutCount.requestid) || !equals((Object) this.userid, (Object) reqCheckoutCount.userid) || !equals((Object) this.country, (Object) reqCheckoutCount.country) || !equals((Object) this.deviceid, (Object) reqCheckoutCount.deviceid) || !equals((Object) this.device_fingerprint, (Object) reqCheckoutCount.device_fingerprint) || !equals((Object) this.only_free_shipping, (Object) reqCheckoutCount.only_free_shipping) || !equals((Object) this.only_web, (Object) reqCheckoutCount.only_web)) {
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
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.device_fingerprint;
        int hashCode5 = (hashCode4 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Boolean bool = this.only_free_shipping;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.only_web;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReqCheckoutCount> {
        public String country;
        public f device_fingerprint;
        public f deviceid;
        public Boolean only_free_shipping;
        public Boolean only_web;
        public String requestid;
        public Integer userid;

        public Builder() {
        }

        public Builder(ReqCheckoutCount reqCheckoutCount) {
            super(reqCheckoutCount);
            if (reqCheckoutCount != null) {
                this.requestid = reqCheckoutCount.requestid;
                this.userid = reqCheckoutCount.userid;
                this.country = reqCheckoutCount.country;
                this.deviceid = reqCheckoutCount.deviceid;
                this.device_fingerprint = reqCheckoutCount.device_fingerprint;
                this.only_free_shipping = reqCheckoutCount.only_free_shipping;
                this.only_web = reqCheckoutCount.only_web;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder only_free_shipping(Boolean bool) {
            this.only_free_shipping = bool;
            return this;
        }

        public Builder only_web(Boolean bool) {
            this.only_web = bool;
            return this;
        }

        public ReqCheckoutCount build() {
            return new ReqCheckoutCount(this);
        }
    }
}
