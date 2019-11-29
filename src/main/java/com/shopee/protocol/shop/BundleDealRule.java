package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BundleDealRule extends Message {
    public static final Long DEFAULT_DISCOUNT_PERCENTAGE = 0L;
    public static final Long DEFAULT_DISCOUNT_VALUE = 0L;
    public static final Long DEFAULT_FIX_PRICE = 0L;
    public static final Integer DEFAULT_MIN_AMOUNT = 0;
    public static final Integer DEFAULT_RULE_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long discount_percentage;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long discount_value;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long fix_price;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer min_amount;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_type;

    public BundleDealRule(Integer num, Integer num2, Long l, Long l2, Long l3) {
        this.rule_type = num;
        this.min_amount = num2;
        this.fix_price = l;
        this.discount_percentage = l2;
        this.discount_value = l3;
    }

    private BundleDealRule(Builder builder) {
        this(builder.rule_type, builder.min_amount, builder.fix_price, builder.discount_percentage, builder.discount_value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundleDealRule)) {
            return false;
        }
        BundleDealRule bundleDealRule = (BundleDealRule) obj;
        if (!equals((Object) this.rule_type, (Object) bundleDealRule.rule_type) || !equals((Object) this.min_amount, (Object) bundleDealRule.min_amount) || !equals((Object) this.fix_price, (Object) bundleDealRule.fix_price) || !equals((Object) this.discount_percentage, (Object) bundleDealRule.discount_percentage) || !equals((Object) this.discount_value, (Object) bundleDealRule.discount_value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.rule_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.min_amount;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.fix_price;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.discount_percentage;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.discount_value;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BundleDealRule> {
        public Long discount_percentage;
        public Long discount_value;
        public Long fix_price;
        public Integer min_amount;
        public Integer rule_type;

        public Builder() {
        }

        public Builder(BundleDealRule bundleDealRule) {
            super(bundleDealRule);
            if (bundleDealRule != null) {
                this.rule_type = bundleDealRule.rule_type;
                this.min_amount = bundleDealRule.min_amount;
                this.fix_price = bundleDealRule.fix_price;
                this.discount_percentage = bundleDealRule.discount_percentage;
                this.discount_value = bundleDealRule.discount_value;
            }
        }

        public Builder rule_type(Integer num) {
            this.rule_type = num;
            return this;
        }

        public Builder min_amount(Integer num) {
            this.min_amount = num;
            return this;
        }

        public Builder fix_price(Long l) {
            this.fix_price = l;
            return this;
        }

        public Builder discount_percentage(Long l) {
            this.discount_percentage = l;
            return this;
        }

        public Builder discount_value(Long l) {
            this.discount_value = l;
            return this;
        }

        public BundleDealRule build() {
            return new BundleDealRule(this);
        }
    }
}
