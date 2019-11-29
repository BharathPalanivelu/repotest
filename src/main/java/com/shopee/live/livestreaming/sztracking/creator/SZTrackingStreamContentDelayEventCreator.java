package com.shopee.live.livestreaming.sztracking.creator;

import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.proto.EventID;
import com.shopee.live.livestreaming.sztracking.proto.StreamContentDelayEvent;
import com.shopee.live.livestreaming.util.f;
import com.squareup.wire.Message;

public class SZTrackingStreamContentDelayEventCreator extends AbstractSZTrackingEventCreator<StreamContentDelayEvent> {
    private String audioBitRate;
    private String fps;
    private long hostTime;
    private String videoBitRate;

    public SZTrackingStreamContentDelayEventCreator(SZTrackingSettings sZTrackingSettings, String str, String str2, String str3, String str4, long j) {
        super(sZTrackingSettings, EventID.StreamContentDelayEvent.getValue(), str);
        this.fps = str2;
        this.audioBitRate = str3;
        this.videoBitRate = str4;
        this.hostTime = j;
    }

    public StreamContentDelayEvent buildBody() {
        return new StreamContentDelayEvent.Builder().session_id(String.valueOf(f.a().f())).video_url(this.settings.getVideoUrl()).room_id(String.valueOf(f.a().g())).host_time(String.valueOf(this.hostTime)).guest_time(String.valueOf(System.currentTimeMillis())).fps(this.fps).video_rate(this.audioBitRate).audio_rate(this.videoBitRate).server_ip(this.mServerIp).build();
    }

    public Message rebuildEvent(String str) {
        this.mServerIp = str;
        StreamContentDelayEvent.Builder builder = new StreamContentDelayEvent.Builder((StreamContentDelayEvent) this.mBody);
        builder.server_ip = str;
        this.mBody = builder.build();
        return buildEvent();
    }
}
