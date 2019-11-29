package com.shopee.live.livestreaming.sztracking;

import com.shopee.live.livestreaming.sztracking.base.SZTrackingManager;
import com.shopee.live.livestreaming.sztracking.creator.AbstractSZTrackingEventCreator;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;

public class SZTrackingCacheEventHelper {
    private Object mObject = new Object();
    private List<AbstractSZTrackingEventCreator> mPendingSaveEventList = new ArrayList();
    private SZTrackingManager mSZTrackingManager;

    public SZTrackingCacheEventHelper(SZTrackingManager sZTrackingManager) {
        this.mSZTrackingManager = sZTrackingManager;
    }

    public void addEventToCache(AbstractSZTrackingEventCreator abstractSZTrackingEventCreator) {
        synchronized (this.mObject) {
            this.mPendingSaveEventList.add(abstractSZTrackingEventCreator);
        }
    }

    public void saveCacheToDB(String str) {
        synchronized (this.mObject) {
            if (this.mPendingSaveEventList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (AbstractSZTrackingEventCreator rebuildEvent : this.mPendingSaveEventList) {
                    arrayList.add(rebuildEvent.rebuildEvent(str));
                }
                this.mSZTrackingManager.eventReport((List<Message>) arrayList);
                this.mPendingSaveEventList.clear();
            }
        }
    }
}
