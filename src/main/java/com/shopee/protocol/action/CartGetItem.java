package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartGetItem extends Message {
    public static final Long DEFAULT_ADD_ON_DEAL_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_GROUP_ID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long add_on_deal_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long item_group_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public CartGetItem(String str, Integer num, Long l, Long l2, Long l3) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.add_on_deal_id = l2;
        this.item_group_id = l3;
    }

    private CartGetItem(Builder builder) {
        this(builder.requestid, builder.shopid, builder.itemid, builder.add_on_deal_id, builder.item_group_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartGetItem)) {
            return false;
        }
        CartGetItem cartGetItem = (CartGetItem) obj;
        if (!equals((Object) this.requestid, (Object) cartGetItem.requestid) || !equals((Object) this.shopid, (Object) cartGetItem.shopid) || !equals((Object) this.itemid, (Object) cartGetItem.itemid) || !equals((Object) this.add_on_deal_id, (Object) cartGetItem.add_on_deal_id) || !equals((Object) this.item_group_id, (Object) cartGetItem.item_group_id)) {
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
        Long l2 = this.add_on_deal_id;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.item_group_id;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartGetItem> {
        public Long add_on_deal_id;
        public Long item_group_id;
        public Long itemid;
        public String requestid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(CartGetItem cartGetItem) {
            super(cartGetItem);
            if (cartGetItem != null) {
                this.requestid = cartGetItem.requestid;
                this.shopid = cartGetItem.shopid;
                this.itemid = cartGetItem.itemid;
                this.add_on_deal_id = cartGetItem.add_on_deal_id;
                this.item_group_id = cartGetItem.item_group_id;
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

        public Builder add_on_deal_id(Long l) {
            this.add_on_deal_id = l;
            return this;
        }

        public Builder item_group_id(Long l) {
            this.item_group_id = l;
            return this;
        }

        public CartGetItem build() {
            checkRequiredFields();
            return new CartGetItem(this);
        }
    }
}
