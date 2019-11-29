package com.shopee.live.livestreaming.sztracking.creator;

import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.proto.EventID;
import com.shopee.live.livestreaming.sztracking.proto.StreamStartEvent;
import com.shopee.live.livestreaming.util.f;
import com.squareup.wire.Message;

public class SZTrackingStreamStartEventCreator extends AbstractSZTrackingEventCreator<StreamStartEvent> {
    private long mStartPlayTime;

    public SZTrackingStreamStartEventCreator(SZTrackingSettings sZTrackingSettings, long j, String str) {
        super(sZTrackingSettings, EventID.StreamStartEvent.getValue(), str);
        this.mStartPlayTime = j;
    }

    public StreamStartEvent buildBody() {
        return new StreamStartEvent.Builder().session_id(String.valueOf(f.a().f())).video_url(this.settings.getVideoUrl()).room_id(String.valueOf(f.a().g())).start_pull_time(Long.valueOf(this.mStartPlayTime)).server_ip(this.mServerIp).build();
    }

    public Message rebuildEvent(String str) {
        this.mServerIp = str;
        StreamStartEvent.Builder builder = new StreamStartEvent.Builder((StreamStartEvent) this.mBody);
        builder.server_ip = str;
        this.mBody = builder.build();
        return buildEvent();
    }
}
