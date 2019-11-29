package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.utilities.spatial.Orientation;

@BatchedEvent(groupId = "orientationEvents")
public class OrientationEvent extends BaseEvent {
    private static final String VALUE_LANDSCAPE = "LANDSCAPE_LEFT";
    private static final String VALUE_PORTRAIT = "PORTRAIT";
    private static final String VALUE_UNKNOWN = "UNDEFINED";
    @c(a = "orientation")
    private final String mOrientation;

    public OrientationEvent(String str, String str2, Orientation orientation) {
        super(str, str2);
        if (orientation.isLandscape()) {
            this.mOrientation = VALUE_LANDSCAPE;
        } else if (orientation.isPortrait()) {
            this.mOrientation = VALUE_PORTRAIT;
        } else {
            this.mOrientation = VALUE_UNKNOWN;
        }
    }

    public String getOrientation() {
        return this.mOrientation;
    }
}
