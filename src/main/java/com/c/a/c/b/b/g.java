package com.c.a.c.b.b;

import android.annotation.SuppressLint;
import com.c.a.c.b.b.h;
import com.c.a.c.b.s;
import com.c.a.c.h;
import com.c.a.i.e;

public class g extends e<h, s<?>> implements h {

    /* renamed from: a  reason: collision with root package name */
    private h.a f5740a;

    public /* synthetic */ s a(com.c.a.c.h hVar) {
        return (s) super.c(hVar);
    }

    public /* bridge */ /* synthetic */ s b(com.c.a.c.h hVar, s sVar) {
        return (s) super.b(hVar, sVar);
    }

    public g(int i) {
        super(i);
    }

    public void a(h.a aVar) {
        this.f5740a = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(com.c.a.c.h hVar, s<?> sVar) {
        h.a aVar = this.f5740a;
        if (aVar != null) {
            aVar.b(sVar);
        }
    }

    /* access modifiers changed from: protected */
    public int a(s<?> sVar) {
        return sVar.d();
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 40) {
            a();
        } else if (i >= 20) {
            b(b() / 2);
        }
    }
}
