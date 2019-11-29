package androidx.lifecycle;

import androidx.lifecycle.e;

class CompositeGeneratedAdaptersObserver implements f {

    /* renamed from: a  reason: collision with root package name */
    private final c[] f2546a;

    CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f2546a = cVarArr;
    }

    public void onStateChanged(h hVar, e.a aVar) {
        l lVar = new l();
        for (c a2 : this.f2546a) {
            a2.a(hVar, aVar, false, lVar);
        }
        for (c a3 : this.f2546a) {
            a3.a(hVar, aVar, true, lVar);
        }
    }
}
