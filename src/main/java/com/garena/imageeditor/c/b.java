package com.garena.imageeditor.c;

import android.graphics.Bitmap;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f8109a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8110b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f8111c = new AtomicBoolean();

    public abstract Bitmap a(Uri uri);

    public b(int i, int i2) {
        this.f8109a = i;
        this.f8110b = i2;
    }

    public boolean a() {
        return this.f8111c.get();
    }

    public int b() {
        return this.f8109a;
    }

    public int c() {
        return this.f8110b;
    }
}
