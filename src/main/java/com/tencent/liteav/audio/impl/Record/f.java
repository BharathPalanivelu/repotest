package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f31174a = ("AudioCenter:" + f.class.getSimpleName());

    /* renamed from: b  reason: collision with root package name */
    private static f f31175b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f31176c;

    /* renamed from: d  reason: collision with root package name */
    private int f31177d = 48000;

    /* renamed from: e  reason: collision with root package name */
    private int f31178e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f31179f = 16;

    /* renamed from: g  reason: collision with root package name */
    private int f31180g = 0;
    private AudioRecord h;
    private byte[] i = null;
    private WeakReference<h> j;
    private Thread k = null;
    private boolean l = false;

    public static f a() {
        if (f31175b == null) {
            synchronized (f.class) {
                if (f31175b == null) {
                    f31175b = new f();
                }
            }
        }
        return f31175b;
    }

    private f() {
    }

    public synchronized void a(h hVar) {
        if (hVar == null) {
            this.j = null;
        } else {
            this.j = new WeakReference<>(hVar);
        }
    }

    public void a(Context context, int i2, int i3, int i4, int i5) {
        b();
        this.f31176c = context;
        this.f31177d = i2;
        this.f31178e = i3;
        this.f31179f = i4;
        this.f31180g = i5;
        this.l = true;
        this.k = new Thread(this, "AudioSysRecord Thread");
        this.k.start();
    }

    public void b() {
        this.l = false;
        long currentTimeMillis = System.currentTimeMillis();
        Thread thread = this.k;
        if (!(thread == null || !thread.isAlive() || Thread.currentThread().getId() == this.k.getId())) {
            try {
                this.k.join();
            } catch (Exception e2) {
                e2.printStackTrace();
                String str = f31174a;
                TXCLog.e(str, "record stop Exception: " + e2.getMessage());
            }
        }
        String str2 = f31174a;
        TXCLog.i(str2, "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.k = null;
    }

    public synchronized boolean c() {
        return this.l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r18 = this;
            r1 = r18
            int r8 = r1.f31177d
            int r9 = r1.f31178e
            int r10 = r1.f31179f
            int r0 = r1.f31180g
            java.lang.String r2 = f31174a
            r11 = 4
            java.lang.Object[] r3 = new java.lang.Object[r11]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r12 = 0
            r3[r12] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            r13 = 1
            r3[r13] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r14 = 2
            r3[r14] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r15 = 3
            r3[r15] = r4
            java.lang.String r4 = "audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            com.tencent.liteav.basic.log.TXCLog.i(r2, r3)
            if (r9 != r13) goto L_0x003b
            r2 = 16
            r5 = 16
            goto L_0x003f
        L_0x003b:
            r2 = 12
            r5 = 12
        L_0x003f:
            r7 = 8
            if (r10 != r7) goto L_0x0045
            r6 = 3
            goto L_0x0046
        L_0x0045:
            r6 = 2
        L_0x0046:
            int r4 = android.media.AudioRecord.getMinBufferSize(r8, r5, r6)
            if (r0 != r13) goto L_0x007b
            java.lang.String r0 = f31174a     // Catch:{ IllegalArgumentException -> 0x0076 }
            java.lang.String r2 = "audio record type: system aec"
            com.tencent.liteav.basic.log.TXCLog.i(r0, r2)     // Catch:{ IllegalArgumentException -> 0x0076 }
            android.content.Context r0 = r1.f31176c     // Catch:{ IllegalArgumentException -> 0x0076 }
            if (r0 == 0) goto L_0x0064
            android.content.Context r0 = r1.f31176c     // Catch:{ IllegalArgumentException -> 0x0076 }
            java.lang.String r2 = "audio"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ IllegalArgumentException -> 0x0076 }
            android.media.AudioManager r0 = (android.media.AudioManager) r0     // Catch:{ IllegalArgumentException -> 0x0076 }
            r0.setMode(r15)     // Catch:{ IllegalArgumentException -> 0x0076 }
        L_0x0064:
            android.media.AudioRecord r0 = new android.media.AudioRecord     // Catch:{ IllegalArgumentException -> 0x0076 }
            r3 = 7
            int r16 = r4 * 2
            r2 = r0
            r11 = r4
            r4 = r8
            r17 = 8
            r7 = r16
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x0092 }
            r1.h = r0     // Catch:{ IllegalArgumentException -> 0x0092 }
            goto L_0x0096
        L_0x0076:
            r0 = move-exception
            r11 = r4
            r17 = 8
            goto L_0x0093
        L_0x007b:
            r11 = r4
            r17 = 8
            java.lang.String r0 = f31174a     // Catch:{ IllegalArgumentException -> 0x0092 }
            java.lang.String r2 = "audio record type: system normal"
            com.tencent.liteav.basic.log.TXCLog.i(r0, r2)     // Catch:{ IllegalArgumentException -> 0x0092 }
            android.media.AudioRecord r0 = new android.media.AudioRecord     // Catch:{ IllegalArgumentException -> 0x0092 }
            r3 = 1
            int r7 = r11 * 2
            r2 = r0
            r4 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x0092 }
            r1.h = r0     // Catch:{ IllegalArgumentException -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r0 = move-exception
        L_0x0093:
            r0.printStackTrace()
        L_0x0096:
            android.media.AudioRecord r0 = r1.h
            r2 = -1
            if (r0 == 0) goto L_0x010a
            int r0 = r0.getState()
            if (r0 == r13) goto L_0x00a2
            goto L_0x010a
        L_0x00a2:
            int r0 = r9 * 1024
            int r0 = r0 * r10
            int r0 = r0 / 8
            if (r0 <= r11) goto L_0x00af
            byte[] r0 = new byte[r11]
            r1.i = r0
            goto L_0x00b3
        L_0x00af:
            byte[] r0 = new byte[r0]
            r1.i = r0
        L_0x00b3:
            java.lang.String r0 = f31174a
            r3 = 6
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r3[r12] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            r3[r13] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r3[r14] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r3[r15] = r4
            byte[] r4 = r1.i
            int r4 = r4.length
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 4
            r3[r5] = r4
            r4 = 5
            android.media.AudioRecord r5 = r1.h
            int r5 = r5.getState()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            java.lang.String r4 = "audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            com.tencent.liteav.basic.log.TXCLog.i(r0, r3)
            android.media.AudioRecord r0 = r1.h
            if (r0 == 0) goto L_0x0109
            r0.startRecording()     // Catch:{ Exception -> 0x00f8 }
            goto L_0x0109
        L_0x00f8:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
            java.lang.String r0 = f31174a
            java.lang.String r3 = "mic startRecording failed."
            com.tencent.liteav.basic.log.TXCLog.e(r0, r3)
            java.lang.String r0 = "start recording failed!"
            r1.a(r2, r0)
        L_0x0109:
            return
        L_0x010a:
            java.lang.String r0 = f31174a
            java.lang.String r3 = "audio record: initialize the mic failed."
            com.tencent.liteav.basic.log.TXCLog.e(r0, r3)
            r18.e()
            java.lang.String r0 = "没有麦克风权限!"
            r1.a(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.Record.f.d():void");
    }

    private void e() {
        if (this.h != null) {
            TXCLog.i(f31174a, "stop mic");
            try {
                this.h.setRecordPositionUpdateListener((AudioRecord.OnRecordPositionUpdateListener) null);
                this.h.stop();
                this.h.release();
                ((AudioManager) this.f31176c.getSystemService("audio")).setMode(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.h = null;
        this.i = null;
    }

    private void a(byte[] bArr, int i2, long j2) {
        h hVar;
        synchronized (this) {
            hVar = this.j != null ? (h) this.j.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordPCM(bArr, i2, j2);
        } else {
            TXCLog.e(f31174a, "onRecordPcmData:no callback");
        }
    }

    private void a(int i2, String str) {
        h hVar;
        synchronized (this) {
            hVar = this.j != null ? (h) this.j.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordError(i2, str);
        } else {
            TXCLog.e(f31174a, "onRecordError:no callback");
        }
    }

    private void f() {
        h hVar;
        synchronized (this) {
            hVar = this.j != null ? (h) this.j.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordStart();
        } else {
            TXCLog.e(f31174a, "onRecordStart:no callback");
        }
    }

    private void g() {
        h hVar;
        synchronized (this) {
            hVar = this.j != null ? (h) this.j.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordStop();
        } else {
            TXCLog.e(f31174a, "onRecordStop:no callback");
        }
    }

    public void run() {
        int i2;
        if (!this.l) {
            TXCLog.w(f31174a, "audio record: abandom start audio sys record thread!");
            return;
        }
        f();
        d();
        loop0:
        while (true) {
            i2 = 0;
            int i3 = 0;
            while (this.l && !Thread.interrupted() && this.h != null && i2 <= 5) {
                System.currentTimeMillis();
                AudioRecord audioRecord = this.h;
                byte[] bArr = this.i;
                int read = audioRecord.read(bArr, i3, bArr.length - i3);
                byte[] bArr2 = this.i;
                if (read == bArr2.length - i3) {
                    a(bArr2, bArr2.length, TXCTimeUtil.getTimeTick());
                } else if (read <= 0) {
                    String str = f31174a;
                    TXCLog.e(str, "read pcm eror, len =" + read);
                    i2++;
                } else {
                    i3 += read;
                }
            }
        }
        e();
        if (i2 > 5) {
            a(-1, "read data failed!");
        } else {
            g();
        }
    }
}
