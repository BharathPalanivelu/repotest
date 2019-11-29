package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Cart extends Message {
    public static final String DEFAULT_CARTPROTO = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String cartproto;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public Cart(Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5) {
        this.id = num;
        this.userid = num2;
        this.shopid = num3;
        this.mtime = num4;
        this.cartproto = str;
        this.item_count = num5;
    }

    private Cart(Builder builder) {
        this(builder.id, builder.userid, builder.shopid, builder.mtime, builder.cartproto, builder.item_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) obj;
        if (!equals((Object) this.id, (Object) cart.id) || !equals((Object) this.userid, (Object) cart.userid) || !equals((Object) this.shopid, (Object) cart.shopid) || !equals((Object) this.mtime, (Object) cart.mtime) || !equals((Object) this.cartproto, (Object) cart.cartproto) || !equals((Object) this.item_count, (Object) cart.item_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.cartproto;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.item_count;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Cart> {
        public String cartproto;
        public Integer id;
        public Integer item_count;
        public Integer mtime;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(Cart cart) {
            super(cart);
            if (cart != null) {
                this.id = cart.id;
                this.userid = cart.userid;
                this.shopid = cart.shopid;
                this.mtime = cart.mtime;
                this.cartproto = cart.cartproto;
                this.item_count = cart.item_count;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder cartproto(String str) {
            this.cartproto = str;
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}
