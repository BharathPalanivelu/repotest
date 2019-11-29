package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class n extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private int f13419a;

    public n(Context context) {
        this(context, (AttributeSet) null);
    }

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13419a = getVisibility();
    }

    public void setVisibility(int i) {
        a(i, true);
    }

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f13419a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f13419a;
    }
}
