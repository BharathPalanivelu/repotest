package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAuditStatus extends Message {
    public static final Integer DEFAULT_AUDITID = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer auditid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    public SetAuditStatus(String str, Integer num, Integer num2, Integer num3) {
        this.requestid = str;
        this.auditid = num;
        this.status = num2;
        this.type = num3;
    }

    private SetAuditStatus(Builder builder) {
        this(builder.requestid, builder.auditid, builder.status, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAuditStatus)) {
            return false;
        }
        SetAuditStatus setAuditStatus = (SetAuditStatus) obj;
        if (!equals((Object) this.requestid, (Object) setAuditStatus.requestid) || !equals((Object) this.auditid, (Object) setAuditStatus.auditid) || !equals((Object) this.status, (Object) setAuditStatus.status) || !equals((Object) this.type, (Object) setAuditStatus.type)) {
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
        Integer num = this.auditid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.type;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAuditStatus> {
        public Integer auditid;
        public String requestid;
        public Integer status;
        public Integer type;

        public Builder() {
        }

        public Builder(SetAuditStatus setAuditStatus) {
            super(setAuditStatus);
            if (setAuditStatus != null) {
                this.requestid = setAuditStatus.requestid;
                this.auditid = setAuditStatus.auditid;
                this.status = setAuditStatus.status;
                this.type = setAuditStatus.type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder auditid(Integer num) {
            this.auditid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public SetAuditStatus build() {
            checkRequiredFields();
            return new SetAuditStatus(this);
        }
    }
}
