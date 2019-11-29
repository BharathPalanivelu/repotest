package com.shopee.protocol.action;

import com.shopee.protocol.shop.CoinEarnRule;
import com.shopee.protocol.shop.CoinGlobalRule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetCoinEarnRules extends Message {
    public static final List<CoinEarnRule> DEFAULT_COIN_EARN_RULES = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Boolean DEFAULT_ONLY_SELECTED_CAN_EARN = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CoinEarnRule.class, tag = 3)
    public final List<CoinEarnRule> coin_earn_rules;
    @ProtoField(tag = 4)
    public final CoinGlobalRule coin_global_rule;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean only_selected_can_earn;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetCoinEarnRules(String str, Integer num, List<CoinEarnRule> list, CoinGlobalRule coinGlobalRule, Boolean bool) {
        this.requestid = str;
        this.errcode = num;
        this.coin_earn_rules = immutableCopyOf(list);
        this.coin_global_rule = coinGlobalRule;
        this.only_selected_can_earn = bool;
    }

    private ResponseGetCoinEarnRules(Builder builder) {
        this(builder.requestid, builder.errcode, builder.coin_earn_rules, builder.coin_global_rule, builder.only_selected_can_earn);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetCoinEarnRules)) {
            return false;
        }
        ResponseGetCoinEarnRules responseGetCoinEarnRules = (ResponseGetCoinEarnRules) obj;
        if (!equals((Object) this.requestid, (Object) responseGetCoinEarnRules.requestid) || !equals((Object) this.errcode, (Object) responseGetCoinEarnRules.errcode) || !equals((List<?>) this.coin_earn_rules, (List<?>) responseGetCoinEarnRules.coin_earn_rules) || !equals((Object) this.coin_global_rule, (Object) responseGetCoinEarnRules.coin_global_rule) || !equals((Object) this.only_selected_can_earn, (Object) responseGetCoinEarnRules.only_selected_can_earn)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<CoinEarnRule> list = this.coin_earn_rules;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        CoinGlobalRule coinGlobalRule = this.coin_global_rule;
        int hashCode4 = (hashCode3 + (coinGlobalRule != null ? coinGlobalRule.hashCode() : 0)) * 37;
        Boolean bool = this.only_selected_can_earn;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetCoinEarnRules> {
        public List<CoinEarnRule> coin_earn_rules;
        public CoinGlobalRule coin_global_rule;
        public Integer errcode;
        public Boolean only_selected_can_earn;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetCoinEarnRules responseGetCoinEarnRules) {
            super(responseGetCoinEarnRules);
            if (responseGetCoinEarnRules != null) {
                this.requestid = responseGetCoinEarnRules.requestid;
                this.errcode = responseGetCoinEarnRules.errcode;
                this.coin_earn_rules = ResponseGetCoinEarnRules.copyOf(responseGetCoinEarnRules.coin_earn_rules);
                this.coin_global_rule = responseGetCoinEarnRules.coin_global_rule;
                this.only_selected_can_earn = responseGetCoinEarnRules.only_selected_can_earn;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder coin_earn_rules(List<CoinEarnRule> list) {
            this.coin_earn_rules = checkForNulls(list);
            return this;
        }

        public Builder coin_global_rule(CoinGlobalRule coinGlobalRule) {
            this.coin_global_rule = coinGlobalRule;
            return this;
        }

        public Builder only_selected_can_earn(Boolean bool) {
            this.only_selected_can_earn = bool;
            return this;
        }

        public ResponseGetCoinEarnRules build() {
            return new ResponseGetCoinEarnRules(this);
        }
    }
}
