package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CheckoutAudit extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Integer DEFAULT_AUDITID = 0;
    public static final Integer DEFAULT_AUDIT_TYPE = 0;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final String DEFAULT_DATA = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_NEW_STATUS = 0;
    public static final Integer DEFAULT_OLD_STATUS = 0;
    public static final Integer DEFAULT_OPUSERID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer audit_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer auditid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String data;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer new_status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer old_status;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer opuserid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public CheckoutAudit(Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Long l2, String str, String str2, Integer num6, Integer num7, String str3, Integer num8) {
        this.auditid = num;
        this.userid = num2;
        this.checkoutid = l;
        this.opuserid = num3;
        this.old_status = num4;
        this.new_status = num5;
        this.amount = l2;
        this.currency = str;
        this.data = str2;
        this.ctime = num6;
        this.mtime = num7;
        this.country = str3;
        this.audit_type = num8;
    }

    private CheckoutAudit(Builder builder) {
        this(builder.auditid, builder.userid, builder.checkoutid, builder.opuserid, builder.old_status, builder.new_status, builder.amount, builder.currency, builder.data, builder.ctime, builder.mtime, builder.country, builder.audit_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutAudit)) {
            return false;
        }
        CheckoutAudit checkoutAudit = (CheckoutAudit) obj;
        if (!equals((Object) this.auditid, (Object) checkoutAudit.auditid) || !equals((Object) this.userid, (Object) checkoutAudit.userid) || !equals((Object) this.checkoutid, (Object) checkoutAudit.checkoutid) || !equals((Object) this.opuserid, (Object) checkoutAudit.opuserid) || !equals((Object) this.old_status, (Object) checkoutAudit.old_status) || !equals((Object) this.new_status, (Object) checkoutAudit.new_status) || !equals((Object) this.amount, (Object) checkoutAudit.amount) || !equals((Object) this.currency, (Object) checkoutAudit.currency) || !equals((Object) this.data, (Object) checkoutAudit.data) || !equals((Object) this.ctime, (Object) checkoutAudit.ctime) || !equals((Object) this.mtime, (Object) checkoutAudit.mtime) || !equals((Object) this.country, (Object) checkoutAudit.country) || !equals((Object) this.audit_type, (Object) checkoutAudit.audit_type)) {
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
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.checkoutid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.opuserid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.old_status;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.new_status;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l2 = this.amount;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.data;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num8 = this.audit_type;
        if (num8 != null) {
            i2 = num8.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckoutAudit> {
        public Long amount;
        public Integer audit_type;
        public Integer auditid;
        public Long checkoutid;
        public String country;
        public Integer ctime;
        public String currency;
        public String data;
        public Integer mtime;
        public Integer new_status;
        public Integer old_status;
        public Integer opuserid;
        public Integer userid;

        public Builder() {
        }

        public Builder(CheckoutAudit checkoutAudit) {
            super(checkoutAudit);
            if (checkoutAudit != null) {
                this.auditid = checkoutAudit.auditid;
                this.userid = checkoutAudit.userid;
                this.checkoutid = checkoutAudit.checkoutid;
                this.opuserid = checkoutAudit.opuserid;
                this.old_status = checkoutAudit.old_status;
                this.new_status = checkoutAudit.new_status;
                this.amount = checkoutAudit.amount;
                this.currency = checkoutAudit.currency;
                this.data = checkoutAudit.data;
                this.ctime = checkoutAudit.ctime;
                this.mtime = checkoutAudit.mtime;
                this.country = checkoutAudit.country;
                this.audit_type = checkoutAudit.audit_type;
            }
        }

        public Builder auditid(Integer num) {
            this.auditid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder opuserid(Integer num) {
            this.opuserid = num;
            return this;
        }

        public Builder old_status(Integer num) {
            this.old_status = num;
            return this;
        }

        public Builder new_status(Integer num) {
            this.new_status = num;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
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

        public Builder audit_type(Integer num) {
            this.audit_type = num;
            return this;
        }

        public CheckoutAudit build() {
            return new CheckoutAudit(this);
        }
    }
}
