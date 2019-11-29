package com.google.android.libraries.places.internal;

import android.text.Editable;
import android.text.TextWatcher;

public final class er implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fs f12516a;

    public er(fs fsVar) {
        this.f12516a = fsVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        try {
            String obj = editable.toString();
            this.f12516a.o.a(obj);
            gc gcVar = this.f12516a.f12579e;
            gcVar.l++;
            gcVar.k = obj;
            this.f12516a.l();
            this.f12516a.k();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
