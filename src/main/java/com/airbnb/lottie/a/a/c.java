package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.b.b;
import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.c.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public class c implements d, l, a.C0069a, f {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f3384a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f3385b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f3386c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3387d;

    /* renamed from: e  reason: collision with root package name */
    private final List<b> f3388e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.f f3389f;

    /* renamed from: g  reason: collision with root package name */
    private List<l> f3390g;
    private o h;

    private static List<b> a(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            b a2 = list.get(i).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    static l a(List<b> list) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof l) {
                return (l) bVar;
            }
        }
        return null;
    }

    public c(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, n nVar) {
        this(fVar, aVar, nVar.a(), a(fVar, aVar, nVar.b()), a(nVar.b()));
    }

    c(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, String str, List<b> list, l lVar) {
        this.f3384a = new Matrix();
        this.f3385b = new Path();
        this.f3386c = new RectF();
        this.f3387d = str;
        this.f3389f = fVar;
        this.f3388e = list;
        if (lVar != null) {
            this.h = lVar.h();
            this.h.a(aVar);
            this.h.a((a.C0069a) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    public void a() {
        this.f3389f.invalidateSelf();
    }

    public String b() {
        return this.f3387d;
    }

    public void a(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f3388e.size());
        arrayList.addAll(list);
        for (int size = this.f3388e.size() - 1; size >= 0; size--) {
            b bVar = this.f3388e.get(size);
            bVar.a(arrayList, this.f3388e.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public List<l> c() {
        if (this.f3390g == null) {
            this.f3390g = new ArrayList();
            for (int i = 0; i < this.f3388e.size(); i++) {
                b bVar = this.f3388e.get(i);
                if (bVar instanceof l) {
                    this.f3390g.add((l) bVar);
                }
            }
        }
        return this.f3390g;
    }

    /* access modifiers changed from: package-private */
    public Matrix d() {
        o oVar = this.h;
        if (oVar != null) {
            return oVar.d();
        }
        this.f3384a.reset();
        return this.f3384a;
    }

    public Path e() {
        this.f3384a.reset();
        o oVar = this.h;
        if (oVar != null) {
            this.f3384a.set(oVar.d());
        }
        this.f3385b.reset();
        for (int size = this.f3388e.size() - 1; size >= 0; size--) {
            b bVar = this.f3388e.get(size);
            if (bVar instanceof l) {
                this.f3385b.addPath(((l) bVar).e(), this.f3384a);
            }
        }
        return this.f3385b;
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f3384a.set(matrix);
        o oVar = this.h;
        if (oVar != null) {
            this.f3384a.preConcat(oVar.d());
            i = (int) ((((((float) this.h.a().e().intValue()) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
        }
        for (int size = this.f3388e.size() - 1; size >= 0; size--) {
            b bVar = this.f3388e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.f3384a, i);
            }
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        this.f3384a.set(matrix);
        o oVar = this.h;
        if (oVar != null) {
            this.f3384a.preConcat(oVar.d());
        }
        this.f3386c.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        for (int size = this.f3388e.size() - 1; size >= 0; size--) {
            b bVar = this.f3388e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.f3386c, this.f3384a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f3386c);
                } else {
                    rectF.set(Math.min(rectF.left, this.f3386c.left), Math.min(rectF.top, this.f3386c.top), Math.max(rectF.right, this.f3386c.right), Math.max(rectF.bottom, this.f3386c.bottom));
                }
            }
        }
    }

    public void a(e eVar, int i, List<e> list, e eVar2) {
        if (eVar.a(b(), i)) {
            if (!"__container".equals(b())) {
                eVar2 = eVar2.a(b());
                if (eVar.c(b(), i)) {
                    list.add(eVar2.a((f) this));
                }
            }
            if (eVar.d(b(), i)) {
                int b2 = i + eVar.b(b(), i);
                for (int i2 = 0; i2 < this.f3388e.size(); i2++) {
                    b bVar = this.f3388e.get(i2);
                    if (bVar instanceof f) {
                        ((f) bVar).a(eVar, b2, list, eVar2);
                    }
                }
            }
        }
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        o oVar = this.h;
        if (oVar != null) {
            oVar.a(t, cVar);
        }
    }
}
