package com.google.firebase.c;

import com.google.firebase.components.e;
import com.google.firebase.components.n;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.Iterator;
import java.util.Set;

public class b implements g {

    /* renamed from: a  reason: collision with root package name */
    private final String f6837a;

    /* renamed from: b  reason: collision with root package name */
    private final d f6838b;

    b(Set<e> set, d dVar) {
        this.f6837a = a(set);
        this.f6838b = dVar;
    }

    public String a() {
        if (this.f6838b.a().isEmpty()) {
            return this.f6837a;
        }
        return this.f6837a + ' ' + a(this.f6838b.a());
    }

    private static String a(Set<e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<e> it = set.iterator();
        while (it.hasNext()) {
            e next = it.next();
            sb.append(next.a());
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(next.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static com.google.firebase.components.b<g> b() {
        return com.google.firebase.components.b.a(g.class).a(n.c(e.class)).a(c.a()).c();
    }

    static /* synthetic */ g a(e eVar) {
        return new b(eVar.b(e.class), d.b());
    }
}
