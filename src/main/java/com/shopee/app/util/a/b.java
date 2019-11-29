package com.shopee.app.util.a;

import android.os.Handler;
import android.os.Looper;
import d.d.b.j;
import d.d.b.k;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;
import java.util.ArrayList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ e[] f26123a = {p.a((m) new n(p.a(b.class), "taskList", "getTaskList()Ljava/util/ArrayList;"))};

    /* renamed from: b  reason: collision with root package name */
    private boolean f26124b;

    /* renamed from: c  reason: collision with root package name */
    private final d.e f26125c = f.a(a.f26127a);

    /* renamed from: d  reason: collision with root package name */
    private final Handler f26126d = new Handler(Looper.getMainLooper());

    private final ArrayList<a> c() {
        d.e eVar = this.f26125c;
        e eVar2 = f26123a[0];
        return (ArrayList) eVar.a();
    }

    static final class a extends k implements d.d.a.a<ArrayList<a>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f26127a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final ArrayList<a> invoke() {
            return new ArrayList<>();
        }
    }

    public final void a() {
        this.f26124b = true;
        d();
    }

    public final void b() {
        this.f26124b = false;
    }

    public final void a(a aVar) {
        j.b(aVar, "task");
        c().add(aVar);
        if (this.f26124b) {
            d();
        }
    }

    private final void d() {
        for (a post : c()) {
            this.f26126d.post(post);
        }
        c().clear();
    }
}
