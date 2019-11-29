package com.bca.xco.widget.d.a.a.f;

import com.bca.xco.widget.d.a.aa;
import com.bca.xco.widget.d.a.r;
import com.bca.xco.widget.d.a.u;
import com.bca.xco.widget.d.b.b;
import com.tencent.qcloud.core.http.HttpConstants;

public final class i extends aa {

    /* renamed from: a  reason: collision with root package name */
    private final r f4882a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4883b;

    public i(r rVar, b bVar) {
        this.f4882a = rVar;
        this.f4883b = bVar;
    }

    public u a() {
        String a2 = this.f4882a.a(HttpConstants.Header.CONTENT_TYPE);
        if (a2 != null) {
            return u.a(a2);
        }
        return null;
    }

    public long b() {
        return f.a(this.f4882a);
    }

    public b c() {
        return this.f4883b;
    }
}
