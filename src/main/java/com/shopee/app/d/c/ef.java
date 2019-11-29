package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.data.store.bb;
import com.shopee.app.util.n;

public class ef extends a {

    /* renamed from: c  reason: collision with root package name */
    private final n f16911c;

    /* renamed from: d  reason: collision with root package name */
    private final bb f16912d;

    /* renamed from: e  reason: collision with root package name */
    private int f16913e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16914f;

    /* access modifiers changed from: protected */
    public String d() {
        return "UpdateRatingStatusInteractor";
    }

    protected ef(n nVar, bb bbVar) {
        super(nVar);
        this.f16911c = nVar;
        this.f16912d = bbVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f16914f) {
            this.f16912d.a(this.f16913e);
        } else {
            this.f16912d.b(this.f16913e);
        }
        this.f16911c.a("RARING_STATUS_CHANGE", new a());
    }

    public void a(int i, boolean z) {
        this.f16913e = i;
        this.f16914f = z;
        a();
    }
}
