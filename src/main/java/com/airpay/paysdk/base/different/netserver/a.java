package com.airpay.paysdk.base.different.netserver;

import android.text.TextUtils;
import android.util.AndroidRuntimeException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f3828a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3829b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3830c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3831d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3832e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3833f;

    /* renamed from: g  reason: collision with root package name */
    private final String f3834g;

    private a(C0072a aVar) {
        if (!TextUtils.isEmpty(aVar.f3835a)) {
            if (aVar.f3836b == 0) {
                aVar.a(4);
            }
            this.f3828a = aVar.f3835a;
            this.f3829b = aVar.f3836b;
            this.f3830c = aVar.f3837c;
            this.f3831d = 1;
            this.f3832e = 2;
            this.f3833f = aVar.f3838d;
            this.f3834g = aVar.f3839e;
            return;
        }
        throw new AndroidRuntimeException("the country can't be null. the country value ref @com.airpay.paysdk.base.different.netserver.IServerEnvs.java");
    }

    public boolean a() {
        if (!TextUtils.isEmpty(this.f3828a) && !TextUtils.isEmpty(this.f3830c)) {
            return true;
        }
        return false;
    }

    public String b() {
        return this.f3828a;
    }

    public int c() {
        return this.f3829b;
    }

    public String d() {
        return this.f3830c;
    }

    public int e() {
        return this.f3831d;
    }

    public int f() {
        return this.f3832e;
    }

    public boolean g() {
        return this.f3833f;
    }

    public String h() {
        return this.f3834g;
    }

    /* renamed from: com.airpay.paysdk.base.different.netserver.a$a  reason: collision with other inner class name */
    public static class C0072a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f3835a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f3836b = 4;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f3837c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f3838d = false;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f3839e = "";

        public C0072a a(String str) {
            this.f3835a = str;
            return this;
        }

        public C0072a a(int i) {
            this.f3836b = i;
            return this;
        }

        public C0072a b(String str) {
            this.f3837c = str;
            return this;
        }

        public C0072a a(boolean z) {
            this.f3838d = z;
            return this;
        }

        public C0072a c(String str) {
            this.f3839e = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
