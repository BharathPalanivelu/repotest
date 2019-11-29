package com.garena.videolib.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.garena.videolib.b;
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
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.x;
import com.tencent.ugc.TXRecordCommon;

public class PlayerView extends FrameLayout implements w.b {

    /* renamed from: a  reason: collision with root package name */
    private f.a f8704a;

    /* renamed from: b  reason: collision with root package name */
    private String f8705b;

    /* renamed from: c  reason: collision with root package name */
    private a f8706c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public w f8707d;

    /* renamed from: e  reason: collision with root package name */
    private TextureView f8708e;

    /* renamed from: f  reason: collision with root package name */
    private AspectRatioFrameLayout f8709f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f8710g;
    /* access modifiers changed from: private */
    public int h = -1;

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

    public PlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(21)
    public PlayerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void a(Context context) {
        inflate(context, b.C0150b.player_layout, this);
        this.f8708e = (TextureView) findViewById(b.a.texture_view);
        this.f8709f = (AspectRatioFrameLayout) findViewById(b.a.video_frame);
        this.f8705b = v.a(getContext(), getContext().getPackageName());
        this.f8704a = new m(getContext(), (u<? super f>) null, new o(this.f8705b, (u<? super f>) null, TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_8000, true));
        this.f8706c = new a();
    }

    public void a(String str, int i, boolean z, int i2) {
        w wVar = this.f8707d;
        if (wVar != null) {
            wVar.b((r.a) this.f8706c);
            this.f8707d.a((w.b) null);
            this.f8707d.d();
        }
        setAutoPlay(z);
        this.h = i2;
        this.f8707d = g.a(new d(getContext()), new c(new a.C0184a(new k())));
        this.f8707d.a((r.a) this.f8706c);
        this.f8707d.a((w.b) this);
        if (i2 > 0) {
            this.f8707d.a((long) i2);
        }
        this.f8707d.a(a(Uri.parse(str), i, this.f8705b));
        this.f8707d.a(this.f8708e);
        this.f8707d.a(z);
    }

    private i a(Uri uri, int i, String str) {
        if (i == -1) {
            i = v.b(uri);
        }
        if (i == 0) {
            return new com.google.android.exoplayer2.source.dash.c(uri, new m(getContext(), (u<? super f>) null, new o(str, (u<? super f>) null, TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_8000, true)), new f.a(this.f8704a), (Handler) null, (com.google.android.exoplayer2.source.a) null);
        } else if (i == 2) {
            return new h(uri, this.f8704a, (Handler) null, (com.google.android.exoplayer2.source.a) null);
        } else {
            if (i == 3) {
                return new com.google.android.exoplayer2.source.g(uri, this.f8704a, new com.google.android.exoplayer2.i.c(), (Handler) null, (g.a) null);
            }
            throw new IllegalStateException("Unsupported type: " + i);
        }
    }

    public void a() {
        w wVar = this.f8707d;
        if (wVar != null) {
            wVar.c();
            this.f8707d = null;
        }
    }

    public w getPlayer() {
        return this.f8707d;
    }

    public void a(int i, int i2, int i3, float f2) {
        float width = (float) this.f8708e.getWidth();
        float f3 = width / 2.0f;
        float height = (float) this.f8708e.getHeight();
        float f4 = height / 2.0f;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i3, f3, f4);
        float f5 = 1.0f;
        if (i3 == 90 || i3 == 270) {
            float f6 = height / width;
            matrix.postScale(1.0f / f6, f6, f3, f4);
            AspectRatioFrameLayout aspectRatioFrameLayout = this.f8709f;
            if (i != 0) {
                f5 = (((float) i2) * f2) / ((float) i);
            }
            aspectRatioFrameLayout.setAspectRatio(f5);
        } else {
            AspectRatioFrameLayout aspectRatioFrameLayout2 = this.f8709f;
            if (i2 != 0) {
                f5 = (((float) i) * f2) / ((float) i2);
            }
            aspectRatioFrameLayout2.setAspectRatio(f5);
        }
        this.f8708e.setTransform(matrix);
    }

    public void setAutoPlay(boolean z) {
        this.f8710g = z;
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
            if (PlayerView.this.f8710g && PlayerView.this.h > 0 && i == 3 && z) {
                PlayerView.this.f8707d.a((long) PlayerView.this.h);
                int unused = PlayerView.this.h = -1;
            }
        }

        public void a(e eVar) {
            Log.d("TEST2", "ERROR: " + eVar.getMessage());
        }
    }
}
