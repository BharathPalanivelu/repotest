package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetShopFlashSale extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public GetShopFlashSale(String str, String str2, Integer num) {
        this.requestid = str;
        this.country = str2;
        this.shopid = num;
    }

    private GetShopFlashSale(Builder builder) {
        this(builder.requestid, builder.country, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetShopFlashSale)) {
            return false;
        }
        GetShopFlashSale getShopFlashSale = (GetShopFlashSale) obj;
        if (!equals((Object) this.requestid, (Object) getShopFlashSale.requestid) || !equals((Object) this.country, (Object) getShopFlashSale.country) || !equals((Object) this.shopid, (Object) getShopFlashSale.shopid)) {
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
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetShopFlashSale> {
        public String country;
        public String requestid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(GetShopFlashSale getShopFlashSale) {
            super(getShopFlashSale);
            if (getShopFlashSale != null) {
                this.requestid = getShopFlashSale.requestid;
                this.country = getShopFlashSale.country;
                this.shopid = getShopFlashSale.shopid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public GetShopFlashSale build() {
            return new GetShopFlashSale(this);
        }
    }
}
