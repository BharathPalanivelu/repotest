package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAddrTax extends Message {
    public static final Integer DEFAULT_ADDR_TAX_FLAG = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer addr_tax_flag;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetAddrTax(String str, Long l, Integer num) {
        this.requestid = str;
        this.orderid = l;
        this.addr_tax_flag = num;
    }

    private SetAddrTax(Builder builder) {
        this(builder.requestid, builder.orderid, builder.addr_tax_flag);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAddrTax)) {
            return false;
        }
        SetAddrTax setAddrTax = (SetAddrTax) obj;
        if (!equals((Object) this.requestid, (Object) setAddrTax.requestid) || !equals((Object) this.orderid, (Object) setAddrTax.orderid) || !equals((Object) this.addr_tax_flag, (Object) setAddrTax.addr_tax_flag)) {
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
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.addr_tax_flag;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAddrTax> {
        public Integer addr_tax_flag;
        public Long orderid;
        public String requestid;

        public Builder() {
        }

        public Builder(SetAddrTax setAddrTax) {
            super(setAddrTax);
            if (setAddrTax != null) {
                this.requestid = setAddrTax.requestid;
                this.orderid = setAddrTax.orderid;
                this.addr_tax_flag = setAddrTax.addr_tax_flag;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder addr_tax_flag(Integer num) {
            this.addr_tax_flag = num;
            return this;
        }

        public SetAddrTax build() {
            return new SetAddrTax(this);
        }
    }
}
