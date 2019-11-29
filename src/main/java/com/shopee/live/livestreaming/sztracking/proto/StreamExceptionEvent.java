package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StreamExceptionEvent extends Message {
    public static final String DEFAULT_AUDIO_CACHE = "";
    public static final String DEFAULT_AUDIO_DROP = "";
    public static final String DEFAULT_AUDIO_RATE = "";
    public static final String DEFAULT_BATTERY = "";
    public static final String DEFAULT_CACHE_SIZE = "";
    public static final String DEFAULT_CPU = "";
    public static final String DEFAULT_DROP_CNT = "";
    public static final String DEFAULT_DROP_SIZE = "";
    public static final String DEFAULT_FPS = "";
    public static final String DEFAULT_GOP = "";
    public static final Boolean DEFAULT_IS_HOST = false;
    public static final String DEFAULT_JITTER = "";
    public static final Boolean DEFAULT_MULTI_CDN = false;
    public static final String DEFAULT_NET_TIME = "";
    public static final String DEFAULT_RESOLUTION = "";
    public static final String DEFAULT_ROOM_ID = "";
    public static final String DEFAULT_SERVER_IP = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final String DEFAULT_SPEED = "";
    public static final Long DEFAULT_START_TIME = 0L;
    public static final String DEFAULT_STREAM_EVT = "";
    public static final String DEFAULT_TX_SDK_VERSION = "";
    public static final String DEFAULT_VIDEO_CACHE = "";
    public static final String DEFAULT_VIDEO_DROP = "";
    public static final String DEFAULT_VIDEO_RATE = "";
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String audio_cache;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String audio_drop;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String audio_rate;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String battery;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String cache_size;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String cpu;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String drop_cnt;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String drop_size;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String fps;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String gop;
    @ProtoField(tag = 18, type = Message.Datatype.BOOL)
    public final Boolean is_host;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String jitter;
    @ProtoField(tag = 24, type = Message.Datatype.BOOL)
    public final Boolean multi_cdn;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String net_time;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String resolution;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String room_id;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String server_ip;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String session_id;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String speed;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long start_time;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String stream_evt;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String tx_sdk_version;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String video_cache;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String video_drop;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String video_rate;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String video_url;

    public StreamExceptionEvent(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Boolean bool, String str17, String str18, String str19, String str20, String str21, Boolean bool2, String str22, String str23) {
        this.session_id = str;
        this.start_time = l;
        this.cpu = str2;
        this.cache_size = str3;
        this.resolution = str4;
        this.battery = str5;
        this.speed = str6;
        this.fps = str7;
        this.gop = str8;
        this.audio_rate = str9;
        this.video_rate = str10;
        this.drop_cnt = str11;
        this.drop_size = str12;
        this.jitter = str13;
        this.net_time = str14;
        this.stream_evt = str15;
        this.server_ip = str16;
        this.is_host = bool;
        this.tx_sdk_version = str17;
        this.video_cache = str18;
        this.audio_cache = str19;
        this.video_drop = str20;
        this.audio_drop = str21;
        this.multi_cdn = bool2;
        this.video_url = str22;
        this.room_id = str23;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private StreamExceptionEvent(com.shopee.live.livestreaming.sztracking.proto.StreamExceptionEvent.Builder r30) {
        /*
            r29 = this;
            r0 = r30
            r1 = r29
            java.lang.String r2 = r0.session_id
            java.lang.Long r3 = r0.start_time
            java.lang.String r4 = r0.cpu
            java.lang.String r5 = r0.cache_size
            java.lang.String r6 = r0.resolution
            java.lang.String r7 = r0.battery
            java.lang.String r8 = r0.speed
            java.lang.String r9 = r0.fps
            java.lang.String r10 = r0.gop
            java.lang.String r11 = r0.audio_rate
            java.lang.String r12 = r0.video_rate
            java.lang.String r13 = r0.drop_cnt
            java.lang.String r14 = r0.drop_size
            java.lang.String r15 = r0.jitter
            r28 = r1
            java.lang.String r1 = r0.net_time
            r16 = r1
            java.lang.String r1 = r0.stream_evt
            r17 = r1
            java.lang.String r1 = r0.server_ip
            r18 = r1
            java.lang.Boolean r1 = r0.is_host
            r19 = r1
            java.lang.String r1 = r0.tx_sdk_version
            r20 = r1
            java.lang.String r1 = r0.video_cache
            r21 = r1
            java.lang.String r1 = r0.audio_cache
            r22 = r1
            java.lang.String r1 = r0.video_drop
            r23 = r1
            java.lang.String r1 = r0.audio_drop
            r24 = r1
            java.lang.Boolean r1 = r0.multi_cdn
            r25 = r1
            java.lang.String r1 = r0.video_url
            r26 = r1
            java.lang.String r1 = r0.room_id
            r27 = r1
            r1 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r29.setBuilder(r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.sztracking.proto.StreamExceptionEvent.<init>(com.shopee.live.livestreaming.sztracking.proto.StreamExceptionEvent$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamExceptionEvent)) {
            return false;
        }
        StreamExceptionEvent streamExceptionEvent = (StreamExceptionEvent) obj;
        if (!equals((Object) this.session_id, (Object) streamExceptionEvent.session_id) || !equals((Object) this.start_time, (Object) streamExceptionEvent.start_time) || !equals((Object) this.cpu, (Object) streamExceptionEvent.cpu) || !equals((Object) this.cache_size, (Object) streamExceptionEvent.cache_size) || !equals((Object) this.resolution, (Object) streamExceptionEvent.resolution) || !equals((Object) this.battery, (Object) streamExceptionEvent.battery) || !equals((Object) this.speed, (Object) streamExceptionEvent.speed) || !equals((Object) this.fps, (Object) streamExceptionEvent.fps) || !equals((Object) this.gop, (Object) streamExceptionEvent.gop) || !equals((Object) this.audio_rate, (Object) streamExceptionEvent.audio_rate) || !equals((Object) this.video_rate, (Object) streamExceptionEvent.video_rate) || !equals((Object) this.drop_cnt, (Object) streamExceptionEvent.drop_cnt) || !equals((Object) this.drop_size, (Object) streamExceptionEvent.drop_size) || !equals((Object) this.jitter, (Object) streamExceptionEvent.jitter) || !equals((Object) this.net_time, (Object) streamExceptionEvent.net_time) || !equals((Object) this.stream_evt, (Object) streamExceptionEvent.stream_evt) || !equals((Object) this.server_ip, (Object) streamExceptionEvent.server_ip) || !equals((Object) this.is_host, (Object) streamExceptionEvent.is_host) || !equals((Object) this.tx_sdk_version, (Object) streamExceptionEvent.tx_sdk_version) || !equals((Object) this.video_cache, (Object) streamExceptionEvent.video_cache) || !equals((Object) this.audio_cache, (Object) streamExceptionEvent.audio_cache) || !equals((Object) this.video_drop, (Object) streamExceptionEvent.video_drop) || !equals((Object) this.audio_drop, (Object) streamExceptionEvent.audio_drop) || !equals((Object) this.multi_cdn, (Object) streamExceptionEvent.multi_cdn) || !equals((Object) this.video_url, (Object) streamExceptionEvent.video_url) || !equals((Object) this.room_id, (Object) streamExceptionEvent.room_id)) {
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
        Long l = this.start_time;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.cpu;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cache_size;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.resolution;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.battery;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.speed;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.fps;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.gop;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.audio_rate;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.video_rate;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.drop_cnt;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.drop_size;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.jitter;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.net_time;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.stream_evt;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.server_ip;
        int hashCode17 = (hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 37;
        Boolean bool = this.is_host;
        int hashCode18 = (hashCode17 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str17 = this.tx_sdk_version;
        int hashCode19 = (hashCode18 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.video_cache;
        int hashCode20 = (hashCode19 + (str18 != null ? str18.hashCode() : 0)) * 37;
        String str19 = this.audio_cache;
        int hashCode21 = (hashCode20 + (str19 != null ? str19.hashCode() : 0)) * 37;
        String str20 = this.video_drop;
        int hashCode22 = (hashCode21 + (str20 != null ? str20.hashCode() : 0)) * 37;
        String str21 = this.audio_drop;
        int hashCode23 = (hashCode22 + (str21 != null ? str21.hashCode() : 0)) * 37;
        Boolean bool2 = this.multi_cdn;
        int hashCode24 = (hashCode23 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str22 = this.video_url;
        int hashCode25 = (hashCode24 + (str22 != null ? str22.hashCode() : 0)) * 37;
        String str23 = this.room_id;
        if (str23 != null) {
            i2 = str23.hashCode();
        }
        int i3 = hashCode25 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StreamExceptionEvent> {
        public String audio_cache;
        public String audio_drop;
        public String audio_rate;
        public String battery;
        public String cache_size;
        public String cpu;
        public String drop_cnt;
        public String drop_size;
        public String fps;
        public String gop;
        public Boolean is_host;
        public String jitter;
        public Boolean multi_cdn;
        public String net_time;
        public String resolution;
        public String room_id;
        public String server_ip;
        public String session_id;
        public String speed;
        public Long start_time;
        public String stream_evt;
        public String tx_sdk_version;
        public String video_cache;
        public String video_drop;
        public String video_rate;
        public String video_url;

        public Builder() {
        }

        public Builder(StreamExceptionEvent streamExceptionEvent) {
            super(streamExceptionEvent);
            if (streamExceptionEvent != null) {
                this.session_id = streamExceptionEvent.session_id;
                this.start_time = streamExceptionEvent.start_time;
                this.cpu = streamExceptionEvent.cpu;
                this.cache_size = streamExceptionEvent.cache_size;
                this.resolution = streamExceptionEvent.resolution;
                this.battery = streamExceptionEvent.battery;
                this.speed = streamExceptionEvent.speed;
                this.fps = streamExceptionEvent.fps;
                this.gop = streamExceptionEvent.gop;
                this.audio_rate = streamExceptionEvent.audio_rate;
                this.video_rate = streamExceptionEvent.video_rate;
                this.drop_cnt = streamExceptionEvent.drop_cnt;
                this.drop_size = streamExceptionEvent.drop_size;
                this.jitter = streamExceptionEvent.jitter;
                this.net_time = streamExceptionEvent.net_time;
                this.stream_evt = streamExceptionEvent.stream_evt;
                this.server_ip = streamExceptionEvent.server_ip;
                this.is_host = streamExceptionEvent.is_host;
                this.tx_sdk_version = streamExceptionEvent.tx_sdk_version;
                this.video_cache = streamExceptionEvent.video_cache;
                this.audio_cache = streamExceptionEvent.audio_cache;
                this.video_drop = streamExceptionEvent.video_drop;
                this.audio_drop = streamExceptionEvent.audio_drop;
                this.multi_cdn = streamExceptionEvent.multi_cdn;
                this.video_url = streamExceptionEvent.video_url;
                this.room_id = streamExceptionEvent.room_id;
            }
        }

        public Builder session_id(String str) {
            this.session_id = str;
            return this;
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder cpu(String str) {
            this.cpu = str;
            return this;
        }

        public Builder cache_size(String str) {
            this.cache_size = str;
            return this;
        }

        public Builder resolution(String str) {
            this.resolution = str;
            return this;
        }

        public Builder battery(String str) {
            this.battery = str;
            return this;
        }

        public Builder speed(String str) {
            this.speed = str;
            return this;
        }

        public Builder fps(String str) {
            this.fps = str;
            return this;
        }

        public Builder gop(String str) {
            this.gop = str;
            return this;
        }

        public Builder audio_rate(String str) {
            this.audio_rate = str;
            return this;
        }

        public Builder video_rate(String str) {
            this.video_rate = str;
            return this;
        }

        public Builder drop_cnt(String str) {
            this.drop_cnt = str;
            return this;
        }

        public Builder drop_size(String str) {
            this.drop_size = str;
            return this;
        }

        public Builder jitter(String str) {
            this.jitter = str;
            return this;
        }

        public Builder net_time(String str) {
            this.net_time = str;
            return this;
        }

        public Builder stream_evt(String str) {
            this.stream_evt = str;
            return this;
        }

        public Builder server_ip(String str) {
            this.server_ip = str;
            return this;
        }

        public Builder is_host(Boolean bool) {
            this.is_host = bool;
            return this;
        }

        public Builder tx_sdk_version(String str) {
            this.tx_sdk_version = str;
            return this;
        }

        public Builder video_cache(String str) {
            this.video_cache = str;
            return this;
        }

        public Builder audio_cache(String str) {
            this.audio_cache = str;
            return this;
        }

        public Builder video_drop(String str) {
            this.video_drop = str;
            return this;
        }

        public Builder audio_drop(String str) {
            this.audio_drop = str;
            return this;
        }

        public Builder multi_cdn(Boolean bool) {
            this.multi_cdn = bool;
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

        public StreamExceptionEvent build() {
            return new StreamExceptionEvent(this);
        }
    }
}
