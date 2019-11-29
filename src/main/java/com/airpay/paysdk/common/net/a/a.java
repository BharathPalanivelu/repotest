package com.airpay.paysdk.common.net.a;

import com.airpay.paysdk.common.net.a.a.e;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private e f3984a;

    /* renamed from: b  reason: collision with root package name */
    private T f3985b;

    private a(C0078a<T> aVar) {
        this.f3984a = aVar.f3986a;
        this.f3985b = aVar.f3987b;
    }

    public e a() {
        return this.f3984a;
    }

    public T b() {
        return this.f3985b;
    }

    /* renamed from: com.airpay.paysdk.common.net.a.a$a  reason: collision with other inner class name */
    public static class C0078a<T> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public e f3986a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public T f3987b;

        public C0078a<T> a(e eVar) {
            this.f3986a = eVar;
            return this;
        }

        public C0078a<T> a(T t) {
            this.f3987b = t;
            return this;
        }

        public a<T> a() {
            return new a<>(this);
        }
    }
}
