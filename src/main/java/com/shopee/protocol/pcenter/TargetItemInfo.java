package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TargetItemInfo extends Message {
    public static final String DEFAULT_ITEM_NAME = "";
    public static final Long DEFAULT_MTIME = 0L;
    public static final Long DEFAULT_PRICE = 0L;
    public static final String DEFAULT_SHOP_NAME = "";
    public static final String DEFAULT_SHOP_URL = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final TargetItemId item;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String item_name;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String shop_name;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String shop_url;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String url;

    public TargetItemInfo(TargetItemId targetItemId, Long l, String str, String str2, String str3, Long l2, String str4) {
        this.item = targetItemId;
        this.price = l;
        this.url = str;
        this.item_name = str2;
        this.shop_name = str3;
        this.mtime = l2;
        this.shop_url = str4;
    }

    private TargetItemInfo(Builder builder) {
        this(builder.item, builder.price, builder.url, builder.item_name, builder.shop_name, builder.mtime, builder.shop_url);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TargetItemInfo)) {
            return false;
        }
        TargetItemInfo targetItemInfo = (TargetItemInfo) obj;
        if (!equals((Object) this.item, (Object) targetItemInfo.item) || !equals((Object) this.price, (Object) targetItemInfo.price) || !equals((Object) this.url, (Object) targetItemInfo.url) || !equals((Object) this.item_name, (Object) targetItemInfo.item_name) || !equals((Object) this.shop_name, (Object) targetItemInfo.shop_name) || !equals((Object) this.mtime, (Object) targetItemInfo.mtime) || !equals((Object) this.shop_url, (Object) targetItemInfo.shop_url)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        TargetItemId targetItemId = this.item;
        int i2 = 0;
        int hashCode = (targetItemId != null ? targetItemId.hashCode() : 0) * 37;
        Long l = this.price;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.url;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.item_name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.shop_name;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l2 = this.mtime;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str4 = this.shop_url;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TargetItemInfo> {
        public TargetItemId item;
        public String item_name;
        public Long mtime;
        public Long price;
        public String shop_name;
        public String shop_url;
        public String url;

        public Builder() {
        }

        public Builder(TargetItemInfo targetItemInfo) {
            super(targetItemInfo);
            if (targetItemInfo != null) {
                this.item = targetItemInfo.item;
                this.price = targetItemInfo.price;
                this.url = targetItemInfo.url;
                this.item_name = targetItemInfo.item_name;
                this.shop_name = targetItemInfo.shop_name;
                this.mtime = targetItemInfo.mtime;
                this.shop_url = targetItemInfo.shop_url;
            }
        }

        public Builder item(TargetItemId targetItemId) {
            this.item = targetItemId;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder item_name(String str) {
            this.item_name = str;
            return this;
        }

        public Builder shop_name(String str) {
            this.shop_name = str;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder shop_url(String str) {
            this.shop_url = str;
            return this;
        }

        public TargetItemInfo build() {
            return new TargetItemInfo(this);
        }
    }
}
