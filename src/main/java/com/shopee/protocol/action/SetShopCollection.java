package com.shopee.protocol.action;

import com.shopee.protocol.shop.ShopCollection;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetShopCollection extends Message {
    public static final Boolean DEFAULT_CLEAR_ITEM = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean clear_item;
    @ProtoField(tag = 3)
    public final ShopCollection collection;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public SetShopCollection(String str, String str2, ShopCollection shopCollection, Boolean bool, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.collection = shopCollection;
        this.clear_item = bool;
        this.bparam = backendParam;
    }

    private SetShopCollection(Builder builder) {
        this(builder.requestid, builder.token, builder.collection, builder.clear_item, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetShopCollection)) {
            return false;
        }
        SetShopCollection setShopCollection = (SetShopCollection) obj;
        if (!equals((Object) this.requestid, (Object) setShopCollection.requestid) || !equals((Object) this.token, (Object) setShopCollection.token) || !equals((Object) this.collection, (Object) setShopCollection.collection) || !equals((Object) this.clear_item, (Object) setShopCollection.clear_item) || !equals((Object) this.bparam, (Object) setShopCollection.bparam)) {
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
        ShopCollection shopCollection = this.collection;
        int hashCode3 = (hashCode2 + (shopCollection != null ? shopCollection.hashCode() : 0)) * 37;
        Boolean bool = this.clear_item;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetShopCollection> {
        public BackendParam bparam;
        public Boolean clear_item;
        public ShopCollection collection;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetShopCollection setShopCollection) {
            super(setShopCollection);
            if (setShopCollection != null) {
                this.requestid = setShopCollection.requestid;
                this.token = setShopCollection.token;
                this.collection = setShopCollection.collection;
                this.clear_item = setShopCollection.clear_item;
                this.bparam = setShopCollection.bparam;
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

        public Builder collection(ShopCollection shopCollection) {
            this.collection = shopCollection;
            return this;
        }

        public Builder clear_item(Boolean bool) {
            this.clear_item = bool;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public SetShopCollection build() {
            return new SetShopCollection(this);
        }
    }
}
