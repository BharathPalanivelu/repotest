package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CoinGlobalExtInfo extends Message {
    public static final List<Integer> DEFAULT_RULE_RANK_IDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> rule_rank_ids;

    public CoinGlobalExtInfo(List<Integer> list) {
        this.rule_rank_ids = immutableCopyOf(list);
    }

    private CoinGlobalExtInfo(Builder builder) {
        this(builder.rule_rank_ids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinGlobalExtInfo)) {
            return false;
        }
        return equals((List<?>) this.rule_rank_ids, (List<?>) ((CoinGlobalExtInfo) obj).rule_rank_ids);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Integer> list = this.rule_rank_ids;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CoinGlobalExtInfo> {
        public List<Integer> rule_rank_ids;

        public Builder() {
        }

        public Builder(CoinGlobalExtInfo coinGlobalExtInfo) {
            super(coinGlobalExtInfo);
            if (coinGlobalExtInfo != null) {
                this.rule_rank_ids = CoinGlobalExtInfo.copyOf(coinGlobalExtInfo.rule_rank_ids);
            }
        }

        public Builder rule_rank_ids(List<Integer> list) {
            this.rule_rank_ids = checkForNulls(list);
            return this;
        }

        public CoinGlobalExtInfo build() {
            return new CoinGlobalExtInfo(this);
        }
    }
}
