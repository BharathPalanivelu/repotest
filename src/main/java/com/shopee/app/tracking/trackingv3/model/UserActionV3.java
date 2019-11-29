package com.shopee.app.tracking.trackingv3.model;

import com.shopee.shopeetracker.EventRepository;
import com.shopee.shopeetracker.model.UserAction;
import com.shopee.shopeetracker.utils.GsonUtils;
import d.d.b.j;

public final class UserActionV3 extends UserAction {
    public static final Companion Companion = new Companion((g) null);
    private final String action;

    public static final UserActionV3 create(TrackingEvent trackingEvent) {
        return Companion.create(trackingEvent);
    }

    public int getType() {
        return 2;
    }

    public /* synthetic */ UserActionV3(TrackingEvent trackingEvent, g gVar) {
        this(trackingEvent);
    }

    private UserActionV3(TrackingEvent trackingEvent) {
        super(0);
        String json = GsonUtils.toJson(trackingEvent, false);
        j.a((Object) json, "GsonUtils.toJson(event, false)");
        this.action = json;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserActionV3(long j, String str) {
        super(j);
        j.b(str, "action");
        this.action = str;
    }

    public String getActionData() {
        return this.action;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final UserActionV3 create(String str) {
            j.b(str, "action");
            return new UserActionV3(0, str);
        }

        public final UserActionV3 create(TrackingEvent trackingEvent) {
            j.b(trackingEvent, EventRepository.TABLE);
            return new UserActionV3(trackingEvent, (g) null);
        }
    }
}
