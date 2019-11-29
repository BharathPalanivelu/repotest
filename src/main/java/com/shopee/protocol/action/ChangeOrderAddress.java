package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerAddress;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChangeOrderAddress extends Message {
    public static final Integer DEFAULT_BUYER_ADDRESS_ID = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SHIPPING_ADDRESS = "";
    public static final String DEFAULT_SHIPPING_NAME = "";
    public static final String DEFAULT_SHIPPING_PHONE = "";
    public static final String DEFAULT_TAX_ADDRESS = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final BuyerAddress buyer_address;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer buyer_address_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String shipping_address;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String shipping_name;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String shipping_phone;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String tax_address;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public ChangeOrderAddress(String str, String str2, Long l, Integer num, BuyerAddress buyerAddress, String str3, String str4, String str5, String str6) {
        this.requestid = str;
        this.token = str2;
        this.orderid = l;
        this.buyer_address_id = num;
        this.buyer_address = buyerAddress;
        this.tax_address = str3;
        this.shipping_name = str4;
        this.shipping_phone = str5;
        this.shipping_address = str6;
    }

    private ChangeOrderAddress(Builder builder) {
        this(builder.requestid, builder.token, builder.orderid, builder.buyer_address_id, builder.buyer_address, builder.tax_address, builder.shipping_name, builder.shipping_phone, builder.shipping_address);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChangeOrderAddress)) {
            return false;
        }
        ChangeOrderAddress changeOrderAddress = (ChangeOrderAddress) obj;
        if (!equals((Object) this.requestid, (Object) changeOrderAddress.requestid) || !equals((Object) this.token, (Object) changeOrderAddress.token) || !equals((Object) this.orderid, (Object) changeOrderAddress.orderid) || !equals((Object) this.buyer_address_id, (Object) changeOrderAddress.buyer_address_id) || !equals((Object) this.buyer_address, (Object) changeOrderAddress.buyer_address) || !equals((Object) this.tax_address, (Object) changeOrderAddress.tax_address) || !equals((Object) this.shipping_name, (Object) changeOrderAddress.shipping_name) || !equals((Object) this.shipping_phone, (Object) changeOrderAddress.shipping_phone) || !equals((Object) this.shipping_address, (Object) changeOrderAddress.shipping_address)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.buyer_address_id;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress = this.buyer_address;
        int hashCode5 = (hashCode4 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        String str3 = this.tax_address;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.shipping_name;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.shipping_phone;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.shipping_address;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChangeOrderAddress> {
        public BuyerAddress buyer_address;
        public Integer buyer_address_id;
        public Long orderid;
        public String requestid;
        public String shipping_address;
        public String shipping_name;
        public String shipping_phone;
        public String tax_address;
        public String token;

        public Builder() {
        }

        public Builder(ChangeOrderAddress changeOrderAddress) {
            super(changeOrderAddress);
            if (changeOrderAddress != null) {
                this.requestid = changeOrderAddress.requestid;
                this.token = changeOrderAddress.token;
                this.orderid = changeOrderAddress.orderid;
                this.buyer_address_id = changeOrderAddress.buyer_address_id;
                this.buyer_address = changeOrderAddress.buyer_address;
                this.tax_address = changeOrderAddress.tax_address;
                this.shipping_name = changeOrderAddress.shipping_name;
                this.shipping_phone = changeOrderAddress.shipping_phone;
                this.shipping_address = changeOrderAddress.shipping_address;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder buyer_address_id(Integer num) {
            this.buyer_address_id = num;
            return this;
        }

        public Builder buyer_address(BuyerAddress buyerAddress) {
            this.buyer_address = buyerAddress;
            return this;
        }

        public Builder tax_address(String str) {
            this.tax_address = str;
            return this;
        }

        public Builder shipping_name(String str) {
            this.shipping_name = str;
            return this;
        }

        public Builder shipping_phone(String str) {
            this.shipping_phone = str;
            return this;
        }

        public Builder shipping_address(String str) {
            this.shipping_address = str;
            return this;
        }

        public ChangeOrderAddress build() {
            return new ChangeOrderAddress(this);
        }
    }
}
