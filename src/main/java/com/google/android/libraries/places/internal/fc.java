package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;

final /* synthetic */ class fc implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    private final fa f12543a;

    fc(fa faVar) {
        this.f12543a = faVar;
    }

    public final void onSuccess(Object obj) {
        fa faVar = this.f12543a;
        faVar.f12539a.f12530c = null;
        faVar.f12539a.a(fe.a(((FindAutocompletePredictionsResponse) obj).getAutocompletePredictions()));
    }
}
