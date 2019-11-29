package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopEscrowPaymentOptionList extends Message {
    public static final List<ShopEscrowPaymentOption> DEFAULT_OPTIONS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopEscrowPaymentOption.class, tag = 1)
    public final List<ShopEscrowPaymentOption> options;

    public ShopEscrowPaymentOptionList(List<ShopEscrowPaymentOption> list) {
        this.options = immutableCopyOf(list);
    }

    private ShopEscrowPaymentOptionList(Builder builder) {
        this(builder.options);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopEscrowPaymentOptionList)) {
            return false;
        }
        return equals((List<?>) this.options, (List<?>) ((ShopEscrowPaymentOptionList) obj).options);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ShopEscrowPaymentOption> list = this.options;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ShopEscrowPaymentOptionList> {
        public List<ShopEscrowPaymentOption> options;

        public Builder() {
        }

        public Builder(ShopEscrowPaymentOptionList shopEscrowPaymentOptionList) {
            super(shopEscrowPaymentOptionList);
            if (shopEscrowPaymentOptionList != null) {
                this.options = ShopEscrowPaymentOptionList.copyOf(shopEscrowPaymentOptionList.options);
            }
        }

        public Builder options(List<ShopEscrowPaymentOption> list) {
            this.options = checkForNulls(list);
            return this;
        }

        public ShopEscrowPaymentOptionList build() {
            return new ShopEscrowPaymentOptionList(this);
        }
    }
}
