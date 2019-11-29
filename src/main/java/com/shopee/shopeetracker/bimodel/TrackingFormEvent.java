package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingFormEvent extends TrackingEvent {
    @c(a = "info")
    public TrackingForm form;

    public TrackingFormEvent() {
        super(TrackingType.FORM);
    }
}
