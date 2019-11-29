package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.al;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.z;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.JobManager;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.imsdk.BaseConstants;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9000a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f9001b = false;
    private int A;
    private int B;
    private int C;
    private long D;
    private long E;
    private boolean F;
    private long G;
    private Method H;
    private int I;
    private long J;
    private long K;
    private int L;
    private long M;
    private long N;
    private int O;
    private int P;
    private long Q;
    private long R;
    private long S;
    private float T;
    private c[] U;
    private ByteBuffer[] V;
    private ByteBuffer W;
    private ByteBuffer X;
    private byte[] Y;
    private int Z;
    private int aa;
    private boolean ab;
    private boolean ac;
    private int ad;
    private boolean ae;
    private boolean af;
    private long ag;

    /* renamed from: c  reason: collision with root package name */
    private final b f9002c;

    /* renamed from: d  reason: collision with root package name */
    private final f f9003d;

    /* renamed from: e  reason: collision with root package name */
    private final k f9004e;

    /* renamed from: f  reason: collision with root package name */
    private final c[] f9005f;

    /* renamed from: g  reason: collision with root package name */
    private final f f9006g;
    /* access modifiers changed from: private */
    public final ConditionVariable h = new ConditionVariable(true);
    private final long[] i;
    private final a j;
    private final LinkedList<g> k;
    private AudioTrack l;
    private AudioTrack m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private int t;
    private long u;
    private al v;
    private al w;
    private long x;
    private long y;
    private ByteBuffer z;

    public interface f {
        void a();

        void a(int i);

        void a(int i, long j, long j2);
    }

    public static final class c extends Exception {
        public c(Throwable th) {
            super(th);
        }

        public c(String str) {
            super(str);
        }
    }

    public static final class d extends Exception {
        public final int audioTrackState;

        public d(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + SQLBuilder.PARENTHESES_RIGHT);
            this.audioTrackState = i;
        }
    }

    public static final class h extends Exception {
        public final int errorCode;

        public h(int i) {
            super("AudioTrack write failed: " + i);
            this.errorCode = i;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.e$e  reason: collision with other inner class name */
    public static final class C0156e extends RuntimeException {
        public C0156e(String str) {
            super(str);
        }
    }

    public e(b bVar, c[] cVarArr, f fVar) {
        this.f9002c = bVar;
        this.f9006g = fVar;
        if (t.f10975a >= 18) {
            try {
                this.H = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (t.f10975a >= 19) {
            this.j = new b();
        } else {
            this.j = new a();
        }
        this.f9003d = new f();
        this.f9004e = new k();
        this.f9005f = new c[(cVarArr.length + 3)];
        this.f9005f[0] = new i();
        c[] cVarArr2 = this.f9005f;
        cVarArr2[1] = this.f9003d;
        System.arraycopy(cVarArr, 0, cVarArr2, 2, cVarArr.length);
        this.f9005f[cVarArr.length + 2] = this.f9004e;
        this.i = new long[10];
        this.T = 1.0f;
        this.P = 0;
        this.r = 3;
        this.ad = 0;
        this.w = al.f9108a;
        this.aa = -1;
        this.U = new c[0];
        this.V = new ByteBuffer[0];
        this.k = new LinkedList<>();
    }

    public boolean a(String str) {
        b bVar = this.f9002c;
        return bVar != null && bVar.a(b(str));
    }

    public long a(boolean z2) {
        long j2;
        if (!p()) {
            return Long.MIN_VALUE;
        }
        if (this.m.getPlayState() == 3) {
            q();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.F) {
            j2 = c(this.j.f() + d(nanoTime - (this.j.e() / 1000)));
        } else {
            if (this.C == 0) {
                j2 = this.j.c();
            } else {
                j2 = nanoTime + this.D;
            }
            if (!z2) {
                j2 -= this.S;
            }
        }
        return this.Q + b(j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r9, int r10, int r11, int r12, int r13, int[] r14) throws com.google.android.exoplayer2.a.e.c {
        /*
            r8 = this;
            java.lang.String r0 = "audio/raw"
            boolean r0 = r0.equals(r9)
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x000f
            int r9 = b((java.lang.String) r9)
            goto L_0x0010
        L_0x000f:
            r9 = r12
        L_0x0010:
            r2 = 0
            if (r0 != 0) goto L_0x004f
            int r12 = com.google.android.exoplayer2.n.t.b(r12, r10)
            r8.I = r12
            com.google.android.exoplayer2.a.f r12 = r8.f9003d
            r12.a((int[]) r14)
            com.google.android.exoplayer2.a.c[] r12 = r8.f9005f
            int r14 = r12.length
            r4 = r9
            r3 = r10
            r9 = 0
            r10 = 0
        L_0x0025:
            if (r9 >= r14) goto L_0x0046
            r5 = r12[r9]
            boolean r6 = r5.a(r11, r3, r4)     // Catch:{ a -> 0x003f }
            r10 = r10 | r6
            boolean r6 = r5.a()
            if (r6 == 0) goto L_0x003c
            int r3 = r5.b()
            int r4 = r5.c()
        L_0x003c:
            int r9 = r9 + 1
            goto L_0x0025
        L_0x003f:
            r9 = move-exception
            com.google.android.exoplayer2.a.e$c r10 = new com.google.android.exoplayer2.a.e$c
            r10.<init>((java.lang.Throwable) r9)
            throw r10
        L_0x0046:
            if (r10 == 0) goto L_0x004b
            r8.k()
        L_0x004b:
            r12 = r10
            r10 = r3
            r9 = r4
            goto L_0x0050
        L_0x004f:
            r12 = 0
        L_0x0050:
            r14 = 252(0xfc, float:3.53E-43)
            r3 = 12
            switch(r10) {
                case 1: goto L_0x0083;
                case 2: goto L_0x0080;
                case 3: goto L_0x007d;
                case 4: goto L_0x007a;
                case 5: goto L_0x0077;
                case 6: goto L_0x0074;
                case 7: goto L_0x0071;
                case 8: goto L_0x006e;
                default: goto L_0x0057;
            }
        L_0x0057:
            com.google.android.exoplayer2.a.e$c r9 = new com.google.android.exoplayer2.a.e$c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Unsupported channel count: "
            r11.append(r12)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>((java.lang.String) r10)
            throw r9
        L_0x006e:
            int r4 = com.google.android.exoplayer2.z.f12315a
            goto L_0x0084
        L_0x0071:
            r4 = 1276(0x4fc, float:1.788E-42)
            goto L_0x0084
        L_0x0074:
            r4 = 252(0xfc, float:3.53E-43)
            goto L_0x0084
        L_0x0077:
            r4 = 220(0xdc, float:3.08E-43)
            goto L_0x0084
        L_0x007a:
            r4 = 204(0xcc, float:2.86E-43)
            goto L_0x0084
        L_0x007d:
            r4 = 28
            goto L_0x0084
        L_0x0080:
            r4 = 12
            goto L_0x0084
        L_0x0083:
            r4 = 4
        L_0x0084:
            int r5 = com.google.android.exoplayer2.n.t.f10975a
            r6 = 23
            r7 = 5
            if (r5 > r6) goto L_0x00ab
            java.lang.String r5 = com.google.android.exoplayer2.n.t.f10976b
            java.lang.String r6 = "foster"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00ab
            java.lang.String r5 = com.google.android.exoplayer2.n.t.f10977c
            java.lang.String r6 = "NVIDIA"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00ab
            r5 = 3
            if (r10 == r5) goto L_0x00ac
            if (r10 == r7) goto L_0x00ac
            r14 = 7
            if (r10 == r14) goto L_0x00a8
            goto L_0x00ab
        L_0x00a8:
            int r14 = com.google.android.exoplayer2.z.f12315a
            goto L_0x00ac
        L_0x00ab:
            r14 = r4
        L_0x00ac:
            int r4 = com.google.android.exoplayer2.n.t.f10975a
            r5 = 25
            if (r4 > r5) goto L_0x00c2
            java.lang.String r4 = com.google.android.exoplayer2.n.t.f10976b
            java.lang.String r5 = "fugu"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00c2
            if (r0 == 0) goto L_0x00c2
            if (r10 != r1) goto L_0x00c2
            r14 = 12
        L_0x00c2:
            if (r12 != 0) goto L_0x00d7
            boolean r12 = r8.s()
            if (r12 == 0) goto L_0x00d7
            int r12 = r8.p
            if (r12 != r9) goto L_0x00d7
            int r12 = r8.n
            if (r12 != r11) goto L_0x00d7
            int r12 = r8.o
            if (r12 != r14) goto L_0x00d7
            return
        L_0x00d7:
            r8.i()
            r8.p = r9
            r8.s = r0
            r8.n = r11
            r8.o = r14
            r12 = 2
            if (r0 == 0) goto L_0x00e6
            goto L_0x00e7
        L_0x00e6:
            r9 = 2
        L_0x00e7:
            r8.q = r9
            int r9 = com.google.android.exoplayer2.n.t.b(r12, r10)
            r8.L = r9
            if (r13 == 0) goto L_0x00f4
            r8.t = r13
            goto L_0x0141
        L_0x00f4:
            if (r0 == 0) goto L_0x0109
            int r9 = r8.q
            if (r9 == r7) goto L_0x0104
            r10 = 6
            if (r9 != r10) goto L_0x00fe
            goto L_0x0104
        L_0x00fe:
            r9 = 49152(0xc000, float:6.8877E-41)
            r8.t = r9
            goto L_0x0141
        L_0x0104:
            r9 = 20480(0x5000, float:2.8699E-41)
            r8.t = r9
            goto L_0x0141
        L_0x0109:
            int r9 = r8.q
            int r9 = android.media.AudioTrack.getMinBufferSize(r11, r14, r9)
            r10 = -2
            if (r9 == r10) goto L_0x0113
            goto L_0x0114
        L_0x0113:
            r1 = 0
        L_0x0114:
            com.google.android.exoplayer2.n.a.b(r1)
            int r10 = r9 * 4
            r11 = 250000(0x3d090, double:1.235164E-318)
            long r11 = r8.d(r11)
            int r12 = (int) r11
            int r11 = r8.L
            int r11 = r11 * r12
            long r12 = (long) r9
            r1 = 750000(0xb71b0, double:3.70549E-318)
            long r1 = r8.d(r1)
            int r9 = r8.L
            long r3 = (long) r9
            long r1 = r1 * r3
            long r12 = java.lang.Math.max(r12, r1)
            int r9 = (int) r12
            if (r10 >= r11) goto L_0x013b
            r9 = r11
            goto L_0x013f
        L_0x013b:
            if (r10 <= r9) goto L_0x013e
            goto L_0x013f
        L_0x013e:
            r9 = r10
        L_0x013f:
            r8.t = r9
        L_0x0141:
            if (r0 == 0) goto L_0x0149
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0153
        L_0x0149:
            int r9 = r8.t
            int r10 = r8.L
            int r9 = r9 / r10
            long r9 = (long) r9
            long r9 = r8.c(r9)
        L_0x0153:
            r8.u = r9
            com.google.android.exoplayer2.al r9 = r8.w
            r8.a((com.google.android.exoplayer2.al) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.e.a(java.lang.String, int, int, int, int, int[]):void");
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.f9005f) {
            if (cVar.a()) {
                arrayList.add(cVar);
            } else {
                cVar.g();
            }
        }
        int size = arrayList.size();
        this.U = (c[]) arrayList.toArray(new c[size]);
        this.V = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            c cVar2 = this.U[i2];
            cVar2.g();
            this.V[i2] = cVar2.e();
        }
    }

    private void l() throws d {
        this.h.block();
        if (this.ae) {
            this.m = a(this.n, this.o, this.q, this.t, this.ad);
        } else {
            int i2 = this.ad;
            if (i2 == 0) {
                this.m = new AudioTrack(this.r, this.n, this.o, this.q, this.t, 1);
            } else {
                this.m = new AudioTrack(this.r, this.n, this.o, this.q, this.t, 1, i2);
            }
        }
        r();
        int audioSessionId = this.m.getAudioSessionId();
        if (f9000a && t.f10975a < 21) {
            AudioTrack audioTrack = this.l;
            if (!(audioTrack == null || audioSessionId == audioTrack.getAudioSessionId())) {
                o();
            }
            if (this.l == null) {
                this.l = new AudioTrack(this.r, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        if (this.ad != audioSessionId) {
            this.ad = audioSessionId;
            this.f9006g.a(audioSessionId);
        }
        this.j.a(this.m, w());
        n();
        this.af = false;
    }

    public void a() {
        this.ac = true;
        if (s()) {
            this.R = System.nanoTime() / 1000;
            this.m.play();
        }
    }

    public void b() {
        if (this.P == 1) {
            this.P = 2;
        }
    }

    public boolean a(ByteBuffer byteBuffer, long j2) throws d, h {
        int i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j2;
        ByteBuffer byteBuffer3 = this.W;
        com.google.android.exoplayer2.n.a.a(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!s()) {
            l();
            if (this.ac) {
                a();
            }
        }
        if (w()) {
            if (this.m.getPlayState() == 2) {
                this.af = false;
                return false;
            } else if (this.m.getPlayState() == 1 && this.j.b() != 0) {
                return false;
            }
        }
        boolean z2 = this.af;
        this.af = e();
        if (z2 && !this.af && this.m.getPlayState() != 1) {
            this.f9006g.a(this.t, z.a(this.u), SystemClock.elapsedRealtime() - this.ag);
        }
        if (this.W == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.s && this.O == 0) {
                this.O = a(this.q, byteBuffer2);
            }
            if (this.v != null) {
                if (!m()) {
                    return false;
                }
                LinkedList<g> linkedList = this.k;
                g gVar = r11;
                g gVar2 = new g(this.v, Math.max(0, j3), c(u()));
                linkedList.add(gVar);
                this.v = null;
                k();
            }
            if (this.P == 0) {
                this.Q = Math.max(0, j3);
                this.P = 1;
            } else {
                long c2 = this.Q + c(t());
                if (this.P != 1 || Math.abs(c2 - j3) <= 200000) {
                    i2 = 2;
                } else {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + c2 + ", got " + j3 + "]");
                    i2 = 2;
                    this.P = 2;
                }
                if (this.P == i2) {
                    this.Q += j3 - c2;
                    this.P = 1;
                    this.f9006g.a();
                }
            }
            if (this.s) {
                this.K += (long) this.O;
            } else {
                this.J += (long) byteBuffer.remaining();
            }
            this.W = byteBuffer2;
        }
        if (this.s) {
            b(this.W, j3);
        } else {
            a(j3);
        }
        if (this.W.hasRemaining()) {
            return false;
        }
        this.W = null;
        return true;
    }

    private void a(long j2) throws h {
        ByteBuffer byteBuffer;
        int length = this.U.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.V[i2 - 1];
            } else {
                byteBuffer = this.W;
                if (byteBuffer == null) {
                    byteBuffer = c.f8981a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j2);
            } else {
                c cVar = this.U[i2];
                cVar.a(byteBuffer);
                ByteBuffer e2 = cVar.e();
                this.V[i2] = e2;
                if (e2.hasRemaining()) {
                    i2++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i2--;
            } else {
                return;
            }
        }
    }

    private boolean b(ByteBuffer byteBuffer, long j2) throws h {
        int i2;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.X;
        if (byteBuffer2 != null) {
            com.google.android.exoplayer2.n.a.a(byteBuffer2 == byteBuffer);
        } else {
            this.X = byteBuffer;
            if (t.f10975a < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.Y;
                if (bArr == null || bArr.length < remaining) {
                    this.Y = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.Y, 0, remaining);
                byteBuffer.position(position);
                this.Z = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (t.f10975a < 21) {
            int b2 = this.t - ((int) (this.M - (this.j.b() * ((long) this.L))));
            if (b2 > 0) {
                i2 = this.m.write(this.Y, this.Z, Math.min(remaining2, b2));
                if (i2 > 0) {
                    this.Z += i2;
                    byteBuffer.position(byteBuffer.position() + i2);
                }
            } else {
                i2 = 0;
            }
        } else if (this.ae) {
            com.google.android.exoplayer2.n.a.b(j2 != -9223372036854775807L);
            i2 = a(this.m, byteBuffer, remaining2, j2);
        } else {
            i2 = a(this.m, byteBuffer, remaining2);
        }
        this.ag = SystemClock.elapsedRealtime();
        if (i2 >= 0) {
            if (!this.s) {
                this.M += (long) i2;
            }
            if (i2 != remaining2) {
                return false;
            }
            if (this.s) {
                this.N += (long) this.O;
            }
            this.X = null;
            return true;
        }
        throw new h(i2);
    }

    public void c() throws h {
        if (!this.ab && s() && m()) {
            this.j.a(u());
            this.A = 0;
            this.ab = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m() throws com.google.android.exoplayer2.a.e.h {
        /*
            r9 = this;
            int r0 = r9.aa
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.s
            if (r0 == 0) goto L_0x000f
            com.google.android.exoplayer2.a.c[] r0 = r9.U
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.aa = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.aa
            com.google.android.exoplayer2.a.c[] r5 = r9.U
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.d()
        L_0x0028:
            r9.a((long) r7)
            boolean r0 = r4.f()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.aa
            int r0 = r0 + r2
            r9.aa = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.X
            if (r0 == 0) goto L_0x0044
            r9.b((java.nio.ByteBuffer) r0, (long) r7)
            java.nio.ByteBuffer r0 = r9.X
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.aa = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.e.m():boolean");
    }

    public boolean d() {
        return !s() || (this.ab && !e());
    }

    public boolean e() {
        return s() && (u() > this.j.b() || x());
    }

    public al a(al alVar) {
        if (this.s) {
            this.w = al.f9108a;
            return this.w;
        }
        al alVar2 = new al(this.f9004e.a(alVar.f9109b), this.f9004e.b(alVar.f9110c));
        al alVar3 = this.v;
        if (alVar3 == null) {
            alVar3 = !this.k.isEmpty() ? this.k.getLast().f9022a : this.w;
        }
        if (!alVar2.equals(alVar3)) {
            if (s()) {
                this.v = alVar2;
            } else {
                this.w = alVar2;
            }
        }
        return this.w;
    }

    public al f() {
        return this.w;
    }

    public void a(int i2) {
        if (this.r != i2) {
            this.r = i2;
            if (!this.ae) {
                i();
                this.ad = 0;
            }
        }
    }

    public void b(int i2) {
        com.google.android.exoplayer2.n.a.b(t.f10975a >= 21);
        if (!this.ae || this.ad != i2) {
            this.ae = true;
            this.ad = i2;
            i();
        }
    }

    public void g() {
        if (this.ae) {
            this.ae = false;
            this.ad = 0;
            i();
        }
    }

    public void a(float f2) {
        if (this.T != f2) {
            this.T = f2;
            n();
        }
    }

    private void n() {
        if (s()) {
            if (t.f10975a >= 21) {
                a(this.m, this.T);
            } else {
                b(this.m, this.T);
            }
        }
    }

    public void h() {
        this.ac = false;
        if (s()) {
            v();
            this.j.a();
        }
    }

    public void i() {
        if (s()) {
            this.J = 0;
            this.K = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            al alVar = this.v;
            if (alVar != null) {
                this.w = alVar;
                this.v = null;
            } else if (!this.k.isEmpty()) {
                this.w = this.k.getLast().f9022a;
            }
            this.k.clear();
            this.x = 0;
            this.y = 0;
            this.W = null;
            this.X = null;
            int i2 = 0;
            while (true) {
                c[] cVarArr = this.U;
                if (i2 >= cVarArr.length) {
                    break;
                }
                c cVar = cVarArr[i2];
                cVar.g();
                this.V[i2] = cVar.e();
                i2++;
            }
            this.ab = false;
            this.aa = -1;
            this.z = null;
            this.A = 0;
            this.P = 0;
            this.S = 0;
            v();
            if (this.m.getPlayState() == 3) {
                this.m.pause();
            }
            final AudioTrack audioTrack = this.m;
            this.m = null;
            this.j.a((AudioTrack) null, false);
            this.h.close();
            new Thread() {
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        e.this.h.open();
                    }
                }
            }.start();
        }
    }

    public void j() {
        i();
        o();
        for (c h2 : this.f9005f) {
            h2.h();
        }
        this.ad = 0;
        this.ac = false;
    }

    private void o() {
        final AudioTrack audioTrack = this.l;
        if (audioTrack != null) {
            this.l = null;
            new Thread() {
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean p() {
        return s() && this.P != 0;
    }

    private long b(long j2) {
        long j3;
        long j4;
        while (!this.k.isEmpty() && j2 >= this.k.getFirst().f9024c) {
            g remove = this.k.remove();
            this.w = remove.f9022a;
            this.y = remove.f9024c;
            this.x = remove.f9023b - this.Q;
        }
        if (this.w.f9109b == 1.0f) {
            return (j2 + this.x) - this.y;
        }
        if (!this.k.isEmpty() || this.f9004e.j() < IjkMediaMeta.AV_CH_SIDE_RIGHT) {
            j3 = this.x;
            double d2 = (double) this.w.f9109b;
            double d3 = (double) (j2 - this.y);
            Double.isNaN(d2);
            Double.isNaN(d3);
            j4 = (long) (d2 * d3);
        } else {
            j3 = this.x;
            j4 = t.a(j2 - this.y, this.f9004e.i(), this.f9004e.j());
        }
        return j3 + j4;
    }

    private void q() {
        long c2 = this.j.c();
        if (c2 != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.E >= BaseConstants.DEFAULT_MSG_TIMEOUT) {
                long[] jArr = this.i;
                int i2 = this.B;
                jArr[i2] = c2 - nanoTime;
                this.B = (i2 + 1) % 10;
                int i3 = this.C;
                if (i3 < 10) {
                    this.C = i3 + 1;
                }
                this.E = nanoTime;
                this.D = 0;
                int i4 = 0;
                while (true) {
                    int i5 = this.C;
                    if (i4 >= i5) {
                        break;
                    }
                    this.D += this.i[i4] / ((long) i5);
                    i4++;
                }
            }
            if (!w() && nanoTime - this.G >= 500000) {
                this.F = this.j.d();
                if (this.F) {
                    long e2 = this.j.e() / 1000;
                    long f2 = this.j.f();
                    if (e2 < this.R) {
                        this.F = false;
                    } else if (Math.abs(e2 - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + f2 + ", " + e2 + ", " + nanoTime + ", " + c2;
                        if (!f9001b) {
                            Log.w("AudioTrack", str);
                            this.F = false;
                        } else {
                            throw new C0156e(str);
                        }
                    } else if (Math.abs(c(f2) - c2) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + f2 + ", " + e2 + ", " + nanoTime + ", " + c2;
                        if (!f9001b) {
                            Log.w("AudioTrack", str2);
                            this.F = false;
                        } else {
                            throw new C0156e(str2);
                        }
                    }
                }
                Method method = this.H;
                if (method != null && !this.s) {
                    try {
                        this.S = (((long) ((Integer) method.invoke(this.m, (Object[]) null)).intValue()) * 1000) - this.u;
                        this.S = Math.max(this.S, 0);
                        if (this.S > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.S);
                            this.S = 0;
                        }
                    } catch (Exception unused) {
                        this.H = null;
                    }
                }
                this.G = nanoTime;
            }
        }
    }

    private void r() throws d {
        int state = this.m.getState();
        if (state != 1) {
            try {
                this.m.release();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.m = null;
                throw th;
            }
            this.m = null;
            throw new d(state, this.n, this.o, this.t);
        }
    }

    private boolean s() {
        return this.m != null;
    }

    private long c(long j2) {
        return (j2 * JobManager.NS_PER_MS) / ((long) this.n);
    }

    private long d(long j2) {
        return (j2 * ((long) this.n)) / JobManager.NS_PER_MS;
    }

    private long t() {
        return this.s ? this.K : this.J / ((long) this.I);
    }

    private long u() {
        return this.s ? this.N : this.M / ((long) this.L);
    }

    private void v() {
        this.D = 0;
        this.C = 0;
        this.B = 0;
        this.E = 0;
        this.F = false;
        this.G = 0;
    }

    private boolean w() {
        if (t.f10975a < 23) {
            int i2 = this.q;
            if (i2 == 5 || i2 == 6) {
                return true;
            }
        }
        return false;
    }

    private boolean x() {
        return w() && this.m.getPlayState() == 2 && this.m.getPlaybackHeadPosition() == 0;
    }

    @TargetApi(21)
    private static AudioTrack a(int i2, int i3, int i4, int i5, int i6) {
        return new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(i3).setEncoding(i4).setSampleRate(i2).build(), i5, 1, i6);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1095064472: goto L_0x002a;
                case 187078296: goto L_0x0020;
                case 1504578661: goto L_0x0016;
                case 1505942594: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 3
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "audio/eac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "audio/ac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0045
            if (r5 == r4) goto L_0x0043
            if (r5 == r3) goto L_0x0041
            if (r5 == r2) goto L_0x003e
            return r1
        L_0x003e:
            r5 = 8
            return r5
        L_0x0041:
            r5 = 7
            return r5
        L_0x0043:
            r5 = 6
            return r5
        L_0x0045:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.e.b(java.lang.String):int");
    }

    private static int a(int i2, ByteBuffer byteBuffer) {
        if (i2 == 7 || i2 == 8) {
            return g.a(byteBuffer);
        }
        if (i2 == 5) {
            return a.a();
        }
        if (i2 == 6) {
            return a.a(byteBuffer);
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i2);
    }

    @TargetApi(21)
    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @TargetApi(21)
    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.z == null) {
            this.z = ByteBuffer.allocate(16);
            this.z.order(ByteOrder.BIG_ENDIAN);
            this.z.putInt(1431633921);
        }
        if (this.A == 0) {
            this.z.putInt(4, i2);
            this.z.putLong(8, j2 * 1000);
            this.z.position(0);
            this.A = i2;
        }
        int remaining = this.z.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.z, remaining, 1);
            if (write < 0) {
                this.A = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i2);
        if (a2 < 0) {
            this.A = 0;
            return a2;
        }
        this.A -= a2;
        return a2;
    }

    @TargetApi(21)
    private static void a(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void b(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        protected AudioTrack f9011a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9012b;

        /* renamed from: c  reason: collision with root package name */
        private int f9013c;

        /* renamed from: d  reason: collision with root package name */
        private long f9014d;

        /* renamed from: e  reason: collision with root package name */
        private long f9015e;

        /* renamed from: f  reason: collision with root package name */
        private long f9016f;

        /* renamed from: g  reason: collision with root package name */
        private long f9017g;
        private long h;
        private long i;

        public boolean d() {
            return false;
        }

        private a() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.f9011a = audioTrack;
            this.f9012b = z;
            this.f9017g = -9223372036854775807L;
            this.f9014d = 0;
            this.f9015e = 0;
            this.f9016f = 0;
            if (audioTrack != null) {
                this.f9013c = audioTrack.getSampleRate();
            }
        }

        public void a(long j) {
            this.h = b();
            this.f9017g = SystemClock.elapsedRealtime() * 1000;
            this.i = j;
            this.f9011a.stop();
        }

        public void a() {
            if (this.f9017g == -9223372036854775807L) {
                this.f9011a.pause();
            }
        }

        public long b() {
            if (this.f9017g != -9223372036854775807L) {
                return Math.min(this.i, this.h + ((((SystemClock.elapsedRealtime() * 1000) - this.f9017g) * ((long) this.f9013c)) / JobManager.NS_PER_MS));
            }
            int playState = this.f9011a.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = 4294967295L & ((long) this.f9011a.getPlaybackHeadPosition());
            if (this.f9012b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f9016f = this.f9014d;
                }
                playbackHeadPosition += this.f9016f;
            }
            if (this.f9014d > playbackHeadPosition) {
                this.f9015e++;
            }
            this.f9014d = playbackHeadPosition;
            return playbackHeadPosition + (this.f9015e << 32);
        }

        public long c() {
            return (b() * JobManager.NS_PER_MS) / ((long) this.f9013c);
        }

        public long e() {
            throw new UnsupportedOperationException();
        }

        public long f() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    private static class b extends a {

        /* renamed from: b  reason: collision with root package name */
        private final AudioTimestamp f9018b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f9019c;

        /* renamed from: d  reason: collision with root package name */
        private long f9020d;

        /* renamed from: e  reason: collision with root package name */
        private long f9021e;

        public b() {
            super();
        }

        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.f9019c = 0;
            this.f9020d = 0;
            this.f9021e = 0;
        }

        public boolean d() {
            boolean timestamp = this.f9011a.getTimestamp(this.f9018b);
            if (timestamp) {
                long j = this.f9018b.framePosition;
                if (this.f9020d > j) {
                    this.f9019c++;
                }
                this.f9020d = j;
                this.f9021e = j + (this.f9019c << 32);
            }
            return timestamp;
        }

        public long e() {
            return this.f9018b.nanoTime;
        }

        public long f() {
            return this.f9021e;
        }
    }

    private static final class g {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final al f9022a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f9023b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f9024c;

        private g(al alVar, long j, long j2) {
            this.f9022a = alVar;
            this.f9023b = j;
            this.f9024c = j2;
        }
    }
}
