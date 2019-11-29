package qalsdk;

import com.g.a.a.c;
import com.g.a.a.e;
import com.g.a.a.f;
import com.g.a.a.g;
import com.g.a.a.h;
import java.util.ArrayList;

public final class af extends g implements Cloneable {

    /* renamed from: g  reason: collision with root package name */
    private static ArrayList<Long> f34078g;
    private static /* synthetic */ boolean h = (!af.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public String f34079a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Long> f34080b;

    /* renamed from: c  reason: collision with root package name */
    public int f34081c;

    /* renamed from: d  reason: collision with root package name */
    public byte f34082d;

    /* renamed from: e  reason: collision with root package name */
    public byte f34083e;

    /* renamed from: f  reason: collision with root package name */
    public long f34084f;

    public af() {
        this.f34079a = "";
        this.f34080b = null;
        this.f34081c = 0;
        this.f34082d = 0;
        this.f34083e = 0;
        this.f34084f = 0;
        this.f34079a = this.f34079a;
        this.f34080b = this.f34080b;
        this.f34081c = this.f34081c;
        this.f34082d = this.f34082d;
        this.f34083e = this.f34083e;
        this.f34084f = this.f34084f;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        af afVar = (af) obj;
        if (!h.a((Object) this.f34079a, (Object) afVar.f34079a) || !h.a((Object) this.f34080b, (Object) afVar.f34080b) || !h.a(this.f34081c, afVar.f34081c) || !h.a(this.f34082d, afVar.f34082d) || !h.a(this.f34083e, afVar.f34083e) || !h.a(this.f34084f, afVar.f34084f)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (h) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(f fVar) {
        fVar.a(this.f34079a, 1);
        fVar.a(this.f34080b, 2);
        fVar.a(this.f34081c, 3);
        fVar.b(this.f34082d, 4);
        fVar.b(this.f34083e, 5);
        fVar.a(this.f34084f, 6);
    }

    public final void readFrom(e eVar) {
        this.f34079a = eVar.a(1, true);
        if (f34078g == null) {
            f34078g = new ArrayList<>();
            f34078g.add(0L);
        }
        this.f34080b = (ArrayList) eVar.a(f34078g, 2, true);
        this.f34081c = eVar.a(this.f34081c, 3, true);
        this.f34082d = eVar.a(this.f34082d, 4, true);
        this.f34083e = eVar.a(this.f34083e, 5, true);
        this.f34084f = eVar.a(this.f34084f, 6, true);
    }

    public final void display(StringBuilder sb, int i) {
        c cVar = new c(sb, i);
        cVar.a(this.f34079a, "uin");
        cVar.a(this.f34080b, "pushIds");
        cVar.a(this.f34081c, "iStatus");
        cVar.a(this.f34082d, "bKikPC");
        cVar.a(this.f34083e, "bKikWeak");
        cVar.a(this.f34084f, "timeStamp");
    }
}
