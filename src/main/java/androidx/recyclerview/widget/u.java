package androidx.recyclerview.widget;

import androidx.b.d;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

class u {

    /* renamed from: a  reason: collision with root package name */
    final androidx.b.a<RecyclerView.w, a> f2978a = new androidx.b.a<>();

    /* renamed from: b  reason: collision with root package name */
    final d<RecyclerView.w> f2979b = new d<>();

    interface b {
        void a(RecyclerView.w wVar);

        void a(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    u() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f2978a.clear();
        this.f2979b.c();
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f2978a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f2978a.put(wVar, aVar);
        }
        aVar.f2982b = cVar;
        aVar.f2981a |= 4;
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.w wVar) {
        a aVar = this.f2978a.get(wVar);
        if (aVar == null || (aVar.f2981a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.f.c b(RecyclerView.w wVar) {
        return a(wVar, 4);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.f.c c(RecyclerView.w wVar) {
        return a(wVar, 8);
    }

    private RecyclerView.f.c a(RecyclerView.w wVar, int i) {
        RecyclerView.f.c cVar;
        int a2 = this.f2978a.a((Object) wVar);
        if (a2 < 0) {
            return null;
        }
        a c2 = this.f2978a.c(a2);
        if (c2 == null || (c2.f2981a & i) == 0) {
            return null;
        }
        c2.f2981a &= i ^ -1;
        if (i == 4) {
            cVar = c2.f2982b;
        } else if (i == 8) {
            cVar = c2.f2983c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c2.f2981a & 12) == 0) {
            this.f2978a.d(a2);
            a.a(c2);
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(long j, RecyclerView.w wVar) {
        this.f2979b.b(j, wVar);
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f2978a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f2978a.put(wVar, aVar);
        }
        aVar.f2981a |= 2;
        aVar.f2982b = cVar;
    }

    /* access modifiers changed from: package-private */
    public boolean d(RecyclerView.w wVar) {
        a aVar = this.f2978a.get(wVar);
        return (aVar == null || (aVar.f2981a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.w a(long j) {
        return this.f2979b.a(j);
    }

    /* access modifiers changed from: package-private */
    public void c(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f2978a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f2978a.put(wVar, aVar);
        }
        aVar.f2983c = cVar;
        aVar.f2981a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.w wVar) {
        a aVar = this.f2978a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f2978a.put(wVar, aVar);
        }
        aVar.f2981a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView.w wVar) {
        a aVar = this.f2978a.get(wVar);
        if (aVar != null) {
            aVar.f2981a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.f2978a.size() - 1; size >= 0; size--) {
            RecyclerView.w b2 = this.f2978a.b(size);
            a d2 = this.f2978a.d(size);
            if ((d2.f2981a & 3) == 3) {
                bVar.a(b2);
            } else if ((d2.f2981a & 1) != 0) {
                if (d2.f2982b == null) {
                    bVar.a(b2);
                } else {
                    bVar.a(b2, d2.f2982b, d2.f2983c);
                }
            } else if ((d2.f2981a & 14) == 14) {
                bVar.b(b2, d2.f2982b, d2.f2983c);
            } else if ((d2.f2981a & 12) == 12) {
                bVar.c(b2, d2.f2982b, d2.f2983c);
            } else if ((d2.f2981a & 4) != 0) {
                bVar.a(b2, d2.f2982b, (RecyclerView.f.c) null);
            } else if ((d2.f2981a & 8) != 0) {
                bVar.b(b2, d2.f2982b, d2.f2983c);
            } else {
                int i = d2.f2981a;
            }
            a.a(d2);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(RecyclerView.w wVar) {
        int b2 = this.f2979b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (wVar == this.f2979b.c(b2)) {
                this.f2979b.a(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f2978a.remove(wVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a.b();
    }

    public void h(RecyclerView.w wVar) {
        f(wVar);
    }

    static class a {

        /* renamed from: d  reason: collision with root package name */
        static Pools.a<a> f2980d = new Pools.SimplePool(20);

        /* renamed from: a  reason: collision with root package name */
        int f2981a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.f.c f2982b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.f.c f2983c;

        private a() {
        }

        static a a() {
            a acquire = f2980d.acquire();
            return acquire == null ? new a() : acquire;
        }

        static void a(a aVar) {
            aVar.f2981a = 0;
            aVar.f2982b = null;
            aVar.f2983c = null;
            f2980d.release(aVar);
        }

        static void b() {
            do {
            } while (f2980d.acquire() != null);
        }
    }
}
