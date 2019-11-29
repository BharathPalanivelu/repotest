package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexItemVisibility extends Message {
    public static final Integer DEFAULT_ADMIN_INVISIBLE = 0;
    public static final Integer DEFAULT_BROWSE_VISIBLE = 0;
    public static final Integer DEFAULT_ITEM_VISIBLE = 0;
    public static final Integer DEFAULT_OWNER_VISIBLE = 0;
    public static final Integer DEFAULT_SHOP_VISIBLE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer admin_invisible;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer browse_visible;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer item_visible;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer owner_visible;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shop_visible;

    public SearchIndexItemVisibility(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.item_visible = num;
        this.shop_visible = num2;
        this.owner_visible = num3;
        this.browse_visible = num4;
        this.admin_invisible = num5;
    }

    private SearchIndexItemVisibility(Builder builder) {
        this(builder.item_visible, builder.shop_visible, builder.owner_visible, builder.browse_visible, builder.admin_invisible);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemVisibility)) {
            return false;
        }
        SearchIndexItemVisibility searchIndexItemVisibility = (SearchIndexItemVisibility) obj;
        if (!equals((Object) this.item_visible, (Object) searchIndexItemVisibility.item_visible) || !equals((Object) this.shop_visible, (Object) searchIndexItemVisibility.shop_visible) || !equals((Object) this.owner_visible, (Object) searchIndexItemVisibility.owner_visible) || !equals((Object) this.browse_visible, (Object) searchIndexItemVisibility.browse_visible) || !equals((Object) this.admin_invisible, (Object) searchIndexItemVisibility.admin_invisible)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.item_visible;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shop_visible;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.owner_visible;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.browse_visible;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.admin_invisible;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemVisibility> {
        public Integer admin_invisible;
        public Integer browse_visible;
        public Integer item_visible;
        public Integer owner_visible;
        public Integer shop_visible;

        public Builder() {
        }

        public Builder(SearchIndexItemVisibility searchIndexItemVisibility) {
            super(searchIndexItemVisibility);
            if (searchIndexItemVisibility != null) {
                this.item_visible = searchIndexItemVisibility.item_visible;
                this.shop_visible = searchIndexItemVisibility.shop_visible;
                this.owner_visible = searchIndexItemVisibility.owner_visible;
                this.browse_visible = searchIndexItemVisibility.browse_visible;
                this.admin_invisible = searchIndexItemVisibility.admin_invisible;
            }
        }

        public Builder item_visible(Integer num) {
            this.item_visible = num;
            return this;
        }

        public Builder shop_visible(Integer num) {
            this.shop_visible = num;
            return this;
        }

        public Builder owner_visible(Integer num) {
            this.owner_visible = num;
            return this;
        }

        public Builder browse_visible(Integer num) {
            this.browse_visible = num;
            return this;
        }

        public Builder admin_invisible(Integer num) {
            this.admin_invisible = num;
            return this;
        }

        public SearchIndexItemVisibility build() {
            return new SearchIndexItemVisibility(this);
        }
    }
}
