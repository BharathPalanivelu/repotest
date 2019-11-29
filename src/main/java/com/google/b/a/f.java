package com.google.b.a;

import com.google.b.a.i;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f13589a;

    /* renamed from: b  reason: collision with root package name */
    private final c f13590b;

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<String, i.b> f13591c;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentHashMap<Integer, i.b> f13592d;

    f(String str, c cVar) {
        this.f13591c = new ConcurrentHashMap<>();
        this.f13592d = new ConcurrentHashMap<>();
        this.f13589a = str;
        this.f13590b = cVar;
    }

    f(c cVar) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", cVar);
    }

    public i.b a(String str) {
        return d.a(str, this.f13591c, this.f13589a, this.f13590b);
    }

    public i.b a(int i) {
        if (!b(i)) {
            return null;
        }
        return d.a(Integer.valueOf(i), this.f13592d, this.f13589a, this.f13590b);
    }

    private boolean b(int i) {
        List list = b.a().get(Integer.valueOf(i));
        if (list.size() != 1 || !"001".equals(list.get(0))) {
            return false;
        }
        return true;
    }
}
