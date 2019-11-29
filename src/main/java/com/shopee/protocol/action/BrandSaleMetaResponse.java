package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BrandSaleMetaResponse extends Message {
    public static final Integer DEFAULT_BRANDID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_CUSTOM_LOGO = "";
    public static final String DEFAULT_CUSTOM_NAME = "";
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer brandid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String custom_logo;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String custom_name;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public BrandSaleMetaResponse(Integer num, Integer num2, String str, String str2, String str3) {
        this.brandid = num;
        this.shopid = num2;
        this.country = str;
        this.custom_name = str2;
        this.custom_logo = str3;
    }

    private BrandSaleMetaResponse(Builder builder) {
        this(builder.brandid, builder.shopid, builder.country, builder.custom_name, builder.custom_logo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrandSaleMetaResponse)) {
            return false;
        }
        BrandSaleMetaResponse brandSaleMetaResponse = (BrandSaleMetaResponse) obj;
        if (!equals((Object) this.brandid, (Object) brandSaleMetaResponse.brandid) || !equals((Object) this.shopid, (Object) brandSaleMetaResponse.shopid) || !equals((Object) this.country, (Object) brandSaleMetaResponse.country) || !equals((Object) this.custom_name, (Object) brandSaleMetaResponse.custom_name) || !equals((Object) this.custom_logo, (Object) brandSaleMetaResponse.custom_logo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.brandid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.custom_name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.custom_logo;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BrandSaleMetaResponse> {
        public Integer brandid;
        public String country;
        public String custom_logo;
        public String custom_name;
        public Integer shopid;

        public Builder() {
        }

        public Builder(BrandSaleMetaResponse brandSaleMetaResponse) {
            super(brandSaleMetaResponse);
            if (brandSaleMetaResponse != null) {
                this.brandid = brandSaleMetaResponse.brandid;
                this.shopid = brandSaleMetaResponse.shopid;
                this.country = brandSaleMetaResponse.country;
                this.custom_name = brandSaleMetaResponse.custom_name;
                this.custom_logo = brandSaleMetaResponse.custom_logo;
            }
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

        public BrandSaleMetaResponse build() {
            return new BrandSaleMetaResponse(this);
        }
    }
}
