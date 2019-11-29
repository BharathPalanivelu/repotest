package com.google.android.libraries.places.internal;

import android.database.DataSetObserver;
import androidx.recyclerview.widget.RecyclerView;

final class fl extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ RecyclerView.c f12560a;

    fl(RecyclerView.c cVar) {
        this.f12560a = cVar;
    }

    public final void onChanged() {
        try {
            this.f12560a.a();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void onInvalidated() {
        try {
            this.f12560a.a();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
