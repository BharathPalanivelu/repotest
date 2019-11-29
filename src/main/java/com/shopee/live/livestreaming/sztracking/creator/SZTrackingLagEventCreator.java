package com.shopee.live.livestreaming.sztracking.creator;

import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.proto.EventID;
import com.shopee.live.livestreaming.sztracking.proto.StreamLagEvent;
import com.shopee.live.livestreaming.util.f;
import com.squareup.wire.Message;

public class SZTrackingLagEventCreator extends AbstractSZTrackingEventCreator<StreamLagEvent> {
    private long mLagTime;

    public SZTrackingLagEventCreator(SZTrackingSettings sZTrackingSettings, long j, String str) {
        super(sZTrackingSettings, EventID.StreamLagEvent.getValue(), str);
        this.mLagTime = j;
    }

    public StreamLagEvent buildBody() {
        return new StreamLagEvent.Builder().session_id(String.valueOf(f.a().f())).video_url(this.settings.getVideoUrl()).duration(Long.valueOf(this.mLagTime)).room_id(String.valueOf(f.a().g())).server_ip(this.mServerIp).build();
    }

    public Message rebuildEvent(String str) {
        this.mServerIp = str;
        StreamLagEvent.Builder builder = new StreamLagEvent.Builder((StreamLagEvent) this.mBody);
        builder.server_ip = str;
        this.mBody = builder.build();
        return buildEvent();
    }
}
