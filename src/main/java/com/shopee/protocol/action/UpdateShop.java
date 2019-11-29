package com.shopee.protocol.action;

import com.shopee.protocol.shop.Shop;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UpdateShop extends Message {
    public static final String DEFAULT_ACTION = "";
    public static final String DEFAULT_LANG = "";
    public static final Boolean DEFAULT_POST_TO_FEED = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Boolean DEFAULT_UPDATE_LABEL = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 100, type = Message.Datatype.STRING)
    public final String action;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean post_to_feed;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final Shop shop;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean update_label;

    public UpdateShop(String str, Shop shop2, BackendParam backendParam, String str2, Boolean bool, String str3, Boolean bool2, String str4) {
        this.requestid = str;
        this.shop = shop2;
        this.bparam = backendParam;
        this.token = str2;
        this.post_to_feed = bool;
        this.lang = str3;
        this.update_label = bool2;
        this.action = str4;
    }

    private UpdateShop(Builder builder) {
        this(builder.requestid, builder.shop, builder.bparam, builder.token, builder.post_to_feed, builder.lang, builder.update_label, builder.action);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateShop)) {
            return false;
        }
        UpdateShop updateShop = (UpdateShop) obj;
        if (!equals((Object) this.requestid, (Object) updateShop.requestid) || !equals((Object) this.shop, (Object) updateShop.shop) || !equals((Object) this.bparam, (Object) updateShop.bparam) || !equals((Object) this.token, (Object) updateShop.token) || !equals((Object) this.post_to_feed, (Object) updateShop.post_to_feed) || !equals((Object) this.lang, (Object) updateShop.lang) || !equals((Object) this.update_label, (Object) updateShop.update_label) || !equals((Object) this.action, (Object) updateShop.action)) {
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
        int hashCode2 = (hashCode + (shop2 != null ? shop2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.post_to_feed;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.lang;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool2 = this.update_label;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str4 = this.action;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UpdateShop> {
        public String action;
        public BackendParam bparam;
        public String lang;
        public Boolean post_to_feed;
        public String requestid;
        public Shop shop;
        public String token;
        public Boolean update_label;

        public Builder() {
        }

        public Builder(UpdateShop updateShop) {
            super(updateShop);
            if (updateShop != null) {
                this.requestid = updateShop.requestid;
                this.shop = updateShop.shop;
                this.bparam = updateShop.bparam;
                this.token = updateShop.token;
                this.post_to_feed = updateShop.post_to_feed;
                this.lang = updateShop.lang;
                this.update_label = updateShop.update_label;
                this.action = updateShop.action;
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder post_to_feed(Boolean bool) {
            this.post_to_feed = bool;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder update_label(Boolean bool) {
            this.update_label = bool;
            return this;
        }

        public Builder action(String str) {
            this.action = str;
            return this;
        }

        public UpdateShop build() {
            checkRequiredFields();
            return new UpdateShop(this);
        }
    }
}
