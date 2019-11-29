package com.shopee.sdk.modules.ui.d;

import com.google.a.l;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f30423a;

    /* renamed from: b  reason: collision with root package name */
    private l f30424b;

    private a(C0474a aVar) {
        this.f30423a = aVar.f30425a;
        this.f30424b = aVar.f30426b;
    }

    public String a() {
        return this.f30423a;
    }

    public l b() {
        return this.f30424b;
    }

    /* renamed from: com.shopee.sdk.modules.ui.d.a$a  reason: collision with other inner class name */
    public static final class C0474a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f30425a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public l f30426b;

        public C0474a a(String str) {
            this.f30425a = str;
            return this;
        }

        public C0474a a(l lVar) {
            this.f30426b = lVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
