package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PListBoostMeta extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_PARENT_CATEGORY = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Double DEFAULT_VALUE = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer parent_category;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double value;

    public PListBoostMeta(Long l, Double d2, Integer num, String str, Integer num2, Integer num3) {
        this.itemid = l;
        this.value = d2;
        this.shopid = num;
        this.country = str;
        this.parent_category = num2;
        this.ctime = num3;
    }

    private PListBoostMeta(Builder builder) {
        this(builder.itemid, builder.value, builder.shopid, builder.country, builder.parent_category, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListBoostMeta)) {
            return false;
        }
        PListBoostMeta pListBoostMeta = (PListBoostMeta) obj;
        if (!equals((Object) this.itemid, (Object) pListBoostMeta.itemid) || !equals((Object) this.value, (Object) pListBoostMeta.value) || !equals((Object) this.shopid, (Object) pListBoostMeta.shopid) || !equals((Object) this.country, (Object) pListBoostMeta.country) || !equals((Object) this.parent_category, (Object) pListBoostMeta.parent_category) || !equals((Object) this.ctime, (Object) pListBoostMeta.ctime)) {
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
        Double d2 = this.value;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.parent_category;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListBoostMeta> {
        public String country;
        public Integer ctime;
        public Long itemid;
        public Integer parent_category;
        public Integer shopid;
        public Double value;

        public Builder() {
        }

        public Builder(PListBoostMeta pListBoostMeta) {
            super(pListBoostMeta);
            if (pListBoostMeta != null) {
                this.itemid = pListBoostMeta.itemid;
                this.value = pListBoostMeta.value;
                this.shopid = pListBoostMeta.shopid;
                this.country = pListBoostMeta.country;
                this.parent_category = pListBoostMeta.parent_category;
                this.ctime = pListBoostMeta.ctime;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder value(Double d2) {
            this.value = d2;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder parent_category(Integer num) {
            this.parent_category = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public PListBoostMeta build() {
            return new PListBoostMeta(this);
        }
    }
}
