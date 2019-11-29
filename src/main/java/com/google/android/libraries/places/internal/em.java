package com.google.android.libraries.places.internal;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class em implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    private final fs f12510a;

    public em(fs fsVar) {
        this.f12510a = fsVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.f12510a.a(i);
    }
}
