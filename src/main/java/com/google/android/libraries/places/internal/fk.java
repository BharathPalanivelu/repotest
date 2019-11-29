package com.google.android.libraries.places.internal;

import android.database.DataSetObserver;

final class fk extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fj f12559a;

    fk(fj fjVar) {
        this.f12559a = fjVar;
    }

    public final void onChanged() {
        try {
            this.f12559a.f12556b = this.f12559a.f12557c;
            this.f12559a.f12557c = this.f12559a.f12555a.getCount();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void onInvalidated() {
        fj fjVar = this.f12559a;
        fjVar.f12557c = 0;
        fjVar.f12556b = 0;
    }
}
