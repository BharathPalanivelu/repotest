package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StreamHeartbeatEvent extends Message {
    public static final String DEFAULT_AUDIO_RATE = "";
    public static final String DEFAULT_DOWN_SPEED = "";
    public static final String DEFAULT_FPS = "";
    public static final String DEFAULT_ROOM_ID = "";
    public static final String DEFAULT_SERVER_IP = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final String DEFAULT_VIDEO_RATE = "";
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String audio_rate;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String down_speed;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String fps;
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

    public StreamHeartbeatEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.session_id = str;
        this.video_url = str2;
        this.room_id = str3;
        this.fps = str4;
        this.video_rate = str5;
        this.audio_rate = str6;
        this.server_ip = str7;
        this.down_speed = str8;
    }

    private StreamHeartbeatEvent(Builder builder) {
        this(builder.session_id, builder.video_url, builder.room_id, builder.fps, builder.video_rate, builder.audio_rate, builder.server_ip, builder.down_speed);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamHeartbeatEvent)) {
            return false;
        }
        StreamHeartbeatEvent streamHeartbeatEvent = (StreamHeartbeatEvent) obj;
        if (!equals((Object) this.session_id, (Object) streamHeartbeatEvent.session_id) || !equals((Object) this.video_url, (Object) streamHeartbeatEvent.video_url) || !equals((Object) this.room_id, (Object) streamHeartbeatEvent.room_id) || !equals((Object) this.fps, (Object) streamHeartbeatEvent.fps) || !equals((Object) this.video_rate, (Object) streamHeartbeatEvent.video_rate) || !equals((Object) this.audio_rate, (Object) streamHeartbeatEvent.audio_rate) || !equals((Object) this.server_ip, (Object) streamHeartbeatEvent.server_ip) || !equals((Object) this.down_speed, (Object) streamHeartbeatEvent.down_speed)) {
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
        String str4 = this.fps;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.video_rate;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.audio_rate;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.server_ip;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.down_speed;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StreamHeartbeatEvent> {
        public String audio_rate;
        public String down_speed;
        public String fps;
        public String room_id;
        public String server_ip;
        public String session_id;
        public String video_rate;
        public String video_url;

        public Builder() {
        }

        public Builder(StreamHeartbeatEvent streamHeartbeatEvent) {
            super(streamHeartbeatEvent);
            if (streamHeartbeatEvent != null) {
                this.session_id = streamHeartbeatEvent.session_id;
                this.video_url = streamHeartbeatEvent.video_url;
                this.room_id = streamHeartbeatEvent.room_id;
                this.fps = streamHeartbeatEvent.fps;
                this.video_rate = streamHeartbeatEvent.video_rate;
                this.audio_rate = streamHeartbeatEvent.audio_rate;
                this.server_ip = streamHeartbeatEvent.server_ip;
                this.down_speed = streamHeartbeatEvent.down_speed;
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

        public Builder down_speed(String str) {
            this.down_speed = str;
            return this;
        }

        public StreamHeartbeatEvent build() {
            return new StreamHeartbeatEvent(this);
        }
    }
}
