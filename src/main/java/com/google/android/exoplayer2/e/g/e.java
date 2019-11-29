package com.google.android.exoplayer2.e.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e implements v.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f9618a;

    /* renamed from: b  reason: collision with root package name */
    private final List<j> f9619b;

    public e() {
        this(0);
    }

    public e(int i) {
        this(i, Collections.emptyList());
    }

    public e(int i, List<j> list) {
        this.f9618a = i;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(j.a((String) null, "application/cea-608", (String) null, -1, 0, (String) null, (a) null));
        }
        this.f9619b = list;
    }

    public SparseArray<v> a() {
        return new SparseArray<>();
    }

    public v a(int i, v.b bVar) {
        if (i == 2) {
            return new o(new i());
        }
        if (i == 3 || i == 4) {
            return new o(new m(bVar.f9745b));
        }
        if (i != 15) {
            if (i == 21) {
                return new o(new l());
            }
            if (i != 27) {
                if (i == 36) {
                    return new o(new k(a(bVar)));
                }
                if (i == 89) {
                    return new o(new g(bVar.f9746c));
                }
                if (i != 138) {
                    if (i != 129) {
                        if (i != 130) {
                            if (i != 134) {
                                if (i != 135) {
                                    return null;
                                }
                            } else if (a(16)) {
                                return null;
                            } else {
                                return new r(new t());
                            }
                        }
                    }
                    return new o(new b(bVar.f9745b));
                }
                return new o(new f(bVar.f9745b));
            } else if (a(4)) {
                return null;
            } else {
                return new o(new j(a(bVar), a(1), a(8)));
            }
        } else if (a(2)) {
            return null;
        } else {
            return new o(new d(false, bVar.f9745b));
        }
    }

    private s a(v.b bVar) {
        int i;
        String str;
        if (a(32)) {
            return new s(this.f9619b);
        }
        k kVar = new k(bVar.f9747d);
        List<j> list = this.f9619b;
        while (kVar.b() > 0) {
            int g2 = kVar.g();
            int d2 = kVar.d() + kVar.g();
            if (g2 == 134) {
                list = new ArrayList<>();
                int g3 = kVar.g() & 31;
                for (int i2 = 0; i2 < g3; i2++) {
                    String e2 = kVar.e(3);
                    int g4 = kVar.g();
                    if ((g4 & 128) != 0) {
                        i = g4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    list.add(j.a((String) null, str, (String) null, -1, 0, e2, i, (a) null));
                    kVar.d(2);
                }
            }
            kVar.c(d2);
        }
        return new s(list);
    }

    private boolean a(int i) {
        return (i & this.f9618a) != 0;
    }
}
