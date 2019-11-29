package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingActionEvent extends TrackingEvent {
    @c(a = "info")
    public TrackingAction action;

    public TrackingActionEvent() {
        super("action");
    }
}
