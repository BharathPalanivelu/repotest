package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.BuyerAddress;
import com.shopee.protocol.shop.Shop;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexShop extends Message {
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final Account account;
    @ProtoField(tag = 3)
    public final BuyerAddress buyer_address;
    @ProtoField(tag = 2)
    public final Shop shop;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public SearchIndexShop(Integer num, Shop shop2, BuyerAddress buyerAddress, Account account2) {
        this.shopid = num;
        this.shop = shop2;
        this.buyer_address = buyerAddress;
        this.account = account2;
    }

    private SearchIndexShop(Builder builder) {
        this(builder.shopid, builder.shop, builder.buyer_address, builder.account);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexShop)) {
            return false;
        }
        SearchIndexShop searchIndexShop = (SearchIndexShop) obj;
        if (!equals((Object) this.shopid, (Object) searchIndexShop.shopid) || !equals((Object) this.shop, (Object) searchIndexShop.shop) || !equals((Object) this.buyer_address, (Object) searchIndexShop.buyer_address) || !equals((Object) this.account, (Object) searchIndexShop.account)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Shop shop2 = this.shop;
        int hashCode2 = (hashCode + (shop2 != null ? shop2.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress = this.buyer_address;
        int hashCode3 = (hashCode2 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        Account account2 = this.account;
        if (account2 != null) {
            i2 = account2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexShop> {
        public Account account;
        public BuyerAddress buyer_address;
        public Shop shop;
        public Integer shopid;

        public Builder() {
        }

        public Builder(SearchIndexShop searchIndexShop) {
            super(searchIndexShop);
            if (searchIndexShop != null) {
                this.shopid = searchIndexShop.shopid;
                this.shop = searchIndexShop.shop;
                this.buyer_address = searchIndexShop.buyer_address;
                this.account = searchIndexShop.account;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder shop(Shop shop2) {
            this.shop = shop2;
            return this;
        }

        public Builder buyer_address(BuyerAddress buyerAddress) {
            this.buyer_address = buyerAddress;
            return this;
        }

        public Builder account(Account account2) {
            this.account = account2;
            return this;
        }

        public SearchIndexShop build() {
            return new SearchIndexShop(this);
        }
    }
}
