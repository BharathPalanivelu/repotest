package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxAddressInfo extends Message {
    public static final Integer DEFAULT_ADDRESS_ID = 0;
    public static final String DEFAULT_TAX_ADDRESS = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer address_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String tax_address;

    public TaxAddressInfo(Integer num, String str) {
        this.address_id = num;
        this.tax_address = str;
    }

    private TaxAddressInfo(Builder builder) {
        this(builder.address_id, builder.tax_address);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxAddressInfo)) {
            return false;
        }
        TaxAddressInfo taxAddressInfo = (TaxAddressInfo) obj;
        if (!equals((Object) this.address_id, (Object) taxAddressInfo.address_id) || !equals((Object) this.tax_address, (Object) taxAddressInfo.tax_address)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.address_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.tax_address;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxAddressInfo> {
        public Integer address_id;
        public String tax_address;

        public Builder() {
        }

        public Builder(TaxAddressInfo taxAddressInfo) {
            super(taxAddressInfo);
            if (taxAddressInfo != null) {
                this.address_id = taxAddressInfo.address_id;
                this.tax_address = taxAddressInfo.tax_address;
            }
        }

        public Builder address_id(Integer num) {
            this.address_id = num;
            return this;
        }

        public Builder tax_address(String str) {
            this.tax_address = str;
            return this;
        }

        public TaxAddressInfo build() {
            return new TaxAddressInfo(this);
        }
    }
}
