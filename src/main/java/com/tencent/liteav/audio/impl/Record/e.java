package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private MediaCodec.BufferInfo f31167a;

    /* renamed from: b  reason: collision with root package name */
    private MediaCodecInfo f31168b;

    /* renamed from: c  reason: collision with root package name */
    private MediaFormat f31169c;

    /* renamed from: d  reason: collision with root package name */
    private MediaCodec f31170d;

    /* renamed from: e  reason: collision with root package name */
    private Vector<byte[]> f31171e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<d> f31172f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f31173g = false;
    private volatile boolean h = false;
    private final Object i = new Object();
    private long j = 0;
    private int k = 48000;
    private int l = 1;
    private int m = 16;
    private byte[] n;

    static {
        b.f();
    }

    @TargetApi(16)
    public e() {
        super("TXAudioRecordThread");
    }

    public void a(int i2, int i3, int i4, int i5, WeakReference<d> weakReference) {
        this.f31172f = weakReference;
        this.f31167a = new MediaCodec.BufferInfo();
        this.f31171e = new Vector<>();
        this.k = i3;
        this.l = i4;
        this.m = i5;
        b();
    }

    public void a(byte[] bArr, long j2) {
        Vector<byte[]> vector = this.f31171e;
        if (!(vector == null || bArr == null)) {
            synchronized (vector) {
                if (this.f31171e != null) {
                    this.f31171e.add(bArr);
                } else {
                    return;
                }
            }
        }
        synchronized (this.i) {
            this.i.notify();
        }
    }

    public void a() {
        c();
    }

    private void b() {
        this.f31168b = a("audio/mp4a-latm");
        if (this.f31168b == null) {
            TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
            return;
        }
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "selected codec: " + this.f31168b.getName());
        int i2 = this.k;
        int i3 = TXRecordCommon.AUDIO_SAMPLERATE_32000;
        if (i2 >= 32000) {
            i3 = 64000;
        }
        this.f31169c = MediaFormat.createAudioFormat("audio/mp4a-latm", this.k, this.l);
        this.f31169c.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
        this.f31169c.setInteger("channel-count", this.l);
        this.f31169c.setInteger("sample-rate", this.k);
        this.f31169c.setInteger("aac-profile", 2);
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "format: " + this.f31169c);
        try {
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        start();
    }

    private void c() {
        this.h = true;
    }

    @TargetApi(16)
    private void d() throws IOException {
        if (this.f31170d == null) {
            this.f31170d = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.f31170d.configure(this.f31169c, (Surface) null, (MediaCrypto) null, 1);
            this.f31170d.start();
            TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
            this.f31173g = true;
        }
    }

    private void e() {
        MediaCodec mediaCodec = this.f31170d;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f31170d.release();
            this.f31170d = null;
        }
        this.f31173g = false;
    }

    public void run() {
        boolean isEmpty;
        byte[] remove;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
        while (!this.h) {
            if (this.f31173g) {
                synchronized (this.f31171e) {
                    isEmpty = this.f31171e.isEmpty();
                }
                if (isEmpty) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    synchronized (this.f31171e) {
                        remove = this.f31171e.remove(0);
                    }
                    if (remove != null) {
                        try {
                            allocateDirect.clear();
                            if (remove.length > allocateDirect.capacity()) {
                                allocateDirect = ByteBuffer.allocateDirect(remove.length);
                            }
                            allocateDirect.clear();
                            allocateDirect.put(remove);
                            allocateDirect.flip();
                            a(allocateDirect, remove.length, f());
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } else {
                synchronized (this.i) {
                    try {
                        this.i.wait();
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        e();
    }

    private void a(ByteBuffer byteBuffer, int i2, long j2) {
        int dequeueOutputBuffer;
        if (!this.h) {
            ByteBuffer[] inputBuffers = this.f31170d.getInputBuffers();
            int dequeueInputBuffer = this.f31170d.dequeueInputBuffer(10000);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                byteBuffer2.clear();
                if (byteBuffer != null) {
                    byteBuffer2.put(byteBuffer);
                }
                if (i2 <= 0) {
                    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "send BUFFER_FLAG_END_OF_STREAM");
                    this.f31170d.queueInputBuffer(dequeueInputBuffer, 0, 0, j2, 4);
                } else {
                    this.f31170d.queueInputBuffer(dequeueInputBuffer, 0, i2, j2, 0);
                }
            }
            ByteBuffer[] outputBuffers = this.f31170d.getOutputBuffers();
            do {
                dequeueOutputBuffer = this.f31170d.dequeueOutputBuffer(this.f31167a, 10000);
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer == -3) {
                        outputBuffers = this.f31170d.getOutputBuffers();
                        continue;
                    } else if (dequeueOutputBuffer == -2) {
                        this.f31170d.getOutputFormat();
                        continue;
                    } else if (dequeueOutputBuffer < 0) {
                        continue;
                    } else {
                        ByteBuffer byteBuffer3 = outputBuffers[dequeueOutputBuffer];
                        if ((this.f31167a.flags & 2) != 0) {
                            TXCLog.d("AudioCenter:TXCAudioHWEncoder", "drain:BUFFER_FLAG_CODEC_CONFIG");
                            this.f31167a.size = 0;
                        }
                        if (this.f31167a.size != 0) {
                            this.f31167a.presentationTimeUs = f();
                            this.n = new byte[byteBuffer3.limit()];
                            byteBuffer3.get(this.n);
                            b(this.n, this.f31167a.presentationTimeUs);
                            this.j = this.f31167a.presentationTimeUs;
                        }
                        this.f31170d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        continue;
                    }
                }
            } while (dequeueOutputBuffer >= 0);
        }
    }

    private long f() {
        long timeTick = TXCTimeUtil.getTimeTick();
        long j2 = this.j;
        return timeTick < j2 ? timeTick + (j2 - timeTick) : timeTick;
    }

    private static final MediaCodecInfo a(String str) {
        TXCLog.v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (int i3 = 0; i3 < supportedTypes.length; i3++) {
                    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "supportedType:" + codecInfoAt.getName() + ",MIME=" + supportedTypes[i3]);
                    if (supportedTypes[i3].equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private void b(byte[] bArr, long j2) {
        WeakReference<d> weakReference = this.f31172f;
        if (weakReference != null) {
            d dVar = (d) weakReference.get();
            if (dVar != null) {
                dVar.b(bArr, j2, this.k, this.l, this.m);
            }
        }
    }
}
