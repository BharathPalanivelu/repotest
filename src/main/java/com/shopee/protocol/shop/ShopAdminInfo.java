package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopAdminInfo extends Message {
    public static final Double DEFAULT_BOOSTING = Double.valueOf(0.0d);
    public static final Integer DEFAULT_DAYS_TO_CONFIRM = 0;
    public static final Integer DEFAULT_DAYS_TO_SHIP = 0;
    public static final Boolean DEFAULT_HAS_WHS = false;
    public static final Integer DEFAULT_ITEM_LIMIT = 0;
    public static final Boolean DEFAULT_OFFICIAL_SHOP = false;
    public static final Boolean DEFAULT_POWER_SELLER = false;
    public static final Integer DEFAULT_PREFERRED_IMAGE_CAP = 0;
    public static final String DEFAULT_SHIPPING_FROM_COUNTRY = "";
    public static final Boolean DEFAULT_STAR_SELLER = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double boosting;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer days_to_confirm;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer days_to_ship;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean has_whs;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer item_limit;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean official_shop;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean power_seller;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer preferred_image_cap;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String shipping_from_country;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean star_seller;

    public ShopAdminInfo(Boolean bool, Boolean bool2, Double d2, Integer num, Boolean bool3, Boolean bool4, Integer num2, Integer num3, String str, Integer num4) {
        this.power_seller = bool;
        this.star_seller = bool2;
        this.boosting = d2;
        this.days_to_confirm = num;
        this.official_shop = bool3;
        this.has_whs = bool4;
        this.item_limit = num2;
        this.days_to_ship = num3;
        this.shipping_from_country = str;
        this.preferred_image_cap = num4;
    }

    private ShopAdminInfo(Builder builder) {
        this(builder.power_seller, builder.star_seller, builder.boosting, builder.days_to_confirm, builder.official_shop, builder.has_whs, builder.item_limit, builder.days_to_ship, builder.shipping_from_country, builder.preferred_image_cap);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopAdminInfo)) {
            return false;
        }
        ShopAdminInfo shopAdminInfo = (ShopAdminInfo) obj;
        if (!equals((Object) this.power_seller, (Object) shopAdminInfo.power_seller) || !equals((Object) this.star_seller, (Object) shopAdminInfo.star_seller) || !equals((Object) this.boosting, (Object) shopAdminInfo.boosting) || !equals((Object) this.days_to_confirm, (Object) shopAdminInfo.days_to_confirm) || !equals((Object) this.official_shop, (Object) shopAdminInfo.official_shop) || !equals((Object) this.has_whs, (Object) shopAdminInfo.has_whs) || !equals((Object) this.item_limit, (Object) shopAdminInfo.item_limit) || !equals((Object) this.days_to_ship, (Object) shopAdminInfo.days_to_ship) || !equals((Object) this.shipping_from_country, (Object) shopAdminInfo.shipping_from_country) || !equals((Object) this.preferred_image_cap, (Object) shopAdminInfo.preferred_image_cap)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.power_seller;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Boolean bool2 = this.star_seller;
        int hashCode2 = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Double d2 = this.boosting;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Integer num = this.days_to_confirm;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool3 = this.official_shop;
        int hashCode5 = (hashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.has_whs;
        int hashCode6 = (hashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num2 = this.item_limit;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.days_to_ship;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.shipping_from_country;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.preferred_image_cap;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopAdminInfo> {
        public Double boosting;
        public Integer days_to_confirm;
        public Integer days_to_ship;
        public Boolean has_whs;
        public Integer item_limit;
        public Boolean official_shop;
        public Boolean power_seller;
        public Integer preferred_image_cap;
        public String shipping_from_country;
        public Boolean star_seller;

        public Builder() {
        }

        public Builder(ShopAdminInfo shopAdminInfo) {
            super(shopAdminInfo);
            if (shopAdminInfo != null) {
                this.power_seller = shopAdminInfo.power_seller;
                this.star_seller = shopAdminInfo.star_seller;
                this.boosting = shopAdminInfo.boosting;
                this.days_to_confirm = shopAdminInfo.days_to_confirm;
                this.official_shop = shopAdminInfo.official_shop;
                this.has_whs = shopAdminInfo.has_whs;
                this.item_limit = shopAdminInfo.item_limit;
                this.days_to_ship = shopAdminInfo.days_to_ship;
                this.shipping_from_country = shopAdminInfo.shipping_from_country;
                this.preferred_image_cap = shopAdminInfo.preferred_image_cap;
            }
        }

        public Builder power_seller(Boolean bool) {
            this.power_seller = bool;
            return this;
        }

        public Builder star_seller(Boolean bool) {
            this.star_seller = bool;
            return this;
        }

        public Builder boosting(Double d2) {
            this.boosting = d2;
            return this;
        }

        public Builder days_to_confirm(Integer num) {
            this.days_to_confirm = num;
            return this;
        }

        public Builder official_shop(Boolean bool) {
            this.official_shop = bool;
            return this;
        }

        public Builder has_whs(Boolean bool) {
            this.has_whs = bool;
            return this;
        }

        public Builder item_limit(Integer num) {
            this.item_limit = num;
            return this;
        }

        public Builder days_to_ship(Integer num) {
            this.days_to_ship = num;
            return this;
        }

        public Builder shipping_from_country(String str) {
            this.shipping_from_country = str;
            return this;
        }

        public Builder preferred_image_cap(Integer num) {
            this.preferred_image_cap = num;
            return this;
        }

        public ShopAdminInfo build() {
            return new ShopAdminInfo(this);
        }
    }
}
