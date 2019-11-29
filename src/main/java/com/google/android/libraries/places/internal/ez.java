package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class ez implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final ex f12536a;

    ez(ex exVar) {
        this.f12536a = exVar;
    }

    public final void onFailure(Exception exc) {
        ex exVar = this.f12536a;
        exVar.f12530c = null;
        exVar.a(fe.a(exVar.f12532e, ex.a(exc)));
    }
}
