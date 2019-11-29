package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SlashPriceItemAudit extends Message {
    public static final Long DEFAULT_AUDITID = 0L;
    public static final Integer DEFAULT_AUDIT_TYPE = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DATA = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
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
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public SlashPriceItemAudit(Long l, Long l2, Integer num, Integer num2, String str, Integer num3, Integer num4) {
        this.auditid = l;
        this.itemid = l2;
        this.audit_type = num;
        this.status = num2;
        this.data = str;
        this.ctime = num3;
        this.mtime = num4;
    }

    private SlashPriceItemAudit(Builder builder) {
        this(builder.auditid, builder.itemid, builder.audit_type, builder.status, builder.data, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceItemAudit)) {
            return false;
        }
        SlashPriceItemAudit slashPriceItemAudit = (SlashPriceItemAudit) obj;
        if (!equals((Object) this.auditid, (Object) slashPriceItemAudit.auditid) || !equals((Object) this.itemid, (Object) slashPriceItemAudit.itemid) || !equals((Object) this.audit_type, (Object) slashPriceItemAudit.audit_type) || !equals((Object) this.status, (Object) slashPriceItemAudit.status) || !equals((Object) this.data, (Object) slashPriceItemAudit.data) || !equals((Object) this.ctime, (Object) slashPriceItemAudit.ctime) || !equals((Object) this.mtime, (Object) slashPriceItemAudit.mtime)) {
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
        Long l2 = this.itemid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.audit_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.data;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceItemAudit> {
        public Integer audit_type;
        public Long auditid;
        public Integer ctime;
        public String data;
        public Long itemid;
        public Integer mtime;
        public Integer status;

        public Builder() {
        }

        public Builder(SlashPriceItemAudit slashPriceItemAudit) {
            super(slashPriceItemAudit);
            if (slashPriceItemAudit != null) {
                this.auditid = slashPriceItemAudit.auditid;
                this.itemid = slashPriceItemAudit.itemid;
                this.audit_type = slashPriceItemAudit.audit_type;
                this.status = slashPriceItemAudit.status;
                this.data = slashPriceItemAudit.data;
                this.ctime = slashPriceItemAudit.ctime;
                this.mtime = slashPriceItemAudit.mtime;
            }
        }

        public Builder auditid(Long l) {
            this.auditid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
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

        public SlashPriceItemAudit build() {
            return new SlashPriceItemAudit(this);
        }
    }
}
