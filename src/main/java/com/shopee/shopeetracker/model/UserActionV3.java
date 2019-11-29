package com.shopee.shopeetracker.model;

import com.shopee.shopeetracker.EventRepository;
import com.shopee.shopeetracker.utils.GsonUtils;
import d.d.b.j;

public class UserActionV3 extends UserAction {
    private String action;

    public int getType() {
        return 2;
    }

    private UserActionV3(TrackingEventV3 trackingEventV3) {
        super(0);
        this.action = GsonUtils.toJson(trackingEventV3, false);
    }

    public UserActionV3(long j, String str) {
        super(j);
        this.action = str;
    }

    public UserActionV3(long j, TrackingEventV3 trackingEventV3) {
        super(j);
        this.action = GsonUtils.toJson(trackingEventV3, false);
    }

    public String getActionData() {
        return this.action;
    }

    public static UserActionV3 create(String str) {
        j.b(str, "action");
        return new UserActionV3(0, str);
    }

    public static UserActionV3 create(TrackingEventV3 trackingEventV3) {
        j.b(trackingEventV3, EventRepository.TABLE);
        return new UserActionV3(trackingEventV3);
    }
}
