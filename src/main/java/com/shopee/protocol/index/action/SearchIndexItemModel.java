package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexItemModel extends Message {
    public static final Integer DEFAULT_ITEM_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ItemModel item_model;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer item_status;

    public SearchIndexItemModel(ItemModel itemModel, Integer num) {
        this.item_model = itemModel;
        this.item_status = num;
    }

    private SearchIndexItemModel(Builder builder) {
        this(builder.item_model, builder.item_status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemModel)) {
            return false;
        }
        SearchIndexItemModel searchIndexItemModel = (SearchIndexItemModel) obj;
        if (!equals((Object) this.item_model, (Object) searchIndexItemModel.item_model) || !equals((Object) this.item_status, (Object) searchIndexItemModel.item_status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ItemModel itemModel = this.item_model;
        int i2 = 0;
        int hashCode = (itemModel != null ? itemModel.hashCode() : 0) * 37;
        Integer num = this.item_status;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemModel> {
        public ItemModel item_model;
        public Integer item_status;

        public Builder() {
        }

        public Builder(SearchIndexItemModel searchIndexItemModel) {
            super(searchIndexItemModel);
            if (searchIndexItemModel != null) {
                this.item_model = searchIndexItemModel.item_model;
                this.item_status = searchIndexItemModel.item_status;
            }
        }

        public Builder item_model(ItemModel itemModel) {
            this.item_model = itemModel;
            return this;
        }

        public Builder item_status(Integer num) {
            this.item_status = num;
            return this;
        }

        public SearchIndexItemModel build() {
            return new SearchIndexItemModel(this);
        }
    }
}
