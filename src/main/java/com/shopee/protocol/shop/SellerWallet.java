package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SellerWallet extends Message {
    public static final Long DEFAULT_AVAILABLE = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_OUTGOING = 0L;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_WALLET_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long available;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long outgoing;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer wallet_id;

    public SellerWallet(Integer num, Integer num2, Long l, Long l2, Integer num3) {
        this.wallet_id = num;
        this.userid = num2;
        this.available = l;
        this.outgoing = l2;
        this.mtime = num3;
    }

    private SellerWallet(Builder builder) {
        this(builder.wallet_id, builder.userid, builder.available, builder.outgoing, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerWallet)) {
            return false;
        }
        SellerWallet sellerWallet = (SellerWallet) obj;
        if (!equals((Object) this.wallet_id, (Object) sellerWallet.wallet_id) || !equals((Object) this.userid, (Object) sellerWallet.userid) || !equals((Object) this.available, (Object) sellerWallet.available) || !equals((Object) this.outgoing, (Object) sellerWallet.outgoing) || !equals((Object) this.mtime, (Object) sellerWallet.mtime)) {
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
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerWallet> {
        public Long available;
        public Integer mtime;
        public Long outgoing;
        public Integer userid;
        public Integer wallet_id;

        public Builder() {
        }

        public Builder(SellerWallet sellerWallet) {
            super(sellerWallet);
            if (sellerWallet != null) {
                this.wallet_id = sellerWallet.wallet_id;
                this.userid = sellerWallet.userid;
                this.available = sellerWallet.available;
                this.outgoing = sellerWallet.outgoing;
                this.mtime = sellerWallet.mtime;
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

        public SellerWallet build() {
            return new SellerWallet(this);
        }
    }
}
