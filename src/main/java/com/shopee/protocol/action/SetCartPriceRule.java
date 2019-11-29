package com.shopee.protocol.action;

import com.shopee.protocol.shop.CartPriceRule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetCartPriceRule extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2)
    public final CartPriceRule rule;

    public SetCartPriceRule(String str, CartPriceRule cartPriceRule) {
        this.requestid = str;
        this.rule = cartPriceRule;
    }

    private SetCartPriceRule(Builder builder) {
        this(builder.requestid, builder.rule);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCartPriceRule)) {
            return false;
        }
        SetCartPriceRule setCartPriceRule = (SetCartPriceRule) obj;
        if (!equals((Object) this.requestid, (Object) setCartPriceRule.requestid) || !equals((Object) this.rule, (Object) setCartPriceRule.rule)) {
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
        CartPriceRule cartPriceRule = this.rule;
        if (cartPriceRule != null) {
            i2 = cartPriceRule.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetCartPriceRule> {
        public String requestid;
        public CartPriceRule rule;

        public Builder() {
        }

        public Builder(SetCartPriceRule setCartPriceRule) {
            super(setCartPriceRule);
            if (setCartPriceRule != null) {
                this.requestid = setCartPriceRule.requestid;
                this.rule = setCartPriceRule.rule;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder rule(CartPriceRule cartPriceRule) {
            this.rule = cartPriceRule;
            return this;
        }

        public SetCartPriceRule build() {
            return new SetCartPriceRule(this);
        }
    }
}
