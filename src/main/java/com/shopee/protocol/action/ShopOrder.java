package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopOrder extends Message {
    public static final List<CartItemInfo> DEFAULT_ITEMINFOS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final CartOrderExtraInfo extrainfo;
    @ProtoField(label = Message.Label.REPEATED, messageType = CartItemInfo.class, tag = 4)
    public final List<CartItemInfo> iteminfos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ShopOrder(Integer num, List<CartItemInfo> list, CartOrderExtraInfo cartOrderExtraInfo) {
        this.shopid = num;
        this.iteminfos = immutableCopyOf(list);
        this.extrainfo = cartOrderExtraInfo;
    }

    private ShopOrder(Builder builder) {
        this(builder.shopid, builder.iteminfos, builder.extrainfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopOrder)) {
            return false;
        }
        ShopOrder shopOrder = (ShopOrder) obj;
        if (!equals((Object) this.shopid, (Object) shopOrder.shopid) || !equals((List<?>) this.iteminfos, (List<?>) shopOrder.iteminfos) || !equals((Object) this.extrainfo, (Object) shopOrder.extrainfo)) {
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
        List<CartItemInfo> list = this.iteminfos;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        CartOrderExtraInfo cartOrderExtraInfo = this.extrainfo;
        if (cartOrderExtraInfo != null) {
            i2 = cartOrderExtraInfo.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopOrder> {
        public CartOrderExtraInfo extrainfo;
        public List<CartItemInfo> iteminfos;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ShopOrder shopOrder) {
            super(shopOrder);
            if (shopOrder != null) {
                this.shopid = shopOrder.shopid;
                this.iteminfos = ShopOrder.copyOf(shopOrder.iteminfos);
                this.extrainfo = shopOrder.extrainfo;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder iteminfos(List<CartItemInfo> list) {
            this.iteminfos = checkForNulls(list);
            return this;
        }

        public Builder extrainfo(CartOrderExtraInfo cartOrderExtraInfo) {
            this.extrainfo = cartOrderExtraInfo;
            return this;
        }

        public ShopOrder build() {
            checkRequiredFields();
            return new ShopOrder(this);
        }
    }
}
