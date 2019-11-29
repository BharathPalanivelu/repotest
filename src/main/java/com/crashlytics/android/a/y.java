package com.crashlytics.android.a;

import com.crashlytics.android.a.ad;
import java.util.HashSet;
import java.util.Set;

class y implements p {

    /* renamed from: b  reason: collision with root package name */
    static final Set<ad.b> f6369b = new HashSet<ad.b>() {
        {
            add(ad.b.START);
            add(ad.b.RESUME);
            add(ad.b.PAUSE);
            add(ad.b.STOP);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f6370a;

    public y(int i) {
        this.f6370a = i;
    }

    public boolean a(ad adVar) {
        boolean z = f6369b.contains(adVar.f6285c) && adVar.f6283a.f6303g == null;
        boolean z2 = Math.abs(adVar.f6283a.f6299c.hashCode() % this.f6370a) != 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
