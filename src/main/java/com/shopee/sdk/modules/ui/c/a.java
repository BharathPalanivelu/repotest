package com.shopee.sdk.modules.ui.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f30417a;

    /* renamed from: b  reason: collision with root package name */
    private int f30418b;

    /* renamed from: c  reason: collision with root package name */
    private String f30419c;

    private a(C0473a aVar) {
        this.f30417a = aVar.f30420a;
        this.f30418b = aVar.f30421b;
        this.f30419c = aVar.f30422c;
    }

    public int a() {
        return this.f30418b;
    }

    public String b() {
        return this.f30419c;
    }

    /* renamed from: com.shopee.sdk.modules.ui.c.a$a  reason: collision with other inner class name */
    public static final class C0473a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f30420a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f30421b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f30422c;

        public C0473a a(String str) {
            this.f30422c = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
