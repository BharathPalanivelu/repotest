package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected int f31159a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected int f31160b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int f31161c = 0;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<h> f31162d = null;

    public void a(Context context, int i, int i2, int i3) {
        this.f31159a = i;
        this.f31160b = i2;
        this.f31161c = i3;
    }

    public synchronized void a(h hVar) {
        if (hVar == null) {
            this.f31162d = null;
        } else {
            this.f31162d = new WeakReference<>(hVar);
        }
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, int i, long j) {
        h hVar;
        synchronized (this) {
            hVar = this.f31162d != null ? (h) this.f31162d.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordPCM(bArr, i, j);
        } else {
            TXCLog.e("AudioCenter:TXCAudioBaseRecord", "onRecordPcmData:no callback");
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        h hVar;
        synchronized (this) {
            hVar = this.f31162d != null ? (h) this.f31162d.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordStart();
        } else {
            TXCLog.e("AudioCenter:TXCAudioBaseRecord", "onRecordStart:no callback");
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        h hVar;
        synchronized (this) {
            hVar = this.f31162d != null ? (h) this.f31162d.get() : null;
        }
        if (hVar != null) {
            hVar.onAudioRecordStop();
        } else {
            TXCLog.e("AudioCenter:TXCAudioBaseRecord", "onRecordStop:no callback");
        }
    }
}
