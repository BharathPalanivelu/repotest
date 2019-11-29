package com.garena.android.uikit.image.b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;

public class a extends AsyncTask<Uri, Void, Bitmap> implements d {

    /* renamed from: a  reason: collision with root package name */
    protected c f7738a;

    /* renamed from: b  reason: collision with root package name */
    protected b f7739b;

    public a(b bVar, c cVar) {
        this.f7739b = bVar;
        this.f7738a = cVar;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        this.f7739b.a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap doInBackground(Uri... uriArr) {
        return this.f7738a.a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        this.f7739b.a(bitmap);
        this.f7739b.b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onCancelled(Bitmap bitmap) {
        this.f7739b.c();
        this.f7739b.b();
    }

    public void a() {
        super.execute(new Uri[0]);
    }

    public void b() {
        cancel(true);
    }
}
