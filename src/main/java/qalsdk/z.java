package qalsdk;

import com.g.a.a.e;
import com.g.a.a.f;
import com.g.a.a.g;
import com.tencent.qalsdk.core.b;
import com.tencent.qalsdk.service.QalService;

public final class z extends g {
    private static af k;
    private static ab l;
    private static aa m;

    /* renamed from: a  reason: collision with root package name */
    public int f34206a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f34207b = "";

    /* renamed from: c  reason: collision with root package name */
    public long f34208c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f34209d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f34210e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f34211f = "";

    /* renamed from: g  reason: collision with root package name */
    public af f34212g = null;
    public aa h = null;
    public String i = "";
    public byte j = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private String q = "";
    private ab r = null;

    public z() {
    }

    public z(String str) {
        this.f34207b = str;
        StringBuilder sb = new StringBuilder();
        sb.append(b.b(QalService.context));
        this.i = sb.toString();
    }

    public final void writeTo(f fVar) {
        fVar.a(this.f34206a, 1);
        fVar.a(this.f34207b, 2);
        fVar.a(this.f34208c, 3);
        fVar.a(this.n, 4);
        fVar.a(this.f34209d, 5);
        fVar.a(this.f34210e, 6);
        fVar.a(this.o, 7);
        fVar.a(this.p, 8);
        String str = this.f34211f;
        if (str != null) {
            fVar.a(str, 9);
        }
        String str2 = this.q;
        if (str2 != null) {
            fVar.a(str2, 10);
        }
        af afVar = this.f34212g;
        if (afVar != null) {
            fVar.a((g) afVar, 11);
        }
        ab abVar = this.r;
        if (abVar != null) {
            fVar.a((g) abVar, 12);
        }
        aa aaVar = this.h;
        if (aaVar != null) {
            fVar.a((g) aaVar, 13);
        }
        String str3 = this.i;
        if (str3 != null) {
            fVar.a(str3, 14);
        }
        fVar.b(this.j, 15);
    }

    public final void readFrom(e eVar) {
        this.f34206a = eVar.a(this.f34206a, 1, true);
        this.f34207b = eVar.a(2, true);
        this.f34208c = eVar.a(this.f34208c, 3, true);
        this.n = eVar.a(this.n, 4, true);
        this.f34209d = eVar.a(this.f34209d, 5, false);
        this.f34210e = eVar.a(this.f34210e, 6, false);
        this.o = eVar.a(this.o, 7, false);
        this.p = eVar.a(this.p, 8, false);
        this.f34211f = eVar.a(9, false);
        this.q = eVar.a(10, false);
        if (k == null) {
            k = new af();
        }
        this.f34212g = (af) eVar.a((g) k, 11, false);
        if (l == null) {
            l = new ab();
        }
        this.r = (ab) eVar.a((g) l, 12, false);
        if (m == null) {
            m = new aa();
        }
        this.h = (aa) eVar.a((g) m, 13, false);
        this.i = eVar.a(14, false);
        this.j = eVar.a(this.j, 15, false);
    }
}
