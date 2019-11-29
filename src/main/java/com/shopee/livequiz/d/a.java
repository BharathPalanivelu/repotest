package com.shopee.livequiz.d;

import com.shopee.livequiz.d.c.d;
import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.g.j;
import com.shopee.livequiz.g.k;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private k f29712a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C0455a f29713b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public d f29714c = com.shopee.livequiz.d.b.a.h();

    /* renamed from: com.shopee.livequiz.d.a$a  reason: collision with other inner class name */
    public interface C0455a {
        void a();

        void a(GameData gameData);
    }

    public a(final int i, final int i2, long j, long j2) {
        this.f29714c.a(j2);
        this.f29712a = new k(new k.a() {
            public void a() {
                a.this.f29714c.b(new d.b(i, i2), new com.shopee.livequiz.c.d<String>() {
                    public void a(String str) {
                        if (!j.a(str)) {
                            try {
                                a.this.f29713b.a((GameData) GameData.fromJson(str, GameData.class));
                            } catch (Exception unused) {
                                a.this.f29713b.a();
                            }
                        }
                    }

                    public void a(int i, String str) {
                        com.garena.android.appkit.d.a.a("GetIssueRequest %s", "get im issue error");
                        a.this.f29713b.a();
                    }
                });
            }
        }, j);
    }

    public void a(C0455a aVar) {
        this.f29713b = aVar;
    }

    public void a() {
        k kVar = this.f29712a;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void b() {
        k kVar = this.f29712a;
        if (kVar != null) {
            kVar.c();
        }
    }

    public void c() {
        b();
        this.f29712a = null;
        this.f29713b = null;
    }
}
