package androidx.activity;

import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.h;

class ComponentActivity$3 implements f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f522a;

    ComponentActivity$3(b bVar) {
        this.f522a = bVar;
    }

    public void onStateChanged(h hVar, e.a aVar) {
        if (aVar == e.a.ON_DESTROY && !this.f522a.isChangingConfigurations()) {
            this.f522a.getViewModelStore().a();
        }
    }
}
