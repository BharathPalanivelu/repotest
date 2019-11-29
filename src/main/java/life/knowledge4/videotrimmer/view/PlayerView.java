package life.knowledge4.videotrimmer.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.q.c;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.k;
import com.google.android.exoplayer2.r.m;
import com.google.android.exoplayer2.r.o;
import com.google.android.exoplayer2.r.u;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.c.h;
import com.google.android.exoplayer2.source.dash.f;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.x;
import com.tencent.ugc.TXRecordCommon;
import life.knowledge4.videotrimmer.a;

public class PlayerView extends FrameLayout implements w.b {

    /* renamed from: a  reason: collision with root package name */
    private f.a f33774a;

    /* renamed from: b  reason: collision with root package name */
    private String f33775b;

    /* renamed from: c  reason: collision with root package name */
    private a f33776c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public w f33777d;

    /* renamed from: e  reason: collision with root package name */
    private TextureView f33778e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f33779f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f33780g = -1;
    /* access modifiers changed from: private */
    public boolean h;
    /* access modifiers changed from: private */
    public b i;

    public interface b {
        void b();
    }

    public void b() {
    }

    public PlayerView(Context context) {
        super(context);
        a(context);
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @TargetApi(21)
    public PlayerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context);
    }

    private void a(Context context) {
        inflate(context, a.e.player_layout, this);
        this.f33778e = (TextureView) findViewById(a.d.texture_view);
        this.f33775b = v.a(getContext(), getContext().getPackageName());
        this.f33774a = new m(getContext(), (u<? super f>) null, new o(this.f33775b, (u<? super f>) null, TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_8000, true));
        this.f33776c = new a();
        this.h = false;
    }

    public void a(String str, int i2, boolean z, int i3) {
        w wVar = this.f33777d;
        if (wVar != null) {
            wVar.b((r.a) this.f33776c);
            this.f33777d.a((w.b) null);
            this.f33777d.d();
        }
        setAutoPlay(z);
        this.f33780g = i3;
        this.f33777d = g.a(new d(getContext()), new c(new a.C0184a(new k())));
        this.f33777d.a((r.a) this.f33776c);
        this.f33777d.a((w.b) this);
        if (i3 > 0) {
            this.f33777d.a((long) i3);
        }
        this.f33777d.a(a(Uri.parse(str), i2, this.f33775b));
        this.f33777d.a(this.f33778e);
        this.f33777d.a(z);
    }

    private i a(Uri uri, int i2, String str) {
        if (i2 == -1) {
            i2 = v.b(uri);
        }
        if (i2 == 0) {
            return new com.google.android.exoplayer2.source.dash.c(uri, new m(getContext(), (u<? super f>) null, new o(str, (u<? super f>) null, TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_8000, true)), new f.a(this.f33774a), (Handler) null, (com.google.android.exoplayer2.source.a) null);
        } else if (i2 == 2) {
            return new h(uri, this.f33774a, (Handler) null, (com.google.android.exoplayer2.source.a) null);
        } else {
            if (i2 == 3) {
                return new com.google.android.exoplayer2.source.g(uri, this.f33774a, new com.google.android.exoplayer2.i.c(), (Handler) null, (g.a) null);
            }
            throw new IllegalStateException("Unsupported type: " + i2);
        }
    }

    public w getPlayer() {
        return this.f33777d;
    }

    public void setInitListener(b bVar) {
        this.i = bVar;
    }

    public void a(int i2, int i3, int i4, float f2) {
        float f3;
        float f4;
        int width = this.f33778e.getWidth();
        int height = this.f33778e.getHeight();
        if (i4 == 90 || i4 == 270) {
            int i5 = i3;
            i3 = i2;
            i2 = i5;
        }
        if (i2 > i3) {
            f3 = (((((float) i3) * 1.0f) / ((float) i2)) * ((float) width)) / ((float) height);
            f4 = 1.0f;
        } else {
            f4 = (((((float) i2) * 1.0f) / ((float) i3)) * ((float) height)) / ((float) width);
            f3 = 1.0f;
        }
        float f5 = (float) width;
        float f6 = f5 / 2.0f;
        float f7 = (float) height;
        float f8 = f7 / 2.0f;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i4, f6, f8);
        if (i4 == 90 || i4 == 270) {
            float f9 = f7 / f5;
            matrix.postScale(1.0f / f9, f9, f6, f8);
        }
        matrix.postScale(f4, f3, f6, f8);
        this.f33778e.setTransform(matrix);
    }

    public void setAutoPlay(boolean z) {
        this.f33779f = z;
    }

    private class a implements r.a {
        public void a() {
        }

        public void a(q qVar) {
        }

        public void a(p pVar, com.google.android.exoplayer2.q.g gVar) {
        }

        public void a(x xVar, Object obj) {
        }

        public void a(boolean z) {
        }

        private a() {
        }

        public void a(boolean z, int i) {
            Log.d("TEST2", "STATE: " + z + " | " + i);
            if (PlayerView.this.f33779f && PlayerView.this.f33780g > 0 && i == 3 && z) {
                PlayerView.this.f33777d.a((long) PlayerView.this.f33780g);
                int unused = PlayerView.this.f33780g = -1;
            }
            if (i == 3 && !PlayerView.this.h) {
                boolean unused2 = PlayerView.this.h = true;
                if (PlayerView.this.i != null) {
                    PlayerView.this.i.b();
                }
            }
        }

        public void a(e eVar) {
            Log.d("TEST2", "ERROR: " + eVar.getMessage());
        }
    }
}
