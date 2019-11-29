package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopFollow extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public ShopFollow(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.userid = num;
        this.shopid = num2;
        this.status = num3;
        this.ctime = num4;
        this.id = num5;
    }

    private ShopFollow(Builder builder) {
        this(builder.userid, builder.shopid, builder.status, builder.ctime, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopFollow)) {
            return false;
        }
        ShopFollow shopFollow = (ShopFollow) obj;
        if (!equals((Object) this.userid, (Object) shopFollow.userid) || !equals((Object) this.shopid, (Object) shopFollow.shopid) || !equals((Object) this.status, (Object) shopFollow.status) || !equals((Object) this.ctime, (Object) shopFollow.ctime) || !equals((Object) this.id, (Object) shopFollow.id)) {
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
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.id;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopFollow> {
        public Integer ctime;
        public Integer id;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ShopFollow shopFollow) {
            super(shopFollow);
            if (shopFollow != null) {
                this.userid = shopFollow.userid;
                this.shopid = shopFollow.shopid;
                this.status = shopFollow.status;
                this.ctime = shopFollow.ctime;
                this.id = shopFollow.id;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public ShopFollow build() {
            checkRequiredFields();
            return new ShopFollow(this);
        }
    }
}
