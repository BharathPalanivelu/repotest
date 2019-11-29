package a;

import a.k;

class m {

    /* renamed from: a  reason: collision with root package name */
    private k<?> f410a;

    public m(k<?> kVar) {
        this.f410a = kVar;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            k<?> kVar = this.f410a;
            if (kVar != null) {
                k.b a2 = k.a();
                if (a2 != null) {
                    a2.a(kVar, new n(kVar.g()));
                }
            }
        } finally {
            super.finalize();
        }
    }

    public void a() {
        this.f410a = null;
    }
}
