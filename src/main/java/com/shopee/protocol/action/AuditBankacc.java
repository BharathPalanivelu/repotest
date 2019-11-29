package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AuditBankacc extends Message {
    public static final Boolean DEFAULT_APPROVE = false;
    public static final String DEFAULT_REASON = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BOOL)
    public final Boolean approve;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public AuditBankacc(String str, Integer num, Boolean bool, String str2) {
        this.requestid = str;
        this.userid = num;
        this.approve = bool;
        this.reason = str2;
    }

    private AuditBankacc(Builder builder) {
        this(builder.requestid, builder.userid, builder.approve, builder.reason);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuditBankacc)) {
            return false;
        }
        AuditBankacc auditBankacc = (AuditBankacc) obj;
        if (!equals((Object) this.requestid, (Object) auditBankacc.requestid) || !equals((Object) this.userid, (Object) auditBankacc.userid) || !equals((Object) this.approve, (Object) auditBankacc.approve) || !equals((Object) this.reason, (Object) auditBankacc.reason)) {
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
        Boolean bool = this.approve;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.reason;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AuditBankacc> {
        public Boolean approve;
        public String reason;
        public String requestid;
        public Integer userid;

        public Builder() {
        }

        public Builder(AuditBankacc auditBankacc) {
            super(auditBankacc);
            if (auditBankacc != null) {
                this.requestid = auditBankacc.requestid;
                this.userid = auditBankacc.userid;
                this.approve = auditBankacc.approve;
                this.reason = auditBankacc.reason;
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

        public Builder approve(Boolean bool) {
            this.approve = bool;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public AuditBankacc build() {
            checkRequiredFields();
            return new AuditBankacc(this);
        }
    }
}
