package com.garena.imageeditor.c;

import android.graphics.Bitmap;
import android.net.Uri;
import com.garena.cropimage.library.CropImageView;

public class d implements CropImageView.a {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f8114a;

    /* renamed from: b  reason: collision with root package name */
    private final b f8115b;

    public Bitmap a(int i, int i2) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public d(Uri uri, b bVar) {
        this.f8114a = uri;
        this.f8115b = bVar;
    }

    public Bitmap b() {
        return this.f8115b.a(this.f8114a);
    }
}
