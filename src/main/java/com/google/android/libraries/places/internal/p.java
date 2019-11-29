package com.google.android.libraries.places.internal;

import com.c.a.g.b;
import com.google.android.gms.tasks.OnTokenCanceledListener;

public final /* synthetic */ class p implements OnTokenCanceledListener {

    /* renamed from: a  reason: collision with root package name */
    private final b f13058a;

    public p(b bVar) {
        this.f13058a = bVar;
    }

    public final void onCanceled() {
        this.f13058a.cancel(false);
    }
}
