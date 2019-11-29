package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CartRemoveItem extends Message {
    public static final List<CartRemoveItemInfo> DEFAULT_BATCH_CART_ITEM = Collections.emptyList();
    public static final List<ShopItemId> DEFAULT_BATCH_ITEM = Collections.emptyList();
    public static final Boolean DEFAULT_CLEAN_WELCOME_PACKAGE = false;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_GROUP_ID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CartRemoveItemInfo.class, tag = 10)
    public final List<CartRemoveItemInfo> batch_cart_item;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopItemId.class, tag = 6)
    public final List<ShopItemId> batch_item;
    @ProtoField(tag = 7)
    public final BackendParam bparam;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean clean_welcome_package;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long item_group_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public CartRemoveItem(String str, Integer num, Long l, String str2, Long l2, List<ShopItemId> list, BackendParam backendParam, Boolean bool, Long l3, List<CartRemoveItemInfo> list2) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.token = str2;
        this.modelid = l2;
        this.batch_item = immutableCopyOf(list);
        this.bparam = backendParam;
        this.clean_welcome_package = bool;
        this.item_group_id = l3;
        this.batch_cart_item = immutableCopyOf(list2);
    }

    private CartRemoveItem(Builder builder) {
        this(builder.requestid, builder.shopid, builder.itemid, builder.token, builder.modelid, builder.batch_item, builder.bparam, builder.clean_welcome_package, builder.item_group_id, builder.batch_cart_item);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartRemoveItem)) {
            return false;
        }
        CartRemoveItem cartRemoveItem = (CartRemoveItem) obj;
        if (!equals((Object) this.requestid, (Object) cartRemoveItem.requestid) || !equals((Object) this.shopid, (Object) cartRemoveItem.shopid) || !equals((Object) this.itemid, (Object) cartRemoveItem.itemid) || !equals((Object) this.token, (Object) cartRemoveItem.token) || !equals((Object) this.modelid, (Object) cartRemoveItem.modelid) || !equals((List<?>) this.batch_item, (List<?>) cartRemoveItem.batch_item) || !equals((Object) this.bparam, (Object) cartRemoveItem.bparam) || !equals((Object) this.clean_welcome_package, (Object) cartRemoveItem.clean_welcome_package) || !equals((Object) this.item_group_id, (Object) cartRemoveItem.item_group_id) || !equals((List<?>) this.batch_cart_item, (List<?>) cartRemoveItem.batch_cart_item)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<ShopItemId> list = this.batch_item;
        int i3 = 1;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode7 = (hashCode6 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Boolean bool = this.clean_welcome_package;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l3 = this.item_group_id;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i4 = (hashCode8 + i2) * 37;
        List<CartRemoveItemInfo> list2 = this.batch_cart_item;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<CartRemoveItem> {
        public List<CartRemoveItemInfo> batch_cart_item;
        public List<ShopItemId> batch_item;
        public BackendParam bparam;
        public Boolean clean_welcome_package;
        public Long item_group_id;
        public Long itemid;
        public Long modelid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(CartRemoveItem cartRemoveItem) {
            super(cartRemoveItem);
            if (cartRemoveItem != null) {
                this.requestid = cartRemoveItem.requestid;
                this.shopid = cartRemoveItem.shopid;
                this.itemid = cartRemoveItem.itemid;
                this.token = cartRemoveItem.token;
                this.modelid = cartRemoveItem.modelid;
                this.batch_item = CartRemoveItem.copyOf(cartRemoveItem.batch_item);
                this.bparam = cartRemoveItem.bparam;
                this.clean_welcome_package = cartRemoveItem.clean_welcome_package;
                this.item_group_id = cartRemoveItem.item_group_id;
                this.batch_cart_item = CartRemoveItem.copyOf(cartRemoveItem.batch_cart_item);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder batch_item(List<ShopItemId> list) {
            this.batch_item = checkForNulls(list);
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder clean_welcome_package(Boolean bool) {
            this.clean_welcome_package = bool;
            return this;
        }

        public Builder item_group_id(Long l) {
            this.item_group_id = l;
            return this;
        }

        public Builder batch_cart_item(List<CartRemoveItemInfo> list) {
            this.batch_cart_item = checkForNulls(list);
            return this;
        }

        public CartRemoveItem build() {
            return new CartRemoveItem(this);
        }
    }
}
