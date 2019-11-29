package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TierVariation extends Message {
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    public static final String DEFAULT_NAME = "";
    public static final List<String> DEFAULT_OPTIONS = Collections.emptyList();
    public static final List<TierProperty> DEFAULT_PROPERTIES = Collections.emptyList();
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> images;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> options;
    @ProtoField(label = Message.Label.REPEATED, messageType = TierProperty.class, tag = 5)
    public final List<TierProperty> properties;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer type;

    public TierVariation(String str, List<String> list, List<String> list2, List<TierProperty> list3, Integer num) {
        this.name = str;
        this.options = immutableCopyOf(list);
        this.images = immutableCopyOf(list2);
        this.properties = immutableCopyOf(list3);
        this.type = num;
    }

    private TierVariation(Builder builder) {
        this(builder.name, builder.options, builder.images, builder.properties, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TierVariation)) {
            return false;
        }
        TierVariation tierVariation = (TierVariation) obj;
        if (!equals((Object) this.name, (Object) tierVariation.name) || !equals((List<?>) this.options, (List<?>) tierVariation.options) || !equals((List<?>) this.images, (List<?>) tierVariation.images) || !equals((List<?>) this.properties, (List<?>) tierVariation.properties) || !equals((Object) this.type, (Object) tierVariation.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<String> list = this.options;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<String> list2 = this.images;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<TierProperty> list3 = this.properties;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        Integer num = this.type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<TierVariation> {
        public List<String> images;
        public String name;
        public List<String> options;
        public List<TierProperty> properties;
        public Integer type;

        public Builder() {
        }

        public Builder(TierVariation tierVariation) {
            super(tierVariation);
            if (tierVariation != null) {
                this.name = tierVariation.name;
                this.options = TierVariation.copyOf(tierVariation.options);
                this.images = TierVariation.copyOf(tierVariation.images);
                this.properties = TierVariation.copyOf(tierVariation.properties);
                this.type = tierVariation.type;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder options(List<String> list) {
            this.options = checkForNulls(list);
            return this;
        }

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder properties(List<TierProperty> list) {
            this.properties = checkForNulls(list);
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public TierVariation build() {
            return new TierVariation(this);
        }
    }
}
