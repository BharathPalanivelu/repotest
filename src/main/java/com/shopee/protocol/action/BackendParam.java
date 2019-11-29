package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BackendParam extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_NEED_AUDIT_LOG = false;
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REASON = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean need_audit_log;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public BackendParam(Integer num, Integer num2, String str, String str2, String str3, Boolean bool) {
        this.userid = num;
        this.shopid = num2;
        this.reason = str;
        this.operator = str2;
        this.country = str3;
        this.need_audit_log = bool;
    }

    private BackendParam(Builder builder) {
        this(builder.userid, builder.shopid, builder.reason, builder.operator, builder.country, builder.need_audit_log);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendParam)) {
            return false;
        }
        BackendParam backendParam = (BackendParam) obj;
        if (!equals((Object) this.userid, (Object) backendParam.userid) || !equals((Object) this.shopid, (Object) backendParam.shopid) || !equals((Object) this.reason, (Object) backendParam.reason) || !equals((Object) this.operator, (Object) backendParam.operator) || !equals((Object) this.country, (Object) backendParam.country) || !equals((Object) this.need_audit_log, (Object) backendParam.need_audit_log)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.reason;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.operator;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.need_audit_log;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BackendParam> {
        public String country;
        public Boolean need_audit_log;
        public String operator;
        public String reason;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(BackendParam backendParam) {
            super(backendParam);
            if (backendParam != null) {
                this.userid = backendParam.userid;
                this.shopid = backendParam.shopid;
                this.reason = backendParam.reason;
                this.operator = backendParam.operator;
                this.country = backendParam.country;
                this.need_audit_log = backendParam.need_audit_log;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder need_audit_log(Boolean bool) {
            this.need_audit_log = bool;
            return this;
        }

        public BackendParam build() {
            return new BackendParam(this);
        }
    }
}
