package com.airpay.paysdk.base.b;

import com.airpay.paysdk.common.net.a.a.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private long f3788a;

    /* renamed from: b  reason: collision with root package name */
    private String f3789b;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f3792a = new c();
    }

    public void a(String str) {
        com.airpay.paysdk.core.a.a().d(str, new com.airpay.paysdk.common.net.a.a.a<c>() {
            public void a(int i, String str) {
            }

            public void a(c cVar) {
                com.airpay.paysdk.common.b.a.b("cash data:" + cVar.toString(), new Object[0]);
            }
        });
    }

    public b b(String str) {
        return com.airpay.paysdk.core.a.a().d(str, new com.airpay.paysdk.common.net.a.a.a<c>() {
            public void a(int i, String str) {
            }

            public void a(c cVar) {
                com.airpay.paysdk.common.b.a.b("cash data:" + cVar.toString(), new Object[0]);
            }
        });
    }

    public static c a() {
        return a.f3792a;
    }

    private c() {
    }

    public void a(String str, long j, int i, long j2) {
        this.f3789b = str;
        this.f3788a = j;
    }

    public long b() {
        return this.f3788a;
    }

    public String c() {
        return this.f3789b;
    }

    public String toString() {
        return "CashDataManager{mCashBalance=" + this.f3788a + ", mCashCurrency='" + this.f3789b + '\'' + '}';
    }
}
