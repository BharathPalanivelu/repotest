package com.c.a.g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.c.a.c.b.h;
import com.c.a.c.d.e.c;
import com.c.a.c.d.e.f;
import com.c.a.c.j;
import com.c.a.c.m;
import com.c.a.h.a;
import com.c.a.i.i;
import com.facebook.common.util.ByteConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.TIMGroupManager;
import java.util.HashMap;
import java.util.Map;
import tencent.tls.platform.SigType;

public class g implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f6194a;

    /* renamed from: b  reason: collision with root package name */
    private float f6195b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private h f6196c = h.f5811e;

    /* renamed from: d  reason: collision with root package name */
    private com.c.a.g f6197d = com.c.a.g.NORMAL;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f6198e;

    /* renamed from: f  reason: collision with root package name */
    private int f6199f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f6200g;
    private int h;
    private boolean i = true;
    private int j = -1;
    private int k = -1;
    private com.c.a.c.h l = a.a();
    private boolean m;
    private boolean n = true;
    private Drawable o;
    private int p;
    private j q = new j();
    private Map<Class<?>, m<?>> r = new HashMap();
    private Class<?> s = Object.class;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y = true;
    private boolean z;

    private static boolean b(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static g a(h hVar) {
        return new g().b(hVar);
    }

    public static g a(com.c.a.c.h hVar) {
        return new g().b(hVar);
    }

    public static g a(Class<?> cls) {
        return new g().b(cls);
    }

    public g a(float f2) {
        if (this.v) {
            return clone().a(f2);
        }
        if (f2 < BitmapDescriptorFactory.HUE_RED || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f6195b = f2;
        this.f6194a |= 2;
        return B();
    }

    public g a(boolean z2) {
        if (this.v) {
            return clone().a(z2);
        }
        this.z = z2;
        this.f6194a |= ByteConstants.MB;
        return B();
    }

    public g b(h hVar) {
        if (this.v) {
            return clone().b(hVar);
        }
        this.f6196c = (h) com.c.a.i.h.a(hVar);
        this.f6194a |= 4;
        return B();
    }

    public g a(com.c.a.g gVar) {
        if (this.v) {
            return clone().a(gVar);
        }
        this.f6197d = (com.c.a.g) com.c.a.i.h.a(gVar);
        this.f6194a |= 8;
        return B();
    }

    public g b(boolean z2) {
        if (this.v) {
            return clone().b(true);
        }
        this.i = !z2;
        this.f6194a |= 256;
        return B();
    }

    public g a(int i2, int i3) {
        if (this.v) {
            return clone().a(i2, i3);
        }
        this.k = i2;
        this.j = i3;
        this.f6194a |= 512;
        return B();
    }

    public g b(com.c.a.c.h hVar) {
        if (this.v) {
            return clone().b(hVar);
        }
        this.l = (com.c.a.c.h) com.c.a.i.h.a(hVar);
        this.f6194a |= 1024;
        return B();
    }

    /* renamed from: a */
    public g clone() {
        try {
            g gVar = (g) super.clone();
            gVar.q = new j();
            gVar.q.a(this.q);
            gVar.r = new HashMap();
            gVar.r.putAll(this.r);
            gVar.t = false;
            gVar.v = false;
            return gVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public g b(Class<?> cls) {
        if (this.v) {
            return clone().b(cls);
        }
        this.s = (Class) com.c.a.i.h.a(cls);
        this.f6194a |= 4096;
        return B();
    }

    public g a(m<Bitmap> mVar) {
        return a(mVar, true);
    }

    private g a(m<Bitmap> mVar, boolean z2) {
        if (this.v) {
            return clone().a(mVar, z2);
        }
        com.c.a.c.d.a.j jVar = new com.c.a.c.d.a.j(mVar, z2);
        a(Bitmap.class, mVar, z2);
        a(Drawable.class, jVar, z2);
        a(BitmapDrawable.class, jVar.a(), z2);
        a(c.class, new f(mVar), z2);
        return B();
    }

    private <T> g a(Class<T> cls, m<T> mVar, boolean z2) {
        if (this.v) {
            return clone().a(cls, mVar, z2);
        }
        com.c.a.i.h.a(cls);
        com.c.a.i.h.a(mVar);
        this.r.put(cls, mVar);
        this.f6194a |= 2048;
        this.n = true;
        this.f6194a |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.y = false;
        if (z2) {
            this.f6194a |= 131072;
            this.m = true;
        }
        return B();
    }

    public g a(g gVar) {
        if (this.v) {
            return clone().a(gVar);
        }
        if (b(gVar.f6194a, 2)) {
            this.f6195b = gVar.f6195b;
        }
        if (b(gVar.f6194a, SigType.D2)) {
            this.w = gVar.w;
        }
        if (b(gVar.f6194a, ByteConstants.MB)) {
            this.z = gVar.z;
        }
        if (b(gVar.f6194a, 4)) {
            this.f6196c = gVar.f6196c;
        }
        if (b(gVar.f6194a, 8)) {
            this.f6197d = gVar.f6197d;
        }
        if (b(gVar.f6194a, 16)) {
            this.f6198e = gVar.f6198e;
        }
        if (b(gVar.f6194a, 32)) {
            this.f6199f = gVar.f6199f;
        }
        if (b(gVar.f6194a, 64)) {
            this.f6200g = gVar.f6200g;
        }
        if (b(gVar.f6194a, 128)) {
            this.h = gVar.h;
        }
        if (b(gVar.f6194a, 256)) {
            this.i = gVar.i;
        }
        if (b(gVar.f6194a, 512)) {
            this.k = gVar.k;
            this.j = gVar.j;
        }
        if (b(gVar.f6194a, 1024)) {
            this.l = gVar.l;
        }
        if (b(gVar.f6194a, 4096)) {
            this.s = gVar.s;
        }
        if (b(gVar.f6194a, 8192)) {
            this.o = gVar.o;
        }
        if (b(gVar.f6194a, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE)) {
            this.p = gVar.p;
        }
        if (b(gVar.f6194a, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG)) {
            this.u = gVar.u;
        }
        if (b(gVar.f6194a, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) {
            this.n = gVar.n;
        }
        if (b(gVar.f6194a, 131072)) {
            this.m = gVar.m;
        }
        if (b(gVar.f6194a, 2048)) {
            this.r.putAll(gVar.r);
            this.y = gVar.y;
        }
        if (b(gVar.f6194a, 524288)) {
            this.x = gVar.x;
        }
        if (!this.n) {
            this.r.clear();
            this.f6194a &= -2049;
            this.m = false;
            this.f6194a &= -131073;
            this.y = true;
        }
        this.f6194a |= gVar.f6194a;
        this.q.a(gVar.q);
        return B();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (Float.compare(gVar.f6195b, this.f6195b) == 0 && this.f6199f == gVar.f6199f && i.a((Object) this.f6198e, (Object) gVar.f6198e) && this.h == gVar.h && i.a((Object) this.f6200g, (Object) gVar.f6200g) && this.p == gVar.p && i.a((Object) this.o, (Object) gVar.o) && this.i == gVar.i && this.j == gVar.j && this.k == gVar.k && this.m == gVar.m && this.n == gVar.n && this.w == gVar.w && this.x == gVar.x && this.f6196c.equals(gVar.f6196c) && this.f6197d == gVar.f6197d && this.q.equals(gVar.q) && this.r.equals(gVar.r) && this.s.equals(gVar.s) && i.a((Object) this.l, (Object) gVar.l) && i.a((Object) this.u, (Object) gVar.u)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return i.a((Object) this.u, i.a((Object) this.l, i.a((Object) this.s, i.a((Object) this.r, i.a((Object) this.q, i.a((Object) this.f6197d, i.a((Object) this.f6196c, i.a(this.x, i.a(this.w, i.a(this.n, i.a(this.m, i.b(this.k, i.b(this.j, i.a(this.i, i.a((Object) this.o, i.b(this.p, i.a((Object) this.f6200g, i.b(this.h, i.a((Object) this.f6198e, i.b(this.f6199f, i.a(this.f6195b)))))))))))))))))))));
    }

    public g b() {
        this.t = true;
        return this;
    }

    public g c() {
        if (!this.t || this.v) {
            this.v = true;
            return b();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    private g B() {
        if (!this.t) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    public final Map<Class<?>, m<?>> d() {
        return this.r;
    }

    public final boolean e() {
        return this.m;
    }

    public final j f() {
        return this.q;
    }

    public final Class<?> g() {
        return this.s;
    }

    public final h h() {
        return this.f6196c;
    }

    public final Drawable i() {
        return this.f6198e;
    }

    public final int j() {
        return this.f6199f;
    }

    public final int k() {
        return this.h;
    }

    public final Drawable l() {
        return this.f6200g;
    }

    public final int m() {
        return this.p;
    }

    public final Drawable n() {
        return this.o;
    }

    public final Resources.Theme o() {
        return this.u;
    }

    public final boolean p() {
        return this.i;
    }

    public final com.c.a.c.h q() {
        return this.l;
    }

    public final boolean r() {
        return a(8);
    }

    public final com.c.a.g s() {
        return this.f6197d;
    }

    public final int t() {
        return this.k;
    }

    public final boolean u() {
        return i.a(this.k, this.j);
    }

    public final int v() {
        return this.j;
    }

    public final float w() {
        return this.f6195b;
    }

    public boolean x() {
        return this.y;
    }

    private boolean a(int i2) {
        return b(this.f6194a, i2);
    }

    public final boolean y() {
        return this.w;
    }

    public final boolean z() {
        return this.z;
    }

    public final boolean A() {
        return this.x;
    }
}
