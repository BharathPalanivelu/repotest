package com.google.android.exoplayer2.b;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.d;

public interface e {
    void a(int i);

    void a(int i, long j, long j2);

    void b(Format format);

    void b(String str, long j, long j2);

    void c(d dVar);

    void d(d dVar);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f9164a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final e f9165b;

        public a(Handler handler, e eVar) {
            this.f9164a = eVar != null ? (Handler) com.google.android.exoplayer2.s.a.a(handler) : null;
            this.f9165b = eVar;
        }

        public void a(final d dVar) {
            if (this.f9165b != null) {
                this.f9164a.post(new Runnable() {
                    public void run() {
                        a.this.f9165b.c(dVar);
                    }
                });
            }
        }

        public void a(String str, long j, long j2) {
            if (this.f9165b != null) {
                final String str2 = str;
                final long j3 = j;
                final long j4 = j2;
                this.f9164a.post(new Runnable() {
                    public void run() {
                        a.this.f9165b.b(str2, j3, j4);
                    }
                });
            }
        }

        public void a(final Format format) {
            if (this.f9165b != null) {
                this.f9164a.post(new Runnable() {
                    public void run() {
                        a.this.f9165b.b(format);
                    }
                });
            }
        }

        public void a(int i, long j, long j2) {
            if (this.f9165b != null) {
                final int i2 = i;
                final long j3 = j;
                final long j4 = j2;
                this.f9164a.post(new Runnable() {
                    public void run() {
                        a.this.f9165b.a(i2, j3, j4);
                    }
                });
            }
        }

        public void b(final d dVar) {
            if (this.f9165b != null) {
                this.f9164a.post(new Runnable() {
                    public void run() {
                        dVar.a();
                        a.this.f9165b.d(dVar);
                    }
                });
            }
        }

        public void a(final int i) {
            if (this.f9165b != null) {
                this.f9164a.post(new Runnable() {
                    public void run() {
                        a.this.f9165b.a(i);
                    }
                });
            }
        }
    }
}
