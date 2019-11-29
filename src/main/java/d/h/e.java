package d.h;

import com.shopee.shopeetracker.bimodel.TrackingType;
import d.e.c;
import d.e.d;
import d.j;
import d.m;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class e implements d.g.a<c> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f32695a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f32696b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f32697c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final d.d.a.c<CharSequence, Integer, j<Integer, Integer>> f32698d;

    public e(CharSequence charSequence, int i, int i2, d.d.a.c<? super CharSequence, ? super Integer, j<Integer, Integer>> cVar) {
        d.d.b.j.b(charSequence, TrackingType.INPUT);
        d.d.b.j.b(cVar, "getNextMatch");
        this.f32695a = charSequence;
        this.f32696b = i;
        this.f32697c = i2;
        this.f32698d = cVar;
    }

    public static final class a implements Iterator<c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f32699a;

        /* renamed from: b  reason: collision with root package name */
        private int f32700b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f32701c;

        /* renamed from: d  reason: collision with root package name */
        private int f32702d;

        /* renamed from: e  reason: collision with root package name */
        private c f32703e;

        /* renamed from: f  reason: collision with root package name */
        private int f32704f;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(e eVar) {
            this.f32699a = eVar;
            this.f32701c = d.a(eVar.f32696b, 0, eVar.f32695a.length());
            this.f32702d = this.f32701c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
            if (r6.f32704f < d.h.e.a(r6.f32699a)) goto L_0x0027;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.f32702d
                r1 = 0
                if (r0 >= 0) goto L_0x000e
                r6.f32700b = r1
                r0 = 0
                d.e.c r0 = (d.e.c) r0
                r6.f32703e = r0
                goto L_0x00a4
            L_0x000e:
                d.h.e r0 = r6.f32699a
                int r0 = r0.f32697c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0027
                int r0 = r6.f32704f
                int r0 = r0 + r3
                r6.f32704f = r0
                int r0 = r6.f32704f
                d.h.e r4 = r6.f32699a
                int r4 = r4.f32697c
                if (r0 >= r4) goto L_0x0035
            L_0x0027:
                int r0 = r6.f32702d
                d.h.e r4 = r6.f32699a
                java.lang.CharSequence r4 = r4.f32695a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x004b
            L_0x0035:
                int r0 = r6.f32701c
                d.e.c r1 = new d.e.c
                d.h.e r4 = r6.f32699a
                java.lang.CharSequence r4 = r4.f32695a
                int r4 = d.h.m.d(r4)
                r1.<init>(r0, r4)
                r6.f32703e = r1
                r6.f32702d = r2
                goto L_0x00a2
            L_0x004b:
                d.h.e r0 = r6.f32699a
                d.d.a.c r0 = r0.f32698d
                d.h.e r4 = r6.f32699a
                java.lang.CharSequence r4 = r4.f32695a
                int r5 = r6.f32702d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.a(r4, r5)
                d.j r0 = (d.j) r0
                if (r0 != 0) goto L_0x007b
                int r0 = r6.f32701c
                d.e.c r1 = new d.e.c
                d.h.e r4 = r6.f32699a
                java.lang.CharSequence r4 = r4.f32695a
                int r4 = d.h.m.d(r4)
                r1.<init>(r0, r4)
                r6.f32703e = r1
                r6.f32702d = r2
                goto L_0x00a2
            L_0x007b:
                java.lang.Object r2 = r0.c()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.d()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f32701c
                d.e.c r4 = d.e.d.b(r4, r2)
                r6.f32703e = r4
                int r2 = r2 + r0
                r6.f32701c = r2
                int r2 = r6.f32701c
                if (r0 != 0) goto L_0x009f
                r1 = 1
            L_0x009f:
                int r2 = r2 + r1
                r6.f32702d = r2
            L_0x00a2:
                r6.f32700b = r3
            L_0x00a4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.h.e.a.b():void");
        }

        /* renamed from: a */
        public c next() {
            if (this.f32700b == -1) {
                b();
            }
            if (this.f32700b != 0) {
                c cVar = this.f32703e;
                if (cVar != null) {
                    this.f32703e = null;
                    this.f32700b = -1;
                    return cVar;
                }
                throw new m("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f32700b == -1) {
                b();
            }
            return this.f32700b == 1;
        }
    }

    public Iterator<c> a() {
        return new a(this);
    }
}
