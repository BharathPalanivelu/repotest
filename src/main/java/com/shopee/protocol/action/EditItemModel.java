package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EditItemModel extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<ItemModel> DEFAULT_MODEL = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 3)
    public final List<ItemModel> model;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public EditItemModel(String str, Long l, List<ItemModel> list, BackendParam backendParam) {
        this.requestid = str;
        this.itemid = l;
        this.model = immutableCopyOf(list);
        this.bparam = backendParam;
    }

    private EditItemModel(Builder builder) {
        this(builder.requestid, builder.itemid, builder.model, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EditItemModel)) {
            return false;
        }
        EditItemModel editItemModel = (EditItemModel) obj;
        if (!equals((Object) this.requestid, (Object) editItemModel.requestid) || !equals((Object) this.itemid, (Object) editItemModel.itemid) || !equals((List<?>) this.model, (List<?>) editItemModel.model) || !equals((Object) this.bparam, (Object) editItemModel.bparam)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        List<ItemModel> list = this.model;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EditItemModel> {
        public BackendParam bparam;
        public Long itemid;
        public List<ItemModel> model;
        public String requestid;

        public Builder() {
        }

        public Builder(EditItemModel editItemModel) {
            super(editItemModel);
            if (editItemModel != null) {
                this.requestid = editItemModel.requestid;
                this.itemid = editItemModel.itemid;
                this.model = EditItemModel.copyOf(editItemModel.model);
                this.bparam = editItemModel.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder model(List<ItemModel> list) {
            this.model = checkForNulls(list);
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public EditItemModel build() {
            checkRequiredFields();
            return new EditItemModel(this);
        }
    }
}
