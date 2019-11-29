package com.google.android.libraries.places.internal;

import android.view.View;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;

public final /* synthetic */ class ed implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final AutocompleteSupportFragment f12492a;

    public ed(AutocompleteSupportFragment autocompleteSupportFragment) {
        this.f12492a = autocompleteSupportFragment;
    }

    public final void onClick(View view) {
        this.f12492a.setText("");
    }
}
