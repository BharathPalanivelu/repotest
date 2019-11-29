package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BuyerOrderCntInfo extends Message {
    public static final Integer DEFAULT_BUYER_RETURN = 0;
    public static final Integer DEFAULT_BUYER_SHIPPING = 0;
    public static final Integer DEFAULT_BUYER_TOSHIP = 0;
    public static final Integer DEFAULT_BUYER_UNPAID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer buyer_return;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer buyer_shipping;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer buyer_toship;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer buyer_unpaid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public BuyerOrderCntInfo(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.userid = num;
        this.buyer_unpaid = num2;
        this.buyer_toship = num3;
        this.buyer_shipping = num4;
        this.buyer_return = num5;
        this.mtime = num6;
    }

    private BuyerOrderCntInfo(Builder builder) {
        this(builder.userid, builder.buyer_unpaid, builder.buyer_toship, builder.buyer_shipping, builder.buyer_return, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyerOrderCntInfo)) {
            return false;
        }
        BuyerOrderCntInfo buyerOrderCntInfo = (BuyerOrderCntInfo) obj;
        if (!equals((Object) this.userid, (Object) buyerOrderCntInfo.userid) || !equals((Object) this.buyer_unpaid, (Object) buyerOrderCntInfo.buyer_unpaid) || !equals((Object) this.buyer_toship, (Object) buyerOrderCntInfo.buyer_toship) || !equals((Object) this.buyer_shipping, (Object) buyerOrderCntInfo.buyer_shipping) || !equals((Object) this.buyer_return, (Object) buyerOrderCntInfo.buyer_return) || !equals((Object) this.mtime, (Object) buyerOrderCntInfo.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.buyer_unpaid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.buyer_toship;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.buyer_shipping;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.buyer_return;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.mtime;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BuyerOrderCntInfo> {
        public Integer buyer_return;
        public Integer buyer_shipping;
        public Integer buyer_toship;
        public Integer buyer_unpaid;
        public Integer mtime;
        public Integer userid;

        public Builder() {
        }

        public Builder(BuyerOrderCntInfo buyerOrderCntInfo) {
            super(buyerOrderCntInfo);
            if (buyerOrderCntInfo != null) {
                this.userid = buyerOrderCntInfo.userid;
                this.buyer_unpaid = buyerOrderCntInfo.buyer_unpaid;
                this.buyer_toship = buyerOrderCntInfo.buyer_toship;
                this.buyer_shipping = buyerOrderCntInfo.buyer_shipping;
                this.buyer_return = buyerOrderCntInfo.buyer_return;
                this.mtime = buyerOrderCntInfo.mtime;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder buyer_unpaid(Integer num) {
            this.buyer_unpaid = num;
            return this;
        }

        public Builder buyer_toship(Integer num) {
            this.buyer_toship = num;
            return this;
        }

        public Builder buyer_shipping(Integer num) {
            this.buyer_shipping = num;
            return this;
        }

        public Builder buyer_return(Integer num) {
            this.buyer_return = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public BuyerOrderCntInfo build() {
            return new BuyerOrderCntInfo(this);
        }
    }
}
