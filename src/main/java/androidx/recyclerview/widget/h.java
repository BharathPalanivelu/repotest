package androidx.recyclerview.widget;

import androidx.core.d.f;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<h> f2907a = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    static Comparator<b> f2908e = new Comparator<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            if ((bVar.f2920d == null) != (bVar2.f2920d == null)) {
                if (bVar.f2920d == null) {
                    return 1;
                }
                return -1;
            } else if (bVar.f2917a == bVar2.f2917a) {
                int i = bVar2.f2918b - bVar.f2918b;
                if (i != 0) {
                    return i;
                }
                int i2 = bVar.f2919c - bVar2.f2919c;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            } else if (bVar.f2917a) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f2909b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    long f2910c;

    /* renamed from: d  reason: collision with root package name */
    long f2911d;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<b> f2912f = new ArrayList<>();

    h() {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2917a;

        /* renamed from: b  reason: collision with root package name */
        public int f2918b;

        /* renamed from: c  reason: collision with root package name */
        public int f2919c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f2920d;

        /* renamed from: e  reason: collision with root package name */
        public int f2921e;

        b() {
        }

        public void a() {
            this.f2917a = false;
            this.f2918b = 0;
            this.f2919c = 0;
            this.f2920d = null;
            this.f2921e = 0;
        }
    }

    static class a implements RecyclerView.i.a {

        /* renamed from: a  reason: collision with root package name */
        int f2913a;

        /* renamed from: b  reason: collision with root package name */
        int f2914b;

        /* renamed from: c  reason: collision with root package name */
        int[] f2915c;

        /* renamed from: d  reason: collision with root package name */
        int f2916d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            this.f2913a = i;
            this.f2914b = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, boolean z) {
            this.f2916d = 0;
            int[] iArr = this.f2915c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.n;
            if (recyclerView.m != null && iVar != null && iVar.s()) {
                if (z) {
                    if (!recyclerView.f2706f.d()) {
                        iVar.a(recyclerView.m.getItemCount(), (RecyclerView.i.a) this);
                    }
                } else if (!recyclerView.v()) {
                    iVar.a(this.f2913a, this.f2914b, recyclerView.D, (RecyclerView.i.a) this);
                }
                if (this.f2916d > iVar.x) {
                    iVar.x = this.f2916d;
                    iVar.y = z;
                    recyclerView.f2705e.b();
                }
            }
        }

        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f2916d * 2;
                int[] iArr = this.f2915c;
                if (iArr == null) {
                    this.f2915c = new int[4];
                    Arrays.fill(this.f2915c, -1);
                } else if (i3 >= iArr.length) {
                    this.f2915c = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.f2915c, 0, iArr.length);
                }
                int[] iArr2 = this.f2915c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.f2916d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.f2915c != null) {
                int i2 = this.f2916d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f2915c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f2915c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2916d = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f2909b.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f2909b.remove(recyclerView);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2910c == 0) {
            this.f2910c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.C.a(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.f2909b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f2909b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.C.a(recyclerView, false);
                i += recyclerView.C.f2916d;
            }
        }
        this.f2912f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f2909b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.C;
                int abs = Math.abs(aVar.f2913a) + Math.abs(aVar.f2914b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.f2916d * 2; i6 += 2) {
                    if (i5 >= this.f2912f.size()) {
                        bVar = new b();
                        this.f2912f.add(bVar);
                    } else {
                        bVar = this.f2912f.get(i5);
                    }
                    int i7 = aVar.f2915c[i6 + 1];
                    bVar.f2917a = i7 <= abs;
                    bVar.f2918b = abs;
                    bVar.f2919c = i7;
                    bVar.f2920d = recyclerView2;
                    bVar.f2921e = aVar.f2915c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f2912f, f2908e);
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int c2 = recyclerView.f2707g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            RecyclerView.w e2 = RecyclerView.e(recyclerView.f2707g.d(i2));
            if (e2.mPosition == i && !e2.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.w a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.p pVar = recyclerView.f2705e;
        try {
            recyclerView.l();
            RecyclerView.w a2 = pVar.a(i, false, j);
            if (a2 != null) {
                if (!a2.isBound() || a2.isInvalid()) {
                    pVar.a(a2, false);
                } else {
                    pVar.a(a2.itemView);
                }
            }
            return a2;
        } finally {
            recyclerView.b(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.x && recyclerView.f2707g.c() != 0) {
                recyclerView.c();
            }
            a aVar = recyclerView.C;
            aVar.a(recyclerView, true);
            if (aVar.f2916d != 0) {
                try {
                    f.a("RV Nested Prefetch");
                    recyclerView.D.a(recyclerView.m);
                    for (int i = 0; i < aVar.f2916d * 2; i += 2) {
                        a(recyclerView, aVar.f2915c[i], j);
                    }
                } finally {
                    f.a();
                }
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.w a2 = a(bVar.f2920d, bVar.f2921e, bVar.f2917a ? Clock.MAX_TIME : j);
        if (a2 != null && a2.mNestedRecyclerView != null && a2.isBound() && !a2.isInvalid()) {
            a((RecyclerView) a2.mNestedRecyclerView.get(), j);
        }
    }

    private void b(long j) {
        int i = 0;
        while (i < this.f2912f.size()) {
            b bVar = this.f2912f.get(i);
            if (bVar.f2920d != null) {
                a(bVar, j);
                bVar.a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        a();
        b(j);
    }

    public void run() {
        try {
            f.a("RV Prefetch");
            if (!this.f2909b.isEmpty()) {
                int size = this.f2909b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f2909b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.f2911d);
                    this.f2910c = 0;
                    f.a();
                }
            }
        } finally {
            this.f2910c = 0;
            f.a();
        }
    }
}
