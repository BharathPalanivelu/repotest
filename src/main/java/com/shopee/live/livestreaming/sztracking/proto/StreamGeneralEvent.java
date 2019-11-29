package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StreamGeneralEvent extends Message {
    public static final Integer DEFAULT_ACTION = 0;
    public static final Boolean DEFAULT_IS_HOST = false;
    public static final String DEFAULT_ROOM_ID = "";
    public static final String DEFAULT_SERVER_IP = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final Long DEFAULT_START_TIME = 0L;
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer action;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_host;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String room_id;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String server_ip;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String session_id;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long start_time;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String video_url;

    public StreamGeneralEvent(Integer num, String str, String str2, String str3, Boolean bool, Long l, String str4) {
        this.action = num;
        this.session_id = str;
        this.video_url = str2;
        this.room_id = str3;
        this.is_host = bool;
        this.start_time = l;
        this.server_ip = str4;
    }

    private StreamGeneralEvent(Builder builder) {
        this(builder.action, builder.session_id, builder.video_url, builder.room_id, builder.is_host, builder.start_time, builder.server_ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamGeneralEvent)) {
            return false;
        }
        StreamGeneralEvent streamGeneralEvent = (StreamGeneralEvent) obj;
        if (!equals((Object) this.action, (Object) streamGeneralEvent.action) || !equals((Object) this.session_id, (Object) streamGeneralEvent.session_id) || !equals((Object) this.video_url, (Object) streamGeneralEvent.video_url) || !equals((Object) this.room_id, (Object) streamGeneralEvent.room_id) || !equals((Object) this.is_host, (Object) streamGeneralEvent.is_host) || !equals((Object) this.start_time, (Object) streamGeneralEvent.start_time) || !equals((Object) this.server_ip, (Object) streamGeneralEvent.server_ip)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.action;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.session_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.video_url;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.room_id;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.is_host;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.start_time;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        String str4 = this.server_ip;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StreamGeneralEvent> {
        public Integer action;
        public Boolean is_host;
        public String room_id;
        public String server_ip;
        public String session_id;
        public Long start_time;
        public String video_url;

        public Builder() {
        }

        public Builder(StreamGeneralEvent streamGeneralEvent) {
            super(streamGeneralEvent);
            if (streamGeneralEvent != null) {
                this.action = streamGeneralEvent.action;
                this.session_id = streamGeneralEvent.session_id;
                this.video_url = streamGeneralEvent.video_url;
                this.room_id = streamGeneralEvent.room_id;
                this.is_host = streamGeneralEvent.is_host;
                this.start_time = streamGeneralEvent.start_time;
                this.server_ip = streamGeneralEvent.server_ip;
            }
        }

        public Builder action(Integer num) {
            this.action = num;
            return this;
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

        public Builder is_host(Boolean bool) {
            this.is_host = bool;
            return this;
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder server_ip(String str) {
            this.server_ip = str;
            return this;
        }

        public StreamGeneralEvent build() {
            return new StreamGeneralEvent(this);
        }
    }
}
