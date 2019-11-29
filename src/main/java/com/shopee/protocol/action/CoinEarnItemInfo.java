package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinEarnItemInfo extends Message {
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;

    public CoinEarnItemInfo(Long l, Long l2, Long l3) {
        this.itemid = l;
        this.modelid = l2;
        this.coin_earn = l3;
    }

    private CoinEarnItemInfo(Builder builder) {
        this(builder.itemid, builder.modelid, builder.coin_earn);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinEarnItemInfo)) {
            return false;
        }
        CoinEarnItemInfo coinEarnItemInfo = (CoinEarnItemInfo) obj;
        if (!equals((Object) this.itemid, (Object) coinEarnItemInfo.itemid) || !equals((Object) this.modelid, (Object) coinEarnItemInfo.modelid) || !equals((Object) this.coin_earn, (Object) coinEarnItemInfo.coin_earn)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.modelid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.coin_earn;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinEarnItemInfo> {
        public Long coin_earn;
        public Long itemid;
        public Long modelid;

        public Builder() {
        }

        public Builder(CoinEarnItemInfo coinEarnItemInfo) {
            super(coinEarnItemInfo);
            if (coinEarnItemInfo != null) {
                this.itemid = coinEarnItemInfo.itemid;
                this.modelid = coinEarnItemInfo.modelid;
                this.coin_earn = coinEarnItemInfo.coin_earn;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder coin_earn(Long l) {
            this.coin_earn = l;
            return this;
        }

        public CoinEarnItemInfo build() {
            return new CoinEarnItemInfo(this);
        }
    }
}
