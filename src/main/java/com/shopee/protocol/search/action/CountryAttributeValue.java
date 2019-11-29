package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CountryAttributeValue extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String value;

    public CountryAttributeValue(String str, String str2) {
        this.country = str;
        this.value = str2;
    }

    private CountryAttributeValue(Builder builder) {
        this(builder.country, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CountryAttributeValue)) {
            return false;
        }
        CountryAttributeValue countryAttributeValue = (CountryAttributeValue) obj;
        if (!equals((Object) this.country, (Object) countryAttributeValue.country) || !equals((Object) this.value, (Object) countryAttributeValue.value)) {
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
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CountryAttributeValue> {
        public String country;
        public String value;

        public Builder() {
        }

        public Builder(CountryAttributeValue countryAttributeValue) {
            super(countryAttributeValue);
            if (countryAttributeValue != null) {
                this.country = countryAttributeValue.country;
                this.value = countryAttributeValue.value;
            }
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public CountryAttributeValue build() {
            return new CountryAttributeValue(this);
        }
    }
}
