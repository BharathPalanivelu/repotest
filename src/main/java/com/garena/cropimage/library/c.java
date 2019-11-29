package com.garena.cropimage.library;

import android.graphics.Bitmap;
import com.garena.cropimage.library.CropImageView;
import com.squareup.a.aa;
import com.squareup.a.r;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class c implements CropImageView.a {

    /* renamed from: a  reason: collision with root package name */
    private final aa f7902a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7903b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7904c;

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f7905d = new AtomicBoolean();

    public c(aa aaVar, int i, int i2) {
        this.f7902a = aaVar;
        this.f7903b = i;
        this.f7904c = i2;
    }

    public boolean a() {
        return this.f7905d.get();
    }

    public Bitmap b() {
        try {
            return this.f7902a.b(this.f7903b, this.f7904c).f().e().a(r.NO_CACHE, r.NO_STORE).h();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Bitmap a(int i, int i2) {
        try {
            return this.f7902a.b(i, i2).h();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
