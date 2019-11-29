package com.bca.xco.widget.d.a.a.g;

import com.appsflyer.share.Constants;
import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.b.d;
import com.bca.xco.widget.d.b.g;
import com.bca.xco.widget.d.b.h;
import com.bca.xco.widget.d.b.m;
import com.facebook.places.model.PlaceFields;
import com.tencent.imsdk.TIMGroupManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final d[] f4917a = {new d(d.f4914e, ""), new d(d.f4911b, "GET"), new d(d.f4911b, "POST"), new d(d.f4912c, (String) Constants.URL_PATH_DELIMITER), new d(d.f4912c, "/index.html"), new d(d.f4913d, "http"), new d(d.f4913d, "https"), new d(d.f4910a, "200"), new d(d.f4910a, "204"), new d(d.f4910a, "206"), new d(d.f4910a, "304"), new d(d.f4910a, "400"), new d(d.f4910a, "404"), new d(d.f4910a, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d("host", ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d((String) PlaceFields.LOCATION, ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<h, Integer> f4918b = c();

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        d[] f4919a;

        /* renamed from: b  reason: collision with root package name */
        int f4920b;

        /* renamed from: c  reason: collision with root package name */
        int f4921c;

        /* renamed from: d  reason: collision with root package name */
        int f4922d;

        /* renamed from: e  reason: collision with root package name */
        private final List<d> f4923e;

        /* renamed from: f  reason: collision with root package name */
        private final com.bca.xco.widget.d.b.b f4924f;

        /* renamed from: g  reason: collision with root package name */
        private final int f4925g;
        private int h;

        a(int i, d dVar) {
            this(i, i, dVar);
        }

        a(int i, int i2, d dVar) {
            this.f4923e = new ArrayList();
            this.f4919a = new d[8];
            this.f4920b = this.f4919a.length - 1;
            this.f4921c = 0;
            this.f4922d = 0;
            this.f4925g = i;
            this.h = i2;
            this.f4924f = m.a(dVar);
        }

        private void d() {
            int i = this.h;
            int i2 = this.f4922d;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                e();
            } else {
                a(i2 - i);
            }
        }

        private void e() {
            this.f4923e.clear();
            Arrays.fill(this.f4919a, (Object) null);
            this.f4920b = this.f4919a.length - 1;
            this.f4921c = 0;
            this.f4922d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f4919a.length;
                while (true) {
                    length--;
                    if (length < this.f4920b || i <= 0) {
                        d[] dVarArr = this.f4919a;
                        int i3 = this.f4920b;
                        System.arraycopy(dVarArr, i3 + 1, dVarArr, i3 + 1 + i2, this.f4921c);
                        this.f4920b += i2;
                    } else {
                        i -= this.f4919a[length].h;
                        this.f4922d -= this.f4919a[length].h;
                        this.f4921c--;
                        i2++;
                    }
                }
                d[] dVarArr2 = this.f4919a;
                int i32 = this.f4920b;
                System.arraycopy(dVarArr2, i32 + 1, dVarArr2, i32 + 1 + i2, this.f4921c);
                this.f4920b += i2;
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            while (!this.f4924f.d()) {
                byte e2 = this.f4924f.e() & 255;
                if (e2 == 128) {
                    throw new IOException("index == 0");
                } else if ((e2 & 128) == 128) {
                    b(a((int) e2, 127) - 1);
                } else if (e2 == 64) {
                    g();
                } else if ((e2 & 64) == 64) {
                    e(a((int) e2, 63) - 1);
                } else if ((e2 & 32) == 32) {
                    this.h = a((int) e2, 31);
                    int i = this.h;
                    if (i < 0 || i > this.f4925g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (e2 == 16 || e2 == 0) {
                    f();
                } else {
                    d(a((int) e2, 15) - 1);
                }
            }
        }

        public List<d> b() {
            ArrayList arrayList = new ArrayList(this.f4923e);
            this.f4923e.clear();
            return arrayList;
        }

        private void b(int i) {
            if (g(i)) {
                this.f4923e.add(e.f4917a[i]);
                return;
            }
            int c2 = c(i - e.f4917a.length);
            if (c2 >= 0) {
                d[] dVarArr = this.f4919a;
                if (c2 <= dVarArr.length - 1) {
                    this.f4923e.add(dVarArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int c(int i) {
            return this.f4920b + 1 + i;
        }

        private void d(int i) {
            this.f4923e.add(new d(f(i), c()));
        }

        private void f() {
            this.f4923e.add(new d(e.b(c()), c()));
        }

        private void e(int i) {
            a(-1, new d(f(i), c()));
        }

        private void g() {
            a(-1, new d(e.b(c()), c()));
        }

        private h f(int i) {
            if (g(i)) {
                return e.f4917a[i].f4915f;
            }
            return this.f4919a[c(i - e.f4917a.length)].f4915f;
        }

        private boolean g(int i) {
            return i >= 0 && i <= e.f4917a.length - 1;
        }

        private void a(int i, d dVar) {
            this.f4923e.add(dVar);
            int i2 = dVar.h;
            if (i != -1) {
                i2 -= this.f4919a[c(i)].h;
            }
            int i3 = this.h;
            if (i2 > i3) {
                e();
                return;
            }
            int a2 = a((this.f4922d + i2) - i3);
            if (i == -1) {
                int i4 = this.f4921c + 1;
                d[] dVarArr = this.f4919a;
                if (i4 > dVarArr.length) {
                    d[] dVarArr2 = new d[(dVarArr.length * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f4920b = this.f4919a.length - 1;
                    this.f4919a = dVarArr2;
                }
                int i5 = this.f4920b;
                this.f4920b = i5 - 1;
                this.f4919a[i5] = dVar;
                this.f4921c++;
            } else {
                this.f4919a[i + c(i) + a2] = dVar;
            }
            this.f4922d += i2;
        }

        private int h() {
            return this.f4924f.e() & 255;
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int h2 = h();
                if ((h2 & 128) == 0) {
                    return i2 + (h2 << i4);
                }
                i2 += (h2 & 127) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: package-private */
        public h c() {
            int h2 = h();
            boolean z = (h2 & 128) == 128;
            int a2 = a(h2, 127);
            if (z) {
                return h.a(k.a().a(this.f4924f.f((long) a2)));
            }
            return this.f4924f.e((long) a2);
        }
    }

    private static Map<h, Integer> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f4917a.length);
        int i = 0;
        while (true) {
            d[] dVarArr = f4917a;
            if (i >= dVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(dVarArr[i].f4915f)) {
                linkedHashMap.put(f4917a[i].f4915f, Integer.valueOf(i));
            }
            i++;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f4926a;

        /* renamed from: b  reason: collision with root package name */
        int f4927b;

        /* renamed from: c  reason: collision with root package name */
        d[] f4928c;

        /* renamed from: d  reason: collision with root package name */
        int f4929d;

        /* renamed from: e  reason: collision with root package name */
        int f4930e;

        /* renamed from: f  reason: collision with root package name */
        int f4931f;

        /* renamed from: g  reason: collision with root package name */
        private final g f4932g;
        private final boolean h;
        private int i;
        private boolean j;

        b(g gVar) {
            this(4096, true, gVar);
        }

        b(int i2, boolean z, g gVar) {
            this.i = Integer.MAX_VALUE;
            this.f4928c = new d[8];
            this.f4929d = this.f4928c.length - 1;
            this.f4930e = 0;
            this.f4931f = 0;
            this.f4926a = i2;
            this.f4927b = i2;
            this.h = z;
            this.f4932g = gVar;
        }

        private void a() {
            Arrays.fill(this.f4928c, (Object) null);
            this.f4929d = this.f4928c.length - 1;
            this.f4930e = 0;
            this.f4931f = 0;
        }

        private int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f4928c.length;
                while (true) {
                    length--;
                    if (length < this.f4929d || i2 <= 0) {
                        d[] dVarArr = this.f4928c;
                        int i4 = this.f4929d;
                        System.arraycopy(dVarArr, i4 + 1, dVarArr, i4 + 1 + i3, this.f4930e);
                        d[] dVarArr2 = this.f4928c;
                        int i5 = this.f4929d;
                        Arrays.fill(dVarArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                        this.f4929d += i3;
                    } else {
                        i2 -= this.f4928c[length].h;
                        this.f4931f -= this.f4928c[length].h;
                        this.f4930e--;
                        i3++;
                    }
                }
                d[] dVarArr3 = this.f4928c;
                int i42 = this.f4929d;
                System.arraycopy(dVarArr3, i42 + 1, dVarArr3, i42 + 1 + i3, this.f4930e);
                d[] dVarArr22 = this.f4928c;
                int i52 = this.f4929d;
                Arrays.fill(dVarArr22, i52 + 1, i52 + 1 + i3, (Object) null);
                this.f4929d += i3;
            }
            return i3;
        }

        private void a(d dVar) {
            int i2 = dVar.h;
            int i3 = this.f4927b;
            if (i2 > i3) {
                a();
                return;
            }
            b((this.f4931f + i2) - i3);
            int i4 = this.f4930e + 1;
            d[] dVarArr = this.f4928c;
            if (i4 > dVarArr.length) {
                d[] dVarArr2 = new d[(dVarArr.length * 2)];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f4929d = this.f4928c.length - 1;
                this.f4928c = dVarArr2;
            }
            int i5 = this.f4929d;
            this.f4929d = i5 - 1;
            this.f4928c[i5] = dVar;
            this.f4930e++;
            this.f4931f += i2;
        }

        /* access modifiers changed from: package-private */
        public void a(List<d> list) {
            if (this.j) {
                int i2 = this.i;
                if (i2 < this.f4927b) {
                    a(i2, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                a(this.f4927b, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                d dVar = list.get(i3);
                h d2 = dVar.f4915f.d();
                h hVar = dVar.f4916g;
                Integer num = (Integer) e.f4918b.get(d2);
                if (num != null) {
                    a(num.intValue() + 1, 15, 0);
                    a(hVar);
                } else {
                    int a2 = c.a((T[]) this.f4928c, dVar);
                    if (a2 != -1) {
                        a((a2 - this.f4929d) + e.f4917a.length, 127, 128);
                    } else {
                        this.f4932g.a(64);
                        a(d2);
                        a(hVar);
                        a(dVar);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.f4932g.a(i2 | i4);
                return;
            }
            this.f4932g.a(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.f4932g.a(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.f4932g.a(i5);
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar) {
            if (!this.h || k.a().a(hVar) >= hVar.e()) {
                a(hVar.e(), 127, 0);
                this.f4932g.a(hVar);
                return;
            }
            g gVar = new g();
            k.a().a(hVar, gVar);
            h p = gVar.p();
            a(p.e(), 127, 128);
            this.f4932g.a(p);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f4926a = i2;
            int min = Math.min(i2, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
            int i3 = this.f4927b;
            if (i3 != min) {
                if (min < i3) {
                    this.i = Math.min(this.i, min);
                }
                this.j = true;
                this.f4927b = min;
                b();
            }
        }

        private void b() {
            int i2 = this.f4927b;
            int i3 = this.f4931f;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                a();
            } else {
                b(i3 - i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static h b(h hVar) {
        int e2 = hVar.e();
        int i = 0;
        while (i < e2) {
            byte a2 = hVar.a(i);
            if (a2 < 65 || a2 > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + hVar.a());
            }
        }
        return hVar;
    }
}
