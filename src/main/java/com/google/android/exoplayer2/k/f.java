package com.google.android.exoplayer2.k;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.d.d;
import com.google.android.exoplayer2.j;

public interface f {
    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void onVideoDisabled(d dVar);

    void onVideoEnabled(d dVar);

    void onVideoInputFormatChanged(j jVar);

    void onVideoSizeChanged(int i, int i2, int i3, float f2);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f10668a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final f f10669b;

        public a(Handler handler, f fVar) {
            this.f10668a = fVar != null ? (Handler) com.google.android.exoplayer2.n.a.a(handler) : null;
            this.f10669b = fVar;
        }

        public void a(final d dVar) {
            if (this.f10669b != null) {
                this.f10668a.post(new Runnable() {
                    public void run() {
                        a.this.f10669b.onVideoEnabled(dVar);
                    }
                });
            }
        }

        public void a(String str, long j, long j2) {
            if (this.f10669b != null) {
                final String str2 = str;
                final long j3 = j;
                final long j4 = j2;
                this.f10668a.post(new Runnable() {
                    public void run() {
                        a.this.f10669b.onVideoDecoderInitialized(str2, j3, j4);
                    }
                });
            }
        }

        public void a(final j jVar) {
            if (this.f10669b != null) {
                this.f10668a.post(new Runnable() {
                    public void run() {
                        a.this.f10669b.onVideoInputFormatChanged(jVar);
                    }
                });
            }
        }

        public void a(final int i, final long j) {
            if (this.f10669b != null) {
                this.f10668a.post(new Runnable() {
                    public void run() {
                        a.this.f10669b.onDroppedFrames(i, j);
                    }
                });
            }
        }

        public void a(int i, int i2, int i3, float f2) {
            if (this.f10669b != null) {
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final float f3 = f2;
                this.f10668a.post(new Runnable() {
                    public void run() {
                        a.this.f10669b.onVideoSizeChanged(i4, i5, i6, f3);
                    }
                });
            }
        }

        public void a(final Surface surface) {
            if (this.f10669b != null) {
                this.f10668a.post(new Runnable() {
                    public void run() {
                        a.this.f10669b.onRenderedFirstFrame(surface);
                    }
                });
            }
        }

        public void b(final d dVar) {
            if (this.f10669b != null) {
                this.f10668a.post(new Runnable() {
                    public void run() {
                        dVar.a();
                        a.this.f10669b.onVideoDisabled(dVar);
                    }
                });
            }
        }
    }
}
