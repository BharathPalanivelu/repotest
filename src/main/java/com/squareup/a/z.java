package com.squareup.a;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class z {
    private static final long u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    int f30598a;

    /* renamed from: b  reason: collision with root package name */
    long f30599b;

    /* renamed from: c  reason: collision with root package name */
    int f30600c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f30601d;

    /* renamed from: e  reason: collision with root package name */
    public final int f30602e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30603f;

    /* renamed from: g  reason: collision with root package name */
    public final List<ah> f30604g;
    public final int h;
    public final int i;
    public final boolean j;
    public final int k;
    public final boolean l;
    public final boolean m;
    public final float n;
    public final float o;
    public final float p;
    public final boolean q;
    public final boolean r;
    public final Bitmap.Config s;
    public final w.e t;

    private z(Uri uri, int i2, String str, List<ah> list, int i3, int i4, boolean z, boolean z2, int i5, boolean z3, float f2, float f3, float f4, boolean z4, boolean z5, Bitmap.Config config, w.e eVar) {
        this.f30601d = uri;
        this.f30602e = i2;
        this.f30603f = str;
        if (list == null) {
            this.f30604g = null;
        } else {
            this.f30604g = Collections.unmodifiableList(list);
        }
        this.h = i3;
        this.i = i4;
        this.j = z;
        this.l = z2;
        this.k = i5;
        this.m = z3;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.q = z4;
        this.r = z5;
        this.s = config;
        this.t = eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i2 = this.f30602e;
        if (i2 > 0) {
            sb.append(i2);
        } else {
            sb.append(this.f30601d);
        }
        List<ah> list = this.f30604g;
        if (list != null && !list.isEmpty()) {
            for (ah a2 : this.f30604g) {
                sb.append(' ');
                sb.append(a2.a());
            }
        }
        if (this.f30603f != null) {
            sb.append(" stableKey(");
            sb.append(this.f30603f);
            sb.append(')');
        }
        if (this.h > 0) {
            sb.append(" resize(");
            sb.append(this.h);
            sb.append(',');
            sb.append(this.i);
            sb.append(')');
        }
        if (this.j) {
            sb.append(" centerCrop");
        }
        if (this.l) {
            sb.append(" centerInside");
        }
        if (this.n != BitmapDescriptorFactory.HUE_RED) {
            sb.append(" rotation(");
            sb.append(this.n);
            if (this.q) {
                sb.append(" @ ");
                sb.append(this.o);
                sb.append(',');
                sb.append(this.p);
            }
            sb.append(')');
        }
        if (this.r) {
            sb.append(" purgeable");
        }
        if (this.s != null) {
            sb.append(' ');
            sb.append(this.s);
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public String a() {
        long nanoTime = System.nanoTime() - this.f30599b;
        if (nanoTime > u) {
            return b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return "[R" + this.f30598a + ']';
    }

    /* access modifiers changed from: package-private */
    public String c() {
        Uri uri = this.f30601d;
        if (uri != null) {
            return String.valueOf(uri.getPath());
        }
        return Integer.toHexString(this.f30602e);
    }

    public boolean d() {
        return (this.h == 0 && this.i == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return f() || g();
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return d() || this.n != BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f30604g != null;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Uri f30605a;

        /* renamed from: b  reason: collision with root package name */
        private int f30606b;

        /* renamed from: c  reason: collision with root package name */
        private String f30607c;

        /* renamed from: d  reason: collision with root package name */
        private int f30608d;

        /* renamed from: e  reason: collision with root package name */
        private int f30609e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f30610f;

        /* renamed from: g  reason: collision with root package name */
        private int f30611g;
        private boolean h;
        private boolean i;
        private float j;
        private float k;
        private float l;
        private boolean m;
        private boolean n;
        private List<ah> o;
        private Bitmap.Config p;
        private w.e q;

        a(Uri uri, int i2, Bitmap.Config config) {
            this.f30605a = uri;
            this.f30606b = i2;
            this.p = config;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return (this.f30605a == null && this.f30606b == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return (this.f30608d == 0 && this.f30609e == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.q != null;
        }

        public a a(String str) {
            this.f30607c = str;
            return this;
        }

        public a a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i3 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i3 == 0 && i2 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f30608d = i2;
                this.f30609e = i3;
                return this;
            }
        }

        public a a(int i2) {
            if (!this.h) {
                this.f30610f = true;
                this.f30611g = i2;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        public a d() {
            if (!this.f30610f) {
                this.h = true;
                return this;
            }
            throw new IllegalStateException("Center inside can not be used after calling centerCrop");
        }

        public a e() {
            if (this.f30609e == 0 && this.f30608d == 0) {
                throw new IllegalStateException("onlyScaleDown can not be applied without resize");
            }
            this.i = true;
            return this;
        }

        public a a(float f2) {
            this.j = f2;
            return this;
        }

        public a a(Bitmap.Config config) {
            if (config != null) {
                this.p = config;
                return this;
            }
            throw new IllegalArgumentException("config == null");
        }

        public a a(w.e eVar) {
            if (eVar == null) {
                throw new IllegalArgumentException("Priority invalid.");
            } else if (this.q == null) {
                this.q = eVar;
                return this;
            } else {
                throw new IllegalStateException("Priority already set.");
            }
        }

        public a a(ah ahVar) {
            if (ahVar == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (ahVar.a() != null) {
                if (this.o == null) {
                    this.o = new ArrayList(2);
                }
                this.o.add(ahVar);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }

        public z f() {
            if (this.h && this.f30610f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f30610f && this.f30608d == 0 && this.f30609e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (this.h && this.f30608d == 0 && this.f30609e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.q == null) {
                    this.q = w.e.NORMAL;
                }
                z zVar = r2;
                z zVar2 = new z(this.f30605a, this.f30606b, this.f30607c, this.o, this.f30608d, this.f30609e, this.f30610f, this.h, this.f30611g, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q);
                return zVar;
            }
        }
    }
}
