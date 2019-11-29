package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.facebook.react.uimanager.ViewProps;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static float f31665a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public static float f31666b = 0.8f;

    /* renamed from: c  reason: collision with root package name */
    public static float f31667c = 1.25f;

    /* renamed from: d  reason: collision with root package name */
    public static float f31668d = 2.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f31669e = 2;

    /* renamed from: f  reason: collision with root package name */
    private MediaMuxer f31670f;

    /* renamed from: g  reason: collision with root package name */
    private String f31671g = null;
    private MediaFormat h = null;
    private MediaFormat i = null;
    private int j = 0;
    private int k = 0;
    private boolean l = false;
    private boolean m = false;
    private ConcurrentLinkedQueue<a> n = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<a> o = new ConcurrentLinkedQueue<>();
    private long p = -1;
    private long q = -1;
    private long r = -1;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        ByteBuffer f31672a;

        /* renamed from: b  reason: collision with root package name */
        MediaCodec.BufferInfo f31673b;

        public a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.f31672a = byteBuffer;
            this.f31673b = bufferInfo;
        }

        public ByteBuffer a() {
            return this.f31672a;
        }

        public MediaCodec.BufferInfo b() {
            return this.f31673b;
        }
    }

    public synchronized void a(MediaFormat mediaFormat) {
        TXCLog.d("TXCMP4HWMuxer", "addVideoTrack:" + mediaFormat);
        this.h = mediaFormat;
        this.n.clear();
    }

    public synchronized void b(MediaFormat mediaFormat) {
        TXCLog.d("TXCMP4HWMuxer", "addAudioTrack:" + mediaFormat);
        this.i = mediaFormat;
        this.o.clear();
    }

    public synchronized boolean c() {
        if (this.h != null) {
            return true;
        }
        return false;
    }

    public synchronized int a() {
        if (this.f31671g != null) {
            if (!this.f31671g.isEmpty()) {
                if (!c()) {
                    TXCLog.e("TXCMP4HWMuxer", "video track not set yet!");
                    return -2;
                } else if (this.f31670f != null) {
                    TXCLog.w("TXCMP4HWMuxer", "start has been called. stop must be called before start");
                    return 0;
                } else {
                    TXCLog.d("TXCMP4HWMuxer", ViewProps.START);
                    try {
                        this.f31670f = new MediaMuxer(this.f31671g, 0);
                        if (this.h != null) {
                            try {
                                this.k = this.f31670f.addTrack(this.h);
                            } catch (IllegalArgumentException e2) {
                                TXCLog.e("TXCMP4HWMuxer", "addVideoTrack IllegalArgumentException: " + e2);
                                return -5;
                            } catch (IllegalStateException e3) {
                                TXCLog.e("TXCMP4HWMuxer", "addVideoTrack IllegalStateException: " + e3);
                                return -6;
                            }
                        }
                        if (this.i != null) {
                            try {
                                this.j = this.f31670f.addTrack(this.i);
                            } catch (IllegalArgumentException e4) {
                                TXCLog.e("TXCMP4HWMuxer", "addAudioTrack IllegalArgumentException: " + e4);
                                return -7;
                            } catch (IllegalStateException e5) {
                                TXCLog.e("TXCMP4HWMuxer", "addAudioTrack IllegalStateException: " + e5);
                                return -8;
                            }
                        }
                        this.f31670f.start();
                        this.p = -1;
                        this.l = true;
                        this.m = false;
                        this.q = -1;
                        this.r = -1;
                        return 0;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        TXCLog.e("TXCMP4HWMuxer", "create MediaMuxer exception:" + e6);
                        return -4;
                    }
                }
            }
        }
        TXCLog.e("TXCMP4HWMuxer", "target path not set yet!");
        return -1;
    }

    public synchronized int b() {
        if (this.f31670f != null) {
            TXCLog.d("TXCMP4HWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
            try {
                if (this.l && this.m) {
                    this.f31670f.stop();
                }
                this.f31670f.release();
                this.l = false;
                this.f31670f = null;
                this.m = false;
                this.n.clear();
                this.o.clear();
                this.h = null;
                this.i = null;
                this.q = -1;
                this.r = -1;
            } catch (Exception e2) {
                try {
                    TXCLog.e("TXCMP4HWMuxer", "muxer stop/release exception: " + e2);
                    return -1;
                } finally {
                    this.l = false;
                    this.f31670f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.h = null;
                    this.i = null;
                    this.q = -1;
                    this.r = -1;
                }
            }
        }
        return 0;
    }

    public synchronized void a(String str) {
        this.f31671g = str;
    }

    public synchronized void b(byte[] bArr, int i2, int i3, long j2, int i4) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
        allocateDirect.put(bArr, i2, i3);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.presentationTimeUs = j2;
        bufferInfo.offset = 0;
        bufferInfo.size = i3;
        bufferInfo.flags = i4;
        a(allocateDirect, bufferInfo);
    }

    public synchronized void a(byte[] bArr, int i2, int i3, long j2, int i4) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
        allocateDirect.put(bArr, i2, i3);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.presentationTimeUs = j2;
        bufferInfo.offset = 0;
        bufferInfo.size = i3;
        bufferInfo.flags = i4;
        b(allocateDirect, bufferInfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.nio.ByteBuffer r7, android.media.MediaCodec.BufferInfo r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            android.media.MediaMuxer r0 = r6.f31670f     // Catch:{ all -> 0x0055 }
            r1 = 1
            if (r0 != 0) goto L_0x0023
            r6.a(r1, r7, r8)     // Catch:{ all -> 0x0055 }
            java.lang.String r7 = "TXCMP4HWMuxer"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r0.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "cache frame before muexer ready. ptsUs: "
            r0.append(r1)     // Catch:{ all -> 0x0055 }
            long r1 = r8.presentationTimeUs     // Catch:{ all -> 0x0055 }
            r0.append(r1)     // Catch:{ all -> 0x0055 }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0055 }
            com.tencent.liteav.basic.log.TXCLog.w(r7, r8)     // Catch:{ all -> 0x0055 }
            monitor-exit(r6)
            return
        L_0x0023:
            long r2 = r6.p     // Catch:{ all -> 0x0055 }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0050
            r6.a(r1, r7, r8)     // Catch:{ all -> 0x0055 }
            long r7 = r6.d()     // Catch:{ all -> 0x0055 }
            r6.p = r7     // Catch:{ all -> 0x0055 }
            java.lang.String r7 = "TXCMP4HWMuxer"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r8.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = "first frame offset = "
            r8.append(r0)     // Catch:{ all -> 0x0055 }
            long r0 = r6.p     // Catch:{ all -> 0x0055 }
            r8.append(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0055 }
            com.tencent.liteav.basic.log.TXCLog.d(r7, r8)     // Catch:{ all -> 0x0055 }
            r6.e()     // Catch:{ all -> 0x0055 }
            goto L_0x0053
        L_0x0050:
            r6.c(r7, r8)     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r6)
            return
        L_0x0055:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.muxer.b.a(java.nio.ByteBuffer, android.media.MediaCodec$BufferInfo):void");
    }

    public synchronized void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f31670f != null) {
            if (this.p >= 0) {
                d(byteBuffer, bufferInfo);
                return;
            }
        }
        TXCLog.w("TXCMP4HWMuxer", "cache sample before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
        a(false, byteBuffer, bufferInfo);
    }

    private void c(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        float f2;
        float f3;
        long j2 = bufferInfo.presentationTimeUs - this.p;
        if (j2 < 0) {
            TXCLog.e("TXCMP4HWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + bufferInfo.presentationTimeUs);
            j2 = this.q;
            if (j2 <= 0) {
                j2 = 0;
            }
        }
        if (j2 < this.q) {
            TXCLog.w("TXCMP4HWMuxer", "video is not in chronological order. current frame's pts(" + j2 + ") smaller than pre frame's pts(" + this.q + SQLBuilder.PARENTHESES_RIGHT);
        } else {
            this.q = j2;
        }
        int i2 = this.f31669e;
        if (i2 != 2) {
            if (i2 == 3) {
                f2 = (float) j2;
                f3 = f31666b;
            } else if (i2 == 4) {
                f2 = (float) j2;
                f3 = f31665a;
            } else if (i2 == 1) {
                f2 = (float) j2;
                f3 = f31667c;
            } else if (i2 == 0) {
                f2 = (float) j2;
                f3 = f31668d;
            }
            j2 = (long) (f2 * f3);
        }
        bufferInfo.presentationTimeUs = j2;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f31670f.writeSampleData(this.k, byteBuffer, bufferInfo);
            if ((bufferInfo.flags & 1) != 0) {
                this.m = true;
            }
        } catch (IllegalStateException e2) {
            TXCLog.e("TXCMP4HWMuxer", "write frame IllegalStateException: " + e2);
        } catch (IllegalArgumentException e3) {
            TXCLog.e("TXCMP4HWMuxer", "write frame IllegalArgumentException: " + e3);
        }
    }

    private void d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        float f2;
        float f3;
        long j2 = bufferInfo.presentationTimeUs;
        long j3 = this.p;
        long j4 = j2 - j3;
        if (j3 < 0 || j4 < 0) {
            TXCLog.w("TXCMP4HWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            return;
        }
        if (j4 < this.r) {
            TXCLog.e("TXCMP4HWMuxer", "audio is not in chronological order. current audio's pts pts(" + j4 + ") must larger than pre audio's pts(" + this.r + SQLBuilder.PARENTHESES_RIGHT);
            j4 = this.r + 1;
        } else {
            this.r = j4;
        }
        int i2 = this.f31669e;
        if (i2 != 2) {
            if (i2 == 3) {
                f2 = (float) j4;
                f3 = f31666b;
            } else if (i2 == 4) {
                f2 = (float) j4;
                f3 = f31665a;
            } else if (i2 == 1) {
                f2 = (float) j4;
                f3 = f31667c;
            } else if (i2 == 0) {
                f2 = (float) j4;
                f3 = f31668d;
            }
            j4 = (long) (f2 * f3);
        }
        bufferInfo.presentationTimeUs = j4;
        try {
            this.f31670f.writeSampleData(this.j, byteBuffer, bufferInfo);
        } catch (IllegalStateException e2) {
            TXCLog.e("TXCMP4HWMuxer", "write sample IllegalStateException: " + e2);
        } catch (IllegalArgumentException e3) {
            TXCLog.e("TXCMP4HWMuxer", "write sample IllegalArgumentException: " + e3);
        }
    }

    private void a(boolean z, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (byteBuffer != null && bufferInfo != null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
            byteBuffer.rewind();
            if (bufferInfo.size > 0) {
                byteBuffer.position(bufferInfo.offset);
                byteBuffer.limit(bufferInfo.size);
            }
            allocateDirect.rewind();
            allocateDirect.put(byteBuffer);
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
            a aVar = new a(allocateDirect, bufferInfo2);
            if (z) {
                if (this.n.size() < 200) {
                    this.n.add(aVar);
                } else {
                    TXCLog.e("TXCMP4HWMuxer", "drop video frame. video cache size is larger than 200");
                }
            } else if (this.o.size() < 600) {
                this.o.add(aVar);
            } else {
                TXCLog.e("TXCMP4HWMuxer", "drop audio frame. audio cache size is larger than 600");
            }
        }
    }

    private long d() {
        long j2 = this.n.size() > 0 ? this.n.peek().b().presentationTimeUs : 0;
        if (this.o.size() <= 0) {
            return j2;
        }
        a peek = this.o.peek();
        if (peek == null || peek.b() == null) {
            return j2;
        }
        long j3 = this.o.peek().b().presentationTimeUs;
        return j2 > j3 ? j3 : j2;
    }

    private void e() {
        while (this.n.size() > 0) {
            a poll = this.n.poll();
            c(poll.a(), poll.b());
        }
        while (this.o.size() > 0) {
            a poll2 = this.o.poll();
            d(poll2.a(), poll2.b());
        }
    }
}
