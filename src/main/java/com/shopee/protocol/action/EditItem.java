package com.shopee.protocol.action;

import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EditItem extends Message {
    public static final Boolean DEFAULT_DISABLE_NOTI = false;
    public static final Boolean DEFAULT_FROM_MASS_UPDATE = false;
    public static final Boolean DEFAULT_ITEM_LEVEL_SHIPPING = false;
    public static final Boolean DEFAULT_KNOW_IMAGE_VARIATION = false;
    public static final List<ItemModel> DEFAULT_MODEL = Collections.emptyList();
    public static final Boolean DEFAULT_ONLY_CHECK = false;
    public static final Boolean DEFAULT_REMOVE_VIDEOS = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Boolean DEFAULT_UNLIST_ITEM = false;
    public static final Boolean DEFAULT_UPDATE_LABEL = false;
    public static final Boolean DEFAULT_UPDATE_MODEL = false;
    public static final Boolean DEFAULT_UPDATE_TIER = false;
    public static final Boolean DEFAULT_UPDATE_WHOLESALE = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 19)
    public final AdditionalDetail additional_detail;
    @ProtoField(tag = 7)
    public final BackendParam bparam;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean disable_noti;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean from_mass_update;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final Item item;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean item_level_shipping;
    @ProtoField(tag = 18, type = Message.Datatype.BOOL)
    public final Boolean know_image_variation;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 3)
    public final List<ItemModel> model;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean only_check;
    @ProtoField(tag = 15, type = Message.Datatype.BOOL)
    public final Boolean remove_videos;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean unlist_item;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean update_label;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean update_model;
    @ProtoField(tag = 14, type = Message.Datatype.BOOL)
    public final Boolean update_tier;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean update_wholesale;

    public EditItem(String str, Item item2, List<ItemModel> list, String str2, BackendParam backendParam, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, AdditionalDetail additionalDetail) {
        this.requestid = str;
        this.item = item2;
        this.model = immutableCopyOf(list);
        this.token = str2;
        this.bparam = backendParam;
        this.update_model = bool;
        this.from_mass_update = bool2;
        this.update_wholesale = bool3;
        this.item_level_shipping = bool4;
        this.disable_noti = bool5;
        this.only_check = bool6;
        this.update_tier = bool7;
        this.remove_videos = bool8;
        this.unlist_item = bool9;
        this.update_label = bool10;
        this.know_image_variation = bool11;
        this.additional_detail = additionalDetail;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private EditItem(com.shopee.protocol.action.EditItem.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.String r2 = r0.requestid
            com.shopee.protocol.shop.Item r3 = r0.item
            java.util.List<com.shopee.protocol.shop.ItemModel> r4 = r0.model
            java.lang.String r5 = r0.token
            com.shopee.protocol.action.BackendParam r6 = r0.bparam
            java.lang.Boolean r7 = r0.update_model
            java.lang.Boolean r8 = r0.from_mass_update
            java.lang.Boolean r9 = r0.update_wholesale
            java.lang.Boolean r10 = r0.item_level_shipping
            java.lang.Boolean r11 = r0.disable_noti
            java.lang.Boolean r12 = r0.only_check
            java.lang.Boolean r13 = r0.update_tier
            java.lang.Boolean r14 = r0.remove_videos
            java.lang.Boolean r15 = r0.unlist_item
            r19 = r1
            java.lang.Boolean r1 = r0.update_label
            r16 = r1
            java.lang.Boolean r1 = r0.know_image_variation
            r17 = r1
            com.shopee.protocol.action.AdditionalDetail r1 = r0.additional_detail
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.EditItem.<init>(com.shopee.protocol.action.EditItem$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EditItem)) {
            return false;
        }
        EditItem editItem = (EditItem) obj;
        if (!equals((Object) this.requestid, (Object) editItem.requestid) || !equals((Object) this.item, (Object) editItem.item) || !equals((List<?>) this.model, (List<?>) editItem.model) || !equals((Object) this.token, (Object) editItem.token) || !equals((Object) this.bparam, (Object) editItem.bparam) || !equals((Object) this.update_model, (Object) editItem.update_model) || !equals((Object) this.from_mass_update, (Object) editItem.from_mass_update) || !equals((Object) this.update_wholesale, (Object) editItem.update_wholesale) || !equals((Object) this.item_level_shipping, (Object) editItem.item_level_shipping) || !equals((Object) this.disable_noti, (Object) editItem.disable_noti) || !equals((Object) this.only_check, (Object) editItem.only_check) || !equals((Object) this.update_tier, (Object) editItem.update_tier) || !equals((Object) this.remove_videos, (Object) editItem.remove_videos) || !equals((Object) this.unlist_item, (Object) editItem.unlist_item) || !equals((Object) this.update_label, (Object) editItem.update_label) || !equals((Object) this.know_image_variation, (Object) editItem.know_image_variation) || !equals((Object) this.additional_detail, (Object) editItem.additional_detail)) {
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
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode5 = (hashCode4 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Boolean bool = this.update_model;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.from_mass_update;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.update_wholesale;
        int hashCode8 = (hashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.item_level_shipping;
        int hashCode9 = (hashCode8 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.disable_noti;
        int hashCode10 = (hashCode9 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.only_check;
        int hashCode11 = (hashCode10 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Boolean bool7 = this.update_tier;
        int hashCode12 = (hashCode11 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Boolean bool8 = this.remove_videos;
        int hashCode13 = (hashCode12 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        Boolean bool9 = this.unlist_item;
        int hashCode14 = (hashCode13 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
        Boolean bool10 = this.update_label;
        int hashCode15 = (hashCode14 + (bool10 != null ? bool10.hashCode() : 0)) * 37;
        Boolean bool11 = this.know_image_variation;
        int hashCode16 = (hashCode15 + (bool11 != null ? bool11.hashCode() : 0)) * 37;
        AdditionalDetail additionalDetail = this.additional_detail;
        if (additionalDetail != null) {
            i2 = additionalDetail.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EditItem> {
        public AdditionalDetail additional_detail;
        public BackendParam bparam;
        public Boolean disable_noti;
        public Boolean from_mass_update;
        public Item item;
        public Boolean item_level_shipping;
        public Boolean know_image_variation;
        public List<ItemModel> model;
        public Boolean only_check;
        public Boolean remove_videos;
        public String requestid;
        public String token;
        public Boolean unlist_item;
        public Boolean update_label;
        public Boolean update_model;
        public Boolean update_tier;
        public Boolean update_wholesale;

        public Builder() {
        }

        public Builder(EditItem editItem) {
            super(editItem);
            if (editItem != null) {
                this.requestid = editItem.requestid;
                this.item = editItem.item;
                this.model = EditItem.copyOf(editItem.model);
                this.token = editItem.token;
                this.bparam = editItem.bparam;
                this.update_model = editItem.update_model;
                this.from_mass_update = editItem.from_mass_update;
                this.update_wholesale = editItem.update_wholesale;
                this.item_level_shipping = editItem.item_level_shipping;
                this.disable_noti = editItem.disable_noti;
                this.only_check = editItem.only_check;
                this.update_tier = editItem.update_tier;
                this.remove_videos = editItem.remove_videos;
                this.unlist_item = editItem.unlist_item;
                this.update_label = editItem.update_label;
                this.know_image_variation = editItem.know_image_variation;
                this.additional_detail = editItem.additional_detail;
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder update_model(Boolean bool) {
            this.update_model = bool;
            return this;
        }

        public Builder from_mass_update(Boolean bool) {
            this.from_mass_update = bool;
            return this;
        }

        public Builder update_wholesale(Boolean bool) {
            this.update_wholesale = bool;
            return this;
        }

        public Builder item_level_shipping(Boolean bool) {
            this.item_level_shipping = bool;
            return this;
        }

        public Builder disable_noti(Boolean bool) {
            this.disable_noti = bool;
            return this;
        }

        public Builder only_check(Boolean bool) {
            this.only_check = bool;
            return this;
        }

        public Builder update_tier(Boolean bool) {
            this.update_tier = bool;
            return this;
        }

        public Builder remove_videos(Boolean bool) {
            this.remove_videos = bool;
            return this;
        }

        public Builder unlist_item(Boolean bool) {
            this.unlist_item = bool;
            return this;
        }

        public Builder update_label(Boolean bool) {
            this.update_label = bool;
            return this;
        }

        public Builder know_image_variation(Boolean bool) {
            this.know_image_variation = bool;
            return this;
        }

        public Builder additional_detail(AdditionalDetail additionalDetail) {
            this.additional_detail = additionalDetail;
            return this;
        }

        public EditItem build() {
            checkRequiredFields();
            return new EditItem(this);
        }
    }
}
