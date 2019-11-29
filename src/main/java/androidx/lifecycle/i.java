package androidx.lifecycle;

import androidx.a.a.b.b;
import androidx.lifecycle.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class i extends e {

    /* renamed from: b  reason: collision with root package name */
    private androidx.a.a.b.a<g, a> f2576b = new androidx.a.a.b.a<>();

    /* renamed from: c  reason: collision with root package name */
    private e.b f2577c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<h> f2578d;

    /* renamed from: e  reason: collision with root package name */
    private int f2579e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2580f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2581g = false;
    private ArrayList<e.b> h = new ArrayList<>();

    public i(h hVar) {
        this.f2578d = new WeakReference<>(hVar);
        this.f2577c = e.b.INITIALIZED;
    }

    @Deprecated
    public void a(e.b bVar) {
        b(bVar);
    }

    public void b(e.b bVar) {
        c(bVar);
    }

    public void a(e.a aVar) {
        c(b(aVar));
    }

    private void c(e.b bVar) {
        if (this.f2577c != bVar) {
            this.f2577c = bVar;
            if (this.f2580f || this.f2579e != 0) {
                this.f2581g = true;
                return;
            }
            this.f2580f = true;
            d();
            this.f2580f = false;
        }
    }

    private boolean b() {
        if (this.f2576b.a() == 0) {
            return true;
        }
        e.b bVar = this.f2576b.d().getValue().f2584a;
        e.b bVar2 = this.f2576b.e().getValue().f2584a;
        if (bVar == bVar2 && this.f2577c == bVar2) {
            return true;
        }
        return false;
    }

    private e.b c(g gVar) {
        Map.Entry<g, a> d2 = this.f2576b.d(gVar);
        e.b bVar = null;
        e.b bVar2 = d2 != null ? d2.getValue().f2584a : null;
        if (!this.h.isEmpty()) {
            ArrayList<e.b> arrayList = this.h;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f2577c, bVar2), bVar);
    }

    public void a(g gVar) {
        a aVar = new a(gVar, this.f2577c == e.b.DESTROYED ? e.b.DESTROYED : e.b.INITIALIZED);
        if (this.f2576b.a(gVar, aVar) == null) {
            h hVar = (h) this.f2578d.get();
            if (hVar != null) {
                boolean z = this.f2579e != 0 || this.f2580f;
                e.b c2 = c(gVar);
                this.f2579e++;
                while (aVar.f2584a.compareTo(c2) < 0 && this.f2576b.c(gVar)) {
                    d(aVar.f2584a);
                    aVar.a(hVar, f(aVar.f2584a));
                    c();
                    c2 = c(gVar);
                }
                if (!z) {
                    d();
                }
                this.f2579e--;
            }
        }
    }

    private void c() {
        ArrayList<e.b> arrayList = this.h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void d(e.b bVar) {
        this.h.add(bVar);
    }

    public void b(g gVar) {
        this.f2576b.b(gVar);
    }

    public e.b a() {
        return this.f2577c;
    }

    static e.b b(e.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return e.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return e.b.STARTED;
            case ON_RESUME:
                return e.b.RESUMED;
            case ON_DESTROY:
                return e.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* renamed from: androidx.lifecycle.i$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2583b = new int[e.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0086 */
        static {
            /*
                androidx.lifecycle.e$b[] r0 = androidx.lifecycle.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2583b = r0
                r0 = 1
                int[] r1 = f2583b     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.lifecycle.e$b r2 = androidx.lifecycle.e.b.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f2583b     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.lifecycle.e$b r3 = androidx.lifecycle.e.b.CREATED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f2583b     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.lifecycle.e$b r4 = androidx.lifecycle.e.b.STARTED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f2583b     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.lifecycle.e$b r5 = androidx.lifecycle.e.b.RESUMED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = f2583b     // Catch:{ NoSuchFieldError -> 0x0040 }
                androidx.lifecycle.e$b r6 = androidx.lifecycle.e.b.DESTROYED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                androidx.lifecycle.e$a[] r5 = androidx.lifecycle.e.a.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f2582a = r5
                int[] r5 = f2582a     // Catch:{ NoSuchFieldError -> 0x0053 }
                androidx.lifecycle.e$a r6 = androidx.lifecycle.e.a.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f2582a     // Catch:{ NoSuchFieldError -> 0x005d }
                androidx.lifecycle.e$a r5 = androidx.lifecycle.e.a.ON_STOP     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = f2582a     // Catch:{ NoSuchFieldError -> 0x0067 }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.e.a.ON_START     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = f2582a     // Catch:{ NoSuchFieldError -> 0x0071 }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.e.a.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f2582a     // Catch:{ NoSuchFieldError -> 0x007b }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.e.a.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f2582a     // Catch:{ NoSuchFieldError -> 0x0086 }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.e.a.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = f2582a     // Catch:{ NoSuchFieldError -> 0x0091 }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.e.a.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.i.AnonymousClass1.<clinit>():void");
        }
    }

    private static e.a e(e.b bVar) {
        int i = AnonymousClass1.f2583b[bVar.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        } else if (i == 2) {
            return e.a.ON_DESTROY;
        } else {
            if (i == 3) {
                return e.a.ON_STOP;
            }
            if (i == 4) {
                return e.a.ON_PAUSE;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
            throw new IllegalArgumentException();
        }
    }

    private static e.a f(e.b bVar) {
        int i = AnonymousClass1.f2583b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return e.a.ON_START;
            }
            if (i == 3) {
                return e.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return e.a.ON_CREATE;
    }

    private void a(h hVar) {
        b<K, V>.d c2 = this.f2576b.c();
        while (c2.hasNext() && !this.f2581g) {
            Map.Entry entry = (Map.Entry) c2.next();
            a aVar = (a) entry.getValue();
            while (aVar.f2584a.compareTo(this.f2577c) < 0 && !this.f2581g && this.f2576b.c(entry.getKey())) {
                d(aVar.f2584a);
                aVar.a(hVar, f(aVar.f2584a));
                c();
            }
        }
    }

    private void b(h hVar) {
        Iterator<Map.Entry<g, a>> b2 = this.f2576b.b();
        while (b2.hasNext() && !this.f2581g) {
            Map.Entry next = b2.next();
            a aVar = (a) next.getValue();
            while (aVar.f2584a.compareTo(this.f2577c) > 0 && !this.f2581g && this.f2576b.c(next.getKey())) {
                e.a e2 = e(aVar.f2584a);
                d(b(e2));
                aVar.a(hVar, e2);
                c();
            }
        }
    }

    private void d() {
        h hVar = (h) this.f2578d.get();
        if (hVar != null) {
            while (!b()) {
                this.f2581g = false;
                if (this.f2577c.compareTo(this.f2576b.d().getValue().f2584a) < 0) {
                    b(hVar);
                }
                Map.Entry<g, a> e2 = this.f2576b.e();
                if (!this.f2581g && e2 != null && this.f2577c.compareTo(e2.getValue().f2584a) > 0) {
                    a(hVar);
                }
            }
            this.f2581g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    static e.b a(e.b bVar, e.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        e.b f2584a;

        /* renamed from: b  reason: collision with root package name */
        f f2585b;

        a(g gVar, e.b bVar) {
            this.f2585b = k.a((Object) gVar);
            this.f2584a = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, e.a aVar) {
            e.b b2 = i.b(aVar);
            this.f2584a = i.a(this.f2584a, b2);
            this.f2585b.onStateChanged(hVar, aVar);
            this.f2584a = b2;
        }
    }
}
