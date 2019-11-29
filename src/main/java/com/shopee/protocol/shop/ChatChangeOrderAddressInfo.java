package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatChangeOrderAddressInfo extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BuyerAddress buyer_address;
    @ProtoField(tag = 1)
    public final ChatOrderInfo order_info;

    public ChatChangeOrderAddressInfo(ChatOrderInfo chatOrderInfo, BuyerAddress buyerAddress) {
        this.order_info = chatOrderInfo;
        this.buyer_address = buyerAddress;
    }

    private ChatChangeOrderAddressInfo(Builder builder) {
        this(builder.order_info, builder.buyer_address);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatChangeOrderAddressInfo)) {
            return false;
        }
        ChatChangeOrderAddressInfo chatChangeOrderAddressInfo = (ChatChangeOrderAddressInfo) obj;
        if (!equals((Object) this.order_info, (Object) chatChangeOrderAddressInfo.order_info) || !equals((Object) this.buyer_address, (Object) chatChangeOrderAddressInfo.buyer_address)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ChatOrderInfo chatOrderInfo = this.order_info;
        int i2 = 0;
        int hashCode = (chatOrderInfo != null ? chatOrderInfo.hashCode() : 0) * 37;
        BuyerAddress buyerAddress = this.buyer_address;
        if (buyerAddress != null) {
            i2 = buyerAddress.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatChangeOrderAddressInfo> {
        public BuyerAddress buyer_address;
        public ChatOrderInfo order_info;

        public Builder() {
        }

        public Builder(ChatChangeOrderAddressInfo chatChangeOrderAddressInfo) {
            super(chatChangeOrderAddressInfo);
            if (chatChangeOrderAddressInfo != null) {
                this.order_info = chatChangeOrderAddressInfo.order_info;
                this.buyer_address = chatChangeOrderAddressInfo.buyer_address;
            }
        }

        public Builder order_info(ChatOrderInfo chatOrderInfo) {
            this.order_info = chatOrderInfo;
            return this;
        }

        public Builder buyer_address(BuyerAddress buyerAddress) {
            this.buyer_address = buyerAddress;
            return this;
        }

        public ChatChangeOrderAddressInfo build() {
            return new ChatChangeOrderAddressInfo(this);
        }
    }
}
