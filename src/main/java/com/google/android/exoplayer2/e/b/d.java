package com.google.android.exoplayer2.e.b;

import android.util.SparseArray;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.z;
import com.path.android.jobqueue.JobManager;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9344a = new i() {
        public f[] a() {
            return new f[]{new d()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f9345b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f9346c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final UUID f9347d = new UUID(72057594037932032L, -9223371306706625679L);
    private long A;
    private boolean B;
    private long C;
    private long D;
    private long E;
    private com.google.android.exoplayer2.n.f F;
    private com.google.android.exoplayer2.n.f G;
    private boolean H;
    private int I;
    private long J;
    private long K;
    private int L;
    private int M;
    private int[] N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private byte W;
    private int X;
    private int Y;
    private int Z;
    private boolean aa;
    private boolean ab;
    private h ac;

    /* renamed from: e  reason: collision with root package name */
    private final b f9348e;

    /* renamed from: f  reason: collision with root package name */
    private final f f9349f;

    /* renamed from: g  reason: collision with root package name */
    private final SparseArray<b> f9350g;
    private final boolean h;
    private final k i;
    private final k j;
    private final k k;
    private final k l;
    private final k m;
    private final k n;
    private final k o;
    private final k p;
    private final k q;
    private ByteBuffer r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private b x;
    private boolean y;
    private int z;

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        switch (i2) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case JfifUtil.MARKER_RST7:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case JfifUtil.MARKER_APP1:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    public void c() {
    }

    public d() {
        this(0);
    }

    public d(int i2) {
        this(new a(), i2);
    }

    d(b bVar, int i2) {
        this.t = -1;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.C = -1;
        this.D = -1;
        this.E = -9223372036854775807L;
        this.f9348e = bVar;
        this.f9348e.a((c) new a());
        this.h = (i2 & 1) != 0 ? false : true;
        this.f9349f = new f();
        this.f9350g = new SparseArray<>();
        this.k = new k(4);
        this.l = new k(ByteBuffer.allocate(4).putInt(-1).array());
        this.m = new k(4);
        this.i = new k(com.google.android.exoplayer2.n.i.f10930a);
        this.j = new k(4);
        this.n = new k();
        this.o = new k();
        this.p = new k(8);
        this.q = new k();
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        return new e().a(gVar);
    }

    public void a(h hVar) {
        this.ac = hVar;
    }

    public void a(long j2, long j3) {
        this.E = -9223372036854775807L;
        this.I = 0;
        this.f9348e.a();
        this.f9349f.a();
        b();
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        this.aa = false;
        boolean z2 = true;
        while (z2 && !this.aa) {
            z2 = this.f9348e.a(gVar);
            if (z2 && a(lVar, gVar.c())) {
                return 1;
            }
        }
        if (z2) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2, long j3) throws ak {
        if (i2 == 160) {
            this.ab = false;
        } else if (i2 == 174) {
            this.x = new b();
        } else if (i2 == 187) {
            this.H = false;
        } else if (i2 == 19899) {
            this.z = -1;
            this.A = -1;
        } else if (i2 == 20533) {
            this.x.f9356e = true;
        } else if (i2 == 21968) {
            this.x.q = true;
        } else if (i2 == 25152) {
        } else {
            if (i2 == 408125543) {
                long j4 = this.t;
                if (j4 == -1 || j4 == j2) {
                    this.t = j2;
                    this.s = j3;
                    return;
                }
                throw new ak("Multiple Segment elements not supported");
            } else if (i2 == 475249515) {
                this.F = new com.google.android.exoplayer2.n.f();
                this.G = new com.google.android.exoplayer2.n.f();
            } else if (i2 != 524531317 || this.y) {
            } else {
                if (!this.h || this.C == -1) {
                    this.ac.a(new m.a(this.w));
                    this.y = true;
                    return;
                }
                this.B = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) throws ak {
        if (i2 != 160) {
            if (i2 == 174) {
                if (a(this.x.f9352a)) {
                    b bVar = this.x;
                    bVar.a(this.ac, bVar.f9353b);
                    this.f9350g.put(this.x.f9353b, this.x);
                }
                this.x = null;
            } else if (i2 == 19899) {
                int i3 = this.z;
                if (i3 != -1) {
                    long j2 = this.A;
                    if (j2 != -1) {
                        if (i3 == 475249515) {
                            this.C = j2;
                            return;
                        }
                        return;
                    }
                }
                throw new ak("Mandatory element SeekID or SeekPosition not found");
            } else if (i2 != 25152) {
                if (i2 != 28032) {
                    if (i2 == 357149030) {
                        if (this.u == -9223372036854775807L) {
                            this.u = JobManager.NS_PER_MS;
                        }
                        long j3 = this.v;
                        if (j3 != -9223372036854775807L) {
                            this.w = a(j3);
                        }
                    } else if (i2 != 374648427) {
                        if (i2 == 475249515 && !this.y) {
                            this.ac.a(d());
                            this.y = true;
                        }
                    } else if (this.f9350g.size() != 0) {
                        this.ac.a();
                    } else {
                        throw new ak("No valid tracks were found");
                    }
                } else if (this.x.f9356e && this.x.f9357f != null) {
                    throw new ak("Combining encryption and compression is not supported");
                }
            } else if (!this.x.f9356e) {
            } else {
                if (this.x.f9358g != null) {
                    this.x.i = new com.google.android.exoplayer2.c.a(new a.C0159a(z.f12316b, "video/webm", this.x.f9358g));
                    return;
                }
                throw new ak("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (this.I == 2) {
            if (!this.ab) {
                this.Q |= 1;
            }
            a(this.f9350g.get(this.O), this.J);
            this.I = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) throws ak {
        if (i2 != 20529) {
            if (i2 != 20530) {
                boolean z2 = false;
                switch (i2) {
                    case 131:
                        this.x.f9354c = (int) j2;
                        return;
                    case 136:
                        b bVar = this.x;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        bVar.L = z2;
                        return;
                    case 155:
                        this.K = a(j2);
                        return;
                    case 159:
                        this.x.G = (int) j2;
                        return;
                    case 176:
                        this.x.j = (int) j2;
                        return;
                    case 179:
                        this.F.a(a(j2));
                        return;
                    case 186:
                        this.x.k = (int) j2;
                        return;
                    case JfifUtil.MARKER_RST7:
                        this.x.f9353b = (int) j2;
                        return;
                    case 231:
                        this.E = a(j2);
                        return;
                    case 241:
                        if (!this.H) {
                            this.G.a(j2);
                            this.H = true;
                            return;
                        }
                        return;
                    case 251:
                        this.ab = true;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            throw new ak("ContentCompAlgo " + j2 + " not supported");
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            throw new ak("DocTypeReadVersion " + j2 + " not supported");
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            throw new ak("EBMLReadVersion " + j2 + " not supported");
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            throw new ak("ContentEncAlgo " + j2 + " not supported");
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            throw new ak("AESSettingsCipherMode " + j2 + " not supported");
                        }
                        return;
                    case 21420:
                        this.A = j2 + this.t;
                        return;
                    case 21432:
                        int i3 = (int) j2;
                        if (i3 == 0) {
                            this.x.p = 0;
                            return;
                        } else if (i3 == 1) {
                            this.x.p = 2;
                            return;
                        } else if (i3 == 3) {
                            this.x.p = 1;
                            return;
                        } else if (i3 == 15) {
                            this.x.p = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.x.l = (int) j2;
                        return;
                    case 21682:
                        this.x.n = (int) j2;
                        return;
                    case 21690:
                        this.x.m = (int) j2;
                        return;
                    case 21930:
                        b bVar2 = this.x;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        bVar2.M = z2;
                        return;
                    case 22186:
                        this.x.J = j2;
                        return;
                    case 22203:
                        this.x.K = j2;
                        return;
                    case 25188:
                        this.x.H = (int) j2;
                        return;
                    case 2352003:
                        this.x.f9355d = (int) j2;
                        return;
                    case 2807729:
                        this.u = j2;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                int i4 = (int) j2;
                                if (i4 == 1) {
                                    this.x.t = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.x.t = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i5 = (int) j2;
                                if (i5 != 1) {
                                    if (i5 == 16) {
                                        this.x.s = 6;
                                        return;
                                    } else if (i5 == 18) {
                                        this.x.s = 7;
                                        return;
                                    } else if (!(i5 == 6 || i5 == 7)) {
                                        return;
                                    }
                                }
                                this.x.s = 3;
                                return;
                            case 21947:
                                b bVar3 = this.x;
                                bVar3.q = true;
                                int i6 = (int) j2;
                                if (i6 == 1) {
                                    bVar3.r = 1;
                                    return;
                                } else if (i6 == 9) {
                                    bVar3.r = 6;
                                    return;
                                } else if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                    this.x.r = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.x.u = (int) j2;
                                return;
                            case 21949:
                                this.x.v = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                throw new ak("ContentEncodingScope " + j2 + " not supported");
            }
        } else if (j2 != 0) {
            throw new ak("ContentEncodingOrder " + j2 + " not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, double d2) {
        if (i2 == 181) {
            this.x.I = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    this.x.w = (float) d2;
                    return;
                case 21970:
                    this.x.x = (float) d2;
                    return;
                case 21971:
                    this.x.y = (float) d2;
                    return;
                case 21972:
                    this.x.z = (float) d2;
                    return;
                case 21973:
                    this.x.A = (float) d2;
                    return;
                case 21974:
                    this.x.B = (float) d2;
                    return;
                case 21975:
                    this.x.C = (float) d2;
                    return;
                case 21976:
                    this.x.D = (float) d2;
                    return;
                case 21977:
                    this.x.E = (float) d2;
                    return;
                case 21978:
                    this.x.F = (float) d2;
                    return;
                default:
                    return;
            }
        } else {
            this.v = (long) d2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str) throws ak {
        if (i2 == 134) {
            this.x.f9352a = str;
        } else if (i2 != 17026) {
            if (i2 == 2274716) {
                String unused = this.x.P = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new ak("DocType " + str + " not supported");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0204, code lost:
        throw new com.google.android.exoplayer2.ak("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r20, int r21, com.google.android.exoplayer2.e.g r22) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 4
            r7 = 0
            if (r1 == r4) goto L_0x0090
            if (r1 == r5) goto L_0x0090
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0083
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0076
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0057
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x004a
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0033
            com.google.android.exoplayer2.e.b.d$b r1 = r0.x
            byte[] r4 = new byte[r2]
            r1.o = r4
            byte[] r1 = r1.o
            r3.b(r1, r7, r2)
            goto L_0x02bd
        L_0x0033:
            com.google.android.exoplayer2.ak r2 = new com.google.android.exoplayer2.ak
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unexpected id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x004a:
            com.google.android.exoplayer2.e.b.d$b r1 = r0.x
            byte[] r4 = new byte[r2]
            r1.h = r4
            byte[] r1 = r1.h
            r3.b(r1, r7, r2)
            goto L_0x02bd
        L_0x0057:
            com.google.android.exoplayer2.n.k r1 = r0.m
            byte[] r1 = r1.f10948a
            java.util.Arrays.fill(r1, r7)
            com.google.android.exoplayer2.n.k r1 = r0.m
            byte[] r1 = r1.f10948a
            int r6 = r6 - r2
            r3.b(r1, r6, r2)
            com.google.android.exoplayer2.n.k r1 = r0.m
            r1.c(r7)
            com.google.android.exoplayer2.n.k r1 = r0.m
            long r1 = r1.l()
            int r2 = (int) r1
            r0.z = r2
            goto L_0x02bd
        L_0x0076:
            com.google.android.exoplayer2.e.b.d$b r1 = r0.x
            byte[] r4 = new byte[r2]
            r1.f9358g = r4
            byte[] r1 = r1.f9358g
            r3.b(r1, r7, r2)
            goto L_0x02bd
        L_0x0083:
            com.google.android.exoplayer2.e.b.d$b r1 = r0.x
            byte[] r4 = new byte[r2]
            r1.f9357f = r4
            byte[] r1 = r1.f9357f
            r3.b(r1, r7, r2)
            goto L_0x02bd
        L_0x0090:
            int r4 = r0.I
            r8 = 8
            r9 = 1
            if (r4 != 0) goto L_0x00b6
            com.google.android.exoplayer2.e.b.f r4 = r0.f9349f
            long r10 = r4.a(r3, r7, r9, r8)
            int r4 = (int) r10
            r0.O = r4
            com.google.android.exoplayer2.e.b.f r4 = r0.f9349f
            int r4 = r4.b()
            r0.P = r4
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.K = r10
            r0.I = r9
            com.google.android.exoplayer2.n.k r4 = r0.k
            r4.a()
        L_0x00b6:
            android.util.SparseArray<com.google.android.exoplayer2.e.b.d$b> r4 = r0.f9350g
            int r10 = r0.O
            java.lang.Object r4 = r4.get(r10)
            com.google.android.exoplayer2.e.b.d$b r4 = (com.google.android.exoplayer2.e.b.d.b) r4
            if (r4 != 0) goto L_0x00cc
            int r1 = r0.P
            int r1 = r2 - r1
            r3.b(r1)
            r0.I = r7
            return
        L_0x00cc:
            int r10 = r0.I
            if (r10 != r9) goto L_0x028b
            r10 = 3
            r0.a((com.google.android.exoplayer2.e.g) r3, (int) r10)
            com.google.android.exoplayer2.n.k r11 = r0.k
            byte[] r11 = r11.f10948a
            r12 = 2
            byte r11 = r11[r12]
            r11 = r11 & 6
            int r11 = r11 >> r9
            r13 = 255(0xff, float:3.57E-43)
            if (r11 != 0) goto L_0x00f6
            r0.M = r9
            int[] r6 = r0.N
            int[] r6 = a((int[]) r6, (int) r9)
            r0.N = r6
            int[] r6 = r0.N
            int r11 = r0.P
            int r2 = r2 - r11
            int r2 = r2 - r10
            r6[r7] = r2
            goto L_0x0217
        L_0x00f6:
            if (r1 != r5) goto L_0x0283
            r0.a((com.google.android.exoplayer2.e.g) r3, (int) r6)
            com.google.android.exoplayer2.n.k r14 = r0.k
            byte[] r14 = r14.f10948a
            byte r14 = r14[r10]
            r14 = r14 & r13
            int r14 = r14 + r9
            r0.M = r14
            int[] r14 = r0.N
            int r15 = r0.M
            int[] r14 = a((int[]) r14, (int) r15)
            r0.N = r14
            if (r11 != r12) goto L_0x011f
            int r10 = r0.P
            int r2 = r2 - r10
            int r2 = r2 - r6
            int r6 = r0.M
            int r2 = r2 / r6
            int[] r10 = r0.N
            java.util.Arrays.fill(r10, r7, r6, r2)
            goto L_0x0217
        L_0x011f:
            if (r11 != r9) goto L_0x0157
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x0124:
            int r14 = r0.M
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x014b
            int[] r14 = r0.N
            r14[r6] = r7
        L_0x012e:
            int r10 = r10 + r9
            r0.a((com.google.android.exoplayer2.e.g) r3, (int) r10)
            com.google.android.exoplayer2.n.k r14 = r0.k
            byte[] r14 = r14.f10948a
            int r15 = r10 + -1
            byte r14 = r14[r15]
            r14 = r14 & r13
            int[] r15 = r0.N
            r16 = r15[r6]
            int r16 = r16 + r14
            r15[r6] = r16
            if (r14 == r13) goto L_0x012e
            r14 = r15[r6]
            int r11 = r11 + r14
            int r6 = r6 + 1
            goto L_0x0124
        L_0x014b:
            int[] r6 = r0.N
            int r14 = r14 - r9
            int r15 = r0.P
            int r2 = r2 - r15
            int r2 = r2 - r10
            int r2 = r2 - r11
            r6[r14] = r2
            goto L_0x0217
        L_0x0157:
            if (r11 != r10) goto L_0x026c
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x015c:
            int r14 = r0.M
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x020d
            int[] r14 = r0.N
            r14[r6] = r7
            int r10 = r10 + 1
            r0.a((com.google.android.exoplayer2.e.g) r3, (int) r10)
            com.google.android.exoplayer2.n.k r14 = r0.k
            byte[] r14 = r14.f10948a
            int r15 = r10 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x0205
            r16 = 0
            r14 = 0
        L_0x0178:
            if (r14 >= r8) goto L_0x01cf
            int r18 = 7 - r14
            int r18 = r9 << r18
            com.google.android.exoplayer2.n.k r5 = r0.k
            byte[] r5 = r5.f10948a
            byte r5 = r5[r15]
            r5 = r5 & r18
            if (r5 == 0) goto L_0x01c4
            int r10 = r10 + r14
            r0.a((com.google.android.exoplayer2.e.g) r3, (int) r10)
            com.google.android.exoplayer2.n.k r5 = r0.k
            byte[] r5 = r5.f10948a
            int r16 = r15 + 1
            byte r5 = r5[r15]
            r5 = r5 & r13
            r15 = r18 ^ -1
            r5 = r5 & r15
            long r12 = (long) r5
            r5 = r16
            r16 = r12
        L_0x019d:
            if (r5 >= r10) goto L_0x01b6
            long r12 = r16 << r8
            com.google.android.exoplayer2.n.k r15 = r0.k
            byte[] r15 = r15.f10948a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            r15 = 255(0xff, float:3.57E-43)
            r5 = r5 & r15
            long r7 = (long) r5
            long r7 = r7 | r12
            r5 = r16
            r16 = r7
            r7 = 0
            r8 = 8
            goto L_0x019d
        L_0x01b6:
            if (r6 <= 0) goto L_0x01cf
            int r14 = r14 * 7
            int r14 = r14 + 6
            r7 = 1
            long r12 = r7 << r14
            long r12 = r12 - r7
            long r16 = r16 - r12
            goto L_0x01cf
        L_0x01c4:
            int r14 = r14 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 8
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0178
        L_0x01cf:
            r7 = r16
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x01fd
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x01fd
            int r5 = (int) r7
            int[] r7 = r0.N
            if (r6 != 0) goto L_0x01e5
            goto L_0x01ea
        L_0x01e5:
            int r8 = r6 + -1
            r8 = r7[r8]
            int r5 = r5 + r8
        L_0x01ea:
            r7[r6] = r5
            int[] r5 = r0.N
            r5 = r5[r6]
            int r11 = r11 + r5
            int r6 = r6 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 8
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x015c
        L_0x01fd:
            com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0205:
            com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x020d:
            int[] r5 = r0.N
            int r14 = r14 - r9
            int r6 = r0.P
            int r2 = r2 - r6
            int r2 = r2 - r10
            int r2 = r2 - r11
            r5[r14] = r2
        L_0x0217:
            com.google.android.exoplayer2.n.k r2 = r0.k
            byte[] r2 = r2.f10948a
            r5 = 0
            byte r2 = r2[r5]
            r5 = 8
            int r2 = r2 << r5
            com.google.android.exoplayer2.n.k r5 = r0.k
            byte[] r5 = r5.f10948a
            byte r5 = r5[r9]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            r2 = r2 | r5
            long r5 = r0.E
            long r7 = (long) r2
            long r7 = r0.a((long) r7)
            long r5 = r5 + r7
            r0.J = r5
            com.google.android.exoplayer2.n.k r2 = r0.k
            byte[] r2 = r2.f10948a
            r5 = 2
            byte r2 = r2[r5]
            r6 = 8
            r2 = r2 & r6
            if (r2 != r6) goto L_0x0243
            r2 = 1
            goto L_0x0244
        L_0x0243:
            r2 = 0
        L_0x0244:
            int r6 = r4.f9354c
            if (r6 == r5) goto L_0x025a
            r6 = 163(0xa3, float:2.28E-43)
            if (r1 != r6) goto L_0x0258
            com.google.android.exoplayer2.n.k r6 = r0.k
            byte[] r6 = r6.f10948a
            byte r6 = r6[r5]
            r5 = 128(0x80, float:1.794E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x0258
            goto L_0x025a
        L_0x0258:
            r5 = 0
            goto L_0x025b
        L_0x025a:
            r5 = 1
        L_0x025b:
            if (r2 == 0) goto L_0x0260
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0261
        L_0x0260:
            r7 = 0
        L_0x0261:
            r2 = r5 | r7
            r0.Q = r2
            r2 = 2
            r0.I = r2
            r2 = 0
            r0.L = r2
            goto L_0x028b
        L_0x026c:
            com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected lacing value: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0283:
            com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x028b:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x02b5
        L_0x028f:
            int r1 = r0.L
            int r2 = r0.M
            if (r1 >= r2) goto L_0x02b1
            int[] r2 = r0.N
            r1 = r2[r1]
            r0.a((com.google.android.exoplayer2.e.g) r3, (com.google.android.exoplayer2.e.b.d.b) r4, (int) r1)
            long r1 = r0.J
            int r5 = r0.L
            int r6 = r4.f9355d
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.a((com.google.android.exoplayer2.e.b.d.b) r4, (long) r1)
            int r1 = r0.L
            int r1 = r1 + r9
            r0.L = r1
            goto L_0x028f
        L_0x02b1:
            r1 = 0
            r0.I = r1
            goto L_0x02bd
        L_0x02b5:
            r1 = 0
            int[] r2 = r0.N
            r1 = r2[r1]
            r0.a((com.google.android.exoplayer2.e.g) r3, (com.google.android.exoplayer2.e.b.d.b) r4, (int) r1)
        L_0x02bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.d.a(int, int, com.google.android.exoplayer2.e.g):void");
    }

    private void a(b bVar, long j2) {
        if ("S_TEXT/UTF8".equals(bVar.f9352a)) {
            a(bVar);
        }
        bVar.N.a(j2, this.Q, this.Z, 0, bVar.f9358g);
        this.aa = true;
        b();
    }

    private void b() {
        this.R = 0;
        this.Z = 0;
        this.Y = 0;
        this.S = false;
        this.T = false;
        this.V = false;
        this.X = 0;
        this.W = 0;
        this.U = false;
        this.n.a();
    }

    private void a(g gVar, int i2) throws IOException, InterruptedException {
        if (this.k.c() < i2) {
            if (this.k.e() < i2) {
                k kVar = this.k;
                kVar.a(Arrays.copyOf(kVar.f10948a, Math.max(this.k.f10948a.length * 2, i2)), this.k.c());
            }
            gVar.b(this.k.f10948a, this.k.c(), i2 - this.k.c());
            this.k.b(i2);
        }
    }

    private void a(g gVar, b bVar, int i2) throws IOException, InterruptedException {
        int i3;
        if ("S_TEXT/UTF8".equals(bVar.f9352a)) {
            int length = f9345b.length + i2;
            if (this.o.e() < length) {
                this.o.f10948a = Arrays.copyOf(f9345b, length + i2);
            }
            gVar.b(this.o.f10948a, f9345b.length, i2);
            this.o.c(0);
            this.o.b(length);
            return;
        }
        n nVar = bVar.N;
        if (!this.S) {
            if (bVar.f9356e) {
                this.Q &= -1073741825;
                int i4 = 128;
                if (!this.T) {
                    gVar.b(this.k.f10948a, 0, 1);
                    this.R++;
                    if ((this.k.f10948a[0] & 128) != 128) {
                        this.W = this.k.f10948a[0];
                        this.T = true;
                    } else {
                        throw new ak("Extension bit is set in signal byte");
                    }
                }
                if ((this.W & 1) == 1) {
                    boolean z2 = (this.W & 2) == 2;
                    this.Q |= 1073741824;
                    if (!this.U) {
                        gVar.b(this.p.f10948a, 0, 8);
                        this.R += 8;
                        this.U = true;
                        byte[] bArr = this.k.f10948a;
                        if (!z2) {
                            i4 = 0;
                        }
                        bArr[0] = (byte) (i4 | 8);
                        this.k.c(0);
                        nVar.a(this.k, 1);
                        this.Z++;
                        this.p.c(0);
                        nVar.a(this.p, 8);
                        this.Z += 8;
                    }
                    if (z2) {
                        if (!this.V) {
                            gVar.b(this.k.f10948a, 0, 1);
                            this.R++;
                            this.k.c(0);
                            this.X = this.k.g();
                            this.V = true;
                        }
                        int i5 = this.X * 4;
                        this.k.a(i5);
                        gVar.b(this.k.f10948a, 0, i5);
                        this.R += i5;
                        short s2 = (short) ((this.X / 2) + 1);
                        int i6 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.r;
                        if (byteBuffer == null || byteBuffer.capacity() < i6) {
                            this.r = ByteBuffer.allocate(i6);
                        }
                        this.r.position(0);
                        this.r.putShort(s2);
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            i3 = this.X;
                            if (i7 >= i3) {
                                break;
                            }
                            int t2 = this.k.t();
                            if (i7 % 2 == 0) {
                                this.r.putShort((short) (t2 - i8));
                            } else {
                                this.r.putInt(t2 - i8);
                            }
                            i7++;
                            i8 = t2;
                        }
                        int i9 = (i2 - this.R) - i8;
                        if (i3 % 2 == 1) {
                            this.r.putInt(i9);
                        } else {
                            this.r.putShort((short) i9);
                            this.r.putInt(0);
                        }
                        this.q.a(this.r.array(), i6);
                        nVar.a(this.q, i6);
                        this.Z += i6;
                    }
                }
            } else if (bVar.f9357f != null) {
                this.n.a(bVar.f9357f, bVar.f9357f.length);
            }
            this.S = true;
        }
        int c2 = i2 + this.n.c();
        if (!"V_MPEG4/ISO/AVC".equals(bVar.f9352a) && !"V_MPEGH/ISO/HEVC".equals(bVar.f9352a)) {
            while (true) {
                int i10 = this.R;
                if (i10 >= c2) {
                    break;
                }
                a(gVar, nVar, c2 - i10);
            }
        } else {
            byte[] bArr2 = this.j.f10948a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i11 = bVar.O;
            int i12 = 4 - bVar.O;
            while (this.R < c2) {
                int i13 = this.Y;
                if (i13 == 0) {
                    a(gVar, bArr2, i12, i11);
                    this.j.c(0);
                    this.Y = this.j.t();
                    this.i.c(0);
                    nVar.a(this.i, 4);
                    this.Z += 4;
                } else {
                    this.Y = i13 - a(gVar, nVar, i13);
                }
            }
        }
        if ("A_VORBIS".equals(bVar.f9352a)) {
            this.l.c(0);
            nVar.a(this.l, 4);
            this.Z += 4;
        }
    }

    private void a(b bVar) {
        a(this.o.f10948a, this.K);
        n nVar = bVar.N;
        k kVar = this.o;
        nVar.a(kVar, kVar.c());
        this.Z += this.o.c();
    }

    private static void a(byte[] bArr, long j2) {
        byte[] bArr2;
        if (j2 == -9223372036854775807L) {
            bArr2 = f9346c;
        } else {
            int i2 = (int) (j2 / 3600000000L);
            long j3 = j2 - (((long) i2) * 3600000000L);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - ((long) (60000000 * i3));
            int i4 = (int) (j4 / JobManager.NS_PER_MS);
            int i5 = (int) ((j4 - ((long) (1000000 * i4))) / 1000);
            bArr2 = t.c(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}));
        }
        System.arraycopy(bArr2, 0, bArr, 19, 12);
    }

    private void a(g gVar, byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int min = Math.min(i3, this.n.b());
        gVar.b(bArr, i2 + min, i3 - min);
        if (min > 0) {
            this.n.a(bArr, i2, min);
        }
        this.R += i3;
    }

    private int a(g gVar, n nVar, int i2) throws IOException, InterruptedException {
        int i3;
        int b2 = this.n.b();
        if (b2 > 0) {
            i3 = Math.min(i2, b2);
            nVar.a(this.n, i3);
        } else {
            i3 = nVar.a(gVar, i2, false);
        }
        this.R += i3;
        this.Z += i3;
        return i3;
    }

    private m d() {
        if (!(this.t == -1 || this.w == -9223372036854775807L)) {
            com.google.android.exoplayer2.n.f fVar = this.F;
            if (!(fVar == null || fVar.a() == 0)) {
                com.google.android.exoplayer2.n.f fVar2 = this.G;
                if (fVar2 != null && fVar2.a() == this.F.a()) {
                    int a2 = this.F.a();
                    int[] iArr = new int[a2];
                    long[] jArr = new long[a2];
                    long[] jArr2 = new long[a2];
                    long[] jArr3 = new long[a2];
                    int i2 = 0;
                    for (int i3 = 0; i3 < a2; i3++) {
                        jArr3[i3] = this.F.a(i3);
                        jArr[i3] = this.t + this.G.a(i3);
                    }
                    while (true) {
                        int i4 = a2 - 1;
                        if (i2 < i4) {
                            int i5 = i2 + 1;
                            iArr[i2] = (int) (jArr[i5] - jArr[i2]);
                            jArr2[i2] = jArr3[i5] - jArr3[i2];
                            i2 = i5;
                        } else {
                            iArr[i4] = (int) ((this.t + this.s) - jArr[i4]);
                            jArr2[i4] = this.w - jArr3[i4];
                            this.F = null;
                            this.G = null;
                            return new com.google.android.exoplayer2.e.a(iArr, jArr, jArr2, jArr3);
                        }
                    }
                }
            }
        }
        this.F = null;
        this.G = null;
        return new m.a(this.w);
    }

    private boolean a(l lVar, long j2) {
        if (this.B) {
            this.D = j2;
            lVar.f9779a = this.C;
            this.B = false;
            return true;
        }
        if (this.y) {
            long j3 = this.D;
            if (j3 != -1) {
                lVar.f9779a = j3;
                this.D = -1;
                return true;
            }
        }
        return false;
    }

    private long a(long j2) throws ak {
        long j3 = this.u;
        if (j3 != -9223372036854775807L) {
            return t.a(j2, j3, 1000);
        }
        throw new ak("Can't scale timecode prior to timecodeScale being set.");
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] a(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }

    private final class a implements c {
        private a() {
        }

        public int a(int i) {
            return d.this.a(i);
        }

        public boolean b(int i) {
            return d.this.b(i);
        }

        public void a(int i, long j, long j2) throws ak {
            d.this.a(i, j, j2);
        }

        public void c(int i) throws ak {
            d.this.c(i);
        }

        public void a(int i, long j) throws ak {
            d.this.a(i, j);
        }

        public void a(int i, double d2) throws ak {
            d.this.a(i, d2);
        }

        public void a(int i, String str) throws ak {
            d.this.a(i, str);
        }

        public void a(int i, int i2, g gVar) throws IOException, InterruptedException {
            d.this.a(i, i2, gVar);
        }
    }

    private static final class b {
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public long J;
        public long K;
        public boolean L;
        public boolean M;
        public n N;
        public int O;
        /* access modifiers changed from: private */
        public String P;

        /* renamed from: a  reason: collision with root package name */
        public String f9352a;

        /* renamed from: b  reason: collision with root package name */
        public int f9353b;

        /* renamed from: c  reason: collision with root package name */
        public int f9354c;

        /* renamed from: d  reason: collision with root package name */
        public int f9355d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9356e;

        /* renamed from: f  reason: collision with root package name */
        public byte[] f9357f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f9358g;
        public byte[] h;
        public com.google.android.exoplayer2.c.a i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public byte[] o;
        public int p;
        public boolean q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public float w;
        public float x;
        public float y;
        public float z;

        private b() {
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = null;
            this.p = -1;
            this.q = false;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 1000;
            this.v = 200;
            this.w = -1.0f;
            this.x = -1.0f;
            this.y = -1.0f;
            this.z = -1.0f;
            this.A = -1.0f;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 1;
            this.H = -1;
            this.I = TXRecordCommon.AUDIO_SAMPLERATE_8000;
            this.J = 0;
            this.K = 0;
            this.M = true;
            this.P = "eng";
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x021f, code lost:
            r3 = null;
            r21 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x022d, code lost:
            r21 = -1;
            r24 = -1;
            r32 = r3;
            r3 = r1;
            r1 = r32;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x02e0, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x02e2, code lost:
            r21 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x02e4, code lost:
            r24 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x02e6, code lost:
            r4 = r0.M | false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x02eb, code lost:
            if (r0.L == false) goto L_0x02ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x02ed, code lost:
            r7 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x02ee, code lost:
            r4 = r4 | r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x02f3, code lost:
            if (com.google.android.exoplayer2.n.h.a(r1) == false) goto L_0x031a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x02f5, code lost:
            r1 = com.google.android.exoplayer2.j.a(java.lang.Integer.toString(r35), r1, (java.lang.String) null, -1, r21, r0.G, r0.I, r24, r3, r0.i, r4 ? 1 : 0, r0.P);
            r8 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x031e, code lost:
            if (com.google.android.exoplayer2.n.h.b(r1) == false) goto L_0x0390;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0322, code lost:
            if (r0.n != 0) goto L_0x0334;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0324, code lost:
            r2 = r0.l;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x0326, code lost:
            if (r2 != -1) goto L_0x032a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x0328, code lost:
            r2 = r0.j;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x032a, code lost:
            r0.l = r2;
            r2 = r0.m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x032e, code lost:
            if (r2 != -1) goto L_0x0332;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0330, code lost:
            r2 = r0.k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x0332, code lost:
            r0.m = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0334, code lost:
            r4 = r0.l;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0338, code lost:
            if (r4 == -1) goto L_0x034c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x033a, code lost:
            r5 = r0.m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x033c, code lost:
            if (r5 == -1) goto L_0x034c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x033e, code lost:
            r27 = ((float) (r0.k * r4)) / ((float) (r0.j * r5));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x034c, code lost:
            r27 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0350, code lost:
            if (r0.q == false) goto L_0x0364;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0352, code lost:
            r30 = new com.google.android.exoplayer2.k.b(r0.r, r0.t, r0.s, a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0364, code lost:
            r30 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0366, code lost:
            r1 = com.google.android.exoplayer2.j.a(java.lang.Integer.toString(r35), r1, (java.lang.String) null, -1, r21, r0.j, r0.k, -1.0f, r3, -1, r27, r0.o, r0.p, r30, r0.i);
            r8 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0394, code lost:
            if ("application/x-subrip".equals(r1) == false) goto L_0x03af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0396, code lost:
            r1 = com.google.android.exoplayer2.j.a(java.lang.Integer.toString(r35), r1, (java.lang.String) null, -1, r4 ? 1 : 0, r0.P, r0.i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x03b3, code lost:
            if ("application/vobsub".equals(r1) != false) goto L_0x03ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x03b9, code lost:
            if ("application/pgs".equals(r1) != false) goto L_0x03ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x03bf, code lost:
            if ("application/dvbsubs".equals(r1) == false) goto L_0x03c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x03c9, code lost:
            throw new com.google.android.exoplayer2.ak("Unexpected MIME type.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x03ca, code lost:
            r1 = com.google.android.exoplayer2.j.a(java.lang.Integer.toString(r35), r1, (java.lang.String) null, -1, r3, r0.P, r0.i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x03e2, code lost:
            r0.N = r34.a(r0.f9353b, r8);
            r0.N.a(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x03f1, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a4, code lost:
            r24 = r1;
            r1 = "audio/raw";
            r3 = null;
            r21 = -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.google.android.exoplayer2.e.h r34, int r35) throws com.google.android.exoplayer2.ak {
            /*
                r33 = this;
                r0 = r33
                java.lang.String r1 = r0.f9352a
                int r2 = r1.hashCode()
                r3 = 4
                r4 = 8
                r5 = 1
                r6 = 2
                r7 = 0
                r8 = 3
                r9 = -1
                switch(r2) {
                    case -2095576542: goto L_0x014a;
                    case -2095575984: goto L_0x0140;
                    case -1985379776: goto L_0x0135;
                    case -1784763192: goto L_0x012a;
                    case -1730367663: goto L_0x011f;
                    case -1482641358: goto L_0x0114;
                    case -1482641357: goto L_0x0109;
                    case -1373388978: goto L_0x00fe;
                    case -933872740: goto L_0x00f3;
                    case -538363189: goto L_0x00e8;
                    case -538363109: goto L_0x00dd;
                    case -425012669: goto L_0x00d1;
                    case -356037306: goto L_0x00c5;
                    case 62923557: goto L_0x00b9;
                    case 62923603: goto L_0x00ad;
                    case 62927045: goto L_0x00a1;
                    case 82338133: goto L_0x0096;
                    case 82338134: goto L_0x008b;
                    case 99146302: goto L_0x007f;
                    case 444813526: goto L_0x0073;
                    case 542569478: goto L_0x0067;
                    case 725957860: goto L_0x005b;
                    case 855502857: goto L_0x0050;
                    case 1422270023: goto L_0x0044;
                    case 1809237540: goto L_0x0039;
                    case 1950749482: goto L_0x002d;
                    case 1950789798: goto L_0x0021;
                    case 1951062397: goto L_0x0015;
                    default: goto L_0x0013;
                }
            L_0x0013:
                goto L_0x0154
            L_0x0015:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 11
                goto L_0x0155
            L_0x0021:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 21
                goto L_0x0155
            L_0x002d:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 16
                goto L_0x0155
            L_0x0039:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 2
                goto L_0x0155
            L_0x0044:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 24
                goto L_0x0155
            L_0x0050:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 7
                goto L_0x0155
            L_0x005b:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 23
                goto L_0x0155
            L_0x0067:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 19
                goto L_0x0155
            L_0x0073:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 9
                goto L_0x0155
            L_0x007f:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 26
                goto L_0x0155
            L_0x008b:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 1
                goto L_0x0155
            L_0x0096:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 0
                goto L_0x0155
            L_0x00a1:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 18
                goto L_0x0155
            L_0x00ad:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 15
                goto L_0x0155
            L_0x00b9:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 12
                goto L_0x0155
            L_0x00c5:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 20
                goto L_0x0155
            L_0x00d1:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 25
                goto L_0x0155
            L_0x00dd:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 6
                goto L_0x0155
            L_0x00e8:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 4
                goto L_0x0155
            L_0x00f3:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 27
                goto L_0x0155
            L_0x00fe:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 8
                goto L_0x0155
            L_0x0109:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 14
                goto L_0x0155
            L_0x0114:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 13
                goto L_0x0155
            L_0x011f:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 10
                goto L_0x0155
            L_0x012a:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 17
                goto L_0x0155
            L_0x0135:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 22
                goto L_0x0155
            L_0x0140:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 3
                goto L_0x0155
            L_0x014a:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0154
                r1 = 5
                goto L_0x0155
            L_0x0154:
                r1 = -1
            L_0x0155:
                java.lang.String r2 = "application/dvbsubs"
                java.lang.String r10 = "application/pgs"
                java.lang.String r11 = "application/vobsub"
                java.lang.String r12 = "application/x-subrip"
                java.lang.String r13 = "audio/raw"
                r14 = 4096(0x1000, float:5.74E-42)
                java.lang.String r15 = "video/x-unknown"
                r16 = 0
                switch(r1) {
                    case 0: goto L_0x02de;
                    case 1: goto L_0x02db;
                    case 2: goto L_0x02d8;
                    case 3: goto L_0x02c9;
                    case 4: goto L_0x02c9;
                    case 5: goto L_0x02c9;
                    case 6: goto L_0x02b5;
                    case 7: goto L_0x02a1;
                    case 8: goto L_0x028d;
                    case 9: goto L_0x028b;
                    case 10: goto L_0x027d;
                    case 11: goto L_0x0238;
                    case 12: goto L_0x0225;
                    case 13: goto L_0x021d;
                    case 14: goto L_0x021a;
                    case 15: goto L_0x0216;
                    case 16: goto L_0x0212;
                    case 17: goto L_0x020e;
                    case 18: goto L_0x020a;
                    case 19: goto L_0x020a;
                    case 20: goto L_0x0206;
                    case 21: goto L_0x01fd;
                    case 22: goto L_0x01c6;
                    case 23: goto L_0x019c;
                    case 24: goto L_0x0199;
                    case 25: goto L_0x018f;
                    case 26: goto L_0x018c;
                    case 27: goto L_0x0170;
                    default: goto L_0x0168;
                }
            L_0x0168:
                com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
                java.lang.String r2 = "Unrecognized codec identifier."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x0170:
                byte[] r1 = new byte[r3]
                byte[] r3 = r0.h
                byte r4 = r3[r7]
                r1[r7] = r4
                byte r4 = r3[r5]
                r1[r5] = r4
                byte r4 = r3[r6]
                r1[r6] = r4
                byte r3 = r3[r8]
                r1[r8] = r3
                java.util.List r1 = java.util.Collections.singletonList(r1)
                r3 = r1
                r1 = r2
                goto L_0x02e2
            L_0x018c:
                r1 = r10
                goto L_0x02e0
            L_0x018f:
                byte[] r1 = r0.h
                java.util.List r1 = java.util.Collections.singletonList(r1)
                r3 = r1
                r1 = r11
                goto L_0x02e2
            L_0x0199:
                r1 = r12
                goto L_0x02e0
            L_0x019c:
                int r1 = r0.H
                int r1 = com.google.android.exoplayer2.n.t.b((int) r1)
                if (r1 == 0) goto L_0x01ad
            L_0x01a4:
                r24 = r1
                r1 = r13
                r3 = r16
                r21 = -1
                goto L_0x02e6
            L_0x01ad:
                com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r2.append(r3)
                int r3 = r0.H
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x01c6:
                com.google.android.exoplayer2.n.k r1 = new com.google.android.exoplayer2.n.k
                byte[] r3 = r0.h
                r1.<init>((byte[]) r3)
                boolean r1 = b(r1)
                if (r1 == 0) goto L_0x01f5
                int r1 = r0.H
                int r1 = com.google.android.exoplayer2.n.t.b((int) r1)
                if (r1 == 0) goto L_0x01dc
                goto L_0x01a4
            L_0x01dc:
                com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r2.append(r3)
                int r3 = r0.H
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x01f5:
                com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
                java.lang.String r2 = "Non-PCM MS/ACM is unsupported"
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x01fd:
                byte[] r1 = r0.h
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r3 = "audio/x-flac"
                goto L_0x022d
            L_0x0206:
                java.lang.String r1 = "audio/vnd.dts.hd"
                goto L_0x02e0
            L_0x020a:
                java.lang.String r1 = "audio/vnd.dts"
                goto L_0x02e0
            L_0x020e:
                java.lang.String r1 = "audio/true-hd"
                goto L_0x02e0
            L_0x0212:
                java.lang.String r1 = "audio/eac3"
                goto L_0x02e0
            L_0x0216:
                java.lang.String r1 = "audio/ac3"
                goto L_0x02e0
            L_0x021a:
                java.lang.String r1 = "audio/mpeg"
                goto L_0x021f
            L_0x021d:
                java.lang.String r1 = "audio/mpeg-L2"
            L_0x021f:
                r3 = r16
                r21 = 4096(0x1000, float:5.74E-42)
                goto L_0x02e4
            L_0x0225:
                byte[] r1 = r0.h
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r3 = "audio/mp4a-latm"
            L_0x022d:
                r21 = -1
                r24 = -1
                r32 = r3
                r3 = r1
                r1 = r32
                goto L_0x02e6
            L_0x0238:
                r1 = 5760(0x1680, float:8.071E-42)
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>(r8)
                byte[] r13 = r0.h
                r3.add(r13)
                java.nio.ByteBuffer r13 = java.nio.ByteBuffer.allocate(r4)
                java.nio.ByteOrder r14 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r13 = r13.order(r14)
                long r14 = r0.J
                java.nio.ByteBuffer r13 = r13.putLong(r14)
                byte[] r13 = r13.array()
                r3.add(r13)
                java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
                java.nio.ByteOrder r13 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r4 = r4.order(r13)
                long r13 = r0.K
                java.nio.ByteBuffer r4 = r4.putLong(r13)
                byte[] r4 = r4.array()
                r3.add(r4)
                java.lang.String r4 = "audio/opus"
                r1 = r4
                r21 = 5760(0x1680, float:8.071E-42)
                goto L_0x02e4
            L_0x027d:
                r1 = 8192(0x2000, float:1.14794E-41)
                byte[] r3 = r0.h
                java.util.List r3 = a((byte[]) r3)
                java.lang.String r4 = "audio/vorbis"
                r1 = r4
                r21 = 8192(0x2000, float:1.14794E-41)
                goto L_0x02e4
            L_0x028b:
                r1 = r15
                goto L_0x02e0
            L_0x028d:
                com.google.android.exoplayer2.n.k r1 = new com.google.android.exoplayer2.n.k
                byte[] r3 = r0.h
                r1.<init>((byte[]) r3)
                java.util.List r1 = a((com.google.android.exoplayer2.n.k) r1)
                if (r1 != 0) goto L_0x029b
                goto L_0x029e
            L_0x029b:
                java.lang.String r3 = "video/wvc1"
                r15 = r3
            L_0x029e:
                r3 = r1
                r1 = r15
                goto L_0x02e2
            L_0x02a1:
                com.google.android.exoplayer2.n.k r1 = new com.google.android.exoplayer2.n.k
                byte[] r3 = r0.h
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.k.c r1 = com.google.android.exoplayer2.k.c.a(r1)
                java.util.List<byte[]> r3 = r1.f10643a
                int r1 = r1.f10644b
                r0.O = r1
                java.lang.String r1 = "video/hevc"
                goto L_0x02e2
            L_0x02b5:
                com.google.android.exoplayer2.n.k r1 = new com.google.android.exoplayer2.n.k
                byte[] r3 = r0.h
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.k.a r1 = com.google.android.exoplayer2.k.a.a(r1)
                java.util.List<byte[]> r3 = r1.f10633a
                int r1 = r1.f10634b
                r0.O = r1
                java.lang.String r1 = "video/avc"
                goto L_0x02e2
            L_0x02c9:
                byte[] r1 = r0.h
                if (r1 != 0) goto L_0x02d0
                r1 = r16
                goto L_0x02d4
            L_0x02d0:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x02d4:
                java.lang.String r3 = "video/mp4v-es"
                goto L_0x022d
            L_0x02d8:
                java.lang.String r1 = "video/mpeg2"
                goto L_0x02e0
            L_0x02db:
                java.lang.String r1 = "video/x-vnd.on2.vp9"
                goto L_0x02e0
            L_0x02de:
                java.lang.String r1 = "video/x-vnd.on2.vp8"
            L_0x02e0:
                r3 = r16
            L_0x02e2:
                r21 = -1
            L_0x02e4:
                r24 = -1
            L_0x02e6:
                boolean r4 = r0.M
                r4 = r4 | r7
                boolean r13 = r0.L
                if (r13 == 0) goto L_0x02ee
                r7 = 2
            L_0x02ee:
                r4 = r4 | r7
                boolean r7 = com.google.android.exoplayer2.n.h.a(r1)
                if (r7 == 0) goto L_0x031a
                java.lang.String r17 = java.lang.Integer.toString(r35)
                r19 = 0
                r20 = -1
                int r2 = r0.G
                int r6 = r0.I
                com.google.android.exoplayer2.c.a r7 = r0.i
                java.lang.String r8 = r0.P
                r18 = r1
                r22 = r2
                r23 = r6
                r25 = r3
                r26 = r7
                r27 = r4
                r28 = r8
                com.google.android.exoplayer2.j r1 = com.google.android.exoplayer2.j.a((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (int) r20, (int) r21, (int) r22, (int) r23, (int) r24, (java.util.List<byte[]>) r25, (com.google.android.exoplayer2.c.a) r26, (int) r27, (java.lang.String) r28)
                r8 = 1
                goto L_0x03e2
            L_0x031a:
                boolean r5 = com.google.android.exoplayer2.n.h.b(r1)
                if (r5 == 0) goto L_0x0390
                int r2 = r0.n
                if (r2 != 0) goto L_0x0334
                int r2 = r0.l
                if (r2 != r9) goto L_0x032a
                int r2 = r0.j
            L_0x032a:
                r0.l = r2
                int r2 = r0.m
                if (r2 != r9) goto L_0x0332
                int r2 = r0.k
            L_0x0332:
                r0.m = r2
            L_0x0334:
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r4 = r0.l
                if (r4 == r9) goto L_0x034c
                int r5 = r0.m
                if (r5 == r9) goto L_0x034c
                int r2 = r0.k
                int r2 = r2 * r4
                float r2 = (float) r2
                int r4 = r0.j
                int r4 = r4 * r5
                float r4 = (float) r4
                float r2 = r2 / r4
                r27 = r2
                goto L_0x034e
            L_0x034c:
                r27 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x034e:
                boolean r2 = r0.q
                if (r2 == 0) goto L_0x0364
                byte[] r2 = r33.a()
                com.google.android.exoplayer2.k.b r4 = new com.google.android.exoplayer2.k.b
                int r5 = r0.r
                int r7 = r0.t
                int r8 = r0.s
                r4.<init>(r5, r7, r8, r2)
                r30 = r4
                goto L_0x0366
            L_0x0364:
                r30 = r16
            L_0x0366:
                java.lang.String r17 = java.lang.Integer.toString(r35)
                r19 = 0
                r20 = -1
                int r2 = r0.j
                int r4 = r0.k
                r24 = -1082130432(0xffffffffbf800000, float:-1.0)
                r26 = -1
                byte[] r5 = r0.o
                int r7 = r0.p
                com.google.android.exoplayer2.c.a r8 = r0.i
                r18 = r1
                r22 = r2
                r23 = r4
                r25 = r3
                r28 = r5
                r29 = r7
                r31 = r8
                com.google.android.exoplayer2.j r1 = com.google.android.exoplayer2.j.a((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (int) r20, (int) r21, (int) r22, (int) r23, (float) r24, (java.util.List<byte[]>) r25, (int) r26, (float) r27, (byte[]) r28, (int) r29, (com.google.android.exoplayer2.k.b) r30, (com.google.android.exoplayer2.c.a) r31)
                r8 = 2
                goto L_0x03e2
            L_0x0390:
                boolean r5 = r12.equals(r1)
                if (r5 == 0) goto L_0x03af
                java.lang.String r17 = java.lang.Integer.toString(r35)
                r19 = 0
                r20 = -1
                java.lang.String r2 = r0.P
                com.google.android.exoplayer2.c.a r3 = r0.i
                r18 = r1
                r21 = r4
                r22 = r2
                r23 = r3
                com.google.android.exoplayer2.j r1 = com.google.android.exoplayer2.j.a((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (int) r20, (int) r21, (java.lang.String) r22, (com.google.android.exoplayer2.c.a) r23)
                goto L_0x03e2
            L_0x03af:
                boolean r4 = r11.equals(r1)
                if (r4 != 0) goto L_0x03ca
                boolean r4 = r10.equals(r1)
                if (r4 != 0) goto L_0x03ca
                boolean r2 = r2.equals(r1)
                if (r2 == 0) goto L_0x03c2
                goto L_0x03ca
            L_0x03c2:
                com.google.android.exoplayer2.ak r1 = new com.google.android.exoplayer2.ak
                java.lang.String r2 = "Unexpected MIME type."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x03ca:
                java.lang.String r17 = java.lang.Integer.toString(r35)
                r19 = 0
                r20 = -1
                java.lang.String r2 = r0.P
                com.google.android.exoplayer2.c.a r4 = r0.i
                r18 = r1
                r21 = r3
                r22 = r2
                r23 = r4
                com.google.android.exoplayer2.j r1 = com.google.android.exoplayer2.j.a((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (int) r20, (java.util.List<byte[]>) r21, (java.lang.String) r22, (com.google.android.exoplayer2.c.a) r23)
            L_0x03e2:
                int r2 = r0.f9353b
                r3 = r34
                com.google.android.exoplayer2.e.n r2 = r3.a(r2, r8)
                r0.N = r2
                com.google.android.exoplayer2.e.n r2 = r0.N
                r2.a(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.d.b.a(com.google.android.exoplayer2.e.h, int):void");
        }

        private byte[] a() {
            if (this.w == -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((int) ((this.w * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.x * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.y * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.z * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.A * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.B * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.C * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.D * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) (this.E + 0.5f)));
            wrap.putShort((short) ((int) (this.F + 0.5f)));
            wrap.putShort((short) this.u);
            wrap.putShort((short) this.v);
            return bArr;
        }

        private static List<byte[]> a(k kVar) throws ak {
            try {
                kVar.d(16);
                if (kVar.m() != 826496599) {
                    return null;
                }
                byte[] bArr = kVar.f10948a;
                for (int d2 = kVar.d() + 20; d2 < bArr.length - 4; d2++) {
                    if (bArr[d2] == 0 && bArr[d2 + 1] == 0 && bArr[d2 + 2] == 1 && bArr[d2 + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, d2, bArr.length));
                    }
                }
                throw new ak("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ak("Error parsing FourCC VC1 codec private");
            }
        }

        private static List<byte[]> a(byte[] bArr) throws ak {
            try {
                if (bArr[0] == 2) {
                    int i2 = 1;
                    int i3 = 0;
                    while (bArr[i2] == -1) {
                        i3 += 255;
                        i2++;
                    }
                    int i4 = i2 + 1;
                    int i5 = i3 + bArr[i2];
                    int i6 = 0;
                    while (bArr[i4] == -1) {
                        i6 += 255;
                        i4++;
                    }
                    int i7 = i4 + 1;
                    int i8 = i6 + bArr[i4];
                    if (bArr[i7] == 1) {
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i7, bArr2, 0, i5);
                        int i9 = i7 + i5;
                        if (bArr[i9] == 3) {
                            int i10 = i9 + i8;
                            if (bArr[i10] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i10)];
                                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new ak("Error parsing vorbis codec private");
                        }
                        throw new ak("Error parsing vorbis codec private");
                    }
                    throw new ak("Error parsing vorbis codec private");
                }
                throw new ak("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ak("Error parsing vorbis codec private");
            }
        }

        private static boolean b(k kVar) throws ak {
            try {
                int i2 = kVar.i();
                if (i2 == 1) {
                    return true;
                }
                if (i2 != 65534) {
                    return false;
                }
                kVar.c(24);
                if (kVar.p() == d.f9347d.getMostSignificantBits() && kVar.p() == d.f9347d.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ak("Error parsing MS/ACM codec private");
            }
        }
    }
}
