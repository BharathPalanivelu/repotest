package com.shopee.protocol.action;

import com.shopee.protocol.shop.ShopBoost;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetShopBoost extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 3)
    public final ShopBoost info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetShopBoost(String str, BackendParam backendParam, ShopBoost shopBoost) {
        this.requestid = str;
        this.bparam = backendParam;
        this.info = shopBoost;
    }

    private SetShopBoost(Builder builder) {
        this(builder.requestid, builder.bparam, builder.info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetShopBoost)) {
            return false;
        }
        SetShopBoost setShopBoost = (SetShopBoost) obj;
        if (!equals((Object) this.requestid, (Object) setShopBoost.requestid) || !equals((Object) this.bparam, (Object) setShopBoost.bparam) || !equals((Object) this.info, (Object) setShopBoost.info)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        ShopBoost shopBoost = this.info;
        if (shopBoost != null) {
            i2 = shopBoost.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetShopBoost> {
        public BackendParam bparam;
        public ShopBoost info;
        public String requestid;

        public Builder() {
        }

        public Builder(SetShopBoost setShopBoost) {
            super(setShopBoost);
            if (setShopBoost != null) {
                this.requestid = setShopBoost.requestid;
                this.bparam = setShopBoost.bparam;
                this.info = setShopBoost.info;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder info(ShopBoost shopBoost) {
            this.info = shopBoost;
            return this;
        }

        public SetShopBoost build() {
            return new SetShopBoost(this);
        }
    }
}
