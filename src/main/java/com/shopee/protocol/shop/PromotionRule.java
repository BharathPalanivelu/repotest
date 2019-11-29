package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PromotionRule extends Message {
    public static final Integer DEFAULT_COMPARE = 0;
    public static final String DEFAULT_FIELD = "";
    public static final Integer DEFAULT_VALUE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer compare;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String field;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer value;

    public PromotionRule(String str, Integer num, Integer num2) {
        this.field = str;
        this.compare = num;
        this.value = num2;
    }

    private PromotionRule(Builder builder) {
        this(builder.field, builder.compare, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PromotionRule)) {
            return false;
        }
        PromotionRule promotionRule = (PromotionRule) obj;
        if (!equals((Object) this.field, (Object) promotionRule.field) || !equals((Object) this.compare, (Object) promotionRule.compare) || !equals((Object) this.value, (Object) promotionRule.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.field;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.compare;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.value;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PromotionRule> {
        public Integer compare;
        public String field;
        public Integer value;

        public Builder() {
        }

        public Builder(PromotionRule promotionRule) {
            super(promotionRule);
            if (promotionRule != null) {
                this.field = promotionRule.field;
                this.compare = promotionRule.compare;
                this.value = promotionRule.value;
            }
        }

        public Builder field(String str) {
            this.field = str;
            return this;
        }

        public Builder compare(Integer num) {
            this.compare = num;
            return this;
        }

        public Builder value(Integer num) {
            this.value = num;
            return this;
        }

        public PromotionRule build() {
            checkRequiredFields();
            return new PromotionRule(this);
        }
    }
}
