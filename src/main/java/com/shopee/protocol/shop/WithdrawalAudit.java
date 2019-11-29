package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class WithdrawalAudit extends Message {
    public static final Long DEFAULT_AUDITID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_DATA = f.f32736b;
    public static final Integer DEFAULT_NEW_STATUS = 0;
    public static final Integer DEFAULT_OLD_STATUS = 0;
    public static final Integer DEFAULT_OPUSERID = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final Long DEFAULT_WITHDRAWAL_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long auditid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f data;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer new_status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer old_status;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer opuserid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long withdrawal_id;

    public WithdrawalAudit(Long l, Integer num, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, f fVar, String str) {
        this.auditid = l;
        this.userid = num;
        this.withdrawal_id = l2;
        this.opuserid = num2;
        this.old_status = num3;
        this.new_status = num4;
        this.ctime = num5;
        this.data = fVar;
        this.country = str;
    }

    private WithdrawalAudit(Builder builder) {
        this(builder.auditid, builder.userid, builder.withdrawal_id, builder.opuserid, builder.old_status, builder.new_status, builder.ctime, builder.data, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WithdrawalAudit)) {
            return false;
        }
        WithdrawalAudit withdrawalAudit = (WithdrawalAudit) obj;
        if (!equals((Object) this.auditid, (Object) withdrawalAudit.auditid) || !equals((Object) this.userid, (Object) withdrawalAudit.userid) || !equals((Object) this.withdrawal_id, (Object) withdrawalAudit.withdrawal_id) || !equals((Object) this.opuserid, (Object) withdrawalAudit.opuserid) || !equals((Object) this.old_status, (Object) withdrawalAudit.old_status) || !equals((Object) this.new_status, (Object) withdrawalAudit.new_status) || !equals((Object) this.ctime, (Object) withdrawalAudit.ctime) || !equals((Object) this.data, (Object) withdrawalAudit.data) || !equals((Object) this.country, (Object) withdrawalAudit.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.auditid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.withdrawal_id;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.opuserid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.old_status;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.new_status;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        f fVar = this.data;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WithdrawalAudit> {
        public Long auditid;
        public String country;
        public Integer ctime;
        public f data;
        public Integer new_status;
        public Integer old_status;
        public Integer opuserid;
        public Integer userid;
        public Long withdrawal_id;

        public Builder() {
        }

        public Builder(WithdrawalAudit withdrawalAudit) {
            super(withdrawalAudit);
            if (withdrawalAudit != null) {
                this.auditid = withdrawalAudit.auditid;
                this.userid = withdrawalAudit.userid;
                this.withdrawal_id = withdrawalAudit.withdrawal_id;
                this.opuserid = withdrawalAudit.opuserid;
                this.old_status = withdrawalAudit.old_status;
                this.new_status = withdrawalAudit.new_status;
                this.ctime = withdrawalAudit.ctime;
                this.data = withdrawalAudit.data;
                this.country = withdrawalAudit.country;
            }
        }

        public Builder auditid(Long l) {
            this.auditid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder withdrawal_id(Long l) {
            this.withdrawal_id = l;
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

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder data(f fVar) {
            this.data = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public WithdrawalAudit build() {
            return new WithdrawalAudit(this);
        }
    }
}
