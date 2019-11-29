package com.google.zxing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.zxing.b.c;
import java.util.Collection;
import java.util.Map;

public final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14703a = "f";

    /* renamed from: b  reason: collision with root package name */
    private final BBQRScannerControl f14704b;

    /* renamed from: c  reason: collision with root package name */
    private final k f14705c;

    /* renamed from: d  reason: collision with root package name */
    private a f14706d = a.SUCCESS;

    /* renamed from: e  reason: collision with root package name */
    private final c f14707e;

    private enum a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public void a() {
        this.f14706d = a.SUCCESS;
    }

    public f(BBQRScannerControl bBQRScannerControl, Collection<c> collection, Map<j, ?> map, String str, c cVar) {
        this.f14704b = bBQRScannerControl;
        this.f14705c = new k(bBQRScannerControl, collection, map, str, new aa(bBQRScannerControl.getViewfinderView()));
        this.f14705c.start();
        this.f14707e = cVar;
        cVar.c();
        c();
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            Log.d(f14703a, "Got restart preview message");
            c();
        } else if (i == 1) {
            Log.d(f14703a, "Got decode succeeded message");
            this.f14706d = a.SUCCESS;
            Bundle data = message.getData();
            float f2 = 1.0f;
            Bitmap bitmap = null;
            if (data != null) {
                byte[] byteArray = data.getByteArray("barcode_bitmap");
                if (byteArray != null) {
                    bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, (BitmapFactory.Options) null).copy(Bitmap.Config.ARGB_8888, true);
                }
                f2 = data.getFloat("barcode_scaled_factor");
            }
            this.f14704b.handleDecode((w) message.obj, bitmap, f2);
        } else if (i == 2) {
            this.f14706d = a.PREVIEW;
            this.f14707e.a(this.f14705c.a(), 10);
        }
    }

    public void b() {
        this.f14706d = a.DONE;
        this.f14707e.d();
        Message.obtain(this.f14705c.a(), 12).sendToTarget();
        try {
            this.f14705c.join(500);
        } catch (InterruptedException unused) {
        }
        removeMessages(1);
        removeMessages(2);
    }

    private void c() {
        if (this.f14706d == a.SUCCESS) {
            this.f14706d = a.PREVIEW;
            this.f14707e.a(this.f14705c.a(), 10);
            this.f14704b.drawViewfinder();
        }
    }
}
