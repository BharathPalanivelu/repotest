package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartPriceRuleAudit extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_RULEID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USAGE_TIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ruleid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer usage_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public CartPriceRuleAudit(Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5) {
        this.id = num;
        this.userid = num2;
        this.checkoutid = l;
        this.ruleid = num3;
        this.usage_time = num4;
        this.status = num5;
    }

    private CartPriceRuleAudit(Builder builder) {
        this(builder.id, builder.userid, builder.checkoutid, builder.ruleid, builder.usage_time, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartPriceRuleAudit)) {
            return false;
        }
        CartPriceRuleAudit cartPriceRuleAudit = (CartPriceRuleAudit) obj;
        if (!equals((Object) this.id, (Object) cartPriceRuleAudit.id) || !equals((Object) this.userid, (Object) cartPriceRuleAudit.userid) || !equals((Object) this.checkoutid, (Object) cartPriceRuleAudit.checkoutid) || !equals((Object) this.ruleid, (Object) cartPriceRuleAudit.ruleid) || !equals((Object) this.usage_time, (Object) cartPriceRuleAudit.usage_time) || !equals((Object) this.status, (Object) cartPriceRuleAudit.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.checkoutid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.ruleid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.usage_time;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartPriceRuleAudit> {
        public Long checkoutid;
        public Integer id;
        public Integer ruleid;
        public Integer status;
        public Integer usage_time;
        public Integer userid;

        public Builder() {
        }

        public Builder(CartPriceRuleAudit cartPriceRuleAudit) {
            super(cartPriceRuleAudit);
            if (cartPriceRuleAudit != null) {
                this.id = cartPriceRuleAudit.id;
                this.userid = cartPriceRuleAudit.userid;
                this.checkoutid = cartPriceRuleAudit.checkoutid;
                this.ruleid = cartPriceRuleAudit.ruleid;
                this.usage_time = cartPriceRuleAudit.usage_time;
                this.status = cartPriceRuleAudit.status;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder ruleid(Integer num) {
            this.ruleid = num;
            return this;
        }

        public Builder usage_time(Integer num) {
            this.usage_time = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public CartPriceRuleAudit build() {
            return new CartPriceRuleAudit(this);
        }
    }
}
