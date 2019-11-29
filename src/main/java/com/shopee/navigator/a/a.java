package com.shopee.navigator.a;

import android.app.Activity;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f30106a;

    /* renamed from: b  reason: collision with root package name */
    private int f30107b;

    /* renamed from: c  reason: collision with root package name */
    private int f30108c;

    /* renamed from: d  reason: collision with root package name */
    private int f30109d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30110e;

    public a() {
        this.f30106a = 0;
        this.f30107b = 0;
        this.f30108c = 0;
        this.f30109d = 0;
        this.f30110e = false;
    }

    private a(C0461a aVar) {
        this.f30106a = aVar.f30111a;
        this.f30107b = aVar.f30112b;
        this.f30108c = aVar.f30113c;
        this.f30109d = aVar.f30114d;
        this.f30110e = aVar.f30115e;
    }

    public boolean a() {
        return this.f30110e;
    }

    public void a(Activity activity) {
        activity.overridePendingTransition(this.f30106a, this.f30107b);
    }

    public void b(Activity activity) {
        activity.overridePendingTransition(this.f30108c, this.f30109d);
    }

    /* renamed from: com.shopee.navigator.a.a$a  reason: collision with other inner class name */
    public static final class C0461a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f30111a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f30112b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f30113c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f30114d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f30115e;

        public C0461a a(int i) {
            this.f30111a = i;
            return this;
        }

        public C0461a b(int i) {
            this.f30112b = i;
            return this;
        }

        public C0461a c(int i) {
            this.f30113c = i;
            return this;
        }

        public C0461a d(int i) {
            this.f30114d = i;
            return this;
        }

        public C0461a a(boolean z) {
            this.f30115e = z;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
