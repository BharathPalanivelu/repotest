package com.shopee.live.livestreaming.sztracking.creator;

import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.proto.EventID;
import com.shopee.live.livestreaming.sztracking.proto.StreamFirstFrameEvent;
import com.shopee.live.livestreaming.util.f;
import com.squareup.wire.Message;

public class SZTrackingStreamFirstFrameEventCreator extends AbstractSZTrackingEventCreator<StreamFirstFrameEvent> {
    private long mFirstFrameTime;
    private long mStartPlayTime;

    public SZTrackingStreamFirstFrameEventCreator(SZTrackingSettings sZTrackingSettings, String str, long j, long j2) {
        super(sZTrackingSettings, EventID.StreamFirstFrameEvent.getValue(), str);
        this.mStartPlayTime = j;
        this.mFirstFrameTime = j2;
    }

    public StreamFirstFrameEvent buildBody() {
        return new StreamFirstFrameEvent.Builder().session_id(String.valueOf(f.a().f())).video_url(this.settings.getVideoUrl()).room_id(String.valueOf(f.a().g())).start_pull_time(Long.valueOf(this.mStartPlayTime)).first_frame_time(Long.valueOf(this.mFirstFrameTime)).server_ip(this.mServerIp).build();
    }

    public Message rebuildEvent(String str) {
        this.mServerIp = str;
        StreamFirstFrameEvent.Builder builder = new StreamFirstFrameEvent.Builder((StreamFirstFrameEvent) this.mBody);
        builder.server_ip = str;
        this.mBody = builder.build();
        return buildEvent();
    }
}
