package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BrandSaleMeta extends Message {
    public static final Integer DEFAULT_BRANDID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CUSTOM_LOGO = "";
    public static final String DEFAULT_CUSTOM_NAME = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer brandid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String custom_logo;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String custom_name;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public BrandSaleMeta(Integer num, Integer num2, Integer num3, String str, String str2, String str3, Integer num4, Integer num5) {
        this.id = num;
        this.brandid = num2;
        this.shopid = num3;
        this.country = str;
        this.custom_name = str2;
        this.custom_logo = str3;
        this.ctime = num4;
        this.mtime = num5;
    }

    private BrandSaleMeta(Builder builder) {
        this(builder.id, builder.brandid, builder.shopid, builder.country, builder.custom_name, builder.custom_logo, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrandSaleMeta)) {
            return false;
        }
        BrandSaleMeta brandSaleMeta = (BrandSaleMeta) obj;
        if (!equals((Object) this.id, (Object) brandSaleMeta.id) || !equals((Object) this.brandid, (Object) brandSaleMeta.brandid) || !equals((Object) this.shopid, (Object) brandSaleMeta.shopid) || !equals((Object) this.country, (Object) brandSaleMeta.country) || !equals((Object) this.custom_name, (Object) brandSaleMeta.custom_name) || !equals((Object) this.custom_logo, (Object) brandSaleMeta.custom_logo) || !equals((Object) this.ctime, (Object) brandSaleMeta.ctime) || !equals((Object) this.mtime, (Object) brandSaleMeta.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.brandid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.custom_name;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.custom_logo;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BrandSaleMeta> {
        public Integer brandid;
        public String country;
        public Integer ctime;
        public String custom_logo;
        public String custom_name;
        public Integer id;
        public Integer mtime;
        public Integer shopid;

        public Builder() {
        }

        public Builder(BrandSaleMeta brandSaleMeta) {
            super(brandSaleMeta);
            if (brandSaleMeta != null) {
                this.id = brandSaleMeta.id;
                this.brandid = brandSaleMeta.brandid;
                this.shopid = brandSaleMeta.shopid;
                this.country = brandSaleMeta.country;
                this.custom_name = brandSaleMeta.custom_name;
                this.custom_logo = brandSaleMeta.custom_logo;
                this.ctime = brandSaleMeta.ctime;
                this.mtime = brandSaleMeta.mtime;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder brandid(Integer num) {
            this.brandid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder custom_name(String str) {
            this.custom_name = str;
            return this;
        }

        public Builder custom_logo(String str) {
            this.custom_logo = str;
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

        public BrandSaleMeta build() {
            return new BrandSaleMeta(this);
        }
    }
}
