package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class HotHashTagCtrDataInfo extends Message {
    public static final Integer DEFAULT_BEGIN_TIME = 0;
    public static final String DEFAULT_COVER_IMAGE = "";
    public static final Integer DEFAULT_END_TIME = 0;
    public static final String DEFAULT_HASHTAG = "";
    public static final Integer DEFAULT_INDEX = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer begin_time;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String cover_image;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String hashtag;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer index;

    public HotHashTagCtrDataInfo(String str, Integer num, Integer num2, Integer num3, String str2) {
        this.hashtag = str;
        this.begin_time = num;
        this.end_time = num2;
        this.index = num3;
        this.cover_image = str2;
    }

    private HotHashTagCtrDataInfo(Builder builder) {
        this(builder.hashtag, builder.begin_time, builder.end_time, builder.index, builder.cover_image);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HotHashTagCtrDataInfo)) {
            return false;
        }
        HotHashTagCtrDataInfo hotHashTagCtrDataInfo = (HotHashTagCtrDataInfo) obj;
        if (!equals((Object) this.hashtag, (Object) hotHashTagCtrDataInfo.hashtag) || !equals((Object) this.begin_time, (Object) hotHashTagCtrDataInfo.begin_time) || !equals((Object) this.end_time, (Object) hotHashTagCtrDataInfo.end_time) || !equals((Object) this.index, (Object) hotHashTagCtrDataInfo.index) || !equals((Object) this.cover_image, (Object) hotHashTagCtrDataInfo.cover_image)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.hashtag;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.begin_time;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_time;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.index;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.cover_image;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HotHashTagCtrDataInfo> {
        public Integer begin_time;
        public String cover_image;
        public Integer end_time;
        public String hashtag;
        public Integer index;

        public Builder() {
        }

        public Builder(HotHashTagCtrDataInfo hotHashTagCtrDataInfo) {
            super(hotHashTagCtrDataInfo);
            if (hotHashTagCtrDataInfo != null) {
                this.hashtag = hotHashTagCtrDataInfo.hashtag;
                this.begin_time = hotHashTagCtrDataInfo.begin_time;
                this.end_time = hotHashTagCtrDataInfo.end_time;
                this.index = hotHashTagCtrDataInfo.index;
                this.cover_image = hotHashTagCtrDataInfo.cover_image;
            }
        }

        public Builder hashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public Builder begin_time(Integer num) {
            this.begin_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder index(Integer num) {
            this.index = num;
            return this;
        }

        public Builder cover_image(String str) {
            this.cover_image = str;
            return this;
        }

        public HotHashTagCtrDataInfo build() {
            return new HotHashTagCtrDataInfo(this);
        }
    }
}
