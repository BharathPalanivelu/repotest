package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatOfferInfo extends Message {
    public static final String DEFAULT_CURRENCY = "";
    public static final String DEFAULT_IMAGEURL = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_ITEM_NAME = "";
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_MODEL_NAME = "";
    public static final Long DEFAULT_OFFERID = 0L;
    public static final Integer DEFAULT_OFFERSTATUS = 0;
    public static final Long DEFAULT_ORIGINAL_PRICE = 0L;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Integer DEFAULT_QUANTITY = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String imageUrl;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String item_name;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String model_name;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer offerStatus;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long offerid;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long original_price;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer quantity;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ChatOfferInfo(Integer num, Long l, String str, Integer num2, Long l2, Long l3, Long l4, String str2, String str3, Long l5, Long l6, String str4, Integer num3) {
        this.offerStatus = num;
        this.price = l;
        this.currency = str;
        this.quantity = num2;
        this.modelid = l2;
        this.offerid = l3;
        this.itemid = l4;
        this.item_name = str2;
        this.model_name = str3;
        this.price_before_discount = l5;
        this.original_price = l6;
        this.imageUrl = str4;
        this.shopid = num3;
    }

    private ChatOfferInfo(Builder builder) {
        this(builder.offerStatus, builder.price, builder.currency, builder.quantity, builder.modelid, builder.offerid, builder.itemid, builder.item_name, builder.model_name, builder.price_before_discount, builder.original_price, builder.imageUrl, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatOfferInfo)) {
            return false;
        }
        ChatOfferInfo chatOfferInfo = (ChatOfferInfo) obj;
        if (!equals((Object) this.offerStatus, (Object) chatOfferInfo.offerStatus) || !equals((Object) this.price, (Object) chatOfferInfo.price) || !equals((Object) this.currency, (Object) chatOfferInfo.currency) || !equals((Object) this.quantity, (Object) chatOfferInfo.quantity) || !equals((Object) this.modelid, (Object) chatOfferInfo.modelid) || !equals((Object) this.offerid, (Object) chatOfferInfo.offerid) || !equals((Object) this.itemid, (Object) chatOfferInfo.itemid) || !equals((Object) this.item_name, (Object) chatOfferInfo.item_name) || !equals((Object) this.model_name, (Object) chatOfferInfo.model_name) || !equals((Object) this.price_before_discount, (Object) chatOfferInfo.price_before_discount) || !equals((Object) this.original_price, (Object) chatOfferInfo.original_price) || !equals((Object) this.imageUrl, (Object) chatOfferInfo.imageUrl) || !equals((Object) this.shopid, (Object) chatOfferInfo.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.offerStatus;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.price;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.quantity;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.offerid;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.itemid;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str2 = this.item_name;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.model_name;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l5 = this.price_before_discount;
        int hashCode10 = (hashCode9 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.original_price;
        int hashCode11 = (hashCode10 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str4 = this.imageUrl;
        int hashCode12 = (hashCode11 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatOfferInfo> {
        public String currency;
        public String imageUrl;
        public String item_name;
        public Long itemid;
        public String model_name;
        public Long modelid;
        public Integer offerStatus;
        public Long offerid;
        public Long original_price;
        public Long price;
        public Long price_before_discount;
        public Integer quantity;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ChatOfferInfo chatOfferInfo) {
            super(chatOfferInfo);
            if (chatOfferInfo != null) {
                this.offerStatus = chatOfferInfo.offerStatus;
                this.price = chatOfferInfo.price;
                this.currency = chatOfferInfo.currency;
                this.quantity = chatOfferInfo.quantity;
                this.modelid = chatOfferInfo.modelid;
                this.offerid = chatOfferInfo.offerid;
                this.itemid = chatOfferInfo.itemid;
                this.item_name = chatOfferInfo.item_name;
                this.model_name = chatOfferInfo.model_name;
                this.price_before_discount = chatOfferInfo.price_before_discount;
                this.original_price = chatOfferInfo.original_price;
                this.imageUrl = chatOfferInfo.imageUrl;
                this.shopid = chatOfferInfo.shopid;
            }
        }

        public Builder offerStatus(Integer num) {
            this.offerStatus = num;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder quantity(Integer num) {
            this.quantity = num;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder offerid(Long l) {
            this.offerid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder item_name(String str) {
            this.item_name = str;
            return this;
        }

        public Builder model_name(String str) {
            this.model_name = str;
            return this;
        }

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public Builder original_price(Long l) {
            this.original_price = l;
            return this;
        }

        public Builder imageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public ChatOfferInfo build() {
            checkRequiredFields();
            return new ChatOfferInfo(this);
        }
    }
}
