package com.google.android.libraries.places.internal;

import android.view.View;
import android.widget.AdapterView;

final /* synthetic */ class fr implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final fq f12572a;

    /* renamed from: b  reason: collision with root package name */
    private final ex f12573b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12574c;

    fr(fq fqVar, ex exVar, int i) {
        this.f12572a = fqVar;
        this.f12573b = exVar;
        this.f12574c = i;
    }

    public final void onClick(View view) {
        fq fqVar = this.f12572a;
        ex exVar = this.f12573b;
        int i = this.f12574c;
        try {
            exVar.onItemClick((AdapterView<?>) null, fqVar.itemView, i, (long) i);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
