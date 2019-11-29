package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;

final /* synthetic */ class ey implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    private final ex f12535a;

    ey(ex exVar) {
        this.f12535a = exVar;
    }

    public final void onSuccess(Object obj) {
        ex exVar = this.f12535a;
        exVar.f12530c = null;
        exVar.a(fe.a(exVar.f12532e, ((FetchPlaceResponse) obj).getPlace()));
        if (exVar.f12533f != null) {
            exVar.f12533f.onPlaceSelected(exVar.f12532e.f12551e);
        }
    }
}
