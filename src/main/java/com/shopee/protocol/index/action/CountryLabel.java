package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CountryLabel extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LABEL = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer label;

    public CountryLabel(String str, Integer num) {
        this.country = str;
        this.label = num;
    }

    private CountryLabel(Builder builder) {
        this(builder.country, builder.label);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CountryLabel)) {
            return false;
        }
        CountryLabel countryLabel = (CountryLabel) obj;
        if (!equals((Object) this.country, (Object) countryLabel.country) || !equals((Object) this.label, (Object) countryLabel.label)) {
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
        Integer num = this.label;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CountryLabel> {
        public String country;
        public Integer label;

        public Builder() {
        }

        public Builder(CountryLabel countryLabel) {
            super(countryLabel);
            if (countryLabel != null) {
                this.country = countryLabel.country;
                this.label = countryLabel.label;
            }
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder label(Integer num) {
            this.label = num;
            return this;
        }

        public CountryLabel build() {
            return new CountryLabel(this);
        }
    }
}
