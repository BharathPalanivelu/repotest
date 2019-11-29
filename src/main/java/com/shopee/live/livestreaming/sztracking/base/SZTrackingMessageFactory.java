package com.shopee.live.livestreaming.sztracking.base;

import com.shopee.live.livestreaming.sztracking.base.db.SZTrackingDBModel;
import com.squareup.wire.Message;
import java.util.List;

public interface SZTrackingMessageFactory<In extends Message, Out extends Message> {
    SZTrackingDBModel inToSave(In in);

    Out outToPost(List<SZTrackingDBModel> list);
}
