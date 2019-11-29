package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CartGetAllOrders extends Message {
    public static final Boolean DEFAULT_CHECKOUT_TRUE_ONLY = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_REQUEST_FROM_CART = false;
    public static final List<ShopItemId> DEFAULT_SELECTED_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean checkout_true_only;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean request_from_cart;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopItemId.class, tag = 6)
    public final List<ShopItemId> selected_items;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public CartGetAllOrders(String str, String str2, Integer num, Boolean bool, Boolean bool2, List<ShopItemId> list) {
        this.requestid = str;
        this.token = str2;
        this.shopid = num;
        this.checkout_true_only = bool;
        this.request_from_cart = bool2;
        this.selected_items = immutableCopyOf(list);
    }

    private CartGetAllOrders(Builder builder) {
        this(builder.requestid, builder.token, builder.shopid, builder.checkout_true_only, builder.request_from_cart, builder.selected_items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartGetAllOrders)) {
            return false;
        }
        CartGetAllOrders cartGetAllOrders = (CartGetAllOrders) obj;
        if (!equals((Object) this.requestid, (Object) cartGetAllOrders.requestid) || !equals((Object) this.token, (Object) cartGetAllOrders.token) || !equals((Object) this.shopid, (Object) cartGetAllOrders.shopid) || !equals((Object) this.checkout_true_only, (Object) cartGetAllOrders.checkout_true_only) || !equals((Object) this.request_from_cart, (Object) cartGetAllOrders.request_from_cart) || !equals((List<?>) this.selected_items, (List<?>) cartGetAllOrders.selected_items)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.checkout_true_only;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.request_from_cart;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = (hashCode4 + i2) * 37;
        List<ShopItemId> list = this.selected_items;
        int hashCode5 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    public static final class Builder extends Message.Builder<CartGetAllOrders> {
        public Boolean checkout_true_only;
        public Boolean request_from_cart;
        public String requestid;
        public List<ShopItemId> selected_items;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(CartGetAllOrders cartGetAllOrders) {
            super(cartGetAllOrders);
            if (cartGetAllOrders != null) {
                this.requestid = cartGetAllOrders.requestid;
                this.token = cartGetAllOrders.token;
                this.shopid = cartGetAllOrders.shopid;
                this.checkout_true_only = cartGetAllOrders.checkout_true_only;
                this.request_from_cart = cartGetAllOrders.request_from_cart;
                this.selected_items = CartGetAllOrders.copyOf(cartGetAllOrders.selected_items);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder checkout_true_only(Boolean bool) {
            this.checkout_true_only = bool;
            return this;
        }

        public Builder request_from_cart(Boolean bool) {
            this.request_from_cart = bool;
            return this;
        }

        public Builder selected_items(List<ShopItemId> list) {
            this.selected_items = checkForNulls(list);
            return this;
        }

        public CartGetAllOrders build() {
            return new CartGetAllOrders(this);
        }
    }
}
