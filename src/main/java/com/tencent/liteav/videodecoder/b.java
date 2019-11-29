package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private MediaCodec.BufferInfo f32087a = new MediaCodec.BufferInfo();

    /* renamed from: b  reason: collision with root package name */
    private MediaCodec f32088b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f32089c = "video/avc";

    /* renamed from: d  reason: collision with root package name */
    private int f32090d = 540;

    /* renamed from: e  reason: collision with root package name */
    private int f32091e = TXEAudioDef.TXE_OPUS_SAMPLE_NUM;

    /* renamed from: f  reason: collision with root package name */
    private long f32092f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f32093g = 0;
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;
    private Surface k = null;
    private int l = 0;
    private ArrayList<TXSNALPacket> m = new ArrayList<>();
    private c n;
    private WeakReference<a> o;

    public void setListener(c cVar) {
        this.n = cVar;
    }

    public void setNotifyListener(WeakReference<a> weakReference) {
        this.o = weakReference;
    }

    public int config(Surface surface) {
        if (surface == null) {
            return -1;
        }
        this.k = surface;
        return 0;
    }

    public void decode(TXSNALPacket tXSNALPacket) {
        boolean z = true;
        if (tXSNALPacket.codecId != 1) {
            z = false;
        }
        a(z);
        this.m.add(tXSNALPacket);
        while (!this.m.isEmpty()) {
            int size = this.m.size();
            b();
            if (size == this.m.size()) {
                return;
            }
        }
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        return a(byteBuffer, byteBuffer2, z2);
    }

    public void stop() {
        a();
    }

    public boolean isHevc() {
        return this.j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8 A[SYNTHETIC, Splitter:B:46:0x00b8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(java.nio.ByteBuffer r8, java.nio.ByteBuffer r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r0 = "MediaCodecDecoder"
            r1 = 1
            r2 = 0
            r3 = 0
            r4 = -1
            android.media.MediaCodec r5 = r7.f32088b     // Catch:{ Exception -> 0x00b3 }
            if (r5 != 0) goto L_0x0092
            android.view.Surface r5 = r7.k     // Catch:{ Exception -> 0x00b3 }
            if (r5 != 0) goto L_0x0010
            goto L_0x0092
        L_0x0010:
            r7.j = r10     // Catch:{ Exception -> 0x00b3 }
            boolean r10 = r7.j     // Catch:{ Exception -> 0x00b3 }
            if (r10 == 0) goto L_0x001b
            java.lang.String r10 = "video/hevc"
            r7.f32089c = r10     // Catch:{ Exception -> 0x00b3 }
            goto L_0x001f
        L_0x001b:
            java.lang.String r10 = "video/avc"
            r7.f32089c = r10     // Catch:{ Exception -> 0x00b3 }
        L_0x001f:
            java.lang.String r10 = r7.f32089c     // Catch:{ Exception -> 0x00b3 }
            int r5 = r7.f32090d     // Catch:{ Exception -> 0x00b3 }
            int r6 = r7.f32091e     // Catch:{ Exception -> 0x00b3 }
            android.media.MediaFormat r10 = android.media.MediaFormat.createVideoFormat(r10, r5, r6)     // Catch:{ Exception -> 0x00b3 }
            if (r8 == 0) goto L_0x0030
            java.lang.String r5 = "csd-0"
            r10.setByteBuffer(r5, r8)     // Catch:{ Exception -> 0x00b3 }
        L_0x0030:
            if (r9 == 0) goto L_0x0037
            java.lang.String r8 = "csd-1"
            r10.setByteBuffer(r8, r9)     // Catch:{ Exception -> 0x00b3 }
        L_0x0037:
            java.lang.String r8 = r7.f32089c     // Catch:{ Exception -> 0x00b3 }
            android.media.MediaCodec r8 = android.media.MediaCodec.createDecoderByType(r8)     // Catch:{ Exception -> 0x00b3 }
            r7.f32088b = r8     // Catch:{ Exception -> 0x00b3 }
            android.media.MediaCodec r8 = r7.f32088b     // Catch:{ Exception -> 0x008f }
            android.view.Surface r9 = r7.k     // Catch:{ Exception -> 0x008f }
            r8.configure(r10, r9, r2, r3)     // Catch:{ Exception -> 0x008f }
            r8 = 2
            android.media.MediaCodec r9 = r7.f32088b     // Catch:{ Exception -> 0x008b }
            r9.setVideoScalingMode(r1)     // Catch:{ Exception -> 0x008b }
            r1 = 3
            android.media.MediaCodec r8 = r7.f32088b     // Catch:{ Exception -> 0x0088 }
            r8.start()     // Catch:{ Exception -> 0x0088 }
            r1 = 4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0085 }
            r8.<init>()     // Catch:{ Exception -> 0x0085 }
            java.lang.String r9 = "decode: start decoder success, is hevc: "
            r8.append(r9)     // Catch:{ Exception -> 0x0085 }
            boolean r9 = r7.j     // Catch:{ Exception -> 0x0085 }
            r8.append(r9)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r9 = " w = "
            r8.append(r9)     // Catch:{ Exception -> 0x0085 }
            int r9 = r7.f32090d     // Catch:{ Exception -> 0x0085 }
            r8.append(r9)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r9 = " h = "
            r8.append(r9)     // Catch:{ Exception -> 0x0085 }
            int r9 = r7.f32091e     // Catch:{ Exception -> 0x0085 }
            r8.append(r9)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0085 }
            com.tencent.liteav.basic.log.TXCLog.w(r0, r8)     // Catch:{ Exception -> 0x0085 }
            r7.l = r3     // Catch:{ Exception -> 0x0081 }
            goto L_0x010c
        L_0x0081:
            r8 = move-exception
            r3 = 4
            r4 = 0
            goto L_0x00b4
        L_0x0085:
            r8 = move-exception
            r3 = 4
            goto L_0x00b4
        L_0x0088:
            r8 = move-exception
            r3 = 3
            goto L_0x00b4
        L_0x008b:
            r9 = move-exception
            r8 = r9
            r3 = 2
            goto L_0x00b4
        L_0x008f:
            r8 = move-exception
            r3 = 1
            goto L_0x00b4
        L_0x0092:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b3 }
            r8.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r9 = "decode: init decoder error, can not init for decoder="
            r8.append(r9)     // Catch:{ Exception -> 0x00b3 }
            android.media.MediaCodec r9 = r7.f32088b     // Catch:{ Exception -> 0x00b3 }
            r8.append(r9)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r9 = ",surface="
            r8.append(r9)     // Catch:{ Exception -> 0x00b3 }
            android.view.Surface r9 = r7.k     // Catch:{ Exception -> 0x00b3 }
            r8.append(r9)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00b3 }
            com.tencent.liteav.basic.log.TXCLog.e(r0, r8)     // Catch:{ Exception -> 0x00b3 }
            return r4
        L_0x00b3:
            r8 = move-exception
        L_0x00b4:
            android.media.MediaCodec r9 = r7.f32088b
            if (r9 == 0) goto L_0x00e5
            r9.release()     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r9 = "decode: , decoder release success"
            com.tencent.liteav.basic.log.TXCLog.w(r0, r9)     // Catch:{ Exception -> 0x00c5 }
        L_0x00c0:
            r7.f32088b = r2
            goto L_0x00e5
        L_0x00c3:
            r8 = move-exception
            goto L_0x00e2
        L_0x00c5:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r10.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "decode: , decoder release exception: "
            r10.append(r1)     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x00c3 }
            r10.append(r1)     // Catch:{ all -> 0x00c3 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00c3 }
            com.tencent.liteav.basic.log.TXCLog.e(r0, r10)     // Catch:{ all -> 0x00c3 }
            r9.printStackTrace()     // Catch:{ all -> 0x00c3 }
            goto L_0x00c0
        L_0x00e2:
            r7.f32088b = r2
            throw r8
        L_0x00e5:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "decode: init decoder "
            r9.append(r10)
            r9.append(r3)
            java.lang.String r10 = " step exception: "
            r9.append(r10)
            java.lang.String r10 = r8.toString()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.tencent.liteav.basic.log.TXCLog.e(r0, r9)
            r8.printStackTrace()
            r7.f()
            r3 = r4
        L_0x010c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videodecoder.b.a(java.nio.ByteBuffer, java.nio.ByteBuffer, boolean):int");
    }

    private void a() {
        MediaCodec mediaCodec = this.f32088b;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                TXCLog.w("MediaCodecDecoder", "decode: stop decoder sucess");
                try {
                    this.f32088b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                } catch (Exception e2) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e2.toString());
                    e2.printStackTrace();
                } catch (Throwable th) {
                    this.f32088b = null;
                    throw th;
                }
            } catch (Exception e3) {
                TXCLog.e("MediaCodecDecoder", "decode: stop decoder Exception: " + e3.toString());
                e3.printStackTrace();
                try {
                    this.f32088b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                } catch (Exception e4) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e4.toString());
                    e4.printStackTrace();
                } catch (Throwable th2) {
                    this.f32088b = null;
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    this.f32088b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                } catch (Exception e5) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e5.toString());
                    e5.printStackTrace();
                } catch (Throwable th4) {
                    this.f32088b = null;
                    throw th4;
                }
                this.f32088b = null;
                throw th3;
            }
            this.f32088b = null;
            this.m.clear();
            this.f32092f = 0;
            this.h = true;
        }
    }

    @TargetApi(16)
    private void b() {
        int i2;
        int i3;
        if (this.f32088b == null) {
            TXCLog.e("MediaCodecDecoder", "null decoder");
            return;
        }
        TXSNALPacket tXSNALPacket = this.m.get(0);
        if (tXSNALPacket == null || tXSNALPacket.nalData.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
            this.m.remove(0);
            return;
        }
        ByteBuffer[] inputBuffers = this.f32088b.getInputBuffers();
        if (inputBuffers == null || inputBuffers.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
            return;
        }
        try {
            i2 = this.f32088b.dequeueInputBuffer(10000);
        } catch (Exception e2) {
            TXCLog.e("MediaCodecDecoder", "decode: dequeueInputBuffer Exception!! " + e2);
            i2 = -10000;
        }
        if (i2 >= 0) {
            inputBuffers[i2].put(tXSNALPacket.nalData);
            try {
                this.f32088b.queueInputBuffer(i2, 0, tXSNALPacket.nalData.length, tXSNALPacket.pts, 0);
                this.m.remove(0);
            } catch (Exception unused) {
                g();
            }
            if (this.f32092f == 0) {
                TXCLog.w("MediaCodecDecoder", "decode: input buffer available, dequeueInputBuffer index: " + i2);
            }
        } else {
            TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
        }
        try {
            i3 = this.f32088b.dequeueOutputBuffer(this.f32087a, 10000);
        } catch (Exception e3) {
            g();
            TXCLog.e("MediaCodecDecoder", "decode: dequeueOutputBuffer exception!!" + e3);
            i3 = -10000;
        }
        if (i3 >= 0) {
            a(i3, this.f32087a.presentationTimeUs, this.f32087a.presentationTimeUs, tXSNALPacket.rotation);
            this.l = 0;
        } else if (i3 == -1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
            TXCLog.d("MediaCodecDecoder", "decode: no output from decoder available when timeout fail count " + this.l);
            g();
        } else if (i3 == -3) {
            TXCLog.d("MediaCodecDecoder", "decode: output buffers changed");
        } else if (i3 == -2) {
            c();
        } else {
            TXCLog.e("MediaCodecDecoder", "decode: unexpected result from decoder.dequeueOutputBuffer: " + i3);
        }
    }

    private void a(int i2, long j2, long j3, int i3) {
        this.f32088b.releaseOutputBuffer(i2, true);
        if ((this.f32087a.flags & 4) != 0) {
            TXCLog.d("MediaCodecDecoder", "output EOS");
        }
        try {
            if (this.n != null) {
                this.n.onDecodeFrame((TXSVideoFrame) null, this.f32090d, this.f32091e, j2, j3, i3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d();
    }

    private void c() {
        MediaFormat outputFormat = this.f32088b.getOutputFormat();
        TXCLog.d("MediaCodecDecoder", "decode output format changed: " + outputFormat);
        int integer = outputFormat.getInteger("width");
        int integer2 = outputFormat.getInteger("height");
        int min = Math.min(Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1, integer);
        int min2 = Math.min(Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1, integer2);
        int i2 = this.f32090d;
        if (min == i2) {
            int i3 = this.f32091e;
            if (min2 == i3) {
                if (this.h) {
                    this.h = false;
                    c cVar = this.n;
                    if (cVar != null) {
                        cVar.onVideoSizeChange(i2, i3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.f32090d = min;
        this.f32091e = min2;
        try {
            if (this.n != null) {
                this.n.onVideoSizeChange(this.f32090d, this.f32091e);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        TXCLog.d("MediaCodecDecoder", "decode: video size change to w:" + min + ",h:" + min2);
    }

    private void d() {
        if (this.f32092f == 0) {
            TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f32092f;
        if (j2 > 0 && currentTimeMillis > j2 + 1000) {
            long j3 = this.f32093g;
            if (currentTimeMillis > 2000 + j3 && j3 != 0) {
                TXCLog.e("MediaCodecDecoder", "frame interval[" + (currentTimeMillis - this.f32092f) + "] > " + 1000);
                this.f32093g = currentTimeMillis;
            }
        }
        if (this.f32093g == 0) {
            this.f32093g = currentTimeMillis;
        }
        this.f32092f = currentTimeMillis;
    }

    private boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                for (String contains : mediaCodecInfo.getSupportedTypes()) {
                    if (contains.contains("video/hevc")) {
                        TXCLog.e("MediaCodecDecoder", "decode: video/hevc MediaCodecInfo: " + mediaCodecInfo.getName() + ",encoder:" + mediaCodecInfo.isEncoder());
                        return true;
                    }
                }
            }
            return false;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                for (String contains2 : codecInfoAt.getSupportedTypes()) {
                    if (contains2.contains("video/hevc")) {
                        TXCLog.e("MediaCodecDecoder", "video/hevc MediaCodecInfo: " + codecInfoAt.getName() + ",encoder:" + codecInfoAt.isEncoder());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void f() {
        if (!this.i) {
            TXCLog.w("MediaCodecDecoder", "decode: hw decode error, hevc: " + this.j);
            if (this.j) {
                com.tencent.liteav.basic.util.b.a(this.o, -2304, "h265解码失败");
            } else {
                com.tencent.liteav.basic.util.b.a(this.o, 2106, "硬解启动失败，采用软解");
            }
            this.i = true;
            c cVar = this.n;
            if (cVar != null) {
                cVar.onDecodeFailed(-1);
            }
        }
    }

    private void g() {
        int i2 = this.l;
        if (i2 >= 40) {
            f();
            this.l = 0;
            return;
        }
        this.l = i2 + 1;
    }

    private void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            if (!this.i) {
                if (!this.j || e()) {
                    a();
                    a((ByteBuffer) null, (ByteBuffer) null, this.j);
                    return;
                }
                a();
                f();
            }
        }
    }
}
