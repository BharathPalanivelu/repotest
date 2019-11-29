package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.d;

public interface e {
    void a(int i, int i2, int i3, float f2);

    void a(int i, long j);

    void a(Surface surface);

    void a(Format format);

    void a(d dVar);

    void a(String str, long j, long j2);

    void b(d dVar);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f12263a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final e f12264b;

        public a(Handler handler, e eVar) {
            this.f12263a = eVar != null ? (Handler) com.google.android.exoplayer2.s.a.a(handler) : null;
            this.f12264b = eVar;
        }

        public void a(final d dVar) {
            if (this.f12264b != null) {
                this.f12263a.post(new Runnable() {
                    public void run() {
                        a.this.f12264b.a(dVar);
                    }
                });
            }
        }

        public void a(String str, long j, long j2) {
            if (this.f12264b != null) {
                final String str2 = str;
                final long j3 = j;
                final long j4 = j2;
                this.f12263a.post(new Runnable() {
                    public void run() {
                        a.this.f12264b.a(str2, j3, j4);
                    }
                });
            }
        }

        public void a(final Format format) {
            if (this.f12264b != null) {
                this.f12263a.post(new Runnable() {
                    public void run() {
                        a.this.f12264b.a(format);
                    }
                });
            }
        }

        public void a(final int i, final long j) {
            if (this.f12264b != null) {
                this.f12263a.post(new Runnable() {
                    public void run() {
                        a.this.f12264b.a(i, j);
                    }
                });
            }
        }

        public void a(int i, int i2, int i3, float f2) {
            if (this.f12264b != null) {
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final float f3 = f2;
                this.f12263a.post(new Runnable() {
                    public void run() {
                        a.this.f12264b.a(i4, i5, i6, f3);
                    }
                });
            }
        }

        public void a(final Surface surface) {
            if (this.f12264b != null) {
                this.f12263a.post(new Runnable() {
                    public void run() {
                        a.this.f12264b.a(surface);
                    }
                });
            }
        }

        public void b(final d dVar) {
            if (this.f12264b != null) {
                this.f12263a.post(new Runnable() {
                    public void run() {
                        dVar.a();
                        a.this.f12264b.b(dVar);
                    }
                });
            }
        }
    }
}
