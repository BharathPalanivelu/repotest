package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CartPriceRuleOperator extends Message {
    public static final Integer DEFAULT_OPERATOR = 0;
    public static final Integer DEFAULT_VALUE = 0;
    public static final List<Integer> DEFAULT_VALUE_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer operator;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer value;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> value_list;

    public CartPriceRuleOperator(Integer num, List<Integer> list, Integer num2) {
        this.operator = num;
        this.value_list = immutableCopyOf(list);
        this.value = num2;
    }

    private CartPriceRuleOperator(Builder builder) {
        this(builder.operator, builder.value_list, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartPriceRuleOperator)) {
            return false;
        }
        CartPriceRuleOperator cartPriceRuleOperator = (CartPriceRuleOperator) obj;
        if (!equals((Object) this.operator, (Object) cartPriceRuleOperator.operator) || !equals((List<?>) this.value_list, (List<?>) cartPriceRuleOperator.value_list) || !equals((Object) this.value, (Object) cartPriceRuleOperator.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.operator;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<Integer> list = this.value_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.value;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartPriceRuleOperator> {
        public Integer operator;
        public Integer value;
        public List<Integer> value_list;

        public Builder() {
        }

        public Builder(CartPriceRuleOperator cartPriceRuleOperator) {
            super(cartPriceRuleOperator);
            if (cartPriceRuleOperator != null) {
                this.operator = cartPriceRuleOperator.operator;
                this.value_list = CartPriceRuleOperator.copyOf(cartPriceRuleOperator.value_list);
                this.value = cartPriceRuleOperator.value;
            }
        }

        public Builder operator(Integer num) {
            this.operator = num;
            return this;
        }

        public Builder value_list(List<Integer> list) {
            this.value_list = checkForNulls(list);
            return this;
        }

        public Builder value(Integer num) {
            this.value = num;
            return this;
        }

        public CartPriceRuleOperator build() {
            return new CartPriceRuleOperator(this);
        }
    }
}
