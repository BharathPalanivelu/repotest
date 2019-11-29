package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AttributeMultiLang extends Message {
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_LANG = "";
    public static final String DEFAULT_PLACEHOLDER = "";
    public static final String DEFAULT_TOOLTIP = "";
    public static final List<String> DEFAULT_VALUE = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String display_name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String placeholder;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String tooltip;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> value;

    public AttributeMultiLang(String str, String str2, String str3, String str4, List<String> list) {
        this.lang = str;
        this.display_name = str2;
        this.placeholder = str3;
        this.tooltip = str4;
        this.value = immutableCopyOf(list);
    }

    private AttributeMultiLang(Builder builder) {
        this(builder.lang, builder.display_name, builder.placeholder, builder.tooltip, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeMultiLang)) {
            return false;
        }
        AttributeMultiLang attributeMultiLang = (AttributeMultiLang) obj;
        if (!equals((Object) this.lang, (Object) attributeMultiLang.lang) || !equals((Object) this.display_name, (Object) attributeMultiLang.display_name) || !equals((Object) this.placeholder, (Object) attributeMultiLang.placeholder) || !equals((Object) this.tooltip, (Object) attributeMultiLang.tooltip) || !equals((List<?>) this.value, (List<?>) attributeMultiLang.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.lang;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.display_name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.placeholder;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.tooltip;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<String> list = this.value;
        int hashCode4 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<AttributeMultiLang> {
        public String display_name;
        public String lang;
        public String placeholder;
        public String tooltip;
        public List<String> value;

        public Builder() {
        }

        public Builder(AttributeMultiLang attributeMultiLang) {
            super(attributeMultiLang);
            if (attributeMultiLang != null) {
                this.lang = attributeMultiLang.lang;
                this.display_name = attributeMultiLang.display_name;
                this.placeholder = attributeMultiLang.placeholder;
                this.tooltip = attributeMultiLang.tooltip;
                this.value = AttributeMultiLang.copyOf(attributeMultiLang.value);
            }
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder display_name(String str) {
            this.display_name = str;
            return this;
        }

        public Builder placeholder(String str) {
            this.placeholder = str;
            return this;
        }

        public Builder tooltip(String str) {
            this.tooltip = str;
            return this;
        }

        public Builder value(List<String> list) {
            this.value = checkForNulls(list);
            return this;
        }

        public AttributeMultiLang build() {
            checkRequiredFields();
            return new AttributeMultiLang(this);
        }
    }
}
