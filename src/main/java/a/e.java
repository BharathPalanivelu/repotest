package a;

import java.util.Locale;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final g f362a;

    e(g gVar) {
        this.f362a = gVar;
    }

    public boolean a() {
        return this.f362a.a();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f362a.a())});
    }
}
