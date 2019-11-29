package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReferralAudit extends Message {
    public static final Integer DEFAULT_AUDITID = 0;
    public static final Integer DEFAULT_AUDIT_TYPE = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DATA = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_REFERRAL_ID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer audit_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer auditid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String data;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer referral_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public ReferralAudit(Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5, Integer num6, String str2) {
        this.auditid = num;
        this.referral_id = num2;
        this.audit_type = num3;
        this.status = num4;
        this.data = str;
        this.ctime = num5;
        this.mtime = num6;
        this.country = str2;
    }

    private ReferralAudit(Builder builder) {
        this(builder.auditid, builder.referral_id, builder.audit_type, builder.status, builder.data, builder.ctime, builder.mtime, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReferralAudit)) {
            return false;
        }
        ReferralAudit referralAudit = (ReferralAudit) obj;
        if (!equals((Object) this.auditid, (Object) referralAudit.auditid) || !equals((Object) this.referral_id, (Object) referralAudit.referral_id) || !equals((Object) this.audit_type, (Object) referralAudit.audit_type) || !equals((Object) this.status, (Object) referralAudit.status) || !equals((Object) this.data, (Object) referralAudit.data) || !equals((Object) this.ctime, (Object) referralAudit.ctime) || !equals((Object) this.mtime, (Object) referralAudit.mtime) || !equals((Object) this.country, (Object) referralAudit.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.auditid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.referral_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.audit_type;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.data;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.mtime;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReferralAudit> {
        public Integer audit_type;
        public Integer auditid;
        public String country;
        public Integer ctime;
        public String data;
        public Integer mtime;
        public Integer referral_id;
        public Integer status;

        public Builder() {
        }

        public Builder(ReferralAudit referralAudit) {
            super(referralAudit);
            if (referralAudit != null) {
                this.auditid = referralAudit.auditid;
                this.referral_id = referralAudit.referral_id;
                this.audit_type = referralAudit.audit_type;
                this.status = referralAudit.status;
                this.data = referralAudit.data;
                this.ctime = referralAudit.ctime;
                this.mtime = referralAudit.mtime;
                this.country = referralAudit.country;
            }
        }

        public Builder auditid(Integer num) {
            this.auditid = num;
            return this;
        }

        public Builder referral_id(Integer num) {
            this.referral_id = num;
            return this;
        }

        public Builder audit_type(Integer num) {
            this.audit_type = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder data(String str) {
            this.data = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public ReferralAudit build() {
            return new ReferralAudit(this);
        }
    }
}
