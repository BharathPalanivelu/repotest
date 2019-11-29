package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SellerOrderCntInfo extends Message {
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SELLER_RETURN = 0;
    public static final Integer DEFAULT_SELLER_TOPAY = 0;
    public static final Integer DEFAULT_SELLER_TORECEICE = 0;
    public static final Integer DEFAULT_SELLER_TOSHIP = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer seller_return;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer seller_topay;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer seller_toreceice;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer seller_toship;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public SellerOrderCntInfo(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.shopid = num;
        this.seller_topay = num2;
        this.seller_toship = num3;
        this.seller_toreceice = num4;
        this.seller_return = num5;
        this.mtime = num6;
    }

    private SellerOrderCntInfo(Builder builder) {
        this(builder.shopid, builder.seller_topay, builder.seller_toship, builder.seller_toreceice, builder.seller_return, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerOrderCntInfo)) {
            return false;
        }
        SellerOrderCntInfo sellerOrderCntInfo = (SellerOrderCntInfo) obj;
        if (!equals((Object) this.shopid, (Object) sellerOrderCntInfo.shopid) || !equals((Object) this.seller_topay, (Object) sellerOrderCntInfo.seller_topay) || !equals((Object) this.seller_toship, (Object) sellerOrderCntInfo.seller_toship) || !equals((Object) this.seller_toreceice, (Object) sellerOrderCntInfo.seller_toreceice) || !equals((Object) this.seller_return, (Object) sellerOrderCntInfo.seller_return) || !equals((Object) this.mtime, (Object) sellerOrderCntInfo.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.seller_topay;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.seller_toship;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.seller_toreceice;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.seller_return;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.mtime;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerOrderCntInfo> {
        public Integer mtime;
        public Integer seller_return;
        public Integer seller_topay;
        public Integer seller_toreceice;
        public Integer seller_toship;
        public Integer shopid;

        public Builder() {
        }

        public Builder(SellerOrderCntInfo sellerOrderCntInfo) {
            super(sellerOrderCntInfo);
            if (sellerOrderCntInfo != null) {
                this.shopid = sellerOrderCntInfo.shopid;
                this.seller_topay = sellerOrderCntInfo.seller_topay;
                this.seller_toship = sellerOrderCntInfo.seller_toship;
                this.seller_toreceice = sellerOrderCntInfo.seller_toreceice;
                this.seller_return = sellerOrderCntInfo.seller_return;
                this.mtime = sellerOrderCntInfo.mtime;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder seller_topay(Integer num) {
            this.seller_topay = num;
            return this;
        }

        public Builder seller_toship(Integer num) {
            this.seller_toship = num;
            return this;
        }

        public Builder seller_toreceice(Integer num) {
            this.seller_toreceice = num;
            return this;
        }

        public Builder seller_return(Integer num) {
            this.seller_return = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public SellerOrderCntInfo build() {
            return new SellerOrderCntInfo(this);
        }
    }
}
