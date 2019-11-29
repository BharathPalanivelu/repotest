package com.tencent.liteav.muxer;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private int f31674a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f31675b;

    public c(Context context, int i) {
        if (i == 0) {
            this.f31674a = 0;
            this.f31675b = new d();
            TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
        } else if (i == 1) {
            this.f31674a = 1;
            this.f31675b = new b();
            TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
        } else if (a(context)) {
            this.f31674a = 0;
            this.f31675b = new d();
            TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
        } else {
            this.f31674a = 1;
            this.f31675b = new b();
            TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
        }
    }

    public static boolean a(Context context) {
        b.a().a(context);
        return b.a().e() == 1;
    }

    public void a(MediaFormat mediaFormat) {
        this.f31675b.a(mediaFormat);
    }

    public void b(MediaFormat mediaFormat) {
        this.f31675b.b(mediaFormat);
    }

    public void a(String str) {
        this.f31675b.a(str);
    }

    public void a(byte[] bArr, int i, int i2, long j, int i3) {
        this.f31675b.a(bArr, i, i2, j, i3);
    }

    public void b(byte[] bArr, int i, int i2, long j, int i3) {
        this.f31675b.b(bArr, i, i2, j, i3);
    }

    public int a() {
        return this.f31675b.a();
    }

    public int b() {
        return this.f31675b.b();
    }

    public boolean c() {
        return this.f31675b.c();
    }
}
