package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.BuyerAddress;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexBuyerAddress extends Message {
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final BuyerAddress buyer_address;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public SearchIndexBuyerAddress(BuyerAddress buyerAddress, Integer num) {
        this.buyer_address = buyerAddress;
        this.shopid = num;
    }

    private SearchIndexBuyerAddress(Builder builder) {
        this(builder.buyer_address, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexBuyerAddress)) {
            return false;
        }
        SearchIndexBuyerAddress searchIndexBuyerAddress = (SearchIndexBuyerAddress) obj;
        if (!equals((Object) this.buyer_address, (Object) searchIndexBuyerAddress.buyer_address) || !equals((Object) this.shopid, (Object) searchIndexBuyerAddress.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        BuyerAddress buyerAddress = this.buyer_address;
        int i2 = 0;
        int hashCode = (buyerAddress != null ? buyerAddress.hashCode() : 0) * 37;
        Integer num = this.shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexBuyerAddress> {
        public BuyerAddress buyer_address;
        public Integer shopid;

        public Builder() {
        }

        public Builder(SearchIndexBuyerAddress searchIndexBuyerAddress) {
            super(searchIndexBuyerAddress);
            if (searchIndexBuyerAddress != null) {
                this.buyer_address = searchIndexBuyerAddress.buyer_address;
                this.shopid = searchIndexBuyerAddress.shopid;
            }
        }

        public Builder buyer_address(BuyerAddress buyerAddress) {
            this.buyer_address = buyerAddress;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public SearchIndexBuyerAddress build() {
            return new SearchIndexBuyerAddress(this);
        }
    }
}
