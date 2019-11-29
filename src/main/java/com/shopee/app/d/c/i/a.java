package com.shopee.app.d.c.i;

import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.v;
import com.shopee.app.util.n;

public class a extends com.shopee.app.d.c.a.a<C0257a> {

    /* renamed from: d  reason: collision with root package name */
    private final v f17051d;

    protected a(n nVar, v vVar) {
        super(nVar);
        this.f17051d = vVar;
    }

    public void a() {
        b(new C0257a(0, false));
    }

    public void a(boolean z) {
        b(new C0257a(1, z));
    }

    /* access modifiers changed from: protected */
    public void a(C0257a aVar) {
        int a2 = aVar.f17053b;
        if (a2 == 0) {
            boolean unused = aVar.f17052a = this.f17051d.f();
        } else if (a2 == 1) {
            this.f17051d.a(aVar.f17052a);
        }
        this.f16405a.a().j.a(aVar).a();
    }

    /* renamed from: com.shopee.app.d.c.i.a$a  reason: collision with other inner class name */
    public static class C0257a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f17052a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f17053b;

        public C0257a(int i, boolean z) {
            super("SoundNotificationSettingInteractor" + z + i, "use_case2", 400, true);
            this.f17052a = z;
            this.f17053b = i;
        }

        public boolean a() {
            return this.f17052a;
        }
    }
}
