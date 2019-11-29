package com.shopee.arcatch.c.e.a;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.path.android.jobqueue.JobManager;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class a extends Thread implements b {

    /* renamed from: a  reason: collision with root package name */
    protected final WeakReference<c> f26786a;

    /* renamed from: b  reason: collision with root package name */
    private int f26787b;

    /* renamed from: c  reason: collision with root package name */
    private MediaCodec.BufferInfo f26788c = new MediaCodec.BufferInfo();

    /* renamed from: d  reason: collision with root package name */
    private MediaCodec f26789d;

    /* renamed from: e  reason: collision with root package name */
    private AudioRecord f26790e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer[] f26791f;

    /* renamed from: g  reason: collision with root package name */
    private int f26792g;
    private int h;
    private boolean i;
    private boolean j = false;
    private boolean k;
    private boolean l;
    private Object m = new Object();
    private long n = -1;
    private long o = 0;

    @TargetApi(21)
    public a(c cVar) {
        this.f26786a = new WeakReference<>(cVar);
        cVar.a(this);
        this.f26787b = TXRecordCommon.AUDIO_SAMPLERATE_44100;
    }

    public void run() {
        super.run();
        try {
            e();
            f();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            com.shopee.e.a.a.a(e2, "MediaAudioEncoder-run failed", new Object[0]);
        }
        try {
            g();
        } catch (Exception e3) {
            e3.printStackTrace();
            com.garena.android.appkit.d.a.a(e3);
        }
    }

    public void a() {
        this.j = false;
        synchronized (this.m) {
            this.m.notify();
        }
    }

    public void b() {
        this.j = true;
        start();
    }

    public void c() {
        this.l = true;
        synchronized (this.m) {
            this.m.notify();
        }
    }

    public void d() {
        this.l = false;
    }

    public void e() throws IOException {
        int minBufferSize = AudioRecord.getMinBufferSize(TXRecordCommon.AUDIO_SAMPLERATE_44100, 16, 2);
        this.f26792g = minBufferSize * 2;
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", TXRecordCommon.AUDIO_SAMPLERATE_44100, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 64000);
        createAudioFormat.setInteger("channel-count", 1);
        createAudioFormat.setInteger("max-input-size", minBufferSize * 4);
        this.f26789d = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.f26789d.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f26789d.start();
        this.i = false;
        this.l = true;
    }

    @TargetApi(21)
    public void f() {
        this.f26790e = new AudioRecord(1, TXRecordCommon.AUDIO_SAMPLERATE_44100, 16, 2, this.f26792g);
        this.f26790e.startRecording();
        while (this.j) {
            if (!this.l) {
                try {
                    synchronized (this.m) {
                        this.m.wait();
                    }
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            } else if (h() >= 0) {
                i();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int h() {
        /*
            r10 = this;
            android.media.MediaCodec r0 = r10.f26789d
            r1 = 10000(0x2710, double:4.9407E-320)
            int r0 = r0.dequeueInputBuffer(r1)
            if (r0 < 0) goto L_0x0045
            android.media.AudioRecord r1 = r10.f26790e
            int r1 = r1.getRecordingState()
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            android.media.MediaCodec r4 = r10.f26789d
            java.nio.ByteBuffer r4 = r4.getInputBuffer(r0)
            int r5 = r4.position()
            int r6 = r4.limit()
            if (r1 != 0) goto L_0x0032
            android.media.AudioRecord r7 = r10.f26790e
            int r4 = r7.read(r4, r6)
            if (r4 >= 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r6 = r4
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            int r2 = r6 << 3
            long r7 = r10.c(r2)
            if (r1 == 0) goto L_0x003e
            r1 = 4
            r9 = 4
            goto L_0x003f
        L_0x003e:
            r9 = 1
        L_0x003f:
            android.media.MediaCodec r3 = r10.f26789d
            r4 = r0
            r3.queueInputBuffer(r4, r5, r6, r7, r9)
        L_0x0045:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.e.a.a.h():int");
    }

    @TargetApi(21)
    public ByteBuffer a(int i2) {
        MediaCodec mediaCodec = this.f26789d;
        if (mediaCodec == null || this.f26791f == null) {
            return null;
        }
        return mediaCodec.getOutputBuffer(i2);
    }

    public void b(int i2) {
        MediaCodec mediaCodec = this.f26789d;
        if (mediaCodec != null) {
            mediaCodec.releaseOutputBuffer(i2, false);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<com.shopee.arcatch.c.e.a.c> r0 = r9.f26786a
            java.lang.Object r0 = r0.get()
            com.shopee.arcatch.c.e.a.c r0 = (com.shopee.arcatch.c.e.a.c) r0
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0018
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "muxer is unexpectedly null"
            r0[r1] = r2
            java.lang.String r1 = "MediaAudioEncoder"
            com.shopee.e.a.a.d(r1, r0)
            return
        L_0x0018:
            boolean r3 = r9.k
            if (r3 == 0) goto L_0x001d
            return
        L_0x001d:
            android.media.MediaCodec r3 = r9.f26789d
            java.nio.ByteBuffer[] r3 = r3.getOutputBuffers()
            r9.f26791f = r3
            android.media.MediaCodec r3 = r9.f26789d
            android.media.MediaCodec$BufferInfo r4 = r9.f26788c
            r5 = 10000(0x2710, double:4.9407E-320)
            int r3 = r3.dequeueOutputBuffer(r4, r5)
            r4 = -1
            if (r3 != r4) goto L_0x0034
            goto L_0x0103
        L_0x0034:
            r4 = -3
            if (r3 != r4) goto L_0x0041
            android.media.MediaCodec r0 = r9.f26789d
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            r9.f26791f = r0
            goto L_0x0103
        L_0x0041:
            r4 = -2
            if (r3 != r4) goto L_0x0079
            boolean r1 = r9.i
            if (r1 != 0) goto L_0x0071
            android.media.MediaCodec r1 = r9.f26789d
            android.media.MediaFormat r1 = r1.getOutputFormat()
            com.shopee.arcatch.c.e.a.c$a r3 = com.shopee.arcatch.c.e.a.c.a.AUDIO
            int r1 = r0.a((android.media.MediaFormat) r1, (com.shopee.arcatch.c.e.a.c.a) r3)
            r9.h = r1
            r9.i = r2
            boolean r1 = r0.f()
            if (r1 != 0) goto L_0x0103
            monitor-enter(r0)
        L_0x005f:
            boolean r1 = r0.e()     // Catch:{ all -> 0x006e }
            if (r1 != 0) goto L_0x006b
            r1 = 100
            r0.wait(r1)     // Catch:{ InterruptedException -> 0x006b }
            goto L_0x005f
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            goto L_0x0103
        L_0x006e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r1
        L_0x0071:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "format changed twice"
            r0.<init>(r1)
            throw r0
        L_0x0079:
            if (r3 >= 0) goto L_0x0096
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Unexpected result from encoder.dequeueOutputBuffer: "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0[r1] = r2
            java.lang.String r1 = "MediaAudioEncoder"
            com.shopee.e.a.a.d(r1, r0)
            goto L_0x0103
        L_0x0096:
            if (r3 < 0) goto L_0x0103
            java.nio.ByteBuffer[] r4 = r9.f26791f
            r4 = r4[r3]
            if (r4 == 0) goto L_0x00e7
            android.media.MediaCodec$BufferInfo r7 = r9.f26788c
            int r7 = r7.flags
            r7 = r7 & 2
            if (r7 == 0) goto L_0x00aa
            android.media.MediaCodec$BufferInfo r7 = r9.f26788c
            r7.size = r1
        L_0x00aa:
            android.media.MediaCodec$BufferInfo r7 = r9.f26788c
            int r7 = r7.size
            if (r7 == 0) goto L_0x00c8
            android.media.MediaCodec$BufferInfo r7 = r9.f26788c
            int r7 = r7.offset
            r4.position(r7)
            android.media.MediaCodec$BufferInfo r7 = r9.f26788c
            int r7 = r7.offset
            android.media.MediaCodec$BufferInfo r8 = r9.f26788c
            int r8 = r8.size
            int r7 = r7 + r8
            r4.limit(r7)
            android.media.MediaCodec$BufferInfo r4 = r9.f26788c
            r0.a((int) r3, (android.media.MediaCodec.BufferInfo) r4)
        L_0x00c8:
            android.media.MediaCodec$BufferInfo r3 = r9.f26788c
            int r3 = r3.flags
            r3 = r3 & 4
            if (r3 == 0) goto L_0x00de
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "AudioRecorder: EOS reached."
            r0[r1] = r3
            java.lang.String r1 = "MediaAudioEncoder"
            com.shopee.e.a.a.d(r1, r0)
            r9.k = r2
            goto L_0x0103
        L_0x00de:
            android.media.MediaCodec r3 = r9.f26789d
            android.media.MediaCodec$BufferInfo r4 = r9.f26788c
            int r3 = r3.dequeueOutputBuffer(r4, r5)
            goto L_0x0096
        L_0x00e7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "encoderOutputBuffer "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " was null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.e.a.a.i():void");
    }

    public void g() {
        AudioRecord audioRecord = this.f26790e;
        if (audioRecord != null) {
            audioRecord.stop();
            this.f26790e.release();
        }
        MediaCodec mediaCodec = this.f26789d;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f26789d.release();
        }
        if (this.i) {
            c cVar = (c) this.f26786a.get();
            if (cVar != null) {
                try {
                    cVar.g();
                } catch (Exception e2) {
                    com.shopee.e.a.a.b("MediaAudioEncoder", "failed stopping muxer", e2);
                }
            }
        }
    }

    @TargetApi(21)
    private long c(int i2) {
        long j2 = (((long) (i2 >> 4)) * JobManager.NS_PER_MS) / ((long) this.f26787b);
        long j3 = this.n;
        if (j3 < 0) {
            this.n = 0;
            this.o = j2;
            return 0;
        }
        long j4 = this.o + j3;
        this.o = j2;
        this.n = j4;
        return j4;
    }
}
