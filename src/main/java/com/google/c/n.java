package com.google.c;

import com.facebook.soloader.MinElf;
import com.google.c.j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class n extends p {

    /* renamed from: a  reason: collision with root package name */
    static final n f13982a = new n(true);

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, b> f13983c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, b> f13984d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<a, b> f13985e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<a, b> f13986f;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final j.f f13989a;

        /* renamed from: b  reason: collision with root package name */
        public final ac f13990b;
    }

    public static n a() {
        return f13982a;
    }

    public b a(j.a aVar, int i) {
        return this.f13985e.get(new a(aVar, i));
    }

    private n() {
        this.f13983c = new HashMap();
        this.f13984d = new HashMap();
        this.f13985e = new HashMap();
        this.f13986f = new HashMap();
    }

    n(boolean z) {
        super(f13993b);
        this.f13983c = Collections.emptyMap();
        this.f13984d = Collections.emptyMap();
        this.f13985e = Collections.emptyMap();
        this.f13986f = Collections.emptyMap();
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final j.a f13987a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13988b;

        a(j.a aVar, int i) {
            this.f13987a = aVar;
            this.f13988b = i;
        }

        public int hashCode() {
            return (this.f13987a.hashCode() * MinElf.PN_XNUM) + this.f13988b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f13987a == aVar.f13987a && this.f13988b == aVar.f13988b) {
                return true;
            }
            return false;
        }
    }
}
