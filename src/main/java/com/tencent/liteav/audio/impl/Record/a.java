package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<h> f31152a;

    /* renamed from: b  reason: collision with root package name */
    private Context f31153b;

    /* renamed from: c  reason: collision with root package name */
    private int f31154c;

    /* renamed from: d  reason: collision with root package name */
    private int f31155d;

    /* renamed from: e  reason: collision with root package name */
    private int f31156e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31157f;

    /* renamed from: g  reason: collision with root package name */
    private Thread f31158g;
    private byte[] h;

    public synchronized void a(h hVar) {
        if (hVar == null) {
            this.f31152a = null;
        } else {
            this.f31152a = new WeakReference<>(hVar);
        }
    }

    public void a(Context context, int i, int i2, int i3) {
        a();
        this.f31153b = context;
        this.f31154c = i;
        this.f31155d = i2;
        this.f31156e = i3;
        this.f31157f = true;
        this.f31158g = new Thread(this, "AudioSysRecord Thread");
        this.f31158g.start();
    }

    public void a() {
        this.f31157f = false;
        long currentTimeMillis = System.currentTimeMillis();
        Thread thread = this.f31158g;
        if (!(thread == null || !thread.isAlive() || Thread.currentThread().getId() == this.f31158g.getId())) {
            try {
                this.f31158g.join();
            } catch (Exception e2) {
                e2.printStackTrace();
                TXCLog.e("AudioCenter:TXCAudioBGMRecord", "record stop Exception: " + e2.getMessage());
            }
        }
        TXCLog.i("AudioCenter:TXCAudioBGMRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.f31158g = null;
    }

    public boolean b() {
        return this.f31157f;
    }

    private void a(byte[] bArr, int i, long j) {
        h hVar;
        synchronized (this) {
            hVar = this.f31152a != null ? (h) this.f31152a.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordPCM(bArr, i, j);
        } else {
            TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
        }
    }

    private void c() {
        h hVar;
        synchronized (this) {
            hVar = this.f31152a != null ? (h) this.f31152a.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordStart();
        } else {
            TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
        }
    }

    private void d() {
        h hVar;
        synchronized (this) {
            hVar = this.f31152a != null ? (h) this.f31152a.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordStop();
        } else {
            TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
        }
    }

    public void run() {
        if (!this.f31157f) {
            TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
            return;
        }
        c();
        int i = this.f31154c;
        int i2 = this.f31155d;
        int i3 = this.f31156e;
        int i4 = ((i2 * 1024) * i3) / 8;
        this.h = new byte[i4];
        Arrays.fill(this.h, (byte) 0);
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (this.f31157f && !Thread.interrupted()) {
            if (((((((System.currentTimeMillis() - currentTimeMillis) * ((long) i)) * ((long) i2)) * ((long) i3)) / 8) / 1000) - j < ((long) i4)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else {
                byte[] bArr = this.h;
                j += (long) bArr.length;
                a(bArr, bArr.length, TXCTimeUtil.getTimeTick());
            }
        }
        d();
    }
}
