package com.airpay.paysdk.base.b;

import com.airpay.paysdk.qrcode.model.BankAccountInfo;
import com.airpay.paysdk.qrcode.model.BankAccountListInfo;
import java.util.List;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Long, BankAccountInfo> f3785a;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f3787a = new b();
    }

    public static b a() {
        return a.f3787a;
    }

    private b() {
        this.f3785a = new androidx.b.a();
    }

    public void b() {
        com.airpay.paysdk.core.a.a().b(new com.airpay.paysdk.common.net.a.a.a<BankAccountListInfo>() {
            public void a(int i, String str) {
            }

            public void a(BankAccountListInfo bankAccountListInfo) {
            }
        });
    }

    public void a(List<BankAccountInfo> list) {
        this.f3785a.clear();
        if (list != null && !list.isEmpty()) {
            for (BankAccountInfo next : list) {
                this.f3785a.put(Long.valueOf(next.f4355a), next);
            }
        }
    }

    public BankAccountInfo a(long j) {
        if (this.f3785a.isEmpty()) {
            return null;
        }
        return this.f3785a.get(Long.valueOf(j));
    }

    public void c() {
        this.f3785a.clear();
    }
}
