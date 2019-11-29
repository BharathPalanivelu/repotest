package com.shopee.app.ui.image.editor.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.a.r;
import com.squareup.a.w;
import java.io.IOException;

public class b extends com.garena.imageeditor.c.b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22915a;

    public b(Context context, int i, int i2) {
        super(i, i2);
        this.f22915a = context;
    }

    public Bitmap a(Uri uri) {
        try {
            return w.a(this.f22915a).a(uri).b(b(), c()).a(r.NO_CACHE, r.NO_STORE).e().f().h();
        } catch (IOException unused) {
            return null;
        }
    }
}
