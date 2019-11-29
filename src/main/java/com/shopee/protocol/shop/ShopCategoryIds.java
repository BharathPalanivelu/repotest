package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopCategoryIds extends Message {
    public static final List<Long> DEFAULT_SHOP_COLLECTIONID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> shop_collectionid;

    public ShopCategoryIds(List<Long> list) {
        this.shop_collectionid = immutableCopyOf(list);
    }

    private ShopCategoryIds(Builder builder) {
        this(builder.shop_collectionid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCategoryIds)) {
            return false;
        }
        return equals((List<?>) this.shop_collectionid, (List<?>) ((ShopCategoryIds) obj).shop_collectionid);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Long> list = this.shop_collectionid;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ShopCategoryIds> {
        public List<Long> shop_collectionid;

        public Builder() {
        }

        public Builder(ShopCategoryIds shopCategoryIds) {
            super(shopCategoryIds);
            if (shopCategoryIds != null) {
                this.shop_collectionid = ShopCategoryIds.copyOf(shopCategoryIds.shop_collectionid);
            }
        }

        public Builder shop_collectionid(List<Long> list) {
            this.shop_collectionid = checkForNulls(list);
            return this;
        }

        public ShopCategoryIds build() {
            return new ShopCategoryIds(this);
        }
    }
}
