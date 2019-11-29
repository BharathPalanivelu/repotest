package com.garena.f;

import com.garena.h.e;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private e f7982a;

    /* renamed from: b  reason: collision with root package name */
    private int f7983b;

    /* renamed from: c  reason: collision with root package name */
    private String f7984c;

    private i(a aVar) {
        this.f7982a = aVar.f7985a;
        this.f7983b = aVar.f7986b;
        this.f7984c = aVar.f7987c;
    }

    public String a() {
        return this.f7982a.a();
    }

    public e b() {
        return this.f7982a;
    }

    public int c() {
        return this.f7983b;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public e f7985a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f7986b = 30000;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f7987c;

        public a a(e eVar) {
            this.f7985a = eVar;
            return this;
        }

        public a a(int i) {
            this.f7986b = i;
            return this;
        }

        public a a(String str) {
            this.f7987c = str;
            return this;
        }

        public i a() {
            return new i(this);
        }
    }
}
