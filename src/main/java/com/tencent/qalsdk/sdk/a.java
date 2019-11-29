package com.tencent.qalsdk.sdk;

import com.g.a.a.c;
import com.g.a.a.e;
import com.g.a.a.f;
import com.g.a.a.g;
import com.g.a.a.h;

public final class a extends g implements Cloneable {
    private static byte[] i;
    private static byte[] j;
    private static byte[] k;
    private static /* synthetic */ boolean l = (!a.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public String f32223a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f32224b = "";

    /* renamed from: c  reason: collision with root package name */
    public byte[] f32225c = null;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f32226d = null;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f32227e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f32228f = 0;

    /* renamed from: g  reason: collision with root package name */
    public byte f32229g = 0;
    public long h = 0;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        a aVar = (a) obj;
        if (!h.a((Object) this.f32223a, (Object) aVar.f32223a) || !h.a((Object) this.f32224b, (Object) aVar.f32224b) || !h.a((Object) this.f32225c, (Object) aVar.f32225c) || !h.a((Object) this.f32226d, (Object) aVar.f32226d) || !h.a((Object) this.f32227e, (Object) aVar.f32227e) || !h.a(this.f32228f, aVar.f32228f) || !h.a(this.f32229g, aVar.f32229g) || !h.a(this.h, aVar.h)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (l) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(f fVar) {
        fVar.a(this.f32223a, 1);
        fVar.a(this.f32224b, 2);
        fVar.a(this.f32225c, 3);
        fVar.a(this.f32226d, 4);
        fVar.a(this.f32227e, 5);
        fVar.a(this.f32228f, 6);
        fVar.b(this.f32229g, 7);
        fVar.a(this.h, 8);
    }

    public final void readFrom(e eVar) {
        this.f32223a = eVar.a(1, true);
        this.f32224b = eVar.a(2, true);
        if (i == null) {
            byte[] bArr = new byte[1];
            i = bArr;
            bArr[0] = 0;
        }
        this.f32225c = eVar.a(i, 3, true);
        if (j == null) {
            byte[] bArr2 = new byte[1];
            j = bArr2;
            bArr2[0] = 0;
        }
        this.f32226d = eVar.a(j, 4, true);
        if (k == null) {
            byte[] bArr3 = new byte[1];
            k = bArr3;
            bArr3[0] = 0;
        }
        this.f32227e = eVar.a(k, 5, true);
        this.f32228f = eVar.a(this.f32228f, 6, true);
        this.f32229g = eVar.a(this.f32229g, 7, true);
        this.h = eVar.a(this.h, 8, true);
    }

    public final void display(StringBuilder sb, int i2) {
        c cVar = new c(sb, i2);
        cVar.a(this.f32223a, "userID");
        cVar.a(this.f32224b, "tinyID");
        cVar.a(this.f32225c, "a2");
        cVar.a(this.f32226d, "d2");
        cVar.a(this.f32227e, "d2Key");
        cVar.a(this.f32228f, "sdkAppID");
        cVar.a(this.f32229g, "bRegister");
        cVar.a(this.h, "lastSendPackTime");
    }
}
