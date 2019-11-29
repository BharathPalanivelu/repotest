package com.google.android.exoplayer2.q;

import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.u;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final p f11288a;

    /* renamed from: b  reason: collision with root package name */
    public final g f11289b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f11290c;

    /* renamed from: d  reason: collision with root package name */
    public final u[] f11291d;

    public i(p pVar, g gVar, Object obj, u[] uVarArr) {
        this.f11288a = pVar;
        this.f11289b = gVar;
        this.f11290c = obj;
        this.f11291d = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.f11289b.f11284a; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        if (iVar != null && v.a((Object) this.f11289b.a(i), (Object) iVar.f11289b.a(i)) && v.a((Object) this.f11291d[i], (Object) iVar.f11291d[i])) {
            return true;
        }
        return false;
    }
}
