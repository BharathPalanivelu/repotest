package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinTransOrderid extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_TRANS_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer trans_type;

    public CoinTransOrderid(Integer num, Long l) {
        this.trans_type = num;
        this.orderid = l;
    }

    private CoinTransOrderid(Builder builder) {
        this(builder.trans_type, builder.orderid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinTransOrderid)) {
            return false;
        }
        CoinTransOrderid coinTransOrderid = (CoinTransOrderid) obj;
        if (!equals((Object) this.trans_type, (Object) coinTransOrderid.trans_type) || !equals((Object) this.orderid, (Object) coinTransOrderid.orderid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.trans_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.orderid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinTransOrderid> {
        public Long orderid;
        public Integer trans_type;

        public Builder() {
        }

        public Builder(CoinTransOrderid coinTransOrderid) {
            super(coinTransOrderid);
            if (coinTransOrderid != null) {
                this.trans_type = coinTransOrderid.trans_type;
                this.orderid = coinTransOrderid.orderid;
            }
        }

        public Builder trans_type(Integer num) {
            this.trans_type = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public CoinTransOrderid build() {
            return new CoinTransOrderid(this);
        }
    }
}
