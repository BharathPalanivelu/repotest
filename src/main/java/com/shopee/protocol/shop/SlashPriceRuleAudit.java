package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SlashPriceRuleAudit extends Message {
    public static final Long DEFAULT_AUDITID = 0L;
    public static final Integer DEFAULT_AUDIT_TYPE = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DATA = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_RULE_ID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer audit_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long auditid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String data;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer rule_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public SlashPriceRuleAudit(Long l, Integer num, Integer num2, Integer num3, String str, Integer num4, Integer num5) {
        this.auditid = l;
        this.rule_id = num;
        this.audit_type = num2;
        this.status = num3;
        this.data = str;
        this.ctime = num4;
        this.mtime = num5;
    }

    private SlashPriceRuleAudit(Builder builder) {
        this(builder.auditid, builder.rule_id, builder.audit_type, builder.status, builder.data, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceRuleAudit)) {
            return false;
        }
        SlashPriceRuleAudit slashPriceRuleAudit = (SlashPriceRuleAudit) obj;
        if (!equals((Object) this.auditid, (Object) slashPriceRuleAudit.auditid) || !equals((Object) this.rule_id, (Object) slashPriceRuleAudit.rule_id) || !equals((Object) this.audit_type, (Object) slashPriceRuleAudit.audit_type) || !equals((Object) this.status, (Object) slashPriceRuleAudit.status) || !equals((Object) this.data, (Object) slashPriceRuleAudit.data) || !equals((Object) this.ctime, (Object) slashPriceRuleAudit.ctime) || !equals((Object) this.mtime, (Object) slashPriceRuleAudit.mtime)) {
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
        Integer num = this.rule_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.audit_type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.data;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceRuleAudit> {
        public Integer audit_type;
        public Long auditid;
        public Integer ctime;
        public String data;
        public Integer mtime;
        public Integer rule_id;
        public Integer status;

        public Builder() {
        }

        public Builder(SlashPriceRuleAudit slashPriceRuleAudit) {
            super(slashPriceRuleAudit);
            if (slashPriceRuleAudit != null) {
                this.auditid = slashPriceRuleAudit.auditid;
                this.rule_id = slashPriceRuleAudit.rule_id;
                this.audit_type = slashPriceRuleAudit.audit_type;
                this.status = slashPriceRuleAudit.status;
                this.data = slashPriceRuleAudit.data;
                this.ctime = slashPriceRuleAudit.ctime;
                this.mtime = slashPriceRuleAudit.mtime;
            }
        }

        public Builder auditid(Long l) {
            this.auditid = l;
            return this;
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
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

        public SlashPriceRuleAudit build() {
            return new SlashPriceRuleAudit(this);
        }
    }
}
