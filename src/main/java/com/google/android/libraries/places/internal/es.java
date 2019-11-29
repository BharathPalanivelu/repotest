package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

public final class es implements PlaceSelectionListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fs f12517a;

    public es(fs fsVar) {
        this.f12517a = fsVar;
    }

    public final void onPlaceSelected(Place place) {
        try {
            this.f12517a.a(place);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void onError(Status status) {
        try {
            this.f12517a.a(2, (Place) null, status);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
