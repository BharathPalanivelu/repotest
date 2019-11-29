package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

@BatchedEvent(groupId = "batteryEvents")
public class BatteryEvent extends BaseEvent {
    @c(a = "level")
    private final int mLevel;

    public BatteryEvent(String str, String str2, int i) {
        super(str, str2);
        i = i < 0 ? 0 : i;
        this.mLevel = i <= 100 ? i : 100;
    }

    public int getLevel() {
        return this.mLevel;
    }
}
