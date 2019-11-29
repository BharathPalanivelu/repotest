package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BriefItem extends Message {
    public static final String DEFAULT_IMAGEURL = "";
    public static final Integer DEFAULT_IS_ADULT = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String imageurl;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer is_adult;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public BriefItem(Long l, Integer num, String str, String str2, Long l2, Integer num2) {
        this.itemid = l;
        this.shopid = num;
        this.name = str;
        this.imageurl = str2;
        this.price = l2;
        this.is_adult = num2;
    }

    private BriefItem(Builder builder) {
        this(builder.itemid, builder.shopid, builder.name, builder.imageurl, builder.price, builder.is_adult);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BriefItem)) {
            return false;
        }
        BriefItem briefItem = (BriefItem) obj;
        if (!equals((Object) this.itemid, (Object) briefItem.itemid) || !equals((Object) this.shopid, (Object) briefItem.shopid) || !equals((Object) this.name, (Object) briefItem.name) || !equals((Object) this.imageurl, (Object) briefItem.imageurl) || !equals((Object) this.price, (Object) briefItem.price) || !equals((Object) this.is_adult, (Object) briefItem.is_adult)) {
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
        String str2 = this.imageurl;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.price;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.is_adult;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BriefItem> {
        public String imageurl;
        public Integer is_adult;
        public Long itemid;
        public String name;
        public Long price;
        public Integer shopid;

        public Builder() {
        }

        public Builder(BriefItem briefItem) {
            super(briefItem);
            if (briefItem != null) {
                this.itemid = briefItem.itemid;
                this.shopid = briefItem.shopid;
                this.name = briefItem.name;
                this.imageurl = briefItem.imageurl;
                this.price = briefItem.price;
                this.is_adult = briefItem.is_adult;
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

        public Builder imageurl(String str) {
            this.imageurl = str;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder is_adult(Integer num) {
            this.is_adult = num;
            return this;
        }

        public BriefItem build() {
            return new BriefItem(this);
        }
    }
}
