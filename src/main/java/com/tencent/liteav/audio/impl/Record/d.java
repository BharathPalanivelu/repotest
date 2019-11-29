package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;

public class d extends b implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private boolean f31163d = false;

    /* renamed from: e  reason: collision with root package name */
    private Thread f31164e = null;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f31165f = new byte[20480];

    /* renamed from: g  reason: collision with root package name */
    private int f31166g = 0;
    private int h = 0;
    private long i = 0;

    public void a(Context context, int i2, int i3, int i4) {
        super.a(context, i2, i3, i4);
        c();
        this.f31163d = true;
        this.f31164e = new Thread(this, "AudioCustomRecord Thread");
        this.f31164e.start();
    }

    public void c() {
        this.f31163d = false;
        long currentTimeMillis = System.currentTimeMillis();
        Thread thread = this.f31164e;
        if (!(thread == null || !thread.isAlive() || Thread.currentThread().getId() == this.f31164e.getId())) {
            try {
                this.f31164e.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                TXCLog.e("AudioCenter:TXCAudioCustomRecord", "custom record stop Exception: " + e2.getMessage());
            }
        }
        TXCLog.i("AudioCenter:TXCAudioCustomRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.f31164e = null;
    }

    public boolean d() {
        return this.f31163d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(byte[] r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = com.tencent.liteav.basic.util.TXCTimeUtil.getTimeTick()     // Catch:{ all -> 0x006d }
            r4.i = r0     // Catch:{ all -> 0x006d }
            if (r5 == 0) goto L_0x0044
            int r0 = r4.f()     // Catch:{ all -> 0x006d }
            int r1 = r5.length     // Catch:{ all -> 0x006d }
            if (r0 >= r1) goto L_0x0011
            goto L_0x0044
        L_0x0011:
            int r0 = r4.f31166g     // Catch:{ all -> 0x006d }
            int r1 = r5.length     // Catch:{ all -> 0x006d }
            int r0 = r0 + r1
            byte[] r1 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r1 = r1.length     // Catch:{ all -> 0x006d }
            r2 = 0
            if (r0 > r1) goto L_0x002a
            byte[] r0 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r1 = r4.f31166g     // Catch:{ all -> 0x006d }
            int r3 = r5.length     // Catch:{ all -> 0x006d }
            java.lang.System.arraycopy(r5, r2, r0, r1, r3)     // Catch:{ all -> 0x006d }
            int r0 = r4.f31166g     // Catch:{ all -> 0x006d }
            int r5 = r5.length     // Catch:{ all -> 0x006d }
            int r0 = r0 + r5
            r4.f31166g = r0     // Catch:{ all -> 0x006d }
            goto L_0x0042
        L_0x002a:
            byte[] r0 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r0 = r0.length     // Catch:{ all -> 0x006d }
            int r1 = r4.f31166g     // Catch:{ all -> 0x006d }
            int r0 = r0 - r1
            byte[] r1 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r3 = r4.f31166g     // Catch:{ all -> 0x006d }
            java.lang.System.arraycopy(r5, r2, r1, r3, r0)     // Catch:{ all -> 0x006d }
            int r1 = r5.length     // Catch:{ all -> 0x006d }
            int r1 = r1 - r0
            r4.f31166g = r1     // Catch:{ all -> 0x006d }
            byte[] r1 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r3 = r4.f31166g     // Catch:{ all -> 0x006d }
            java.lang.System.arraycopy(r5, r0, r1, r2, r3)     // Catch:{ all -> 0x006d }
        L_0x0042:
            monitor-exit(r4)
            return
        L_0x0044:
            java.lang.String r0 = "AudioCenter:TXCAudioCustomRecord"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "缓冲区不够. 自定义数据长度 = "
            r1.append(r2)     // Catch:{ all -> 0x006d }
            if (r5 != 0) goto L_0x0054
            r5 = -1
            goto L_0x0055
        L_0x0054:
            int r5 = r5.length     // Catch:{ all -> 0x006d }
        L_0x0055:
            r1.append(r5)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = ", 剩余缓冲区长度 = "
            r1.append(r5)     // Catch:{ all -> 0x006d }
            int r5 = r4.f()     // Catch:{ all -> 0x006d }
            r1.append(r5)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x006d }
            com.tencent.liteav.basic.log.TXCLog.e(r0, r5)     // Catch:{ all -> 0x006d }
            monitor-exit(r4)
            return
        L_0x006d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.Record.d.a(byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.tencent.liteav.basic.structs.a r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r5.f31401e     // Catch:{ all -> 0x006d }
            r4.i = r0     // Catch:{ all -> 0x006d }
            byte[] r5 = r5.f31402f     // Catch:{ all -> 0x006d }
            if (r5 == 0) goto L_0x0044
            int r0 = r4.f()     // Catch:{ all -> 0x006d }
            int r1 = r5.length     // Catch:{ all -> 0x006d }
            if (r0 >= r1) goto L_0x0011
            goto L_0x0044
        L_0x0011:
            int r0 = r4.f31166g     // Catch:{ all -> 0x006d }
            int r1 = r5.length     // Catch:{ all -> 0x006d }
            int r0 = r0 + r1
            byte[] r1 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r1 = r1.length     // Catch:{ all -> 0x006d }
            r2 = 0
            if (r0 > r1) goto L_0x002a
            byte[] r0 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r1 = r4.f31166g     // Catch:{ all -> 0x006d }
            int r3 = r5.length     // Catch:{ all -> 0x006d }
            java.lang.System.arraycopy(r5, r2, r0, r1, r3)     // Catch:{ all -> 0x006d }
            int r0 = r4.f31166g     // Catch:{ all -> 0x006d }
            int r5 = r5.length     // Catch:{ all -> 0x006d }
            int r0 = r0 + r5
            r4.f31166g = r0     // Catch:{ all -> 0x006d }
            goto L_0x0042
        L_0x002a:
            byte[] r0 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r0 = r0.length     // Catch:{ all -> 0x006d }
            int r1 = r4.f31166g     // Catch:{ all -> 0x006d }
            int r0 = r0 - r1
            byte[] r1 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r3 = r4.f31166g     // Catch:{ all -> 0x006d }
            java.lang.System.arraycopy(r5, r2, r1, r3, r0)     // Catch:{ all -> 0x006d }
            int r1 = r5.length     // Catch:{ all -> 0x006d }
            int r1 = r1 - r0
            r4.f31166g = r1     // Catch:{ all -> 0x006d }
            byte[] r1 = r4.f31165f     // Catch:{ all -> 0x006d }
            int r3 = r4.f31166g     // Catch:{ all -> 0x006d }
            java.lang.System.arraycopy(r5, r0, r1, r2, r3)     // Catch:{ all -> 0x006d }
        L_0x0042:
            monitor-exit(r4)
            return
        L_0x0044:
            java.lang.String r0 = "AudioCenter:TXCAudioCustomRecord"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "缓冲区不够. 自定义数据长度 = "
            r1.append(r2)     // Catch:{ all -> 0x006d }
            if (r5 != 0) goto L_0x0054
            r5 = -1
            goto L_0x0055
        L_0x0054:
            int r5 = r5.length     // Catch:{ all -> 0x006d }
        L_0x0055:
            r1.append(r5)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = ", 剩余缓冲区长度 = "
            r1.append(r5)     // Catch:{ all -> 0x006d }
            int r5 = r4.f()     // Catch:{ all -> 0x006d }
            r1.append(r5)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x006d }
            com.tencent.liteav.basic.log.TXCLog.e(r0, r5)     // Catch:{ all -> 0x006d }
            monitor-exit(r4)
            return
        L_0x006d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.Record.d.a(com.tencent.liteav.basic.structs.a):void");
    }

    private int e() {
        int i2 = this.f31166g;
        byte[] bArr = this.f31165f;
        return ((i2 + bArr.length) - this.h) % bArr.length;
    }

    private int f() {
        return this.f31165f.length - e();
    }

    public void run() {
        if (!this.f31163d) {
            TXCLog.w("AudioCenter:TXCAudioCustomRecord", "audio custom record: abandom start audio sys record thread!");
            return;
        }
        a();
        int i2 = ((this.f31160b * 1024) * this.f31161c) / 8;
        byte[] bArr = new byte[i2];
        while (this.f31163d && !Thread.interrupted()) {
            if (i2 <= e()) {
                synchronized (this) {
                    if (this.h + i2 <= this.f31165f.length) {
                        System.arraycopy(this.f31165f, this.h, bArr, 0, i2);
                        this.h += i2;
                    } else {
                        int length = this.f31165f.length - this.h;
                        System.arraycopy(this.f31165f, this.h, bArr, 0, length);
                        this.h = i2 - length;
                        System.arraycopy(this.f31165f, 0, bArr, length, this.h);
                    }
                }
                a(bArr, bArr.length, this.i);
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        b();
    }
}
