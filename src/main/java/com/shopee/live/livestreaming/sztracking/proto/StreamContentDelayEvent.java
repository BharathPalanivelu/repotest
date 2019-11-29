package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StreamContentDelayEvent extends Message {
    public static final String DEFAULT_AUDIO_RATE = "";
    public static final String DEFAULT_FPS = "";
    public static final String DEFAULT_GUEST_TIME = "";
    public static final String DEFAULT_HOST_TIME = "";
    public static final String DEFAULT_ROOM_ID = "";
    public static final String DEFAULT_SERVER_IP = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final String DEFAULT_VIDEO_RATE = "";
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String audio_rate;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String fps;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String guest_time;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String host_time;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String room_id;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String server_ip;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String session_id;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String video_rate;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String video_url;

    public StreamContentDelayEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.session_id = str;
        this.video_url = str2;
        this.room_id = str3;
        this.host_time = str4;
        this.guest_time = str5;
        this.fps = str6;
        this.video_rate = str7;
        this.audio_rate = str8;
        this.server_ip = str9;
    }

    private StreamContentDelayEvent(Builder builder) {
        this(builder.session_id, builder.video_url, builder.room_id, builder.host_time, builder.guest_time, builder.fps, builder.video_rate, builder.audio_rate, builder.server_ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamContentDelayEvent)) {
            return false;
        }
        StreamContentDelayEvent streamContentDelayEvent = (StreamContentDelayEvent) obj;
        if (!equals((Object) this.session_id, (Object) streamContentDelayEvent.session_id) || !equals((Object) this.video_url, (Object) streamContentDelayEvent.video_url) || !equals((Object) this.room_id, (Object) streamContentDelayEvent.room_id) || !equals((Object) this.host_time, (Object) streamContentDelayEvent.host_time) || !equals((Object) this.guest_time, (Object) streamContentDelayEvent.guest_time) || !equals((Object) this.fps, (Object) streamContentDelayEvent.fps) || !equals((Object) this.video_rate, (Object) streamContentDelayEvent.video_rate) || !equals((Object) this.audio_rate, (Object) streamContentDelayEvent.audio_rate) || !equals((Object) this.server_ip, (Object) streamContentDelayEvent.server_ip)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.session_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.video_url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.room_id;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.host_time;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.guest_time;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.fps;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.video_rate;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.audio_rate;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.server_ip;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StreamContentDelayEvent> {
        public String audio_rate;
        public String fps;
        public String guest_time;
        public String host_time;
        public String room_id;
        public String server_ip;
        public String session_id;
        public String video_rate;
        public String video_url;

        public Builder() {
        }

        public Builder(StreamContentDelayEvent streamContentDelayEvent) {
            super(streamContentDelayEvent);
            if (streamContentDelayEvent != null) {
                this.session_id = streamContentDelayEvent.session_id;
                this.video_url = streamContentDelayEvent.video_url;
                this.room_id = streamContentDelayEvent.room_id;
                this.host_time = streamContentDelayEvent.host_time;
                this.guest_time = streamContentDelayEvent.guest_time;
                this.fps = streamContentDelayEvent.fps;
                this.video_rate = streamContentDelayEvent.video_rate;
                this.audio_rate = streamContentDelayEvent.audio_rate;
                this.server_ip = streamContentDelayEvent.server_ip;
            }
        }

        public Builder session_id(String str) {
            this.session_id = str;
            return this;
        }

        public Builder video_url(String str) {
            this.video_url = str;
            return this;
        }

        public Builder room_id(String str) {
            this.room_id = str;
            return this;
        }

        public Builder host_time(String str) {
            this.host_time = str;
            return this;
        }

        public Builder guest_time(String str) {
            this.guest_time = str;
            return this;
        }

        public Builder fps(String str) {
            this.fps = str;
            return this;
        }

        public Builder video_rate(String str) {
            this.video_rate = str;
            return this;
        }

        public Builder audio_rate(String str) {
            this.audio_rate = str;
            return this;
        }

        public Builder server_ip(String str) {
            this.server_ip = str;
            return this;
        }

        public StreamContentDelayEvent build() {
            return new StreamContentDelayEvent(this);
        }
    }
}
