package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StreamLagEvent extends Message {
    public static final Long DEFAULT_DURATION = 0L;
    public static final String DEFAULT_ROOM_ID = "";
    public static final String DEFAULT_SERVER_IP = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long duration;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String room_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String server_ip;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String session_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String video_url;

    public StreamLagEvent(String str, String str2, String str3, Long l, String str4) {
        this.session_id = str;
        this.video_url = str2;
        this.room_id = str3;
        this.duration = l;
        this.server_ip = str4;
    }

    private StreamLagEvent(Builder builder) {
        this(builder.session_id, builder.video_url, builder.room_id, builder.duration, builder.server_ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamLagEvent)) {
            return false;
        }
        StreamLagEvent streamLagEvent = (StreamLagEvent) obj;
        if (!equals((Object) this.session_id, (Object) streamLagEvent.session_id) || !equals((Object) this.video_url, (Object) streamLagEvent.video_url) || !equals((Object) this.room_id, (Object) streamLagEvent.room_id) || !equals((Object) this.duration, (Object) streamLagEvent.duration) || !equals((Object) this.server_ip, (Object) streamLagEvent.server_ip)) {
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
        Long l = this.duration;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str4 = this.server_ip;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StreamLagEvent> {
        public Long duration;
        public String room_id;
        public String server_ip;
        public String session_id;
        public String video_url;

        public Builder() {
        }

        public Builder(StreamLagEvent streamLagEvent) {
            super(streamLagEvent);
            if (streamLagEvent != null) {
                this.session_id = streamLagEvent.session_id;
                this.video_url = streamLagEvent.video_url;
                this.room_id = streamLagEvent.room_id;
                this.duration = streamLagEvent.duration;
                this.server_ip = streamLagEvent.server_ip;
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

        public Builder duration(Long l) {
            this.duration = l;
            return this;
        }

        public Builder server_ip(String str) {
            this.server_ip = str;
            return this;
        }

        public StreamLagEvent build() {
            return new StreamLagEvent(this);
        }
    }
}
