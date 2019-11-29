package com.shopee.protocol.action;

import com.shopee.protocol.shop.Shop;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CreateShop extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final Shop shop;

    public CreateShop(String str, Shop shop2) {
        this.requestid = str;
        this.shop = shop2;
    }

    private CreateShop(Builder builder) {
        this(builder.requestid, builder.shop);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateShop)) {
            return false;
        }
        CreateShop createShop = (CreateShop) obj;
        if (!equals((Object) this.requestid, (Object) createShop.requestid) || !equals((Object) this.shop, (Object) createShop.shop)) {
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
        Shop shop2 = this.shop;
        if (shop2 != null) {
            i2 = shop2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CreateShop> {
        public String requestid;
        public Shop shop;

        public Builder() {
        }

        public Builder(CreateShop createShop) {
            super(createShop);
            if (createShop != null) {
                this.requestid = createShop.requestid;
                this.shop = createShop.shop;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shop(Shop shop2) {
            this.shop = shop2;
            return this;
        }

        public CreateShop build() {
            checkRequiredFields();
            return new CreateShop(this);
        }
    }
}
