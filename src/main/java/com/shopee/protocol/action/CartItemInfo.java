package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartItemInfo extends Message {
    public static final Integer DEFAULT_ADDIN_TIME = 0;
    public static final Long DEFAULT_ADD_ON_DEAL_ID = 0L;
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final Long DEFAULT_CHATID = 0L;
    public static final Boolean DEFAULT_CHECKOUT = false;
    public static final Integer DEFAULT_CONDITION = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final Boolean DEFAULT_DONOT_ADD_QUANTITY = false;
    public static final String DEFAULT_IMAGE = "";
    public static final Boolean DEFAULT_IS_ADD_ON_SUB_ITEM = false;
    public static final Boolean DEFAULT_IS_FLASH_SALE = false;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_DISCOUNT = 0L;
    public static final Long DEFAULT_ITEM_GROUP_ID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_MODEL_NAME = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_OFFERID = 0L;
    public static final Integer DEFAULT_ORIGIN_CONDITION = 0;
    public static final Long DEFAULT_ORIGIN_PRICE = 0L;
    public static final Integer DEFAULT_ORIGIN_QUANTITY = 0;
    public static final Long DEFAULT_ORIGIN_WHOLESALE_PRICE = 0L;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_QUANTITY = 0;
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STOCK = 0;
    public static final Long DEFAULT_WHOLESALE_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 28, type = Message.Datatype.UINT64)
    public final Long add_on_deal_id;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer addin_time;
    @ProtoField(tag = 27, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean checkout;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer condition;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 15, type = Message.Datatype.BOOL)
    public final Boolean donot_add_quantity;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String image;
    @ProtoField(tag = 30, type = Message.Datatype.BOOL)
    public final Boolean is_add_on_sub_item;
    @ProtoField(tag = 26, type = Message.Datatype.BOOL)
    public final Boolean is_flash_sale;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long item_discount;
    @ProtoField(tag = 29, type = Message.Datatype.INT64)
    public final Long item_group_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String model_name;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long offerid;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer origin_condition;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long origin_price;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer origin_quantity;
    @ProtoField(tag = 25, type = Message.Datatype.INT64)
    public final Long origin_wholesale_price;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer quantity;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer stock;
    @ProtoField(tag = 24, type = Message.Datatype.INT64)
    public final Long wholesale_price;

    public CartItemInfo(Long l, Integer num, Long l2, String str, String str2, Long l3, String str3, String str4, Boolean bool, Long l4, Integer num2, Integer num3, Integer num4, Boolean bool2, Integer num5, Long l5, Long l6, Integer num6, Integer num7, Integer num8, Long l7, String str5, Long l8, Long l9, Boolean bool3, Long l10, Long l11, Long l12, Boolean bool4) {
        this.itemid = l;
        this.quantity = num;
        this.price = l2;
        this.name = str;
        this.image = str2;
        this.modelid = l3;
        this.currency = str3;
        this.model_name = str4;
        this.checkout = bool;
        this.chatid = l4;
        this.status = num2;
        this.mtime = num3;
        this.addin_time = num4;
        this.donot_add_quantity = bool2;
        this.stock = num5;
        this.offerid = l5;
        this.origin_price = l6;
        this.origin_condition = num6;
        this.condition = num7;
        this.origin_quantity = num8;
        this.item_discount = l7;
        this.source = str5;
        this.wholesale_price = l8;
        this.origin_wholesale_price = l9;
        this.is_flash_sale = bool3;
        this.bundle_deal_id = l10;
        this.add_on_deal_id = l11;
        this.item_group_id = l12;
        this.is_add_on_sub_item = bool4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CartItemInfo(com.shopee.protocol.action.CartItemInfo.Builder r33) {
        /*
            r32 = this;
            r0 = r33
            r1 = r32
            java.lang.Long r2 = r0.itemid
            java.lang.Integer r3 = r0.quantity
            java.lang.Long r4 = r0.price
            java.lang.String r5 = r0.name
            java.lang.String r6 = r0.image
            java.lang.Long r7 = r0.modelid
            java.lang.String r8 = r0.currency
            java.lang.String r9 = r0.model_name
            java.lang.Boolean r10 = r0.checkout
            java.lang.Long r11 = r0.chatid
            java.lang.Integer r12 = r0.status
            java.lang.Integer r13 = r0.mtime
            java.lang.Integer r14 = r0.addin_time
            java.lang.Boolean r15 = r0.donot_add_quantity
            r31 = r1
            java.lang.Integer r1 = r0.stock
            r16 = r1
            java.lang.Long r1 = r0.offerid
            r17 = r1
            java.lang.Long r1 = r0.origin_price
            r18 = r1
            java.lang.Integer r1 = r0.origin_condition
            r19 = r1
            java.lang.Integer r1 = r0.condition
            r20 = r1
            java.lang.Integer r1 = r0.origin_quantity
            r21 = r1
            java.lang.Long r1 = r0.item_discount
            r22 = r1
            java.lang.String r1 = r0.source
            r23 = r1
            java.lang.Long r1 = r0.wholesale_price
            r24 = r1
            java.lang.Long r1 = r0.origin_wholesale_price
            r25 = r1
            java.lang.Boolean r1 = r0.is_flash_sale
            r26 = r1
            java.lang.Long r1 = r0.bundle_deal_id
            r27 = r1
            java.lang.Long r1 = r0.add_on_deal_id
            r28 = r1
            java.lang.Long r1 = r0.item_group_id
            r29 = r1
            java.lang.Boolean r1 = r0.is_add_on_sub_item
            r30 = r1
            r1 = r31
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r32.setBuilder(r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.CartItemInfo.<init>(com.shopee.protocol.action.CartItemInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartItemInfo)) {
            return false;
        }
        CartItemInfo cartItemInfo = (CartItemInfo) obj;
        if (!equals((Object) this.itemid, (Object) cartItemInfo.itemid) || !equals((Object) this.quantity, (Object) cartItemInfo.quantity) || !equals((Object) this.price, (Object) cartItemInfo.price) || !equals((Object) this.name, (Object) cartItemInfo.name) || !equals((Object) this.image, (Object) cartItemInfo.image) || !equals((Object) this.modelid, (Object) cartItemInfo.modelid) || !equals((Object) this.currency, (Object) cartItemInfo.currency) || !equals((Object) this.model_name, (Object) cartItemInfo.model_name) || !equals((Object) this.checkout, (Object) cartItemInfo.checkout) || !equals((Object) this.chatid, (Object) cartItemInfo.chatid) || !equals((Object) this.status, (Object) cartItemInfo.status) || !equals((Object) this.mtime, (Object) cartItemInfo.mtime) || !equals((Object) this.addin_time, (Object) cartItemInfo.addin_time) || !equals((Object) this.donot_add_quantity, (Object) cartItemInfo.donot_add_quantity) || !equals((Object) this.stock, (Object) cartItemInfo.stock) || !equals((Object) this.offerid, (Object) cartItemInfo.offerid) || !equals((Object) this.origin_price, (Object) cartItemInfo.origin_price) || !equals((Object) this.origin_condition, (Object) cartItemInfo.origin_condition) || !equals((Object) this.condition, (Object) cartItemInfo.condition) || !equals((Object) this.origin_quantity, (Object) cartItemInfo.origin_quantity) || !equals((Object) this.item_discount, (Object) cartItemInfo.item_discount) || !equals((Object) this.source, (Object) cartItemInfo.source) || !equals((Object) this.wholesale_price, (Object) cartItemInfo.wholesale_price) || !equals((Object) this.origin_wholesale_price, (Object) cartItemInfo.origin_wholesale_price) || !equals((Object) this.is_flash_sale, (Object) cartItemInfo.is_flash_sale) || !equals((Object) this.bundle_deal_id, (Object) cartItemInfo.bundle_deal_id) || !equals((Object) this.add_on_deal_id, (Object) cartItemInfo.add_on_deal_id) || !equals((Object) this.item_group_id, (Object) cartItemInfo.item_group_id) || !equals((Object) this.is_add_on_sub_item, (Object) cartItemInfo.is_add_on_sub_item)) {
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
        Integer num = this.quantity;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.price;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.image;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l3 = this.modelid;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str3 = this.currency;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.model_name;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.checkout;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l4 = this.chatid;
        int hashCode10 = (hashCode9 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode12 = (hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.addin_time;
        int hashCode13 = (hashCode12 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool2 = this.donot_add_quantity;
        int hashCode14 = (hashCode13 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num5 = this.stock;
        int hashCode15 = (hashCode14 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l5 = this.offerid;
        int hashCode16 = (hashCode15 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.origin_price;
        int hashCode17 = (hashCode16 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num6 = this.origin_condition;
        int hashCode18 = (hashCode17 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.condition;
        int hashCode19 = (hashCode18 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.origin_quantity;
        int hashCode20 = (hashCode19 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Long l7 = this.item_discount;
        int hashCode21 = (hashCode20 + (l7 != null ? l7.hashCode() : 0)) * 37;
        String str5 = this.source;
        int hashCode22 = (hashCode21 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l8 = this.wholesale_price;
        int hashCode23 = (hashCode22 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.origin_wholesale_price;
        int hashCode24 = (hashCode23 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_flash_sale;
        int hashCode25 = (hashCode24 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Long l10 = this.bundle_deal_id;
        int hashCode26 = (hashCode25 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Long l11 = this.add_on_deal_id;
        int hashCode27 = (hashCode26 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Long l12 = this.item_group_id;
        int hashCode28 = (hashCode27 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Boolean bool4 = this.is_add_on_sub_item;
        if (bool4 != null) {
            i2 = bool4.hashCode();
        }
        int i3 = hashCode28 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartItemInfo> {
        public Long add_on_deal_id;
        public Integer addin_time;
        public Long bundle_deal_id;
        public Long chatid;
        public Boolean checkout;
        public Integer condition;
        public String currency;
        public Boolean donot_add_quantity;
        public String image;
        public Boolean is_add_on_sub_item;
        public Boolean is_flash_sale;
        public Long item_discount;
        public Long item_group_id;
        public Long itemid;
        public String model_name;
        public Long modelid;
        public Integer mtime;
        public String name;
        public Long offerid;
        public Integer origin_condition;
        public Long origin_price;
        public Integer origin_quantity;
        public Long origin_wholesale_price;
        public Long price;
        public Integer quantity;
        public String source;
        public Integer status;
        public Integer stock;
        public Long wholesale_price;

        public Builder() {
        }

        public Builder(CartItemInfo cartItemInfo) {
            super(cartItemInfo);
            if (cartItemInfo != null) {
                this.itemid = cartItemInfo.itemid;
                this.quantity = cartItemInfo.quantity;
                this.price = cartItemInfo.price;
                this.name = cartItemInfo.name;
                this.image = cartItemInfo.image;
                this.modelid = cartItemInfo.modelid;
                this.currency = cartItemInfo.currency;
                this.model_name = cartItemInfo.model_name;
                this.checkout = cartItemInfo.checkout;
                this.chatid = cartItemInfo.chatid;
                this.status = cartItemInfo.status;
                this.mtime = cartItemInfo.mtime;
                this.addin_time = cartItemInfo.addin_time;
                this.donot_add_quantity = cartItemInfo.donot_add_quantity;
                this.stock = cartItemInfo.stock;
                this.offerid = cartItemInfo.offerid;
                this.origin_price = cartItemInfo.origin_price;
                this.origin_condition = cartItemInfo.origin_condition;
                this.condition = cartItemInfo.condition;
                this.origin_quantity = cartItemInfo.origin_quantity;
                this.item_discount = cartItemInfo.item_discount;
                this.source = cartItemInfo.source;
                this.wholesale_price = cartItemInfo.wholesale_price;
                this.origin_wholesale_price = cartItemInfo.origin_wholesale_price;
                this.is_flash_sale = cartItemInfo.is_flash_sale;
                this.bundle_deal_id = cartItemInfo.bundle_deal_id;
                this.add_on_deal_id = cartItemInfo.add_on_deal_id;
                this.item_group_id = cartItemInfo.item_group_id;
                this.is_add_on_sub_item = cartItemInfo.is_add_on_sub_item;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder quantity(Integer num) {
            this.quantity = num;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder image(String str) {
            this.image = str;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder model_name(String str) {
            this.model_name = str;
            return this;
        }

        public Builder checkout(Boolean bool) {
            this.checkout = bool;
            return this;
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder addin_time(Integer num) {
            this.addin_time = num;
            return this;
        }

        public Builder donot_add_quantity(Boolean bool) {
            this.donot_add_quantity = bool;
            return this;
        }

        public Builder stock(Integer num) {
            this.stock = num;
            return this;
        }

        public Builder offerid(Long l) {
            this.offerid = l;
            return this;
        }

        public Builder origin_price(Long l) {
            this.origin_price = l;
            return this;
        }

        public Builder origin_condition(Integer num) {
            this.origin_condition = num;
            return this;
        }

        public Builder condition(Integer num) {
            this.condition = num;
            return this;
        }

        public Builder origin_quantity(Integer num) {
            this.origin_quantity = num;
            return this;
        }

        public Builder item_discount(Long l) {
            this.item_discount = l;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder wholesale_price(Long l) {
            this.wholesale_price = l;
            return this;
        }

        public Builder origin_wholesale_price(Long l) {
            this.origin_wholesale_price = l;
            return this;
        }

        public Builder is_flash_sale(Boolean bool) {
            this.is_flash_sale = bool;
            return this;
        }

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder add_on_deal_id(Long l) {
            this.add_on_deal_id = l;
            return this;
        }

        public Builder item_group_id(Long l) {
            this.item_group_id = l;
            return this;
        }

        public Builder is_add_on_sub_item(Boolean bool) {
            this.is_add_on_sub_item = bool;
            return this;
        }

        public CartItemInfo build() {
            checkRequiredFields();
            return new CartItemInfo(this);
        }
    }
}
