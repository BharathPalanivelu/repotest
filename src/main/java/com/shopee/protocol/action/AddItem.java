package com.shopee.protocol.action;

import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AddItem extends Message {
    public static final Boolean DEFAULT_FROM_MASS_UPDATE = false;
    public static final Boolean DEFAULT_ITEM_LEVEL_SHIPPING = false;
    public static final List<ItemModel> DEFAULT_MODEL = Collections.emptyList();
    public static final Boolean DEFAULT_ONLY_CHECK = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Boolean DEFAULT_UNLIST_ITEM = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 17)
    public final AdditionalDetail additional_detail;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean from_mass_update;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final Item item;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean item_level_shipping;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 3)
    public final List<ItemModel> model;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean only_check;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean unlist_item;

    public AddItem(String str, Item item2, List<ItemModel> list, BackendParam backendParam, String str2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, AdditionalDetail additionalDetail) {
        this.requestid = str;
        this.item = item2;
        this.model = immutableCopyOf(list);
        this.bparam = backendParam;
        this.token = str2;
        this.only_check = bool;
        this.from_mass_update = bool2;
        this.item_level_shipping = bool3;
        this.unlist_item = bool4;
        this.additional_detail = additionalDetail;
    }

    private AddItem(Builder builder) {
        this(builder.requestid, builder.item, builder.model, builder.bparam, builder.token, builder.only_check, builder.from_mass_update, builder.item_level_shipping, builder.unlist_item, builder.additional_detail);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddItem)) {
            return false;
        }
        AddItem addItem = (AddItem) obj;
        if (!equals((Object) this.requestid, (Object) addItem.requestid) || !equals((Object) this.item, (Object) addItem.item) || !equals((List<?>) this.model, (List<?>) addItem.model) || !equals((Object) this.bparam, (Object) addItem.bparam) || !equals((Object) this.token, (Object) addItem.token) || !equals((Object) this.only_check, (Object) addItem.only_check) || !equals((Object) this.from_mass_update, (Object) addItem.from_mass_update) || !equals((Object) this.item_level_shipping, (Object) addItem.item_level_shipping) || !equals((Object) this.unlist_item, (Object) addItem.unlist_item) || !equals((Object) this.additional_detail, (Object) addItem.additional_detail)) {
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
        Item item2 = this.item;
        int hashCode2 = (hashCode + (item2 != null ? item2.hashCode() : 0)) * 37;
        List<ItemModel> list = this.model;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.only_check;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.from_mass_update;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.item_level_shipping;
        int hashCode8 = (hashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.unlist_item;
        int hashCode9 = (hashCode8 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        AdditionalDetail additionalDetail = this.additional_detail;
        if (additionalDetail != null) {
            i2 = additionalDetail.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AddItem> {
        public AdditionalDetail additional_detail;
        public BackendParam bparam;
        public Boolean from_mass_update;
        public Item item;
        public Boolean item_level_shipping;
        public List<ItemModel> model;
        public Boolean only_check;
        public String requestid;
        public String token;
        public Boolean unlist_item;

        public Builder() {
        }

        public Builder(AddItem addItem) {
            super(addItem);
            if (addItem != null) {
                this.requestid = addItem.requestid;
                this.item = addItem.item;
                this.model = AddItem.copyOf(addItem.model);
                this.bparam = addItem.bparam;
                this.token = addItem.token;
                this.only_check = addItem.only_check;
                this.from_mass_update = addItem.from_mass_update;
                this.item_level_shipping = addItem.item_level_shipping;
                this.unlist_item = addItem.unlist_item;
                this.additional_detail = addItem.additional_detail;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder item(Item item2) {
            this.item = item2;
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder only_check(Boolean bool) {
            this.only_check = bool;
            return this;
        }

        public Builder from_mass_update(Boolean bool) {
            this.from_mass_update = bool;
            return this;
        }

        public Builder item_level_shipping(Boolean bool) {
            this.item_level_shipping = bool;
            return this;
        }

        public Builder unlist_item(Boolean bool) {
            this.unlist_item = bool;
            return this;
        }

        public Builder additional_detail(AdditionalDetail additionalDetail) {
            this.additional_detail = additionalDetail;
            return this;
        }

        public AddItem build() {
            checkRequiredFields();
            return new AddItem(this);
        }
    }
}
