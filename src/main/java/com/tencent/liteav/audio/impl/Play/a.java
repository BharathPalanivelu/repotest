package com.tencent.liteav.audio.impl.Play;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f31130a = ("AudioCenter:" + a.class.getSimpleName());

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<c> f31131b = null;

    /* renamed from: c  reason: collision with root package name */
    private MediaCodec f31132c = null;

    /* renamed from: d  reason: collision with root package name */
    private MediaCodec.BufferInfo f31133d;

    /* renamed from: e  reason: collision with root package name */
    private MediaFormat f31134e;

    /* renamed from: f  reason: collision with root package name */
    private long f31135f = 0;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f31136g = false;
    private Vector<com.tencent.liteav.basic.structs.a> h;
    private List i;
    private Thread j = null;

    public void a(WeakReference<c> weakReference) {
        if (this.f31136g) {
            a();
        }
        this.f31131b = weakReference;
        this.f31135f = 0;
        this.h = new Vector<>();
        this.i = new ArrayList();
        this.f31136g = true;
        this.j = new Thread(this);
        this.j.setName(f31130a);
        this.j.start();
    }

    public void a() {
        this.f31136g = false;
        Thread thread = this.j;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.j = null;
        }
    }

    public void run() {
        boolean isEmpty;
        com.tencent.liteav.basic.structs.a remove;
        int i2;
        while (true) {
            ByteBuffer[] byteBufferArr = null;
            if (this.f31136g) {
                synchronized (this.h) {
                    isEmpty = this.h.isEmpty();
                }
                if (isEmpty) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    int i3 = -1;
                    MediaCodec mediaCodec = this.f31132c;
                    if (mediaCodec != null) {
                        try {
                            byteBufferArr = mediaCodec.getInputBuffers();
                            i2 = 1;
                            try {
                                i3 = this.f31132c.dequeueInputBuffer(10000);
                                if (i3 < 0) {
                                    return;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                String str = f31130a;
                                TXCLog.e(str, "Exception. step: " + i2 + ", error: " + e);
                                return;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            i2 = 0;
                            String str2 = f31130a;
                            TXCLog.e(str2, "Exception. step: " + i2 + ", error: " + e);
                            return;
                        }
                    }
                    synchronized (this.h) {
                        remove = this.h.remove(0);
                    }
                    if (remove.f31400d == 2) {
                        a(remove);
                    } else if (remove.f31400d == 3) {
                        this.i.add(new Long(remove.f31401e));
                        a(remove, byteBufferArr, i3);
                    } else {
                        TXCLog.e(f31130a, "not support audio format");
                    }
                }
            } else {
                MediaCodec mediaCodec2 = this.f31132c;
                if (mediaCodec2 != null) {
                    mediaCodec2.stop();
                    this.f31132c.release();
                    this.f31132c = null;
                    return;
                }
                return;
            }
        }
        while (true) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:49|50|51|52|76|75) */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0179, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x017a, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017b, code lost:
        r9 = f31130a;
        com.tencent.liteav.basic.log.TXCLog.e(r9, "CodecException1: " + r1 + ". step: " + r8);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0198, code lost:
        if (r0 > 1) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019a, code lost:
        com.tencent.liteav.basic.log.TXCLog.e(f31130a, "decoder start error!");
        r12.f31132c.release();
        r12.f31132c = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01a6, code lost:
        return -101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r12.f31132c.reset();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00e0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0156 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e0 A[LOOP:0: B:23:0x00e0->B:68:0x00e0, LOOP_START, PHI: r0 
      PHI: (r0v24 int) = (r0v23 int), (r0v25 int) binds: [B:22:0x00df, B:68:0x00e0] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:23:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0156 A[LOOP:1: B:49:0x0156->B:75:0x0156, LOOP_START, PHI: r0 
      PHI: (r0v21 int) = (r0v20 int), (r0v22 int) binds: [B:48:0x0155, B:75:0x0156] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:49:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(com.tencent.liteav.basic.structs.a r13) {
        /*
            r12 = this;
            byte[] r0 = r13.f31402f
            int r0 = r0.length
            r1 = 2
            if (r0 == r1) goto L_0x001f
            java.lang.String r0 = f31130a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "aac seq header len not equal to 2 , with len "
            r2.append(r3)
            byte[] r3 = r13.f31402f
            int r3 = r3.length
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.tencent.liteav.basic.log.TXCLog.w(r0, r2)
        L_0x001f:
            byte[] r0 = r13.f31402f
            if (r0 == 0) goto L_0x01ad
            byte[] r0 = r13.f31402f
            r2 = 0
            byte r0 = r0[r2]
            byte[] r0 = r13.f31402f
            byte r0 = r0[r2]
            r0 = r0 & 7
            r3 = 1
            int r0 = r0 << r3
            byte[] r4 = r13.f31402f
            byte r4 = r4[r3]
            r4 = r4 & 128(0x80, float:1.794E-43)
            int r4 = r4 >> 7
            r0 = r0 | r4
            int r0 = com.tencent.liteav.audio.impl.b.a(r0)
            byte[] r4 = r13.f31402f
            byte r4 = r4[r3]
            r4 = r4 & 120(0x78, float:1.68E-43)
            int r4 = r4 >> 3
            java.lang.String r5 = "audio/mp4a-latm"
            android.media.MediaFormat r0 = android.media.MediaFormat.createAudioFormat(r5, r0, r4)
            r12.f31134e = r0
            android.media.MediaFormat r0 = r12.f31134e
            r4 = 64000(0xfa00, float:8.9683E-41)
            java.lang.String r6 = "bitrate"
            r0.setInteger(r6, r4)
            android.media.MediaFormat r0 = r12.f31134e
            java.lang.String r4 = "is-adts"
            r0.setInteger(r4, r2)
            android.media.MediaFormat r0 = r12.f31134e
            java.lang.String r4 = "aac-profile"
            r0.setInteger(r4, r1)
            java.lang.String r0 = f31130a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "audio decoder media format: "
            r1.append(r4)
            android.media.MediaFormat r4 = r12.f31134e
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.tencent.liteav.basic.log.TXCLog.i(r0, r1)
            android.media.MediaCodec r0 = r12.f31132c
            if (r0 == 0) goto L_0x00ad
            r0.stop()     // Catch:{ Exception -> 0x008d }
            android.media.MediaCodec r0 = r12.f31132c     // Catch:{ Exception -> 0x008a }
            r0.release()     // Catch:{ Exception -> 0x008a }
            goto L_0x00ad
        L_0x008a:
            r0 = move-exception
            r1 = 1
            goto L_0x008f
        L_0x008d:
            r0 = move-exception
            r1 = 0
        L_0x008f:
            java.lang.String r4 = f31130a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "hw audio decoder release error: "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r1 = ". error: "
            r6.append(r1)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.tencent.liteav.basic.log.TXCLog.e(r4, r0)
        L_0x00ad:
            android.media.MediaCodec r0 = android.media.MediaCodec.createDecoderByType(r5)     // Catch:{ IOException -> 0x00b4 }
            r12.f31132c = r0     // Catch:{ IOException -> 0x00b4 }
            goto L_0x00d2
        L_0x00b4:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r1 = f31130a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "createDecoderByType exception: "
            r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tencent.liteav.basic.log.TXCLog.e(r1, r0)
        L_0x00d2:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            java.lang.String r4 = "decoder start error!"
            java.lang.String r5 = ". step: "
            r6 = -101(0xffffffffffffff9b, float:NaN)
            r7 = 0
            if (r0 < r1) goto L_0x0155
            r0 = 0
        L_0x00e0:
            android.media.MediaCodec r1 = r12.f31132c     // Catch:{ CodecException -> 0x00f1 }
            android.media.MediaFormat r8 = r12.f31134e     // Catch:{ CodecException -> 0x00f1 }
            r1.configure(r8, r7, r7, r2)     // Catch:{ CodecException -> 0x00f1 }
            android.media.MediaCodec r1 = r12.f31132c     // Catch:{ CodecException -> 0x00ee }
            r1.start()     // Catch:{ CodecException -> 0x00ee }
            goto L_0x0162
        L_0x00ee:
            r1 = move-exception
            r8 = 1
            goto L_0x00f3
        L_0x00f1:
            r1 = move-exception
            r8 = 0
        L_0x00f3:
            java.lang.String r9 = f31130a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "CodecException: "
            r10.append(r11)
            r10.append(r1)
            r10.append(r5)
            r10.append(r8)
            java.lang.String r8 = ", mediaformat: "
            r10.append(r8)
            android.media.MediaFormat r8 = r12.f31134e
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            com.tencent.liteav.basic.log.TXCLog.e(r9, r8)
            int r0 = r0 + r3
            if (r0 <= r3) goto L_0x0129
            java.lang.String r13 = f31130a
            com.tencent.liteav.basic.log.TXCLog.e(r13, r4)
            android.media.MediaCodec r13 = r12.f31132c
            r13.release()
            r12.f31132c = r7
            return r6
        L_0x0129:
            boolean r8 = r1.isRecoverable()
            if (r8 == 0) goto L_0x0135
            android.media.MediaCodec r1 = r12.f31132c     // Catch:{ Exception -> 0x00e0 }
            r1.stop()     // Catch:{ Exception -> 0x00e0 }
            goto L_0x00e0
        L_0x0135:
            boolean r1 = r1.isTransient()
            if (r1 == 0) goto L_0x0146
            r8 = 20
            java.lang.Thread.sleep(r8)     // Catch:{ InterruptedException -> 0x0141 }
            goto L_0x00e0
        L_0x0141:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x00e0
        L_0x0146:
            java.lang.String r13 = f31130a
            java.lang.String r0 = "decoder cath unrecoverable error!"
            com.tencent.liteav.basic.log.TXCLog.e(r13, r0)
            android.media.MediaCodec r13 = r12.f31132c
            r13.release()
            r12.f31132c = r7
            return r6
        L_0x0155:
            r0 = 0
        L_0x0156:
            android.media.MediaCodec r1 = r12.f31132c     // Catch:{ IllegalStateException -> 0x0179 }
            android.media.MediaFormat r8 = r12.f31134e     // Catch:{ IllegalStateException -> 0x0179 }
            r1.configure(r8, r7, r7, r2)     // Catch:{ IllegalStateException -> 0x0179 }
            android.media.MediaCodec r1 = r12.f31132c     // Catch:{ IllegalStateException -> 0x0176 }
            r1.start()     // Catch:{ IllegalStateException -> 0x0176 }
        L_0x0162:
            android.media.MediaCodec r0 = r12.f31132c
            if (r0 == 0) goto L_0x0175
            java.nio.ByteBuffer[] r0 = r0.getInputBuffers()
            android.media.MediaCodec r1 = r12.f31132c
            r3 = 10000(0x2710, double:4.9407E-320)
            int r1 = r1.dequeueInputBuffer(r3)
            r12.a(r13, r0, r1)
        L_0x0175:
            return r2
        L_0x0176:
            r1 = move-exception
            r8 = 1
            goto L_0x017b
        L_0x0179:
            r1 = move-exception
            r8 = 0
        L_0x017b:
            java.lang.String r9 = f31130a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "CodecException1: "
            r10.append(r11)
            r10.append(r1)
            r10.append(r5)
            r10.append(r8)
            java.lang.String r1 = r10.toString()
            com.tencent.liteav.basic.log.TXCLog.e(r9, r1)
            int r0 = r0 + r3
            if (r0 <= r3) goto L_0x01a7
            java.lang.String r13 = f31130a
            com.tencent.liteav.basic.log.TXCLog.e(r13, r4)
            android.media.MediaCodec r13 = r12.f31132c
            r13.release()
            r12.f31132c = r7
            return r6
        L_0x01a7:
            android.media.MediaCodec r1 = r12.f31132c     // Catch:{ Exception -> 0x0156 }
            r1.reset()     // Catch:{ Exception -> 0x0156 }
            goto L_0x0156
        L_0x01ad:
            r13 = -901(0xfffffffffffffc7b, float:NaN)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.Play.a.a(com.tencent.liteav.basic.structs.a):int");
    }

    private int a(com.tencent.liteav.basic.structs.a aVar, ByteBuffer[] byteBufferArr, int i2) {
        int dequeueOutputBuffer;
        if (i2 >= 0) {
            try {
                if (aVar.f31402f != null) {
                    ByteBuffer byteBuffer = byteBufferArr[i2];
                    byteBuffer.clear();
                    byteBuffer.put(aVar.f31402f);
                }
                if (aVar == null || aVar.f31402f.length <= 0) {
                    this.f31132c.queueInputBuffer(i2, 0, 0, b(), 4);
                } else {
                    this.f31132c.queueInputBuffer(i2, 0, aVar.f31402f.length, b(), 0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (i2 == -1) {
            return -1;
        }
        ByteBuffer[] outputBuffers = this.f31132c.getOutputBuffers();
        if (this.f31133d == null) {
            this.f31133d = new MediaCodec.BufferInfo();
        }
        do {
            dequeueOutputBuffer = this.f31132c.dequeueOutputBuffer(this.f31133d, 10000);
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f31132c.getOutputBuffers();
                continue;
            } else if (dequeueOutputBuffer == -2) {
                this.f31134e = this.f31132c.getOutputFormat();
                continue;
            } else if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                byteBuffer2.position(this.f31133d.offset);
                byteBuffer2.limit(this.f31133d.offset + this.f31133d.size);
                byte[] bArr = new byte[this.f31133d.size];
                byteBuffer2.get(bArr);
                long longValue = ((Long) this.i.get(0)).longValue();
                this.i.remove(0);
                if (this.f31131b != null) {
                    c cVar = (c) this.f31131b.get();
                    if (cVar != null) {
                        cVar.onPlayPcmData(bArr, longValue, 48000, 1);
                    }
                }
                this.f31132c.releaseOutputBuffer(dequeueOutputBuffer, false);
                continue;
            } else {
                continue;
            }
        } while (dequeueOutputBuffer >= 0);
        return 0;
    }

    private long b() {
        long timeTick = TXCTimeUtil.getTimeTick();
        long j2 = this.f31135f;
        if (timeTick < j2) {
            timeTick += j2 - timeTick;
        }
        this.f31135f = timeTick;
        return timeTick;
    }
}
