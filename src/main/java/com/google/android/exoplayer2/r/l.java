package com.google.android.exoplayer2.r;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public final class l implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11338a;

    /* renamed from: b  reason: collision with root package name */
    private final u<? super f> f11339b;

    /* renamed from: c  reason: collision with root package name */
    private final f f11340c;

    /* renamed from: d  reason: collision with root package name */
    private f f11341d;

    /* renamed from: e  reason: collision with root package name */
    private f f11342e;

    /* renamed from: f  reason: collision with root package name */
    private f f11343f;

    /* renamed from: g  reason: collision with root package name */
    private f f11344g;
    private f h;

    public l(Context context, u<? super f> uVar, f fVar) {
        this.f11338a = context.getApplicationContext();
        this.f11339b = uVar;
        this.f11340c = (f) a.a(fVar);
    }

    public long a(i iVar) throws IOException {
        a.b(this.h == null);
        String scheme = iVar.f11313a.getScheme();
        if (v.a(iVar.f11313a)) {
            if (iVar.f11313a.getPath().startsWith("/android_asset/")) {
                this.h = d();
            } else {
                this.h = c();
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.h = d();
        } else if (UriUtil.LOCAL_CONTENT_SCHEME.equals(scheme)) {
            this.h = e();
        } else if ("rtmp".equals(scheme)) {
            this.h = f();
        } else {
            this.h = this.f11340c;
        }
        return this.h.a(iVar);
    }

    public int a(byte[] bArr, int i, int i2) throws IOException {
        return this.h.a(bArr, i, i2);
    }

    public Uri b() {
        f fVar = this.h;
        if (fVar == null) {
            return null;
        }
        return fVar.b();
    }

    public void a() throws IOException {
        f fVar = this.h;
        if (fVar != null) {
            try {
                fVar.a();
            } finally {
                this.h = null;
            }
        }
    }

    private f c() {
        if (this.f11341d == null) {
            this.f11341d = new p(this.f11339b);
        }
        return this.f11341d;
    }

    private f d() {
        if (this.f11342e == null) {
            this.f11342e = new c(this.f11338a, this.f11339b);
        }
        return this.f11342e;
    }

    private f e() {
        if (this.f11343f == null) {
            this.f11343f = new e(this.f11338a, this.f11339b);
        }
        return this.f11343f;
    }

    private f f() {
        if (this.f11344g == null) {
            try {
                this.f11344g = (f) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (InstantiationException e2) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e2);
            } catch (IllegalAccessException e3) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e3);
            } catch (NoSuchMethodException e4) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e4);
            } catch (InvocationTargetException e5) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e5);
            }
            if (this.f11344g == null) {
                this.f11344g = this.f11340c;
            }
        }
        return this.f11344g;
    }
}
