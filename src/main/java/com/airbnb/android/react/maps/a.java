package com.airbnb.android.react.maps;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;

public class a extends ReactViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public int f3248a;

    /* renamed from: b  reason: collision with root package name */
    public int f3249b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3250c = false;

    public a(Context context) {
        super(context);
    }

    public void setTooltip(boolean z) {
        this.f3250c = z;
    }

    public boolean getTooltip() {
        return this.f3250c;
    }
}
