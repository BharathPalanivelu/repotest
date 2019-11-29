package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class WelcomePackageItem extends Message {
    public static final String DEFAULT_CUSTOM_IMAGE = "";
    public static final String DEFAULT_CUSTOM_NAME = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<WelcomePackageModelPrice> DEFAULT_MODELS = Collections.emptyList();
    public static final Boolean DEFAULT_NEED_UPDATE = false;
    public static final Boolean DEFAULT_NEW_USER_ONLY = false;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_PURCHASE_LIMIT = 0;
    public static final Long DEFAULT_REBATE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String custom_image;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String custom_name;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = WelcomePackageModelPrice.class, tag = 7)
    public final List<WelcomePackageModelPrice> models;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean need_update;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean new_user_only;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer purchase_limit;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long rebate;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public WelcomePackageItem(Long l, Integer num, String str, String str2, Long l2, List<WelcomePackageModelPrice> list, Boolean bool, Boolean bool2, Long l3, Integer num2) {
        this.itemid = l;
        this.shopid = num;
        this.custom_image = str;
        this.custom_name = str2;
        this.price = l2;
        this.models = immutableCopyOf(list);
        this.need_update = bool;
        this.new_user_only = bool2;
        this.rebate = l3;
        this.purchase_limit = num2;
    }

    private WelcomePackageItem(Builder builder) {
        this(builder.itemid, builder.shopid, builder.custom_image, builder.custom_name, builder.price, builder.models, builder.need_update, builder.new_user_only, builder.rebate, builder.purchase_limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WelcomePackageItem)) {
            return false;
        }
        WelcomePackageItem welcomePackageItem = (WelcomePackageItem) obj;
        if (!equals((Object) this.itemid, (Object) welcomePackageItem.itemid) || !equals((Object) this.shopid, (Object) welcomePackageItem.shopid) || !equals((Object) this.custom_image, (Object) welcomePackageItem.custom_image) || !equals((Object) this.custom_name, (Object) welcomePackageItem.custom_name) || !equals((Object) this.price, (Object) welcomePackageItem.price) || !equals((List<?>) this.models, (List<?>) welcomePackageItem.models) || !equals((Object) this.need_update, (Object) welcomePackageItem.need_update) || !equals((Object) this.new_user_only, (Object) welcomePackageItem.new_user_only) || !equals((Object) this.rebate, (Object) welcomePackageItem.rebate) || !equals((Object) this.purchase_limit, (Object) welcomePackageItem.purchase_limit)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.custom_image;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.custom_name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.price;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<WelcomePackageModelPrice> list = this.models;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.need_update;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.new_user_only;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Long l3 = this.rebate;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.purchase_limit;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WelcomePackageItem> {
        public String custom_image;
        public String custom_name;
        public Long itemid;
        public List<WelcomePackageModelPrice> models;
        public Boolean need_update;
        public Boolean new_user_only;
        public Long price;
        public Integer purchase_limit;
        public Long rebate;
        public Integer shopid;

        public Builder() {
        }

        public Builder(WelcomePackageItem welcomePackageItem) {
            super(welcomePackageItem);
            if (welcomePackageItem != null) {
                this.itemid = welcomePackageItem.itemid;
                this.shopid = welcomePackageItem.shopid;
                this.custom_image = welcomePackageItem.custom_image;
                this.custom_name = welcomePackageItem.custom_name;
                this.price = welcomePackageItem.price;
                this.models = WelcomePackageItem.copyOf(welcomePackageItem.models);
                this.need_update = welcomePackageItem.need_update;
                this.new_user_only = welcomePackageItem.new_user_only;
                this.rebate = welcomePackageItem.rebate;
                this.purchase_limit = welcomePackageItem.purchase_limit;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder custom_image(String str) {
            this.custom_image = str;
            return this;
        }

        public Builder custom_name(String str) {
            this.custom_name = str;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder models(List<WelcomePackageModelPrice> list) {
            this.models = checkForNulls(list);
            return this;
        }

        public Builder need_update(Boolean bool) {
            this.need_update = bool;
            return this;
        }

        public Builder new_user_only(Boolean bool) {
            this.new_user_only = bool;
            return this;
        }

        public Builder rebate(Long l) {
            this.rebate = l;
            return this;
        }

        public Builder purchase_limit(Integer num) {
            this.purchase_limit = num;
            return this;
        }

        public WelcomePackageItem build() {
            return new WelcomePackageItem(this);
        }
    }
}
