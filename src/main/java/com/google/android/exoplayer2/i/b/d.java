package com.google.android.exoplayer2.i.b;

import android.util.SparseArray;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.g;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
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

public final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f9985a = new h() {
        public e[] a() {
            return new e[]{new d()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f9986b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f9987c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};

    /* renamed from: d  reason: collision with root package name */
    private static long f9988d = 1000;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f9989e = v.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f9990f = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: g  reason: collision with root package name */
    private static long f9991g = 10000;
    private static final byte[] h = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */
    public static final UUID i = new UUID(72057594037932032L, -9223371306706625679L);
    private long A;
    private long B;
    private b C;
    private boolean D;
    private int E;
    private long F;
    private boolean G;
    private long H;
    private long I;
    private long J;
    private g K;
    private g L;
    private boolean M;
    private int N;
    private long O;
    private long P;
    private int Q;
    private int R;
    private int[] S;
    private int T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private boolean aa;
    private byte ab;
    private int ac;
    private int ad;
    private int ae;
    private boolean af;
    private boolean ag;
    private com.google.android.exoplayer2.i.g ah;
    private final b j;
    private final f k;
    private final SparseArray<b> l;
    private final boolean m;
    private final l n;
    private final l o;
    private final l p;
    private final l q;
    private final l r;
    private final l s;
    private final l t;
    private final l u;
    private final l v;
    private ByteBuffer w;
    private long x;
    private long y;
    private long z;

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
        this.y = -1;
        this.z = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.H = -1;
        this.I = -1;
        this.J = -9223372036854775807L;
        this.j = bVar;
        this.j.a((c) new a());
        this.m = (i2 & 1) != 0 ? false : true;
        this.k = new f();
        this.l = new SparseArray<>();
        this.p = new l(4);
        this.q = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.r = new l(4);
        this.n = new l(j.f11404a);
        this.o = new l(4);
        this.s = new l();
        this.t = new l();
        this.u = new l(8);
        this.v = new l();
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        return new e().a(fVar);
    }

    public void a(com.google.android.exoplayer2.i.g gVar) {
        this.ah = gVar;
    }

    public void a(long j2, long j3) {
        this.J = -9223372036854775807L;
        this.N = 0;
        this.j.a();
        this.k.a();
        d();
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        this.af = false;
        boolean z2 = true;
        while (z2 && !this.af) {
            z2 = this.j.a(fVar);
            if (z2 && a(kVar, fVar.c())) {
                return 1;
            }
        }
        if (z2) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2, long j3) throws p {
        if (i2 == 160) {
            this.ag = false;
        } else if (i2 == 174) {
            this.C = new b();
        } else if (i2 == 187) {
            this.M = false;
        } else if (i2 == 19899) {
            this.E = -1;
            this.F = -1;
        } else if (i2 == 20533) {
            this.C.f9997e = true;
        } else if (i2 == 21968) {
            this.C.q = true;
        } else if (i2 == 25152) {
        } else {
            if (i2 == 408125543) {
                long j4 = this.y;
                if (j4 == -1 || j4 == j2) {
                    this.y = j2;
                    this.x = j3;
                    return;
                }
                throw new p("Multiple Segment elements not supported");
            } else if (i2 == 475249515) {
                this.K = new g();
                this.L = new g();
            } else if (i2 != 524531317 || this.D) {
            } else {
                if (!this.m || this.H == -1) {
                    this.ah.a(new l.a(this.B));
                    this.D = true;
                    return;
                }
                this.G = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) throws p {
        if (i2 != 160) {
            if (i2 == 174) {
                if (a(this.C.f9993a)) {
                    b bVar = this.C;
                    bVar.a(this.ah, bVar.f9994b);
                    this.l.put(this.C.f9994b, this.C);
                }
                this.C = null;
            } else if (i2 == 19899) {
                int i3 = this.E;
                if (i3 != -1) {
                    long j2 = this.F;
                    if (j2 != -1) {
                        if (i3 == 475249515) {
                            this.H = j2;
                            return;
                        }
                        return;
                    }
                }
                throw new p("Mandatory element SeekID or SeekPosition not found");
            } else if (i2 != 25152) {
                if (i2 != 28032) {
                    if (i2 == 357149030) {
                        if (this.z == -9223372036854775807L) {
                            this.z = JobManager.NS_PER_MS;
                        }
                        long j3 = this.A;
                        if (j3 != -9223372036854775807L) {
                            this.B = a(j3);
                        }
                    } else if (i2 != 374648427) {
                        if (i2 == 475249515 && !this.D) {
                            this.ah.a(e());
                            this.D = true;
                        }
                    } else if (this.l.size() != 0) {
                        this.ah.a();
                    } else {
                        throw new p("No valid tracks were found");
                    }
                } else if (this.C.f9997e && this.C.f9998f != null) {
                    throw new p("Combining encryption and compression is not supported");
                }
            } else if (!this.C.f9997e) {
            } else {
                if (this.C.f9999g != null) {
                    this.C.i = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.b.f9137b, (String) null, "video/webm", this.C.f9999g.f10419b));
                    return;
                }
                throw new p("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (this.N == 2) {
            if (!this.ag) {
                this.V |= 1;
            }
            a(this.l.get(this.T), this.O);
            this.N = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) throws p {
        if (i2 != 20529) {
            if (i2 != 20530) {
                boolean z2 = false;
                switch (i2) {
                    case 131:
                        this.C.f9995c = (int) j2;
                        return;
                    case 136:
                        b bVar = this.C;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        bVar.L = z2;
                        return;
                    case 155:
                        this.P = a(j2);
                        return;
                    case 159:
                        this.C.G = (int) j2;
                        return;
                    case 176:
                        this.C.j = (int) j2;
                        return;
                    case 179:
                        this.K.a(a(j2));
                        return;
                    case 186:
                        this.C.k = (int) j2;
                        return;
                    case JfifUtil.MARKER_RST7:
                        this.C.f9994b = (int) j2;
                        return;
                    case 231:
                        this.J = a(j2);
                        return;
                    case 241:
                        if (!this.M) {
                            this.L.a(j2);
                            this.M = true;
                            return;
                        }
                        return;
                    case 251:
                        this.ag = true;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            throw new p("ContentCompAlgo " + j2 + " not supported");
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            throw new p("DocTypeReadVersion " + j2 + " not supported");
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            throw new p("EBMLReadVersion " + j2 + " not supported");
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            throw new p("ContentEncAlgo " + j2 + " not supported");
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            throw new p("AESSettingsCipherMode " + j2 + " not supported");
                        }
                        return;
                    case 21420:
                        this.F = j2 + this.y;
                        return;
                    case 21432:
                        int i3 = (int) j2;
                        if (i3 == 0) {
                            this.C.p = 0;
                            return;
                        } else if (i3 == 1) {
                            this.C.p = 2;
                            return;
                        } else if (i3 == 3) {
                            this.C.p = 1;
                            return;
                        } else if (i3 == 15) {
                            this.C.p = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.C.l = (int) j2;
                        return;
                    case 21682:
                        this.C.n = (int) j2;
                        return;
                    case 21690:
                        this.C.m = (int) j2;
                        return;
                    case 21930:
                        b bVar2 = this.C;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        bVar2.M = z2;
                        return;
                    case 22186:
                        this.C.J = j2;
                        return;
                    case 22203:
                        this.C.K = j2;
                        return;
                    case 25188:
                        this.C.H = (int) j2;
                        return;
                    case 2352003:
                        this.C.f9996d = (int) j2;
                        return;
                    case 2807729:
                        this.z = j2;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                int i4 = (int) j2;
                                if (i4 == 1) {
                                    this.C.t = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.C.t = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i5 = (int) j2;
                                if (i5 != 1) {
                                    if (i5 == 16) {
                                        this.C.s = 6;
                                        return;
                                    } else if (i5 == 18) {
                                        this.C.s = 7;
                                        return;
                                    } else if (!(i5 == 6 || i5 == 7)) {
                                        return;
                                    }
                                }
                                this.C.s = 3;
                                return;
                            case 21947:
                                b bVar3 = this.C;
                                bVar3.q = true;
                                int i6 = (int) j2;
                                if (i6 == 1) {
                                    bVar3.r = 1;
                                    return;
                                } else if (i6 == 9) {
                                    bVar3.r = 6;
                                    return;
                                } else if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                    this.C.r = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.C.u = (int) j2;
                                return;
                            case 21949:
                                this.C.v = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                throw new p("ContentEncodingScope " + j2 + " not supported");
            }
        } else if (j2 != 0) {
            throw new p("ContentEncodingOrder " + j2 + " not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, double d2) {
        if (i2 == 181) {
            this.C.I = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    this.C.w = (float) d2;
                    return;
                case 21970:
                    this.C.x = (float) d2;
                    return;
                case 21971:
                    this.C.y = (float) d2;
                    return;
                case 21972:
                    this.C.z = (float) d2;
                    return;
                case 21973:
                    this.C.A = (float) d2;
                    return;
                case 21974:
                    this.C.B = (float) d2;
                    return;
                case 21975:
                    this.C.C = (float) d2;
                    return;
                case 21976:
                    this.C.D = (float) d2;
                    return;
                case 21977:
                    this.C.E = (float) d2;
                    return;
                case 21978:
                    this.C.F = (float) d2;
                    return;
                default:
                    return;
            }
        } else {
            this.A = (long) d2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str) throws p {
        if (i2 == 134) {
            this.C.f9993a = str;
        } else if (i2 != 17026) {
            if (i2 == 2274716) {
                String unused = this.C.P = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new p("DocType " + str + " not supported");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0201, code lost:
        throw new com.google.android.exoplayer2.p("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r20, int r21, com.google.android.exoplayer2.i.f r22) throws java.io.IOException, java.lang.InterruptedException {
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
            r8 = 1
            if (r1 == r4) goto L_0x0094
            if (r1 == r5) goto L_0x0094
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0087
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0077
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0058
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x004b
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0034
            com.google.android.exoplayer2.i.b.d$b r1 = r0.C
            byte[] r4 = new byte[r2]
            r1.o = r4
            byte[] r1 = r1.o
            r3.b(r1, r7, r2)
            goto L_0x02b9
        L_0x0034:
            com.google.android.exoplayer2.p r2 = new com.google.android.exoplayer2.p
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unexpected id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x004b:
            com.google.android.exoplayer2.i.b.d$b r1 = r0.C
            byte[] r4 = new byte[r2]
            r1.h = r4
            byte[] r1 = r1.h
            r3.b(r1, r7, r2)
            goto L_0x02b9
        L_0x0058:
            com.google.android.exoplayer2.s.l r1 = r0.r
            byte[] r1 = r1.f11422a
            java.util.Arrays.fill(r1, r7)
            com.google.android.exoplayer2.s.l r1 = r0.r
            byte[] r1 = r1.f11422a
            int r6 = r6 - r2
            r3.b(r1, r6, r2)
            com.google.android.exoplayer2.s.l r1 = r0.r
            r1.c(r7)
            com.google.android.exoplayer2.s.l r1 = r0.r
            long r1 = r1.l()
            int r2 = (int) r1
            r0.E = r2
            goto L_0x02b9
        L_0x0077:
            byte[] r1 = new byte[r2]
            r3.b(r1, r7, r2)
            com.google.android.exoplayer2.i.b.d$b r2 = r0.C
            com.google.android.exoplayer2.i.m$a r3 = new com.google.android.exoplayer2.i.m$a
            r3.<init>(r8, r1, r7, r7)
            r2.f9999g = r3
            goto L_0x02b9
        L_0x0087:
            com.google.android.exoplayer2.i.b.d$b r1 = r0.C
            byte[] r4 = new byte[r2]
            r1.f9998f = r4
            byte[] r1 = r1.f9998f
            r3.b(r1, r7, r2)
            goto L_0x02b9
        L_0x0094:
            int r4 = r0.N
            r9 = 8
            if (r4 != 0) goto L_0x00b9
            com.google.android.exoplayer2.i.b.f r4 = r0.k
            long r10 = r4.a(r3, r7, r8, r9)
            int r4 = (int) r10
            r0.T = r4
            com.google.android.exoplayer2.i.b.f r4 = r0.k
            int r4 = r4.b()
            r0.U = r4
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.P = r10
            r0.N = r8
            com.google.android.exoplayer2.s.l r4 = r0.p
            r4.a()
        L_0x00b9:
            android.util.SparseArray<com.google.android.exoplayer2.i.b.d$b> r4 = r0.l
            int r10 = r0.T
            java.lang.Object r4 = r4.get(r10)
            com.google.android.exoplayer2.i.b.d$b r4 = (com.google.android.exoplayer2.i.b.d.b) r4
            if (r4 != 0) goto L_0x00cf
            int r1 = r0.U
            int r1 = r2 - r1
            r3.b(r1)
            r0.N = r7
            return
        L_0x00cf:
            int r10 = r0.N
            if (r10 != r8) goto L_0x0286
            r10 = 3
            r0.a((com.google.android.exoplayer2.i.f) r3, (int) r10)
            com.google.android.exoplayer2.s.l r11 = r0.p
            byte[] r11 = r11.f11422a
            r12 = 2
            byte r11 = r11[r12]
            r11 = r11 & 6
            int r11 = r11 >> r8
            r13 = 255(0xff, float:3.57E-43)
            if (r11 != 0) goto L_0x00f9
            r0.R = r8
            int[] r6 = r0.S
            int[] r6 = a((int[]) r6, (int) r8)
            r0.S = r6
            int[] r6 = r0.S
            int r11 = r0.U
            int r2 = r2 - r11
            int r2 = r2 - r10
            r6[r7] = r2
            goto L_0x0215
        L_0x00f9:
            if (r1 != r5) goto L_0x027e
            r0.a((com.google.android.exoplayer2.i.f) r3, (int) r6)
            com.google.android.exoplayer2.s.l r14 = r0.p
            byte[] r14 = r14.f11422a
            byte r14 = r14[r10]
            r14 = r14 & r13
            int r14 = r14 + r8
            r0.R = r14
            int[] r14 = r0.S
            int r15 = r0.R
            int[] r14 = a((int[]) r14, (int) r15)
            r0.S = r14
            if (r11 != r12) goto L_0x0122
            int r10 = r0.U
            int r2 = r2 - r10
            int r2 = r2 - r6
            int r6 = r0.R
            int r2 = r2 / r6
            int[] r10 = r0.S
            java.util.Arrays.fill(r10, r7, r6, r2)
            goto L_0x0215
        L_0x0122:
            if (r11 != r8) goto L_0x015a
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x0127:
            int r14 = r0.R
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x014e
            int[] r14 = r0.S
            r14[r6] = r7
        L_0x0131:
            int r10 = r10 + r8
            r0.a((com.google.android.exoplayer2.i.f) r3, (int) r10)
            com.google.android.exoplayer2.s.l r14 = r0.p
            byte[] r14 = r14.f11422a
            int r15 = r10 + -1
            byte r14 = r14[r15]
            r14 = r14 & r13
            int[] r15 = r0.S
            r16 = r15[r6]
            int r16 = r16 + r14
            r15[r6] = r16
            if (r14 == r13) goto L_0x0131
            r14 = r15[r6]
            int r11 = r11 + r14
            int r6 = r6 + 1
            goto L_0x0127
        L_0x014e:
            int[] r6 = r0.S
            int r14 = r14 - r8
            int r15 = r0.U
            int r2 = r2 - r15
            int r2 = r2 - r10
            int r2 = r2 - r11
            r6[r14] = r2
            goto L_0x0215
        L_0x015a:
            if (r11 != r10) goto L_0x0267
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x015f:
            int r14 = r0.R
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x020a
            int[] r14 = r0.S
            r14[r6] = r7
            int r10 = r10 + 1
            r0.a((com.google.android.exoplayer2.i.f) r3, (int) r10)
            com.google.android.exoplayer2.s.l r14 = r0.p
            byte[] r14 = r14.f11422a
            int r15 = r10 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x0202
            r16 = 0
            r14 = 0
        L_0x017b:
            if (r14 >= r9) goto L_0x01cd
            int r18 = 7 - r14
            int r18 = r8 << r18
            com.google.android.exoplayer2.s.l r5 = r0.p
            byte[] r5 = r5.f11422a
            byte r5 = r5[r15]
            r5 = r5 & r18
            if (r5 == 0) goto L_0x01c3
            int r10 = r10 + r14
            r0.a((com.google.android.exoplayer2.i.f) r3, (int) r10)
            com.google.android.exoplayer2.s.l r5 = r0.p
            byte[] r5 = r5.f11422a
            int r16 = r15 + 1
            byte r5 = r5[r15]
            r5 = r5 & r13
            r15 = r18 ^ -1
            r5 = r5 & r15
            long r7 = (long) r5
            r5 = r16
        L_0x019e:
            r16 = r7
            if (r5 >= r10) goto L_0x01b5
            long r7 = r16 << r9
            com.google.android.exoplayer2.s.l r15 = r0.p
            byte[] r15 = r15.f11422a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            r5 = r5 & r13
            long r12 = (long) r5
            long r7 = r7 | r12
            r5 = r16
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x019e
        L_0x01b5:
            if (r6 <= 0) goto L_0x01cd
            int r14 = r14 * 7
            int r14 = r14 + 6
            r7 = 1
            long r12 = r7 << r14
            long r12 = r12 - r7
            long r16 = r16 - r12
            goto L_0x01cd
        L_0x01c3:
            int r14 = r14 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x017b
        L_0x01cd:
            r7 = r16
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x01fa
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x01fa
            int r5 = (int) r7
            int[] r7 = r0.S
            if (r6 != 0) goto L_0x01e3
            goto L_0x01e8
        L_0x01e3:
            int r8 = r6 + -1
            r8 = r7[r8]
            int r5 = r5 + r8
        L_0x01e8:
            r7[r6] = r5
            int[] r5 = r0.S
            r5 = r5[r6]
            int r11 = r11 + r5
            int r6 = r6 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x015f
        L_0x01fa:
            com.google.android.exoplayer2.p r1 = new com.google.android.exoplayer2.p
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0202:
            com.google.android.exoplayer2.p r1 = new com.google.android.exoplayer2.p
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x020a:
            int[] r5 = r0.S
            r6 = 1
            int r14 = r14 - r6
            int r6 = r0.U
            int r2 = r2 - r6
            int r2 = r2 - r10
            int r2 = r2 - r11
            r5[r14] = r2
        L_0x0215:
            com.google.android.exoplayer2.s.l r2 = r0.p
            byte[] r2 = r2.f11422a
            r5 = 0
            byte r2 = r2[r5]
            int r2 = r2 << r9
            com.google.android.exoplayer2.s.l r5 = r0.p
            byte[] r5 = r5.f11422a
            r6 = 1
            byte r5 = r5[r6]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            r2 = r2 | r5
            long r5 = r0.J
            long r7 = (long) r2
            long r7 = r0.a((long) r7)
            long r5 = r5 + r7
            r0.O = r5
            com.google.android.exoplayer2.s.l r2 = r0.p
            byte[] r2 = r2.f11422a
            r5 = 2
            byte r2 = r2[r5]
            r2 = r2 & r9
            if (r2 != r9) goto L_0x023e
            r2 = 1
            goto L_0x023f
        L_0x023e:
            r2 = 0
        L_0x023f:
            int r6 = r4.f9995c
            if (r6 == r5) goto L_0x0255
            r6 = 163(0xa3, float:2.28E-43)
            if (r1 != r6) goto L_0x0253
            com.google.android.exoplayer2.s.l r6 = r0.p
            byte[] r6 = r6.f11422a
            byte r6 = r6[r5]
            r5 = 128(0x80, float:1.794E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x0253
            goto L_0x0255
        L_0x0253:
            r5 = 0
            goto L_0x0256
        L_0x0255:
            r5 = 1
        L_0x0256:
            if (r2 == 0) goto L_0x025b
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x025c
        L_0x025b:
            r7 = 0
        L_0x025c:
            r2 = r5 | r7
            r0.V = r2
            r2 = 2
            r0.N = r2
            r2 = 0
            r0.Q = r2
            goto L_0x0286
        L_0x0267:
            com.google.android.exoplayer2.p r1 = new com.google.android.exoplayer2.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected lacing value: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x027e:
            com.google.android.exoplayer2.p r1 = new com.google.android.exoplayer2.p
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0286:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x02b1
        L_0x028a:
            int r1 = r0.Q
            int r2 = r0.R
            if (r1 >= r2) goto L_0x02ad
            int[] r2 = r0.S
            r1 = r2[r1]
            r0.a((com.google.android.exoplayer2.i.f) r3, (com.google.android.exoplayer2.i.b.d.b) r4, (int) r1)
            long r1 = r0.O
            int r5 = r0.Q
            int r6 = r4.f9996d
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.a((com.google.android.exoplayer2.i.b.d.b) r4, (long) r1)
            int r1 = r0.Q
            r2 = 1
            int r1 = r1 + r2
            r0.Q = r1
            goto L_0x028a
        L_0x02ad:
            r1 = 0
            r0.N = r1
            goto L_0x02b9
        L_0x02b1:
            r1 = 0
            int[] r2 = r0.S
            r1 = r2[r1]
            r0.a((com.google.android.exoplayer2.i.f) r3, (com.google.android.exoplayer2.i.b.d.b) r4, (int) r1)
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.b.d.a(int, int, com.google.android.exoplayer2.i.f):void");
    }

    private void a(b bVar, long j2) {
        b bVar2 = bVar;
        if ("S_TEXT/UTF8".equals(bVar2.f9993a)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, f9988d, f9987c);
        } else if ("S_TEXT/ASS".equals(bVar2.f9993a)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, f9991g, h);
        }
        bVar2.N.a(j2, this.V, this.ae, 0, bVar2.f9999g);
        this.af = true;
        d();
    }

    private void d() {
        this.W = 0;
        this.ae = 0;
        this.ad = 0;
        this.X = false;
        this.Y = false;
        this.aa = false;
        this.ac = 0;
        this.ab = 0;
        this.Z = false;
        this.s.a();
    }

    private void a(f fVar, int i2) throws IOException, InterruptedException {
        if (this.p.c() < i2) {
            if (this.p.e() < i2) {
                com.google.android.exoplayer2.s.l lVar = this.p;
                lVar.a(Arrays.copyOf(lVar.f11422a, Math.max(this.p.f11422a.length * 2, i2)), this.p.c());
            }
            fVar.b(this.p.f11422a, this.p.c(), i2 - this.p.c());
            this.p.b(i2);
        }
    }

    private void a(f fVar, b bVar, int i2) throws IOException, InterruptedException {
        int i3;
        if ("S_TEXT/UTF8".equals(bVar.f9993a)) {
            a(fVar, f9986b, i2);
        } else if ("S_TEXT/ASS".equals(bVar.f9993a)) {
            a(fVar, f9990f, i2);
        } else {
            m mVar = bVar.N;
            if (!this.X) {
                if (bVar.f9997e) {
                    this.V &= -1073741825;
                    int i4 = 128;
                    if (!this.Y) {
                        fVar.b(this.p.f11422a, 0, 1);
                        this.W++;
                        if ((this.p.f11422a[0] & 128) != 128) {
                            this.ab = this.p.f11422a[0];
                            this.Y = true;
                        } else {
                            throw new p("Extension bit is set in signal byte");
                        }
                    }
                    if ((this.ab & 1) == 1) {
                        boolean z2 = (this.ab & 2) == 2;
                        this.V |= 1073741824;
                        if (!this.Z) {
                            fVar.b(this.u.f11422a, 0, 8);
                            this.W += 8;
                            this.Z = true;
                            byte[] bArr = this.p.f11422a;
                            if (!z2) {
                                i4 = 0;
                            }
                            bArr[0] = (byte) (i4 | 8);
                            this.p.c(0);
                            mVar.a(this.p, 1);
                            this.ae++;
                            this.u.c(0);
                            mVar.a(this.u, 8);
                            this.ae += 8;
                        }
                        if (z2) {
                            if (!this.aa) {
                                fVar.b(this.p.f11422a, 0, 1);
                                this.W++;
                                this.p.c(0);
                                this.ac = this.p.g();
                                this.aa = true;
                            }
                            int i5 = this.ac * 4;
                            this.p.a(i5);
                            fVar.b(this.p.f11422a, 0, i5);
                            this.W += i5;
                            short s2 = (short) ((this.ac / 2) + 1);
                            int i6 = (s2 * 6) + 2;
                            ByteBuffer byteBuffer = this.w;
                            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                this.w = ByteBuffer.allocate(i6);
                            }
                            this.w.position(0);
                            this.w.putShort(s2);
                            int i7 = 0;
                            int i8 = 0;
                            while (true) {
                                i3 = this.ac;
                                if (i7 >= i3) {
                                    break;
                                }
                                int t2 = this.p.t();
                                if (i7 % 2 == 0) {
                                    this.w.putShort((short) (t2 - i8));
                                } else {
                                    this.w.putInt(t2 - i8);
                                }
                                i7++;
                                i8 = t2;
                            }
                            int i9 = (i2 - this.W) - i8;
                            if (i3 % 2 == 1) {
                                this.w.putInt(i9);
                            } else {
                                this.w.putShort((short) i9);
                                this.w.putInt(0);
                            }
                            this.v.a(this.w.array(), i6);
                            mVar.a(this.v, i6);
                            this.ae += i6;
                        }
                    }
                } else if (bVar.f9998f != null) {
                    this.s.a(bVar.f9998f, bVar.f9998f.length);
                }
                this.X = true;
            }
            int c2 = i2 + this.s.c();
            if (!"V_MPEG4/ISO/AVC".equals(bVar.f9993a) && !"V_MPEGH/ISO/HEVC".equals(bVar.f9993a)) {
                while (true) {
                    int i10 = this.W;
                    if (i10 >= c2) {
                        break;
                    }
                    a(fVar, mVar, c2 - i10);
                }
            } else {
                byte[] bArr2 = this.o.f11422a;
                bArr2[0] = 0;
                bArr2[1] = 0;
                bArr2[2] = 0;
                int i11 = bVar.O;
                int i12 = 4 - bVar.O;
                while (this.W < c2) {
                    int i13 = this.ad;
                    if (i13 == 0) {
                        a(fVar, bArr2, i12, i11);
                        this.o.c(0);
                        this.ad = this.o.t();
                        this.n.c(0);
                        mVar.a(this.n, 4);
                        this.ae += 4;
                    } else {
                        this.ad = i13 - a(fVar, mVar, i13);
                    }
                }
            }
            if ("A_VORBIS".equals(bVar.f9993a)) {
                this.q.c(0);
                mVar.a(this.q, 4);
                this.ae += 4;
            }
        }
    }

    private void a(f fVar, byte[] bArr, int i2) throws IOException, InterruptedException {
        int length = bArr.length + i2;
        if (this.t.e() < length) {
            this.t.f11422a = Arrays.copyOf(bArr, length + i2);
        } else {
            System.arraycopy(bArr, 0, this.t.f11422a, 0, bArr.length);
        }
        fVar.b(this.t.f11422a, bArr.length, i2);
        this.t.a(length);
    }

    private void a(b bVar, String str, int i2, long j2, byte[] bArr) {
        a(this.t.f11422a, this.P, str, i2, j2, bArr);
        m mVar = bVar.N;
        com.google.android.exoplayer2.s.l lVar = this.t;
        mVar.a(lVar, lVar.c());
        this.ae += this.t.c();
    }

    private static void a(byte[] bArr, long j2, String str, int i2, long j3, byte[] bArr2) {
        byte[] bArr3;
        byte[] bArr4;
        if (j2 == -9223372036854775807L) {
            bArr4 = bArr2;
            bArr3 = bArr4;
        } else {
            int i3 = (int) (j2 / 3600000000L);
            long j4 = j2 - (((long) (i3 * 3600)) * JobManager.NS_PER_MS);
            int i4 = (int) (j4 / 60000000);
            long j5 = j4 - (((long) (i4 * 60)) * JobManager.NS_PER_MS);
            int i5 = (int) (j5 / JobManager.NS_PER_MS);
            int i6 = (int) ((j5 - (((long) i5) * JobManager.NS_PER_MS)) / j3);
            Locale locale = Locale.US;
            Object[] objArr = {Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            String str2 = str;
            bArr3 = v.c(String.format(locale, str, objArr));
            bArr4 = bArr2;
        }
        byte[] bArr5 = bArr;
        int i7 = i2;
        System.arraycopy(bArr3, 0, bArr, i2, bArr4.length);
    }

    private void a(f fVar, byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int min = Math.min(i3, this.s.b());
        fVar.b(bArr, i2 + min, i3 - min);
        if (min > 0) {
            this.s.a(bArr, i2, min);
        }
        this.W += i3;
    }

    private int a(f fVar, m mVar, int i2) throws IOException, InterruptedException {
        int i3;
        int b2 = this.s.b();
        if (b2 > 0) {
            i3 = Math.min(i2, b2);
            mVar.a(this.s, i3);
        } else {
            i3 = mVar.a(fVar, i2, false);
        }
        this.W += i3;
        this.ae += i3;
        return i3;
    }

    private com.google.android.exoplayer2.i.l e() {
        if (!(this.y == -1 || this.B == -9223372036854775807L)) {
            g gVar = this.K;
            if (!(gVar == null || gVar.a() == 0)) {
                g gVar2 = this.L;
                if (gVar2 != null && gVar2.a() == this.K.a()) {
                    int a2 = this.K.a();
                    int[] iArr = new int[a2];
                    long[] jArr = new long[a2];
                    long[] jArr2 = new long[a2];
                    long[] jArr3 = new long[a2];
                    int i2 = 0;
                    for (int i3 = 0; i3 < a2; i3++) {
                        jArr3[i3] = this.K.a(i3);
                        jArr[i3] = this.y + this.L.a(i3);
                    }
                    while (true) {
                        int i4 = a2 - 1;
                        if (i2 < i4) {
                            int i5 = i2 + 1;
                            iArr[i2] = (int) (jArr[i5] - jArr[i2]);
                            jArr2[i2] = jArr3[i5] - jArr3[i2];
                            i2 = i5;
                        } else {
                            iArr[i4] = (int) ((this.y + this.x) - jArr[i4]);
                            jArr2[i4] = this.B - jArr3[i4];
                            this.K = null;
                            this.L = null;
                            return new com.google.android.exoplayer2.i.a(iArr, jArr, jArr2, jArr3);
                        }
                    }
                }
            }
        }
        this.K = null;
        this.L = null;
        return new l.a(this.B);
    }

    private boolean a(k kVar, long j2) {
        if (this.G) {
            this.I = j2;
            kVar.f10416a = this.H;
            this.G = false;
            return true;
        }
        if (this.D) {
            long j3 = this.I;
            if (j3 != -1) {
                kVar.f10416a = j3;
                this.I = -1;
                return true;
            }
        }
        return false;
    }

    private long a(long j2) throws p {
        long j3 = this.z;
        if (j3 != -9223372036854775807L) {
            return v.b(j2, j3, 1000);
        }
        throw new p("Can't scale timecode prior to timecodeScale being set.");
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
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

        public void a(int i, long j, long j2) throws p {
            d.this.a(i, j, j2);
        }

        public void c(int i) throws p {
            d.this.c(i);
        }

        public void a(int i, long j) throws p {
            d.this.a(i, j);
        }

        public void a(int i, double d2) throws p {
            d.this.a(i, d2);
        }

        public void a(int i, String str) throws p {
            d.this.a(i, str);
        }

        public void a(int i, int i2, f fVar) throws IOException, InterruptedException {
            d.this.a(i, i2, fVar);
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
        public m N;
        public int O;
        /* access modifiers changed from: private */
        public String P;

        /* renamed from: a  reason: collision with root package name */
        public String f9993a;

        /* renamed from: b  reason: collision with root package name */
        public int f9994b;

        /* renamed from: c  reason: collision with root package name */
        public int f9995c;

        /* renamed from: d  reason: collision with root package name */
        public int f9996d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9997e;

        /* renamed from: f  reason: collision with root package name */
        public byte[] f9998f;

        /* renamed from: g  reason: collision with root package name */
        public m.a f9999g;
        public byte[] h;
        public DrmInitData i;
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
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d2, code lost:
            r23 = r1;
            r1 = "audio/raw";
            r3 = null;
            r20 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0222, code lost:
            r1 = "audio/x-unknown";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0247, code lost:
            r3 = null;
            r20 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0254, code lost:
            r20 = -1;
            r23 = -1;
            r31 = r3;
            r3 = r1;
            r1 = r31;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x030b, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x030c, code lost:
            r20 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x030e, code lost:
            r23 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x0310, code lost:
            r11 = r0.M | false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0315, code lost:
            if (r0.L == false) goto L_0x0318;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0317, code lost:
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0318, code lost:
            r5 = r5 | r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x031d, code lost:
            if (com.google.android.exoplayer2.s.i.a(r1) == false) goto L_0x0344;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x031f, code lost:
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r34), r1, (java.lang.String) null, -1, r20, r0.G, r0.I, r23, r3, r0.i, r5 ? 1 : 0, r0.P);
            r7 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0348, code lost:
            if (com.google.android.exoplayer2.s.i.b(r1) == false) goto L_0x03b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x034c, code lost:
            if (r0.n != 0) goto L_0x035e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x034e, code lost:
            r2 = r0.l;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x0350, code lost:
            if (r2 != -1) goto L_0x0354;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x0352, code lost:
            r2 = r0.j;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0354, code lost:
            r0.l = r2;
            r2 = r0.m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x0358, code lost:
            if (r2 != -1) goto L_0x035c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x035a, code lost:
            r2 = r0.k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x035c, code lost:
            r0.m = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x035e, code lost:
            r4 = r0.l;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0362, code lost:
            if (r4 == -1) goto L_0x0376;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x0364, code lost:
            r5 = r0.m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0366, code lost:
            if (r5 == -1) goto L_0x0376;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0368, code lost:
            r26 = ((float) (r0.k * r4)) / ((float) (r0.j * r5));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0376, code lost:
            r26 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x037a, code lost:
            if (r0.q == false) goto L_0x038b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x037c, code lost:
            r15 = new com.google.android.exoplayer2.video.ColorInfo(r0.r, r0.t, r0.s, a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x038b, code lost:
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r34), r1, (java.lang.String) null, -1, r20, r0.j, r0.k, -1.0f, r3, -1, r26, r0.o, r0.p, r15, r0.i);
            r7 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x03bc, code lost:
            if ("application/x-subrip".equals(r1) == false) goto L_0x03cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x03be, code lost:
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r34), r1, r5 ? 1 : 0, r0.P, r0.i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x03d0, code lost:
            if ("text/x-ssa".equals(r1) == false) goto L_0x0405;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x03d2, code lost:
            r2 = new java.util.ArrayList(2);
            r2.add(com.google.android.exoplayer2.i.b.d.a());
            r2.add(r0.h);
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r34), r1, (java.lang.String) null, -1, r5 ? 1 : 0, r0.P, -1, r0.i, (long) com.facebook.common.time.Clock.MAX_TIME, (java.util.List<byte[]>) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x0409, code lost:
            if ("application/vobsub".equals(r1) != false) goto L_0x0424;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0411, code lost:
            if ("application/pgs".equals(r1) != false) goto L_0x0424;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x0419, code lost:
            if ("application/dvbsubs".equals(r1) == false) goto L_0x041c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x0423, code lost:
            throw new com.google.android.exoplayer2.p("Unexpected MIME type.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0424, code lost:
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r34), r1, (java.lang.String) null, -1, r3, r0.P, r0.i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x043c, code lost:
            r0.N = r33.a(r0.f9994b, r7);
            r0.N.a(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x044b, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.google.android.exoplayer2.i.g r33, int r34) throws com.google.android.exoplayer2.p {
            /*
                r32 = this;
                r0 = r32
                java.lang.String r1 = r0.f9993a
                int r2 = r1.hashCode()
                r3 = 8
                r4 = 1
                r5 = 0
                r6 = 2
                r7 = 3
                r8 = -1
                switch(r2) {
                    case -2095576542: goto L_0x0155;
                    case -2095575984: goto L_0x014b;
                    case -1985379776: goto L_0x0140;
                    case -1784763192: goto L_0x0135;
                    case -1730367663: goto L_0x012a;
                    case -1482641358: goto L_0x011f;
                    case -1482641357: goto L_0x0114;
                    case -1373388978: goto L_0x0109;
                    case -933872740: goto L_0x00fe;
                    case -538363189: goto L_0x00f3;
                    case -538363109: goto L_0x00e8;
                    case -425012669: goto L_0x00dc;
                    case -356037306: goto L_0x00d0;
                    case 62923557: goto L_0x00c4;
                    case 62923603: goto L_0x00b8;
                    case 62927045: goto L_0x00ac;
                    case 82338133: goto L_0x00a1;
                    case 82338134: goto L_0x0096;
                    case 99146302: goto L_0x008a;
                    case 444813526: goto L_0x007e;
                    case 542569478: goto L_0x0072;
                    case 725957860: goto L_0x0066;
                    case 738597099: goto L_0x005a;
                    case 855502857: goto L_0x004f;
                    case 1422270023: goto L_0x0043;
                    case 1809237540: goto L_0x0038;
                    case 1950749482: goto L_0x002c;
                    case 1950789798: goto L_0x0020;
                    case 1951062397: goto L_0x0014;
                    default: goto L_0x0012;
                }
            L_0x0012:
                goto L_0x015f
            L_0x0014:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 11
                goto L_0x0160
            L_0x0020:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 21
                goto L_0x0160
            L_0x002c:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 16
                goto L_0x0160
            L_0x0038:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 2
                goto L_0x0160
            L_0x0043:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 24
                goto L_0x0160
            L_0x004f:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 7
                goto L_0x0160
            L_0x005a:
                java.lang.String r2 = "S_TEXT/ASS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 25
                goto L_0x0160
            L_0x0066:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 23
                goto L_0x0160
            L_0x0072:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 19
                goto L_0x0160
            L_0x007e:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 9
                goto L_0x0160
            L_0x008a:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 27
                goto L_0x0160
            L_0x0096:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 1
                goto L_0x0160
            L_0x00a1:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 0
                goto L_0x0160
            L_0x00ac:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 18
                goto L_0x0160
            L_0x00b8:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 15
                goto L_0x0160
            L_0x00c4:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 12
                goto L_0x0160
            L_0x00d0:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 20
                goto L_0x0160
            L_0x00dc:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 26
                goto L_0x0160
            L_0x00e8:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 6
                goto L_0x0160
            L_0x00f3:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 4
                goto L_0x0160
            L_0x00fe:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 28
                goto L_0x0160
            L_0x0109:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 8
                goto L_0x0160
            L_0x0114:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 14
                goto L_0x0160
            L_0x011f:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 13
                goto L_0x0160
            L_0x012a:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 10
                goto L_0x0160
            L_0x0135:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 17
                goto L_0x0160
            L_0x0140:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 22
                goto L_0x0160
            L_0x014b:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 3
                goto L_0x0160
            L_0x0155:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x015f
                r1 = 5
                goto L_0x0160
            L_0x015f:
                r1 = -1
            L_0x0160:
                java.lang.String r2 = "application/vobsub"
                java.lang.String r9 = "text/x-ssa"
                java.lang.String r10 = "application/x-subrip"
                java.lang.String r11 = "audio/raw"
                java.lang.String r13 = "video/x-unknown"
                java.lang.String r14 = "audio/x-unknown"
                r15 = 0
                java.lang.String r12 = "MatroskaExtractor"
                switch(r1) {
                    case 0: goto L_0x0309;
                    case 1: goto L_0x0306;
                    case 2: goto L_0x0303;
                    case 3: goto L_0x02f5;
                    case 4: goto L_0x02f5;
                    case 5: goto L_0x02f5;
                    case 6: goto L_0x02e1;
                    case 7: goto L_0x02cd;
                    case 8: goto L_0x02b5;
                    case 9: goto L_0x02b3;
                    case 10: goto L_0x02a5;
                    case 11: goto L_0x025f;
                    case 12: goto L_0x024c;
                    case 13: goto L_0x0245;
                    case 14: goto L_0x0242;
                    case 15: goto L_0x023e;
                    case 16: goto L_0x023a;
                    case 17: goto L_0x0236;
                    case 18: goto L_0x0232;
                    case 19: goto L_0x0232;
                    case 20: goto L_0x022e;
                    case 21: goto L_0x0225;
                    case 22: goto L_0x01da;
                    case 23: goto L_0x01ab;
                    case 24: goto L_0x01a8;
                    case 25: goto L_0x01a5;
                    case 26: goto L_0x019b;
                    case 27: goto L_0x0197;
                    case 28: goto L_0x017a;
                    default: goto L_0x0172;
                }
            L_0x0172:
                com.google.android.exoplayer2.p r1 = new com.google.android.exoplayer2.p
                java.lang.String r2 = "Unrecognized codec identifier."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x017a:
                r1 = 4
                byte[] r1 = new byte[r1]
                byte[] r3 = r0.h
                byte r11 = r3[r5]
                r1[r5] = r11
                byte r11 = r3[r4]
                r1[r4] = r11
                byte r11 = r3[r6]
                r1[r6] = r11
                byte r3 = r3[r7]
                r1[r7] = r3
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r3 = "application/dvbsubs"
                goto L_0x0254
            L_0x0197:
                java.lang.String r1 = "application/pgs"
                goto L_0x030b
            L_0x019b:
                byte[] r1 = r0.h
                java.util.List r1 = java.util.Collections.singletonList(r1)
                r3 = r1
                r1 = r2
                goto L_0x030c
            L_0x01a5:
                r1 = r9
                goto L_0x030b
            L_0x01a8:
                r1 = r10
                goto L_0x030b
            L_0x01ab:
                int r1 = r0.H
                int r1 = com.google.android.exoplayer2.s.v.b((int) r1)
                if (r1 != 0) goto L_0x01d2
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r1.append(r3)
                int r3 = r0.H
                r1.append(r3)
                java.lang.String r3 = ". Setting mimeType to "
                r1.append(r3)
                r1.append(r14)
                java.lang.String r1 = r1.toString()
                android.util.Log.w(r12, r1)
                goto L_0x0222
            L_0x01d2:
                r23 = r1
                r1 = r11
                r3 = r15
                r20 = -1
                goto L_0x0310
            L_0x01da:
                com.google.android.exoplayer2.s.l r1 = new com.google.android.exoplayer2.s.l
                byte[] r3 = r0.h
                r1.<init>((byte[]) r3)
                boolean r1 = b(r1)
                if (r1 == 0) goto L_0x020e
                int r1 = r0.H
                int r1 = com.google.android.exoplayer2.s.v.b((int) r1)
                if (r1 != 0) goto L_0x01d2
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r1.append(r3)
                int r3 = r0.H
                r1.append(r3)
                java.lang.String r3 = ". Setting mimeType to "
                r1.append(r3)
                r1.append(r14)
                java.lang.String r1 = r1.toString()
                android.util.Log.w(r12, r1)
                goto L_0x0222
            L_0x020e:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r1.append(r3)
                r1.append(r14)
                java.lang.String r1 = r1.toString()
                android.util.Log.w(r12, r1)
            L_0x0222:
                r1 = r14
                goto L_0x030b
            L_0x0225:
                byte[] r1 = r0.h
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r3 = "audio/flac"
                goto L_0x0254
            L_0x022e:
                java.lang.String r1 = "audio/vnd.dts.hd"
                goto L_0x030b
            L_0x0232:
                java.lang.String r1 = "audio/vnd.dts"
                goto L_0x030b
            L_0x0236:
                java.lang.String r1 = "audio/true-hd"
                goto L_0x030b
            L_0x023a:
                java.lang.String r1 = "audio/eac3"
                goto L_0x030b
            L_0x023e:
                java.lang.String r1 = "audio/ac3"
                goto L_0x030b
            L_0x0242:
                java.lang.String r1 = "audio/mpeg"
                goto L_0x0247
            L_0x0245:
                java.lang.String r1 = "audio/mpeg-L2"
            L_0x0247:
                r3 = r15
                r20 = 4096(0x1000, float:5.74E-42)
                goto L_0x030e
            L_0x024c:
                byte[] r1 = r0.h
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r3 = "audio/mp4a-latm"
            L_0x0254:
                r20 = -1
                r23 = -1
                r31 = r3
                r3 = r1
                r1 = r31
                goto L_0x0310
            L_0x025f:
                r1 = 5760(0x1680, float:8.071E-42)
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>(r7)
                byte[] r12 = r0.h
                r11.add(r12)
                java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r3)
                java.nio.ByteOrder r13 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r12 = r12.order(r13)
                long r13 = r0.J
                java.nio.ByteBuffer r12 = r12.putLong(r13)
                byte[] r12 = r12.array()
                r11.add(r12)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)
                java.nio.ByteOrder r12 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r3 = r3.order(r12)
                long r12 = r0.K
                java.nio.ByteBuffer r3 = r3.putLong(r12)
                byte[] r3 = r3.array()
                r11.add(r3)
                java.lang.String r3 = "audio/opus"
                r1 = r3
                r3 = r11
                r20 = 5760(0x1680, float:8.071E-42)
                goto L_0x030e
            L_0x02a5:
                r1 = 8192(0x2000, float:1.14794E-41)
                byte[] r3 = r0.h
                java.util.List r3 = a((byte[]) r3)
                java.lang.String r11 = "audio/vorbis"
                r1 = r11
                r20 = 8192(0x2000, float:1.14794E-41)
                goto L_0x030e
            L_0x02b3:
                r1 = r13
                goto L_0x030b
            L_0x02b5:
                com.google.android.exoplayer2.s.l r1 = new com.google.android.exoplayer2.s.l
                byte[] r3 = r0.h
                r1.<init>((byte[]) r3)
                java.util.List r1 = a((com.google.android.exoplayer2.s.l) r1)
                if (r1 == 0) goto L_0x02c5
                java.lang.String r3 = "video/wvc1"
                goto L_0x0254
            L_0x02c5:
                java.lang.String r3 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
                android.util.Log.w(r12, r3)
                r3 = r1
                r1 = r13
                goto L_0x030c
            L_0x02cd:
                com.google.android.exoplayer2.s.l r1 = new com.google.android.exoplayer2.s.l
                byte[] r3 = r0.h
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.video.b r1 = com.google.android.exoplayer2.video.b.a(r1)
                java.util.List<byte[]> r3 = r1.f12238a
                int r1 = r1.f12239b
                r0.O = r1
                java.lang.String r1 = "video/hevc"
                goto L_0x030c
            L_0x02e1:
                com.google.android.exoplayer2.s.l r1 = new com.google.android.exoplayer2.s.l
                byte[] r3 = r0.h
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.video.a r1 = com.google.android.exoplayer2.video.a.a(r1)
                java.util.List<byte[]> r3 = r1.f12233a
                int r1 = r1.f12234b
                r0.O = r1
                java.lang.String r1 = "video/avc"
                goto L_0x030c
            L_0x02f5:
                byte[] r1 = r0.h
                if (r1 != 0) goto L_0x02fb
                r1 = r15
                goto L_0x02ff
            L_0x02fb:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x02ff:
                java.lang.String r3 = "video/mp4v-es"
                goto L_0x0254
            L_0x0303:
                java.lang.String r1 = "video/mpeg2"
                goto L_0x030b
            L_0x0306:
                java.lang.String r1 = "video/x-vnd.on2.vp9"
                goto L_0x030b
            L_0x0309:
                java.lang.String r1 = "video/x-vnd.on2.vp8"
            L_0x030b:
                r3 = r15
            L_0x030c:
                r20 = -1
            L_0x030e:
                r23 = -1
            L_0x0310:
                boolean r11 = r0.M
                r11 = r11 | r5
                boolean r12 = r0.L
                if (r12 == 0) goto L_0x0318
                r5 = 2
            L_0x0318:
                r5 = r5 | r11
                boolean r11 = com.google.android.exoplayer2.s.i.a(r1)
                if (r11 == 0) goto L_0x0344
                java.lang.String r16 = java.lang.Integer.toString(r34)
                r18 = 0
                r19 = -1
                int r2 = r0.G
                int r6 = r0.I
                com.google.android.exoplayer2.drm.DrmInitData r7 = r0.i
                java.lang.String r8 = r0.P
                r17 = r1
                r21 = r2
                r22 = r6
                r24 = r3
                r25 = r7
                r26 = r5
                r27 = r8
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (int) r19, (int) r20, (int) r21, (int) r22, (int) r23, (java.util.List<byte[]>) r24, (com.google.android.exoplayer2.drm.DrmInitData) r25, (int) r26, (java.lang.String) r27)
                r7 = 1
                goto L_0x043c
            L_0x0344:
                boolean r4 = com.google.android.exoplayer2.s.i.b(r1)
                if (r4 == 0) goto L_0x03b8
                int r2 = r0.n
                if (r2 != 0) goto L_0x035e
                int r2 = r0.l
                if (r2 != r8) goto L_0x0354
                int r2 = r0.j
            L_0x0354:
                r0.l = r2
                int r2 = r0.m
                if (r2 != r8) goto L_0x035c
                int r2 = r0.k
            L_0x035c:
                r0.m = r2
            L_0x035e:
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r4 = r0.l
                if (r4 == r8) goto L_0x0376
                int r5 = r0.m
                if (r5 == r8) goto L_0x0376
                int r2 = r0.k
                int r2 = r2 * r4
                float r2 = (float) r2
                int r4 = r0.j
                int r4 = r4 * r5
                float r4 = (float) r4
                float r2 = r2 / r4
                r26 = r2
                goto L_0x0378
            L_0x0376:
                r26 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x0378:
                boolean r2 = r0.q
                if (r2 == 0) goto L_0x038b
                byte[] r2 = r32.a()
                com.google.android.exoplayer2.video.ColorInfo r15 = new com.google.android.exoplayer2.video.ColorInfo
                int r4 = r0.r
                int r5 = r0.t
                int r7 = r0.s
                r15.<init>(r4, r5, r7, r2)
            L_0x038b:
                r29 = r15
                java.lang.String r16 = java.lang.Integer.toString(r34)
                r18 = 0
                r19 = -1
                int r2 = r0.j
                int r4 = r0.k
                r23 = -1082130432(0xffffffffbf800000, float:-1.0)
                r25 = -1
                byte[] r5 = r0.o
                int r7 = r0.p
                com.google.android.exoplayer2.drm.DrmInitData r8 = r0.i
                r17 = r1
                r21 = r2
                r22 = r4
                r24 = r3
                r27 = r5
                r28 = r7
                r30 = r8
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (int) r19, (int) r20, (int) r21, (int) r22, (float) r23, (java.util.List<byte[]>) r24, (int) r25, (float) r26, (byte[]) r27, (int) r28, (com.google.android.exoplayer2.video.ColorInfo) r29, (com.google.android.exoplayer2.drm.DrmInitData) r30)
                r7 = 2
                goto L_0x043c
            L_0x03b8:
                boolean r4 = r10.equals(r1)
                if (r4 == 0) goto L_0x03cc
                java.lang.String r2 = java.lang.Integer.toString(r34)
                java.lang.String r3 = r0.P
                com.google.android.exoplayer2.drm.DrmInitData r4 = r0.i
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r2, (java.lang.String) r1, (int) r5, (java.lang.String) r3, (com.google.android.exoplayer2.drm.DrmInitData) r4)
                goto L_0x043c
            L_0x03cc:
                boolean r4 = r9.equals(r1)
                if (r4 == 0) goto L_0x0405
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>(r6)
                byte[] r3 = com.google.android.exoplayer2.i.b.d.f9989e
                r2.add(r3)
                byte[] r3 = r0.h
                r2.add(r3)
                java.lang.String r16 = java.lang.Integer.toString(r34)
                r18 = 0
                r19 = -1
                java.lang.String r3 = r0.P
                r22 = -1
                com.google.android.exoplayer2.drm.DrmInitData r4 = r0.i
                r24 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r17 = r1
                r20 = r5
                r21 = r3
                r23 = r4
                r26 = r2
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (int) r19, (int) r20, (java.lang.String) r21, (int) r22, (com.google.android.exoplayer2.drm.DrmInitData) r23, (long) r24, (java.util.List<byte[]>) r26)
                goto L_0x043c
            L_0x0405:
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L_0x0424
                java.lang.String r2 = "application/pgs"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L_0x0424
                java.lang.String r2 = "application/dvbsubs"
                boolean r2 = r2.equals(r1)
                if (r2 == 0) goto L_0x041c
                goto L_0x0424
            L_0x041c:
                com.google.android.exoplayer2.p r1 = new com.google.android.exoplayer2.p
                java.lang.String r2 = "Unexpected MIME type."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x0424:
                java.lang.String r16 = java.lang.Integer.toString(r34)
                r18 = 0
                r19 = -1
                java.lang.String r2 = r0.P
                com.google.android.exoplayer2.drm.DrmInitData r4 = r0.i
                r17 = r1
                r20 = r3
                r21 = r2
                r22 = r4
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (int) r19, (java.util.List<byte[]>) r20, (java.lang.String) r21, (com.google.android.exoplayer2.drm.DrmInitData) r22)
            L_0x043c:
                int r2 = r0.f9994b
                r3 = r33
                com.google.android.exoplayer2.i.m r2 = r3.a(r2, r7)
                r0.N = r2
                com.google.android.exoplayer2.i.m r2 = r0.N
                r2.a(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.b.d.b.a(com.google.android.exoplayer2.i.g, int):void");
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

        private static List<byte[]> a(com.google.android.exoplayer2.s.l lVar) throws p {
            try {
                lVar.d(16);
                if (lVar.m() != 826496599) {
                    return null;
                }
                byte[] bArr = lVar.f11422a;
                for (int d2 = lVar.d() + 20; d2 < bArr.length - 4; d2++) {
                    if (bArr[d2] == 0 && bArr[d2 + 1] == 0 && bArr[d2 + 2] == 1 && bArr[d2 + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, d2, bArr.length));
                    }
                }
                throw new p("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new p("Error parsing FourCC VC1 codec private");
            }
        }

        private static List<byte[]> a(byte[] bArr) throws p {
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
                            throw new p("Error parsing vorbis codec private");
                        }
                        throw new p("Error parsing vorbis codec private");
                    }
                    throw new p("Error parsing vorbis codec private");
                }
                throw new p("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new p("Error parsing vorbis codec private");
            }
        }

        private static boolean b(com.google.android.exoplayer2.s.l lVar) throws p {
            try {
                int i2 = lVar.i();
                if (i2 == 1) {
                    return true;
                }
                if (i2 != 65534) {
                    return false;
                }
                lVar.c(24);
                if (lVar.p() == d.i.getMostSignificantBits() && lVar.p() == d.i.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new p("Error parsing MS/ACM codec private");
            }
        }
    }
}
