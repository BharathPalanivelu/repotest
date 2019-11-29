package com.airbnb.lottie.a.b;

import com.airbnb.lottie.g.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public abstract class a<K, A> {

    /* renamed from: a  reason: collision with root package name */
    final List<C0069a> f3463a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    protected c<A> f3464b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3465c = false;

    /* renamed from: d  reason: collision with root package name */
    private final List<? extends com.airbnb.lottie.g.a<K>> f3466d;

    /* renamed from: e  reason: collision with root package name */
    private float f3467e = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: f  reason: collision with root package name */
    private com.airbnb.lottie.g.a<K> f3468f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    public interface C0069a {
        void a();
    }

    /* access modifiers changed from: package-private */
    public abstract A a(com.airbnb.lottie.g.a<K> aVar, float f2);

    a(List<? extends com.airbnb.lottie.g.a<K>> list) {
        this.f3466d = list;
    }

    public void a() {
        this.f3465c = true;
    }

    public void a(C0069a aVar) {
        this.f3463a.add(aVar);
    }

    public void a(float f2) {
        if (f2 < i()) {
            f2 = i();
        } else if (f2 > d()) {
            f2 = d();
        }
        if (f2 != this.f3467e) {
            this.f3467e = f2;
            b();
        }
    }

    public void b() {
        for (int i = 0; i < this.f3463a.size(); i++) {
            this.f3463a.get(i).a();
        }
    }

    private com.airbnb.lottie.g.a<K> g() {
        com.airbnb.lottie.g.a<K> aVar = this.f3468f;
        if (aVar != null && aVar.a(this.f3467e)) {
            return this.f3468f;
        }
        List<? extends com.airbnb.lottie.g.a<K>> list = this.f3466d;
        com.airbnb.lottie.g.a<K> aVar2 = (com.airbnb.lottie.g.a) list.get(list.size() - 1);
        if (this.f3467e < aVar2.b()) {
            for (int size = this.f3466d.size() - 1; size >= 0; size--) {
                aVar2 = (com.airbnb.lottie.g.a) this.f3466d.get(size);
                if (aVar2.a(this.f3467e)) {
                    break;
                }
            }
        }
        this.f3468f = aVar2;
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        if (this.f3465c) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        com.airbnb.lottie.g.a g2 = g();
        if (g2.d()) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        return (this.f3467e - g2.b()) / (g2.c() - g2.b());
    }

    private float h() {
        com.airbnb.lottie.g.a g2 = g();
        if (g2.d()) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        return g2.f3736c.getInterpolation(c());
    }

    private float i() {
        return this.f3466d.isEmpty() ? BitmapDescriptorFactory.HUE_RED : ((com.airbnb.lottie.g.a) this.f3466d.get(0)).b();
    }

    /* access modifiers changed from: package-private */
    public float d() {
        if (this.f3466d.isEmpty()) {
            return 1.0f;
        }
        List<? extends com.airbnb.lottie.g.a<K>> list = this.f3466d;
        return ((com.airbnb.lottie.g.a) list.get(list.size() - 1)).c();
    }

    public A e() {
        return a(g(), h());
    }

    public float f() {
        return this.f3467e;
    }

    public void a(c<A> cVar) {
        c<A> cVar2 = this.f3464b;
        if (cVar2 != null) {
            cVar2.a((a<?, ?>) null);
        }
        this.f3464b = cVar;
        if (cVar != null) {
            cVar.a((a<?, ?>) this);
        }
    }
}
