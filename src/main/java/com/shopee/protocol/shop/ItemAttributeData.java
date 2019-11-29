package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemAttributeData extends Message {
    public static final Integer DEFAULT_BRAND_OPTION = 0;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Integer DEFAULT_IS_FILTER = 0;
    public static final Integer DEFAULT_MANDATORY_MALL = 0;
    public static final List<AttributeMultiLang> DEFAULT_MULTI_LANG = Collections.emptyList();
    public static final String DEFAULT_PLACEHOLDER = "";
    public static final String DEFAULT_TOOLTIP = "";
    public static final List<String> DEFAULT_VALUE = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer brand_option;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer is_filter;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mandatory_mall;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeMultiLang.class, tag = 7)
    public final List<AttributeMultiLang> multi_lang;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String placeholder;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String tooltip;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> value;

    public ItemAttributeData(List<String> list, String str, Integer num, String str2, String str3, Integer num2, List<AttributeMultiLang> list2, Integer num3) {
        this.value = immutableCopyOf(list);
        this.description = str;
        this.brand_option = num;
        this.tooltip = str2;
        this.placeholder = str3;
        this.is_filter = num2;
        this.multi_lang = immutableCopyOf(list2);
        this.mandatory_mall = num3;
    }

    private ItemAttributeData(Builder builder) {
        this(builder.value, builder.description, builder.brand_option, builder.tooltip, builder.placeholder, builder.is_filter, builder.multi_lang, builder.mandatory_mall);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemAttributeData)) {
            return false;
        }
        ItemAttributeData itemAttributeData = (ItemAttributeData) obj;
        if (!equals((List<?>) this.value, (List<?>) itemAttributeData.value) || !equals((Object) this.description, (Object) itemAttributeData.description) || !equals((Object) this.brand_option, (Object) itemAttributeData.brand_option) || !equals((Object) this.tooltip, (Object) itemAttributeData.tooltip) || !equals((Object) this.placeholder, (Object) itemAttributeData.placeholder) || !equals((Object) this.is_filter, (Object) itemAttributeData.is_filter) || !equals((List<?>) this.multi_lang, (List<?>) itemAttributeData.multi_lang) || !equals((Object) this.mandatory_mall, (Object) itemAttributeData.mandatory_mall)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<String> list = this.value;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.description;
        int i3 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.brand_option;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.tooltip;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.placeholder;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.is_filter;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<AttributeMultiLang> list2 = this.multi_lang;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i4 = (hashCode6 + i2) * 37;
        Integer num3 = this.mandatory_mall;
        if (num3 != null) {
            i3 = num3.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ItemAttributeData> {
        public Integer brand_option;
        public String description;
        public Integer is_filter;
        public Integer mandatory_mall;
        public List<AttributeMultiLang> multi_lang;
        public String placeholder;
        public String tooltip;
        public List<String> value;

        public Builder() {
        }

        public Builder(ItemAttributeData itemAttributeData) {
            super(itemAttributeData);
            if (itemAttributeData != null) {
                this.value = ItemAttributeData.copyOf(itemAttributeData.value);
                this.description = itemAttributeData.description;
                this.brand_option = itemAttributeData.brand_option;
                this.tooltip = itemAttributeData.tooltip;
                this.placeholder = itemAttributeData.placeholder;
                this.is_filter = itemAttributeData.is_filter;
                this.multi_lang = ItemAttributeData.copyOf(itemAttributeData.multi_lang);
                this.mandatory_mall = itemAttributeData.mandatory_mall;
            }
        }

        public Builder value(List<String> list) {
            this.value = checkForNulls(list);
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder brand_option(Integer num) {
            this.brand_option = num;
            return this;
        }

        public Builder tooltip(String str) {
            this.tooltip = str;
            return this;
        }

        public Builder placeholder(String str) {
            this.placeholder = str;
            return this;
        }

        public Builder is_filter(Integer num) {
            this.is_filter = num;
            return this;
        }

        public Builder multi_lang(List<AttributeMultiLang> list) {
            this.multi_lang = checkForNulls(list);
            return this;
        }

        public Builder mandatory_mall(Integer num) {
            this.mandatory_mall = num;
            return this;
        }

        public ItemAttributeData build() {
            return new ItemAttributeData(this);
        }
    }
}
