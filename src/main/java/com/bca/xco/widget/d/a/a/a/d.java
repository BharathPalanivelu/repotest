package com.bca.xco.widget.d.a.a.a;

import com.bca.xco.widget.d.a.ab;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ab> f4754a = new LinkedHashSet();

    public synchronized void a(ab abVar) {
        this.f4754a.add(abVar);
    }

    public synchronized void b(ab abVar) {
        this.f4754a.remove(abVar);
    }

    public synchronized boolean c(ab abVar) {
        return this.f4754a.contains(abVar);
    }
}
