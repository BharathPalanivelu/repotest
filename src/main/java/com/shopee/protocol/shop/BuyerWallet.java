package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BuyerWallet extends Message {
    public static final Long DEFAULT_AVAILABLE = 0L;
    public static final Integer DEFAULT_CASHBACK = 0;
    public static final Integer DEFAULT_DEPOSIT = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_OUTGOING = 0L;
    public static final Integer DEFAULT_REFUND = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_WALLET_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long available;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer cashback;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer deposit;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long outgoing;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer refund;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer wallet_id;

    public BuyerWallet(Integer num, Integer num2, Long l, Long l2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.wallet_id = num;
        this.userid = num2;
        this.available = l;
        this.outgoing = l2;
        this.mtime = num3;
        this.cashback = num4;
        this.deposit = num5;
        this.refund = num6;
    }

    private BuyerWallet(Builder builder) {
        this(builder.wallet_id, builder.userid, builder.available, builder.outgoing, builder.mtime, builder.cashback, builder.deposit, builder.refund);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyerWallet)) {
            return false;
        }
        BuyerWallet buyerWallet = (BuyerWallet) obj;
        if (!equals((Object) this.wallet_id, (Object) buyerWallet.wallet_id) || !equals((Object) this.userid, (Object) buyerWallet.userid) || !equals((Object) this.available, (Object) buyerWallet.available) || !equals((Object) this.outgoing, (Object) buyerWallet.outgoing) || !equals((Object) this.mtime, (Object) buyerWallet.mtime) || !equals((Object) this.cashback, (Object) buyerWallet.cashback) || !equals((Object) this.deposit, (Object) buyerWallet.deposit) || !equals((Object) this.refund, (Object) buyerWallet.refund)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.wallet_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.available;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.outgoing;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.cashback;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.deposit;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.refund;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BuyerWallet> {
        public Long available;
        public Integer cashback;
        public Integer deposit;
        public Integer mtime;
        public Long outgoing;
        public Integer refund;
        public Integer userid;
        public Integer wallet_id;

        public Builder() {
        }

        public Builder(BuyerWallet buyerWallet) {
            super(buyerWallet);
            if (buyerWallet != null) {
                this.wallet_id = buyerWallet.wallet_id;
                this.userid = buyerWallet.userid;
                this.available = buyerWallet.available;
                this.outgoing = buyerWallet.outgoing;
                this.mtime = buyerWallet.mtime;
                this.cashback = buyerWallet.cashback;
                this.deposit = buyerWallet.deposit;
                this.refund = buyerWallet.refund;
            }
        }

        public Builder wallet_id(Integer num) {
            this.wallet_id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder available(Long l) {
            this.available = l;
            return this;
        }

        public Builder outgoing(Long l) {
            this.outgoing = l;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder cashback(Integer num) {
            this.cashback = num;
            return this;
        }

        public Builder deposit(Integer num) {
            this.deposit = num;
            return this;
        }

        public Builder refund(Integer num) {
            this.refund = num;
            return this;
        }

        public BuyerWallet build() {
            return new BuyerWallet(this);
        }
    }
}
