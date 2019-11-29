package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.r.i;
import java.io.IOException;

public interface a {
    void a(int i, Format format, int i2, Object obj, long j);

    void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3);

    void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void b(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    /* renamed from: com.google.android.exoplayer2.source.a$a  reason: collision with other inner class name */
    public static final class C0185a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f11457a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final a f11458b;

        /* renamed from: c  reason: collision with root package name */
        private final long f11459c;

        public C0185a(Handler handler, a aVar) {
            this(handler, aVar, 0);
        }

        public C0185a(Handler handler, a aVar, long j) {
            this.f11457a = aVar != null ? (Handler) com.google.android.exoplayer2.s.a.a(handler) : null;
            this.f11458b = aVar;
            this.f11459c = j;
        }

        public C0185a a(long j) {
            return new C0185a(this.f11457a, this.f11458b, j);
        }

        public void a(i iVar, int i, long j) {
            a(iVar, i, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j);
        }

        public void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
            if (this.f11458b != null) {
                Handler handler = this.f11457a;
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j4 = j;
                final long j5 = j2;
                AnonymousClass1 r14 = r0;
                final long j6 = j3;
                AnonymousClass1 r0 = new Runnable() {
                    public void run() {
                        C0185a.this.f11458b.a(iVar2, i4, i5, format2, i6, obj2, C0185a.this.b(j4), C0185a.this.b(j5), j6);
                    }
                };
                handler.post(r14);
            }
        }

        public void a(i iVar, int i, long j, long j2, long j3) {
            a(iVar, i, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.f11458b != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                AnonymousClass2 r18 = r0;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                AnonymousClass2 r0 = new Runnable(this) {
                    final /* synthetic */ C0185a l;

                    {
                        this.l = r4;
                    }

                    public void run() {
                        this.l.f11458b.a(iVar2, i4, i5, format2, i6, obj2, this.l.b(j6), this.l.b(j7), j8, j9, j10);
                    }
                };
                this.f11457a.post(r18);
            }
        }

        public void b(i iVar, int i, long j, long j2, long j3) {
            b(iVar, i, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public void b(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.f11458b != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                AnonymousClass3 r18 = r0;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                AnonymousClass3 r0 = new Runnable(this) {
                    final /* synthetic */ C0185a l;

                    {
                        this.l = r4;
                    }

                    public void run() {
                        this.l.f11458b.b(iVar2, i4, i5, format2, i6, obj2, this.l.b(j6), this.l.b(j7), j8, j9, j10);
                    }
                };
                this.f11457a.post(r18);
            }
        }

        public void a(i iVar, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            a(iVar, i, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        public void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            if (this.f11458b != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
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
                    final /* synthetic */ C0185a n;

                    {
                        this.n = r4;
                    }

                    public void run() {
                        this.n.f11458b.a(iVar2, i4, i5, format2, i6, obj2, this.n.b(j6), this.n.b(j7), j8, j9, j10, iOException2, z2);
                    }
                };
                this.f11457a.post(r20);
            }
        }

        public void a(int i, Format format, int i2, Object obj, long j) {
            if (this.f11458b != null) {
                final int i3 = i;
                final Format format2 = format;
                final int i4 = i2;
                final Object obj2 = obj;
                final long j2 = j;
                this.f11457a.post(new Runnable() {
                    public void run() {
                        C0185a.this.f11458b.a(i3, format2, i4, obj2, C0185a.this.b(j2));
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public long b(long j) {
            long a2 = b.a(j);
            if (a2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f11459c + a2;
        }
    }
}
