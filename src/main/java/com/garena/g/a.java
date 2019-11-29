package com.garena.g;

import android.net.Uri;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f7990a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f7991b;

    /* renamed from: c  reason: collision with root package name */
    private String f7992c;

    /* renamed from: d  reason: collision with root package name */
    private String f7993d;

    /* renamed from: e  reason: collision with root package name */
    private int f7994e;

    public String a() {
        return this.f7993d;
    }

    public void a(String str) {
        this.f7993d = str;
    }

    public String b() {
        return this.f7990a;
    }

    public void b(String str) {
        this.f7990a = str;
    }

    public Uri c() {
        return this.f7991b;
    }

    public void a(Uri uri) {
        this.f7991b = uri;
    }

    public String d() {
        return this.f7992c;
    }

    public void c(String str) {
        this.f7992c = str;
    }

    public int e() {
        return this.f7994e;
    }

    public void a(int i) {
        this.f7994e = i;
    }

    /* renamed from: com.garena.g.a$a  reason: collision with other inner class name */
    public static class C0132a {

        /* renamed from: a  reason: collision with root package name */
        private String f7995a;

        /* renamed from: b  reason: collision with root package name */
        private Uri f7996b;

        /* renamed from: c  reason: collision with root package name */
        private String f7997c;

        /* renamed from: d  reason: collision with root package name */
        private String f7998d;

        /* renamed from: e  reason: collision with root package name */
        private int f7999e = 0;

        private C0132a() {
        }

        public static C0132a a() {
            return new C0132a();
        }

        public C0132a a(String str) {
            this.f7995a = str;
            return this;
        }

        public C0132a a(Uri uri) {
            this.f7996b = uri;
            return this;
        }

        public C0132a b(String str) {
            this.f7997c = str;
            return this;
        }

        public C0132a c(String str) {
            this.f7998d = str;
            return this;
        }

        public a b() {
            a aVar = new a();
            aVar.b(this.f7995a);
            aVar.a(this.f7996b);
            aVar.c(this.f7997c);
            aVar.a(this.f7998d);
            aVar.a(this.f7999e);
            return aVar;
        }

        public C0132a a(int i) {
            this.f7999e = i;
            return this;
        }
    }
}
