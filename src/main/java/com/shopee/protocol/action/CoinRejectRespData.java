package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinRejectRespData extends Message {
    public static final Integer DEFAULT_COIN_REJECT_ERRCODE = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer coin_reject_errcode;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;

    public CoinRejectRespData(Long l, Integer num) {
        this.orderid = l;
        this.coin_reject_errcode = num;
    }

    private CoinRejectRespData(Builder builder) {
        this(builder.orderid, builder.coin_reject_errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinRejectRespData)) {
            return false;
        }
        CoinRejectRespData coinRejectRespData = (CoinRejectRespData) obj;
        if (!equals((Object) this.orderid, (Object) coinRejectRespData.orderid) || !equals((Object) this.coin_reject_errcode, (Object) coinRejectRespData.coin_reject_errcode)) {
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
        Integer num = this.coin_reject_errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinRejectRespData> {
        public Integer coin_reject_errcode;
        public Long orderid;

        public Builder() {
        }

        public Builder(CoinRejectRespData coinRejectRespData) {
            super(coinRejectRespData);
            if (coinRejectRespData != null) {
                this.orderid = coinRejectRespData.orderid;
                this.coin_reject_errcode = coinRejectRespData.coin_reject_errcode;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder coin_reject_errcode(Integer num) {
            this.coin_reject_errcode = num;
            return this;
        }

        public CoinRejectRespData build() {
            return new CoinRejectRespData(this);
        }
    }
}
