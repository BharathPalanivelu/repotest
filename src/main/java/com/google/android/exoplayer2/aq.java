package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.a.d;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.j.j;
import com.google.android.exoplayer2.l.h;
import com.google.android.exoplayer2.source.y;
import java.util.List;

@TargetApi(16)
public class aq implements ad {

    /* renamed from: a  reason: collision with root package name */
    protected final am[] f9114a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f9115b;

    /* renamed from: c  reason: collision with root package name */
    private final a f9116c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final int f9117d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9118e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public j f9119f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public j f9120g;
    /* access modifiers changed from: private */
    public Surface h;
    private boolean i;
    private int j;
    private SurfaceHolder k;
    private TextureView l;
    /* access modifiers changed from: private */
    public j.a m;
    /* access modifiers changed from: private */
    public f.a n;
    /* access modifiers changed from: private */
    public b o;
    /* access modifiers changed from: private */
    public d p;
    /* access modifiers changed from: private */
    public com.google.android.exoplayer2.k.f q;
    /* access modifiers changed from: private */
    public com.google.android.exoplayer2.d.d r;
    /* access modifiers changed from: private */
    public com.google.android.exoplayer2.d.d s;
    /* access modifiers changed from: private */
    public int t;
    private int u;
    private float v;

    public interface b {
        void onRenderedFirstFrame();

        void onVideoSizeChanged(int i, int i2, int i3, float f2);
    }

    protected aq(ap apVar, h hVar, aj ajVar) {
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        a aVar = this.f9116c;
        this.f9114a = apVar.a(handler, aVar, aVar, aVar, aVar);
        int i2 = 0;
        int i3 = 0;
        for (am a2 : this.f9114a) {
            int a3 = a2.a();
            if (a3 == 1) {
                i3++;
            } else if (a3 == 2) {
                i2++;
            }
        }
        this.f9117d = i2;
        this.f9118e = i3;
        this.v = 1.0f;
        this.t = 0;
        this.u = 3;
        this.j = 1;
        this.f9115b = new af(this.f9114a, hVar, ajVar);
    }

    public void a(Surface surface) {
        j();
        a(surface, false);
    }

    public void a(float f2) {
        this.v = f2;
        ad.c[] cVarArr = new ad.c[this.f9118e];
        int i2 = 0;
        for (am amVar : this.f9114a) {
            if (amVar.a() == 1) {
                cVarArr[i2] = new ad.c(amVar, 2, Float.valueOf(f2));
                i2++;
            }
        }
        this.f9115b.a(cVarArr);
    }

    public j h() {
        return this.f9119f;
    }

    public com.google.android.exoplayer2.d.d i() {
        return this.r;
    }

    public void a(b bVar) {
        this.o = bVar;
    }

    public void a(f.a aVar) {
        this.n = aVar;
    }

    public void a(com.google.android.exoplayer2.k.f fVar) {
        this.q = fVar;
    }

    public void a(d dVar) {
        this.p = dVar;
    }

    public void a(ad.a aVar) {
        this.f9115b.a(aVar);
    }

    public void b(ad.a aVar) {
        this.f9115b.b(aVar);
    }

    public int a() {
        return this.f9115b.a();
    }

    public void a(y yVar) {
        this.f9115b.a(yVar);
    }

    public void a(y yVar, boolean z, boolean z2) {
        this.f9115b.a(yVar, z, z2);
    }

    public void a(boolean z) {
        this.f9115b.a(z);
    }

    public boolean b() {
        return this.f9115b.b();
    }

    public void a(long j2) {
        this.f9115b.a(j2);
    }

    public void a(al alVar) {
        this.f9115b.a(alVar);
    }

    public al c() {
        return this.f9115b.c();
    }

    public void d() {
        this.f9115b.d();
        j();
        Surface surface = this.h;
        if (surface != null) {
            if (this.i) {
                surface.release();
            }
            this.h = null;
        }
    }

    public void a(ad.c... cVarArr) {
        this.f9115b.a(cVarArr);
    }

    public void b(ad.c... cVarArr) {
        this.f9115b.b(cVarArr);
    }

    public long e() {
        return this.f9115b.e();
    }

    public long f() {
        return this.f9115b.f();
    }

    public int g() {
        return this.f9115b.g();
    }

    private void j() {
        TextureView textureView = this.l;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f9116c) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.l.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.l = null;
        }
        SurfaceHolder surfaceHolder = this.k;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f9116c);
            this.k = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        ad.c[] cVarArr = new ad.c[this.f9117d];
        int i2 = 0;
        for (am amVar : this.f9114a) {
            if (amVar.a() == 2) {
                cVarArr[i2] = new ad.c(amVar, 1, surface);
                i2++;
            }
        }
        Surface surface2 = this.h;
        if (surface2 == null || surface2 == surface) {
            this.f9115b.a(cVarArr);
        } else {
            if (this.i) {
                surface2.release();
            }
            this.f9115b.b(cVarArr);
        }
        this.h = surface;
        this.i = z;
    }

    private final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, d, f.a, j.a, com.google.android.exoplayer2.k.f {
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private a() {
        }

        public void onVideoEnabled(com.google.android.exoplayer2.d.d dVar) {
            com.google.android.exoplayer2.d.d unused = aq.this.r = dVar;
            if (aq.this.q != null) {
                aq.this.q.onVideoEnabled(dVar);
            }
        }

        public void onVideoDecoderInitialized(String str, long j, long j2) {
            if (aq.this.q != null) {
                aq.this.q.onVideoDecoderInitialized(str, j, j2);
            }
        }

        public void onVideoInputFormatChanged(j jVar) {
            j unused = aq.this.f9119f = jVar;
            if (aq.this.q != null) {
                aq.this.q.onVideoInputFormatChanged(jVar);
            }
        }

        public void onDroppedFrames(int i, long j) {
            if (aq.this.q != null) {
                aq.this.q.onDroppedFrames(i, j);
            }
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f2) {
            if (aq.this.o != null) {
                aq.this.o.onVideoSizeChanged(i, i2, i3, f2);
            }
            if (aq.this.q != null) {
                aq.this.q.onVideoSizeChanged(i, i2, i3, f2);
            }
        }

        public void onRenderedFirstFrame(Surface surface) {
            if (aq.this.o != null && aq.this.h == surface) {
                aq.this.o.onRenderedFirstFrame();
            }
            if (aq.this.q != null) {
                aq.this.q.onRenderedFirstFrame(surface);
            }
        }

        public void onVideoDisabled(com.google.android.exoplayer2.d.d dVar) {
            if (aq.this.q != null) {
                aq.this.q.onVideoDisabled(dVar);
            }
            j unused = aq.this.f9119f = null;
            com.google.android.exoplayer2.d.d unused2 = aq.this.r = null;
        }

        public void onAudioEnabled(com.google.android.exoplayer2.d.d dVar) {
            com.google.android.exoplayer2.d.d unused = aq.this.s = dVar;
            if (aq.this.p != null) {
                aq.this.p.onAudioEnabled(dVar);
            }
        }

        public void onAudioSessionId(int i) {
            int unused = aq.this.t = i;
            if (aq.this.p != null) {
                aq.this.p.onAudioSessionId(i);
            }
        }

        public void onAudioDecoderInitialized(String str, long j, long j2) {
            if (aq.this.p != null) {
                aq.this.p.onAudioDecoderInitialized(str, j, j2);
            }
        }

        public void onAudioInputFormatChanged(j jVar) {
            j unused = aq.this.f9120g = jVar;
            if (aq.this.p != null) {
                aq.this.p.onAudioInputFormatChanged(jVar);
            }
        }

        public void onAudioTrackUnderrun(int i, long j, long j2) {
            if (aq.this.p != null) {
                aq.this.p.onAudioTrackUnderrun(i, j, j2);
            }
        }

        public void onAudioDisabled(com.google.android.exoplayer2.d.d dVar) {
            if (aq.this.p != null) {
                aq.this.p.onAudioDisabled(dVar);
            }
            j unused = aq.this.f9120g = null;
            com.google.android.exoplayer2.d.d unused2 = aq.this.s = null;
            int unused3 = aq.this.t = 0;
        }

        public void a(List<com.google.android.exoplayer2.j.a> list) {
            if (aq.this.m != null) {
                aq.this.m.a(list);
            }
        }

        public void onMetadata(com.google.android.exoplayer2.f.a aVar) {
            if (aq.this.n != null) {
                aq.this.n.onMetadata(aVar);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            aq.this.a(surfaceHolder.getSurface(), false);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            aq.this.a((Surface) null, false);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            aq.this.a(new Surface(surfaceTexture), true);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            aq.this.a((Surface) null, true);
            return true;
        }
    }
}
