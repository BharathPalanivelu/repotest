package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.z;
import java.io.IOException;

public interface r {
    void onDownstreamFormatChanged(int i, j jVar, int i2, Object obj, long j);

    void onLoadCanceled(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void onLoadCompleted(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void onLoadError(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void onLoadStarted(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f12121a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final r f12122b;

        /* renamed from: c  reason: collision with root package name */
        private final long f12123c;

        public a(Handler handler, r rVar) {
            this(handler, rVar, 0);
        }

        public a(Handler handler, r rVar, long j) {
            this.f12121a = rVar != null ? (Handler) com.google.android.exoplayer2.n.a.a(handler) : null;
            this.f12122b = rVar;
            this.f12123c = j;
        }

        public a a(long j) {
            return new a(this.f12121a, this.f12122b, j);
        }

        public void a(i iVar, int i, long j) {
            a(iVar, i, -1, (j) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j);
        }

        public void a(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3) {
            if (this.f12122b != null) {
                Handler handler = this.f12121a;
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final j jVar2 = jVar;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j4 = j;
                final long j5 = j2;
                AnonymousClass1 r14 = r0;
                final long j6 = j3;
                AnonymousClass1 r0 = new Runnable() {
                    public void run() {
                        a.this.f12122b.onLoadStarted(iVar2, i4, i5, jVar2, i6, obj2, a.this.b(j4), a.this.b(j5), j6);
                    }
                };
                handler.post(r14);
            }
        }

        public void a(i iVar, int i, long j, long j2, long j3) {
            a(iVar, i, -1, (j) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public void a(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.f12122b != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final j jVar2 = jVar;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                AnonymousClass2 r18 = r0;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                AnonymousClass2 r0 = new Runnable(this) {
                    final /* synthetic */ a l;

                    {
                        this.l = r4;
                    }

                    public void run() {
                        this.l.f12122b.onLoadCompleted(iVar2, i4, i5, jVar2, i6, obj2, this.l.b(j6), this.l.b(j7), j8, j9, j10);
                    }
                };
                this.f12121a.post(r18);
            }
        }

        public void b(i iVar, int i, long j, long j2, long j3) {
            b(iVar, i, -1, (j) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public void b(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.f12122b != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final j jVar2 = jVar;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                AnonymousClass3 r18 = r0;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                AnonymousClass3 r0 = new Runnable(this) {
                    final /* synthetic */ a l;

                    {
                        this.l = r4;
                    }

                    public void run() {
                        this.l.f12122b.onLoadCanceled(iVar2, i4, i5, jVar2, i6, obj2, this.l.b(j6), this.l.b(j7), j8, j9, j10);
                    }
                };
                this.f12121a.post(r18);
            }
        }

        public void a(i iVar, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            a(iVar, i, -1, (j) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        public void a(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            if (this.f12122b != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final j jVar2 = jVar;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                AnonymousClass4 r20 = r0;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                final IOException iOException2 = iOException;
                final boolean z2 = z;
                AnonymousClass4 r0 = new Runnable(this) {
                    final /* synthetic */ a n;

                    {
                        this.n = r4;
                    }

                    public void run() {
                        this.n.f12122b.onLoadError(iVar2, i4, i5, jVar2, i6, obj2, this.n.b(j6), this.n.b(j7), j8, j9, j10, iOException2, z2);
                    }
                };
                this.f12121a.post(r20);
            }
        }

        public void a(int i, j jVar, int i2, Object obj, long j) {
            if (this.f12122b != null) {
                final int i3 = i;
                final j jVar2 = jVar;
                final int i4 = i2;
                final Object obj2 = obj;
                final long j2 = j;
                this.f12121a.post(new Runnable() {
                    public void run() {
                        a.this.f12122b.onDownstreamFormatChanged(i3, jVar2, i4, obj2, a.this.b(j2));
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public long b(long j) {
            long a2 = z.a(j);
            if (a2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f12123c + a2;
        }
    }
}
