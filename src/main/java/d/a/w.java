package d.a;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import d.d.b.j;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class w implements Serializable, Map {

    /* renamed from: a  reason: collision with root package name */
    public static final w f32652a = new w();
    private static final long serialVersionUID = 8246714829545688274L;

    public int a() {
        return 0;
    }

    public Void a(Object obj) {
        return null;
    }

    public boolean a(Void voidR) {
        j.b(voidR, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return false;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object obj) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return ServiceLogger.PLACEHOLDER;
    }

    private w() {
    }

    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    public final Set<Map.Entry> entrySet() {
        return b();
    }

    public final Object get(Object obj) {
        return a(obj);
    }

    public final Set<Object> keySet() {
        return c();
    }

    public final int size() {
        return a();
    }

    public final Collection values() {
        return d();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public Set<Map.Entry> b() {
        return x.f32653a;
    }

    public Set<Object> c() {
        return x.f32653a;
    }

    public Collection d() {
        return v.f32651a;
    }

    private final Object readResolve() {
        return f32652a;
    }
}
