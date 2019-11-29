package com.c.a.c.c;

import androidx.core.util.Pools;
import com.c.a.c.a.b;
import com.c.a.c.b.o;
import com.c.a.c.c.n;
import com.c.a.c.h;
import com.c.a.c.j;
import com.c.a.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f5956a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.a<List<Throwable>> f5957b;

    q(List<n<Model, Data>> list, Pools.a<List<Throwable>> aVar) {
        this.f5956a = list;
        this.f5957b = aVar;
    }

    public n.a<Data> a(Model model, int i, int i2, j jVar) {
        int size = this.f5956a.size();
        ArrayList arrayList = new ArrayList(size);
        h hVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = this.f5956a.get(i3);
            if (nVar.a(model)) {
                n.a a2 = nVar.a(model, i, i2, jVar);
                if (a2 != null) {
                    hVar = a2.f5949a;
                    arrayList.add(a2.f5951c);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return new n.a<>(hVar, new a(arrayList, this.f5957b));
        }
        return null;
    }

    public boolean a(Model model) {
        for (n<Model, Data> a2 : this.f5956a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiModelLoader{modelLoaders=");
        List<n<Model, Data>> list = this.f5956a;
        sb.append(Arrays.toString(list.toArray(new n[list.size()])));
        sb.append('}');
        return sb.toString();
    }

    static class a<Data> implements b<Data>, b.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<b<Data>> f5958a;

        /* renamed from: b  reason: collision with root package name */
        private final Pools.a<List<Throwable>> f5959b;

        /* renamed from: c  reason: collision with root package name */
        private int f5960c = 0;

        /* renamed from: d  reason: collision with root package name */
        private g f5961d;

        /* renamed from: e  reason: collision with root package name */
        private b.a<? super Data> f5962e;

        /* renamed from: f  reason: collision with root package name */
        private List<Throwable> f5963f;

        a(List<b<Data>> list, Pools.a<List<Throwable>> aVar) {
            this.f5959b = aVar;
            com.c.a.i.h.a(list);
            this.f5958a = list;
        }

        public void a(g gVar, b.a<? super Data> aVar) {
            this.f5961d = gVar;
            this.f5962e = aVar;
            this.f5963f = this.f5959b.acquire();
            this.f5958a.get(this.f5960c).a(gVar, this);
        }

        public void a() {
            List<Throwable> list = this.f5963f;
            if (list != null) {
                this.f5959b.release(list);
            }
            this.f5963f = null;
            for (b<Data> a2 : this.f5958a) {
                a2.a();
            }
        }

        public void b() {
            for (b<Data> b2 : this.f5958a) {
                b2.b();
            }
        }

        public Class<Data> d() {
            return this.f5958a.get(0).d();
        }

        public com.c.a.c.a c() {
            return this.f5958a.get(0).c();
        }

        public void a(Data data) {
            if (data != null) {
                this.f5962e.a(data);
            } else {
                e();
            }
        }

        public void a(Exception exc) {
            this.f5963f.add(exc);
            e();
        }

        private void e() {
            if (this.f5960c < this.f5958a.size() - 1) {
                this.f5960c++;
                a(this.f5961d, this.f5962e);
                return;
            }
            this.f5962e.a((Exception) new o("Fetch failed", (List<Throwable>) new ArrayList(this.f5963f)));
        }
    }
}
