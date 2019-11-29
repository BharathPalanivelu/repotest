package com.shopee.protocol.action;

import com.shopee.protocol.shop.CartPriceRule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RespCartPriceRuleList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<CartPriceRule> DEFAULT_RULES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = CartPriceRule.class, tag = 3)
    public final List<CartPriceRule> rules;

    public RespCartPriceRuleList(String str, Integer num, List<CartPriceRule> list) {
        this.requestid = str;
        this.errcode = num;
        this.rules = immutableCopyOf(list);
    }

    private RespCartPriceRuleList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.rules);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RespCartPriceRuleList)) {
            return false;
        }
        RespCartPriceRuleList respCartPriceRuleList = (RespCartPriceRuleList) obj;
        if (!equals((Object) this.requestid, (Object) respCartPriceRuleList.requestid) || !equals((Object) this.errcode, (Object) respCartPriceRuleList.errcode) || !equals((List<?>) this.rules, (List<?>) respCartPriceRuleList.rules)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<CartPriceRule> list = this.rules;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<RespCartPriceRuleList> {
        public Integer errcode;
        public String requestid;
        public List<CartPriceRule> rules;

        public Builder() {
        }

        public Builder(RespCartPriceRuleList respCartPriceRuleList) {
            super(respCartPriceRuleList);
            if (respCartPriceRuleList != null) {
                this.requestid = respCartPriceRuleList.requestid;
                this.errcode = respCartPriceRuleList.errcode;
                this.rules = RespCartPriceRuleList.copyOf(respCartPriceRuleList.rules);
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

        public Builder rules(List<CartPriceRule> list) {
            this.rules = checkForNulls(list);
            return this;
        }

        public RespCartPriceRuleList build() {
            checkRequiredFields();
            return new RespCartPriceRuleList(this);
        }
    }
}
