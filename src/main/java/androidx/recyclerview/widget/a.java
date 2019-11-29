package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.List;

class a implements o.a {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<b> f2814a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f2815b;

    /* renamed from: c  reason: collision with root package name */
    final C0062a f2816c;

    /* renamed from: d  reason: collision with root package name */
    Runnable f2817d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f2818e;

    /* renamed from: f  reason: collision with root package name */
    final o f2819f;

    /* renamed from: g  reason: collision with root package name */
    private Pools.a<b> f2820g;
    private int h;

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    interface C0062a {
        RecyclerView.w a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    a(C0062a aVar) {
        this(aVar, false);
    }

    a(C0062a aVar, boolean z) {
        this.f2820g = new Pools.SimplePool(30);
        this.f2814a = new ArrayList<>();
        this.f2815b = new ArrayList<>();
        this.h = 0;
        this.f2816c = aVar;
        this.f2818e = z;
        this.f2819f = new o(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a((List<b>) this.f2814a);
        a((List<b>) this.f2815b);
        this.h = 0;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f2819f.a(this.f2814a);
        int size = this.f2814a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f2814a.get(i);
            int i2 = bVar.f2821a;
            if (i2 == 1) {
                f(bVar);
            } else if (i2 == 2) {
                c(bVar);
            } else if (i2 == 4) {
                d(bVar);
            } else if (i2 == 8) {
                b(bVar);
            }
            Runnable runnable = this.f2817d;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2814a.clear();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int size = this.f2815b.size();
        for (int i = 0; i < size; i++) {
            this.f2816c.b(this.f2815b.get(i));
        }
        a((List<b>) this.f2815b);
        this.h = 0;
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        char c2;
        boolean z;
        boolean z2;
        int i = bVar.f2822b;
        int i2 = bVar.f2822b + bVar.f2824d;
        int i3 = bVar.f2822b;
        int i4 = 0;
        char c3 = 65535;
        while (i3 < i2) {
            if (this.f2816c.a(i3) != null || d(i3)) {
                if (c3 == 0) {
                    e(a(2, i, i4, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    g(a(2, i, i4, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c3 = c2;
        }
        if (i4 != bVar.f2824d) {
            a(bVar);
            bVar = a(2, i, i4, (Object) null);
        }
        if (c3 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void d(b bVar) {
        int i = bVar.f2822b;
        int i2 = bVar.f2822b + bVar.f2824d;
        int i3 = i;
        int i4 = 0;
        char c2 = 65535;
        for (int i5 = bVar.f2822b; i5 < i2; i5++) {
            if (this.f2816c.a(i5) != null || d(i5)) {
                if (c2 == 0) {
                    e(a(4, i3, i4, bVar.f2823c));
                    i3 = i5;
                    i4 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i3, i4, bVar.f2823c));
                    i3 = i5;
                    i4 = 0;
                }
                c2 = 0;
            }
            i4++;
        }
        if (i4 != bVar.f2824d) {
            Object obj = bVar.f2823c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c2 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void e(b bVar) {
        int i;
        if (bVar.f2821a == 1 || bVar.f2821a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d2 = d(bVar.f2822b, bVar.f2821a);
        int i2 = bVar.f2822b;
        int i3 = bVar.f2821a;
        if (i3 == 2) {
            i = 0;
        } else if (i3 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i4 = d2;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f2824d; i7++) {
            int d3 = d(bVar.f2822b + (i * i7), bVar.f2821a);
            int i8 = bVar.f2821a;
            if (i8 == 2 ? d3 == i4 : i8 == 4 && d3 == i4 + 1) {
                i6++;
            } else {
                b a2 = a(bVar.f2821a, i4, i6, bVar.f2823c);
                a(a2, i5);
                a(a2);
                if (bVar.f2821a == 4) {
                    i5 += i6;
                }
                i4 = d3;
                i6 = 1;
            }
        }
        Object obj = bVar.f2823c;
        a(bVar);
        if (i6 > 0) {
            b a3 = a(bVar.f2821a, i4, i6, obj);
            a(a3, i5);
            a(a3);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, int i) {
        this.f2816c.a(bVar);
        int i2 = bVar.f2821a;
        if (i2 == 2) {
            this.f2816c.a(i, bVar.f2824d);
        } else if (i2 == 4) {
            this.f2816c.a(i, bVar.f2824d, bVar.f2823c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int d(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f2815b.size() - 1; size >= 0; size--) {
            b bVar = this.f2815b.get(size);
            if (bVar.f2821a == 8) {
                if (bVar.f2822b < bVar.f2824d) {
                    i4 = bVar.f2822b;
                    i3 = bVar.f2824d;
                } else {
                    i4 = bVar.f2824d;
                    i3 = bVar.f2822b;
                }
                if (i < i4 || i > i3) {
                    if (i < bVar.f2822b) {
                        if (i2 == 1) {
                            bVar.f2822b++;
                            bVar.f2824d++;
                        } else if (i2 == 2) {
                            bVar.f2822b--;
                            bVar.f2824d--;
                        }
                    }
                } else if (i4 == bVar.f2822b) {
                    if (i2 == 1) {
                        bVar.f2824d++;
                    } else if (i2 == 2) {
                        bVar.f2824d--;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bVar.f2822b++;
                    } else if (i2 == 2) {
                        bVar.f2822b--;
                    }
                    i--;
                }
            } else if (bVar.f2822b <= i) {
                if (bVar.f2821a == 1) {
                    i -= bVar.f2824d;
                } else if (bVar.f2821a == 2) {
                    i += bVar.f2824d;
                }
            } else if (i2 == 1) {
                bVar.f2822b++;
            } else if (i2 == 2) {
                bVar.f2822b--;
            }
        }
        for (int size2 = this.f2815b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f2815b.get(size2);
            if (bVar2.f2821a == 8) {
                if (bVar2.f2824d == bVar2.f2822b || bVar2.f2824d < 0) {
                    this.f2815b.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f2824d <= 0) {
                this.f2815b.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private boolean d(int i) {
        int size = this.f2815b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f2815b.get(i2);
            if (bVar.f2821a == 8) {
                if (a(bVar.f2824d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f2821a == 1) {
                int i3 = bVar.f2822b + bVar.f2824d;
                for (int i4 = bVar.f2822b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.f2815b.add(bVar);
        int i = bVar.f2821a;
        if (i == 1) {
            this.f2816c.c(bVar.f2822b, bVar.f2824d);
        } else if (i == 2) {
            this.f2816c.b(bVar.f2822b, bVar.f2824d);
        } else if (i == 4) {
            this.f2816c.a(bVar.f2822b, bVar.f2824d, bVar.f2823c);
        } else if (i == 8) {
            this.f2816c.d(bVar.f2822b, bVar.f2824d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f2814a.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i) {
        return (i & this.h) != 0;
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        return a(i, 0);
    }

    /* access modifiers changed from: package-private */
    public int a(int i, int i2) {
        int size = this.f2815b.size();
        while (i2 < size) {
            b bVar = this.f2815b.get(i2);
            if (bVar.f2821a == 8) {
                if (bVar.f2822b == i) {
                    i = bVar.f2824d;
                } else {
                    if (bVar.f2822b < i) {
                        i--;
                    }
                    if (bVar.f2824d <= i) {
                        i++;
                    }
                }
            } else if (bVar.f2822b > i) {
                continue;
            } else if (bVar.f2821a == 2) {
                if (i < bVar.f2822b + bVar.f2824d) {
                    return -1;
                }
                i -= bVar.f2824d;
            } else if (bVar.f2821a == 1) {
                i += bVar.f2824d;
            }
            i2++;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f2814a.add(a(4, i, i2, obj));
        this.h |= 4;
        if (this.f2814a.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2814a.add(a(1, i, i2, (Object) null));
        this.h |= 1;
        if (this.f2814a.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2814a.add(a(2, i, i2, (Object) null));
        this.h |= 2;
        if (this.f2814a.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f2814a.add(a(8, i, i2, (Object) null));
            this.h |= 8;
            if (this.f2814a.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        c();
        int size = this.f2814a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f2814a.get(i);
            int i2 = bVar.f2821a;
            if (i2 == 1) {
                this.f2816c.b(bVar);
                this.f2816c.c(bVar.f2822b, bVar.f2824d);
            } else if (i2 == 2) {
                this.f2816c.b(bVar);
                this.f2816c.a(bVar.f2822b, bVar.f2824d);
            } else if (i2 == 4) {
                this.f2816c.b(bVar);
                this.f2816c.a(bVar.f2822b, bVar.f2824d, bVar.f2823c);
            } else if (i2 == 8) {
                this.f2816c.b(bVar);
                this.f2816c.d(bVar.f2822b, bVar.f2824d);
            }
            Runnable runnable = this.f2817d;
            if (runnable != null) {
                runnable.run();
            }
        }
        a((List<b>) this.f2814a);
        this.h = 0;
    }

    public int c(int i) {
        int size = this.f2814a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f2814a.get(i2);
            int i3 = bVar.f2821a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (bVar.f2822b == i) {
                            i = bVar.f2824d;
                        } else {
                            if (bVar.f2822b < i) {
                                i--;
                            }
                            if (bVar.f2824d <= i) {
                                i++;
                            }
                        }
                    }
                } else if (bVar.f2822b > i) {
                    continue;
                } else if (bVar.f2822b + bVar.f2824d > i) {
                    return -1;
                } else {
                    i -= bVar.f2824d;
                }
            } else if (bVar.f2822b <= i) {
                i += bVar.f2824d;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return !this.f2815b.isEmpty() && !this.f2814a.isEmpty();
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f2821a;

        /* renamed from: b  reason: collision with root package name */
        int f2822b;

        /* renamed from: c  reason: collision with root package name */
        Object f2823c;

        /* renamed from: d  reason: collision with root package name */
        int f2824d;

        b(int i, int i2, int i3, Object obj) {
            this.f2821a = i;
            this.f2822b = i2;
            this.f2824d = i3;
            this.f2823c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i = this.f2821a;
            if (i == 1) {
                return ProductAction.ACTION_ADD;
            }
            if (i == 2) {
                return "rm";
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return "up";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f2822b + "c:" + this.f2824d + ",p:" + this.f2823c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f2821a;
            if (i != bVar.f2821a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f2824d - this.f2822b) == 1 && this.f2824d == bVar.f2822b && this.f2822b == bVar.f2824d) {
                return true;
            }
            if (this.f2824d != bVar.f2824d || this.f2822b != bVar.f2822b) {
                return false;
            }
            Object obj2 = this.f2823c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f2823c)) {
                    return false;
                }
            } else if (bVar.f2823c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f2821a * 31) + this.f2822b) * 31) + this.f2824d;
        }
    }

    public b a(int i, int i2, int i3, Object obj) {
        b acquire = this.f2820g.acquire();
        if (acquire == null) {
            return new b(i, i2, i3, obj);
        }
        acquire.f2821a = i;
        acquire.f2822b = i2;
        acquire.f2824d = i3;
        acquire.f2823c = obj;
        return acquire;
    }

    public void a(b bVar) {
        if (!this.f2818e) {
            bVar.f2823c = null;
            this.f2820g.release(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }
}
