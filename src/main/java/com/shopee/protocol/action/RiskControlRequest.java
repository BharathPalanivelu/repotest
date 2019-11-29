package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class RiskControlRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SCENARIO = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer scenario;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public RiskControlRequest(String str, Integer num, f fVar, Integer num2, String str2) {
        this.requestid = str;
        this.userid = num;
        this.device_fingerprint = fVar;
        this.scenario = num2;
        this.country = str2;
    }

    private RiskControlRequest(Builder builder) {
        this(builder.requestid, builder.userid, builder.device_fingerprint, builder.scenario, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RiskControlRequest)) {
            return false;
        }
        RiskControlRequest riskControlRequest = (RiskControlRequest) obj;
        if (!equals((Object) this.requestid, (Object) riskControlRequest.requestid) || !equals((Object) this.userid, (Object) riskControlRequest.userid) || !equals((Object) this.device_fingerprint, (Object) riskControlRequest.device_fingerprint) || !equals((Object) this.scenario, (Object) riskControlRequest.scenario) || !equals((Object) this.country, (Object) riskControlRequest.country)) {
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
        f fVar = this.device_fingerprint;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.scenario;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RiskControlRequest> {
        public String country;
        public f device_fingerprint;
        public String requestid;
        public Integer scenario;
        public Integer userid;

        public Builder() {
        }

        public Builder(RiskControlRequest riskControlRequest) {
            super(riskControlRequest);
            if (riskControlRequest != null) {
                this.requestid = riskControlRequest.requestid;
                this.userid = riskControlRequest.userid;
                this.device_fingerprint = riskControlRequest.device_fingerprint;
                this.scenario = riskControlRequest.scenario;
                this.country = riskControlRequest.country;
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

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder scenario(Integer num) {
            this.scenario = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public RiskControlRequest build() {
            return new RiskControlRequest(this);
        }
    }
}
