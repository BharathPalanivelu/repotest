package com.shopee.app.ui.chat2;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.ce;
import com.shopee.app.d.c.ed;
import com.shopee.app.d.c.f.a;
import com.shopee.app.d.c.f.c;
import com.shopee.app.d.c.f.g;
import com.shopee.app.d.c.f.k;
import com.shopee.app.d.c.f.m;
import com.shopee.app.d.c.j;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.h.r;
import com.shopee.app.network.d.l;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.ae;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class e extends q<g> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f20405a = b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private final c f20406c;

    /* renamed from: d  reason: collision with root package name */
    private final com.shopee.app.d.c.f.e f20407d;

    /* renamed from: e  reason: collision with root package name */
    private final a f20408e;

    /* renamed from: f  reason: collision with root package name */
    private final m f20409f;

    /* renamed from: g  reason: collision with root package name */
    private final k f20410g;
    private final j h;
    private final g i;
    private final ce j;
    private final ChatBadgeStore k;
    private final ed l;
    private String m = "";
    private int n = 0;
    private int o = 0;
    private boolean p = false;
    private int q;
    private boolean r;

    public e(c cVar, com.shopee.app.d.c.f.e eVar, j jVar, g gVar, k kVar, m mVar, a aVar, ce ceVar, ed edVar, ChatBadgeStore chatBadgeStore) {
        this.f20407d = eVar;
        this.f20410g = kVar;
        this.f20409f = mVar;
        this.i = gVar;
        this.h = jVar;
        this.f20408e = aVar;
        this.f20406c = cVar;
        this.j = ceVar;
        this.l = edVar;
        this.k = chatBadgeStore;
    }

    public void a() {
        this.f20405a.a();
        this.l.a();
    }

    public void c() {
        super.c();
        this.f20405a.c();
    }

    public void d() {
        super.d();
        this.f20405a.d();
    }

    public void b() {
        this.f20405a.b();
    }

    public void a(int i2) {
        this.q = i2;
        i();
        k();
    }

    private void i() {
        int i2 = this.q;
        if (i2 == 0) {
            this.f20410g.a();
            this.f20409f.a(true);
        } else if (i2 == 1) {
            this.i.a(this.n, true);
        }
    }

    private void j() {
        int i2 = this.q;
        if (i2 == 0) {
            this.f20406c.a(this.n);
        } else if (i2 == 1) {
            this.i.a(this.n, true);
        }
    }

    private void k() {
        int i2 = this.q;
        if (i2 == 0) {
            this.f20407d.a(this.n);
        } else if (i2 == 1) {
            this.i.a(this.n, false);
        }
    }

    private void e(List<ChatItem2> list) {
        ArrayList arrayList = new ArrayList(list);
        ((g) this.f19220b).a((List<ChatItem2>) arrayList);
        if (arrayList.size() + 1 == this.o) {
            ((g) this.f19220b).d();
        } else {
            ((g) this.f19220b).e();
        }
    }

    private void f(List<ChatItem2> list) {
        ArrayList arrayList = new ArrayList(list);
        ((g) this.f19220b).a((List<ChatItem2>) arrayList);
        if (arrayList.size() + 1 == this.o) {
            ((g) this.f19220b).d();
        } else {
            ((g) this.f19220b).e();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<ChatItem2> list) {
        if (this.q == 0) {
            e(list);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(List<ChatItem2> list) {
        int i2 = this.q;
        if (i2 != 0 && i2 == 1) {
            f(list);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (i2 <= 0) {
            j();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        k();
        ((g) this.f19220b).c();
    }

    /* access modifiers changed from: package-private */
    public void a(ChatMessage chatMessage) {
        this.r = false;
    }

    /* access modifiers changed from: package-private */
    public void c(List<Object> list) {
        this.r = true;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.r) {
            this.r = false;
            return;
        }
        ((g) this.f19220b).f();
        j();
    }

    /* access modifiers changed from: package-private */
    public void b(ChatMessage chatMessage) {
        ((g) this.f19220b).f();
        j();
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        k();
    }

    /* access modifiers changed from: package-private */
    public void d(List<UserData> list) {
        k();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        k();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        a(this.q);
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        ((g) this.f19220b).c();
        r.a().b((int) R.string.sp_network_error);
    }

    public void d(int i2) {
        this.o = i2;
        this.n++;
        j();
    }

    public void f(int i2) {
        ((g) this.f19220b).b();
        l lVar = new l();
        lVar.h();
        lVar.a(i2);
    }

    public void g(int i2) {
        this.h.a(i2);
    }

    public void h(int i2) {
        this.j.a(i2);
    }
}
