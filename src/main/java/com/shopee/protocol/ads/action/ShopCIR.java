package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopCIR extends Message {
    public static final Double DEFAULT_CIR = Double.valueOf(0.0d);
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Long DEFAULT_SHOPID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double cir;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer status;

    public ShopCIR(Long l, Integer num, Long l2, Long l3, Double d2) {
        this.shopid = l;
        this.status = num;
        this.ctime = l2;
        this.mtime = l3;
        this.cir = d2;
    }

    private ShopCIR(Builder builder) {
        this(builder.shopid, builder.status, builder.ctime, builder.mtime, builder.cir);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCIR)) {
            return false;
        }
        ShopCIR shopCIR = (ShopCIR) obj;
        if (!equals((Object) this.shopid, (Object) shopCIR.shopid) || !equals((Object) this.status, (Object) shopCIR.status) || !equals((Object) this.ctime, (Object) shopCIR.ctime) || !equals((Object) this.mtime, (Object) shopCIR.mtime) || !equals((Object) this.cir, (Object) shopCIR.cir)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.shopid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.status;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.ctime;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.mtime;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Double d2 = this.cir;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCIR> {
        public Double cir;
        public Long ctime;
        public Long mtime;
        public Long shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(ShopCIR shopCIR) {
            super(shopCIR);
            if (shopCIR != null) {
                this.shopid = shopCIR.shopid;
                this.status = shopCIR.status;
                this.ctime = shopCIR.ctime;
                this.mtime = shopCIR.mtime;
                this.cir = shopCIR.cir;
            }
        }

        public Builder shopid(Long l) {
            this.shopid = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder cir(Double d2) {
            this.cir = d2;
            return this;
        }

        public ShopCIR build() {
            return new ShopCIR(this);
        }
    }
}
