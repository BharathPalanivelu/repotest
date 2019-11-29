package com.bca.xco.widget.d.b;

import com.litesuits.orm.db.assit.SQLBuilder;

public abstract class i implements d {

    /* renamed from: a  reason: collision with root package name */
    private final d f5221a;

    public i(d dVar) {
        if (dVar != null) {
            this.f5221a = dVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public long a(g gVar, long j) {
        return this.f5221a.a(gVar, j);
    }

    public s a() {
        return this.f5221a.a();
    }

    public void close() {
        this.f5221a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + SQLBuilder.PARENTHESES_LEFT + this.f5221a.toString() + SQLBuilder.PARENTHESES_RIGHT;
    }
}
