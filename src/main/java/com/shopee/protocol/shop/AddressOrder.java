package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AddressOrder extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_HASHED_ADDR = "";
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String hashed_addr;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public AddressOrder(Long l, String str, Integer num, Integer num2, Integer num3) {
        this.orderid = l;
        this.hashed_addr = str;
        this.ctime = num;
        this.status = num2;
        this.userid = num3;
    }

    private AddressOrder(Builder builder) {
        this(builder.orderid, builder.hashed_addr, builder.ctime, builder.status, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddressOrder)) {
            return false;
        }
        AddressOrder addressOrder = (AddressOrder) obj;
        if (!equals((Object) this.orderid, (Object) addressOrder.orderid) || !equals((Object) this.hashed_addr, (Object) addressOrder.hashed_addr) || !equals((Object) this.ctime, (Object) addressOrder.ctime) || !equals((Object) this.status, (Object) addressOrder.status) || !equals((Object) this.userid, (Object) addressOrder.userid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.orderid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.hashed_addr;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.ctime;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AddressOrder> {
        public Integer ctime;
        public String hashed_addr;
        public Long orderid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(AddressOrder addressOrder) {
            super(addressOrder);
            if (addressOrder != null) {
                this.orderid = addressOrder.orderid;
                this.hashed_addr = addressOrder.hashed_addr;
                this.ctime = addressOrder.ctime;
                this.status = addressOrder.status;
                this.userid = addressOrder.userid;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder hashed_addr(String str) {
            this.hashed_addr = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public AddressOrder build() {
            return new AddressOrder(this);
        }
    }
}
