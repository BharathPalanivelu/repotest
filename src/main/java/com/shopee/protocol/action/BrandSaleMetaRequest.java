package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BrandSaleMetaRequest extends Message {
    public static final Integer DEFAULT_BRANDID = 0;
    public static final String DEFAULT_CUSTOM_LOGO = "";
    public static final String DEFAULT_CUSTOM_NAME = "";
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer brandid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String custom_logo;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String custom_name;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public BrandSaleMetaRequest(Integer num, Integer num2, String str, String str2) {
        this.brandid = num;
        this.shopid = num2;
        this.custom_name = str;
        this.custom_logo = str2;
    }

    private BrandSaleMetaRequest(Builder builder) {
        this(builder.brandid, builder.shopid, builder.custom_name, builder.custom_logo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrandSaleMetaRequest)) {
            return false;
        }
        BrandSaleMetaRequest brandSaleMetaRequest = (BrandSaleMetaRequest) obj;
        if (!equals((Object) this.brandid, (Object) brandSaleMetaRequest.brandid) || !equals((Object) this.shopid, (Object) brandSaleMetaRequest.shopid) || !equals((Object) this.custom_name, (Object) brandSaleMetaRequest.custom_name) || !equals((Object) this.custom_logo, (Object) brandSaleMetaRequest.custom_logo)) {
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
        String str = this.custom_name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.custom_logo;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BrandSaleMetaRequest> {
        public Integer brandid;
        public String custom_logo;
        public String custom_name;
        public Integer shopid;

        public Builder() {
        }

        public Builder(BrandSaleMetaRequest brandSaleMetaRequest) {
            super(brandSaleMetaRequest);
            if (brandSaleMetaRequest != null) {
                this.brandid = brandSaleMetaRequest.brandid;
                this.shopid = brandSaleMetaRequest.shopid;
                this.custom_name = brandSaleMetaRequest.custom_name;
                this.custom_logo = brandSaleMetaRequest.custom_logo;
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

        public Builder custom_name(String str) {
            this.custom_name = str;
            return this;
        }

        public Builder custom_logo(String str) {
            this.custom_logo = str;
            return this;
        }

        public BrandSaleMetaRequest build() {
            return new BrandSaleMetaRequest(this);
        }
    }
}
