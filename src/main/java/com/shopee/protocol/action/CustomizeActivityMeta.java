package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CustomizeActivityMeta extends Message {
    public static final String DEFAULT_AVATAR_IMAGE = "";
    public static final Boolean DEFAULT_IS_WEBPAGE_URL = false;
    public static final Boolean DEFAULT_NEED_GENERATE = false;
    public static final String DEFAULT_PRODUCT_IMAGE = "";
    public static final String DEFAULT_REDIRECT_URL = "";
    public static final f DEFAULT_TEXT = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String avatar_image;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_webpage_url;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean need_generate;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String product_image;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String redirect_url;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f text;

    public CustomizeActivityMeta(String str, String str2, f fVar, String str3, Boolean bool, Boolean bool2) {
        this.avatar_image = str;
        this.product_image = str2;
        this.text = fVar;
        this.redirect_url = str3;
        this.is_webpage_url = bool;
        this.need_generate = bool2;
    }

    private CustomizeActivityMeta(Builder builder) {
        this(builder.avatar_image, builder.product_image, builder.text, builder.redirect_url, builder.is_webpage_url, builder.need_generate);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomizeActivityMeta)) {
            return false;
        }
        CustomizeActivityMeta customizeActivityMeta = (CustomizeActivityMeta) obj;
        if (!equals((Object) this.avatar_image, (Object) customizeActivityMeta.avatar_image) || !equals((Object) this.product_image, (Object) customizeActivityMeta.product_image) || !equals((Object) this.text, (Object) customizeActivityMeta.text) || !equals((Object) this.redirect_url, (Object) customizeActivityMeta.redirect_url) || !equals((Object) this.is_webpage_url, (Object) customizeActivityMeta.is_webpage_url) || !equals((Object) this.need_generate, (Object) customizeActivityMeta.need_generate)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.avatar_image;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.product_image;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.text;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str3 = this.redirect_url;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.is_webpage_url;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_generate;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CustomizeActivityMeta> {
        public String avatar_image;
        public Boolean is_webpage_url;
        public Boolean need_generate;
        public String product_image;
        public String redirect_url;
        public f text;

        public Builder() {
        }

        public Builder(CustomizeActivityMeta customizeActivityMeta) {
            super(customizeActivityMeta);
            if (customizeActivityMeta != null) {
                this.avatar_image = customizeActivityMeta.avatar_image;
                this.product_image = customizeActivityMeta.product_image;
                this.text = customizeActivityMeta.text;
                this.redirect_url = customizeActivityMeta.redirect_url;
                this.is_webpage_url = customizeActivityMeta.is_webpage_url;
                this.need_generate = customizeActivityMeta.need_generate;
            }
        }

        public Builder avatar_image(String str) {
            this.avatar_image = str;
            return this;
        }

        public Builder product_image(String str) {
            this.product_image = str;
            return this;
        }

        public Builder text(f fVar) {
            this.text = fVar;
            return this;
        }

        public Builder redirect_url(String str) {
            this.redirect_url = str;
            return this;
        }

        public Builder is_webpage_url(Boolean bool) {
            this.is_webpage_url = bool;
            return this;
        }

        public Builder need_generate(Boolean bool) {
            this.need_generate = bool;
            return this;
        }

        public CustomizeActivityMeta build() {
            return new CustomizeActivityMeta(this);
        }
    }
}
