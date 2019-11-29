package com.shopee.live.livestreaming.sztracking.creator;

import com.squareup.wire.Message;

public interface SZTrackingEventBuildInterface {
    boolean beforeBuildCheckSuccessFully();

    AbstractSZTrackingEventCreator buildCreator();

    Message buildEvent();
}
