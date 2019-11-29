package com.shopee.livequiz.d.c;

import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.d.b.b;
import java.io.IOException;

public class a extends com.shopee.livequiz.c.a<C0456a, d<Void>> {

    /* renamed from: c  reason: collision with root package name */
    private b f29735c;

    public a(c cVar, b bVar) {
        super(cVar);
        this.f29735c = bVar;
    }

    /* access modifiers changed from: protected */
    public void a(C0456a aVar, final d<Void> dVar) {
        try {
            if (this.f29735c.a(aVar.f29740a, aVar.f29741b, aVar.f29742c, new com.shopee.livequiz.d.a.b.c(1)).a().d()) {
                a(new e() {
                    public void a() {
                        d dVar = dVar;
                        if (dVar != null) {
                            dVar.a(null);
                        }
                    }
                });
                return;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        a(new e() {
            public void a() {
                d dVar = dVar;
                if (dVar != null) {
                    dVar.a(-99, "post failed");
                }
            }
        });
    }

    /* renamed from: com.shopee.livequiz.d.c.a$a  reason: collision with other inner class name */
    public static class C0456a {

        /* renamed from: a  reason: collision with root package name */
        String f29740a;

        /* renamed from: b  reason: collision with root package name */
        int f29741b;

        /* renamed from: c  reason: collision with root package name */
        int f29742c;

        public C0456a(String str, int i, int i2) {
            this.f29740a = str;
            this.f29741b = i;
            this.f29742c = i2;
        }
    }
}
