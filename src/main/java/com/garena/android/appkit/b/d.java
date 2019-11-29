package com.garena.android.appkit.b;

import com.garena.android.appkit.b.b;

public abstract class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private int f7623a = 0;

    public b.C0122b getOption() {
        return b.C0122b.ANY_THREAD;
    }

    public void onRegister() {
        this.f7623a++;
    }

    public void onDismiss() {
        this.f7623a--;
    }

    public boolean isValid() {
        return this.f7623a > 0;
    }
}
