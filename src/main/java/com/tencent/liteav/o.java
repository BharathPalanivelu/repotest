package com.tencent.liteav;

import android.content.Context;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;

public abstract class o {

    /* renamed from: b  reason: collision with root package name */
    protected g f31850b = null;

    /* renamed from: c  reason: collision with root package name */
    protected Context f31851c = null;

    /* renamed from: d  reason: collision with root package name */
    protected TXCloudVideoView f31852d = null;

    /* renamed from: e  reason: collision with root package name */
    protected WeakReference<a> f31853e;

    public int a(String str) {
        return -1;
    }

    public abstract int a(String str, int i);

    public abstract int a(boolean z);

    public abstract void a(int i);

    public void a(int i, int i2) {
    }

    public void a(Context context, int i) {
    }

    public void a(Surface surface) {
    }

    public void a(p pVar) {
    }

    public void a(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
    }

    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
    }

    public abstract void b(int i);

    public abstract void b(boolean z);

    public abstract int c(int i);

    public abstract boolean c();

    public TextureView d() {
        return null;
    }

    public abstract int e();

    public boolean f() {
        return false;
    }

    public void g() {
    }

    public o(Context context) {
        if (context != null) {
            this.f31851c = context.getApplicationContext();
        }
    }

    public g p() {
        return this.f31850b;
    }

    public void a(g gVar) {
        this.f31850b = gVar;
        if (this.f31850b == null) {
            this.f31850b = new g();
        }
    }

    public void a() {
        TXCLog.w("TXIPlayer", "pause not support");
    }

    public void b() {
        TXCLog.w("TXIPlayer", "resume not support");
    }

    public void d(int i) {
        TXCLog.w("TXIPlayer", "seek not support");
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        this.f31852d = tXCloudVideoView;
    }

    public void a(a aVar) {
        this.f31853e = new WeakReference<>(aVar);
    }

    public void c(boolean z) {
        TXCLog.w("TXIPlayer", "autoPlay not implement");
    }

    public void b(float f2) {
        TXCLog.w("TXIPlayer", "rate not implement");
    }
}
