package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemCmtCoin extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Long DEFAULT_COINS = 0L;
    public static final Integer DEFAULT_COIN_STATUS = 0;
    public static final String DEFAULT_COMMENT = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_IMAGES = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer coin_status;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long coins;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String comment;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String images;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ItemCmtCoin(Long l, Integer num, Integer num2, Long l2, String str, String str2, Long l3, Integer num3, Integer num4, Long l4, String str3) {
        this.cmtid = l;
        this.userid = num;
        this.shopid = num2;
        this.itemid = l2;
        this.comment = str;
        this.images = str2;
        this.coins = l3;
        this.coin_status = num3;
        this.ctime = num4;
        this.orderid = l4;
        this.country = str3;
    }

    private ItemCmtCoin(Builder builder) {
        this(builder.cmtid, builder.userid, builder.shopid, builder.itemid, builder.comment, builder.images, builder.coins, builder.coin_status, builder.ctime, builder.orderid, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemCmtCoin)) {
            return false;
        }
        ItemCmtCoin itemCmtCoin = (ItemCmtCoin) obj;
        if (!equals((Object) this.cmtid, (Object) itemCmtCoin.cmtid) || !equals((Object) this.userid, (Object) itemCmtCoin.userid) || !equals((Object) this.shopid, (Object) itemCmtCoin.shopid) || !equals((Object) this.itemid, (Object) itemCmtCoin.itemid) || !equals((Object) this.comment, (Object) itemCmtCoin.comment) || !equals((Object) this.images, (Object) itemCmtCoin.images) || !equals((Object) this.coins, (Object) itemCmtCoin.coins) || !equals((Object) this.coin_status, (Object) itemCmtCoin.coin_status) || !equals((Object) this.ctime, (Object) itemCmtCoin.ctime) || !equals((Object) this.orderid, (Object) itemCmtCoin.orderid) || !equals((Object) this.country, (Object) itemCmtCoin.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.cmtid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.comment;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.images;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l3 = this.coins;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num3 = this.coin_status;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l4 = this.orderid;
        int hashCode10 = (hashCode9 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemCmtCoin> {
        public Long cmtid;
        public Integer coin_status;
        public Long coins;
        public String comment;
        public String country;
        public Integer ctime;
        public String images;
        public Long itemid;
        public Long orderid;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(ItemCmtCoin itemCmtCoin) {
            super(itemCmtCoin);
            if (itemCmtCoin != null) {
                this.cmtid = itemCmtCoin.cmtid;
                this.userid = itemCmtCoin.userid;
                this.shopid = itemCmtCoin.shopid;
                this.itemid = itemCmtCoin.itemid;
                this.comment = itemCmtCoin.comment;
                this.images = itemCmtCoin.images;
                this.coins = itemCmtCoin.coins;
                this.coin_status = itemCmtCoin.coin_status;
                this.ctime = itemCmtCoin.ctime;
                this.orderid = itemCmtCoin.orderid;
                this.country = itemCmtCoin.country;
            }
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder comment(String str) {
            this.comment = str;
            return this;
        }

        public Builder images(String str) {
            this.images = str;
            return this;
        }

        public Builder coins(Long l) {
            this.coins = l;
            return this;
        }

        public Builder coin_status(Integer num) {
            this.coin_status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public ItemCmtCoin build() {
            return new ItemCmtCoin(this);
        }
    }
}
