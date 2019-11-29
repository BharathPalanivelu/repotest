package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AddressTax extends Message {
    public static final String DEFAULT_HASHED_ADDR = "";
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_NORMALIZED_ADDR = "";
    public static final Integer DEFAULT_ORDER_COUNT = 0;
    public static final Integer DEFAULT_TAX_FLAG = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String hashed_addr;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String normalized_addr;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer order_count;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer tax_flag;

    public AddressTax(Long l, String str, String str2, Integer num, Integer num2) {
        this.id = l;
        this.hashed_addr = str;
        this.normalized_addr = str2;
        this.tax_flag = num;
        this.order_count = num2;
    }

    private AddressTax(Builder builder) {
        this(builder.id, builder.hashed_addr, builder.normalized_addr, builder.tax_flag, builder.order_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddressTax)) {
            return false;
        }
        AddressTax addressTax = (AddressTax) obj;
        if (!equals((Object) this.id, (Object) addressTax.id) || !equals((Object) this.hashed_addr, (Object) addressTax.hashed_addr) || !equals((Object) this.normalized_addr, (Object) addressTax.normalized_addr) || !equals((Object) this.tax_flag, (Object) addressTax.tax_flag) || !equals((Object) this.order_count, (Object) addressTax.order_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.hashed_addr;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.normalized_addr;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.tax_flag;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.order_count;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AddressTax> {
        public String hashed_addr;
        public Long id;
        public String normalized_addr;
        public Integer order_count;
        public Integer tax_flag;

        public Builder() {
        }

        public Builder(AddressTax addressTax) {
            super(addressTax);
            if (addressTax != null) {
                this.id = addressTax.id;
                this.hashed_addr = addressTax.hashed_addr;
                this.normalized_addr = addressTax.normalized_addr;
                this.tax_flag = addressTax.tax_flag;
                this.order_count = addressTax.order_count;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder hashed_addr(String str) {
            this.hashed_addr = str;
            return this;
        }

        public Builder normalized_addr(String str) {
            this.normalized_addr = str;
            return this;
        }

        public Builder tax_flag(Integer num) {
            this.tax_flag = num;
            return this;
        }

        public Builder order_count(Integer num) {
            this.order_count = num;
            return this;
        }

        public AddressTax build() {
            return new AddressTax(this);
        }
    }
}
