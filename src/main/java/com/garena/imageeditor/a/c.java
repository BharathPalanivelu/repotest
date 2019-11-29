package com.garena.imageeditor.a;

import android.util.Pair;
import java.util.LinkedHashMap;
import jp.co.cyberagent.android.gpuimage.e;
import jp.co.cyberagent.android.gpuimage.f;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashMap<d, b> f8077a = new LinkedHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Pair<d, b> f8078b;

    /* renamed from: c  reason: collision with root package name */
    private b f8079c;

    /* renamed from: d  reason: collision with root package name */
    private b f8080d;

    /* renamed from: com.garena.imageeditor.a.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8081a = new int[d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.garena.imageeditor.a.d[] r0 = com.garena.imageeditor.a.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8081a = r0
                int[] r0 = f8081a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.garena.imageeditor.a.d r1 = com.garena.imageeditor.a.d.FOCUS_BLUR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8081a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.garena.imageeditor.a.d r1 = com.garena.imageeditor.a.d.CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.imageeditor.a.c.AnonymousClass1.<clinit>():void");
        }
    }

    public void a(b bVar) {
        d g2 = bVar.g();
        int i = AnonymousClass1.f8081a[g2.ordinal()];
        if (i == 1) {
            this.f8079c = bVar;
        } else if (i != 2) {
            this.f8077a.put(g2, bVar);
        } else {
            this.f8080d = bVar;
        }
    }

    public b a(d dVar) {
        int i = AnonymousClass1.f8081a[dVar.ordinal()];
        if (i == 1) {
            return this.f8079c;
        }
        if (i != 2) {
            return this.f8077a.get(dVar);
        }
        return this.f8080d;
    }

    public e a() {
        f fVar = new f();
        int i = 0;
        for (b f2 : this.f8077a.values()) {
            fVar.a(f2.f());
            i++;
        }
        b bVar = this.f8079c;
        if (bVar != null) {
            fVar.a(bVar.f());
            i++;
        }
        return i == 0 ? new e() : fVar;
    }

    public void b(b bVar) {
        if (bVar == null) {
            this.f8078b = null;
        } else if (!this.f8077a.containsKey(bVar.g())) {
            this.f8078b = new Pair<>(bVar.g(), bVar);
        }
    }

    public e b() {
        f fVar = new f();
        int i = 0;
        for (b e2 : this.f8077a.values()) {
            fVar.a(e2.e());
            i++;
        }
        Pair<d, b> pair = this.f8078b;
        if (!(pair == null || pair.first == d.FOCUS_BLUR || this.f8078b.first == d.CROP)) {
            fVar.a(((b) this.f8078b.second).e());
            i++;
        }
        return i == 0 ? new e() : fVar;
    }

    public void b(d dVar) {
        int i = AnonymousClass1.f8081a[dVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.f8080d = null;
            }
            this.f8077a.remove(dVar);
            return;
        }
        this.f8079c = null;
    }
}
