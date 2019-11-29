package qalsdk;

import com.g.a.a.c;
import com.g.a.a.e;
import com.g.a.a.f;
import com.g.a.a.g;
import com.g.a.a.h;
import java.util.ArrayList;

public final class al extends g implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<ak> f34104b;

    /* renamed from: c  reason: collision with root package name */
    private static /* synthetic */ boolean f34105c = (!al.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ak> f34106a = null;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return h.a((Object) this.f34106a, (Object) ((al) obj).f34106a);
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
            if (f34105c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(f fVar) {
        fVar.a(this.f34106a, 1);
    }

    public final void readFrom(e eVar) {
        if (f34104b == null) {
            f34104b = new ArrayList<>();
            f34104b.add(new ak());
        }
        this.f34106a = (ArrayList) eVar.a(f34104b, 1, true);
    }

    public final void display(StringBuilder sb, int i) {
        new c(sb, i).a(this.f34106a, "netInfos");
    }
}
