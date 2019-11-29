package androidx.j.a;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.j.a.b;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import com.tencent.imsdk.TIMGroupManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

final class a {

    /* renamed from: g  reason: collision with root package name */
    private static final Comparator<C0057a> f2364g = new Comparator<C0057a>() {
        /* renamed from: a */
        public int compare(C0057a aVar, C0057a aVar2) {
            return aVar2.a() - aVar.a();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int[] f2365a;

    /* renamed from: b  reason: collision with root package name */
    final int[] f2366b;

    /* renamed from: c  reason: collision with root package name */
    final List<b.c> f2367c;

    /* renamed from: d  reason: collision with root package name */
    final TimingLogger f2368d = null;

    /* renamed from: e  reason: collision with root package name */
    final b.C0058b[] f2369e;

    /* renamed from: f  reason: collision with root package name */
    private final float[] f2370f = new float[3];

    static int a(int i) {
        return (i >> 10) & 31;
    }

    static int b(int i) {
        return (i >> 5) & 31;
    }

    private static int b(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    static int c(int i) {
        return i & 31;
    }

    a(int[] iArr, int i, b.C0058b[] bVarArr) {
        this.f2369e = bVarArr;
        int[] iArr2 = new int[TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG];
        this.f2366b = iArr2;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int f2 = f(iArr[i2]);
            iArr[i2] = f2;
            iArr2[f2] = iArr2[f2] + 1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            if (iArr2[i4] > 0 && e(i4)) {
                iArr2[i4] = 0;
            }
            if (iArr2[i4] > 0) {
                i3++;
            }
        }
        int[] iArr3 = new int[i3];
        this.f2365a = iArr3;
        int i5 = 0;
        for (int i6 = 0; i6 < iArr2.length; i6++) {
            if (iArr2[i6] > 0) {
                iArr3[i5] = i6;
                i5++;
            }
        }
        if (i3 <= i) {
            this.f2367c = new ArrayList();
            for (int i7 : iArr3) {
                this.f2367c.add(new b.c(g(i7), iArr2[i7]));
            }
            return;
        }
        this.f2367c = d(i);
    }

    /* access modifiers changed from: package-private */
    public List<b.c> a() {
        return this.f2367c;
    }

    private List<b.c> d(int i) {
        PriorityQueue priorityQueue = new PriorityQueue(i, f2364g);
        priorityQueue.offer(new C0057a(0, this.f2365a.length - 1));
        a((PriorityQueue<C0057a>) priorityQueue, i);
        return a((Collection<C0057a>) priorityQueue);
    }

    private void a(PriorityQueue<C0057a> priorityQueue, int i) {
        while (priorityQueue.size() < i) {
            C0057a poll = priorityQueue.poll();
            if (poll != null && poll.b()) {
                priorityQueue.offer(poll.e());
                priorityQueue.offer(poll);
            } else {
                return;
            }
        }
    }

    private List<b.c> a(Collection<C0057a> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (C0057a h : collection) {
            b.c h2 = h.h();
            if (!a(h2)) {
                arrayList.add(h2);
            }
        }
        return arrayList;
    }

    /* renamed from: androidx.j.a.a$a  reason: collision with other inner class name */
    private class C0057a {

        /* renamed from: b  reason: collision with root package name */
        private int f2372b;

        /* renamed from: c  reason: collision with root package name */
        private int f2373c;

        /* renamed from: d  reason: collision with root package name */
        private int f2374d;

        /* renamed from: e  reason: collision with root package name */
        private int f2375e;

        /* renamed from: f  reason: collision with root package name */
        private int f2376f;

        /* renamed from: g  reason: collision with root package name */
        private int f2377g;
        private int h;
        private int i;
        private int j;

        C0057a(int i2, int i3) {
            this.f2372b = i2;
            this.f2373c = i3;
            d();
        }

        /* access modifiers changed from: package-private */
        public final int a() {
            return ((this.f2376f - this.f2375e) + 1) * ((this.h - this.f2377g) + 1) * ((this.j - this.i) + 1);
        }

        /* access modifiers changed from: package-private */
        public final boolean b() {
            return c() > 1;
        }

        /* access modifiers changed from: package-private */
        public final int c() {
            return (this.f2373c + 1) - this.f2372b;
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            int[] iArr = a.this.f2365a;
            int[] iArr2 = a.this.f2366b;
            int i2 = Integer.MAX_VALUE;
            int i3 = RNCartPanelDataEntity.NULL_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = RNCartPanelDataEntity.NULL_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = RNCartPanelDataEntity.NULL_VALUE;
            int i8 = 0;
            for (int i9 = this.f2372b; i9 <= this.f2373c; i9++) {
                int i10 = iArr[i9];
                i8 += iArr2[i10];
                int a2 = a.a(i10);
                int b2 = a.b(i10);
                int c2 = a.c(i10);
                if (a2 > i3) {
                    i3 = a2;
                }
                if (a2 < i2) {
                    i2 = a2;
                }
                if (b2 > i5) {
                    i5 = b2;
                }
                if (b2 < i4) {
                    i4 = b2;
                }
                if (c2 > i7) {
                    i7 = c2;
                }
                if (c2 < i6) {
                    i6 = c2;
                }
            }
            this.f2375e = i2;
            this.f2376f = i3;
            this.f2377g = i4;
            this.h = i5;
            this.i = i6;
            this.j = i7;
            this.f2374d = i8;
        }

        /* access modifiers changed from: package-private */
        public final C0057a e() {
            if (b()) {
                int g2 = g();
                C0057a aVar = new C0057a(g2 + 1, this.f2373c);
                this.f2373c = g2;
                d();
                return aVar;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }

        /* access modifiers changed from: package-private */
        public final int f() {
            int i2 = this.f2376f - this.f2375e;
            int i3 = this.h - this.f2377g;
            int i4 = this.j - this.i;
            if (i2 < i3 || i2 < i4) {
                return (i3 < i2 || i3 < i4) ? -1 : -2;
            }
            return -3;
        }

        /* access modifiers changed from: package-private */
        public final int g() {
            int f2 = f();
            int[] iArr = a.this.f2365a;
            int[] iArr2 = a.this.f2366b;
            a.a(iArr, f2, this.f2372b, this.f2373c);
            Arrays.sort(iArr, this.f2372b, this.f2373c + 1);
            a.a(iArr, f2, this.f2372b, this.f2373c);
            int i2 = this.f2374d / 2;
            int i3 = this.f2372b;
            int i4 = 0;
            while (true) {
                int i5 = this.f2373c;
                if (i3 > i5) {
                    return this.f2372b;
                }
                i4 += iArr2[iArr[i3]];
                if (i4 >= i2) {
                    return Math.min(i5 - 1, i3);
                }
                i3++;
            }
        }

        /* access modifiers changed from: package-private */
        public final b.c h() {
            int[] iArr = a.this.f2365a;
            int[] iArr2 = a.this.f2366b;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = this.f2372b; i6 <= this.f2373c; i6++) {
                int i7 = iArr[i6];
                int i8 = iArr2[i7];
                i3 += i8;
                i2 += a.a(i7) * i8;
                i4 += a.b(i7) * i8;
                i5 += i8 * a.c(i7);
            }
            float f2 = (float) i3;
            return new b.c(a.a(Math.round(((float) i2) / f2), Math.round(((float) i4) / f2), Math.round(((float) i5) / f2)), i3);
        }
    }

    static void a(int[] iArr, int i, int i2, int i3) {
        if (i == -3) {
            return;
        }
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = c(i4) | (b(i4) << 10) | (a(i4) << 5);
                i2++;
            }
        } else if (i == -1) {
            while (i2 <= i3) {
                int i5 = iArr[i2];
                iArr[i2] = a(i5) | (c(i5) << 10) | (b(i5) << 5);
                i2++;
            }
        }
    }

    private boolean e(int i) {
        int g2 = g(i);
        androidx.core.graphics.a.a(g2, this.f2370f);
        return a(g2, this.f2370f);
    }

    private boolean a(b.c cVar) {
        return a(cVar.a(), cVar.b());
    }

    private boolean a(int i, float[] fArr) {
        b.C0058b[] bVarArr = this.f2369e;
        if (bVarArr != null && bVarArr.length > 0) {
            int length = bVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!this.f2369e[i2].a(i, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int f(int i) {
        return b(Color.blue(i), 8, 5) | (b(Color.red(i), 8, 5) << 10) | (b(Color.green(i), 8, 5) << 5);
    }

    static int a(int i, int i2, int i3) {
        return Color.rgb(b(i, 5, 8), b(i2, 5, 8), b(i3, 5, 8));
    }

    private static int g(int i) {
        return a(a(i), b(i), c(i));
    }
}
