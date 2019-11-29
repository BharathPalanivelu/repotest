package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SPUSynonym extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_SPUID = 0L;
    public static final String DEFAULT_SPU_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String spu_name;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long spuid;

    public SPUSynonym(String str, Long l, String str2) {
        this.country = str;
        this.spuid = l;
        this.spu_name = str2;
    }

    private SPUSynonym(Builder builder) {
        this(builder.country, builder.spuid, builder.spu_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SPUSynonym)) {
            return false;
        }
        SPUSynonym sPUSynonym = (SPUSynonym) obj;
        if (!equals((Object) this.country, (Object) sPUSynonym.country) || !equals((Object) this.spuid, (Object) sPUSynonym.spuid) || !equals((Object) this.spu_name, (Object) sPUSynonym.spu_name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.country;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.spuid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.spu_name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SPUSynonym> {
        public String country;
        public String spu_name;
        public Long spuid;

        public Builder() {
        }

        public Builder(SPUSynonym sPUSynonym) {
            super(sPUSynonym);
            if (sPUSynonym != null) {
                this.country = sPUSynonym.country;
                this.spuid = sPUSynonym.spuid;
                this.spu_name = sPUSynonym.spu_name;
            }
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder spuid(Long l) {
            this.spuid = l;
            return this;
        }

        public Builder spu_name(String str) {
            this.spu_name = str;
            return this;
        }

        public SPUSynonym build() {
            return new SPUSynonym(this);
        }
    }
}
