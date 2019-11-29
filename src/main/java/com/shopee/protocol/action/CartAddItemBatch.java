package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CartAddItemBatch extends Message {
    public static final List<CartItemInfo> DEFAULT_CHECKOUT_TRUE_ITEMINFO_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final List<CartGroup> DEFAULT_RESET_GROUPS = Collections.emptyList();
    public static final List<ShopOrder> DEFAULT_SHOPORDERS = Collections.emptyList();
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CartItemInfo.class, tag = 5)
    public final List<CartItemInfo> checkout_true_iteminfo_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = CartGroup.class, tag = 6)
    public final List<CartGroup> reset_groups;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopOrder.class, tag = 3)
    public final List<ShopOrder> shoporders;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public CartAddItemBatch(String str, List<ShopOrder> list, String str2, List<CartItemInfo> list2, List<CartGroup> list3) {
        this.requestid = str;
        this.shoporders = immutableCopyOf(list);
        this.token = str2;
        this.checkout_true_iteminfo_list = immutableCopyOf(list2);
        this.reset_groups = immutableCopyOf(list3);
    }

    private CartAddItemBatch(Builder builder) {
        this(builder.requestid, builder.shoporders, builder.token, builder.checkout_true_iteminfo_list, builder.reset_groups);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartAddItemBatch)) {
            return false;
        }
        CartAddItemBatch cartAddItemBatch = (CartAddItemBatch) obj;
        if (!equals((Object) this.requestid, (Object) cartAddItemBatch.requestid) || !equals((List<?>) this.shoporders, (List<?>) cartAddItemBatch.shoporders) || !equals((Object) this.token, (Object) cartAddItemBatch.token) || !equals((List<?>) this.checkout_true_iteminfo_list, (List<?>) cartAddItemBatch.checkout_true_iteminfo_list) || !equals((List<?>) this.reset_groups, (List<?>) cartAddItemBatch.reset_groups)) {
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
        List<ShopOrder> list = this.shoporders;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i4 = (hashCode2 + i2) * 37;
        List<CartItemInfo> list2 = this.checkout_true_iteminfo_list;
        int hashCode3 = (i4 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<CartGroup> list3 = this.reset_groups;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i5 = hashCode3 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<CartAddItemBatch> {
        public List<CartItemInfo> checkout_true_iteminfo_list;
        public String requestid;
        public List<CartGroup> reset_groups;
        public List<ShopOrder> shoporders;
        public String token;

        public Builder() {
        }

        public Builder(CartAddItemBatch cartAddItemBatch) {
            super(cartAddItemBatch);
            if (cartAddItemBatch != null) {
                this.requestid = cartAddItemBatch.requestid;
                this.shoporders = CartAddItemBatch.copyOf(cartAddItemBatch.shoporders);
                this.token = cartAddItemBatch.token;
                this.checkout_true_iteminfo_list = CartAddItemBatch.copyOf(cartAddItemBatch.checkout_true_iteminfo_list);
                this.reset_groups = CartAddItemBatch.copyOf(cartAddItemBatch.reset_groups);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shoporders(List<ShopOrder> list) {
            this.shoporders = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder checkout_true_iteminfo_list(List<CartItemInfo> list) {
            this.checkout_true_iteminfo_list = checkForNulls(list);
            return this;
        }

        public Builder reset_groups(List<CartGroup> list) {
            this.reset_groups = checkForNulls(list);
            return this;
        }

        public CartAddItemBatch build() {
            return new CartAddItemBatch(this);
        }
    }
}
