package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatProductInfo extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_MODELNAME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PRICE = "";
    public static final String DEFAULT_PRICE_BEFORE_DISCOUNT = "";
    public static final Integer DEFAULT_QUANTITY = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SNAPSHOPID = 0L;
    public static final String DEFAULT_THUMBURL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String modelname;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String price;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String price_before_discount;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer quantity;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long snapshopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String thumbUrl;

    public ChatProductInfo(Long l, Integer num, String str, String str2, String str3, Integer num2, Long l2, String str4, String str5) {
        this.itemid = l;
        this.shopid = num;
        this.name = str;
        this.thumbUrl = str2;
        this.price = str3;
        this.quantity = num2;
        this.snapshopid = l2;
        this.modelname = str4;
        this.price_before_discount = str5;
    }

    private ChatProductInfo(Builder builder) {
        this(builder.itemid, builder.shopid, builder.name, builder.thumbUrl, builder.price, builder.quantity, builder.snapshopid, builder.modelname, builder.price_before_discount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatProductInfo)) {
            return false;
        }
        ChatProductInfo chatProductInfo = (ChatProductInfo) obj;
        if (!equals((Object) this.itemid, (Object) chatProductInfo.itemid) || !equals((Object) this.shopid, (Object) chatProductInfo.shopid) || !equals((Object) this.name, (Object) chatProductInfo.name) || !equals((Object) this.thumbUrl, (Object) chatProductInfo.thumbUrl) || !equals((Object) this.price, (Object) chatProductInfo.price) || !equals((Object) this.quantity, (Object) chatProductInfo.quantity) || !equals((Object) this.snapshopid, (Object) chatProductInfo.snapshopid) || !equals((Object) this.modelname, (Object) chatProductInfo.modelname) || !equals((Object) this.price_before_discount, (Object) chatProductInfo.price_before_discount)) {
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
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.thumbUrl;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.price;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.quantity;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.snapshopid;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str4 = this.modelname;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.price_before_discount;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatProductInfo> {
        public Long itemid;
        public String modelname;
        public String name;
        public String price;
        public String price_before_discount;
        public Integer quantity;
        public Integer shopid;
        public Long snapshopid;
        public String thumbUrl;

        public Builder() {
        }

        public Builder(ChatProductInfo chatProductInfo) {
            super(chatProductInfo);
            if (chatProductInfo != null) {
                this.itemid = chatProductInfo.itemid;
                this.shopid = chatProductInfo.shopid;
                this.name = chatProductInfo.name;
                this.thumbUrl = chatProductInfo.thumbUrl;
                this.price = chatProductInfo.price;
                this.quantity = chatProductInfo.quantity;
                this.snapshopid = chatProductInfo.snapshopid;
                this.modelname = chatProductInfo.modelname;
                this.price_before_discount = chatProductInfo.price_before_discount;
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

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder thumbUrl(String str) {
            this.thumbUrl = str;
            return this;
        }

        public Builder price(String str) {
            this.price = str;
            return this;
        }

        public Builder quantity(Integer num) {
            this.quantity = num;
            return this;
        }

        public Builder snapshopid(Long l) {
            this.snapshopid = l;
            return this;
        }

        public Builder modelname(String str) {
            this.modelname = str;
            return this;
        }

        public Builder price_before_discount(String str) {
            this.price_before_discount = str;
            return this;
        }

        public ChatProductInfo build() {
            return new ChatProductInfo(this);
        }
    }
}
