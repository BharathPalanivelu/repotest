package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CountrySearchTerms extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final List<TermCategory> DEFAULT_TERMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, messageType = TermCategory.class, tag = 2)
    public final List<TermCategory> terms;

    public CountrySearchTerms(String str, List<TermCategory> list) {
        this.country = str;
        this.terms = immutableCopyOf(list);
    }

    private CountrySearchTerms(Builder builder) {
        this(builder.country, builder.terms);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CountrySearchTerms)) {
            return false;
        }
        CountrySearchTerms countrySearchTerms = (CountrySearchTerms) obj;
        if (!equals((Object) this.country, (Object) countrySearchTerms.country) || !equals((List<?>) this.terms, (List<?>) countrySearchTerms.terms)) {
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
        List<TermCategory> list = this.terms;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CountrySearchTerms> {
        public String country;
        public List<TermCategory> terms;

        public Builder() {
        }

        public Builder(CountrySearchTerms countrySearchTerms) {
            super(countrySearchTerms);
            if (countrySearchTerms != null) {
                this.country = countrySearchTerms.country;
                this.terms = CountrySearchTerms.copyOf(countrySearchTerms.terms);
            }
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder terms(List<TermCategory> list) {
            this.terms = checkForNulls(list);
            return this;
        }

        public CountrySearchTerms build() {
            return new CountrySearchTerms(this);
        }
    }
}
