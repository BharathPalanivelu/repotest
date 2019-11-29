package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StreamFirstFrameEvent extends Message {
    public static final Long DEFAULT_FIRST_FRAME_TIME = 0L;
    public static final String DEFAULT_ROOM_ID = "";
    public static final String DEFAULT_SERVER_IP = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final Long DEFAULT_START_PULL_TIME = 0L;
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long first_frame_time;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String room_id;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String server_ip;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String session_id;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long start_pull_time;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String video_url;

    public StreamFirstFrameEvent(String str, String str2, String str3, Long l, Long l2, String str4) {
        this.session_id = str;
        this.video_url = str2;
        this.room_id = str3;
        this.start_pull_time = l;
        this.first_frame_time = l2;
        this.server_ip = str4;
    }

    private StreamFirstFrameEvent(Builder builder) {
        this(builder.session_id, builder.video_url, builder.room_id, builder.start_pull_time, builder.first_frame_time, builder.server_ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamFirstFrameEvent)) {
            return false;
        }
        StreamFirstFrameEvent streamFirstFrameEvent = (StreamFirstFrameEvent) obj;
        if (!equals((Object) this.session_id, (Object) streamFirstFrameEvent.session_id) || !equals((Object) this.video_url, (Object) streamFirstFrameEvent.video_url) || !equals((Object) this.room_id, (Object) streamFirstFrameEvent.room_id) || !equals((Object) this.start_pull_time, (Object) streamFirstFrameEvent.start_pull_time) || !equals((Object) this.first_frame_time, (Object) streamFirstFrameEvent.first_frame_time) || !equals((Object) this.server_ip, (Object) streamFirstFrameEvent.server_ip)) {
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
        Long l = this.start_pull_time;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.first_frame_time;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str4 = this.server_ip;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StreamFirstFrameEvent> {
        public Long first_frame_time;
        public String room_id;
        public String server_ip;
        public String session_id;
        public Long start_pull_time;
        public String video_url;

        public Builder() {
        }

        public Builder(StreamFirstFrameEvent streamFirstFrameEvent) {
            super(streamFirstFrameEvent);
            if (streamFirstFrameEvent != null) {
                this.session_id = streamFirstFrameEvent.session_id;
                this.video_url = streamFirstFrameEvent.video_url;
                this.room_id = streamFirstFrameEvent.room_id;
                this.start_pull_time = streamFirstFrameEvent.start_pull_time;
                this.first_frame_time = streamFirstFrameEvent.first_frame_time;
                this.server_ip = streamFirstFrameEvent.server_ip;
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

        public Builder start_pull_time(Long l) {
            this.start_pull_time = l;
            return this;
        }

        public Builder first_frame_time(Long l) {
            this.first_frame_time = l;
            return this;
        }

        public Builder server_ip(String str) {
            this.server_ip = str;
            return this;
        }

        public StreamFirstFrameEvent build() {
            return new StreamFirstFrameEvent(this);
        }
    }
}
