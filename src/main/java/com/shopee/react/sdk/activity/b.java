package com.shopee.react.sdk.activity;

public class b extends com.shopee.navigator.b {

    /* renamed from: a  reason: collision with root package name */
    private String f30157a;

    /* renamed from: b  reason: collision with root package name */
    private String f30158b;

    /* renamed from: c  reason: collision with root package name */
    private String f30159c;

    /* renamed from: d  reason: collision with root package name */
    private int f30160d;

    private b(a aVar) {
        this.f30157a = aVar.f30161a;
        this.f30158b = aVar.f30162b;
        this.f30159c = aVar.f30163c;
        this.f30160d = aVar.f30164d;
    }

    public String a() {
        return this.f30158b;
    }

    public String b() {
        return this.f30159c;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f30161a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f30162b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f30163c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f30164d;

        public a a(String str) {
            this.f30161a = str;
            return this;
        }

        public a b(String str) {
            this.f30162b = str;
            return this;
        }

        public a c(String str) {
            this.f30163c = str;
            return this;
        }

        public a a(int i) {
            this.f30164d = i;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}
