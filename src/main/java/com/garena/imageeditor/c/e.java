package com.garena.imageeditor.c;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.io.File;
import jp.co.cyberagent.android.gpuimage.b;

public class e extends AsyncTask<Bitmap, Void, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final b f8116a;

    /* renamed from: b  reason: collision with root package name */
    private final a f8117b;

    /* renamed from: c  reason: collision with root package name */
    private final File f8118c;

    public e(b bVar, File file, a aVar) {
        this.f8116a = bVar;
        this.f8117b = aVar;
        this.f8118c = file;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean doInBackground(Bitmap... bitmapArr) {
        try {
            Bitmap b2 = this.f8116a.b(bitmapArr[0]);
            if (b2 != null && com.garena.cropimage.library.b.a(b2, this.f8118c, 100)) {
                b2.recycle();
                return true;
            }
        } catch (OutOfMemoryError unused) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        if (this.f8117b == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f8117b.a((Bitmap) null);
        } else {
            this.f8117b.c();
        }
    }
}
