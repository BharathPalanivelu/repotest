package com.tencent.liteav.videoencoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.path.android.jobqueue.JobManager;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.liteav.basic.d.b;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.j;
import com.tencent.liteav.basic.d.k;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayDeque;
import javax.microedition.khronos.egl.EGLConfig;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32097a = "a";
    private boolean A;
    private boolean B;
    private ByteBuffer[] C;
    private byte[] D;
    private volatile long E;
    private long F;
    private long G;
    private long H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private boolean O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private boolean T;

    /* renamed from: b  reason: collision with root package name */
    private int f32098b;

    /* renamed from: c  reason: collision with root package name */
    private long f32099c;

    /* renamed from: d  reason: collision with root package name */
    private double f32100d;

    /* renamed from: e  reason: collision with root package name */
    private long f32101e;

    /* renamed from: f  reason: collision with root package name */
    private long f32102f;

    /* renamed from: g  reason: collision with root package name */
    private int f32103g;
    private boolean h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private long q;
    /* access modifiers changed from: private */
    public MediaCodec r;
    private c s;
    private Runnable t;
    private Runnable u;
    private Runnable v;
    private ArrayDeque<Long> w;
    private Object x;
    private Surface y;
    private boolean z;

    public void setEncodeIdrFpsFromQos(int i2) {
    }

    public a() {
        this.f32098b = 0;
        this.f32099c = 0;
        this.f32100d = 0.0d;
        this.f32101e = 0;
        this.f32102f = 0;
        this.f32103g = 0;
        this.h = false;
        this.i = true;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = new Runnable() {
            public void run() {
                a.this.e();
            }
        };
        this.u = new Runnable() {
            public void run() {
                a.this.b(10);
            }
        };
        this.v = new Runnable() {
            public void run() {
                a.this.b(1);
            }
        };
        this.w = new ArrayDeque<>(10);
        this.y = null;
        this.z = true;
        this.A = true;
        this.B = false;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.O = true;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = -1;
        this.T = false;
        this.s = new c("HWVideoEncoder");
        this.F = 0;
    }

    public int start(final TXSVideoEncoderParam tXSVideoEncoderParam) {
        super.start(tXSVideoEncoderParam);
        final boolean[] zArr = new boolean[1];
        if (Build.VERSION.SDK_INT < 18) {
            zArr[0] = false;
        } else {
            synchronized (this) {
                this.s.a((Runnable) new Runnable() {
                    public void run() {
                        if (a.this.mInit) {
                            a.this.e();
                        }
                        zArr[0] = a.this.a(tXSVideoEncoderParam);
                    }
                });
            }
        }
        if (!zArr[0]) {
            callDelegate(10000004);
        }
        if (zArr[0]) {
            return 0;
        }
        return 10000004;
    }

    public void stop() {
        this.A = true;
        synchronized (this) {
            this.s.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.mInit) {
                        a.this.e();
                    }
                }
            });
        }
    }

    public void setFPS(final int i2) {
        this.s.b(new Runnable() {
            public void run() {
                a.this.d(i2);
            }
        });
    }

    public void setBitrate(final int i2) {
        this.f32098b = i2;
        this.s.b(new Runnable() {
            public void run() {
                a.this.c(i2);
            }
        });
    }

    public void setBitrateFromQos(final int i2, int i3) {
        this.f32098b = i2;
        this.s.b(new Runnable() {
            public void run() {
                a.this.c(i2);
            }
        });
    }

    public double getRealFPS() {
        return this.f32100d;
    }

    public long getRealBitrate() {
        return this.f32099c;
    }

    public long pushVideoFrame(int i2, int i3, int i4, long j2) {
        if (this.A) {
            return 10000004;
        }
        GLES20.glFinish();
        long timeTick = TXCTimeUtil.getTimeTick();
        if (this.F == 0) {
            this.F = timeTick - j2;
        }
        this.E = timeTick - this.F;
        this.S = i2;
        this.P++;
        this.mInputWidth = i3;
        this.mInputHeight = i4;
        if (this.N) {
            f();
        }
        if (!this.O || this.T) {
            this.s.b(this.u);
            this.T = false;
        }
        return 0;
    }

    public long pushVideoFrameSync(int i2, int i3, int i4, long j2) {
        if (this.A) {
            return 10000004;
        }
        GLES20.glFinish();
        this.E = j2;
        this.S = i2;
        this.P++;
        if (this.N) {
            f();
        }
        this.s.a(this.v);
        return 0;
    }

    public void signalEOSAndFlush() {
        if (!this.A) {
            this.s.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.r != null) {
                        try {
                            a.this.r.signalEndOfInputStream();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        do {
                        } while (a.this.a(10) >= 0);
                        a.this.e();
                    }
                }
            });
        }
    }

    @TargetApi(16)
    private MediaFormat a(int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0) {
            return null;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i4 * 1024);
        createVideoFormat.setInteger("frame-rate", i5);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("i-frame-interval", i6);
        return createVideoFormat;
    }

    @TargetApi(16)
    private MediaFormat a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MediaFormat a2 = a(i2, i3, i4, i5, i6);
        if (a2 == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            MediaCodecInfo a3 = a("video/avc");
            if (a3 == null) {
                return a2;
            }
            MediaCodecInfo.CodecCapabilities capabilitiesForType = a3.getCapabilitiesForType("video/avc");
            MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
            if (encoderCapabilities.isBitrateModeSupported(i7)) {
                a2.setInteger("bitrate-mode", i7);
            } else if (encoderCapabilities.isBitrateModeSupported(2)) {
                a2.setInteger("bitrate-mode", 2);
            }
            a2.setInteger("complexity", encoderCapabilities.getComplexityRange().clamp(5).intValue());
            if (Build.VERSION.SDK_INT >= 23) {
                int i9 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                    if (codecProfileLevel.profile <= i8 && codecProfileLevel.profile > i9) {
                        i9 = codecProfileLevel.profile;
                        a2.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        a2.setInteger("level", codecProfileLevel.level);
                    }
                }
            }
        }
        return a2;
    }

    @TargetApi(16)
    private static MediaCodecInfo a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String equalsIgnoreCase : codecInfoAt.getSupportedTypes()) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private void a(long j2) {
        this.w.add(Long.valueOf(j2));
    }

    private long a() {
        Long poll = this.w.poll();
        if (poll == null) {
            return 0;
        }
        return poll.longValue();
    }

    private boolean a(Surface surface, int i2, int i3) {
        if (surface == null) {
            return false;
        }
        TXCLog.d(f32097a, "HWVideoEncode createGL");
        if (this.mGLContextExternal == null || !(this.mGLContextExternal instanceof EGLContext)) {
            this.x = b.a((EGLConfig) null, (javax.microedition.khronos.egl.EGLContext) this.mGLContextExternal, surface, i2, i3);
        } else {
            this.x = com.tencent.liteav.basic.d.c.a((android.opengl.EGLConfig) null, (EGLContext) this.mGLContextExternal, surface, i2, i3);
        }
        if (this.x == null) {
            return false;
        }
        GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
        this.mEncodeFilter = new g();
        this.mEncodeFilter.a(k.f31351e, k.a(j.NORMAL, false, false));
        if (!this.mEncodeFilter.a()) {
            this.mEncodeFilter = null;
            return false;
        }
        GLES20.glViewport(0, 0, i2, i3);
        return true;
    }

    private void b() {
        TXCLog.d(f32097a, "HWVideoEncode destroyGL");
        if (this.mEncodeFilter != null) {
            this.mEncodeFilter.d();
            this.mEncodeFilter = null;
        }
        Object obj = this.x;
        if (obj instanceof b) {
            ((b) obj).b();
            this.x = null;
        }
        Object obj2 = this.x;
        if (obj2 instanceof com.tencent.liteav.basic.d.c) {
            ((com.tencent.liteav.basic.d.c) obj2).b();
            this.x = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e7  */
    @android.annotation.TargetApi(18)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.tencent.liteav.videoencoder.TXSVideoEncoderParam r9) {
        /*
            r8 = this;
            r0 = 0
            r8.A = r0
            r8.z = r0
            r1 = 0
            r8.f32099c = r1
            r3 = 0
            r8.f32100d = r3
            r8.f32101e = r1
            r8.f32102f = r1
            r8.f32103g = r0
            r8.j = r1
            long r3 = r9.baseGopIndex
            r8.k = r3
            r8.l = r1
            long r3 = r9.baseFrameIndex
            r8.m = r3
            r8.n = r1
            r8.p = r1
            r8.q = r1
            r3 = 0
            r8.C = r3
            r8.D = r3
            r8.E = r1
            r3 = -1
            r8.I = r3
            int r4 = r9.width
            r8.mOutputWidth = r4
            int r4 = r9.height
            r8.mOutputHeight = r4
            int r4 = r9.gop
            r8.J = r4
            int r4 = r9.fps
            r8.K = r4
            java.lang.String r4 = f32097a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "FPS-TEST  HWEncode FPS start"
            r5.append(r6)
            int r6 = r8.K
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.tencent.liteav.basic.log.TXCLog.w(r4, r5)
            boolean r4 = r9.fullIFrame
            r8.N = r4
            boolean r4 = r9.syncOutput
            r8.o = r4
            boolean r4 = r9.enableEGL14
            r8.B = r4
            java.util.ArrayDeque<java.lang.Long> r4 = r8.w
            r4.clear()
            boolean r4 = r9.bLimitFps
            r8.O = r4
            r8.F = r1
            r1 = 1
            if (r9 == 0) goto L_0x00fd
            int r2 = r9.width
            if (r2 == 0) goto L_0x00fd
            int r2 = r9.height
            if (r2 == 0) goto L_0x00fd
            int r2 = r9.fps
            if (r2 == 0) goto L_0x00fd
            int r2 = r9.gop
            if (r2 != 0) goto L_0x0083
            goto L_0x00fd
        L_0x0083:
            boolean r2 = r9.annexb
            r8.h = r2
            boolean r2 = r9.appendSpsPps
            r8.i = r2
            int r2 = r8.f32098b
            if (r2 != 0) goto L_0x00b6
            int r2 = r9.width
            int r4 = r9.width
            int r2 = r2 * r4
            double r4 = (double) r2
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r6
            int r2 = r9.height
            int r6 = r9.height
            int r2 = r2 * r6
            double r6 = (double) r2
            java.lang.Double.isNaN(r6)
            double r4 = r4 + r6
            double r4 = java.lang.Math.sqrt(r4)
            r6 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r4 = r4 * r6
            int r2 = (int) r4
            r8.f32098b = r2
        L_0x00b6:
            int r2 = r8.f32098b
            long r4 = (long) r2
            r8.j = r4
            int r2 = r9.fps
            r8.f32103g = r2
            int r2 = r9.encoderMode
            r4 = 3
            r5 = 2
            if (r2 == r1) goto L_0x00c9
            if (r2 == r5) goto L_0x00cd
            if (r2 == r4) goto L_0x00cb
        L_0x00c9:
            r2 = 2
            goto L_0x00ce
        L_0x00cb:
            r2 = 0
            goto L_0x00ce
        L_0x00cd:
            r2 = 1
        L_0x00ce:
            com.tencent.liteav.basic.e.b r6 = com.tencent.liteav.basic.e.b.a()
            int r6 = r6.c()
            if (r6 != r1) goto L_0x00da
            r9.encoderProfile = r1
        L_0x00da:
            int r9 = r9.encoderProfile
            r8.L = r2
            r8.M = r1
            boolean r9 = r8.c()
            if (r9 != 0) goto L_0x00e7
            return r0
        L_0x00e7:
            r8.mInit = r1
            boolean r9 = r8.O
            if (r9 == 0) goto L_0x00fc
            r8.S = r3
            com.tencent.liteav.basic.util.c r9 = r8.s
            java.lang.Runnable r0 = r8.u
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = r8.K
            int r2 = r2 / r3
            long r2 = (long) r2
            r9.a(r0, r2)
        L_0x00fc:
            return r1
        L_0x00fd:
            r8.z = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.a.a(com.tencent.liteav.videoencoder.TXSVideoEncoderParam):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0288 A[Catch:{ IllegalStateException -> 0x0290 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(int r35) {
        /*
            r34 = this;
            r14 = r34
            android.media.MediaCodec r0 = r14.r
            r1 = -1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.media.MediaCodec$BufferInfo r0 = new android.media.MediaCodec$BufferInfo
            r0.<init>()
            android.media.MediaCodec r2 = r14.r     // Catch:{ IllegalStateException -> 0x0295 }
            r3 = r35
            int r3 = r3 * 1000
            long r3 = (long) r3     // Catch:{ IllegalStateException -> 0x0295 }
            int r15 = r2.dequeueOutputBuffer(r0, r3)     // Catch:{ IllegalStateException -> 0x0295 }
            r12 = 0
            if (r15 != r1) goto L_0x001c
            return r12
        L_0x001c:
            r2 = -3
            r13 = 1
            if (r15 != r2) goto L_0x0029
            android.media.MediaCodec r0 = r14.r
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            r14.C = r0
            return r13
        L_0x0029:
            r10 = -2
            if (r15 != r10) goto L_0x0036
            android.media.MediaCodec r0 = r14.r
            android.media.MediaFormat r0 = r0.getOutputFormat()
            r14.callDelegate((android.media.MediaFormat) r0)
            return r13
        L_0x0036:
            if (r15 >= 0) goto L_0x0039
            return r1
        L_0x0039:
            java.nio.ByteBuffer[] r2 = r14.C
            r11 = r2[r15]
            if (r11 != 0) goto L_0x0045
        L_0x003f:
            r2 = r14
            r33 = r15
        L_0x0042:
            r3 = 0
            goto L_0x0284
        L_0x0045:
            int r2 = r0.size
            byte[] r2 = new byte[r2]
            int r3 = r0.offset
            r11.position(r3)
            int r3 = r0.offset
            int r4 = r0.size
            int r3 = r3 + r4
            r11.limit(r3)
            int r3 = r0.size
            r11.get(r2, r12, r3)
            int r3 = r2.length
            int r4 = r0.size
            r5 = 5
            r19 = 4
            r6 = 2
            if (r4 <= r5) goto L_0x00a4
            byte r4 = r2[r12]
            if (r4 != 0) goto L_0x00a4
            byte r4 = r2[r13]
            if (r4 != 0) goto L_0x00a4
            byte r4 = r2[r6]
            if (r4 != 0) goto L_0x00a4
            r4 = 3
            byte r7 = r2[r4]
            if (r7 != 0) goto L_0x00a4
            byte r7 = r2[r19]
            if (r7 != 0) goto L_0x00a4
            byte r5 = r2[r5]
            if (r5 != 0) goto L_0x00a4
        L_0x007d:
            int r5 = r2.length
            int r5 = r5 + -4
            if (r4 >= r5) goto L_0x009d
            byte r5 = r2[r4]
            if (r5 != 0) goto L_0x009a
            int r5 = r4 + 1
            byte r5 = r2[r5]
            if (r5 != 0) goto L_0x009a
            int r5 = r4 + 2
            byte r5 = r2[r5]
            if (r5 != 0) goto L_0x009a
            int r5 = r4 + 3
            byte r5 = r2[r5]
            if (r5 != r13) goto L_0x009a
            int r3 = r3 - r4
            goto L_0x009e
        L_0x009a:
            int r4 = r4 + 1
            goto L_0x007d
        L_0x009d:
            r4 = 0
        L_0x009e:
            byte[] r5 = new byte[r3]
            java.lang.System.arraycopy(r2, r4, r5, r12, r3)
            goto L_0x00a5
        L_0x00a4:
            r5 = r2
        L_0x00a5:
            int r3 = r0.size
            r8 = 0
            if (r3 != 0) goto L_0x00be
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x003f
            com.tencent.liteav.videoencoder.d r0 = r14.mListener
            if (r0 == 0) goto L_0x00b9
            com.tencent.liteav.videoencoder.d r0 = r14.mListener
            r0.a(r8, r12)
        L_0x00b9:
            r2 = r14
            r33 = r15
            r1 = -2
            goto L_0x0042
        L_0x00be:
            int r3 = r0.flags
            r3 = r3 & r6
            if (r3 != r6) goto L_0x00e2
            boolean r0 = r14.h
            if (r0 == 0) goto L_0x00d0
            java.lang.Object r0 = r5.clone()
            byte[] r0 = (byte[]) r0
            r14.D = r0
            goto L_0x00dc
        L_0x00d0:
            java.lang.Object r0 = r5.clone()
            byte[] r0 = (byte[]) r0
            byte[] r0 = r14.a((byte[]) r0)
            r14.D = r0
        L_0x00dc:
            r2 = r14
            r33 = r15
            r1 = 1
            goto L_0x0042
        L_0x00e2:
            int r3 = r0.flags
            r3 = r3 & r13
            if (r3 != r13) goto L_0x0119
            r14.I = r1
            boolean r1 = r14.h
            if (r1 == 0) goto L_0x0101
            byte[] r1 = r14.D
            int r3 = r1.length
            int r4 = r5.length
            int r3 = r3 + r4
            byte[] r3 = new byte[r3]
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r12, r3, r12, r4)
            byte[] r1 = r14.D
            int r1 = r1.length
            int r4 = r5.length
            java.lang.System.arraycopy(r5, r12, r3, r1, r4)
            r4 = r3
            goto L_0x0117
        L_0x0101:
            byte[] r1 = r14.a((byte[]) r5)
            byte[] r3 = r14.D
            int r4 = r3.length
            int r5 = r1.length
            int r4 = r4 + r5
            byte[] r4 = new byte[r4]
            int r5 = r3.length
            java.lang.System.arraycopy(r3, r12, r4, r12, r5)
            byte[] r3 = r14.D
            int r3 = r3.length
            int r5 = r1.length
            java.lang.System.arraycopy(r1, r12, r4, r3, r5)
        L_0x0117:
            r3 = 0
            goto L_0x0125
        L_0x0119:
            boolean r1 = r14.h
            if (r1 != 0) goto L_0x0123
            byte[] r1 = r14.a((byte[]) r5)
            r4 = r1
            goto L_0x0124
        L_0x0123:
            r4 = r5
        L_0x0124:
            r3 = 1
        L_0x0125:
            boolean r1 = r14.N
            if (r1 != 0) goto L_0x0139
            int r1 = r14.I
            int r1 = r1 + r13
            r14.I = r1
            int r5 = r14.f32103g
            int r6 = r14.J
            int r5 = r5 * r6
            if (r1 != r5) goto L_0x0139
            r34.f()
        L_0x0139:
            long r5 = r34.a()
            long r8 = r0.presentationTimeUs
            r16 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 / r16
            long r12 = r14.H
            r22 = r11
            r10 = 0
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x014f
            r14.H = r5
        L_0x014f:
            long r12 = r14.G
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x0157
            r14.G = r8
        L_0x0157:
            long r12 = r14.H
            long r10 = r14.G
            long r12 = r12 - r10
            long r24 = r8 + r12
            long r7 = r14.n
            r9 = 1
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0168
            long r5 = r7 + r9
        L_0x0168:
            int r1 = (r5 > r24 ? 1 : (r5 == r24 ? 0 : -1))
            if (r1 <= 0) goto L_0x016e
            r5 = r24
        L_0x016e:
            r14.n = r5
            long r5 = com.tencent.liteav.basic.util.TXCTimeUtil.getTimeTick()
            if (r3 != 0) goto L_0x01b6
            long r7 = r14.f32101e
            long r16 = r7 + r16
            int r1 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r1 <= 0) goto L_0x019f
            long r11 = r14.p
            double r11 = (double) r11
            r16 = 4665518107723300864(0x40bf400000000000, double:8000.0)
            java.lang.Double.isNaN(r11)
            double r11 = r11 * r16
            long r7 = r5 - r7
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r11 = r11 / r7
            r7 = 4652218415073722368(0x4090000000000000, double:1024.0)
            double r11 = r11 / r7
            long r7 = (long) r11
            r14.f32099c = r7
            r7 = 0
            r14.p = r7
            r14.f32101e = r5
            goto L_0x01a1
        L_0x019f:
            r7 = 0
        L_0x01a1:
            long r11 = r14.k
            long r11 = r11 + r9
            r14.k = r11
            long r11 = r14.k
            r16 = 256(0x100, double:1.265E-321)
            long r16 = r11 % r16
            int r1 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x01b3
            long r11 = r11 + r9
            r14.k = r11
        L_0x01b3:
            r14.l = r7
            goto L_0x01bb
        L_0x01b6:
            long r7 = r14.l
            long r7 = r7 + r9
            r14.l = r7
        L_0x01bb:
            long r7 = r14.p
            int r1 = r4.length
            long r11 = (long) r1
            long r7 = r7 + r11
            r14.p = r7
            long r7 = r14.f32102f
            r11 = 2000(0x7d0, double:9.88E-321)
            long r11 = r11 + r7
            int r1 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x01e7
            long r11 = r14.q
            double r11 = (double) r11
            r16 = 4652007308841189376(0x408f400000000000, double:1000.0)
            java.lang.Double.isNaN(r11)
            double r11 = r11 * r16
            long r7 = r5 - r7
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r11 = r11 / r7
            r14.f32100d = r11
            r7 = 0
            r14.q = r7
            r14.f32102f = r5
        L_0x01e7:
            long r5 = r14.q
            long r5 = r5 + r9
            r14.q = r5
            int r1 = r0.offset
            r11 = r22
            r11.position(r1)
            long r5 = r14.m
            long r5 = r5 + r9
            r14.m = r5
            com.tencent.liteav.videoencoder.d r1 = r14.mListener
            if (r1 == 0) goto L_0x020d
            com.tencent.liteav.videoencoder.d r1 = r14.mListener
            r27 = 2
            long r5 = r14.k
            long r7 = r14.l
            r26 = r1
            r29 = r5
            r31 = r7
            r26.a(r27, r29, r31)
        L_0x020d:
            boolean r1 = r14.i
            if (r1 == 0) goto L_0x023e
            long r5 = r14.k
            long r7 = r14.l
            long r12 = r14.m
            if (r3 != 0) goto L_0x021c
            r22 = r7
            goto L_0x0220
        L_0x021c:
            long r1 = r7 - r9
            r22 = r1
        L_0x0220:
            r16 = 0
            r1 = r34
            r2 = r4
            r4 = r5
            r6 = r7
            r10 = 0
            r8 = r12
            r12 = r10
            r17 = r11
            r21 = -2
            r10 = r22
            r20 = 1
            r12 = r24
            r33 = r15
            r14 = r24
            r18 = r0
            r1.callDelegate(r2, r3, r4, r6, r8, r10, r12, r14, r16, r17, r18)
            goto L_0x0265
        L_0x023e:
            r17 = r11
            r33 = r15
            r20 = 1
            r21 = -2
            long r4 = r14.k
            long r6 = r14.l
            long r11 = r14.m
            if (r3 != 0) goto L_0x0251
            r22 = r6
            goto L_0x0255
        L_0x0251:
            long r9 = r6 - r9
            r22 = r9
        L_0x0255:
            r16 = 0
            r1 = r34
            r8 = r11
            r10 = r22
            r12 = r24
            r14 = r24
            r18 = r0
            r1.callDelegate(r2, r3, r4, r6, r8, r10, r12, r14, r16, r17, r18)
        L_0x0265:
            r2 = r34
            int r1 = r2.R
            int r1 = r1 + 1
            r2.R = r1
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0282
            com.tencent.liteav.videoencoder.d r0 = r2.mListener
            if (r0 == 0) goto L_0x027f
            com.tencent.liteav.videoencoder.d r0 = r2.mListener
            r1 = 0
            r3 = 0
            r0.a(r1, r3)
            goto L_0x0280
        L_0x027f:
            r3 = 0
        L_0x0280:
            r1 = -2
            goto L_0x0284
        L_0x0282:
            r3 = 0
            r1 = 1
        L_0x0284:
            android.media.MediaCodec r0 = r2.r     // Catch:{ IllegalStateException -> 0x0290 }
            if (r0 == 0) goto L_0x0294
            android.media.MediaCodec r0 = r2.r     // Catch:{ IllegalStateException -> 0x0290 }
            r4 = r33
            r0.releaseOutputBuffer(r4, r3)     // Catch:{ IllegalStateException -> 0x0290 }
            goto L_0x0294
        L_0x0290:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0294:
            return r1
        L_0x0295:
            r0 = move-exception
            r2 = r14
            r0.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.a.a(int):int");
    }

    private byte[] a(byte[] bArr) {
        int i2;
        int i3;
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 20)];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i2 >= length) {
                i3 = i2;
                break;
            }
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 1) {
                i5 = a(i2, i4, bArr2, bArr, i5);
                i2 += 3;
            } else {
                if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 0 && bArr[i2 + 3] == 1) {
                    i5 = a(i2, i4, bArr2, bArr, i5);
                    i2 += 4;
                }
                if (i2 == length - 4 || (bArr[i2 + 1] == 0 && bArr[i2 + 2] == 0 && bArr[i2 + 3] == 1)) {
                    i6 = i2 + 1;
                }
            }
            i4 = i2;
            if (i2 == length - 4) {
            }
            i6 = i2 + 1;
        }
        i3 = length;
        int a2 = a(i3, i4, bArr2, bArr, i5);
        byte[] bArr3 = new byte[a2];
        System.arraycopy(bArr2, 0, bArr3, 0, a2);
        return bArr3;
    }

    private int a(int i2, int i3, byte[] bArr, byte[] bArr2, int i4) {
        if (i3 <= 0 || i2 <= i3) {
            return i4;
        }
        int i5 = i2 - i3;
        try {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[4]);
            wrap.asIntBuffer().put(i5);
            wrap.order(ByteOrder.BIG_ENDIAN);
            System.arraycopy(wrap.array(), 0, bArr, i4, 4);
            System.arraycopy(bArr2, i3, bArr, i4 + 4, i5);
            return i4 + i5 + 4;
        } catch (Exception e2) {
            e2.printStackTrace();
            TXCLog.e(f32097a, "setNalData exception");
            return i4;
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(18)
    public void b(int i2) {
        int a2;
        if (!this.z && this.x != null) {
            int i3 = this.S;
            if (this.O) {
                this.S = -1;
                if (i3 == -1) {
                    this.T = true;
                    return;
                }
                this.s.a(this.u, (long) (1000 / this.K));
            }
            a(this.E);
            float[] a3 = this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, (FloatBuffer) null, com.tencent.liteav.basic.util.b.a(this.mInputWidth, this.mInputHeight, this.mOutputWidth, this.mOutputHeight), 0);
            int i4 = (720 - this.mRotation) % 360;
            this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, i4, a3, ((float) ((i4 == 90 || i4 == 270) ? this.mOutputHeight : this.mOutputWidth)) / ((float) ((i4 == 90 || i4 == 270) ? this.mOutputWidth : this.mOutputHeight)), false, true);
            this.mEncodeFilter.a(i3);
            Object obj = this.x;
            if (obj instanceof com.tencent.liteav.basic.d.c) {
                ((com.tencent.liteav.basic.d.c) obj).a(this.E * JobManager.NS_PER_MS);
                ((com.tencent.liteav.basic.d.c) this.x).c();
            }
            Object obj2 = this.x;
            if (obj2 instanceof b) {
                ((b) obj2).a();
            }
            do {
                a2 = a(i2);
            } while (a2 > 0);
            if (a2 == -1 || a2 == -2) {
                if (a2 == -1) {
                    callDelegate(10000005);
                }
                this.z = true;
                e();
                return;
            }
            this.Q++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x007f A[SYNTHETIC, Splitter:B:40:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e A[Catch:{ Exception -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c() {
        /*
            r13 = this;
            r0 = 5
            r1 = 0
            r2 = 0
            r3 = 1
            int r5 = r13.mOutputWidth     // Catch:{ Exception -> 0x0078 }
            int r6 = r13.mOutputHeight     // Catch:{ Exception -> 0x0078 }
            int r7 = r13.f32098b     // Catch:{ Exception -> 0x0078 }
            int r8 = r13.K     // Catch:{ Exception -> 0x0078 }
            int r9 = r13.J     // Catch:{ Exception -> 0x0078 }
            int r10 = r13.L     // Catch:{ Exception -> 0x0078 }
            int r11 = r13.M     // Catch:{ Exception -> 0x0078 }
            r4 = r13
            android.media.MediaFormat r4 = r4.a(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0078 }
            if (r4 != 0) goto L_0x001c
            r13.z = r3     // Catch:{ Exception -> 0x0078 }
            return r1
        L_0x001c:
            java.lang.String r5 = "video/avc"
            android.media.MediaCodec r5 = android.media.MediaCodec.createEncoderByType(r5)     // Catch:{ Exception -> 0x0078 }
            r13.r = r5     // Catch:{ Exception -> 0x0078 }
            r5 = 2
            android.media.MediaCodec r6 = r13.r     // Catch:{ Exception -> 0x002b }
            r6.configure(r4, r2, r2, r3)     // Catch:{ Exception -> 0x002b }
            goto L_0x0053
        L_0x002b:
            r4 = move-exception
            boolean r6 = r4 instanceof java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0076 }
            if (r6 != 0) goto L_0x003c
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0076 }
            r7 = 21
            if (r6 < r7) goto L_0x003b
            boolean r6 = r4 instanceof android.media.MediaCodec.CodecException     // Catch:{ Exception -> 0x0076 }
            if (r6 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            throw r4     // Catch:{ Exception -> 0x0076 }
        L_0x003c:
            android.media.MediaCodec r6 = r13.r     // Catch:{ Exception -> 0x0076 }
            int r8 = r13.mOutputWidth     // Catch:{ Exception -> 0x0076 }
            int r9 = r13.mOutputHeight     // Catch:{ Exception -> 0x0076 }
            int r10 = r13.f32098b     // Catch:{ Exception -> 0x0076 }
            int r11 = r13.K     // Catch:{ Exception -> 0x0076 }
            int r12 = r13.J     // Catch:{ Exception -> 0x0076 }
            r7 = r13
            android.media.MediaFormat r7 = r7.a((int) r8, (int) r9, (int) r10, (int) r11, (int) r12)     // Catch:{ Exception -> 0x0076 }
            r6.configure(r7, r2, r2, r3)     // Catch:{ Exception -> 0x0076 }
            r4.printStackTrace()     // Catch:{ Exception -> 0x0076 }
        L_0x0053:
            r4 = 3
            android.media.MediaCodec r5 = r13.r     // Catch:{ Exception -> 0x0072 }
            android.view.Surface r5 = r5.createInputSurface()     // Catch:{ Exception -> 0x0072 }
            r13.y = r5     // Catch:{ Exception -> 0x0072 }
            r4 = 4
            android.media.MediaCodec r5 = r13.r     // Catch:{ Exception -> 0x006e }
            r5.start()     // Catch:{ Exception -> 0x006e }
            android.media.MediaCodec r4 = r13.r     // Catch:{ Exception -> 0x006b }
            java.nio.ByteBuffer[] r4 = r4.getOutputBuffers()     // Catch:{ Exception -> 0x006b }
            r13.C = r4     // Catch:{ Exception -> 0x006b }
            goto L_0x0097
        L_0x006b:
            r4 = move-exception
            r5 = 5
            goto L_0x007a
        L_0x006e:
            r5 = move-exception
            r4 = r5
            r5 = 4
            goto L_0x007a
        L_0x0072:
            r5 = move-exception
            r4 = r5
            r5 = 3
            goto L_0x007a
        L_0x0076:
            r4 = move-exception
            goto L_0x007a
        L_0x0078:
            r4 = move-exception
            r5 = 1
        L_0x007a:
            r4.printStackTrace()
            if (r5 < r0) goto L_0x0088
            android.media.MediaCodec r0 = r13.r     // Catch:{ Exception -> 0x0096 }
            if (r0 == 0) goto L_0x0088
            android.media.MediaCodec r0 = r13.r     // Catch:{ Exception -> 0x0096 }
            r0.stop()     // Catch:{ Exception -> 0x0096 }
        L_0x0088:
            r13.r = r2     // Catch:{ Exception -> 0x0096 }
            android.view.Surface r0 = r13.y     // Catch:{ Exception -> 0x0096 }
            if (r0 == 0) goto L_0x0093
            android.view.Surface r0 = r13.y     // Catch:{ Exception -> 0x0096 }
            r0.release()     // Catch:{ Exception -> 0x0096 }
        L_0x0093:
            r13.y = r2     // Catch:{ Exception -> 0x0096 }
            goto L_0x0097
        L_0x0096:
        L_0x0097:
            android.media.MediaCodec r0 = r13.r
            if (r0 == 0) goto L_0x00b2
            java.nio.ByteBuffer[] r0 = r13.C
            if (r0 == 0) goto L_0x00b2
            android.view.Surface r0 = r13.y
            if (r0 != 0) goto L_0x00a4
            goto L_0x00b2
        L_0x00a4:
            int r2 = r13.mOutputWidth
            int r4 = r13.mOutputHeight
            boolean r0 = r13.a(r0, r2, r4)
            if (r0 != 0) goto L_0x00b1
            r13.z = r3
            return r1
        L_0x00b1:
            return r3
        L_0x00b2:
            r13.z = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.a.c():boolean");
    }

    private void d() {
        MediaCodec mediaCodec = this.r;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                try {
                    this.r.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
                this.r.release();
            } catch (Throwable th) {
                try {
                    this.r.release();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
            this.r = null;
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.mInit) {
            this.z = true;
            this.A = true;
            b();
            d();
            this.S = -1;
            this.f32099c = 0;
            this.f32100d = 0.0d;
            this.f32101e = 0;
            this.f32102f = 0;
            this.f32103g = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.p = 0;
            this.q = 0;
            this.mGLContextExternal = null;
            this.C = null;
            this.D = null;
            this.E = 0;
            this.mOutputWidth = 0;
            this.mOutputHeight = 0;
            this.mInit = false;
            this.mListener = null;
            this.w.clear();
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        long j2 = this.j;
        int i3 = this.f32098b;
        if (j2 != ((long) i3)) {
            this.j = (long) i3;
            if (Build.VERSION.SDK_INT >= 19 && this.r != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", this.f32098b * 1024);
                this.r.setParameters(bundle);
            }
        }
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 19 && this.r != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.r.setParameters(bundle);
        }
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        if (i2 != 0 && this.K != i2) {
            String str = f32097a;
            TXCLog.w(str, "FPS-TEST  HWEncode FPS set" + i2);
            b();
            d();
            this.K = i2;
            c();
        }
    }
}
