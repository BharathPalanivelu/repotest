package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartPriceInfo extends Message {
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Integer DEFAULT_PERCENTAGE = 0;
    public static final Integer DEFAULT_RULEID = 0;
    public static final String DEFAULT_TITLE = "";
    public static final Long DEFAULT_VALUE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final CartPriceCondition condition;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer percentage;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer ruleid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long value;

    public CartPriceInfo(Integer num, Long l, Integer num2, CartPriceCondition cartPriceCondition, String str, String str2) {
        this.ruleid = num;
        this.value = l;
        this.percentage = num2;
        this.condition = cartPriceCondition;
        this.description = str;
        this.title = str2;
    }

    private CartPriceInfo(Builder builder) {
        this(builder.ruleid, builder.value, builder.percentage, builder.condition, builder.description, builder.title);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartPriceInfo)) {
            return false;
        }
        CartPriceInfo cartPriceInfo = (CartPriceInfo) obj;
        if (!equals((Object) this.ruleid, (Object) cartPriceInfo.ruleid) || !equals((Object) this.value, (Object) cartPriceInfo.value) || !equals((Object) this.percentage, (Object) cartPriceInfo.percentage) || !equals((Object) this.condition, (Object) cartPriceInfo.condition) || !equals((Object) this.description, (Object) cartPriceInfo.description) || !equals((Object) this.title, (Object) cartPriceInfo.title)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ruleid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.value;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.percentage;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        CartPriceCondition cartPriceCondition = this.condition;
        int hashCode4 = (hashCode3 + (cartPriceCondition != null ? cartPriceCondition.hashCode() : 0)) * 37;
        String str = this.description;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.title;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartPriceInfo> {
        public CartPriceCondition condition;
        public String description;
        public Integer percentage;
        public Integer ruleid;
        public String title;
        public Long value;

        public Builder() {
        }

        public Builder(CartPriceInfo cartPriceInfo) {
            super(cartPriceInfo);
            if (cartPriceInfo != null) {
                this.ruleid = cartPriceInfo.ruleid;
                this.value = cartPriceInfo.value;
                this.percentage = cartPriceInfo.percentage;
                this.condition = cartPriceInfo.condition;
                this.description = cartPriceInfo.description;
                this.title = cartPriceInfo.title;
            }
        }

        public Builder ruleid(Integer num) {
            this.ruleid = num;
            return this;
        }

        public Builder value(Long l) {
            this.value = l;
            return this;
        }

        public Builder percentage(Integer num) {
            this.percentage = num;
            return this;
        }

        public Builder condition(CartPriceCondition cartPriceCondition) {
            this.condition = cartPriceCondition;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public CartPriceInfo build() {
            return new CartPriceInfo(this);
        }
    }
}
