package com.google.android.libraries.places.internal;

import com.android.b.a.h;
import com.google.android.gms.tasks.OnTokenCanceledListener;

public final /* synthetic */ class n implements OnTokenCanceledListener {

    /* renamed from: a  reason: collision with root package name */
    private final h f13000a;

    public n(h hVar) {
        this.f13000a = hVar;
    }

    public final void onCanceled() {
        this.f13000a.cancel();
    }
}
