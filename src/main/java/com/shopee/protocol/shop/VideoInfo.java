package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VideoInfo extends Message {
    public static final Integer DEFAULT_DURATION = 0;
    public static final String DEFAULT_THUMB_URL = "";
    public static final String DEFAULT_VIDEO_ID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer duration;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String thumb_url;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String video_id;

    public VideoInfo(String str, String str2, Integer num) {
        this.video_id = str;
        this.thumb_url = str2;
        this.duration = num;
    }

    private VideoInfo(Builder builder) {
        this(builder.video_id, builder.thumb_url, builder.duration);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        if (!equals((Object) this.video_id, (Object) videoInfo.video_id) || !equals((Object) this.thumb_url, (Object) videoInfo.thumb_url) || !equals((Object) this.duration, (Object) videoInfo.duration)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.video_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.thumb_url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.duration;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VideoInfo> {
        public Integer duration;
        public String thumb_url;
        public String video_id;

        public Builder() {
        }

        public Builder(VideoInfo videoInfo) {
            super(videoInfo);
            if (videoInfo != null) {
                this.video_id = videoInfo.video_id;
                this.thumb_url = videoInfo.thumb_url;
                this.duration = videoInfo.duration;
            }
        }

        public Builder video_id(String str) {
            this.video_id = str;
            return this;
        }

        public Builder thumb_url(String str) {
            this.thumb_url = str;
            return this;
        }

        public Builder duration(Integer num) {
            this.duration = num;
            return this;
        }

        public VideoInfo build() {
            return new VideoInfo(this);
        }
    }
}
