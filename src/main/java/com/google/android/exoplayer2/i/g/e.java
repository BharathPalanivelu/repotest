package com.google.android.exoplayer2.i.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.s.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e implements v.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f10252a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Format> f10253b;

    public e() {
        this(0);
    }

    public e(int i) {
        this(i, Collections.emptyList());
    }

    public e(int i, List<Format> list) {
        this.f10252a = i;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.a((String) null, "application/cea-608", 0, (String) null));
        }
        this.f10253b = list;
    }

    public SparseArray<v> a() {
        return new SparseArray<>();
    }

    public v a(int i, v.b bVar) {
        if (i == 2) {
            return new o(new i());
        }
        if (i == 3 || i == 4) {
            return new o(new m(bVar.f10382b));
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
                    return new o(new g(bVar.f10383c));
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
                    return new o(new b(bVar.f10382b));
                }
                return new o(new f(bVar.f10382b));
            } else if (a(4)) {
                return null;
            } else {
                return new o(new j(a(bVar), a(1), a(8)));
            }
        } else if (a(2)) {
            return null;
        } else {
            return new o(new d(false, bVar.f10382b));
        }
    }

    private s a(v.b bVar) {
        int i;
        String str;
        if (a(32)) {
            return new s(this.f10253b);
        }
        l lVar = new l(bVar.f10384d);
        List<Format> list = this.f10253b;
        while (lVar.b() > 0) {
            int g2 = lVar.g();
            int d2 = lVar.d() + lVar.g();
            if (g2 == 134) {
                list = new ArrayList<>();
                int g3 = lVar.g() & 31;
                for (int i2 = 0; i2 < g3; i2++) {
                    String e2 = lVar.e(3);
                    int g4 = lVar.g();
                    if ((g4 & 128) != 0) {
                        i = g4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    list.add(Format.a((String) null, str, (String) null, -1, 0, e2, i, (DrmInitData) null));
                    lVar.d(2);
                }
            }
            lVar.c(d2);
        }
        return new s(list);
    }

    private boolean a(int i) {
        return (i & this.f10252a) != 0;
    }
}
