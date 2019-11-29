package com.c.a.c.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.c.a.c;
import com.c.a.c.b.s;
import com.c.a.c.d.a.d;
import com.c.a.c.m;
import java.security.MessageDigest;

public class f implements m<c> {

    /* renamed from: b  reason: collision with root package name */
    private final m<Bitmap> f6079b;

    /* JADX WARNING: type inference failed for: r1v0, types: [com.c.a.c.m<android.graphics.Bitmap>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.c.a.c.m<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.c.a.i.h.a(r1)
            com.c.a.c.m r1 = (com.c.a.c.m) r1
            r0.f6079b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.d.e.f.<init>(com.c.a.c.m):void");
    }

    public s<c> a(Context context, s<c> sVar, int i, int i2) {
        c c2 = sVar.c();
        d dVar = new d(c2.b(), c.a(context).a());
        s<Bitmap> a2 = this.f6079b.a(context, dVar, i, i2);
        if (!dVar.equals(a2)) {
            dVar.e();
        }
        c2.a(this.f6079b, a2.c());
        return sVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f6079b.equals(((f) obj).f6079b);
        }
        return false;
    }

    public int hashCode() {
        return this.f6079b.hashCode();
    }

    public void a(MessageDigest messageDigest) {
        this.f6079b.a(messageDigest);
    }
}
