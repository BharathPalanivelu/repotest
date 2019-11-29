package com.squareup.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.a.w;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final w f30489a;

    /* renamed from: b  reason: collision with root package name */
    final z f30490b;

    /* renamed from: c  reason: collision with root package name */
    final WeakReference<T> f30491c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30492d;

    /* renamed from: e  reason: collision with root package name */
    final int f30493e;

    /* renamed from: f  reason: collision with root package name */
    final int f30494f;

    /* renamed from: g  reason: collision with root package name */
    final int f30495g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public abstract void a(Bitmap bitmap, w.d dVar);

    /* renamed from: com.squareup.a.a$a  reason: collision with other inner class name */
    static class C0477a<M> extends WeakReference<M> {

        /* renamed from: a  reason: collision with root package name */
        final a f30496a;

        public C0477a(a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f30496a = aVar;
        }
    }

    a(w wVar, T t, z zVar, int i2, int i3, int i4, Drawable drawable, String str, Object obj, boolean z) {
        C0477a aVar;
        this.f30489a = wVar;
        this.f30490b = zVar;
        if (t == null) {
            aVar = null;
        } else {
            aVar = new C0477a(this, t, wVar.i);
        }
        this.f30491c = aVar;
        this.f30493e = i2;
        this.f30494f = i3;
        this.f30492d = z;
        this.f30495g = i4;
        this.h = drawable;
        this.i = str;
        this.j = obj == null ? this : obj;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.l = true;
    }

    /* access modifiers changed from: package-private */
    public z c() {
        return this.f30490b;
    }

    /* access modifiers changed from: package-private */
    public T d() {
        WeakReference<T> weakReference = this.f30491c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f30493e;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f30494f;
    }

    /* access modifiers changed from: package-private */
    public w j() {
        return this.f30489a;
    }

    /* access modifiers changed from: package-private */
    public w.e k() {
        return this.f30490b.t;
    }

    /* access modifiers changed from: package-private */
    public Object l() {
        return this.j;
    }
}
