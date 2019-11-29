package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.g.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.p.k;
import com.google.android.exoplayer2.q.h;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.i;
import java.util.List;

@TargetApi(16)
public class w implements f {

    /* renamed from: a  reason: collision with root package name */
    protected final s[] f12285a;

    /* renamed from: b  reason: collision with root package name */
    private final f f12286b;

    /* renamed from: c  reason: collision with root package name */
    private final a f12287c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final int f12288d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12289e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Format f12290f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Format f12291g;
    /* access modifiers changed from: private */
    public Surface h;
    private boolean i;
    private int j;
    private SurfaceHolder k;
    private TextureView l;
    /* access modifiers changed from: private */
    public k.a m;
    /* access modifiers changed from: private */
    public e.a n;
    /* access modifiers changed from: private */
    public b o;
    /* access modifiers changed from: private */
    public com.google.android.exoplayer2.b.e p;
    /* access modifiers changed from: private */
    public com.google.android.exoplayer2.video.e q;
    /* access modifiers changed from: private */
    public d r;
    /* access modifiers changed from: private */
    public d s;
    /* access modifiers changed from: private */
    public int t;
    private com.google.android.exoplayer2.b.b u;
    private float v;

    public interface b {
        void a(int i, int i2, int i3, float f2);

        void b();
    }

    protected w(v vVar, h hVar, n nVar) {
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        a aVar = this.f12287c;
        this.f12285a = vVar.a(handler, aVar, aVar, aVar, aVar);
        int i2 = 0;
        int i3 = 0;
        for (s a2 : this.f12285a) {
            int a3 = a2.a();
            if (a3 == 1) {
                i3++;
            } else if (a3 == 2) {
                i2++;
            }
        }
        this.f12288d = i2;
        this.f12289e = i3;
        this.v = 1.0f;
        this.t = 0;
        this.u = com.google.android.exoplayer2.b.b.f9152a;
        this.j = 1;
        this.f12286b = new h(this.f12285a, hVar, nVar);
    }

    public void d() {
        a((Surface) null);
    }

    public void a(Surface surface) {
        h();
        a(surface, false);
    }

    public void a(TextureView textureView) {
        h();
        this.l = textureView;
        Surface surface = null;
        if (textureView == null) {
            a((Surface) null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f12287c);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture != null) {
            surface = new Surface(surfaceTexture);
        }
        a(surface, true);
    }

    public void a(float f2) {
        this.v = f2;
        f.b[] bVarArr = new f.b[this.f12289e];
        int i2 = 0;
        for (s sVar : this.f12285a) {
            if (sVar.a() == 1) {
                bVarArr[i2] = new f.b(sVar, 2, Float.valueOf(f2));
                i2++;
            }
        }
        this.f12286b.a(bVarArr);
    }

    public Format g() {
        return this.f12290f;
    }

    public void a(b bVar) {
        this.o = bVar;
    }

    public void a(r.a aVar) {
        this.f12286b.a(aVar);
    }

    public void b(r.a aVar) {
        this.f12286b.b(aVar);
    }

    public int a() {
        return this.f12286b.a();
    }

    public void a(i iVar) {
        this.f12286b.a(iVar);
    }

    public void a(boolean z) {
        this.f12286b.a(z);
    }

    public boolean b() {
        return this.f12286b.b();
    }

    public void a(long j2) {
        this.f12286b.a(j2);
    }

    public void c() {
        this.f12286b.c();
        h();
        Surface surface = this.h;
        if (surface != null) {
            if (this.i) {
                surface.release();
            }
            this.h = null;
        }
    }

    public void a(f.b... bVarArr) {
        this.f12286b.a(bVarArr);
    }

    public void b(f.b... bVarArr) {
        this.f12286b.b(bVarArr);
    }

    public long e() {
        return this.f12286b.e();
    }

    public long f() {
        return this.f12286b.f();
    }

    private void h() {
        TextureView textureView = this.l;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f12287c) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.l.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.l = null;
        }
        SurfaceHolder surfaceHolder = this.k;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f12287c);
            this.k = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        f.b[] bVarArr = new f.b[this.f12288d];
        int i2 = 0;
        for (s sVar : this.f12285a) {
            if (sVar.a() == 2) {
                bVarArr[i2] = new f.b(sVar, 1, surface);
                i2++;
            }
        }
        Surface surface2 = this.h;
        if (surface2 == null || surface2 == surface) {
            this.f12286b.a(bVarArr);
        } else {
            this.f12286b.b(bVarArr);
            if (this.i) {
                this.h.release();
            }
        }
        this.h = surface;
        this.i = z;
    }

    private final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.b.e, e.a, k.a, com.google.android.exoplayer2.video.e {
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private a() {
        }

        public void a(d dVar) {
            d unused = w.this.r = dVar;
            if (w.this.q != null) {
                w.this.q.a(dVar);
            }
        }

        public void a(String str, long j, long j2) {
            if (w.this.q != null) {
                w.this.q.a(str, j, j2);
            }
        }

        public void a(Format format) {
            Format unused = w.this.f12290f = format;
            if (w.this.q != null) {
                w.this.q.a(format);
            }
        }

        public void a(int i, long j) {
            if (w.this.q != null) {
                w.this.q.a(i, j);
            }
        }

        public void a(int i, int i2, int i3, float f2) {
            if (w.this.o != null) {
                w.this.o.a(i, i2, i3, f2);
            }
            if (w.this.q != null) {
                w.this.q.a(i, i2, i3, f2);
            }
        }

        public void a(Surface surface) {
            if (w.this.o != null && w.this.h == surface) {
                w.this.o.b();
            }
            if (w.this.q != null) {
                w.this.q.a(surface);
            }
        }

        public void b(d dVar) {
            if (w.this.q != null) {
                w.this.q.b(dVar);
            }
            Format unused = w.this.f12290f = null;
            d unused2 = w.this.r = null;
        }

        public void c(d dVar) {
            d unused = w.this.s = dVar;
            if (w.this.p != null) {
                w.this.p.c(dVar);
            }
        }

        public void a(int i) {
            int unused = w.this.t = i;
            if (w.this.p != null) {
                w.this.p.a(i);
            }
        }

        public void b(String str, long j, long j2) {
            if (w.this.p != null) {
                w.this.p.b(str, j, j2);
            }
        }

        public void b(Format format) {
            Format unused = w.this.f12291g = format;
            if (w.this.p != null) {
                w.this.p.b(format);
            }
        }

        public void a(int i, long j, long j2) {
            if (w.this.p != null) {
                w.this.p.a(i, j, j2);
            }
        }

        public void d(d dVar) {
            if (w.this.p != null) {
                w.this.p.d(dVar);
            }
            Format unused = w.this.f12291g = null;
            d unused2 = w.this.s = null;
            int unused3 = w.this.t = 0;
        }

        public void a(List<com.google.android.exoplayer2.p.b> list) {
            if (w.this.m != null) {
                w.this.m.a(list);
            }
        }

        public void a(Metadata metadata) {
            if (w.this.n != null) {
                w.this.n.a(metadata);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            w.this.a(surfaceHolder.getSurface(), false);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            w.this.a((Surface) null, false);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            w.this.a(new Surface(surfaceTexture), true);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            w.this.a((Surface) null, true);
            return true;
        }
    }
}
