package com.shopee.live.livestreaming.sztracking.creator;

import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.proto.EventID;
import com.shopee.live.livestreaming.sztracking.proto.StreamHeartbeatEvent;
import com.shopee.live.livestreaming.util.f;
import com.squareup.wire.Message;

public class SZTrackingStreamHeartbeatEventCreator extends AbstractSZTrackingEventCreator<StreamHeartbeatEvent> {
    private String audioRate;
    private String downSpeed;
    private String fps;
    private String videoRate;

    public Message rebuildEvent(String str) {
        return null;
    }

    public SZTrackingStreamHeartbeatEventCreator(SZTrackingSettings sZTrackingSettings) {
        super(sZTrackingSettings, EventID.StreamHeartbeatEvent.getValue());
    }

    public StreamHeartbeatEvent buildBody() {
        return new StreamHeartbeatEvent.Builder().session_id(String.valueOf(f.a().f())).video_url(this.settings.getVideoUrl()).room_id(String.valueOf(f.a().g())).fps(this.fps).video_rate(this.videoRate).audio_rate(this.audioRate).server_ip(this.mServerIp).down_speed(this.downSpeed).build();
    }

    public SZTrackingStreamHeartbeatEventCreator setFps(String str) {
        this.fps = str;
        return this;
    }

    public SZTrackingStreamHeartbeatEventCreator setVideoRate(String str) {
        this.videoRate = str;
        return this;
    }

    public SZTrackingStreamHeartbeatEventCreator setAudioRate(String str) {
        this.audioRate = str;
        return this;
    }

    public SZTrackingStreamHeartbeatEventCreator setDownSpeed(String str) {
        this.downSpeed = str;
        return this;
    }

    public SZTrackingStreamHeartbeatEventCreator setServerIp(String str) {
        this.mServerIp = str;
        return this;
    }
}
