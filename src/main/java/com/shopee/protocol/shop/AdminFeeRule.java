package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdminFeeRule extends Message {
    public static final Long DEFAULT_CAP = 0L;
    public static final Long DEFAULT_FIXED = 0L;
    public static final Long DEFAULT_MIN_FEE = 0L;
    public static final Long DEFAULT_RATE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long cap;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long fixed;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long min_fee;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long rate;

    public AdminFeeRule(Long l, Long l2, Long l3, Long l4) {
        this.cap = l;
        this.min_fee = l2;
        this.rate = l3;
        this.fixed = l4;
    }

    private AdminFeeRule(Builder builder) {
        this(builder.cap, builder.min_fee, builder.rate, builder.fixed);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdminFeeRule)) {
            return false;
        }
        AdminFeeRule adminFeeRule = (AdminFeeRule) obj;
        if (!equals((Object) this.cap, (Object) adminFeeRule.cap) || !equals((Object) this.min_fee, (Object) adminFeeRule.min_fee) || !equals((Object) this.rate, (Object) adminFeeRule.rate) || !equals((Object) this.fixed, (Object) adminFeeRule.fixed)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.cap;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.min_fee;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.rate;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.fixed;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdminFeeRule> {
        public Long cap;
        public Long fixed;
        public Long min_fee;
        public Long rate;

        public Builder() {
        }

        public Builder(AdminFeeRule adminFeeRule) {
            super(adminFeeRule);
            if (adminFeeRule != null) {
                this.cap = adminFeeRule.cap;
                this.min_fee = adminFeeRule.min_fee;
                this.rate = adminFeeRule.rate;
                this.fixed = adminFeeRule.fixed;
            }
        }

        public Builder cap(Long l) {
            this.cap = l;
            return this;
        }

        public Builder min_fee(Long l) {
            this.min_fee = l;
            return this;
        }

        public Builder rate(Long l) {
            this.rate = l;
            return this;
        }

        public Builder fixed(Long l) {
            this.fixed = l;
            return this;
        }

        public AdminFeeRule build() {
            return new AdminFeeRule(this);
        }
    }
}
