package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class d {

    /* renamed from: a  reason: collision with root package name */
    final b f2831a;

    /* renamed from: b  reason: collision with root package name */
    final a f2832b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f2833c = new ArrayList();

    interface b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        View b(int i);

        RecyclerView.w b(View view);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    d(b bVar) {
        this.f2831a = bVar;
    }

    private void g(View view) {
        this.f2833c.add(view);
        this.f2831a.c(view);
    }

    private boolean h(View view) {
        if (!this.f2833c.remove(view)) {
            return false;
        }
        this.f2831a.d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f2831a.a();
        } else {
            i2 = f(i);
        }
        this.f2832b.a(i2, z);
        if (z) {
            g(view);
        }
        this.f2831a.a(view, i2);
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.f2831a.a();
        int i2 = i;
        while (i2 < a2) {
            int e2 = i - (i2 - this.f2832b.e(i2));
            if (e2 == 0) {
                while (this.f2832b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e2;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        int a2 = this.f2831a.a(view);
        if (a2 >= 0) {
            if (this.f2832b.d(a2)) {
                h(view);
            }
            this.f2831a.a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        int f2 = f(i);
        View b2 = this.f2831a.b(f2);
        if (b2 != null) {
            if (this.f2832b.d(f2)) {
                h(b2);
            }
            this.f2831a.a(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public View b(int i) {
        return this.f2831a.b(f(i));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f2832b.a();
        for (int size = this.f2833c.size() - 1; size >= 0; size--) {
            this.f2831a.d(this.f2833c.get(size));
            this.f2833c.remove(size);
        }
        this.f2831a.b();
    }

    /* access modifiers changed from: package-private */
    public View c(int i) {
        int size = this.f2833c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f2833c.get(i2);
            RecyclerView.w b2 = this.f2831a.b(view);
            if (b2.getLayoutPosition() == i && !b2.isInvalid() && !b2.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f2831a.a();
        } else {
            i2 = f(i);
        }
        this.f2832b.a(i2, z);
        if (z) {
            g(view);
        }
        this.f2831a.a(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f2831a.a() - this.f2833c.size();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f2831a.a();
    }

    /* access modifiers changed from: package-private */
    public View d(int i) {
        return this.f2831a.b(i);
    }

    /* access modifiers changed from: package-private */
    public void e(int i) {
        int f2 = f(i);
        this.f2832b.d(f2);
        this.f2831a.c(f2);
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        int a2 = this.f2831a.a(view);
        if (a2 != -1 && !this.f2832b.c(a2)) {
            return a2 - this.f2832b.e(a2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.f2833c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        int a2 = this.f2831a.a(view);
        if (a2 >= 0) {
            this.f2832b.a(a2);
            g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        int a2 = this.f2831a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2832b.c(a2)) {
            this.f2832b.b(a2);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f2832b.toString() + ", hidden list:" + this.f2833c.size();
    }

    /* access modifiers changed from: package-private */
    public boolean f(View view) {
        int a2 = this.f2831a.a(view);
        if (a2 == -1) {
            h(view);
            return true;
        } else if (!this.f2832b.c(a2)) {
            return false;
        } else {
            this.f2832b.d(a2);
            h(view);
            this.f2831a.a(a2);
            return true;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f2834a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f2835b;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (i >= 64) {
                b();
                this.f2835b.a(i - 64);
                return;
            }
            this.f2834a |= 1 << i;
        }

        private void b() {
            if (this.f2835b == null) {
                this.f2835b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i) {
            if (i >= 64) {
                a aVar = this.f2835b;
                if (aVar != null) {
                    aVar.b(i - 64);
                    return;
                }
                return;
            }
            this.f2834a &= (1 << i) ^ -1;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i) {
            if (i < 64) {
                return (this.f2834a & (1 << i)) != 0;
            }
            b();
            return this.f2835b.c(i - 64);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2834a = 0;
            a aVar = this.f2835b;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f2835b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2834a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f2834a;
            this.f2834a = ((j2 & (j ^ -1)) << 1) | (j2 & j);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.f2835b != null) {
                b();
                this.f2835b.a(0, z2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f2835b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2834a & j) != 0;
            this.f2834a &= j ^ -1;
            long j2 = j - 1;
            long j3 = this.f2834a;
            this.f2834a = Long.rotateRight(j3 & (j2 ^ -1), 1) | (j3 & j2);
            a aVar = this.f2835b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    a(63);
                }
                this.f2835b.d(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public int e(int i) {
            a aVar = this.f2835b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f2834a);
                }
                return Long.bitCount(this.f2834a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f2834a & ((1 << i) - 1));
            } else {
                return aVar.e(i - 64) + Long.bitCount(this.f2834a);
            }
        }

        public String toString() {
            if (this.f2835b == null) {
                return Long.toBinaryString(this.f2834a);
            }
            return this.f2835b.toString() + "xx" + Long.toBinaryString(this.f2834a);
        }
    }
}
