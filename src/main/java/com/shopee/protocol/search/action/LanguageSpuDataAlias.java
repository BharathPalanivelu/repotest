package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LanguageSpuDataAlias extends Message {
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_SELLING_POINT = "";
    public static final String DEFAULT_SPU_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String language;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String selling_point;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String spu_name;

    public LanguageSpuDataAlias(String str, String str2, String str3) {
        this.language = str;
        this.spu_name = str2;
        this.selling_point = str3;
    }

    private LanguageSpuDataAlias(Builder builder) {
        this(builder.language, builder.spu_name, builder.selling_point);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LanguageSpuDataAlias)) {
            return false;
        }
        LanguageSpuDataAlias languageSpuDataAlias = (LanguageSpuDataAlias) obj;
        if (!equals((Object) this.language, (Object) languageSpuDataAlias.language) || !equals((Object) this.spu_name, (Object) languageSpuDataAlias.spu_name) || !equals((Object) this.selling_point, (Object) languageSpuDataAlias.selling_point)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.language;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.spu_name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.selling_point;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LanguageSpuDataAlias> {
        public String language;
        public String selling_point;
        public String spu_name;

        public Builder() {
        }

        public Builder(LanguageSpuDataAlias languageSpuDataAlias) {
            super(languageSpuDataAlias);
            if (languageSpuDataAlias != null) {
                this.language = languageSpuDataAlias.language;
                this.spu_name = languageSpuDataAlias.spu_name;
                this.selling_point = languageSpuDataAlias.selling_point;
            }
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder spu_name(String str) {
            this.spu_name = str;
            return this;
        }

        public Builder selling_point(String str) {
            this.selling_point = str;
            return this;
        }

        public LanguageSpuDataAlias build() {
            return new LanguageSpuDataAlias(this);
        }
    }
}
