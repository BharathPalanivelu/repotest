package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SlashPriceActivityInfo extends Message {
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    public static final String DEFAULT_MODEL_NAME = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_ORIGINAL_EXPIRY_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> images;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String model_name;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer original_expiry_time;

    public SlashPriceActivityInfo(String str, List<String> list, Integer num, String str2) {
        this.name = str;
        this.images = immutableCopyOf(list);
        this.original_expiry_time = num;
        this.model_name = str2;
    }

    private SlashPriceActivityInfo(Builder builder) {
        this(builder.name, builder.images, builder.original_expiry_time, builder.model_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceActivityInfo)) {
            return false;
        }
        SlashPriceActivityInfo slashPriceActivityInfo = (SlashPriceActivityInfo) obj;
        if (!equals((Object) this.name, (Object) slashPriceActivityInfo.name) || !equals((List<?>) this.images, (List<?>) slashPriceActivityInfo.images) || !equals((Object) this.original_expiry_time, (Object) slashPriceActivityInfo.original_expiry_time) || !equals((Object) this.model_name, (Object) slashPriceActivityInfo.model_name)) {
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
        List<String> list = this.images;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.original_expiry_time;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.model_name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceActivityInfo> {
        public List<String> images;
        public String model_name;
        public String name;
        public Integer original_expiry_time;

        public Builder() {
        }

        public Builder(SlashPriceActivityInfo slashPriceActivityInfo) {
            super(slashPriceActivityInfo);
            if (slashPriceActivityInfo != null) {
                this.name = slashPriceActivityInfo.name;
                this.images = SlashPriceActivityInfo.copyOf(slashPriceActivityInfo.images);
                this.original_expiry_time = slashPriceActivityInfo.original_expiry_time;
                this.model_name = slashPriceActivityInfo.model_name;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder original_expiry_time(Integer num) {
            this.original_expiry_time = num;
            return this;
        }

        public Builder model_name(String str) {
            this.model_name = str;
            return this;
        }

        public SlashPriceActivityInfo build() {
            return new SlashPriceActivityInfo(this);
        }
    }
}
