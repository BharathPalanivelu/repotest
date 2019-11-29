package com.shopee.react.sdk.bridge.modules.app.application;

import android.os.Build;
import com.shopee.arcatch.data.common_bean.Country;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f30175a;

    /* renamed from: b  reason: collision with root package name */
    private String f30176b;

    /* renamed from: c  reason: collision with root package name */
    private String f30177c;

    /* renamed from: d  reason: collision with root package name */
    private String f30178d;

    /* renamed from: e  reason: collision with root package name */
    private String f30179e;

    /* renamed from: f  reason: collision with root package name */
    private String f30180f;

    /* renamed from: g  reason: collision with root package name */
    private String f30181g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private long n;

    private a(C0465a aVar) {
        this.f30175a = aVar.f30182a;
        this.f30176b = aVar.f30183b;
        this.f30177c = aVar.f30184c;
        this.f30178d = aVar.f30185d;
        this.f30179e = aVar.f30186e;
        this.f30180f = aVar.f30187f;
        this.f30181g = aVar.f30188g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
    }

    public String a() {
        return this.f30175a;
    }

    public String b() {
        return this.f30176b;
    }

    public String c() {
        return this.f30177c;
    }

    public String d() {
        return this.f30178d;
    }

    public String e() {
        return this.f30179e;
    }

    public String f() {
        return this.f30180f;
    }

    public String g() {
        return this.f30181g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.k;
    }

    public String l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }

    public long n() {
        return this.n;
    }

    /* renamed from: com.shopee.react.sdk.bridge.modules.app.application.a$a  reason: collision with other inner class name */
    public static final class C0465a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f30182a = "22005";
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f30183b = "";
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f30184c = "";
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f30185d = "live";
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f30186e = Country.COUNTRY_SG;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f30187f = "en";
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public String f30188g = String.valueOf(Build.VERSION.SDK_INT);
        /* access modifiers changed from: private */
        public String h = Build.MODEL;
        /* access modifiers changed from: private */
        public String i;
        /* access modifiers changed from: private */
        public String j = Build.BRAND;
        /* access modifiers changed from: private */
        public String k = Build.MODEL;
        /* access modifiers changed from: private */
        public String l = "";
        /* access modifiers changed from: private */
        public boolean m = false;
        /* access modifiers changed from: private */
        public long n = 0;

        public C0465a a(String str) {
            this.f30182a = str;
            return this;
        }

        public C0465a b(String str) {
            this.f30183b = str;
            return this;
        }

        public C0465a c(String str) {
            this.f30184c = str;
            return this;
        }

        public C0465a d(String str) {
            this.f30185d = str;
            return this;
        }

        public C0465a e(String str) {
            this.f30186e = str;
            return this;
        }

        public C0465a f(String str) {
            this.f30187f = str;
            return this;
        }

        public C0465a g(String str) {
            this.f30188g = str;
            return this;
        }

        public C0465a h(String str) {
            this.h = str;
            return this;
        }

        public C0465a i(String str) {
            this.i = str;
            return this;
        }

        public C0465a j(String str) {
            this.j = str;
            return this;
        }

        public C0465a k(String str) {
            this.k = str;
            return this;
        }

        public C0465a l(String str) {
            this.l = str;
            return this;
        }

        public C0465a a(boolean z) {
            this.m = z;
            return this;
        }

        public C0465a a(long j2) {
            this.n = j2;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
