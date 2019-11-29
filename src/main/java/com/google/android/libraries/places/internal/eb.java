package com.google.android.libraries.places.internal;

import android.view.View;
import com.google.android.libraries.places.widget.AutocompleteFragment;

public final /* synthetic */ class eb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final AutocompleteFragment f12490a;

    public eb(AutocompleteFragment autocompleteFragment) {
        this.f12490a = autocompleteFragment;
    }

    public final void onClick(View view) {
        this.f12490a.setText("");
    }
}
