package com.shopee.app.ui.chat2.search;

import com.garena.android.appkit.b.i;
import com.garena.android.appkit.f.f;
import com.shopee.app.d.c.ce;
import com.shopee.app.d.c.f.m;
import com.shopee.app.d.c.f.o;
import com.shopee.app.d.c.j;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.h.r;
import com.shopee.app.network.d.l;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.ae;
import com.shopee.app.util.bi;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class b extends q<d> implements ae.a {
    /* access modifiers changed from: private */
    public static List<UserData> l = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private final i f20865a = com.garena.a.a.a.b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private final m f20866c;

    /* renamed from: d  reason: collision with root package name */
    private final j f20867d;

    /* renamed from: e  reason: collision with root package name */
    private final ce f20868e;

    /* renamed from: f  reason: collision with root package name */
    private final com.shopee.app.d.c.f.i f20869f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final o f20870g;
    private final bi h;
    /* access modifiers changed from: private */
    public String i = "";
    /* access modifiers changed from: private */
    public int j = 0;
    private int k = 0;
    private a m = new a(true);
    private a n = new a(false);
    private boolean o = true;
    private boolean p;

    public b(j jVar, com.shopee.app.d.c.f.i iVar, o oVar, ce ceVar, m mVar, bi biVar) {
        this.f20870g = oVar;
        this.f20866c = mVar;
        this.f20869f = iVar;
        this.f20867d = jVar;
        this.f20868e = ceVar;
        this.h = biVar;
    }

    public void a() {
        this.f20865a.a();
    }

    public void c() {
        super.c();
        this.f20865a.c();
    }

    public void d() {
        super.d();
        this.f20865a.d();
    }

    public void b() {
        this.f20865a.b();
    }

    public void a(String str) {
        this.i = str;
        ((d) this.f19220b).b();
        this.f20866c.a(true);
        this.f20869f.a(false);
        this.f20870g.a(this.i, this.j, l, false);
    }

    public void b(String str) {
        this.i = str;
        if (!this.m.b()) {
            this.m.a();
            f.a().a(this.m, 400);
        }
    }

    public void c(String str) {
        this.i = str;
        if (!this.n.b()) {
            this.n.a();
            f.a().a(this.n, 400);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (i2 <= 0) {
            this.f20869f.a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<UserData> list) {
        l = list;
        b(this.i);
    }

    /* access modifiers changed from: package-private */
    public void b(List<UserData> list) {
        this.f20869f.a(false);
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        if (!str.equals(this.i)) {
            this.j = 0;
            this.o = true;
        }
        this.h.a("SHOW_SEARCH_PROGRESS", new com.garena.android.appkit.b.a());
        this.n.c();
        this.m.c();
        this.n = new a(false);
        this.m = new a(true);
        b(str);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        c("");
    }

    /* access modifiers changed from: package-private */
    public void c(List<ChatItem2> list) {
        ((d) this.f19220b).c();
        ((d) this.f19220b).a((List<ChatItem2>) new ArrayList(list));
        if (this.j == 0 && this.o) {
            ((d) this.f19220b).h();
            ((d) this.f19220b).e();
            this.o = false;
        } else if (list.size() + 1 == this.k) {
            ((d) this.f19220b).d();
        } else {
            ((d) this.f19220b).e();
        }
        this.h.a("HIDE_SEARCH_PROGRESS", new com.garena.android.appkit.b.a());
    }

    /* access modifiers changed from: package-private */
    public void f() {
        c(this.i);
        ((d) this.f19220b).g();
    }

    /* access modifiers changed from: package-private */
    public void a(ChatMessage chatMessage) {
        this.p = false;
    }

    /* access modifiers changed from: package-private */
    public void d(List<Object> list) {
        this.p = true;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.p) {
            this.p = false;
        } else {
            b(this.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        c(this.i);
    }

    /* access modifiers changed from: package-private */
    public void b(ChatMessage chatMessage) {
        b(this.i);
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        ((d) this.f19220b).c();
        ((d) this.f19220b).g();
        r.a().b((int) R.string.sp_network_error);
    }

    public void e(int i2) {
        l lVar = new l();
        lVar.h();
        lVar.a(i2);
        ((d) this.f19220b).f();
    }

    public void f(int i2) {
        this.f20867d.a(i2);
    }

    public void g(int i2) {
        this.f20868e.a(i2);
    }

    public void d(int i2) {
        this.k = i2;
        this.j++;
        this.f20870g.a(this.i, this.j, l, true);
    }

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private boolean f20872b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f20873c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f20874d = false;

        public a(boolean z) {
            this.f20873c = z;
        }

        public void a() {
            this.f20872b = true;
        }

        public boolean b() {
            return this.f20872b;
        }

        public void c() {
            this.f20874d = true;
        }

        public void run() {
            this.f20872b = false;
            if (!this.f20874d) {
                b.this.f20870g.a(b.this.i, b.this.j, b.l, this.f20873c);
            }
            this.f20874d = false;
        }
    }
}
