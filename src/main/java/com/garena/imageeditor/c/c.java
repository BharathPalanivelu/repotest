package com.garena.imageeditor.c;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

public class c extends AsyncTask<Uri, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final b f8112a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<a> f8113b;

    public c(b bVar, a aVar) {
        this.f8112a = bVar;
        this.f8113b = new WeakReference<>(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap doInBackground(Uri... uriArr) {
        if (isCancelled() || this.f8112a.a()) {
            return null;
        }
        try {
            return this.f8112a.a(uriArr[0]);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        if (!this.f8112a.a()) {
            a aVar = (a) this.f8113b.get();
            if (aVar == null) {
                return;
            }
            if (bitmap == null) {
                aVar.c();
            } else {
                aVar.a(bitmap);
            }
        }
    }
}
