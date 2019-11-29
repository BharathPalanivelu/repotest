package qalsdk;

import com.g.a.a.c;
import com.g.a.a.e;
import com.g.a.a.f;
import com.g.a.a.g;
import com.g.a.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ab extends g implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<Long> f34059a;

    /* renamed from: b  reason: collision with root package name */
    private static Map<Long, String> f34060b;

    /* renamed from: f  reason: collision with root package name */
    private static /* synthetic */ boolean f34061f = (!ab.class.desiredAssertionStatus());

    /* renamed from: c  reason: collision with root package name */
    private String f34062c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Long> f34063d;

    /* renamed from: e  reason: collision with root package name */
    private Map<Long, String> f34064e;

    public ab() {
        this.f34062c = "";
        this.f34063d = null;
        this.f34064e = null;
        this.f34062c = this.f34062c;
        this.f34063d = this.f34063d;
        this.f34064e = this.f34064e;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ab abVar = (ab) obj;
        if (!h.a((Object) this.f34062c, (Object) abVar.f34062c) || !h.a((Object) this.f34063d, (Object) abVar.f34063d) || !h.a((Object) this.f34064e, (Object) abVar.f34064e)) {
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
            if (f34061f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(f fVar) {
        fVar.a(this.f34062c, 1);
        fVar.a(this.f34063d, 2);
        fVar.a(this.f34064e, 3);
    }

    public final void readFrom(e eVar) {
        this.f34062c = eVar.a(1, true);
        if (f34059a == null) {
            f34059a = new ArrayList<>();
            f34059a.add(0L);
        }
        this.f34063d = (ArrayList) eVar.a(f34059a, 2, true);
        if (f34060b == null) {
            f34060b = new HashMap();
            f34060b.put(0L, "");
        }
        this.f34064e = (Map) eVar.a(f34060b, 3, true);
    }

    public final void display(StringBuilder sb, int i) {
        c cVar = new c(sb, i);
        cVar.a(this.f34062c, "uin");
        cVar.a(this.f34063d, "notifyIds");
        cVar.a(this.f34064e, "notifyProperties");
    }
}
