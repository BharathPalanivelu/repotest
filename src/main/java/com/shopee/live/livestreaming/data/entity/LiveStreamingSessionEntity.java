package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;
import java.util.ArrayList;

public class LiveStreamingSessionEntity extends a {
    public static final int CUSTOM_CONFIG = 1;
    public static final int PRESET_CONFIG = 2;
    private boolean ccu_limit;
    private ArrayList<DefaultPushConfig> default_push_config;
    private long maximum_can_show_items;
    private PlayConfig play_config;
    private PushConfig push_stream_config;
    private Session session;
    private SpeedTestConfig speed_test_config;
    private String usersig;

    public ArrayList<DefaultPushConfig> getDefault_push_config() {
        ArrayList<DefaultPushConfig> arrayList = this.default_push_config;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setDefault_push_config(ArrayList<DefaultPushConfig> arrayList) {
        this.default_push_config = arrayList;
    }

    public SpeedTestConfig getSpeed_test_config() {
        return this.speed_test_config;
    }

    public void setSpeed_test_config(SpeedTestConfig speedTestConfig) {
        this.speed_test_config = speedTestConfig;
    }

    public PushConfig getPush_stream_config() {
        return this.push_stream_config;
    }

    public void setPush_stream_config(PushConfig pushConfig) {
        this.push_stream_config = pushConfig;
    }

    public Session getSession() {
        return this.session;
    }

    public void setSession(Session session2) {
        this.session = session2;
    }

    public String getUsersig() {
        return this.usersig;
    }

    public void setUsersig(String str) {
        this.usersig = str;
    }

    public long getMaximum_can_show_items() {
        return this.maximum_can_show_items;
    }

    public void setMaximum_can_show_items(long j) {
        this.maximum_can_show_items = j;
    }

    public PlayConfig getPlay_config() {
        return this.play_config;
    }

    public void setPlay_config(PlayConfig playConfig) {
        this.play_config = playConfig;
    }

    public static class DefaultPushConfig {
        private int bitrate;
        private int video_resolution;

        public int getVideo_resolution() {
            return this.video_resolution;
        }

        public void setVideo_resolution(int i) {
            this.video_resolution = i;
        }

        public int getBitrate() {
            return this.bitrate;
        }

        public void setBitrate(int i) {
            this.bitrate = i;
        }
    }

    public static class SpeedTestConfig {
        private int duration;
        private int times;
        private String url;

        public String getUrl() {
            String str = this.url;
            return str == null ? "" : str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public int getDuration() {
            return this.duration;
        }

        public void setDuration(int i) {
            this.duration = i;
        }

        public int getTimes() {
            return this.times;
        }

        public void setTimes(int i) {
            this.times = i;
        }
    }

    public static class PushConfig {
        private Custom custom;
        private Preset preset;
        private int type;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public Custom getCustom() {
            return this.custom;
        }

        public void setCustom(Custom custom2) {
            this.custom = custom2;
        }

        public Preset getPreset() {
            return this.preset;
        }

        public void setPreset(Preset preset2) {
            this.preset = preset2;
        }
    }

    public static class PlayConfig {
        private boolean auto_adjust_cache_time = true;
        private double max_auto_adjust_cache_time = 5.0d;
        private double min_auto_adjust_cache_time = 1.0d;

        public boolean isAuto_adjust_cache_time() {
            return this.auto_adjust_cache_time;
        }

        public void setAuto_adjust_cache_time(boolean z) {
            this.auto_adjust_cache_time = z;
        }

        public double getMin_auto_adjust_cache_time() {
            return this.min_auto_adjust_cache_time;
        }

        public void setMin_auto_adjust_cache_time(double d2) {
            this.min_auto_adjust_cache_time = d2;
        }

        public double getMax_auto_adjust_cache_time() {
            return this.max_auto_adjust_cache_time;
        }

        public void setMax_auto_adjust_cache_time(double d2) {
            this.max_auto_adjust_cache_time = d2;
        }
    }

    public static class Custom {
        private int audio_sample_rate;
        private int auto_adjust_strategy;
        private boolean enable_auto_bitrate;
        private int video_bitrate_max;
        private int video_bitrate_min;
        private int video_bitrate_pin;
        private int video_encode_gop;
        private int video_resolution;

        public int getAudio_sample_rate() {
            return this.audio_sample_rate;
        }

        public void setAudio_sample_rate(int i) {
            this.audio_sample_rate = i;
        }

        public int getVideo_resolution() {
            return this.video_resolution;
        }

        public void setVideo_resolution(int i) {
            this.video_resolution = i;
        }

        public int getVideo_encode_gop() {
            return this.video_encode_gop;
        }

        public void setVideo_encode_gop(int i) {
            this.video_encode_gop = i;
        }

        public boolean isEnable_auto_bitrate() {
            return this.enable_auto_bitrate;
        }

        public void setEnable_auto_bitrate(boolean z) {
            this.enable_auto_bitrate = z;
        }

        public int getVideo_bitrate_pin() {
            return this.video_bitrate_pin;
        }

        public void setVideo_bitrate_pin(int i) {
            this.video_bitrate_pin = i;
        }

        public int getVideo_bitrate_min() {
            return this.video_bitrate_min;
        }

        public void setVideo_bitrate_min(int i) {
            this.video_bitrate_min = i;
        }

        public int getVideo_bitrate_max() {
            return this.video_bitrate_max;
        }

        public void setVideo_bitrate_max(int i) {
            this.video_bitrate_max = i;
        }

        public int getAuto_adjust_strategy() {
            return this.auto_adjust_strategy;
        }

        public void setAuto_adjust_strategy(int i) {
            this.auto_adjust_strategy = i;
        }
    }

    public static class Preset {
        private boolean adjustBitrate;
        private boolean adjustResolution;
        private int quality;

        public int getQuality() {
            return this.quality;
        }

        public void setQuality(int i) {
            this.quality = i;
        }

        public boolean isAdjustBitrate() {
            return this.adjustBitrate;
        }

        public void setAdjustBitrate(boolean z) {
            this.adjustBitrate = z;
        }

        public boolean isAdjustResolution() {
            return this.adjustResolution;
        }

        public void setAdjustResolution(boolean z) {
            this.adjustResolution = z;
        }
    }

    public static class Session {
        private String avatar;
        private String chatroom_id;
        private String cover_pic;
        private long create_time;
        private String description;
        private long end_time;
        private boolean is_dynamic_play_url;
        private boolean is_terminate;
        private int items_cnt;
        private int like_cnt;
        private int member_cnt;
        private String nickname;
        private String play_url;
        private String push_url;
        private int room_id;
        private int session_id;
        private int shop_id;
        private long start_time;
        private int status;
        private String title;
        private int uid;
        private String username;

        public long getCreate_time() {
            return this.create_time;
        }

        public void setCreate_time(long j) {
            this.create_time = j;
        }

        public int getSession_id() {
            return this.session_id;
        }

        public void setSession_id(int i) {
            this.session_id = i;
        }

        public int getUid() {
            return this.uid;
        }

        public void setUid(int i) {
            this.uid = i;
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String str) {
            this.username = str;
        }

        public String getNickname() {
            return this.nickname;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public int getRoom_id() {
            return this.room_id;
        }

        public void setRoom_id(int i) {
            this.room_id = i;
        }

        public int getShop_id() {
            return this.shop_id;
        }

        public void setShop_id(int i) {
            this.shop_id = i;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getCover_pic() {
            return this.cover_pic;
        }

        public void setCover_pic(String str) {
            this.cover_pic = str;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public int getMember_cnt() {
            return this.member_cnt;
        }

        public void setMember_cnt(int i) {
            this.member_cnt = i;
        }

        public int getLike_cnt() {
            return this.like_cnt;
        }

        public void setLike_cnt(int i) {
            this.like_cnt = i;
        }

        public long getStart_time() {
            return this.start_time;
        }

        public void setStart_time(long j) {
            this.start_time = j;
        }

        public long getEnd_time() {
            return this.end_time;
        }

        public void setEnd_time(long j) {
            this.end_time = j;
        }

        public String getPush_url() {
            return this.push_url;
        }

        public void setPush_url(String str) {
            this.push_url = str;
        }

        public String getPlay_url() {
            return this.play_url;
        }

        public void setPlay_url(String str) {
            this.play_url = str;
        }

        public String getChatroom_id() {
            return this.chatroom_id;
        }

        public void setChatroom_id(String str) {
            this.chatroom_id = str;
        }

        public boolean isIs_terminate() {
            return this.is_terminate;
        }

        public void setIs_terminate(boolean z) {
            this.is_terminate = z;
        }

        public int getItems_cnt() {
            return this.items_cnt;
        }

        public void setItems_cnt(int i) {
            this.items_cnt = i;
        }

        public boolean isIs_dynamic_play_url() {
            return this.is_dynamic_play_url;
        }

        public void setIs_dynamic_play_url(boolean z) {
            this.is_dynamic_play_url = z;
        }
    }

    public boolean isCcu_limit() {
        return this.ccu_limit;
    }

    public void setCcu_limit(boolean z) {
        this.ccu_limit = z;
    }
}
