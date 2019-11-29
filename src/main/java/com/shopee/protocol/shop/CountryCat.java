package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CountryCat extends Message {
    public static final List<Integer> DEFAULT_CATEGORY = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> category;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String country;

    public CountryCat(String str, List<Integer> list) {
        this.country = str;
        this.category = immutableCopyOf(list);
    }

    private CountryCat(Builder builder) {
        this(builder.country, builder.category);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CountryCat)) {
            return false;
        }
        CountryCat countryCat = (CountryCat) obj;
        if (!equals((Object) this.country, (Object) countryCat.country) || !equals((List<?>) this.category, (List<?>) countryCat.category)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<Integer> list = this.category;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CountryCat> {
        public List<Integer> category;
        public String country;

        public Builder() {
        }

        public Builder(CountryCat countryCat) {
            super(countryCat);
            if (countryCat != null) {
                this.country = countryCat.country;
                this.category = CountryCat.copyOf(countryCat.category);
            }
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder category(List<Integer> list) {
            this.category = checkForNulls(list);
            return this;
        }

        public CountryCat build() {
            return new CountryCat(this);
        }
    }
}
