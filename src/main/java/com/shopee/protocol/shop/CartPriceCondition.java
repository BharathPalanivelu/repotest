package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartPriceCondition extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final CartPriceRuleOperator credit_banks;

    public CartPriceCondition(CartPriceRuleOperator cartPriceRuleOperator) {
        this.credit_banks = cartPriceRuleOperator;
    }

    private CartPriceCondition(Builder builder) {
        this(builder.credit_banks);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartPriceCondition)) {
            return false;
        }
        return equals((Object) this.credit_banks, (Object) ((CartPriceCondition) obj).credit_banks);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            CartPriceRuleOperator cartPriceRuleOperator = this.credit_banks;
            i = cartPriceRuleOperator != null ? cartPriceRuleOperator.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CartPriceCondition> {
        public CartPriceRuleOperator credit_banks;

        public Builder() {
        }

        public Builder(CartPriceCondition cartPriceCondition) {
            super(cartPriceCondition);
            if (cartPriceCondition != null) {
                this.credit_banks = cartPriceCondition.credit_banks;
            }
        }

        public Builder credit_banks(CartPriceRuleOperator cartPriceRuleOperator) {
            this.credit_banks = cartPriceRuleOperator;
            return this;
        }

        public CartPriceCondition build() {
            return new CartPriceCondition(this);
        }
    }
}
