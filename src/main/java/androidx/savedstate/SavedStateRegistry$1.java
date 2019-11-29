package androidx.savedstate;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.h;

class SavedStateRegistry$1 implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2985a;

    SavedStateRegistry$1(a aVar) {
        this.f2985a = aVar;
    }

    public void onStateChanged(h hVar, e.a aVar) {
        if (aVar == e.a.ON_START) {
            this.f2985a.f2986a = true;
        } else if (aVar == e.a.ON_STOP) {
            this.f2985a.f2986a = false;
        }
    }
}
