package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.ProtoEnum;
import com.tencent.ijk.media.player.IjkMediaPlayer;

public enum EventID implements ProtoEnum {
    StreamExceptionEvent(10001),
    StreamStartEvent(10002),
    StreamFirstFrameEvent(IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE),
    StreamGeneralEvent(IjkMediaPlayer.FFP_PROP_FLOAT_AVDELAY),
    StreamLagEvent(IjkMediaPlayer.FFP_PROP_FLOAT_AVDIFF),
    StreamContentDelayEvent(10006),
    StreamHeartbeatEvent(IjkMediaPlayer.FFP_PROP_FLOAT_DROP_FRAME_RATE),
    StreamPushLowFpsEvent(IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM),
    StreamServerStatEvent(IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM),
    StreamSgSessionCCUEvent(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER),
    StreamSgRegionCCUEvent(IjkMediaPlayer.FFP_PROP_INT64_AUDIO_DECODER);
    
    private final int value;

    private EventID(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
