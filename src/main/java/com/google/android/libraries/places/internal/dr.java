package com.google.android.libraries.places.internal;

import com.c.a.j;
import com.google.a.d;
import com.google.a.f;
import com.google.a.g;
import com.google.a.u;

public class dr implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final f f12471a = new g().a(d.LOWER_CASE_WITH_UNDERSCORES).d();

    public static dq a(j jVar) {
        return new dq(jVar);
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public <T> T a(String str, Class<T> cls) throws t {
        try {
            return this.f12471a.a(str, cls);
        } catch (u unused) {
            String name = cls.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 55);
            sb.append("Could not convert JSON string to ");
            sb.append(name);
            sb.append(" due to syntax errors.");
            throw new t(sb.toString());
        }
    }
}
