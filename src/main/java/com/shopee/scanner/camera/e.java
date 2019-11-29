package com.shopee.scanner.camera;

import android.graphics.SurfaceTexture;
import android.view.View;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private a f30310a;

    /* renamed from: b  reason: collision with root package name */
    private int f30311b;

    /* renamed from: c  reason: collision with root package name */
    private int f30312c;

    interface a {
        void a();
    }

    /* access modifiers changed from: package-private */
    public abstract View a();

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public abstract SurfaceTexture d();

    e() {
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f30310a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f30310a.a();
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2) {
        this.f30311b = i;
        this.f30312c = i2;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f30311b;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f30312c;
    }
}
