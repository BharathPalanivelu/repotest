package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.c.b.h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
public class k implements i, l {

    /* renamed from: a  reason: collision with root package name */
    private final Path f3418a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f3419b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f3420c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final String f3421d;

    /* renamed from: e  reason: collision with root package name */
    private final List<l> f3422e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final h f3423f;

    public k(h hVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3421d = hVar.a();
            this.f3423f = hVar;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() == this) {
                break;
            }
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.f3422e.add((l) previous);
                listIterator.remove();
            }
        }
    }

    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < this.f3422e.size(); i++) {
            this.f3422e.get(i).a(list, list2);
        }
    }

    public Path e() {
        this.f3420c.reset();
        int i = AnonymousClass1.f3424a[this.f3423f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            a(Path.Op.UNION);
        } else if (i == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            a(Path.Op.INTERSECT);
        } else if (i == 5) {
            a(Path.Op.XOR);
        }
        return this.f3420c;
    }

    /* renamed from: com.airbnb.lottie.a.a.k$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3424a = new int[h.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.airbnb.lottie.c.b.h$a[] r0 = com.airbnb.lottie.c.b.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3424a = r0
                int[] r0 = f3424a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.Merge     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3424a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.Add     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3424a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.Subtract     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3424a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.Intersect     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f3424a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.ExcludeIntersections     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.k.AnonymousClass1.<clinit>():void");
        }
    }

    public String b() {
        return this.f3421d;
    }

    private void a() {
        for (int i = 0; i < this.f3422e.size(); i++) {
            this.f3420c.addPath(this.f3422e.get(i).e());
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f3419b.reset();
        this.f3418a.reset();
        for (int size = this.f3422e.size() - 1; size >= 1; size--) {
            l lVar = this.f3422e.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                List<l> c2 = cVar.c();
                for (int size2 = c2.size() - 1; size2 >= 0; size2--) {
                    Path e2 = c2.get(size2).e();
                    e2.transform(cVar.d());
                    this.f3419b.addPath(e2);
                }
            } else {
                this.f3419b.addPath(lVar.e());
            }
        }
        l lVar2 = this.f3422e.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            List<l> c3 = cVar2.c();
            for (int i = 0; i < c3.size(); i++) {
                Path e3 = c3.get(i).e();
                e3.transform(cVar2.d());
                this.f3418a.addPath(e3);
            }
        } else {
            this.f3418a.set(lVar2.e());
        }
        this.f3420c.op(this.f3418a, this.f3419b, op);
    }
}
