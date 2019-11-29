package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AddItemModel extends Message {
    public static final List<ItemModel> DEFAULT_MODEL = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 2)
    public final List<ItemModel> model;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public AddItemModel(String str, List<ItemModel> list) {
        this.requestid = str;
        this.model = immutableCopyOf(list);
    }

    private AddItemModel(Builder builder) {
        this(builder.requestid, builder.model);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddItemModel)) {
            return false;
        }
        AddItemModel addItemModel = (AddItemModel) obj;
        if (!equals((Object) this.requestid, (Object) addItemModel.requestid) || !equals((List<?>) this.model, (List<?>) addItemModel.model)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<ItemModel> list = this.model;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<AddItemModel> {
        public List<ItemModel> model;
        public String requestid;

        public Builder() {
        }

        public Builder(AddItemModel addItemModel) {
            super(addItemModel);
            if (addItemModel != null) {
                this.requestid = addItemModel.requestid;
                this.model = AddItemModel.copyOf(addItemModel.model);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder model(List<ItemModel> list) {
            this.model = checkForNulls(list);
            return this;
        }

        public AddItemModel build() {
            return new AddItemModel(this);
        }
    }
}
