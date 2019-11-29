package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopAudit extends Message {
    public static final Integer DEFAULT_AUDITID = 0;
    public static final Integer DEFAULT_AUDIT_TYPE = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DATA = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
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
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public ShopAudit(Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5, Integer num6, String str2) {
        this.auditid = num;
        this.shopid = num2;
        this.audit_type = num3;
        this.status = num4;
        this.data = str;
        this.ctime = num5;
        this.mtime = num6;
        this.country = str2;
    }

    private ShopAudit(Builder builder) {
        this(builder.auditid, builder.shopid, builder.audit_type, builder.status, builder.data, builder.ctime, builder.mtime, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopAudit)) {
            return false;
        }
        ShopAudit shopAudit = (ShopAudit) obj;
        if (!equals((Object) this.auditid, (Object) shopAudit.auditid) || !equals((Object) this.shopid, (Object) shopAudit.shopid) || !equals((Object) this.audit_type, (Object) shopAudit.audit_type) || !equals((Object) this.status, (Object) shopAudit.status) || !equals((Object) this.data, (Object) shopAudit.data) || !equals((Object) this.ctime, (Object) shopAudit.ctime) || !equals((Object) this.mtime, (Object) shopAudit.mtime) || !equals((Object) this.country, (Object) shopAudit.country)) {
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
        Integer num2 = this.shopid;
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

    public static final class Builder extends Message.Builder<ShopAudit> {
        public Integer audit_type;
        public Integer auditid;
        public String country;
        public Integer ctime;
        public String data;
        public Integer mtime;
        public Integer shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(ShopAudit shopAudit) {
            super(shopAudit);
            if (shopAudit != null) {
                this.auditid = shopAudit.auditid;
                this.shopid = shopAudit.shopid;
                this.audit_type = shopAudit.audit_type;
                this.status = shopAudit.status;
                this.data = shopAudit.data;
                this.ctime = shopAudit.ctime;
                this.mtime = shopAudit.mtime;
                this.country = shopAudit.country;
            }
        }

        public Builder auditid(Integer num) {
            this.auditid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
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

        public ShopAudit build() {
            return new ShopAudit(this);
        }
    }
}
