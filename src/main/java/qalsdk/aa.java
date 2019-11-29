package qalsdk;

import com.g.a.a.c;
import com.g.a.a.e;
import com.g.a.a.f;
import com.g.a.a.g;
import com.g.a.a.h;
import java.util.ArrayList;

public final class aa extends g implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static ArrayList<String> f34055c;

    /* renamed from: d  reason: collision with root package name */
    private static /* synthetic */ boolean f34056d = (!aa.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public String f34057a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f34058b;

    public aa() {
        this.f34057a = "";
        this.f34058b = null;
        this.f34057a = this.f34057a;
        this.f34058b = this.f34058b;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        aa aaVar = (aa) obj;
        if (!h.a((Object) this.f34057a, (Object) aaVar.f34057a) || !h.a((Object) this.f34058b, (Object) aaVar.f34058b)) {
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
            if (f34056d) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(f fVar) {
        fVar.a(this.f34057a, 1);
        fVar.a(this.f34058b, 2);
    }

    public final void readFrom(e eVar) {
        this.f34057a = eVar.a(1, true);
        if (f34055c == null) {
            f34055c = new ArrayList<>();
            f34055c.add("");
        }
        this.f34058b = (ArrayList) eVar.a(f34055c, 2, true);
    }

    public final void display(StringBuilder sb, int i) {
        c cVar = new c(sb, i);
        cVar.a(this.f34057a, "uin");
        cVar.a(this.f34058b, "cmds");
    }
}
