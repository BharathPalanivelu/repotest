package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopCover extends Message {
    public static final String DEFAULT_IMAGE_URL = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String image_url;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String video_url;

    public ShopCover(Integer num, String str, String str2) {
        this.type = num;
        this.image_url = str;
        this.video_url = str2;
    }

    private ShopCover(Builder builder) {
        this(builder.type, builder.image_url, builder.video_url);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCover)) {
            return false;
        }
        ShopCover shopCover = (ShopCover) obj;
        if (!equals((Object) this.type, (Object) shopCover.type) || !equals((Object) this.image_url, (Object) shopCover.image_url) || !equals((Object) this.video_url, (Object) shopCover.video_url)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.image_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.video_url;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCover> {
        public String image_url;
        public Integer type;
        public String video_url;

        public Builder() {
        }

        public Builder(ShopCover shopCover) {
            super(shopCover);
            if (shopCover != null) {
                this.type = shopCover.type;
                this.image_url = shopCover.image_url;
                this.video_url = shopCover.video_url;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder image_url(String str) {
            this.image_url = str;
            return this;
        }

        public Builder video_url(String str) {
            this.video_url = str;
            return this;
        }

        public ShopCover build() {
            checkRequiredFields();
            return new ShopCover(this);
        }
    }
}
