package com.shopee.scanner;

import android.content.Context;
import android.hardware.Camera;
import com.shopee.scanner.e;
import com.yanzhenjie.zbar.Image;
import com.yanzhenjie.zbar.ImageScanner;
import com.yanzhenjie.zbar.Symbol;
import com.yanzhenjie.zbar.SymbolSet;
import g.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class f extends e implements Camera.PreviewCallback {

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f30329b = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ImageScanner f30330c = new ImageScanner();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f30331d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Image f30332e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f30333f = new Runnable() {
        public void run() {
            if (f.this.f30330c.scanImage(f.this.f30332e) != 0) {
                SymbolSet results = f.this.f30330c.getResults();
                ArrayList arrayList = new ArrayList();
                Iterator<Symbol> it = results.iterator();
                while (it.hasNext()) {
                    arrayList.add(a.a(it.next()));
                }
                if (!arrayList.isEmpty()) {
                    f.this.a((List<a>) arrayList);
                }
            }
            f.this.f30326a.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = f.this.f30331d = true;
                }
            }, 200);
        }
    };

    static {
        System.loadLibrary("iconv");
        System.loadLibrary("zbar");
    }

    f(e.a aVar) {
        super(aVar);
        this.f30330c.setConfig(0, 256, 3);
        this.f30330c.setConfig(0, 257, 3);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        this.f30331d = true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f30331d = false;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (a(bArr, camera) && this.f30331d) {
            this.f30331d = false;
            try {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                a.a("AirPay-Scanner").b("Analysing frame [%d x %d]", Integer.valueOf(previewSize.width), Integer.valueOf(previewSize.height));
                this.f30332e = new Image(previewSize.width, previewSize.height, "Y800");
                this.f30332e.setData(bArr);
                this.f30329b.execute(this.f30333f);
            } catch (RuntimeException e2) {
                a.a((Throwable) e2);
                this.f30331d = true;
            }
        }
    }

    private boolean a(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        return ((long) bArr.length) >= ((long) (previewSize.width * previewSize.height));
    }
}
