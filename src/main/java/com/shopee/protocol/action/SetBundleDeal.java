package com.shopee.protocol.action;

import com.shopee.protocol.shop.BundleDeal;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetBundleDeal extends Message {
    public static final Boolean DEFAULT_CLEAR_ALL_ITEMID_LIST = false;
    public static final Boolean DEFAULT_CLEAR_ALL_SHOPID_LIST = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 4)
    public final BundleDeal bundle_deal;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean clear_all_itemid_list;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean clear_all_shopid_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public SetBundleDeal(String str, String str2, BackendParam backendParam, BundleDeal bundleDeal, Boolean bool, Boolean bool2) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.bundle_deal = bundleDeal;
        this.clear_all_itemid_list = bool;
        this.clear_all_shopid_list = bool2;
    }

    private SetBundleDeal(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.bundle_deal, builder.clear_all_itemid_list, builder.clear_all_shopid_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetBundleDeal)) {
            return false;
        }
        SetBundleDeal setBundleDeal = (SetBundleDeal) obj;
        if (!equals((Object) this.requestid, (Object) setBundleDeal.requestid) || !equals((Object) this.token, (Object) setBundleDeal.token) || !equals((Object) this.bparam, (Object) setBundleDeal.bparam) || !equals((Object) this.bundle_deal, (Object) setBundleDeal.bundle_deal) || !equals((Object) this.clear_all_itemid_list, (Object) setBundleDeal.clear_all_itemid_list) || !equals((Object) this.clear_all_shopid_list, (Object) setBundleDeal.clear_all_shopid_list)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        BundleDeal bundleDeal = this.bundle_deal;
        int hashCode4 = (hashCode3 + (bundleDeal != null ? bundleDeal.hashCode() : 0)) * 37;
        Boolean bool = this.clear_all_itemid_list;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.clear_all_shopid_list;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetBundleDeal> {
        public BackendParam bparam;
        public BundleDeal bundle_deal;
        public Boolean clear_all_itemid_list;
        public Boolean clear_all_shopid_list;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetBundleDeal setBundleDeal) {
            super(setBundleDeal);
            if (setBundleDeal != null) {
                this.requestid = setBundleDeal.requestid;
                this.token = setBundleDeal.token;
                this.bparam = setBundleDeal.bparam;
                this.bundle_deal = setBundleDeal.bundle_deal;
                this.clear_all_itemid_list = setBundleDeal.clear_all_itemid_list;
                this.clear_all_shopid_list = setBundleDeal.clear_all_shopid_list;
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder bundle_deal(BundleDeal bundleDeal) {
            this.bundle_deal = bundleDeal;
            return this;
        }

        public Builder clear_all_itemid_list(Boolean bool) {
            this.clear_all_itemid_list = bool;
            return this;
        }

        public Builder clear_all_shopid_list(Boolean bool) {
            this.clear_all_shopid_list = bool;
            return this;
        }

        public SetBundleDeal build() {
            return new SetBundleDeal(this);
        }
    }
}
