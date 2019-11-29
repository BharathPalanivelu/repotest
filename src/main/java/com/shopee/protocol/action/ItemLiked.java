package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemLiked extends Message {
    public static final Boolean DEFAULT_LIKED = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final ShopItemId id;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean liked;

    public ItemLiked(ShopItemId shopItemId, Boolean bool) {
        this.id = shopItemId;
        this.liked = bool;
    }

    private ItemLiked(Builder builder) {
        this(builder.id, builder.liked);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemLiked)) {
            return false;
        }
        ItemLiked itemLiked = (ItemLiked) obj;
        if (!equals((Object) this.id, (Object) itemLiked.id) || !equals((Object) this.liked, (Object) itemLiked.liked)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ShopItemId shopItemId = this.id;
        int i2 = 0;
        int hashCode = (shopItemId != null ? shopItemId.hashCode() : 0) * 37;
        Boolean bool = this.liked;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemLiked> {
        public ShopItemId id;
        public Boolean liked;

        public Builder() {
        }

        public Builder(ItemLiked itemLiked) {
            super(itemLiked);
            if (itemLiked != null) {
                this.id = itemLiked.id;
                this.liked = itemLiked.liked;
            }
        }

        public Builder id(ShopItemId shopItemId) {
            this.id = shopItemId;
            return this;
        }

        public Builder liked(Boolean bool) {
            this.liked = bool;
            return this;
        }

        public ItemLiked build() {
            checkRequiredFields();
            return new ItemLiked(this);
        }
    }
}
