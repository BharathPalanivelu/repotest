package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CoinItemInfo extends Message {
    public static final List<CoinEarnItemInfo> DEFAULT_COIN_EARN_ITEMS = Collections.emptyList();
    public static final Long DEFAULT_SPEND_CASH_UNIT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CoinEarnItemInfo.class, tag = 1)
    public final List<CoinEarnItemInfo> coin_earn_items;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long spend_cash_unit;

    public CoinItemInfo(List<CoinEarnItemInfo> list, Long l) {
        this.coin_earn_items = immutableCopyOf(list);
        this.spend_cash_unit = l;
    }

    private CoinItemInfo(Builder builder) {
        this(builder.coin_earn_items, builder.spend_cash_unit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinItemInfo)) {
            return false;
        }
        CoinItemInfo coinItemInfo = (CoinItemInfo) obj;
        if (!equals((List<?>) this.coin_earn_items, (List<?>) coinItemInfo.coin_earn_items) || !equals((Object) this.spend_cash_unit, (Object) coinItemInfo.spend_cash_unit)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<CoinEarnItemInfo> list = this.coin_earn_items;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Long l = this.spend_cash_unit;
        int hashCode2 = hashCode + (l != null ? l.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CoinItemInfo> {
        public List<CoinEarnItemInfo> coin_earn_items;
        public Long spend_cash_unit;

        public Builder() {
        }

        public Builder(CoinItemInfo coinItemInfo) {
            super(coinItemInfo);
            if (coinItemInfo != null) {
                this.coin_earn_items = CoinItemInfo.copyOf(coinItemInfo.coin_earn_items);
                this.spend_cash_unit = coinItemInfo.spend_cash_unit;
            }
        }

        public Builder coin_earn_items(List<CoinEarnItemInfo> list) {
            this.coin_earn_items = checkForNulls(list);
            return this;
        }

        public Builder spend_cash_unit(Long l) {
            this.spend_cash_unit = l;
            return this;
        }

        public CoinItemInfo build() {
            return new CoinItemInfo(this);
        }
    }
}
