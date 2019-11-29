package com.shopee.live.livestreaming.sztracking.creator;

import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.proto.EventID;
import com.shopee.live.livestreaming.sztracking.proto.StreamGeneralEvent;
import com.shopee.live.livestreaming.util.f;
import com.squareup.wire.Message;

public class SZTrackingStreamGeneralEventCreator extends AbstractSZTrackingEventCreator<StreamGeneralEvent> {
    private int action;
    private boolean isHost;
    private long start_time;

    public SZTrackingStreamGeneralEventCreator(SZTrackingSettings sZTrackingSettings, String str, int i, long j, boolean z) {
        super(sZTrackingSettings, EventID.StreamGeneralEvent.getValue(), str);
        this.action = i;
        this.start_time = j;
        this.isHost = z;
    }

    public StreamGeneralEvent buildBody() {
        return new StreamGeneralEvent.Builder().action(Integer.valueOf(this.action)).session_id(String.valueOf(f.a().f())).video_url(this.settings.getVideoUrl()).room_id(String.valueOf(f.a().g())).is_host(Boolean.valueOf(this.isHost)).start_time(Long.valueOf(this.start_time)).server_ip(this.mServerIp).build();
    }

    public Message rebuildEvent(String str) {
        this.mServerIp = str;
        StreamGeneralEvent.Builder builder = new StreamGeneralEvent.Builder((StreamGeneralEvent) this.mBody);
        builder.server_ip = str;
        this.mBody = builder.build();
        return buildEvent();
    }
}
