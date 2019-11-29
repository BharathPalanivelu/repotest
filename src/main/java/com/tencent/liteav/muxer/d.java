package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public static float f31676a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public static float f31677b = 0.8f;

    /* renamed from: c  reason: collision with root package name */
    public static float f31678c = 1.25f;

    /* renamed from: d  reason: collision with root package name */
    public static float f31679d = 2.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f31680e = 2;

    /* renamed from: f  reason: collision with root package name */
    private TXSWMuxerJNI f31681f;

    /* renamed from: g  reason: collision with root package name */
    private String f31682g = null;
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
        ByteBuffer f31683a;

        /* renamed from: b  reason: collision with root package name */
        MediaCodec.BufferInfo f31684b;

        public a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.f31683a = byteBuffer;
            this.f31684b = bufferInfo;
        }

        public ByteBuffer a() {
            return this.f31683a;
        }

        public MediaCodec.BufferInfo b() {
            return this.f31684b;
        }
    }

    public synchronized void a(MediaFormat mediaFormat) {
        TXCLog.d("TXCMP4SWMuxer", "addVideoTrack:" + mediaFormat);
        this.h = mediaFormat;
        this.n.clear();
    }

    public synchronized void b(MediaFormat mediaFormat) {
        TXCLog.d("TXCMP4SWMuxer", "addAudioTrack:" + mediaFormat);
        this.i = mediaFormat;
        this.o.clear();
    }

    public synchronized boolean c() {
        if (this.h != null) {
            return true;
        }
        return false;
    }

    private ByteBuffer d() {
        ByteBuffer byteBuffer = this.i.getByteBuffer("csd-0");
        byteBuffer.position(0);
        return byteBuffer;
    }

    private ByteBuffer e() {
        return this.h.getByteBuffer("csd-0");
    }

    private ByteBuffer f() {
        return this.h.getByteBuffer("csd-1");
    }

    public synchronized int a() {
        if (this.f31682g != null) {
            if (!this.f31682g.isEmpty()) {
                if (!c()) {
                    TXCLog.e("TXCMP4SWMuxer", "video track not set yet!");
                    return -2;
                } else if (this.f31681f != null) {
                    TXCLog.w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
                    return 0;
                } else {
                    TXCLog.d("TXCMP4SWMuxer", ViewProps.START);
                    this.f31681f = new TXSWMuxerJNI();
                    TXSWMuxerJNI.AVOptions aVOptions = new TXSWMuxerJNI.AVOptions();
                    if (this.h != null) {
                        int integer = this.h.getInteger("width");
                        aVOptions.videoHeight = this.h.getInteger("height");
                        aVOptions.videoWidth = integer;
                        aVOptions.videoGOP = this.h.containsKey("i-frame-interval") ? this.h.getInteger("i-frame-interval") : 3;
                    }
                    if (this.i != null) {
                        int integer2 = this.i.getInteger("channel-count");
                        int integer3 = this.i.getInteger("sample-rate");
                        aVOptions.audioChannels = integer2;
                        aVOptions.audioSampleRate = integer3;
                    }
                    ByteBuffer e2 = e();
                    ByteBuffer f2 = f();
                    ByteBuffer byteBuffer = null;
                    if (this.i != null) {
                        byteBuffer = d();
                    }
                    if (e2 != null) {
                        if (f2 != null) {
                            if (this.i == null || byteBuffer != null) {
                                this.f31681f.a(e2, e2.capacity(), f2, f2.capacity());
                                if (this.i != null) {
                                    this.f31681f.a(byteBuffer, byteBuffer.capacity());
                                }
                                this.f31681f.a(aVOptions);
                                this.f31681f.a(this.f31682g);
                                this.f31681f.a();
                                this.p = -1;
                                this.l = true;
                                this.m = false;
                                this.q = -1;
                                this.r = -1;
                                return 0;
                            }
                            TXCLog.e("TXCMP4SWMuxer", "audio format contains error csd!");
                            return -3;
                        }
                    }
                    TXCLog.e("TXCMP4SWMuxer", "video format contains error csd!");
                    return -3;
                }
            }
        }
        TXCLog.e("TXCMP4SWMuxer", "target path not set yet!");
        return -1;
    }

    public synchronized int b() {
        if (this.f31681f != null) {
            h();
            TXCLog.d("TXCMP4SWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
            try {
                if (this.l && this.m) {
                    this.f31681f.b();
                }
                this.f31681f.c();
                this.f31681f = null;
                this.l = false;
                this.f31681f = null;
                this.m = false;
                this.n.clear();
                this.o.clear();
                this.h = null;
                this.i = null;
                this.q = -1;
                this.r = -1;
            } catch (Exception e2) {
                try {
                    TXCLog.e("TXCMP4SWMuxer", "muxer stop/release exception: " + e2);
                    return -1;
                } finally {
                    this.l = false;
                    this.f31681f = null;
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
        this.f31682g = str;
        if (!TextUtils.isEmpty(this.f31682g)) {
            File file = new File(this.f31682g);
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return;
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

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.nio.ByteBuffer r7, android.media.MediaCodec.BufferInfo r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.tencent.liteav.muxer.jni.TXSWMuxerJNI r0 = r6.f31681f     // Catch:{ all -> 0x005a }
            r1 = 1
            if (r0 != 0) goto L_0x0023
            r6.a(r1, r7, r8)     // Catch:{ all -> 0x005a }
            java.lang.String r7 = "TXCMP4SWMuxer"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r0.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "cache frame before muexer ready. ptsUs: "
            r0.append(r1)     // Catch:{ all -> 0x005a }
            long r1 = r8.presentationTimeUs     // Catch:{ all -> 0x005a }
            r0.append(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x005a }
            com.tencent.liteav.basic.log.TXCLog.w(r7, r8)     // Catch:{ all -> 0x005a }
            monitor-exit(r6)
            return
        L_0x0023:
            long r2 = r6.p     // Catch:{ all -> 0x005a }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0050
            r6.a(r1, r7, r8)     // Catch:{ all -> 0x005a }
            long r7 = r6.g()     // Catch:{ all -> 0x005a }
            r6.p = r7     // Catch:{ all -> 0x005a }
            java.lang.String r7 = "TXCMP4SWMuxer"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r8.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r0 = "first frame offset = "
            r8.append(r0)     // Catch:{ all -> 0x005a }
            long r0 = r6.p     // Catch:{ all -> 0x005a }
            r8.append(r0)     // Catch:{ all -> 0x005a }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x005a }
            com.tencent.liteav.basic.log.TXCLog.d(r7, r8)     // Catch:{ all -> 0x005a }
            r6.i()     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x0050:
            long r0 = r8.presentationTimeUs     // Catch:{ all -> 0x005a }
            r6.a((long) r0)     // Catch:{ all -> 0x005a }
            r6.c(r7, r8)     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r6)
            return
        L_0x005a:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.muxer.d.a(java.nio.ByteBuffer, android.media.MediaCodec$BufferInfo):void");
    }

    public synchronized void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        a(false, byteBuffer, bufferInfo);
    }

    private void c(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        float f2;
        float f3;
        long j2 = bufferInfo.presentationTimeUs - this.p;
        if (j2 < 0) {
            TXCLog.e("TXCMP4SWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + bufferInfo.presentationTimeUs);
            j2 = this.q;
            if (j2 <= 0) {
                j2 = 0;
            }
        }
        if (j2 < this.q) {
            TXCLog.w("TXCMP4SWMuxer", "video is not in chronological order. current frame's pts(" + j2 + ") smaller than pre frame's pts(" + this.q + SQLBuilder.PARENTHESES_RIGHT);
        } else {
            this.q = j2;
        }
        int i2 = this.f31680e;
        if (i2 != 2) {
            if (i2 == 3) {
                f2 = (float) j2;
                f3 = f31677b;
            } else if (i2 == 4) {
                f2 = (float) j2;
                f3 = f31676a;
            } else if (i2 == 1) {
                f2 = (float) j2;
                f3 = f31678c;
            } else if (i2 == 0) {
                f2 = (float) j2;
                f3 = f31679d;
            }
            j2 = (long) (f2 * f3);
        }
        bufferInfo.presentationTimeUs = j2;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f31681f.a(byteBuffer, 1, bufferInfo.offset, bufferInfo.size, bufferInfo.flags == 1 ? 1 : 0, bufferInfo.presentationTimeUs);
            if ((bufferInfo.flags & 1) != 0) {
                this.m = true;
            }
        } catch (IllegalStateException e2) {
            TXCLog.e("TXCMP4SWMuxer", "write frame IllegalStateException: " + e2);
        } catch (IllegalArgumentException e3) {
            TXCLog.e("TXCMP4SWMuxer", "write frame IllegalArgumentException: " + e3);
        }
    }

    private void d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        float f2;
        float f3;
        long j2 = bufferInfo.presentationTimeUs;
        long j3 = this.p;
        long j4 = j2 - j3;
        if (j3 < 0 || j4 < 0) {
            TXCLog.w("TXCMP4SWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            return;
        }
        if (j4 < this.r) {
            TXCLog.e("TXCMP4SWMuxer", "audio is not in chronological order. current audio's pts pts(" + j4 + ") must larger than pre audio's pts(" + this.r + SQLBuilder.PARENTHESES_RIGHT);
            j4 = this.r + 1;
        } else {
            this.r = j4;
        }
        int i2 = this.f31680e;
        if (i2 != 2) {
            if (i2 == 3) {
                f2 = (float) j4;
                f3 = f31677b;
            } else if (i2 == 4) {
                f2 = (float) j4;
                f3 = f31676a;
            } else if (i2 == 1) {
                f2 = (float) j4;
                f3 = f31678c;
            } else if (i2 == 0) {
                f2 = (float) j4;
                f3 = f31679d;
            }
            j4 = (long) (f2 * f3);
        }
        bufferInfo.presentationTimeUs = j4;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f31681f.a(byteBuffer, 0, bufferInfo.offset, bufferInfo.size, bufferInfo.flags, bufferInfo.presentationTimeUs);
        } catch (IllegalStateException e2) {
            TXCLog.e("TXCMP4SWMuxer", "write sample IllegalStateException: " + e2);
        } catch (IllegalArgumentException e3) {
            TXCLog.e("TXCMP4SWMuxer", "write sample IllegalArgumentException: " + e3);
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
            if (!z) {
                this.o.add(aVar);
            } else if (this.n.size() < 200) {
                this.n.add(aVar);
            } else {
                TXCLog.e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
            }
        }
    }

    private long g() {
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

    private void h() {
        while (this.n.size() > 0) {
            a poll = this.n.poll();
            c(poll.a(), poll.b());
        }
        while (this.o.size() > 0) {
            a poll2 = this.o.poll();
            d(poll2.a(), poll2.b());
        }
    }

    private void i() {
        while (this.n.size() > 0) {
            a poll = this.n.poll();
            a(poll.b().presentationTimeUs);
            c(poll.a(), poll.b());
        }
    }

    private void a(long j2) {
        while (this.o.size() > 0) {
            if (this.o.peek().b() == null) {
                TXCLog.e("TXCMP4SWMuxer", "flushAudioCache, bufferInfo is null");
                this.o.remove();
            } else if (this.o.peek().b().presentationTimeUs < j2) {
                a poll = this.o.poll();
                d(poll.a(), poll.b());
            } else {
                return;
            }
        }
    }
}
