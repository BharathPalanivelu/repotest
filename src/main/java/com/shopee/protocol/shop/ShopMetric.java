package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ShopMetric extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_VALUE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer value;

    public ShopMetric(Integer num, Integer num2, Integer num3, Integer num4, f fVar, String str, Integer num5) {
        this.shopid = num;
        this.type = num2;
        this.value = num3;
        this.ctime = num4;
        this.extinfo = fVar;
        this.country = str;
        this.id = num5;
    }

    private ShopMetric(Builder builder) {
        this(builder.shopid, builder.type, builder.value, builder.ctime, builder.extinfo, builder.country, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopMetric)) {
            return false;
        }
        ShopMetric shopMetric = (ShopMetric) obj;
        if (!equals((Object) this.shopid, (Object) shopMetric.shopid) || !equals((Object) this.type, (Object) shopMetric.type) || !equals((Object) this.value, (Object) shopMetric.value) || !equals((Object) this.ctime, (Object) shopMetric.ctime) || !equals((Object) this.extinfo, (Object) shopMetric.extinfo) || !equals((Object) this.country, (Object) shopMetric.country) || !equals((Object) this.id, (Object) shopMetric.id)) {
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
        Integer num2 = this.type;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.value;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode5 = (hashCode4 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.id;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopMetric> {
        public String country;
        public Integer ctime;
        public f extinfo;
        public Integer id;
        public Integer shopid;
        public Integer type;
        public Integer value;

        public Builder() {
        }

        public Builder(ShopMetric shopMetric) {
            super(shopMetric);
            if (shopMetric != null) {
                this.shopid = shopMetric.shopid;
                this.type = shopMetric.type;
                this.value = shopMetric.value;
                this.ctime = shopMetric.ctime;
                this.extinfo = shopMetric.extinfo;
                this.country = shopMetric.country;
                this.id = shopMetric.id;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder value(Integer num) {
            this.value = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public ShopMetric build() {
            return new ShopMetric(this);
        }
    }
}
