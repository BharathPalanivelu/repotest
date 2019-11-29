package com.shopee.f.a.a;

import android.content.Context;
import android.content.IntentFilter;
import com.shopee.f.a.a.a.f;
import com.shopee.f.a.a.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    a f27278a;

    /* renamed from: b  reason: collision with root package name */
    private Context f27279b;

    /* renamed from: c  reason: collision with root package name */
    private String f27280c;

    /* renamed from: d  reason: collision with root package name */
    private String f27281d;

    /* renamed from: e  reason: collision with root package name */
    private String f27282e;

    /* renamed from: f  reason: collision with root package name */
    private a f27283f = null;

    /* renamed from: g  reason: collision with root package name */
    private f f27284g;

    public interface a {
        void a();

        void a(int i);

        void a(long j, long j2);

        void a(b.c cVar);
    }

    public c(Context context) {
        this.f27279b = context;
        a();
    }

    public void a() {
        b();
        this.f27283f = new a(this.f27279b, "independence_android");
        this.f27283f.a((b.a) new b.a() {
            public void a(long j, long j2) {
                if (c.this.f27278a != null) {
                    c.this.f27278a.a(j, j2);
                }
            }

            public void a(b.c cVar) {
                if (c.this.f27278a != null) {
                    c.this.f27278a.a(cVar);
                }
            }
        });
    }

    public void b() {
        this.f27284g = new f();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addCategory("android.intent.category.DEFAULT");
        this.f27279b.registerReceiver(this.f27284g, intentFilter);
    }

    public void c() {
        Context context = this.f27279b;
        if (context != null) {
            f fVar = this.f27284g;
            if (fVar != null) {
                context.unregisterReceiver(fVar);
            }
        }
    }

    public void a(String str, String str2, String str3) {
        this.f27280c = str2;
        this.f27281d = str3;
        this.f27282e = str;
    }

    public void d() {
        if (this.f27283f == null) {
            this.f27283f = new a(this.f27279b, "independence_android");
        }
        a aVar = this.f27278a;
        if (aVar != null) {
            aVar.a();
        }
        b.C0421b bVar = new b.C0421b();
        bVar.f27267a = this.f27282e;
        bVar.f27268b = this.f27280c;
        String str = this.f27281d;
        if (str != null && !str.equals("")) {
            bVar.f27269c = this.f27281d;
        }
        int a2 = this.f27283f.a(bVar);
        if (a2 != 0) {
            a aVar2 = this.f27278a;
            if (aVar2 != null) {
                aVar2.a(a2);
            }
        }
    }

    public void a(a aVar) {
        this.f27278a = aVar;
    }
}
