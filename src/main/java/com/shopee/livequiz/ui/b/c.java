package com.shopee.livequiz.ui.b;

import android.text.TextUtils;
import com.shopee.c.a;
import com.shopee.livequiz.a.b;
import com.shopee.livequiz.g.e;

public class c extends b<com.shopee.livequiz.ui.activity.c> {

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.livequiz.g.c f29942b;

    /* renamed from: c  reason: collision with root package name */
    private a f29943c;

    public c(a aVar) {
        com.shopee.c.b.a();
        this.f29943c = aVar;
    }

    public void a(com.shopee.livequiz.ui.activity.c cVar) {
        super.a(cVar);
        this.f29942b = new com.shopee.livequiz.g.c(com.shopee.livequiz.b.a().c(), b().j());
        this.f29942b.a(this.f29943c);
        g();
    }

    public void a() {
        super.a();
        this.f29942b.c();
        this.f29942b = null;
    }

    /* renamed from: c */
    public com.shopee.livequiz.ui.activity.c b() {
        return com.shopee.livequiz.g.a.a((com.shopee.livequiz.ui.activity.c) super.b());
    }

    private void g() {
        String str = com.shopee.livequiz.data.b.a().b().playUrl;
        if (TextUtils.isEmpty(str)) {
            b().a(e.a().a("t_neg_general_msg"));
            com.shopee.livequiz.b.e.a("empty_play_url_error");
        } else if (str.contains("rtmp")) {
            this.f29942b.a(str.replace("rtmp", "http") + ".flv", 1);
        } else if (str.contains("flv")) {
            this.f29942b.a(str, 1);
        }
    }

    public void d() {
        com.shopee.livequiz.g.c cVar = this.f29942b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void e() {
        com.shopee.livequiz.g.c cVar = this.f29942b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public String f() {
        com.shopee.livequiz.g.c cVar = this.f29942b;
        return cVar == null ? "" : cVar.d();
    }
}
