package com.garena.f;

import com.garena.f.a.c;
import com.garena.f.a.h;
import com.garena.h.b;
import com.garena.h.c;
import com.garena.h.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private c f7968a;

    /* renamed from: b  reason: collision with root package name */
    private List<c> f7969b;

    /* renamed from: c  reason: collision with root package name */
    private List<e> f7970c;

    /* renamed from: d  reason: collision with root package name */
    private h f7971d;

    /* renamed from: e  reason: collision with root package name */
    private com.garena.h.c f7972e;

    /* renamed from: f  reason: collision with root package name */
    private ScheduledExecutorService f7973f;

    private d(a aVar) {
        this.f7973f = Executors.newSingleThreadScheduledExecutor();
        this.f7969b = aVar.f7977d;
        this.f7970c = aVar.f7978e;
        this.f7971d = new h(this, aVar.f7974a, this.f7973f);
        this.f7968a = new c(this.f7973f, aVar.f7978e, aVar.f7976c, this.f7971d);
        this.f7972e = new c.a().a((com.garena.h.d) aVar.f7974a).a(aVar.f7975b).a((b) this.f7968a).a();
    }

    public boolean a() {
        return this.f7972e.a();
    }

    public boolean b() {
        return this.f7972e.b() || this.f7971d.a();
    }

    public void c() {
        this.f7972e.c();
        this.f7971d.a(false);
    }

    public void d() {
        this.f7972e.d();
        this.f7971d.a(true);
        this.f7968a.a(com.garena.h.a.d.UNKNOWN, false);
    }

    public h a(i iVar) {
        return new com.garena.f.a.b(this.f7972e, iVar, this.f7968a, this.f7973f, this.f7969b);
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public b f7974a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public f f7975b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public List<a> f7976c = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public List<c> f7977d = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public List<e> f7978e = new ArrayList();

        public a a(b bVar) {
            this.f7974a = bVar;
            this.f7976c.add(bVar);
            return this;
        }

        public a a(f fVar) {
            this.f7975b = fVar;
            return this;
        }

        public a a(e eVar) {
            this.f7978e.add(eVar);
            return this;
        }

        public d a() {
            return new d(this);
        }
    }
}
