package com.google.android.libraries.places.internal;

import androidx.recyclerview.widget.RecyclerView;

public final class et extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fs f12518a;

    public et(fs fsVar) {
        this.f12518a = fsVar;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 1) {
            try {
                this.f12518a.i();
            } catch (Error | RuntimeException e2) {
                dx.a(e2);
                throw e2;
            }
        }
    }
}
