package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.media.AudioTrack;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    static d f31142a = new d();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f31143b = ("AudioCenter:" + d.class.getSimpleName());

    /* renamed from: c  reason: collision with root package name */
    private a f31144c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f31145d = false;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f31146e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f31147f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f31148g = 0;
    /* access modifiers changed from: private */
    public volatile boolean h = false;
    /* access modifiers changed from: private */
    public int i = 48000;
    /* access modifiers changed from: private */
    public int j = 2;
    /* access modifiers changed from: private */
    public int k = 16;

    class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        volatile boolean f31150b = false;

        public a(String str) {
            super(str);
        }

        public void a() {
            this.f31150b = true;
        }

        public void b() {
            this.f31150b = false;
        }
    }

    private d() {
    }

    public static d a() {
        return f31142a;
    }

    public void b() {
        TXCLog.w(f31143b, "mult-track-player start!");
        if (this.f31146e) {
            TXCLog.e(f31143b, "mult-track-player can not start because of has started!");
        } else if (this.i == 0 || this.j == 0) {
            String str = f31143b;
            TXCLog.e(str, "strat mult-track-player failed with invalid audio info , samplerate:" + this.i + ", channels:" + this.j);
        } else {
            this.f31146e = true;
            if (this.f31144c == null) {
                this.f31144c = new a("AUDIO_TRACK") {
                    public void run() {
                        a();
                        try {
                            int i = d.this.j == 1 ? 2 : 3;
                            int i2 = d.this.k == 8 ? 3 : 2;
                            AudioTrack audioTrack = new AudioTrack(3, d.this.i, i, i2, AudioTrack.getMinBufferSize(d.this.i, i, i2), 1);
                            String e2 = d.f31143b;
                            TXCLog.i(e2, "create audio track, samplerate:" + d.this.i + ", channels:" + d.this.j + ", bits:" + d.this.k);
                            try {
                                audioTrack.play();
                                boolean unused = d.this.h = true;
                                d dVar = d.this;
                                dVar.a(dVar.f31147f, d.this.f31148g);
                                int i3 = 100;
                                int i4 = 0;
                                while (this.f31150b) {
                                    byte[] nativeGetMixedTracksData = b.nativeGetMixedTracksData(d.this.j * 2048);
                                    TXCAudioBasePlayController.onCorePlayPcmData(nativeGetMixedTracksData, 0, d.this.i, d.this.j);
                                    if (nativeGetMixedTracksData == null || nativeGetMixedTracksData.length <= 0) {
                                        try {
                                            sleep(5);
                                        } catch (InterruptedException unused2) {
                                        }
                                    } else {
                                        if (d.this.f31145d) {
                                            Arrays.fill(nativeGetMixedTracksData, (byte) 0);
                                        }
                                        if (i3 != 0 && i4 < 800) {
                                            short[] sArr = new short[(nativeGetMixedTracksData.length / 2)];
                                            ByteBuffer.wrap(nativeGetMixedTracksData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                                            for (int i5 = 0; i5 < sArr.length; i5++) {
                                                sArr[i5] = (short) (sArr[i5] / i3);
                                            }
                                            ByteBuffer.wrap(nativeGetMixedTracksData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr);
                                            i4 += nativeGetMixedTracksData.length / ((d.this.i * 2) / 1000);
                                            i3 = (i3 * (800 - i4)) / 800;
                                        }
                                        audioTrack.write(nativeGetMixedTracksData, 0, nativeGetMixedTracksData.length);
                                    }
                                }
                                try {
                                    audioTrack.pause();
                                    audioTrack.flush();
                                    audioTrack.stop();
                                    audioTrack.release();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                TXCLog.e(d.f31143b, "mult-player thread stop finish!");
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                };
                this.f31144c.start();
            }
            TXCLog.w(f31143b, "mult-track-player thread start finish!");
        }
    }

    public void c() {
        TXCLog.w(f31143b, "mult-track-player stop!");
        if (!this.f31146e) {
            TXCLog.w(f31143b, "mult-track-player can not stop because of not started yet!");
            return;
        }
        a aVar = this.f31144c;
        if (aVar != null) {
            aVar.b();
            this.f31144c = null;
        }
        this.f31148g = 0;
        this.f31147f = null;
        this.h = false;
        this.f31146e = false;
        TXCLog.w(f31143b, "mult-track-player stop finish!");
    }

    public synchronized void a(Context context, int i2) {
        this.f31147f = context;
        this.f31148g = i2;
        if (this.h) {
            TXCLog.w(f31143b, "mult-track-player setAudioRoute~");
            com.tencent.liteav.audio.impl.a.a().b(i2);
        } else {
            TXCLog.w(f31143b, "mult-track-player do'not setAudioRoute~");
        }
    }

    public boolean d() {
        return this.f31146e;
    }
}
