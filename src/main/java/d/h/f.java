package d.h;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import d.e.c;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f32705a;

    /* renamed from: b  reason: collision with root package name */
    private final c f32706b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return j.a((Object) this.f32705a, (Object) fVar.f32705a) && j.a((Object) this.f32706b, (Object) fVar.f32706b);
    }

    public int hashCode() {
        String str = this.f32705a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        c cVar = this.f32706b;
        if (cVar != null) {
            i = cVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MatchGroup(value=" + this.f32705a + ", range=" + this.f32706b + SQLBuilder.PARENTHESES_RIGHT;
    }

    public f(String str, c cVar) {
        j.b(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        j.b(cVar, "range");
        this.f32705a = str;
        this.f32706b = cVar;
    }
}
