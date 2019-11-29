package org.a.a.b;

import java.util.LinkedHashSet;
import java.util.Set;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f33823a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f33824b = new LinkedHashSet();

    public static c a(c cVar) {
        c cVar2 = f33823a;
        f33823a = cVar;
        return cVar2;
    }

    public static void a(b bVar) {
        c cVar = f33823a;
        if (cVar != null) {
            cVar.f33824b.add(bVar);
        }
    }

    public void a(a aVar) {
        for (b onViewChanged : this.f33824b) {
            onViewChanged.onViewChanged(aVar);
        }
    }
}
