package com.firebase.jobdispatcher;

import android.os.Bundle;

public final class n implements r {

    /* renamed from: a  reason: collision with root package name */
    private final String f7208a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7209b;

    /* renamed from: c  reason: collision with root package name */
    private final u f7210c;

    /* renamed from: d  reason: collision with root package name */
    private final x f7211d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7212e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f7213f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f7214g;
    private final boolean h;
    private final Bundle i;

    private n(a aVar) {
        this.f7208a = aVar.f7216b;
        this.i = aVar.f7217c == null ? null : new Bundle(aVar.f7217c);
        this.f7209b = aVar.f7218d;
        this.f7210c = aVar.f7219e;
        this.f7211d = aVar.h;
        this.f7212e = aVar.f7220f;
        this.f7213f = aVar.j;
        this.f7214g = aVar.f7221g != null ? aVar.f7221g : new int[0];
        this.h = aVar.i;
    }

    public int[] a() {
        return this.f7214g;
    }

    public Bundle b() {
        return this.i;
    }

    public x c() {
        return this.f7211d;
    }

    public boolean d() {
        return this.h;
    }

    public String e() {
        return this.f7209b;
    }

    public u f() {
        return this.f7210c;
    }

    public int g() {
        return this.f7212e;
    }

    public boolean h() {
        return this.f7213f;
    }

    public String i() {
        return this.f7208a;
    }

    public static final class a implements r {

        /* renamed from: a  reason: collision with root package name */
        private final aa f7215a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f7216b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Bundle f7217c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f7218d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public u f7219e = y.f7265a;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f7220f = 1;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int[] f7221g;
        /* access modifiers changed from: private */
        public x h = x.f7259a;
        /* access modifiers changed from: private */
        public boolean i = false;
        /* access modifiers changed from: private */
        public boolean j = false;

        a(aa aaVar) {
            this.f7215a = aaVar;
        }

        a(aa aaVar, r rVar) {
            this.f7215a = aaVar;
            this.f7218d = rVar.e();
            this.f7216b = rVar.i();
            this.f7219e = rVar.f();
            this.j = rVar.h();
            this.f7220f = rVar.g();
            this.f7221g = rVar.a();
            this.f7217c = rVar.b();
            this.h = rVar.c();
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public n j() {
            this.f7215a.b(this);
            return new n(this);
        }

        public String i() {
            return this.f7216b;
        }

        public a a(Class<? extends s> cls) {
            this.f7216b = cls == null ? null : cls.getName();
            return this;
        }

        public String e() {
            return this.f7218d;
        }

        public a a(String str) {
            this.f7218d = str;
            return this;
        }

        public u f() {
            return this.f7219e;
        }

        public a a(u uVar) {
            this.f7219e = uVar;
            return this;
        }

        public int g() {
            return this.f7220f;
        }

        public a a(int i2) {
            this.f7220f = i2;
            return this;
        }

        public boolean h() {
            return this.j;
        }

        public a b(boolean z) {
            this.j = z;
            return this;
        }

        public int[] a() {
            int[] iArr = this.f7221g;
            return iArr == null ? new int[0] : iArr;
        }

        public a a(int... iArr) {
            this.f7221g = iArr;
            return this;
        }

        public Bundle b() {
            return this.f7217c;
        }

        public x c() {
            return this.h;
        }

        public a a(x xVar) {
            this.h = xVar;
            return this;
        }

        public boolean d() {
            return this.i;
        }
    }
}
