package com.shopee.scanner.camera;

import android.view.View;
import java.util.Set;

abstract class b {

    /* renamed from: a  reason: collision with root package name */
    final a f30301a;

    /* renamed from: b  reason: collision with root package name */
    final e f30302b;

    interface a {
        void a();

        void b();
    }

    /* access modifiers changed from: package-private */
    public abstract void a(int i);

    /* access modifiers changed from: package-private */
    public abstract void a(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void a(boolean z);

    /* access modifiers changed from: package-private */
    public abstract boolean a();

    /* access modifiers changed from: package-private */
    public abstract boolean a(AspectRatio aspectRatio);

    /* access modifiers changed from: package-private */
    public abstract void b();

    /* access modifiers changed from: package-private */
    public abstract void b(int i);

    /* access modifiers changed from: package-private */
    public abstract void c(int i);

    /* access modifiers changed from: package-private */
    public abstract boolean c();

    /* access modifiers changed from: package-private */
    public abstract int d();

    /* access modifiers changed from: package-private */
    public abstract Set<AspectRatio> e();

    /* access modifiers changed from: package-private */
    public abstract AspectRatio f();

    /* access modifiers changed from: package-private */
    public abstract boolean g();

    /* access modifiers changed from: package-private */
    public abstract int h();

    b(a aVar, e eVar) {
        this.f30301a = aVar;
        this.f30302b = eVar;
    }

    /* access modifiers changed from: package-private */
    public View i() {
        return this.f30302b.a();
    }
}
