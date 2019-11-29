package com.shopee.protocol.action;

import com.shopee.protocol.shop.CoinEarnRule;
import com.shopee.protocol.shop.CoinGlobalRule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetCoinRule extends Message {
    public static final Integer DEFAULT_DEL_EARN_RULE_ID = 0;
    public static final List<Integer> DEFAULT_EARN_RANK_RULE_IDS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer del_earn_rule_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> earn_rank_rule_ids;
    @ProtoField(tag = 3)
    public final CoinEarnRule earn_rule;
    @ProtoField(tag = 6)
    public final CoinGlobalRule global_rule;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetCoinRule(String str, BackendParam backendParam, CoinEarnRule coinEarnRule, Integer num, List<Integer> list, CoinGlobalRule coinGlobalRule) {
        this.requestid = str;
        this.bparam = backendParam;
        this.earn_rule = coinEarnRule;
        this.del_earn_rule_id = num;
        this.earn_rank_rule_ids = immutableCopyOf(list);
        this.global_rule = coinGlobalRule;
    }

    private SetCoinRule(Builder builder) {
        this(builder.requestid, builder.bparam, builder.earn_rule, builder.del_earn_rule_id, builder.earn_rank_rule_ids, builder.global_rule);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCoinRule)) {
            return false;
        }
        SetCoinRule setCoinRule = (SetCoinRule) obj;
        if (!equals((Object) this.requestid, (Object) setCoinRule.requestid) || !equals((Object) this.bparam, (Object) setCoinRule.bparam) || !equals((Object) this.earn_rule, (Object) setCoinRule.earn_rule) || !equals((Object) this.del_earn_rule_id, (Object) setCoinRule.del_earn_rule_id) || !equals((List<?>) this.earn_rank_rule_ids, (List<?>) setCoinRule.earn_rank_rule_ids) || !equals((Object) this.global_rule, (Object) setCoinRule.global_rule)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        CoinEarnRule coinEarnRule = this.earn_rule;
        int hashCode3 = (hashCode2 + (coinEarnRule != null ? coinEarnRule.hashCode() : 0)) * 37;
        Integer num = this.del_earn_rule_id;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        List<Integer> list = this.earn_rank_rule_ids;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        CoinGlobalRule coinGlobalRule = this.global_rule;
        if (coinGlobalRule != null) {
            i2 = coinGlobalRule.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetCoinRule> {
        public BackendParam bparam;
        public Integer del_earn_rule_id;
        public List<Integer> earn_rank_rule_ids;
        public CoinEarnRule earn_rule;
        public CoinGlobalRule global_rule;
        public String requestid;

        public Builder() {
        }

        public Builder(SetCoinRule setCoinRule) {
            super(setCoinRule);
            if (setCoinRule != null) {
                this.requestid = setCoinRule.requestid;
                this.bparam = setCoinRule.bparam;
                this.earn_rule = setCoinRule.earn_rule;
                this.del_earn_rule_id = setCoinRule.del_earn_rule_id;
                this.earn_rank_rule_ids = SetCoinRule.copyOf(setCoinRule.earn_rank_rule_ids);
                this.global_rule = setCoinRule.global_rule;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder earn_rule(CoinEarnRule coinEarnRule) {
            this.earn_rule = coinEarnRule;
            return this;
        }

        public Builder del_earn_rule_id(Integer num) {
            this.del_earn_rule_id = num;
            return this;
        }

        public Builder earn_rank_rule_ids(List<Integer> list) {
            this.earn_rank_rule_ids = checkForNulls(list);
            return this;
        }

        public Builder global_rule(CoinGlobalRule coinGlobalRule) {
            this.global_rule = coinGlobalRule;
            return this;
        }

        public SetCoinRule build() {
            return new SetCoinRule(this);
        }
    }
}
