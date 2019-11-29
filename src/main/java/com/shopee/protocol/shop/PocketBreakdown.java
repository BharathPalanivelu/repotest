package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PocketBreakdown extends Message {
    public static final Long DEFAULT_NEW_CASHBACK = 0L;
    public static final Long DEFAULT_NEW_DEPOSIT = 0L;
    public static final Long DEFAULT_NEW_REFUND = 0L;
    public static final Long DEFAULT_OLD_CASHBACK = 0L;
    public static final Long DEFAULT_OLD_DEPOSIT = 0L;
    public static final Long DEFAULT_OLD_REFUND = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long new_cashback;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long new_deposit;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long new_refund;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long old_cashback;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long old_deposit;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long old_refund;

    public PocketBreakdown(Long l, Long l2, Long l3, Long l4, Long l5, Long l6) {
        this.old_cashback = l;
        this.new_cashback = l2;
        this.old_deposit = l3;
        this.new_deposit = l4;
        this.old_refund = l5;
        this.new_refund = l6;
    }

    private PocketBreakdown(Builder builder) {
        this(builder.old_cashback, builder.new_cashback, builder.old_deposit, builder.new_deposit, builder.old_refund, builder.new_refund);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PocketBreakdown)) {
            return false;
        }
        PocketBreakdown pocketBreakdown = (PocketBreakdown) obj;
        if (!equals((Object) this.old_cashback, (Object) pocketBreakdown.old_cashback) || !equals((Object) this.new_cashback, (Object) pocketBreakdown.new_cashback) || !equals((Object) this.old_deposit, (Object) pocketBreakdown.old_deposit) || !equals((Object) this.new_deposit, (Object) pocketBreakdown.new_deposit) || !equals((Object) this.old_refund, (Object) pocketBreakdown.old_refund) || !equals((Object) this.new_refund, (Object) pocketBreakdown.new_refund)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.old_cashback;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.new_cashback;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.old_deposit;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.new_deposit;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.old_refund;
        int hashCode5 = (hashCode4 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.new_refund;
        if (l6 != null) {
            i2 = l6.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PocketBreakdown> {
        public Long new_cashback;
        public Long new_deposit;
        public Long new_refund;
        public Long old_cashback;
        public Long old_deposit;
        public Long old_refund;

        public Builder() {
        }

        public Builder(PocketBreakdown pocketBreakdown) {
            super(pocketBreakdown);
            if (pocketBreakdown != null) {
                this.old_cashback = pocketBreakdown.old_cashback;
                this.new_cashback = pocketBreakdown.new_cashback;
                this.old_deposit = pocketBreakdown.old_deposit;
                this.new_deposit = pocketBreakdown.new_deposit;
                this.old_refund = pocketBreakdown.old_refund;
                this.new_refund = pocketBreakdown.new_refund;
            }
        }

        public Builder old_cashback(Long l) {
            this.old_cashback = l;
            return this;
        }

        public Builder new_cashback(Long l) {
            this.new_cashback = l;
            return this;
        }

        public Builder old_deposit(Long l) {
            this.old_deposit = l;
            return this;
        }

        public Builder new_deposit(Long l) {
            this.new_deposit = l;
            return this;
        }

        public Builder old_refund(Long l) {
            this.old_refund = l;
            return this;
        }

        public Builder new_refund(Long l) {
            this.new_refund = l;
            return this;
        }

        public PocketBreakdown build() {
            return new PocketBreakdown(this);
        }
    }
}
