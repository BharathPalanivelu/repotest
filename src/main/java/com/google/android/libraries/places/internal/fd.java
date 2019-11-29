package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.libraries.places.api.model.Place;

final /* synthetic */ class fd implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final fa f12544a;

    fd(fa faVar) {
        this.f12544a = faVar;
    }

    public final void onFailure(Exception exc) {
        fa faVar = this.f12544a;
        faVar.f12539a.f12530c = null;
        ex exVar = faVar.f12539a;
        ex exVar2 = faVar.f12539a;
        exVar.a(new fe(3, ex.a(exc), ha.g(), -1, (Place) null));
    }
}
