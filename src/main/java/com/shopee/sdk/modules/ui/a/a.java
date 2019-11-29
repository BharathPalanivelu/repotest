package com.shopee.sdk.modules.ui.a;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f30403a;

    /* renamed from: b  reason: collision with root package name */
    private String f30404b;

    /* renamed from: c  reason: collision with root package name */
    private String f30405c;

    /* renamed from: d  reason: collision with root package name */
    private String f30406d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30407e;

    private a(C0472a aVar) {
        this.f30407e = true;
        this.f30403a = aVar.f30408a;
        this.f30404b = aVar.f30409b;
        this.f30405c = aVar.f30410c;
        this.f30406d = aVar.f30411d;
        this.f30407e = aVar.f30412e;
    }

    public String a() {
        return this.f30403a;
    }

    public String b() {
        return this.f30404b;
    }

    public String c() {
        return this.f30405c;
    }

    public String d() {
        return this.f30406d;
    }

    public boolean e() {
        return this.f30407e;
    }

    /* renamed from: com.shopee.sdk.modules.ui.a.a$a  reason: collision with other inner class name */
    public static final class C0472a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f30408a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f30409b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f30410c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f30411d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f30412e = true;

        public C0472a a(String str) {
            this.f30408a = str;
            return this;
        }

        public C0472a b(String str) {
            this.f30409b = str;
            return this;
        }

        public C0472a c(String str) {
            this.f30410c = str;
            return this;
        }

        public C0472a d(String str) {
            this.f30411d = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
