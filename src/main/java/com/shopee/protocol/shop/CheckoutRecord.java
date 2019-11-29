package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CheckoutRecord extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public CheckoutRecord(Long l, Integer num, Long l2, Integer num2) {
        this.checkoutid = l;
        this.timestamp = num;
        this.amount = l2;
        this.userid = num2;
    }

    private CheckoutRecord(Builder builder) {
        this(builder.checkoutid, builder.timestamp, builder.amount, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutRecord)) {
            return false;
        }
        CheckoutRecord checkoutRecord = (CheckoutRecord) obj;
        if (!equals((Object) this.checkoutid, (Object) checkoutRecord.checkoutid) || !equals((Object) this.timestamp, (Object) checkoutRecord.timestamp) || !equals((Object) this.amount, (Object) checkoutRecord.amount) || !equals((Object) this.userid, (Object) checkoutRecord.userid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.checkoutid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.timestamp;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.amount;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckoutRecord> {
        public Long amount;
        public Long checkoutid;
        public Integer timestamp;
        public Integer userid;

        public Builder() {
        }

        public Builder(CheckoutRecord checkoutRecord) {
            super(checkoutRecord);
            if (checkoutRecord != null) {
                this.checkoutid = checkoutRecord.checkoutid;
                this.timestamp = checkoutRecord.timestamp;
                this.amount = checkoutRecord.amount;
                this.userid = checkoutRecord.userid;
            }
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public CheckoutRecord build() {
            return new CheckoutRecord(this);
        }
    }
}
