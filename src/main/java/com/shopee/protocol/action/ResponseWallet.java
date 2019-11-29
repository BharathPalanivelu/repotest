package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerWallet;
import com.shopee.protocol.shop.SellerWallet;
import com.shopee.protocol.shop.Wallet;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseWallet extends Message {
    public static final Boolean DEFAULT_ENABLED = false;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BuyerWallet buyer_wallet;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean enabled;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5)
    public final SellerWallet seller_wallet;
    @ProtoField(tag = 3)
    public final Wallet wallet;

    public ResponseWallet(String str, Integer num, Wallet wallet2, BuyerWallet buyerWallet, SellerWallet sellerWallet, Boolean bool) {
        this.requestid = str;
        this.errcode = num;
        this.wallet = wallet2;
        this.buyer_wallet = buyerWallet;
        this.seller_wallet = sellerWallet;
        this.enabled = bool;
    }

    private ResponseWallet(Builder builder) {
        this(builder.requestid, builder.errcode, builder.wallet, builder.buyer_wallet, builder.seller_wallet, builder.enabled);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseWallet)) {
            return false;
        }
        ResponseWallet responseWallet = (ResponseWallet) obj;
        if (!equals((Object) this.requestid, (Object) responseWallet.requestid) || !equals((Object) this.errcode, (Object) responseWallet.errcode) || !equals((Object) this.wallet, (Object) responseWallet.wallet) || !equals((Object) this.buyer_wallet, (Object) responseWallet.buyer_wallet) || !equals((Object) this.seller_wallet, (Object) responseWallet.seller_wallet) || !equals((Object) this.enabled, (Object) responseWallet.enabled)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Wallet wallet2 = this.wallet;
        int hashCode3 = (hashCode2 + (wallet2 != null ? wallet2.hashCode() : 0)) * 37;
        BuyerWallet buyerWallet = this.buyer_wallet;
        int hashCode4 = (hashCode3 + (buyerWallet != null ? buyerWallet.hashCode() : 0)) * 37;
        SellerWallet sellerWallet = this.seller_wallet;
        int hashCode5 = (hashCode4 + (sellerWallet != null ? sellerWallet.hashCode() : 0)) * 37;
        Boolean bool = this.enabled;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseWallet> {
        public BuyerWallet buyer_wallet;
        public Boolean enabled;
        public Integer errcode;
        public String requestid;
        public SellerWallet seller_wallet;
        public Wallet wallet;

        public Builder() {
        }

        public Builder(ResponseWallet responseWallet) {
            super(responseWallet);
            if (responseWallet != null) {
                this.requestid = responseWallet.requestid;
                this.errcode = responseWallet.errcode;
                this.wallet = responseWallet.wallet;
                this.buyer_wallet = responseWallet.buyer_wallet;
                this.seller_wallet = responseWallet.seller_wallet;
                this.enabled = responseWallet.enabled;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder wallet(Wallet wallet2) {
            this.wallet = wallet2;
            return this;
        }

        public Builder buyer_wallet(BuyerWallet buyerWallet) {
            this.buyer_wallet = buyerWallet;
            return this;
        }

        public Builder seller_wallet(SellerWallet sellerWallet) {
            this.seller_wallet = sellerWallet;
            return this;
        }

        public Builder enabled(Boolean bool) {
            this.enabled = bool;
            return this;
        }

        public ResponseWallet build() {
            return new ResponseWallet(this);
        }
    }
}
