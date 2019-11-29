package com.shopee.shopeetracker.model;

import com.shopee.shopeetracker.bimodel.TrackingEvent;
import com.shopee.shopeetracker.utils.GsonUtils;

public class UserActionV2 extends UserAction {
    private final String action;

    public int getType() {
        return 2;
    }

    public static UserActionV2 create(String str) {
        return new UserActionV2(0, str);
    }

    public static UserActionV2 create(TrackingEvent trackingEvent) {
        return new UserActionV2(trackingEvent);
    }

    private UserActionV2(TrackingEvent trackingEvent) {
        super(0);
        this.action = GsonUtils.toJson(trackingEvent, false);
    }

    UserActionV2(long j, String str) {
        super(j);
        this.action = str;
    }

    public String getActionData() {
        return this.action;
    }
}
