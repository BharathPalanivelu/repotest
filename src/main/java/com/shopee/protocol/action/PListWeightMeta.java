package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PListWeightMeta extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Double DEFAULT_VALUE = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double value;

    public PListWeightMeta(Integer num, Integer num2, Double d2, String str) {
        this.catid = num;
        this.type = num2;
        this.value = d2;
        this.country = str;
    }

    private PListWeightMeta(Builder builder) {
        this(builder.catid, builder.type, builder.value, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListWeightMeta)) {
            return false;
        }
        PListWeightMeta pListWeightMeta = (PListWeightMeta) obj;
        if (!equals((Object) this.catid, (Object) pListWeightMeta.catid) || !equals((Object) this.type, (Object) pListWeightMeta.type) || !equals((Object) this.value, (Object) pListWeightMeta.value) || !equals((Object) this.country, (Object) pListWeightMeta.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.catid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.type;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Double d2 = this.value;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListWeightMeta> {
        public Integer catid;
        public String country;
        public Integer type;
        public Double value;

        public Builder() {
        }

        public Builder(PListWeightMeta pListWeightMeta) {
            super(pListWeightMeta);
            if (pListWeightMeta != null) {
                this.catid = pListWeightMeta.catid;
                this.type = pListWeightMeta.type;
                this.value = pListWeightMeta.value;
                this.country = pListWeightMeta.country;
            }
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder value(Double d2) {
            this.value = d2;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public PListWeightMeta build() {
            return new PListWeightMeta(this);
        }
    }
}
