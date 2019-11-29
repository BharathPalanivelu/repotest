package com.google.android.exoplayer2.l;

import com.google.android.exoplayer2.ao;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.ad;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final ad f10739a;

    /* renamed from: b  reason: collision with root package name */
    public final g f10740b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f10741c;

    /* renamed from: d  reason: collision with root package name */
    public final ao[] f10742d;

    public i(ad adVar, g gVar, Object obj, ao[] aoVarArr) {
        this.f10739a = adVar;
        this.f10740b = gVar;
        this.f10741c = obj;
        this.f10742d = aoVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i = 0; i < this.f10740b.f10735a; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        if (iVar != null && t.a((Object) this.f10740b.a(i), (Object) iVar.f10740b.a(i)) && t.a((Object) this.f10742d[i], (Object) iVar.f10742d[i])) {
            return true;
        }
        return false;
    }
}
